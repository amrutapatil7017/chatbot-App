package amruta.newproject;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ChatbotPrefs {

    private static final String PREF_NAME = "chatbot_ai_preferences";
    private static final String KEY_GEMINI_API_KEY = "gemini_api_key";
    private static final String KEY_AI_MODE = "ai_mode";
    private static final String KEY_GEMINI_MODEL = "gemini_model";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";
    private static final String KEY_LOGGED_IN_PHONE = "logged_in_phone";

    public static final String MODE_AUTO = "auto";       // Gemini with offline fallback (recommended)
    public static final String MODE_GEMINI = "gemini";   // Gemini only
    public static final String MODE_OFFLINE = "offline"; // Offline Knowledge Engine only

    public static final String DEFAULT_MODEL = "gemini-1.5-flash";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static boolean isLoggedIn(Context context) {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public static void setLoggedIn(Context context, boolean isLoggedIn, String phone) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        if (isLoggedIn && phone != null) {
            editor.putString(KEY_LOGGED_IN_PHONE, phone.trim());
        } else if (!isLoggedIn) {
            editor.remove(KEY_LOGGED_IN_PHONE);
        }
        editor.apply();
    }

    public static String getLoggedInPhone(Context context) {
        return getPrefs(context).getString(KEY_LOGGED_IN_PHONE, "");
    }

    public static String getGeminiApiKey(Context context) {
        return getPrefs(context).getString(KEY_GEMINI_API_KEY, "").trim();
    }

    public static void setGeminiApiKey(Context context, String apiKey) {
        getPrefs(context).edit().putString(KEY_GEMINI_API_KEY, apiKey != null ? apiKey.trim() : "").apply();
    }

    public static boolean hasGeminiApiKey(Context context) {
        return !getGeminiApiKey(context).isEmpty();
    }

    public static String getAiMode(Context context) {
        return getPrefs(context).getString(KEY_AI_MODE, MODE_AUTO);
    }

    public static void setAiMode(Context context, String mode) {
        getPrefs(context).edit().putString(KEY_AI_MODE, mode).apply();
    }

    public static String getGeminiModel(Context context) {
        return getPrefs(context).getString(KEY_GEMINI_MODEL, DEFAULT_MODEL);
    }

    public static void setGeminiModel(Context context, String model) {
        getPrefs(context).edit().putString(KEY_GEMINI_MODEL, model).apply();
    }

    private static final String KEY_RECENT_CHATS = "recent_chats_json";
    private static final String KEY_CONVERSATIONS_PREFIX = "chat_conv_";

    public static List<RecentChat> getRecentChats(Context context) {
        List<RecentChat> list = new ArrayList<>();
        String jsonStr = getPrefs(context).getString(KEY_RECENT_CHATS, "");
        if (!jsonStr.isEmpty()) {
            try {
                JSONArray array = new JSONArray(jsonStr);
                for (int i = 0; i < array.length(); i++) {
                    RecentChat item = RecentChat.fromJson(array.optJSONObject(i));
                    if (item != null) {
                        list.add(item);
                    }
                }
            } catch (Exception ignored) {}
        }
        return list;
    }

    public static void saveRecentChats(Context context, List<RecentChat> list) {
        try {
            JSONArray array = new JSONArray();
            for (RecentChat item : list) {
                array.put(item.toJson());
            }
            getPrefs(context).edit().putString(KEY_RECENT_CHATS, array.toString()).apply();
        } catch (Exception ignored) {}
    }

    public static List<ChatMessage> getConversationMessages(Context context, String chatId) {
        List<ChatMessage> list = new ArrayList<>();
        // 1. Try dedicated conversation preference
        String jsonStr = getPrefs(context).getString(KEY_CONVERSATIONS_PREFIX + chatId, "");
        if (!jsonStr.isEmpty()) {
            try {
                JSONArray array = new JSONArray(jsonStr);
                for (int i = 0; i < array.length(); i++) {
                    ChatMessage item = ChatMessage.fromJson(array.optJSONObject(i));
                    if (item != null) {
                        list.add(item);
                    }
                }
            } catch (Exception ignored) {}
        }

        // 2. Fallback: check RecentChat object messages
        if (list.isEmpty()) {
            List<RecentChat> recents = getRecentChats(context);
            for (RecentChat rc : recents) {
                if (rc.id.equals(chatId) && rc.messages != null && !rc.messages.isEmpty()) {
                    list.addAll(rc.messages);
                    break;
                }
            }
        }
        return list;
    }

    public static void saveConversationMessages(Context context, String chatId, List<ChatMessage> messages) {
        try {
            JSONArray array = new JSONArray();
            if (messages != null) {
                for (ChatMessage item : messages) {
                    if (!item.isTyping()) {
                        array.put(item.toJson());
                    }
                }
            }
            getPrefs(context).edit().putString(KEY_CONVERSATIONS_PREFIX + chatId, array.toString()).apply();
        } catch (Exception ignored) {}
    }

    public static void addRecentChat(Context context, String chatId, String question, String title, List<ChatMessage> messages) {
        if (question == null || question.trim().isEmpty()) return;
        List<RecentChat> list = getRecentChats(context);

        // Remove previous entry if matching id or question
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).id.equals(chatId) || list.get(i).question.equalsIgnoreCase(question.trim())
                    || list.get(i).title.equalsIgnoreCase(title.trim())) {
                list.remove(i);
            }
        }

        // Save messages in conversation storage
        saveConversationMessages(context, chatId, messages);

        // Add newest to the top (index 0)
        list.add(0, new RecentChat(chatId, title, question.trim(), System.currentTimeMillis(), messages));

        // Keep up to 50 recent entries
        while (list.size() > 50) {
            list.remove(list.size() - 1);
        }

        saveRecentChats(context, list);
    }

    // Backward compatibility helper
    public static void addRecentChat(Context context, String question, String title) {
        String id = String.valueOf(System.currentTimeMillis());
        List<ChatMessage> defaultMsgs = new ArrayList<>();
        defaultMsgs.add(new ChatMessage(question, true, System.currentTimeMillis()));
        addRecentChat(context, id, question, title, defaultMsgs);
    }

    public static void deleteRecentChat(Context context, String id) {
        List<RecentChat> list = getRecentChats(context);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).id.equals(id)) {
                list.remove(i);
                break;
            }
        }
        getPrefs(context).edit().remove(KEY_CONVERSATIONS_PREFIX + id).apply();
        saveRecentChats(context, list);
    }

    public static void clearRecentChats(Context context) {
        List<RecentChat> list = getRecentChats(context);
        SharedPreferences.Editor editor = getPrefs(context).edit();
        for (RecentChat rc : list) {
            editor.remove(KEY_CONVERSATIONS_PREFIX + rc.id);
        }
        editor.remove(KEY_RECENT_CHATS);
        editor.apply();
    }
}
