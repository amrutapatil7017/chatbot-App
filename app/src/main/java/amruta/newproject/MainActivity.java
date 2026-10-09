package amruta.newproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText phoneEditText;
    private EditText passwordEditText;
    private TextView errorTextView;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user session is already authenticated (One-Time Login check)
        if (ChatbotPrefs.isLoggedIn(this)) {
            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
            finish(); // Bypass login screen directly to chatbot home
            return;
        }

        // Root ScrollView
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(Color.parseColor("#F8FAFC")); // Clean light background

        // Main Vertical Container
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        int paddingHoriz = UIUtils.dpToPx(this, 28);
        int paddingVert = UIUtils.dpToPx(this, 32);
        mainLayout.setPadding(paddingHoriz, paddingVert, paddingHoriz, paddingVert);

        // System insets handling for edge-to-edge padding
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(paddingHoriz, systemBars.top + paddingVert, paddingHoriz, systemBars.bottom + paddingVert);
            return insets;
        });

        // 1. ChAI Logo with Full Text
        BotLogoView logoView = new BotLogoView(this);
        logoView.setShowText(true);
        int logoSize = UIUtils.dpToPx(this, 110);
        LinearLayout.LayoutParams logoParams = new LinearLayout.LayoutParams(logoSize, logoSize);
        logoParams.bottomMargin = UIUtils.dpToPx(this, 16);
        logoView.setLayoutParams(logoParams);
        mainLayout.addView(logoView);

        // 2. Title: ChAI
        TextView titleText = new TextView(this);
        titleText.setText("ChAI");
        titleText.setTextSize(26);
        titleText.setTypeface(null, Typeface.BOLD);
        titleText.setTextColor(Color.parseColor("#0F172A")); // Dark slate
        titleText.setGravity(Gravity.CENTER);
        mainLayout.addView(titleText);

        // 3. Subtitle: Your Smart AI Assistant
        TextView subtitleText = new TextView(this);
        subtitleText.setText("Your Smart AI Assistant");
        subtitleText.setTextSize(14);
        subtitleText.setTextColor(Color.parseColor("#64748B")); // Muted gray
        subtitleText.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        subtitleParams.bottomMargin = UIUtils.dpToPx(this, 32);
        subtitleText.setLayoutParams(subtitleParams);
        mainLayout.addView(subtitleText);

        // 4. Phone Number Label & Field
        TextView phoneLabel = new TextView(this);
        phoneLabel.setText("Phone Number");
        phoneLabel.setTextSize(13);
        phoneLabel.setTypeface(null, Typeface.BOLD);
        phoneLabel.setTextColor(Color.parseColor("#334155"));
        LinearLayout.LayoutParams phoneLabelParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        phoneLabelParams.bottomMargin = UIUtils.dpToPx(this, 6);
        phoneLabel.setLayoutParams(phoneLabelParams);
        mainLayout.addView(phoneLabel);

        // Phone Input Container with Country Code
        LinearLayout phoneContainer = new LinearLayout(this);
        phoneContainer.setOrientation(LinearLayout.HORIZONTAL);
        phoneContainer.setGravity(Gravity.CENTER_VERTICAL);
        phoneContainer.setBackground(UIUtils.createRoundedDrawable(
                Color.WHITE, 12, Color.parseColor("#CBD5E1"), 1, this));
        LinearLayout.LayoutParams phoneContainerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        phoneContainerParams.bottomMargin = UIUtils.dpToPx(this, 16);
        phoneContainer.setLayoutParams(phoneContainerParams);

        // Default Country Code: +91
        TextView codeTextView = new TextView(this);
        codeTextView.setText("+91");
        codeTextView.setTextSize(14);
        codeTextView.setTypeface(null, Typeface.BOLD);
        codeTextView.setTextColor(Color.parseColor("#1E293B"));
        int codePaddingHoriz = UIUtils.dpToPx(this, 14);
        int codePaddingVert = UIUtils.dpToPx(this, 12);
        codeTextView.setPadding(codePaddingHoriz, codePaddingVert, codePaddingHoriz, codePaddingVert);

        // Phone EditText
        phoneEditText = new EditText(this);
        phoneEditText.setHint("Enter phone number");
        phoneEditText.setHintTextColor(Color.parseColor("#94A3B8"));
        phoneEditText.setTextColor(Color.parseColor("#0F172A"));
        phoneEditText.setTextSize(14);
        phoneEditText.setSingleLine(true);
        phoneEditText.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneEditText.setBackground(null);
        int inputPadding = UIUtils.dpToPx(this, 12);
        phoneEditText.setPadding(inputPadding, inputPadding, inputPadding, inputPadding);
        LinearLayout.LayoutParams phoneEditParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        phoneEditText.setLayoutParams(phoneEditParams);

        phoneContainer.addView(codeTextView);
        phoneContainer.addView(phoneEditText);
        mainLayout.addView(phoneContainer);

        // 5. Password Label & Field with Show/Hide Toggle
        TextView passwordLabel = new TextView(this);
        passwordLabel.setText("Password");
        passwordLabel.setTextSize(13);
        passwordLabel.setTypeface(null, Typeface.BOLD);
        passwordLabel.setTextColor(Color.parseColor("#334155"));
        LinearLayout.LayoutParams passLabelParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        passLabelParams.bottomMargin = UIUtils.dpToPx(this, 6);
        passwordLabel.setLayoutParams(passLabelParams);
        mainLayout.addView(passwordLabel);

        // Password Container
        LinearLayout passwordContainer = new LinearLayout(this);
        passwordContainer.setOrientation(LinearLayout.HORIZONTAL);
        passwordContainer.setGravity(Gravity.CENTER_VERTICAL);
        passwordContainer.setBackground(UIUtils.createRoundedDrawable(
                Color.WHITE, 12, Color.parseColor("#CBD5E1"), 1, this));
        LinearLayout.LayoutParams passwordContainerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        passwordContainerParams.bottomMargin = UIUtils.dpToPx(this, 8);
        passwordContainer.setLayoutParams(passwordContainerParams);

        passwordEditText = new EditText(this);
        passwordEditText.setHint("Enter password");
        passwordEditText.setHintTextColor(Color.parseColor("#94A3B8"));
        passwordEditText.setTextColor(Color.parseColor("#0F172A"));
        passwordEditText.setTextSize(14);
        passwordEditText.setSingleLine(true);
        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordEditText.setBackground(null);
        passwordEditText.setPadding(inputPadding, inputPadding, inputPadding, inputPadding);
        LinearLayout.LayoutParams passEditParams = new LinearLayout.LayoutParams(
                0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        passwordEditText.setLayoutParams(passEditParams);

        // Eye Toggle Icon
        ImageView eyeIcon = new ImageView(this);
        int eyeSize = UIUtils.dpToPx(this, 36);
        LinearLayout.LayoutParams eyeParams = new LinearLayout.LayoutParams(eyeSize, eyeSize);
        eyeParams.rightMargin = UIUtils.dpToPx(this, 8);
        eyeIcon.setLayoutParams(eyeParams);
        eyeIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        eyeIcon.setImageBitmap(UIUtils.createEyeIconBitmap(this, 20, false, Color.parseColor("#94A3B8")));

        eyeIcon.setOnClickListener(v -> {
            isPasswordVisible = !isPasswordVisible;
            if (isPasswordVisible) {
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                eyeIcon.setImageBitmap(UIUtils.createEyeIconBitmap(this, 20, true, Color.parseColor("#0D9488")));
            } else {
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                eyeIcon.setImageBitmap(UIUtils.createEyeIconBitmap(this, 20, false, Color.parseColor("#94A3B8")));
            }
            passwordEditText.setSelection(passwordEditText.getText().length());
        });

        passwordContainer.addView(passwordEditText);
        passwordContainer.addView(eyeIcon);
        mainLayout.addView(passwordContainer);

        // 6. "Forgot Password?" Text
        TextView forgotPasswordText = new TextView(this);
        forgotPasswordText.setText("Forgot Password?");
        forgotPasswordText.setTextSize(13);
        forgotPasswordText.setTypeface(null, Typeface.BOLD);
        forgotPasswordText.setTextColor(Color.parseColor("#0D9488")); // Teal accent
        forgotPasswordText.setGravity(Gravity.END);
        LinearLayout.LayoutParams forgotParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        forgotParams.bottomMargin = UIUtils.dpToPx(this, 20);
        forgotPasswordText.setLayoutParams(forgotParams);
        forgotPasswordText.setOnClickListener(v ->
                Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        );
        mainLayout.addView(forgotPasswordText);

        // Error TextView
        errorTextView = new TextView(this);
        errorTextView.setText("Please enter a valid phone number and password.");
        errorTextView.setTextColor(Color.parseColor("#EF4444")); // Red
        errorTextView.setTextSize(13);
        errorTextView.setVisibility(View.GONE);
        LinearLayout.LayoutParams errorParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        errorParams.bottomMargin = UIUtils.dpToPx(this, 12);
        errorTextView.setLayoutParams(errorParams);
        mainLayout.addView(errorTextView);

        // 7. "Sign In" Button
        Button signInButton = new Button(this);
        signInButton.setText("Sign In");
        signInButton.setTextSize(16);
        signInButton.setTypeface(null, Typeface.BOLD);
        signInButton.setTextColor(Color.WHITE);
        signInButton.setAllCaps(false);
        signInButton.setBackground(UIUtils.createButtonDrawable(
                Color.parseColor("#0D9488"), Color.parseColor("#0F766E"), 12, this));
        LinearLayout.LayoutParams signInParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dpToPx(this, 48));
        signInButton.setLayoutParams(signInParams);
        mainLayout.addView(signInButton);

        // 8. "Don't have an account? Sign Up" Text
        LinearLayout signUpLayout = new LinearLayout(this);
        signUpLayout.setOrientation(LinearLayout.HORIZONTAL);
        signUpLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams signUpParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        signUpParams.topMargin = UIUtils.dpToPx(this, 24);
        signUpLayout.setLayoutParams(signUpParams);

        TextView noAccountText = new TextView(this);
        noAccountText.setText("Don't have an account? ");
        noAccountText.setTextSize(13);
        noAccountText.setTextColor(Color.parseColor("#64748B"));

        TextView signUpText = new TextView(this);
        signUpText.setText("Sign Up");
        signUpText.setTextSize(13);
        signUpText.setTypeface(null, Typeface.BOLD);
        signUpText.setTextColor(Color.parseColor("#0D9488")); // Teal accent

        signUpLayout.addView(noAccountText);
        signUpLayout.addView(signUpText);

        signUpLayout.setOnClickListener(v ->
                Toast.makeText(this, "Sign Up clicked", Toast.LENGTH_SHORT).show()
        );
        mainLayout.addView(signUpLayout);

        scrollView.addView(mainLayout);
        setContentView(scrollView);

        // Sign In Listener
        signInButton.setOnClickListener(v -> performSignIn());
    }

    private void performSignIn() {
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(phone) && phone.length() >= 7 && !TextUtils.isEmpty(password)) {
            errorTextView.setVisibility(View.GONE);
            // Save persistent login session
            ChatbotPrefs.setLoggedIn(this, true, phone);
            Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
            finish(); // Close login screen
        } else {
            errorTextView.setText("Please enter a valid phone number and password.");
            errorTextView.setVisibility(View.VISIBLE);
        }
    }
}
