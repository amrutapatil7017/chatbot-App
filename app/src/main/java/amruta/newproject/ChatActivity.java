package amruta.newproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.ColorDrawable;
import android.provider.OpenableColumns;
import android.database.Cursor;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;
import androidx.activity.OnBackPressedCallback;
import android.text.TextUtils;
import android.speech.RecognizerIntent;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> messageList;
    private EditText messageEditText;
    private LinearLayout appBarLayout;
    private LinearLayout inputBarLayout;
    private ChatbotDatasetHelper datasetHelper;
    private String currentChatId = null;

    // Navigation Drawer & Recents
    private DrawerLayout drawerLayout;
    private LinearLayout recentsContainer;
    private TextView seeAllButton;
    private boolean isRecentsExpanded = false;

    // Offline Image attachment & OCR fields
    private Uri attachedImageUri;
    private Uri pendingCameraUri;
    private LinearLayout imagePreviewLayout;
    private ImageView previewImageView;
    private TextView prevTitleView;
    private TextView prevSubtitleView;
    private ImageView attachButton;
    private PopupWindow attachmentPopupWindow;
    private boolean isThinkHarderEnabled = false;
    private OfflineOCRProcessor ocrProcessor;

    private ActivityResultLauncher<String> galleryLauncher;
    private ActivityResultLauncher<Uri> cameraLauncher;
    private ActivityResultLauncher<String> cameraPermissionLauncher;
    private ActivityResultLauncher<String> fileLauncher;
    private ActivityResultLauncher<Intent> speechLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Local Deep Dataset Helper
        datasetHelper = new ChatbotDatasetHelper(this);

        // Initialize Offline OCR Processor
        ocrProcessor = new OfflineOCRProcessor();

        // Register Activity Result Launchers
        initActivityLaunchers();

        // Root Container
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setBackgroundColor(Color.parseColor("#F8FAFC"));

        // 1. Top App Bar Header
        appBarLayout = new LinearLayout(this);
        appBarLayout.setOrientation(LinearLayout.HORIZONTAL);
        appBarLayout.setGravity(Gravity.CENTER_VERTICAL);
        appBarLayout.setBackgroundColor(Color.WHITE);
        int pHoriz = UIUtils.dpToPx(this, 16);
        int pVert = UIUtils.dpToPx(this, 12);
        appBarLayout.setPadding(pHoriz, pVert, pHoriz, pVert);

        // Top-Left Hamburger Menu Button [☰]
        ImageView menuButton = new ImageView(this);
        int menuSize = UIUtils.dpToPx(this, 36);
        LinearLayout.LayoutParams menuParams = new LinearLayout.LayoutParams(menuSize, menuSize);
        menuParams.rightMargin = UIUtils.dpToPx(this, 12);
        menuButton.setLayoutParams(menuParams);
        menuButton.setImageBitmap(UIUtils.createMenuIconBitmap(this, 26, Color.parseColor("#334155")));
        menuButton.setScaleType(ImageView.ScaleType.CENTER);
        menuButton.setOnClickListener(this::showHamburgerMenu);
        appBarLayout.addView(menuButton);

        // Center Title & Bot Icon Container
        LinearLayout centerTitleLayout = new LinearLayout(this);
        centerTitleLayout.setOrientation(LinearLayout.HORIZONTAL);
        centerTitleLayout.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams centerParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        centerTitleLayout.setLayoutParams(centerParams);

        // Bot Logo View (icon-only in header)
        BotLogoView headerLogo = new BotLogoView(this);
        headerLogo.setShowText(false);
        int iconSize = UIUtils.dpToPx(this, 32);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(iconSize, iconSize);
        iconParams.rightMargin = UIUtils.dpToPx(this, 10);
        headerLogo.setLayoutParams(iconParams);
        centerTitleLayout.addView(headerLogo);

        // Title: Chatbot
        TextView titleText = new TextView(this);
        titleText.setText("Chatbot");
        titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        titleText.setTypeface(null, Typeface.BOLD);
        titleText.setTextColor(Color.parseColor("#0F172A"));
        centerTitleLayout.addView(titleText);

        appBarLayout.addView(centerTitleLayout);

        rootLayout.addView(appBarLayout);

        // Header Bottom Divider Line
        View appBarDivider = new View(this);
        appBarDivider.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1)));
        appBarDivider.setBackgroundColor(Color.parseColor("#E2E8F0"));
        rootLayout.addView(appBarDivider);

        // Chat RecyclerView Area
        recyclerView = new RecyclerView(this);
        LinearLayout.LayoutParams recyclerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f);
        recyclerView.setLayoutParams(recyclerParams);
        recyclerView.setBackgroundColor(Color.parseColor("#F8FAFC"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(layoutManager);

        messageList = new ArrayList<>();
        // Initial Welcome Card Message
        messageList.add(new ChatMessage("Hello! I am your AI Assistant powered by Google Gemini and a Supercharged Knowledge Engine. Ask me anything!", false, System.currentTimeMillis(), false, true));

        chatAdapter = new ChatAdapter(messageList);
        recyclerView.setAdapter(chatAdapter);
        rootLayout.addView(recyclerView);

        // Image Attachment Preview Area (Initially hidden)
        imagePreviewLayout = new LinearLayout(this);
        imagePreviewLayout.setOrientation(LinearLayout.HORIZONTAL);
        imagePreviewLayout.setGravity(Gravity.CENTER_VERTICAL);
        imagePreviewLayout.setBackgroundColor(Color.parseColor("#F1F5F9"));
        int prevPadH = UIUtils.dpToPx(this, 12);
        int prevPadV = UIUtils.dpToPx(this, 8);
        imagePreviewLayout.setPadding(prevPadH, prevPadV, prevPadH, prevPadV);
        imagePreviewLayout.setVisibility(View.GONE);

        previewImageView = new ImageView(this);
        int thumbSize = UIUtils.dpToPx(this, 44);
        LinearLayout.LayoutParams thumbParams = new LinearLayout.LayoutParams(thumbSize, thumbSize);
        thumbParams.rightMargin = UIUtils.dpToPx(this, 10);
        previewImageView.setLayoutParams(thumbParams);
        previewImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        previewImageView.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#CBD5E1"), 8, Color.TRANSPARENT, 0, this));
        previewImageView.setClipToOutline(true);
        imagePreviewLayout.addView(previewImageView);

        LinearLayout prevTextLayout = new LinearLayout(this);
        prevTextLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams prevTextParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        prevTextLayout.setLayoutParams(prevTextParams);

        prevTitleView = new TextView(this);
        prevTitleView.setText("Image Attached");
        prevTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        prevTitleView.setTypeface(null, Typeface.BOLD);
        prevTitleView.setTextColor(Color.parseColor("#1E293B"));
        prevTextLayout.addView(prevTitleView);

        prevSubtitleView = new TextView(this);
        prevSubtitleView.setText("Ready for offline AI analysis");
        prevSubtitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        prevSubtitleView.setTextColor(Color.parseColor("#64748B"));
        prevTextLayout.addView(prevSubtitleView);

        imagePreviewLayout.addView(prevTextLayout);

        ImageView removeBtn = new ImageView(this);
        int removeSize = UIUtils.dpToPx(this, 30);
        LinearLayout.LayoutParams removeParams = new LinearLayout.LayoutParams(removeSize, removeSize);
        removeBtn.setLayoutParams(removeParams);
        removeBtn.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#E2E8F0"), 15, Color.TRANSPARENT, 0, this));
        removeBtn.setImageBitmap(UIUtils.createCloseIconBitmap(this, 16, Color.parseColor("#475569")));
        removeBtn.setScaleType(ImageView.ScaleType.CENTER);
        removeBtn.setOnClickListener(v -> clearAttachedImage());
        imagePreviewLayout.addView(removeBtn);

        rootLayout.addView(imagePreviewLayout);

        // Input Bar Divider Line
        View inputDivider = new View(this);
        inputDivider.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1)));
        inputDivider.setBackgroundColor(Color.parseColor("#E2E8F0"));
        rootLayout.addView(inputDivider);

        // Bottom Message Input Area
        inputBarLayout = new LinearLayout(this);
        inputBarLayout.setOrientation(LinearLayout.HORIZONTAL);
        inputBarLayout.setGravity(Gravity.CENTER_VERTICAL);
        inputBarLayout.setBackgroundColor(Color.WHITE);
        inputBarLayout.setPadding(pHoriz, pVert, pHoriz, pVert);

        // Attachment Options Button (+)
        attachButton = new ImageView(this);
        int attachSize = UIUtils.dpToPx(this, 44);
        LinearLayout.LayoutParams attachParams = new LinearLayout.LayoutParams(attachSize, attachSize);
        attachParams.rightMargin = UIUtils.dpToPx(this, 8);
        attachButton.setLayoutParams(attachParams);
        attachButton.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#F1F5F9"), Color.parseColor("#E2E8F0"), 22, this));
        attachButton.setImageBitmap(UIUtils.createPlusIconBitmap(this, 22, Color.parseColor("#475569")));
        attachButton.setScaleType(ImageView.ScaleType.CENTER);
        attachButton.setOnClickListener(v -> showAttachmentMenu());

        // Input Box Container (holds EditText + Microphone Icon inside on the right)
        LinearLayout inputBoxContainer = new LinearLayout(this);
        inputBoxContainer.setOrientation(LinearLayout.HORIZONTAL);
        inputBoxContainer.setGravity(Gravity.CENTER_VERTICAL);
        inputBoxContainer.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 22, Color.parseColor("#CBD5E1"), 1, this));

        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        inputBoxContainer.setLayoutParams(containerParams);

        messageEditText = new EditText(this);
        messageEditText.setHint("Type your message...");
        messageEditText.setHintTextColor(Color.parseColor("#94A3B8"));
        messageEditText.setTextColor(Color.parseColor("#0F172A"));
        messageEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        messageEditText.setMaxLines(4);
        int inputPaddingLeft = UIUtils.dpToPx(this, 16);
        int inputPaddingRight = UIUtils.dpToPx(this, 6);
        int inputPaddingVert = UIUtils.dpToPx(this, 10);
        messageEditText.setPadding(inputPaddingLeft, inputPaddingVert, inputPaddingRight, inputPaddingVert);
        messageEditText.setBackground(null);
        messageEditText.setImeOptions(EditorInfo.IME_ACTION_SEND);

        LinearLayout.LayoutParams editParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        messageEditText.setLayoutParams(editParams);

        // Microphone Icon inside input box on the right
        ImageView micButton = new ImageView(this);
        int micSize = UIUtils.dpToPx(this, 36);
        LinearLayout.LayoutParams micParams = new LinearLayout.LayoutParams(micSize, micSize);
        micParams.rightMargin = UIUtils.dpToPx(this, 6);
        micButton.setLayoutParams(micParams);
        micButton.setImageBitmap(UIUtils.createMicIconBitmap(this, 20, Color.parseColor("#475569")));
        micButton.setScaleType(ImageView.ScaleType.CENTER);
        micButton.setOnClickListener(v -> launchVoiceInput());

        inputBoxContainer.addView(messageEditText);
        inputBoxContainer.addView(micButton);

        // Keyboard Send action
        messageEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                sendMessage();
                return true;
            }
            return false;
        });

        // Circular Send Button
        ImageView sendButton = new ImageView(this);
        int sendSize = UIUtils.dpToPx(this, 44);
        LinearLayout.LayoutParams sendParams = new LinearLayout.LayoutParams(sendSize, sendSize);
        sendParams.leftMargin = UIUtils.dpToPx(this, 8);
        sendButton.setLayoutParams(sendParams);
        sendButton.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#1E1E1E"), Color.parseColor("#06B6D4"), 22, this));
        sendButton.setImageBitmap(UIUtils.createSendIconBitmap(this, 22, Color.parseColor("#22D3EE")));
        sendButton.setScaleType(ImageView.ScaleType.CENTER);
        sendButton.setOnClickListener(v -> sendMessage());

        inputBarLayout.addView(attachButton);
        inputBarLayout.addView(inputBoxContainer);
        inputBarLayout.addView(sendButton);

        rootLayout.addView(inputBarLayout);

        // DrawerLayout wrapping rootLayout and the Left Navigation Drawer
        drawerLayout = new DrawerLayout(this);
        drawerLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        rootLayout.setLayoutParams(new DrawerLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        drawerLayout.addView(rootLayout);

        View navDrawerView = createNavigationDrawerView();
        int drawerWidth = Math.min(UIUtils.dpToPx(this, 305), (int) (getResources().getDisplayMetrics().widthPixels * 0.85f));
        DrawerLayout.LayoutParams drawerParams = new DrawerLayout.LayoutParams(
                drawerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        drawerParams.gravity = GravityCompat.START;
        navDrawerView.setLayoutParams(drawerParams);
        drawerLayout.addView(navDrawerView);

        setContentView(drawerLayout);

        // Handle Back button to close drawer when open
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });

        // Initialize status badge
        updateStatusHeader();

        // Window Insets Handling for Keyboard & Status Bar
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());

            appBarLayout.setPadding(
                    pHoriz,
                    systemBars.top + pVert,
                    pHoriz,
                    pVert
            );

            int bottomInset = Math.max(systemBars.bottom, ime.bottom);
            inputBarLayout.setPadding(
                    pHoriz,
                    pVert,
                    pHoriz,
                    bottomInset + pVert
            );

            return WindowInsetsCompat.CONSUMED;
        });
    }

    private void updateStatusHeader() {
        // Status badge removed from header per UI design requirements
    }

    private void initActivityLaunchers() {
        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
            if (uri != null) {
                setAttachedImage(uri);
            }
        });

        cameraLauncher = registerForActivityResult(new ActivityResultContracts.TakePicture(), success -> {
            if (Boolean.TRUE.equals(success) && pendingCameraUri != null) {
                setAttachedImage(pendingCameraUri);
            }
        });

        cameraPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (Boolean.TRUE.equals(isGranted)) {
                launchCamera();
            } else {
                Toast.makeText(this, "Camera permission is required to capture photos", Toast.LENGTH_SHORT).show();
            }
        });

        fileLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
            if (uri != null) {
                handleFileSelection(uri);
            }
        });

        speechLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        ArrayList<String> matches = result.getData().getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        if (matches != null && !matches.isEmpty()) {
                            String spokenText = matches.get(0);
                            if (messageEditText != null) {
                                String currentText = messageEditText.getText().toString();
                                if (!currentText.isEmpty() && !currentText.endsWith(" ")) {
                                    currentText += " ";
                                }
                                messageEditText.setText(currentText + spokenText);
                                messageEditText.setSelection(messageEditText.getText().length());
                            }
                        }
                    }
                }
        );
    }

    private void launchVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak your message...");

        try {
            speechLauncher.launch(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Voice input is not supported on this device", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAttachedImage(Uri uri) {
        this.attachedImageUri = uri;
        Bitmap thumb = ImageProcessor.getThumbnail(this, uri, 120);
        if (thumb != null) {
            previewImageView.setImageBitmap(thumb);
        }
        if (prevTitleView != null) {
            prevTitleView.setText("Image Attached");
        }
        if (prevSubtitleView != null) {
            prevSubtitleView.setText("Ready for offline AI analysis");
        }
        imagePreviewLayout.setVisibility(View.VISIBLE);
    }

    private void setAttachedNonImageFile(Uri uri, String fileName) {
        this.attachedImageUri = uri;
        if (previewImageView != null) {
            previewImageView.setImageBitmap(UIUtils.createFilesIconBitmap(this, 28, Color.parseColor("#FB923C")));
        }
        if (prevTitleView != null) {
            prevTitleView.setText(fileName);
        }
        if (prevSubtitleView != null) {
            prevSubtitleView.setText("Ready for AI analysis");
        }
        if (imagePreviewLayout != null) {
            imagePreviewLayout.setVisibility(View.VISIBLE);
        }
        Toast.makeText(this, "File attached: " + fileName, Toast.LENGTH_SHORT).show();
    }

    private void clearAttachedImage() {
        this.attachedImageUri = null;
        this.pendingCameraUri = null;
        if (previewImageView != null) {
            previewImageView.setImageDrawable(null);
        }
        if (prevTitleView != null) {
            prevTitleView.setText("Image Attached");
        }
        if (prevSubtitleView != null) {
            prevSubtitleView.setText("Ready for offline AI analysis");
        }
        if (imagePreviewLayout != null) {
            imagePreviewLayout.setVisibility(View.GONE);
        }
    }

    private void showAttachmentMenu() {
        if (attachmentPopupWindow != null && attachmentPopupWindow.isShowing()) {
            attachmentPopupWindow.dismiss();
            return;
        }

        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int popupWidth = Math.min(UIUtils.dpToPx(this, 280), screenWidth - UIUtils.dpToPx(this, 32));

        LinearLayout popupCard = new LinearLayout(this);
        popupCard.setOrientation(LinearLayout.VERTICAL);
        popupCard.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#1F222A"), 18, Color.parseColor("#333742"), 1, this));
        int pPad = UIUtils.dpToPx(this, 6);
        popupCard.setPadding(pPad, pPad, pPad, pPad);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);

        LinearLayout optionsContainer = new LinearLayout(this);
        optionsContainer.setOrientation(LinearLayout.VERTICAL);

        // 1. Camera — Take a photo
        addAttachmentOption(
                optionsContainer,
                "Camera",
                "Take a photo",
                UIUtils.createCameraIconBitmap(this, 20, Color.parseColor("#38BDF8")),
                v -> {
                    if (attachmentPopupWindow != null) attachmentPopupWindow.dismiss();
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        launchCamera();
                    } else {
                        cameraPermissionLauncher.launch(Manifest.permission.CAMERA);
                    }
                },
                false
        );

        // 2. Photos — Choose an image from gallery
        addAttachmentOption(
                optionsContainer,
                "Photos",
                "Choose an image from gallery",
                UIUtils.createGalleryIconBitmap(this, 20, Color.parseColor("#34D399")),
                v -> {
                    if (attachmentPopupWindow != null) attachmentPopupWindow.dismiss();
                    galleryLauncher.launch("image/*");
                },
                false
        );

        // 3. Files — Choose a file from device
        addAttachmentOption(
                optionsContainer,
                "Files",
                "Choose a file from device",
                UIUtils.createFilesIconBitmap(this, 20, Color.parseColor("#FB923C")),
                v -> {
                    if (attachmentPopupWindow != null) attachmentPopupWindow.dismiss();
                    fileLauncher.launch("*/*");
                },
                true
        );

        scrollView.addView(optionsContainer);
        popupCard.addView(scrollView);

        popupCard.measure(
                View.MeasureSpec.makeMeasureSpec(popupWidth, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        int popupHeight = popupCard.getMeasuredHeight();

        int[] location = new int[2];
        attachButton.getLocationInWindow(location);
        int anchorX = location[0];
        int anchorY = location[1];

        int gap = UIUtils.dpToPx(this, 8);
        int targetX = anchorX;
        if (targetX + popupWidth > screenWidth - UIUtils.dpToPx(this, 12)) {
            targetX = screenWidth - popupWidth - UIUtils.dpToPx(this, 12);
        }
        if (targetX < UIUtils.dpToPx(this, 12)) {
            targetX = UIUtils.dpToPx(this, 12);
        }

        int targetY = anchorY - popupHeight - gap;
        if (targetY < UIUtils.dpToPx(this, 48)) {
            targetY = UIUtils.dpToPx(this, 48);
        }

        attachmentPopupWindow = new PopupWindow(popupCard, popupWidth, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        attachmentPopupWindow.setOutsideTouchable(true);
        attachmentPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        attachmentPopupWindow.setElevation(UIUtils.dpToPx(this, 16));

        attachmentPopupWindow.showAtLocation(attachButton, Gravity.NO_GRAVITY, targetX, targetY);
    }

    private void addAttachmentOption(LinearLayout container, String title, String subtitle, Bitmap iconBitmap, View.OnClickListener onClickListener, boolean isLast) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int padH = UIUtils.dpToPx(this, 12);
        int padV = UIUtils.dpToPx(this, 10);
        row.setPadding(padH, padV, padH, padV);
        row.setClickable(true);
        row.setFocusable(true);
        row.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#2A2E39"), 12, this));

        // Circular dark icon container
        ImageView iconView = new ImageView(this);
        int iconContainerSize = UIUtils.dpToPx(this, 36);
        LinearLayout.LayoutParams iconContainerParams = new LinearLayout.LayoutParams(iconContainerSize, iconContainerSize);
        iconContainerParams.rightMargin = UIUtils.dpToPx(this, 12);
        iconView.setLayoutParams(iconContainerParams);
        iconView.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#282B35"), 18, Color.parseColor("#383C48"), 1, this));
        iconView.setImageBitmap(iconBitmap);
        iconView.setScaleType(ImageView.ScaleType.CENTER);
        row.addView(iconView);

        // Titles Container
        LinearLayout textLayout = new LinearLayout(this);
        textLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        textLayout.setLayoutParams(textParams);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(Color.parseColor("#F8FAFC"));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        titleView.setTypeface(null, Typeface.BOLD);
        textLayout.addView(titleView);

        TextView subView = new TextView(this);
        subView.setText(subtitle);
        subView.setTextColor(Color.parseColor("#94A3B8"));
        subView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        textLayout.addView(subView);

        row.addView(textLayout);

        // Think harder ON/OFF badge
        if ("Think harder".equals(title)) {
            TextView badge = new TextView(this);
            badge.setText(isThinkHarderEnabled ? "ON" : "OFF");
            badge.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            badge.setTypeface(null, Typeface.BOLD);
            badge.setTextColor(isThinkHarderEnabled ? Color.parseColor("#10B981") : Color.parseColor("#94A3B8"));
            int bPadH = UIUtils.dpToPx(this, 8);
            int bPadV = UIUtils.dpToPx(this, 3);
            badge.setPadding(bPadH, bPadV, bPadH, bPadV);
            badge.setBackground(UIUtils.createRoundedDrawable(
                    isThinkHarderEnabled ? Color.parseColor("#064E3B") : Color.parseColor("#27272A"),
                    8,
                    isThinkHarderEnabled ? Color.parseColor("#059669") : Color.parseColor("#3F3F46"),
                    1,
                    this));
            row.addView(badge);
        }

        row.setOnClickListener(onClickListener);
        container.addView(row);

        if (!isLast) {
            View divider = new View(this);
            LinearLayout.LayoutParams divParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1));
            divParams.leftMargin = UIUtils.dpToPx(this, 56);
            divParams.rightMargin = UIUtils.dpToPx(this, 12);
            divider.setLayoutParams(divParams);
            divider.setBackgroundColor(Color.parseColor("#2A2E39"));
            container.addView(divider);
        }
    }

    private void toggleThinkHarderMode() {
        isThinkHarderEnabled = !isThinkHarderEnabled;
        if (isThinkHarderEnabled) {
            Toast.makeText(this, "🧠 Think harder mode ENABLED\nDeep step-by-step reasoning active", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Think harder mode DISABLED", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleFileSelection(Uri uri) {
        String fileName = queryFileName(uri);
        String mimeType = getContentResolver().getType(uri);

        boolean isImage = (mimeType != null && mimeType.startsWith("image/"))
                || (fileName != null && (fileName.toLowerCase().endsWith(".png")
                || fileName.toLowerCase().endsWith(".jpg")
                || fileName.toLowerCase().endsWith(".jpeg")
                || fileName.toLowerCase().endsWith(".webp")
                || fileName.toLowerCase().endsWith(".bmp")));

        if (isImage) {
            setAttachedImage(uri);
            Toast.makeText(this, "Image attached: " + fileName, Toast.LENGTH_SHORT).show();
        } else {
            setAttachedNonImageFile(uri, fileName);
        }
    }

    private String queryFileName(Uri uri) {
        String name = null;
        try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                if (nameIndex >= 0) {
                    name = cursor.getString(nameIndex);
                }
            }
        } catch (Exception ignored) {}
        if (name == null && uri.getPath() != null) {
            name = uri.getLastPathSegment();
        }
        return name != null ? name : "Attached File";
    }

    private void showPluginsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LinearLayout dialogRoot = new LinearLayout(this);
        dialogRoot.setOrientation(LinearLayout.VERTICAL);
        dialogRoot.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#1F222A"), 20, Color.parseColor("#333742"), 1, this));
        int pPad = UIUtils.dpToPx(this, 20);
        dialogRoot.setPadding(pPad, pPad, pPad, pPad);

        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        ImageView headerIcon = new ImageView(this);
        int hIconSize = UIUtils.dpToPx(this, 36);
        LinearLayout.LayoutParams hIconParams = new LinearLayout.LayoutParams(hIconSize, hIconSize);
        hIconParams.rightMargin = UIUtils.dpToPx(this, 12);
        headerIcon.setLayoutParams(hIconParams);
        headerIcon.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#282B35"), 18, Color.parseColor("#A78BFA"), 1, this));
        headerIcon.setImageBitmap(UIUtils.createPluginsIconBitmap(this, 20, Color.parseColor("#A78BFA")));
        headerIcon.setScaleType(ImageView.ScaleType.CENTER);
        header.addView(headerIcon);

        LinearLayout titleBox = new LinearLayout(this);
        titleBox.setOrientation(LinearLayout.VERTICAL);
        TextView dTitle = new TextView(this);
        dTitle.setText("Available Plugins");
        dTitle.setTextColor(Color.parseColor("#F8FAFC"));
        dTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        dTitle.setTypeface(null, Typeface.BOLD);
        titleBox.addView(dTitle);

        TextView dSub = new TextView(this);
        dSub.setText("Active intelligence & tool modules");
        dSub.setTextColor(Color.parseColor("#94A3B8"));
        dSub.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        titleBox.addView(dSub);
        header.addView(titleBox);
        dialogRoot.addView(header);

        View div = new View(this);
        LinearLayout.LayoutParams divParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1));
        divParams.topMargin = UIUtils.dpToPx(this, 14);
        divParams.bottomMargin = UIUtils.dpToPx(this, 14);
        div.setLayoutParams(divParams);
        div.setBackgroundColor(Color.parseColor("#2A2E39"));
        dialogRoot.addView(div);

        ScrollView sv = new ScrollView(this);
        sv.setVerticalScrollBarEnabled(false);
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        addPluginCard(list, "Offline OCR Vision", "Extracts formulas, questions, diagrams & code on-device without cloud.", true);
        addPluginCard(list, "Deep ML Knowledge Engine", "Offline NLP engine covering 200+ ML/DL/AI topics and exam answers.", true);
        addPluginCard(list, "Google Gemini AI", "Cloud multimodal LLM for advanced conversation and reasoning.", ChatbotPrefs.hasGeminiApiKey(this));
        addPluginCard(list, "Code & Formula Formatter", "Renders code snippets and mathematical formulas clearly.", true);

        sv.addView(list);
        dialogRoot.addView(sv);

        Button doneBtn = new Button(this);
        doneBtn.setText("Done");
        doneBtn.setTextColor(Color.WHITE);
        doneBtn.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#2563EB"), Color.parseColor("#1D4ED8"), 12, this));
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 44));
        btnParams.topMargin = UIUtils.dpToPx(this, 16);
        doneBtn.setLayoutParams(btnParams);

        dialogRoot.addView(doneBtn);

        AlertDialog dialog = builder.setView(dialogRoot).create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        doneBtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void addPluginCard(LinearLayout container, String name, String description, boolean isEnabled) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#242833"), 12, Color.parseColor("#333742"), 1, this));
        int pad = UIUtils.dpToPx(this, 12);
        card.setPadding(pad, pad, pad, pad);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.bottomMargin = UIUtils.dpToPx(this, 10);
        card.setLayoutParams(cardParams);

        LinearLayout topRow = new LinearLayout(this);
        topRow.setOrientation(LinearLayout.HORIZONTAL);
        topRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView nameView = new TextView(this);
        nameView.setText(name);
        nameView.setTextColor(Color.parseColor("#F8FAFC"));
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        nameView.setTypeface(null, Typeface.BOLD);
        LinearLayout.LayoutParams nParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        nameView.setLayoutParams(nParams);
        topRow.addView(nameView);

        TextView badge = new TextView(this);
        badge.setText(isEnabled ? "Active" : "Standby");
        badge.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        badge.setTypeface(null, Typeface.BOLD);
        badge.setTextColor(isEnabled ? Color.parseColor("#10B981") : Color.parseColor("#94A3B8"));
        int bPadH = UIUtils.dpToPx(this, 8);
        int bPadV = UIUtils.dpToPx(this, 3);
        badge.setPadding(bPadH, bPadV, bPadH, bPadV);
        badge.setBackground(UIUtils.createRoundedDrawable(
                isEnabled ? Color.parseColor("#064E3B") : Color.parseColor("#27272A"),
                8,
                isEnabled ? Color.parseColor("#059669") : Color.parseColor("#3F3F46"),
                1,
                this));
        topRow.addView(badge);
        card.addView(topRow);

        TextView descView = new TextView(this);
        descView.setText(description);
        descView.setTextColor(Color.parseColor("#94A3B8"));
        descView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        LinearLayout.LayoutParams dParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dParams.topMargin = UIUtils.dpToPx(this, 4);
        descView.setLayoutParams(dParams);
        card.addView(descView);

        container.addView(card);
    }

    private void launchCamera() {
        try {
            File cacheDir = new File(getCacheDir(), "images");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File tempFile = File.createTempFile("photo_", ".jpg", cacheDir);
            pendingCameraUri = FileProvider.getUriForFile(
                    this,
                    getApplicationContext().getPackageName() + ".fileprovider",
                    tempFile
            );
            cameraLauncher.launch(pendingCameraUri);
        } catch (Exception e) {
            Toast.makeText(this, "Could not open camera: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void sendMessage() {
        String text = messageEditText.getText().toString().trim();
        Uri imageUriToSend = attachedImageUri;

        if (text.isEmpty() && imageUriToSend == null) return;

        // Immediately hide/remove the welcome card from the chat screen when the user sends a message
        for (int i = messageList.size() - 1; i >= 0; i--) {
            if (messageList.get(i).isWelcome()) {
                messageList.remove(i);
            }
        }

        // 1. Display user message
        ChatMessage userMessage;
        if (imageUriToSend != null) {
            userMessage = new ChatMessage(text, imageUriToSend, true, System.currentTimeMillis());
        } else {
            userMessage = new ChatMessage(text, true, System.currentTimeMillis());
        }
        messageList.add(userMessage);

        // 2. Clear input field and attached image preview
        messageEditText.setText("");
        clearAttachedImage();

        if (currentChatId == null) {
            currentChatId = String.valueOf(System.currentTimeMillis());
        }

        // Automatically update Recents with new question and conversation history
        if (!text.isEmpty()) {
            String recentTitle = RecentChatTitleGenerator.generateTitle(text, datasetHelper);
            ChatbotPrefs.addRecentChat(this, currentChatId, text, recentTitle, messageList);
            refreshRecentsList();
        } else if (imageUriToSend != null) {
            String recentTitle = "Image / Diagram Query";
            ChatbotPrefs.addRecentChat(this, currentChatId, "Image Analysis", recentTitle, messageList);
            refreshRecentsList();
        }

        // 3. If an image or file is attached, process using on-device OCR / local analysis
        if (imageUriToSend != null) {
            handleAttachedFile(imageUriToSend, text);
            return;
        }

        // 4. Regular text-only message: Show Typing Indicator
        String typingPrompt = isThinkHarderEnabled ? "🧠 AI is thinking deeply (high reasoning)..." : "AI is thinking...";
        ChatMessage typingMessage = new ChatMessage(typingPrompt, false, System.currentTimeMillis(), true, false);
        messageList.add(typingMessage);

        chatAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(messageList.size() - 1);

        String mode = ChatbotPrefs.getAiMode(this);
        boolean hasKey = ChatbotPrefs.hasGeminiApiKey(this);

        if (ChatbotPrefs.MODE_OFFLINE.equals(mode)) {
            // Offline mode selected
            handleOfflineResponse(text, false);
        } else if (hasKey) {
            // Live Gemini API call with conversation context
            String promptToSend = isThinkHarderEnabled ? (text + "\n(Please think step-by-step and provide a thorough, structured reasoning breakdown.)") : text;
            GeminiApiClient.getInstance().generateResponse(this, promptToSend, messageList, new GeminiApiClient.ResponseCallback() {
                @Override
                public void onSuccess(String responseText) {
                    displayBotResponse(responseText);
                }

                @Override
                public void onError(String errorMessage, boolean isApiKeyIssue) {
                    if (ChatbotPrefs.MODE_GEMINI.equals(mode)) {
                        displayBotResponse("⚠️ Gemini Error: " + errorMessage + "\n\nYou can update your API key in Settings (☰ -> Settings).");
                    } else {
                        // Hybrid auto fallback to deep knowledge engine
                        handleOfflineResponse(text, true);
                    }
                }
            });
        } else {
            // No API key set
            if (ChatbotPrefs.MODE_GEMINI.equals(mode)) {
                displayBotResponse("⚠️ Gemini AI mode is active, but no API key is saved.\n\nPlease open Settings (☰ -> Settings) to paste your free Gemini API key, or switch to Auto / Offline mode.");
            } else {
                handleOfflineResponse(text, false);
            }
        }
    }

    private void handleAttachedFile(Uri fileUri, String userQuestion) {
        String mimeType = getContentResolver().getType(fileUri);
        String fileName = queryFileName(fileUri);
        boolean isImage = (mimeType != null && mimeType.startsWith("image/"))
                || (fileName != null && (fileName.toLowerCase().endsWith(".png")
                || fileName.toLowerCase().endsWith(".jpg")
                || fileName.toLowerCase().endsWith(".jpeg")
                || fileName.toLowerCase().endsWith(".webp")
                || fileName.toLowerCase().endsWith(".bmp")));

        if (isImage) {
            handleImageQuestion(fileUri, userQuestion);
        } else {
            handleDocumentQuestion(fileUri, fileName, userQuestion);
        }
    }

    private void handleImageQuestion(Uri imageUri, String userQuestion) {
        String statusPrompt = isThinkHarderEnabled ? "📷 🧠 AI is reading image with deep reasoning..." : "📷 AI is reading image offline...";
        ChatMessage typingMessage = new ChatMessage(statusPrompt, false, System.currentTimeMillis(), true, false);
        messageList.add(typingMessage);
        int typingPos = messageList.size() - 1;
        chatAdapter.notifyItemInserted(typingPos);
        recyclerView.smoothScrollToPosition(typingPos);

        ocrProcessor.processImageUri(this, imageUri, new OfflineOCRProcessor.OCRCallback() {
            @Override
            public void onSuccess(String extractedText) {
                String answer = ImageQuestionMatcher.analyzeImageContent(extractedText, userQuestion, datasetHelper);
                if (isThinkHarderEnabled) {
                    answer = "🧠 Step-by-Step Reasoning Breakdown:\n\n" + answer;
                }
                final String finalAnswer = answer;
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    displayBotResponse(finalAnswer);
                }, 500);
            }

            @Override
            public void onError(String errorMessage) {
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    displayBotResponse("📷 Offline Image Reading Note:\n" +
                            "Unable to extract text from the image: " + errorMessage +
                            "\n\nPlease ensure the photo is clear, well-lit, and contains readable text or diagram labels.");
                }, 400);
            }
        });
    }

    private void handleDocumentQuestion(Uri fileUri, String fileName, String userQuestion) {
        ChatMessage typingMessage = new ChatMessage("📄 AI is analyzing file...", false, System.currentTimeMillis(), true, false);
        messageList.add(typingMessage);
        int typingPos = messageList.size() - 1;
        chatAdapter.notifyItemInserted(typingPos);
        recyclerView.smoothScrollToPosition(typingPos);

        new Thread(() -> {
            String extractedText = "";
            try (InputStream is = getContentResolver().openInputStream(fileUri);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && sb.length() < 10000) {
                    sb.append(line).append("\n");
                }
                extractedText = sb.toString().trim();
            } catch (Exception ignored) {}

            final String fileText = extractedText;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                String answer;
                if (!fileText.isEmpty()) {
                    answer = ImageQuestionMatcher.analyzeImageContent(fileText, userQuestion, datasetHelper);
                } else {
                    answer = "Attached File: " + fileName + "\n\nFile received successfully. You can ask questions about its concepts or content.";
                }
                if (isThinkHarderEnabled) {
                    answer = "🧠 Step-by-Step Reasoning Breakdown:\n\n" + answer;
                }
                displayBotResponse(answer);
            }, 500);
        }).start();
    }

    private void handleOfflineResponse(String query, boolean wasFallback) {
        String answer = datasetHelper.getAnswer(query);
        if (isThinkHarderEnabled) {
            answer = "🧠 Step-by-Step Reasoning Breakdown:\n\n" + answer;
        }
        if (wasFallback) {
            answer = answer + "\n\n*(⚡ Answered via Deep Knowledge Base - Live API offline)*";
        }
        displayBotResponse(answer);
    }

    private void displayBotResponse(String reply) {
        if (reply != null) {
            reply = reply.replace("**", "");
        }

        for (int i = messageList.size() - 1; i >= 0; i--) {
            if (messageList.get(i).isTyping()) {
                messageList.remove(i);
            }
        }

        ChatMessage botMessage = new ChatMessage(reply, false, System.currentTimeMillis());
        messageList.add(botMessage);

        if (currentChatId != null && !messageList.isEmpty()) {
            String firstQuestion = "";
            for (ChatMessage m : messageList) {
                if (m.isUser()) {
                    firstQuestion = m.getText();
                    break;
                }
            }
            if (firstQuestion.isEmpty()) firstQuestion = "Chat Conversation";
            String title = RecentChatTitleGenerator.generateTitle(firstQuestion, datasetHelper);
            ChatbotPrefs.addRecentChat(this, currentChatId, firstQuestion, title, messageList);
            refreshRecentsList();
        }

        new Handler(Looper.getMainLooper()).post(() -> {
            chatAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(messageList.size() - 1);
        });
    }

    private void showHamburgerMenu(View anchorView) {
        if (drawerLayout != null) {
            refreshRecentsList();
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }
    }

    private View createNavigationDrawerView() {
        LinearLayout drawerRoot = new LinearLayout(this);
        drawerRoot.setOrientation(LinearLayout.VERTICAL);
        drawerRoot.setBackgroundColor(Color.parseColor("#FFFFFF")); // Clean light theme

        // 1. Top Header
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);
        int padH = UIUtils.dpToPx(this, 18);
        int padV = UIUtils.dpToPx(this, 14);
        header.setPadding(padH, padV, padH, padV);

        BotLogoView drawerLogo = new BotLogoView(this);
        drawerLogo.setShowText(false);
        int iconSize = UIUtils.dpToPx(this, 38);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(iconSize, iconSize);
        iconParams.rightMargin = UIUtils.dpToPx(this, 12);
        drawerLogo.setLayoutParams(iconParams);
        header.addView(drawerLogo);

        LinearLayout titleBox = new LinearLayout(this);
        titleBox.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams titleBoxParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        titleBox.setLayoutParams(titleBoxParams);

        TextView titleView = new TextView(this);
        titleView.setText("ChAI");
        titleView.setTextColor(Color.parseColor("#0F172A"));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        titleView.setTypeface(null, Typeface.BOLD);
        titleBox.addView(titleView);

        TextView subtitleView = new TextView(this);
        subtitleView.setText("AI & Machine Learning Assistant");
        subtitleView.setTextColor(Color.parseColor("#64748B"));
        subtitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        titleBox.addView(subtitleView);

        header.addView(titleBox);

        // Search Icon Button
        ImageView searchBtn = new ImageView(this);
        int searchSize = UIUtils.dpToPx(this, 30);
        LinearLayout.LayoutParams searchParams = new LinearLayout.LayoutParams(searchSize, searchSize);
        searchParams.rightMargin = UIUtils.dpToPx(this, 8);
        searchBtn.setLayoutParams(searchParams);
        searchBtn.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 15, Color.TRANSPARENT, 0, this));
        searchBtn.setImageBitmap(UIUtils.createSearchIconBitmap(this, 16, Color.parseColor("#64748B")));
        searchBtn.setScaleType(ImageView.ScaleType.CENTER);
        searchBtn.setOnClickListener(v -> {
            drawerLayout.closeDrawer(GravityCompat.START);
            showSearchHistoryDialog();
        });
        header.addView(searchBtn);

        ImageView closeBtn = new ImageView(this);
        int closeSize = UIUtils.dpToPx(this, 30);
        LinearLayout.LayoutParams closeParams = new LinearLayout.LayoutParams(closeSize, closeSize);
        closeBtn.setLayoutParams(closeParams);
        closeBtn.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 15, Color.TRANSPARENT, 0, this));
        closeBtn.setImageBitmap(UIUtils.createCloseIconBitmap(this, 16, Color.parseColor("#64748B")));
        closeBtn.setScaleType(ImageView.ScaleType.CENTER);
        closeBtn.setOnClickListener(v -> drawerLayout.closeDrawer(GravityCompat.START));
        header.addView(closeBtn);

        drawerRoot.addView(header);

        // Header Divider
        View headerDivider = new View(this);
        headerDivider.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1)));
        headerDivider.setBackgroundColor(Color.parseColor("#E2E8F0"));
        drawerRoot.addView(headerDivider);

        // Scrollable Content
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f);
        scrollView.setLayoutParams(scrollParams);

        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        int padContent = UIUtils.dpToPx(this, 16);
        contentLayout.setPadding(padContent, padContent, padContent, padContent);

        // ==========================================
        // EXISTING SECTION: Domain: AIML
        // ==========================================
        LinearLayout domainCard = new LinearLayout(this);
        domainCard.setOrientation(LinearLayout.VERTICAL);
        domainCard.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F8FAFC"), 14, Color.parseColor("#E2E8F0"), 1, this));
        int dPadH = UIUtils.dpToPx(this, 14);
        int dPadV = UIUtils.dpToPx(this, 12);
        domainCard.setPadding(dPadH, dPadV, dPadH, dPadV);
        LinearLayout.LayoutParams dCardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dCardParams.bottomMargin = UIUtils.dpToPx(this, 14);
        domainCard.setLayoutParams(dCardParams);

        LinearLayout domainTopRow = new LinearLayout(this);
        domainTopRow.setOrientation(LinearLayout.HORIZONTAL);
        domainTopRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView domainTitle = new TextView(this);
        domainTitle.setText("🤖 Domain: AIML");
        domainTitle.setTextColor(Color.parseColor("#0F172A"));
        domainTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        domainTitle.setTypeface(null, Typeface.BOLD);
        LinearLayout.LayoutParams dtParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        domainTitle.setLayoutParams(dtParams);
        domainTopRow.addView(domainTitle);

        TextView domainBadge = new TextView(this);
        domainBadge.setText("Active");
        domainBadge.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        domainBadge.setTypeface(null, Typeface.BOLD);
        domainBadge.setTextColor(Color.parseColor("#166534"));
        int bPadH = UIUtils.dpToPx(this, 8);
        int bPadV = UIUtils.dpToPx(this, 3);
        domainBadge.setPadding(bPadH, bPadV, bPadH, bPadV);
        domainBadge.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#DCFCE7"), 8, Color.parseColor("#86EFAC"), 1, this));
        domainTopRow.addView(domainBadge);

        domainCard.addView(domainTopRow);

        TextView domainDesc = new TextView(this);
        domainDesc.setText("Core AI, Machine Learning, Deep Learning & NLP");
        domainDesc.setTextColor(Color.parseColor("#64748B"));
        domainDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        LinearLayout.LayoutParams ddParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ddParams.topMargin = UIUtils.dpToPx(this, 6);
        domainDesc.setLayoutParams(ddParams);
        domainCard.addView(domainDesc);

        contentLayout.addView(domainCard);

        // ========================================================
        // 1. FOUR MENU OPTIONS BELOW THE EXISTING "Domain: AIML" SECTION:
        //    - New chat
        //    - Clear chat
        //    - Chat history
        //    - Logout
        // ========================================================
        LinearLayout menuOptionsContainer = new LinearLayout(this);
        menuOptionsContainer.setOrientation(LinearLayout.VERTICAL);

        // New chat
        addDrawerActionRow(
                menuOptionsContainer,
                "New chat",
                UIUtils.createChatIconBitmap(this, 18, Color.parseColor("#38BDF8")),
                v -> {
                    drawerLayout.closeDrawers();
                    resetChat();
                    Toast.makeText(this, "New chat started", Toast.LENGTH_SHORT).show();
                }
        );

        // Clear chat
        addDrawerActionRow(
                menuOptionsContainer,
                "Clear chat",
                UIUtils.createClearIconBitmap(this, 18, Color.parseColor("#F87171")),
                v -> {
                    drawerLayout.closeDrawers();
                    resetChat();
                    Toast.makeText(this, "Chat cleared", Toast.LENGTH_SHORT).show();
                }
        );

        // Chat history
        addDrawerActionRow(
                menuOptionsContainer,
                "Chat history",
                UIUtils.createHistoryIconBitmap(this, 18, Color.parseColor("#FBBF24")),
                v -> {
                    drawerLayout.closeDrawers();
                    showChatHistoryDialog();
                }
        );

        // Logout
        addDrawerActionRow(
                menuOptionsContainer,
                "Logout",
                UIUtils.createLogoutIconBitmap(this, 18, Color.parseColor("#EF4444")),
                v -> {
                    drawerLayout.closeDrawers();
                    logout();
                }
        );

        contentLayout.addView(menuOptionsContainer);

        // Divider
        View menuDivider = new View(this);
        LinearLayout.LayoutParams mdParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1));
        mdParams.topMargin = UIUtils.dpToPx(this, 14);
        mdParams.bottomMargin = UIUtils.dpToPx(this, 14);
        menuDivider.setLayoutParams(mdParams);
        menuDivider.setBackgroundColor(Color.parseColor("#E2E8F0"));
        contentLayout.addView(menuDivider);

        // ==========================================
        // 2. "RECENTS" SECTION BELOW FOUR OPTIONS
        // ==========================================
        TextView recentsHeader = new TextView(this);
        recentsHeader.setText("Recents");
        recentsHeader.setTextColor(Color.parseColor("#64748B"));
        recentsHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        recentsHeader.setTypeface(null, Typeface.BOLD);
        LinearLayout.LayoutParams rhParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rhParams.bottomMargin = UIUtils.dpToPx(this, 8);
        recentsHeader.setLayoutParams(rhParams);
        contentLayout.addView(recentsHeader);

        recentsContainer = new LinearLayout(this);
        recentsContainer.setOrientation(LinearLayout.VERTICAL);
        contentLayout.addView(recentsContainer);

        // 8. "See all..." at the bottom of the Recents section
        seeAllButton = new TextView(this);
        seeAllButton.setText("See all...");
        seeAllButton.setTextColor(Color.parseColor("#2563EB"));
        seeAllButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        seeAllButton.setTypeface(null, Typeface.BOLD);
        int seePadH = UIUtils.dpToPx(this, 8);
        int seePadV = UIUtils.dpToPx(this, 10);
        seeAllButton.setPadding(seePadH, seePadV, seePadH, seePadV);
        seeAllButton.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#F1F5F9"), 8, this));
        seeAllButton.setOnClickListener(v -> showAllRecentChatsDialog());
        contentLayout.addView(seeAllButton);

        scrollView.addView(contentLayout);
        drawerRoot.addView(scrollView);

        // Populate Recents on view creation
        refreshRecentsList();

        return drawerRoot;
    }

    private void addDrawerActionRow(LinearLayout container, String title, Bitmap iconBitmap, View.OnClickListener onClickListener) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int padH = UIUtils.dpToPx(this, 10);
        int padV = UIUtils.dpToPx(this, 10);
        row.setPadding(padH, padV, padH, padV);
        row.setClickable(true);
        row.setFocusable(true);
        row.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#F1F5F9"), 10, this));

        ImageView iconView = new ImageView(this);
        int iconSize = UIUtils.dpToPx(this, 28);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(iconSize, iconSize);
        iconParams.rightMargin = UIUtils.dpToPx(this, 12);
        iconView.setLayoutParams(iconParams);
        iconView.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 14, Color.TRANSPARENT, 0, this));
        iconView.setImageBitmap(iconBitmap);
        iconView.setScaleType(ImageView.ScaleType.CENTER);
        row.addView(iconView);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(Color.parseColor("#0F172A"));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        titleView.setTypeface(null, Typeface.BOLD);
        LinearLayout.LayoutParams tp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        titleView.setLayoutParams(tp);
        row.addView(titleView);

        row.setOnClickListener(onClickListener);
        container.addView(row);
    }

    private void refreshRecentsList() {
        if (recentsContainer == null) return;
        recentsContainer.removeAllViews();

        List<RecentChat> list = ChatbotPrefs.getRecentChats(this);
        if (list.isEmpty()) {
            TextView emptyView = new TextView(this);
            emptyView.setText("No recent chats yet");
            emptyView.setTextColor(Color.parseColor("#64748B"));
            emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            int pad = UIUtils.dpToPx(this, 8);
            emptyView.setPadding(pad, pad, pad, pad);
            recentsContainer.addView(emptyView);
            if (seeAllButton != null) {
                seeAllButton.setVisibility(View.GONE);
            }
            return;
        }

        if (seeAllButton != null) {
            seeAllButton.setVisibility(View.VISIBLE);
        }

        int maxItemsToShow = isRecentsExpanded ? list.size() : Math.min(5, list.size());
        for (int i = 0; i < maxItemsToShow; i++) {
            RecentChat chat = list.get(i);
            addRecentChatItemView(recentsContainer, chat, i == maxItemsToShow - 1);
        }
    }

    private void addRecentChatItemView(LinearLayout container, RecentChat chat, boolean isLast) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int padH = UIUtils.dpToPx(this, 8);
        int padV = UIUtils.dpToPx(this, 8);
        row.setPadding(padH, padV, padH, padV);
        row.setClickable(true);
        row.setFocusable(true);
        row.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#F1F5F9"), 8, this));

        // Question Icon
        ImageView qIcon = new ImageView(this);
        int qIconSize = UIUtils.dpToPx(this, 26);
        LinearLayout.LayoutParams qParams = new LinearLayout.LayoutParams(qIconSize, qIconSize);
        qParams.rightMargin = UIUtils.dpToPx(this, 10);
        qIcon.setLayoutParams(qParams);
        qIcon.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 13, Color.TRANSPARENT, 0, this));
        qIcon.setImageBitmap(UIUtils.createChatIconBitmap(this, 14, Color.parseColor("#64748B")));
        qIcon.setScaleType(ImageView.ScaleType.CENTER);
        row.addView(qIcon);

        // Title and Date/Time Column
        LinearLayout textBox = new LinearLayout(this);
        textBox.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams tbParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        textBox.setLayoutParams(tbParams);

        TextView titleView = new TextView(this);
        titleView.setText(chat.title);
        titleView.setTextColor(Color.parseColor("#0F172A"));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        titleView.setTypeface(null, Typeface.BOLD);
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        textBox.addView(titleView);

        TextView timeView = new TextView(this);
        timeView.setText(formatChatDate(chat.timestamp));
        timeView.setTextColor(Color.parseColor("#64748B"));
        timeView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        textBox.addView(timeView);

        row.addView(textBox);

        // Delete / Trash Icon on the right side
        ImageView deleteBtn = new ImageView(this);
        int delSize = UIUtils.dpToPx(this, 30);
        LinearLayout.LayoutParams delParams = new LinearLayout.LayoutParams(delSize, delSize);
        deleteBtn.setLayoutParams(delParams);
        deleteBtn.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#FEE2E2"), 15, this));
        deleteBtn.setImageBitmap(UIUtils.createTrashIconBitmap(this, 16, Color.parseColor("#EF4444")));
        deleteBtn.setScaleType(ImageView.ScaleType.CENTER);
        deleteBtn.setOnClickListener(v -> {
            ChatbotPrefs.deleteRecentChat(this, chat.id);
            refreshRecentsList();
            Toast.makeText(this, "Recent chat removed", Toast.LENGTH_SHORT).show();
        });
        row.addView(deleteBtn);

        // Click row: load complete conversation history
        row.setOnClickListener(v -> {
            drawerLayout.closeDrawers();
            loadRecentChatConversation(chat);
        });

        container.addView(row);

        if (!isLast) {
            View div = new View(this);
            LinearLayout.LayoutParams divP = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1));
            divP.leftMargin = UIUtils.dpToPx(this, 36);
            divP.rightMargin = UIUtils.dpToPx(this, 8);
            div.setLayoutParams(divP);
            div.setBackgroundColor(Color.parseColor("#E2E8F0"));
            container.addView(div);
        }
    }

    private String formatChatDate(long timestamp) {
        long now = System.currentTimeMillis();
        long diff = now - timestamp;
        if (diff < 60 * 1000) {
            return "Just now";
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        String timeStr = timeFormat.format(new Date(timestamp));

        Calendar calNow = Calendar.getInstance();
        Calendar calThen = Calendar.getInstance();
        calThen.setTimeInMillis(timestamp);

        if (calNow.get(Calendar.YEAR) == calThen.get(Calendar.YEAR)
                && calNow.get(Calendar.DAY_OF_YEAR) == calThen.get(Calendar.DAY_OF_YEAR)) {
            return "Today, " + timeStr;
        }

        if (calNow.get(Calendar.YEAR) == calThen.get(Calendar.YEAR)
                && calNow.get(Calendar.DAY_OF_YEAR) - calThen.get(Calendar.DAY_OF_YEAR) == 1) {
            return "Yesterday, " + timeStr;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, h:mm a", Locale.getDefault());
        return dateFormat.format(new Date(timestamp));
    }

    private void showChatHistoryDialog() {
        showAllRecentChatsDialog();
    }

    private void loadRecentChatConversation(RecentChat chat) {
        // Show loading indicator
        messageList.clear();
        messageList.add(new ChatMessage("Loading conversation...", false, System.currentTimeMillis(), true, false));
        chatAdapter.notifyDataSetChanged();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            try {
                List<ChatMessage> loadedMessages = ChatbotPrefs.getConversationMessages(this, chat.id);
                if (loadedMessages.isEmpty() && chat.question != null && !chat.question.isEmpty()) {
                    loadedMessages.add(new ChatMessage(chat.question, true, chat.timestamp));
                    loadedMessages.add(new ChatMessage("Previous conversation response.", false, chat.timestamp));
                }

                if (!loadedMessages.isEmpty()) {
                    currentChatId = chat.id;
                    messageList.clear();
                    messageList.addAll(loadedMessages);
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messageList.size() - 1);
                    Toast.makeText(this, "Loaded: " + chat.title, Toast.LENGTH_SHORT).show();
                } else {
                    showLoadErrorDialog(chat);
                }
            } catch (Exception e) {
                showLoadErrorDialog(chat);
            }
        }, 350);
    }

    private void showLoadErrorDialog(RecentChat chat) {
        messageList.clear();
        messageList.add(new ChatMessage("Hello! I am your AI Assistant powered by Google Gemini and a Supercharged Knowledge Engine. Ask me anything!", false, System.currentTimeMillis(), false, true));
        chatAdapter.notifyDataSetChanged();

        new AlertDialog.Builder(this)
                .setTitle("Loading Error")
                .setMessage("Could not load the conversation '" + chat.title + "'. Would you like to retry?")
                .setPositiveButton("Retry", (dialog, which) -> loadRecentChatConversation(chat))
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showSearchHistoryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackground(UIUtils.createRoundedDrawable(
                Color.WHITE, 20, Color.parseColor("#CBD5E1"), 1, this));
        int pad = UIUtils.dpToPx(this, 20);
        root.setPadding(pad, pad, pad, pad);

        // Header Title
        TextView tView = new TextView(this);
        tView.setText("🔍 Search Chat History");
        tView.setTextColor(Color.parseColor("#0F172A"));
        tView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        tView.setTypeface(null, Typeface.BOLD);
        root.addView(tView);

        // Search Input EditText
        EditText searchEditText = new EditText(this);
        searchEditText.setHint("Type keyword to search chats...");
        searchEditText.setHintTextColor(Color.parseColor("#94A3B8"));
        searchEditText.setTextColor(Color.parseColor("#0F172A"));
        searchEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        searchEditText.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 10, Color.parseColor("#CBD5E1"), 1, this));
        int sPad = UIUtils.dpToPx(this, 12);
        searchEditText.setPadding(sPad, sPad, sPad, sPad);
        LinearLayout.LayoutParams seParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        seParams.topMargin = UIUtils.dpToPx(this, 12);
        seParams.bottomMargin = UIUtils.dpToPx(this, 12);
        searchEditText.setLayoutParams(seParams);
        root.addView(searchEditText);

        // Results Container
        ScrollView sv = new ScrollView(this);
        int maxH = UIUtils.dpToPx(this, 320);
        sv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, maxH));
        sv.setVerticalScrollBarEnabled(false);

        LinearLayout resultsContainer = new LinearLayout(this);
        resultsContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(resultsContainer);
        root.addView(sv);

        AlertDialog dialog = builder.setView(root).create();

        // Populate initial list (all recent chats)
        List<RecentChat> allList = ChatbotPrefs.getRecentChats(this);
        populateSearchResults(resultsContainer, allList);

        // TextWatcher to filter search results live
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase().trim();
                List<RecentChat> filtered = new ArrayList<>();
                for (RecentChat chat : allList) {
                    if (chat.title.toLowerCase().contains(query) || chat.question.toLowerCase().contains(query)) {
                        filtered.add(chat);
                    }
                }
                populateSearchResults(resultsContainer, filtered);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Close Button Row
        LinearLayout btnRow = new LinearLayout(this);
        btnRow.setOrientation(LinearLayout.HORIZONTAL);
        btnRow.setGravity(Gravity.END);
        LinearLayout.LayoutParams brp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        brp.topMargin = UIUtils.dpToPx(this, 14);
        btnRow.setLayoutParams(brp);

        Button closeBtn = new Button(this);
        closeBtn.setText("Close");
        closeBtn.setTextColor(Color.WHITE);
        closeBtn.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#0D9488"), Color.parseColor("#0F766E"), 10, this));
        closeBtn.setOnClickListener(v -> dialog.dismiss());
        btnRow.addView(closeBtn);
        root.addView(btnRow);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.show();
    }

    private void populateSearchResults(LinearLayout container, List<RecentChat> list) {
        container.removeAllViews();
        if (list.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("No matching chat history found");
            empty.setTextColor(Color.parseColor("#64748B"));
            empty.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            empty.setGravity(Gravity.CENTER);
            empty.setPadding(0, UIUtils.dpToPx(this, 24), 0, UIUtils.dpToPx(this, 24));
            container.addView(empty);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            RecentChat chat = list.get(i);
            addRecentChatItemView(container, chat, i == list.size() - 1);
        }
    }

    private void showAllRecentChatsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#18181B"), 20, Color.parseColor("#2E3038"), 1, this));
        int pad = UIUtils.dpToPx(this, 20);
        root.setPadding(pad, pad, pad, pad);

        // Header
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        ImageView hIcon = new ImageView(this);
        int hiSize = UIUtils.dpToPx(this, 34);
        LinearLayout.LayoutParams hip = new LinearLayout.LayoutParams(hiSize, hiSize);
        hip.rightMargin = UIUtils.dpToPx(this, 12);
        hIcon.setLayoutParams(hip);
        hIcon.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#27272A"), 17, Color.TRANSPARENT, 0, this));
        hIcon.setImageBitmap(UIUtils.createHistoryIconBitmap(this, 18, Color.parseColor("#38BDF8")));
        hIcon.setScaleType(ImageView.ScaleType.CENTER);
        header.addView(hIcon);

        LinearLayout hTitles = new LinearLayout(this);
        hTitles.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams htp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        hTitles.setLayoutParams(htp);

        TextView tView = new TextView(this);
        tView.setText("All Recent Chats");
        tView.setTextColor(Color.parseColor("#F8FAFC"));
        tView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        tView.setTypeface(null, Typeface.BOLD);
        hTitles.addView(tView);

        List<RecentChat> allList = ChatbotPrefs.getRecentChats(this);
        TextView sView = new TextView(this);
        sView.setText(allList.size() + " saved recent questions");
        sView.setTextColor(Color.parseColor("#94A3B8"));
        sView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        hTitles.addView(sView);
        header.addView(hTitles);
        root.addView(header);

        // Divider
        View div = new View(this);
        LinearLayout.LayoutParams dp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 1));
        dp.topMargin = UIUtils.dpToPx(this, 14);
        dp.bottomMargin = UIUtils.dpToPx(this, 14);
        div.setLayoutParams(dp);
        div.setBackgroundColor(Color.parseColor("#27272A"));
        root.addView(div);

        ScrollView sv = new ScrollView(this);
        int maxH = UIUtils.dpToPx(this, 360);
        sv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, maxH));
        sv.setVerticalScrollBarEnabled(false);

        LinearLayout listContainer = new LinearLayout(this);
        listContainer.setOrientation(LinearLayout.VERTICAL);

        AlertDialog dialog = builder.setView(root).create();

        if (allList.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("No recent chats recorded yet");
            empty.setTextColor(Color.parseColor("#64748B"));
            empty.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            empty.setGravity(Gravity.CENTER);
            empty.setPadding(0, UIUtils.dpToPx(this, 30), 0, UIUtils.dpToPx(this, 30));
            listContainer.addView(empty);
        } else {
            for (int i = 0; i < allList.size(); i++) {
                RecentChat chat = allList.get(i);
                addRecentChatItemView(listContainer, chat, i == allList.size() - 1);
            }
        }
        sv.addView(listContainer);
        root.addView(sv);

        // Action Buttons Row: Clear All & Close
        LinearLayout btnRow = new LinearLayout(this);
        btnRow.setOrientation(LinearLayout.HORIZONTAL);
        btnRow.setGravity(Gravity.END);
        LinearLayout.LayoutParams brp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        brp.topMargin = UIUtils.dpToPx(this, 14);
        btnRow.setLayoutParams(brp);

        Button clearAllBtn = new Button(this);
        clearAllBtn.setText("Clear All");
        clearAllBtn.setTextColor(Color.parseColor("#F87171"));
        clearAllBtn.setBackground(UIUtils.createButtonDrawable(
                Color.TRANSPARENT, Color.parseColor("#27272A"), 10, this));
        clearAllBtn.setOnClickListener(v -> {
            ChatbotPrefs.clearRecentChats(this);
            refreshRecentsList();
            dialog.dismiss();
            Toast.makeText(this, "Recent chats cleared", Toast.LENGTH_SHORT).show();
        });
        btnRow.addView(clearAllBtn);

        Button closeBtn = new Button(this);
        closeBtn.setText("Close");
        closeBtn.setTextColor(Color.WHITE);
        closeBtn.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#2563EB"), Color.parseColor("#1D4ED8"), 10, this));
        LinearLayout.LayoutParams cbParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cbParams.leftMargin = UIUtils.dpToPx(this, 8);
        closeBtn.setLayoutParams(cbParams);
        closeBtn.setOnClickListener(v -> dialog.dismiss());
        btnRow.addView(closeBtn);

        root.addView(btnRow);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.show();
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        int pad = UIUtils.dpToPx(this, 20);
        layout.setPadding(pad, pad, pad, pad);

        // Header Title
        TextView title = new TextView(this);
        title.setText("⚙️ AI Assistant Settings");
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.parseColor("#0F172A"));
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Select your intelligence engine and configure Google Gemini API.");
        subtitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        subtitle.setTextColor(Color.parseColor("#64748B"));
        LinearLayout.LayoutParams subParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subParams.topMargin = UIUtils.dpToPx(this, 4);
        subParams.bottomMargin = UIUtils.dpToPx(this, 16);
        subtitle.setLayoutParams(subParams);
        layout.addView(subtitle);

        // Mode Label
        TextView modeLabel = new TextView(this);
        modeLabel.setText("Intelligence Mode");
        modeLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        modeLabel.setTypeface(null, Typeface.BOLD);
        modeLabel.setTextColor(Color.parseColor("#1E293B"));
        layout.addView(modeLabel);

        // RadioGroup for Mode
        RadioGroup radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(RadioGroup.VERTICAL);
        LinearLayout.LayoutParams rgParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rgParams.topMargin = UIUtils.dpToPx(this, 6);
        rgParams.bottomMargin = UIUtils.dpToPx(this, 16);
        radioGroup.setLayoutParams(rgParams);

        RadioButton rbAuto = new RadioButton(this);
        rbAuto.setText("⚡ Auto Hybrid (Gemini AI + Offline Base)");
        rbAuto.setTextColor(Color.parseColor("#0F172A"));

        RadioButton rbGemini = new RadioButton(this);
        rbGemini.setText("🌐 Gemini Live AI Only (Requires API Key)");
        rbGemini.setTextColor(Color.parseColor("#0F172A"));

        RadioButton rbOffline = new RadioButton(this);
        rbOffline.setText("💾 Deep Offline Knowledge Base Only");
        rbOffline.setTextColor(Color.parseColor("#0F172A"));

        radioGroup.addView(rbAuto);
        radioGroup.addView(rbGemini);
        radioGroup.addView(rbOffline);

        String currentMode = ChatbotPrefs.getAiMode(this);
        if (ChatbotPrefs.MODE_GEMINI.equals(currentMode)) {
            rbGemini.setChecked(true);
        } else if (ChatbotPrefs.MODE_OFFLINE.equals(currentMode)) {
            rbOffline.setChecked(true);
        } else {
            rbAuto.setChecked(true);
        }
        layout.addView(radioGroup);

        // API Key Section
        TextView keyLabel = new TextView(this);
        keyLabel.setText("Google Gemini API Key");
        keyLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        keyLabel.setTypeface(null, Typeface.BOLD);
        keyLabel.setTextColor(Color.parseColor("#1E293B"));
        layout.addView(keyLabel);

        EditText keyEditText = new EditText(this);
        keyEditText.setHint("Paste your Gemini API key (AIzaSy...)");
        keyEditText.setHintTextColor(Color.parseColor("#94A3B8"));
        keyEditText.setTextColor(Color.parseColor("#0F172A"));
        keyEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        keyEditText.setText(ChatbotPrefs.getGeminiApiKey(this));
        keyEditText.setBackground(UIUtils.createRoundedDrawable(
                Color.parseColor("#F1F5F9"), 8, Color.parseColor("#CBD5E1"), 1, this));
        int inputPad = UIUtils.dpToPx(this, 10);
        keyEditText.setPadding(inputPad, inputPad, inputPad, inputPad);
        LinearLayout.LayoutParams keyParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        keyParams.topMargin = UIUtils.dpToPx(this, 6);
        keyParams.bottomMargin = UIUtils.dpToPx(this, 10);
        keyEditText.setLayoutParams(keyParams);
        layout.addView(keyEditText);

        // Helper Buttons Row: "Get Free Key" and "Test Key"
        LinearLayout buttonRow = new LinearLayout(this);
        buttonRow.setOrientation(LinearLayout.HORIZONTAL);

        Button getKeyBtn = new Button(this);
        getKeyBtn.setText("🔑 Get Free Key");
        getKeyBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        getKeyBtn.setAllCaps(false);
        getKeyBtn.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#EEF2FF"), Color.parseColor("#E0E7FF"), 8, this));
        getKeyBtn.setTextColor(Color.parseColor("#2563EB"));
        LinearLayout.LayoutParams btnParams1 = new LinearLayout.LayoutParams(
                0, UIUtils.dpToPx(this, 38), 1.0f);
        btnParams1.rightMargin = UIUtils.dpToPx(this, 6);
        getKeyBtn.setLayoutParams(btnParams1);
        getKeyBtn.setOnClickListener(v -> {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aistudio.google.com/app/apikey"));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(this, "Could not open browser", Toast.LENGTH_SHORT).show();
            }
        });

        Button testKeyBtn = new Button(this);
        testKeyBtn.setText("🧪 Test Key");
        testKeyBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        testKeyBtn.setAllCaps(false);
        testKeyBtn.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#F1F5F9"), Color.parseColor("#E2E8F0"), 8, this));
        testKeyBtn.setTextColor(Color.parseColor("#334155"));
        LinearLayout.LayoutParams btnParams2 = new LinearLayout.LayoutParams(
                0, UIUtils.dpToPx(this, 38), 1.0f);
        testKeyBtn.setLayoutParams(btnParams2);

        buttonRow.addView(getKeyBtn);
        buttonRow.addView(testKeyBtn);
        layout.addView(buttonRow);

        // Test Status Text
        TextView testStatusText = new TextView(this);
        testStatusText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        testStatusText.setPadding(0, UIUtils.dpToPx(this, 8), 0, UIUtils.dpToPx(this, 4));
        testStatusText.setVisibility(View.GONE);
        layout.addView(testStatusText);

        testKeyBtn.setOnClickListener(v -> {
            String testKey = keyEditText.getText().toString().trim();
            if (testKey.isEmpty()) {
                testStatusText.setText("⚠️ Please paste an API key first.");
                testStatusText.setTextColor(Color.parseColor("#D97706"));
                testStatusText.setVisibility(View.VISIBLE);
                return;
            }
            testStatusText.setText("Connecting to Gemini...");
            testStatusText.setTextColor(Color.parseColor("#2563EB"));
            testStatusText.setVisibility(View.VISIBLE);

            GeminiApiClient.getInstance().testApiKey(testKey, (isSuccess, message) -> {
                testStatusText.setText(isSuccess ? "✅ " + message : "❌ " + message);
                testStatusText.setTextColor(isSuccess ? Color.parseColor("#16A34A") : Color.parseColor("#DC2626"));
            });
        });

        scroll.addView(layout);
        builder.setView(scroll);

        builder.setPositiveButton("Save", (dialog, which) -> {
            String newKey = keyEditText.getText().toString().trim();
            ChatbotPrefs.setGeminiApiKey(this, newKey);

            String selectedMode = ChatbotPrefs.MODE_AUTO;
            if (rbGemini.isChecked()) {
                selectedMode = ChatbotPrefs.MODE_GEMINI;
            } else if (rbOffline.isChecked()) {
                selectedMode = ChatbotPrefs.MODE_OFFLINE;
            }
            ChatbotPrefs.setAiMode(this, selectedMode);

            updateStatusHeader();
            Toast.makeText(this, "AI Settings saved!", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void resetChat() {
        if (datasetHelper != null) {
            datasetHelper.resetContext();
        }
        clearAttachedImage();
        messageList.clear();
        messageList.add(new ChatMessage("Hello! I am your AI Assistant powered by Google Gemini and a Supercharged Knowledge Engine. Ask me anything!", false, System.currentTimeMillis(), false, true));
        chatAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }

    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("About Smart Chatbot")
                .setMessage("Smart AI Chatbot v2.0\n\nFeatures:\n• Google Gemini Generative AI (Live cloud responses)\n• Supercharged Deep Offline Knowledge Base (100% offline fallback)\n• Multi-turn conversation context\n• Fast & beautiful Material UI\n\nBuilt with 100% Java for Android.")
                .setPositiveButton("OK", null)
                .show();
    }

    private void logout() {
        ChatbotPrefs.setLoggedIn(this, false, null);
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ChatActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ocrProcessor != null) {
            ocrProcessor.close();
        }
    }
}