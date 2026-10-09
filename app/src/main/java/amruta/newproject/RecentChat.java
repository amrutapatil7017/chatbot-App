package amruta.newproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecentChat {
    public String id;
    public String title;
    public String question;
    public long timestamp;
    public List<ChatMessage> messages;

    public RecentChat(String id, String title, String question, long timestamp) {
        this(id, title, question, timestamp, new ArrayList<>());
    }

    public RecentChat(String id, String title, String question, long timestamp, List<ChatMessage> messages) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.timestamp = timestamp;
        this.messages = messages != null ? messages : new ArrayList<>();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("title", title);
            json.put("question", question);
            json.put("timestamp", timestamp);

            JSONArray msgArray = new JSONArray();
            if (messages != null) {
                for (ChatMessage msg : messages) {
                    msgArray.put(msg.toJson());
                }
            }
            json.put("messages", msgArray);
        } catch (JSONException ignored) {}
        return json;
    }

    public static RecentChat fromJson(JSONObject json) {
        if (json == null) return null;
        try {
            String id = json.optString("id", String.valueOf(System.currentTimeMillis()));
            String title = json.optString("title", "Recent Question");
            String question = json.optString("question", "");
            long timestamp = json.optLong("timestamp", System.currentTimeMillis());

            List<ChatMessage> msgs = new ArrayList<>();
            JSONArray msgArray = json.optJSONArray("messages");
            if (msgArray != null) {
                for (int i = 0; i < msgArray.length(); i++) {
                    JSONObject mObj = msgArray.optJSONObject(i);
                    ChatMessage m = ChatMessage.fromJson(mObj);
                    if (m != null) {
                        msgs.add(m);
                    }
                }
            }
            return new RecentChat(id, title, question, timestamp, msgs);
        } catch (Exception e) {
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
