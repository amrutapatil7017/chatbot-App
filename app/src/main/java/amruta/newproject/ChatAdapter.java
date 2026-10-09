package amruta.newproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_WELCOME = 0;
    private static final int TYPE_USER = 1;
    private static final int TYPE_BOT = 2;
    private static final int TYPE_TYPING = 3;

    private final List<ChatMessage> messageList;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

    public ChatAdapter(List<ChatMessage> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage message = messageList.get(position);
        if (message.isWelcome()) {
            return TYPE_WELCOME;
        } else if (message.isTyping()) {
            return TYPE_TYPING;
        } else if (message.isUser()) {
            return TYPE_USER;
        } else {
            return TYPE_BOT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        int userMaxTextWidth = (int) (screenWidth * 0.72);
        int botMaxTextWidth = (int) (screenWidth * 0.85);

        if (viewType == TYPE_WELCOME) {
            LinearLayout root = new LinearLayout(context);
            root.setOrientation(LinearLayout.VERTICAL);
            root.setGravity(Gravity.CENTER);
            root.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            int pHoriz = UIUtils.dpToPx(context, 20);
            int pVert = UIUtils.dpToPx(context, 18);
            root.setPadding(pHoriz, pVert, pHoriz, pVert);

            LinearLayout card = new LinearLayout(context);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setGravity(Gravity.CENTER);
            int cardPad = UIUtils.dpToPx(context, 20);
            card.setPadding(cardPad, cardPad, cardPad, cardPad);

            GradientDrawable cardBg = UIUtils.createRoundedDrawable(
                    Color.WHITE, 16, Color.parseColor("#E2E8F0"), 1, context);
            card.setBackground(cardBg);

            ImageView avatar = new ImageView(context);
            int avatarSize = UIUtils.dpToPx(context, 48);
            avatar.setLayoutParams(new LinearLayout.LayoutParams(avatarSize, avatarSize));
            avatar.setImageBitmap(UIUtils.createBotAvatarBitmap(context, 48));

            TextView titleText = new TextView(context);
            titleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            titleText.setTypeface(null, Typeface.BOLD);
            titleText.setTextColor(Color.parseColor("#0F172A"));
            titleText.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams tParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tParams.topMargin = UIUtils.dpToPx(context, 10);
            titleText.setLayoutParams(tParams);

            TextView subtitleText = new TextView(context);
            subtitleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            subtitleText.setTextColor(Color.parseColor("#64748B"));
            subtitleText.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams sParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            sParams.topMargin = UIUtils.dpToPx(context, 4);
            subtitleText.setLayoutParams(sParams);

            card.addView(avatar);
            card.addView(titleText);
            card.addView(subtitleText);

            root.addView(card);
            return new WelcomeViewHolder(root, titleText, subtitleText);

        } else if (viewType == TYPE_USER) {
            LinearLayout root = new LinearLayout(context);
            root.setOrientation(LinearLayout.HORIZONTAL);
            root.setGravity(Gravity.END | Gravity.TOP);
            root.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            int marginHoriz = UIUtils.dpToPx(context, 12);
            int marginVert = UIUtils.dpToPx(context, 6);
            root.setPadding(marginHoriz, marginVert, marginHoriz, marginVert);

            LinearLayout bubble = new LinearLayout(context);
            bubble.setOrientation(LinearLayout.VERTICAL);
            int pHorizontal = UIUtils.dpToPx(context, 14);
            int pVertical = UIUtils.dpToPx(context, 10);
            bubble.setPadding(pHorizontal, pVertical, pHorizontal, pVertical);
            bubble.setBackground(UIUtils.createBubbleDrawable(
                    Color.parseColor("#1E1E1E"), 18, 18, 4, 18, context));

            TextView messageText = new TextView(context);
            messageText.setTextColor(Color.parseColor("#F8FAFC"));
            messageText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            messageText.setSingleLine(false);
            messageText.setMaxWidth(userMaxTextWidth);
            messageText.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            TextView timeText = new TextView(context);
            timeText.setTextColor(Color.parseColor("#94A3B8"));
            timeText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            LinearLayout.LayoutParams timeParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            timeParams.gravity = Gravity.END;
            timeParams.topMargin = UIUtils.dpToPx(context, 4);
            timeText.setLayoutParams(timeParams);

            ImageView imageAttachment = new ImageView(context);
            imageAttachment.setVisibility(View.GONE);
            imageAttachment.setAdjustViewBounds(true);
            imageAttachment.setMaxHeight(UIUtils.dpToPx(context, 200));
            imageAttachment.setScaleType(ImageView.ScaleType.FIT_CENTER);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imgParams.bottomMargin = UIUtils.dpToPx(context, 6);
            imageAttachment.setLayoutParams(imgParams);

            bubble.addView(imageAttachment);
            bubble.addView(messageText);
            bubble.addView(timeText);

            LinearLayout.LayoutParams bubbleParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            bubble.setLayoutParams(bubbleParams);

            ImageView avatar = new ImageView(context);
            int avatarSize = UIUtils.dpToPx(context, 32);
            LinearLayout.LayoutParams avatarParams = new LinearLayout.LayoutParams(avatarSize, avatarSize);
            avatarParams.leftMargin = UIUtils.dpToPx(context, 8);
            avatarParams.topMargin = UIUtils.dpToPx(context, 2);
            avatar.setLayoutParams(avatarParams);
            avatar.setImageBitmap(UIUtils.createUserAvatarBitmap(context, 32));

            root.addView(bubble);
            root.addView(avatar);

            return new MessageViewHolder(root, messageText, timeText, avatar, imageAttachment);

        } else if (viewType == TYPE_TYPING) {
            LinearLayout root = new LinearLayout(context);
            root.setOrientation(LinearLayout.HORIZONTAL);
            root.setGravity(Gravity.START | Gravity.TOP);
            root.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            int marginHoriz = UIUtils.dpToPx(context, 12);
            int marginVert = UIUtils.dpToPx(context, 6);
            root.setPadding(marginHoriz, marginVert, marginHoriz, marginVert);

            ImageView avatar = new ImageView(context);
            int avatarSize = UIUtils.dpToPx(context, 32);
            LinearLayout.LayoutParams avatarParams = new LinearLayout.LayoutParams(avatarSize, avatarSize);
            avatarParams.rightMargin = UIUtils.dpToPx(context, 8);
            avatarParams.topMargin = UIUtils.dpToPx(context, 2);
            avatar.setLayoutParams(avatarParams);
            avatar.setImageBitmap(UIUtils.createBotAvatarBitmap(context, 32));

            LinearLayout bubble = new LinearLayout(context);
            bubble.setOrientation(LinearLayout.HORIZONTAL);
            bubble.setGravity(Gravity.CENTER_VERTICAL);
            int pHorizontal = UIUtils.dpToPx(context, 14);
            int pVertical = UIUtils.dpToPx(context, 10);
            bubble.setPadding(pHorizontal, pVertical, pHorizontal, pVertical);

            GradientDrawable botBubbleBg = UIUtils.createBubbleDrawable(
                    Color.WHITE, 18, 18, 18, 4, context);
            botBubbleBg.setStroke(UIUtils.dpToPx(context, 1), Color.parseColor("#E2E8F0"));
            bubble.setBackground(botBubbleBg);

            TextView typingText = new TextView(context);
            typingText.setText("AI is typing...");
            typingText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            typingText.setTypeface(null, Typeface.BOLD_ITALIC);
            typingText.setTextColor(Color.parseColor("#2563EB"));
            bubble.addView(typingText);

            root.addView(avatar);
            root.addView(bubble);

            return new TypingViewHolder(root, typingText);

        } else { // TYPE_BOT
            LinearLayout root = new LinearLayout(context);
            root.setOrientation(LinearLayout.HORIZONTAL);
            root.setGravity(Gravity.START | Gravity.TOP);
            root.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            int marginHoriz = UIUtils.dpToPx(context, 12);
            int marginVert = UIUtils.dpToPx(context, 6);
            root.setPadding(marginHoriz, marginVert, marginHoriz, marginVert);

            ImageView avatar = new ImageView(context);
            int avatarSize = UIUtils.dpToPx(context, 32);
            LinearLayout.LayoutParams avatarParams = new LinearLayout.LayoutParams(avatarSize, avatarSize);
            avatarParams.rightMargin = UIUtils.dpToPx(context, 8);
            avatarParams.topMargin = UIUtils.dpToPx(context, 2);
            avatar.setLayoutParams(avatarParams);
            avatar.setImageBitmap(UIUtils.createBotAvatarBitmap(context, 32));

            LinearLayout bubble = new LinearLayout(context);
            bubble.setOrientation(LinearLayout.VERTICAL);
            int pHorizontal = UIUtils.dpToPx(context, 14);
            int pVertical = UIUtils.dpToPx(context, 10);
            bubble.setPadding(pHorizontal, pVertical, pHorizontal, pVertical);

            GradientDrawable botBubbleBg = UIUtils.createBubbleDrawable(
                    Color.WHITE, 18, 18, 18, 4, context);
            botBubbleBg.setStroke(UIUtils.dpToPx(context, 1), Color.parseColor("#E2E8F0"));
            bubble.setBackground(botBubbleBg);

            TextView messageText = new TextView(context);
            messageText.setTextColor(Color.parseColor("#0F172A"));
            messageText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            messageText.setSingleLine(false);
            messageText.setMaxWidth(botMaxTextWidth);
            messageText.setTextIsSelectable(true);
            messageText.setLineSpacing(UIUtils.dpToPx(context, 3), 1.15f);
            messageText.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            TextView timeText = new TextView(context);
            timeText.setTextColor(Color.parseColor("#64748B"));
            timeText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            LinearLayout.LayoutParams timeParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            timeParams.gravity = Gravity.START;
            timeParams.topMargin = UIUtils.dpToPx(context, 4);
            timeText.setLayoutParams(timeParams);

            bubble.addView(messageText);
            bubble.addView(timeText);

            LinearLayout.LayoutParams bubbleParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            bubble.setLayoutParams(bubbleParams);

            root.addView(avatar);
            root.addView(bubble);

            return new MessageViewHolder(root, messageText, timeText, avatar, null);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = messageList.get(position);
        if (holder instanceof WelcomeViewHolder) {
            WelcomeViewHolder wHolder = (WelcomeViewHolder) holder;
            wHolder.titleText.setText(message.getText());
            wHolder.subtitleText.setText("Ask me anything");
        } else if (holder instanceof MessageViewHolder) {
            MessageViewHolder mHolder = (MessageViewHolder) holder;

            // Handle image attachment
            if (mHolder.imageAttachment != null) {
                if (message.hasImage()) {
                    mHolder.imageAttachment.setVisibility(View.VISIBLE);
                    try {
                        android.net.Uri uri = android.net.Uri.parse(message.getImageUri());
                        android.graphics.Bitmap thumb = ImageProcessor.decodeThumbnail(mHolder.itemView.getContext(), uri);
                        if (thumb != null) {
                            mHolder.imageAttachment.setImageBitmap(thumb);
                        } else {
                            mHolder.imageAttachment.setImageURI(uri);
                        }
                    } catch (Exception e) {
                        mHolder.imageAttachment.setVisibility(View.GONE);
                    }
                } else {
                    mHolder.imageAttachment.setVisibility(View.GONE);
                }
            }

            // Message text
            if (message.getText() != null && !message.getText().trim().isEmpty()) {
                mHolder.messageText.setVisibility(View.VISIBLE);
                mHolder.messageText.setText(message.getText());
            } else if (message.hasImage()) {
                mHolder.messageText.setVisibility(View.GONE);
            } else {
                mHolder.messageText.setVisibility(View.VISIBLE);
                mHolder.messageText.setText("");
            }

            mHolder.timeText.setText(timeFormat.format(new Date(message.getTimestamp())));
        } else if (holder instanceof TypingViewHolder) {
            TypingViewHolder tHolder = (TypingViewHolder) holder;
            if (message.getText() != null && !message.getText().isEmpty()) {
                tHolder.typingText.setText(message.getText());
            } else {
                tHolder.typingText.setText("AI is thinking...");
            }
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        public final TextView messageText;
        public final TextView timeText;
        public final ImageView avatar;
        public final ImageView imageAttachment;

        public MessageViewHolder(@NonNull View itemView, TextView messageText, TextView timeText, ImageView avatar, ImageView imageAttachment) {
            super(itemView);
            this.messageText = messageText;
            this.timeText = timeText;
            this.avatar = avatar;
            this.imageAttachment = imageAttachment;
        }
    }

    public static class WelcomeViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleText;
        public final TextView subtitleText;

        public WelcomeViewHolder(@NonNull View itemView, TextView titleText, TextView subtitleText) {
            super(itemView);
            this.titleText = titleText;
            this.subtitleText = subtitleText;
        }
    }

    public static class TypingViewHolder extends RecyclerView.ViewHolder {
        public final TextView typingText;

        public TypingViewHolder(@NonNull View itemView, TextView typingText) {
            super(itemView);
            this.typingText = typingText;
        }
    }
}