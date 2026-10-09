package amruta.newproject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GeminiApiClient {

    public interface ResponseCallback {
        void onSuccess(String responseText);
        void onError(String errorMessage, boolean isApiKeyIssue);
    }

    public interface TestCallback {
        void onResult(boolean isSuccess, String message);
    }

    private static final String BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/";
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private static GeminiApiClient instance;

    public static synchronized GeminiApiClient getInstance() {
        if (instance == null) {
            instance = new GeminiApiClient();
        }
        return instance;
    }

    /**
     * Checks if active network connectivity is available.
     */
    public boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                return netInfo != null && netInfo.isConnected();
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    /**
     * Sends a conversational query to Google Gemini API with conversational context.
     */
    public void generateResponse(Context context, String userQuery, List<ChatMessage> conversationHistory, ResponseCallback callback) {
        String apiKey = ChatbotPrefs.getGeminiApiKey(context);
        if (apiKey.isEmpty()) {
            mainHandler.post(() -> callback.onError("No Gemini API Key provided. Please enter your API key in Settings.", true));
            return;
        }

        if (!isNetworkAvailable(context)) {
            mainHandler.post(() -> callback.onError("No internet connection detected.", false));
            return;
        }

        String model = ChatbotPrefs.getGeminiModel(context);
        executor.execute(() -> {
            try {
                String requestJson = buildConversationPayload(userQuery, conversationHistory);
                String result = executeApiCall(model, apiKey, requestJson);
                if (result != null) {
                    result = result.replace("**", "");
                }
                final String finalResult = result;
                mainHandler.post(() -> callback.onSuccess(finalResult));
            } catch (ApiException e) {
                Log.e("GeminiApiClient", "Gemini API Exception: " + e.getMessage(), e);
                mainHandler.post(() -> callback.onError(e.getMessage(), e.isApiKeyIssue));
            } catch (Exception e) {
                Log.e("GeminiApiClient", "Unexpected Exception in generateResponse: " + e.getLocalizedMessage(), e);
                mainHandler.post(() -> callback.onError("Network error: " + e.getLocalizedMessage(), false));
            }
        });
    }

    /**
     * Quick test method to verify that an API key works.
     */
    public void testApiKey(String apiKey, TestCallback callback) {
        executor.execute(() -> {
            try {
                JSONObject payload = new JSONObject();
                JSONArray contents = new JSONArray();
                JSONObject turn = new JSONObject();
                turn.put("role", "user");
                JSONArray parts = new JSONArray();
                JSONObject part = new JSONObject();
                part.put("text", "Respond with 'Connected' in one word.");
                parts.put(part);
                turn.put("parts", parts);
                contents.put(turn);
                payload.put("contents", contents);

                executeApiCall(ChatbotPrefs.DEFAULT_MODEL, apiKey.trim(), payload.toString());
                mainHandler.post(() -> callback.onResult(true, "API Key is valid and working!"));
            } catch (ApiException e) {
                Log.e("GeminiApiClient", "Test API Key ApiException: " + e.getMessage(), e);
                mainHandler.post(() -> callback.onResult(false, e.getMessage()));
            } catch (Exception e) {
                Log.e("GeminiApiClient", "Test API Key Exception: " + e.getMessage(), e);
                mainHandler.post(() -> callback.onResult(false, "Connection error: " + e.getMessage()));
            }
        });
    }

    private String buildConversationPayload(String currentQuery, List<ChatMessage> history) throws Exception {
        JSONObject root = new JSONObject();

        // System Instruction to guide the response quality
        JSONObject systemInstruction = new JSONObject();
        JSONArray sysParts = new JSONArray();
        JSONObject sysPart = new JSONObject();
        sysPart.put("text", "You are a Programming Language Educational Chatbot.\n\n" +
                "Your job is to answer questions about ANY programming language and computer science topic.\n\n" +
                "IMPORTANT RULES:\n" +
                "1. Give simple, clear and easy-to-understand answers.\n" +
                "2. Do not give unnecessary long explanations.\n" +
                "3. Answer exactly what the user asks.\n" +
                "4. If the user asks \"Define\", \"Definition\", or \"What is\" for any topic, give a simple and easy-to-understand definition along with a simple example.\n" +
                "5. If the user asks \"Explain\", explain the topic clearly in short points.\n" +
                "6. If the user asks \"Explain its types\", give the types AND explain each type briefly in 2-3 simple sentences. Do not only list the names.\n" +
                "7. If the user asks for an example, give a simple example.\n" +
                "8. For 2-mark questions, give a short 2-mark answer.\n" +
                "9. For 5-mark questions, give a properly explained 5-mark answer.\n" +
                "10. Do not add \"Key Points\", \"Core Pillars\", \"Real-World Examples\", or extra sections unless the user asks for them.\n" +
                "11. Do not repeat the question.\n" +
                "12. Do not use unnecessary emojis.\n" +
                "13. Use simple English suitable for college students.\n" +
                "14. Keep the answer focused on the exact question.\n" +
                "15. DO NOT use double stars (**) on both sides of any word or sentence. Do not use markdown bold formatting. Output plain text without **.\n\n" +
                "Example:\n" +
                "Question: What is Artificial Intelligence?\n" +
                "Answer:\n" +
                "Artificial Intelligence (AI) is a branch of computer science that enables machines to perform tasks that normally require human intelligence, such as learning, reasoning and problem-solving.\n\n" +
                "Example: Chatbots and voice assistants use AI.\n\n" +
                "CONVERSATION & SCOPE RULES:\n" +
                "• Understand questions even when wording differs, spelling is incorrect, abbreviations are used (e.g., OOP, DBMS, OS, ML, CNN, RNN, LLM), or the question is short or a follow-up.\n" +
                "• Maintain conversation context across turns (e.g., follow-ups like 'What are its types?', 'How does it work?', 'Give examples').\n" +
                "• If greeted, respond warmly and politely.\n" +
                "• If the question is completely outside programming languages and computer science, respond politely indicating it is outside the knowledge base.");
        sysParts.put(sysPart);
        systemInstruction.put("parts", sysParts);
        root.put("systemInstruction", systemInstruction);

        // Multi-turn conversational memory (include last 6 non-welcome turns)
        JSONArray contents = new JSONArray();
        if (history != null && !history.isEmpty()) {
            int startIdx = Math.max(0, history.size() - 8);
            for (int i = startIdx; i < history.size(); i++) {
                ChatMessage msg = history.get(i);
                if (msg.isWelcome() || msg.isTyping()) continue;

                JSONObject turn = new JSONObject();
                turn.put("role", msg.isUser() ? "user" : "model");
                JSONArray parts = new JSONArray();
                JSONObject p = new JSONObject();
                p.put("text", msg.getText());
                parts.put(p);
                turn.put("parts", parts);
                contents.put(turn);
            }
        }

        // Add current query
        JSONObject currentTurn = new JSONObject();
        currentTurn.put("role", "user");
        JSONArray curParts = new JSONArray();
        JSONObject curPart = new JSONObject();
        curPart.put("text", currentQuery);
        curParts.put(curPart);
        currentTurn.put("parts", curParts);
        contents.put(currentTurn);

        root.put("contents", contents);

        // Generation configuration
        JSONObject genConfig = new JSONObject();
        genConfig.put("temperature", 0.7);
        genConfig.put("topK", 40);
        genConfig.put("topP", 0.95);
        genConfig.put("maxOutputTokens", 4096);
        root.put("generationConfig", genConfig);

        return root.toString();
    }

    private String executeApiCall(String model, String apiKey, String jsonBody) throws Exception {
        String endpoint = BASE_URL + model + ":generateContent?key=" + apiKey;
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);

            byte[] outputBytes = jsonBody.getBytes(StandardCharsets.UTF_8);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(outputBytes);
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            InputStream is = (responseCode >= 200 && responseCode < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            StringBuilder sb = new StringBuilder();
            if (is != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }
            }

            String responseBody = sb.toString().trim();

            if (responseCode >= 200 && responseCode < 300) {
                return parseSuccessResponse(responseBody);
            } else {
                throw parseErrorResponse(responseCode, responseBody);
            }
        } finally {
            conn.disconnect();
        }
    }

    private String parseSuccessResponse(String jsonString) throws Exception {
        JSONObject root = new JSONObject(jsonString);
        JSONArray candidates = root.optJSONArray("candidates");
        if (candidates != null && candidates.length() > 0) {
            JSONObject candidate = candidates.getJSONObject(0);
            JSONObject content = candidate.optJSONObject("content");
            if (content != null) {
                JSONArray parts = content.optJSONArray("parts");
                if (parts != null && parts.length() > 0) {
                    StringBuilder fullText = new StringBuilder();
                    for (int i = 0; i < parts.length(); i++) {
                        JSONObject part = parts.getJSONObject(i);
                        if (part.has("text")) {
                            fullText.append(part.getString("text"));
                        }
                    }
                    if (fullText.length() > 0) {
                        return fullText.toString().trim();
                    }
                }
            }
        }
        return "I processed your request, but received an empty response.";
    }

    private ApiException parseErrorResponse(int statusCode, String jsonString) {
        String message = "Gemini API error (HTTP " + statusCode + ")";
        boolean isApiKeyIssue = false;
        Log.e("GeminiApiClient", "Gemini API Error Response [HTTP " + statusCode + "]: " + jsonString);

        try {
            JSONObject root = new JSONObject(jsonString);
            JSONObject error = root.optJSONObject("error");
            if (error != null) {
                String errorMsg = error.optString("message", "");
                String status = error.optString("status", "");

                if (statusCode == 400 || statusCode == 403 || status.contains("INVALID_ARGUMENT") || errorMsg.contains("API key")) {
                    isApiKeyIssue = true;
                    message = "Invalid or inactive API Key. Please verify your Gemini API key in Settings.";
                } else if (statusCode == 429) {
                    message = "Gemini quota or rate limit exceeded. Falling back to offline knowledge engine.";
                } else if (!errorMsg.isEmpty()) {
                    message = errorMsg;
                }
            }
        } catch (Exception ignored) {
        }

        return new ApiException(message, isApiKeyIssue);
    }

    private static class ApiException extends Exception {
        final boolean isApiKeyIssue;

        ApiException(String message, boolean isApiKeyIssue) {
            super(message);
            this.isApiKeyIssue = isApiKeyIssue;
        }
    }
}
