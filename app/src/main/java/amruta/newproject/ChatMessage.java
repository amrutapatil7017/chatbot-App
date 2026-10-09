package amruta.newproject;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatMessage {

    private final String text;
    private final boolean isUser;
    private final long timestamp;
    private final boolean isTyping;
    private final boolean isWelcome;
    private final String imageUri;

    public ChatMessage(String text, boolean isUser, long timestamp) {
        this(text, isUser, timestamp, false, false, null);
    }

    public ChatMessage(String text, String imageUri, boolean isUser, long timestamp) {
        this(text, isUser, timestamp, false, false, imageUri);
    }

    public ChatMessage(String text, Uri imageUri, boolean isUser, long timestamp) {
        this(text, isUser, timestamp, false, false, imageUri != null ? imageUri.toString() : null);
    }

    public ChatMessage(String text, boolean isUser, long timestamp, boolean isTyping, boolean isWelcome) {
        this(text, isUser, timestamp, isTyping, isWelcome, null);
    }

    public ChatMessage(String text, boolean isUser, long timestamp, boolean isTyping, boolean isWelcome, String imageUri) {
        this.text = text;
        this.isUser = isUser;
        this.timestamp = timestamp;
        this.isTyping = isTyping;
        this.isWelcome = isWelcome;
        this.imageUri = imageUri;
    }

    public String getText() {
        return text;
    }

    public boolean isUser() {
        return isUser;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isTyping() {
        return isTyping;
    }

    public boolean isWelcome() {
        return isWelcome;
    }

    public String getImageUri() {
        return imageUri;
    }

    public boolean hasImage() {
        return imageUri != null && !imageUri.isEmpty();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("text", text != null ? text : "");
            json.put("isUser", isUser);
            json.put("timestamp", timestamp);
            json.put("isTyping", isTyping);
            json.put("isWelcome", isWelcome);
            json.put("imageUri", imageUri != null ? imageUri : JSONObject.NULL);
        } catch (JSONException ignored) {}
        return json;
    }

    public static ChatMessage fromJson(JSONObject json) {
        if (json == null) return null;
        try {
            String text = json.optString("text", "");
            boolean isUser = json.optBoolean("isUser", false);
            long timestamp = json.optLong("timestamp", System.currentTimeMillis());
            boolean isTyping = json.optBoolean("isTyping", false);
            boolean isWelcome = json.optBoolean("isWelcome", false);
            String imageUri = json.optString("imageUri", null);
            if ("null".equals(imageUri)) imageUri = null;
            return new ChatMessage(text, isUser, timestamp, isTyping, isWelcome, imageUri);
        } catch (Exception e) {
            return null;
        }
    }
}
