package amruta.newproject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecentChatTitleGenerator {

    /**
     * Generates a short, clear title based on the main point of the user's question,
     * preserving the original language and key terms.
     */
    public static String generateTitle(String question, ChatbotDatasetHelper datasetHelper) {
        if (question == null || question.trim().isEmpty()) {
            return "New Conversation";
        }

        String raw = question.trim();

        // 1. Remove trailing question marks and punctuation
        raw = raw.replaceAll("[?!.,;:\"']+$", "").trim();

        // 2. Check for "Difference between X and Y"
        Pattern diffPattern = Pattern.compile("(?i)^(?:what is the difference between|difference between|differences between|compare)\\s+(.+?)\\s+(?:and|vs|with)\\s+(.+)$");
        Matcher diffMatcher = diffPattern.matcher(raw);
        if (diffMatcher.find()) {
            String term1 = capitalizeWords(diffMatcher.group(1).trim());
            String term2 = capitalizeWords(diffMatcher.group(2).trim());
            return term1 + " vs " + term2;
        }

        // 3. Check for "Types of X" or "Explain types of X"
        Pattern typesPattern = Pattern.compile("(?i)^(?:explain (?:its|the)?\\s*types of|what are (?:the)?\\s*types of|types of)\\s+(.+)$");
        Matcher typesMatcher = typesPattern.matcher(raw);
        if (typesMatcher.find()) {
            String topic = capitalizeWords(typesMatcher.group(1).trim());
            return "Types of " + topic;
        }

        // 4. Strip leading conversational/question intros while keeping the core topic and language
        String cleaned = raw;
        cleaned = cleaned.replaceAll("(?i)^(?:can you please explain|please explain to me|can you explain|please explain|tell me about|could you tell me about)\\s+", "");
        cleaned = cleaned.replaceAll("(?i)^(?:what is an?|what are the?|what is the?|what is|whats)\\s+", "");
        cleaned = cleaned.replaceAll("(?i)^(?:define the?|define|definition of the?|definition of)\\s+", "");
        cleaned = cleaned.replaceAll("(?i)^(?:explain about the?|explain about|explain the?|explain)\\s+", "");
        cleaned = cleaned.replaceAll("(?i)^(?:give me an example of|give example of|example of)\\s+", "");
        cleaned = cleaned.replaceAll("(?i)^(?:how does|how do|how to)\\s+", "");

        // 5. Strip trailing multilingual conversational fillers (e.g. Hindi/Urdu question particles)
        cleaned = cleaned.replaceAll("(?i)\\s+(?:kya hai|kya hota hai|ke baare me batao|batao|samjhao)$", "");

        cleaned = cleaned.trim();

        // 6. If concept matches in knowledge bank, check for clean concept name
        if (datasetHelper != null) {
            String norm = datasetHelper.cleanAndNormalize(cleaned);
            List<ChatbotDatasetHelper.MatchedConcept> concepts = datasetHelper.detectConcepts(norm.isEmpty() ? cleaned.toLowerCase() : norm);
            if (concepts != null && !concepts.isEmpty()) {
                ChatbotDatasetHelper.MatchedConcept mc = null;
                for (ChatbotDatasetHelper.MatchedConcept c : concepts) {
                    if (!"algorithm_concept".equals(c.conceptId) && !"programming_language".equals(c.conceptId)) {
                        mc = c;
                        break;
                    }
                }
                if (mc == null) {
                    mc = concepts.get(0);
                }
                if (mc != null && mc.conceptId != null && !mc.conceptId.isEmpty()) {
                    String conceptFormatted = formatConceptId(mc.conceptId);
                    if (conceptFormatted != null && !conceptFormatted.isEmpty()) {
                        // If user asked specifically about types or algorithms, retain that aspect
                        if (raw.toLowerCase().contains("type")) {
                            return "Types of " + conceptFormatted;
                        } else if (raw.toLowerCase().contains("algorithm")) {
                            return conceptFormatted + " Algorithms";
                        }
                        return conceptFormatted;
                    }
                }
            }
        }

        if (cleaned.isEmpty()) {
            cleaned = raw;
        }

        // 7. Limit length and format cleanly
        String[] words = cleaned.split("\\s+");
        if (words.length > 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(5, words.length); i++) {
                if (i > 0) sb.append(" ");
                sb.append(words[i]);
            }
            cleaned = sb.toString();
        }

        String title = capitalizeWords(cleaned);
        if (title.length() > 34) {
            title = title.substring(0, 31).trim() + "...";
        }

        return title;
    }

    private static String formatConceptId(String conceptId) {
        if (conceptId == null) return null;
        switch (conceptId) {
            case "ai": return "Artificial Intelligence (AI)";
            case "ml": case "machine_learning": return "Machine Learning";
            case "dl": case "deep_learning": return "Deep Learning";
            case "nlp": return "Natural Language Processing (NLP)";
            case "cv": case "computer_vision": return "Computer Vision";
            case "supervised_learning": return "Supervised Learning";
            case "unsupervised_learning": return "Unsupervised Learning";
            case "reinforcement_learning": return "Reinforcement Learning";
            case "neural_network": return "Neural Networks";
            case "cnn": return "CNN (Convolutional Networks)";
            case "rnn": return "RNN (Recurrent Networks)";
            case "lstm": return "LSTM Networks";
            case "transformers": return "Transformers";
            case "generative_ai": case "genai": return "Generative AI";
            case "llm": return "Large Language Models";
            case "prompt_engineering": return "Prompt Engineering";
            case "rag": return "RAG (Retrieval Augmented)";
            case "lora": return "LoRA Fine-Tuning";
            case "k_means": return "K-Means Clustering";
            case "knn": return "K-Nearest Neighbors (KNN)";
            case "svm": return "Support Vector Machines (SVM)";
            case "random_forest": return "Random Forest";
            case "decision_tree": return "Decision Trees";
            case "linear_regression": return "Linear Regression";
            case "logistic_regression": return "Logistic Regression";
            case "gradient_descent": return "Gradient Descent";
            case "overfitting": return "Overfitting";
            case "underfitting": return "Underfitting";
            case "bias_variance": return "Bias-Variance Tradeoff";
            case "regularization": return "Regularization (L1/L2)";
            case "cross_validation": return "Cross Validation";
            case "confusion_matrix": return "Confusion Matrix";
            case "data_preprocessing": return "Data Preprocessing";
            case "feature_engineering": return "Feature Engineering";
            case "python": return "Python for AI/ML";
            case "numpy": return "NumPy";
            case "pandas": return "Pandas";
            case "scikit_learn": return "Scikit-Learn";
            case "ai_ethics": case "ai_bias": return "AI Bias & Ethics";
            case "model_evaluation": return "Model Evaluation";
            default:
                String[] parts = conceptId.split("_");
                StringBuilder sb = new StringBuilder();
                for (String part : parts) {
                    if (part.isEmpty()) continue;
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
                }
                return sb.toString();
        }
    }

    private static String capitalizeWords(String text) {
        if (text == null || text.isEmpty()) return "";
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (sb.length() > 0) sb.append(" ");
            if (word.equalsIgnoreCase("ai") || word.equalsIgnoreCase("ml")
                    || word.equalsIgnoreCase("dl") || word.equalsIgnoreCase("nlp")
                    || word.equalsIgnoreCase("cv") || word.equalsIgnoreCase("cnn")
                    || word.equalsIgnoreCase("rnn") || word.equalsIgnoreCase("lstm")
                    || word.equalsIgnoreCase("svm") || word.equalsIgnoreCase("knn")
                    || word.equalsIgnoreCase("rag") || word.equalsIgnoreCase("llm")) {
                sb.append(word.toUpperCase());
            } else if (word.equalsIgnoreCase("vs") || word.equalsIgnoreCase("and") || word.equalsIgnoreCase("of") || word.equalsIgnoreCase("in") || word.equalsIgnoreCase("for")) {
                sb.append(word.toLowerCase());
            } else {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            }
        }
        return sb.toString();
    }
}
