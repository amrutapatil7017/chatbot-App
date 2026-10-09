package amruta.newproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ImageQuestionMatcher
 * Bridges offline OCR text extraction with the local NLP Machine Learning Knowledge Base.
 * 
 * Analyzes:
 * - Screenshots of ML questions
 * - ML workflow diagrams & flowcharts
 * - Algorithm architecture diagrams
 * - ML / Python code screenshots
 * - Formulas, graphs, and confusion matrix tables
 * 
 * Works 100% OFFLINE without any cloud APIs or internet connection.
 */
public class ImageQuestionMatcher {

    /**
     * Main entry point to process an image's OCR text along with an optional user question.
     *
     * @param ocrText       Text extracted from the image by on-device OCR.
     * @param userQuestion  Optional text question typed by the user (e.g. "Explain this", "What is this diagram?").
     * @param datasetHelper Local NLP knowledge assistant.
     * @return Comprehensive, easy-to-understand explanation based on offline ML knowledge.
     */
    public static String analyzeImageContent(String ocrText, String userQuestion, ChatbotDatasetHelper datasetHelper) {
        String cleanOcr = ocrText != null ? ocrText.trim() : "";
        String cleanUser = userQuestion != null ? userQuestion.trim() : "";

        // Case 1: No readable text extracted by OCR
        if (cleanOcr.isEmpty()) {
            if (!cleanUser.isEmpty() && !isGenericImagePrompt(cleanUser)) {
                // User asked a specific question; answer it and mention image was unreadable
                String ans = datasetHelper.getAnswer(cleanUser);
                return "📷 **Image Analysis:**\n" +
                        "No readable text or ML diagram labels could be extracted from this image.\n\n" +
                        "**Regarding your question:**\n\n" + ans +
                        "\n\n*(Note: On-device offline OCR requires clear, readable text or labeled diagram boxes to interpret images).*";
            } else {
                return "📷 **Image Analysis Result:**\n\n" +
                        "I could not detect any readable text, labels, or formulas in this image.\n\n" +
                        "💡 **Tips for best offline results:**\n" +
                        "• Ensure the diagram, formula, or question is well-lit and not blurry.\n" +
                        "• Crop closely around the Machine Learning diagram or question.\n" +
                        "• Make sure text labels (e.g., *'Supervised Learning'*, *'Training Data'*, *'Model'*) are visible.\n\n" +
                        "*Limitation Note: This chatbot runs completely offline on your device using on-device OCR and local NLP. It cannot visually perceive abstract shapes or graphics that lack readable text labels.*";
            }
        }

        // Case 2: Detect if image contains ML / Python Code
        if (isCodeSnippet(cleanOcr)) {
            return handleCodeScreenshot(cleanOcr, cleanUser, datasetHelper);
        }

        // Case 3: Detect if image is an ML Workflow / Pipeline / Architecture Diagram
        if (isDiagramOrFlowchart(cleanOcr)) {
            return handleDiagramOrFlowchart(cleanOcr, cleanUser, datasetHelper);
        }

        // Case 4: Detect if image is an Evaluation Table or Confusion Matrix
        if (isConfusionMatrixOrTable(cleanOcr)) {
            return handleEvaluationTable(cleanOcr, cleanUser, datasetHelper);
        }

        // Case 5: Text contains a direct ML Question (e.g. "What is supervised learning?")
        String extractedQuestion = extractQuestionFromText(cleanOcr);
        if (extractedQuestion != null && !extractedQuestion.isEmpty()) {
            String ans = datasetHelper.getAnswer(extractedQuestion);
            if (!ans.equals(ChatbotDatasetHelper.FALLBACK_MESSAGE)) {
                StringBuilder sb = new StringBuilder();
                sb.append("📷 **Recognized Question from Image:**\n");
                sb.append("👉 *\"").append(extractedQuestion).append("\"*\n\n");
                sb.append(ans).append("\n\n");
                sb.append("*(⚡ Processed locally using on-device OCR and offline ML Knowledge Base)*");
                return sb.toString();
            }
        }

        // Case 6: Identify ML Concepts present in OCR text
        List<String> matchedConcepts = findConceptsInText(cleanOcr, datasetHelper);

        if (!matchedConcepts.isEmpty()) {
            return handleMatchedConcepts(cleanOcr, cleanUser, matchedConcepts, datasetHelper);
        }

        // Case 7: Text was found, but no ML concepts were recognized
        if (!cleanUser.isEmpty() && !isGenericImagePrompt(cleanUser)) {
            // Try answering user's question directly
            String ans = datasetHelper.getAnswer(cleanUser);
            if (!ans.equals(ChatbotDatasetHelper.FALLBACK_MESSAGE)) {
                return "📷 **Image Text Extracted:**\n*\"" + previewText(cleanOcr, 120) + "\"*\n\n" +
                        "**Answer to your question:**\n\n" + ans;
            }
        }

        return "📷 **Image Text Detected (Non-ML Content):**\n\n" +
                "The on-device OCR extracted the following text:\n" +
                "> *\"" + previewText(cleanOcr, 160) + "\"*\n\n" +
                "⚠️ I could not identify any Machine Learning concepts, algorithms, or formulas in this text.\n\n" +
                "Please upload an image featuring an **ML diagram**, **algorithm chart**, **code screenshot**, or **ML exam question**.";
    }

    /**
     * Checks if a user prompt is generic (e.g., "Explain this", "What is this image?").
     */
    public static boolean isGenericImagePrompt(String query) {
        if (query == null || query.trim().isEmpty()) return true;
        String q = query.toLowerCase(Locale.ROOT).trim();
        return q.matches("^(explain( this)?( image| diagram| photo| picture)?|what is this( diagram| image)?|tell me about this|read this|analyze this|help with this|check this|explain)\\??$");
    }

    /**
     * Checks if OCR text looks like Python or Machine Learning code.
     */
    private static boolean isCodeSnippet(String text) {
        String lower = text.toLowerCase(Locale.ROOT);
        int codeScore = 0;
        if (lower.contains("import ") || lower.contains("from ")) codeScore += 2;
        if (lower.contains("def ") || lower.contains("return ")) codeScore += 2;
        if (lower.contains("sklearn") || lower.contains("scikit-learn")) codeScore += 3;
        if (lower.contains("pandas") || lower.contains("pd.")) codeScore += 2;
        if (lower.contains("numpy") || lower.contains("np.")) codeScore += 2;
        if (lower.contains("tensorflow") || lower.contains("tf.") || lower.contains("keras")) codeScore += 3;
        if (lower.contains("torch") || lower.contains("nn.module")) codeScore += 3;
        if (lower.contains(".fit(") || lower.contains(".predict(")) codeScore += 3;
        if (lower.contains("train_test_split")) codeScore += 3;
        if (lower.contains("plt.") || lower.contains("matplotlib") || lower.contains("sns.")) codeScore += 2;
        return codeScore >= 3;
    }

    /**
     * Handles code screenshot understanding.
     */
    private static String handleCodeScreenshot(String ocrText, String userQuery, ChatbotDatasetHelper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append("💻 **Machine Learning Code Detected in Image**\n\n");

        List<String> detectedLibraries = new ArrayList<>();
        String lower = ocrText.toLowerCase(Locale.ROOT);
        if (lower.contains("sklearn") || lower.contains("scikit")) detectedLibraries.add("Scikit-Learn (Machine Learning library)");
        if (lower.contains("pandas") || lower.contains("pd.")) detectedLibraries.add("Pandas (Data manipulation & DataFrames)");
        if (lower.contains("numpy") || lower.contains("np.")) detectedLibraries.add("NumPy (Numerical arrays & matrices)");
        if (lower.contains("tensorflow") || lower.contains("keras")) detectedLibraries.add("TensorFlow / Keras (Deep Learning)");
        if (lower.contains("torch")) detectedLibraries.add("PyTorch (Deep Learning framework)");
        if (lower.contains("matplotlib") || lower.contains("plt.")) detectedLibraries.add("Matplotlib (Data visualization)");
        if (lower.contains("seaborn") || lower.contains("sns.")) detectedLibraries.add("Seaborn (Statistical visualization)");

        if (!detectedLibraries.isEmpty()) {
            sb.append("📦 **Identified Libraries:**\n");
            for (String lib : detectedLibraries) {
                sb.append("• ").append(lib).append("\n");
            }
            sb.append("\n");
        }

        // Identify key ML functions used
        sb.append("⚙️ **Key Workflow Steps in Code:**\n");
        if (lower.contains("train_test_split")) {
            sb.append("• `train_test_split`: Splits data into training and testing partitions to evaluate model generalization.\n");
        }
        if (lower.contains(".fit(")) {
            sb.append("• `.fit(X, y)`: Trains the machine learning algorithm on features and target labels.\n");
        }
        if (lower.contains(".predict(")) {
            sb.append("• `.predict(X)`: Generates predictions on unseen test feature vectors.\n");
        }
        if (lower.contains("standardscaler") || lower.contains("minmaxscaler")) {
            sb.append("• Feature Scaling: Normalizes / standardizes feature scales to optimize model convergence.\n");
        }
        sb.append("\n");

        // Identify primary algorithm in code
        List<String> concepts = findConceptsInText(ocrText, helper);
        if (!concepts.isEmpty()) {
            String primary = concepts.get(0);
            String rich = DeepKnowledgeBank.getRichExplanation(primary);
            if (rich != null) {
                sb.append("🧠 **Core Algorithm Concept:**\n\n").append(rich).append("\n\n");
            }
        }

        sb.append("*(⚡ Extracted locally via on-device OCR - 100% offline)*");
        return sb.toString();
    }

    /**
     * Detects if the image text represents a machine learning workflow, pipeline, or architecture.
     */
    private static boolean isDiagramOrFlowchart(String text) {
        String lower = text.toLowerCase(Locale.ROOT);
        int diagramSignals = 0;
        String[] terms = {
                "training data", "test data", "features", "labels", "raw data", "data preprocessing",
                "model", "learning algorithm", "prediction", "predictions", "evaluation",
                "input layer", "hidden layer", "output layer", "weights", "biases",
                "convolution", "pooling", "encoder", "decoder", "feedforward", "backpropagation",
                "cluster", "clusters", "centroid", "hyperplane", "decision node", "root node"
        };
        for (String t : terms) {
            if (lower.contains(t)) diagramSignals++;
        }
        return diagramSignals >= 2;
    }

    /**
     * Handles ML diagrams, flowcharts, and architecture images.
     */
    private static String handleDiagramOrFlowchart(String ocrText, String userQuery, ChatbotDatasetHelper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 **Machine Learning Diagram / Flowchart Detected**\n\n");

        List<String> matchedTerms = new ArrayList<>();
        String lower = ocrText.toLowerCase(Locale.ROOT);
        String[] candidateLabels = {
                "Raw Data", "Preprocessing", "Training Data", "Testing Data", "Validation Data",
                "Feature Extraction", "Features", "Labels", "Machine Learning Algorithm",
                "Trained Model", "Model Evaluation", "Predictions", "Loss Function",
                "Input Layer", "Hidden Layer", "Output Layer", "Weights", "Activation Function",
                "Convolutional Layer", "Pooling Layer", "Fully Connected Layer"
        };
        for (String label : candidateLabels) {
            if (lower.contains(label.toLowerCase(Locale.ROOT))) {
                matchedTerms.add(label);
            }
        }

        if (!matchedTerms.isEmpty()) {
            sb.append("🔍 **Recognized Diagram Components:**\n");
            for (String term : matchedTerms) {
                sb.append("• **").append(term).append("**\n");
            }
            sb.append("\n");
        }

        // Determine general diagram type
        if (lower.contains("input layer") || lower.contains("hidden layer") || lower.contains("output layer")) {
            sb.append("🧠 **Diagram Type: Artificial Neural Network Architecture**\n\n");
            sb.append("• **Input Layer:** Takes in the raw input features (such as numbers or pixels).\n");
            sb.append("• **Hidden Layer(s):** Learns patterns from the data using learned weights and activation functions (like ReLU).\n");
            sb.append("• **Output Layer:** Gives the final result or prediction (such as Softmax class probabilities or continuous output).\n\n");
            String rich = DeepKnowledgeBank.getRichExplanation("neural_networks");
            if (rich != null) sb.append(rich).append("\n\n");
        } else if (lower.contains("convolution") || lower.contains("pooling")) {
            sb.append("🖼️ **Diagram Type: Convolutional Neural Network (CNN) Architecture**\n\n");
            String rich = DeepKnowledgeBank.getRichExplanation("cnn");
            if (rich != null) sb.append(rich).append("\n\n");
        } else {
            sb.append("🔄 **Diagram Workflow Explanation:**\n");
            sb.append("1. **Data Preprocessing:** Raw data is gathered, cleaned, and prepared for training.\n");
            sb.append("2. **Model Training:** Training data is fed into the machine learning algorithm to learn patterns.\n");
            sb.append("3. **Evaluation & Predictions:** Unseen test data is used to evaluate accuracy and make predictions.\n\n");

            // Look up primary concept (e.g., supervised learning, clustering, etc.)
            List<String> concepts = findConceptsInText(ocrText, helper);
            if (!concepts.isEmpty()) {
                String primary = concepts.get(0);
                String rich = DeepKnowledgeBank.getRichExplanation(primary);
                if (rich != null) {
                    sb.append(rich).append("\n\n");
                }
            }
        }

        sb.append("📌 *Note: Offline analysis is performed via on-device OCR based on recognized diagram labels and text.*");
        return sb.toString();
    }

    /**
     * Checks if image contains confusion matrix or evaluation table.
     */
    private static boolean isConfusionMatrixOrTable(String text) {
        String lower = text.toLowerCase(Locale.ROOT);
        return (lower.contains("true positive") || lower.contains("false positive") || lower.contains("tp") && lower.contains("fn"))
                || (lower.contains("confusion matrix") || lower.contains("actual") && lower.contains("predicted"));
    }

    private static String handleEvaluationTable(String ocrText, String userQuery, ChatbotDatasetHelper helper) {
        StringBuilder sb = new StringBuilder();
        sb.append("🔲 **Evaluation Matrix / Confusion Matrix Detected**\n\n");
        sb.append("The image contains a classification performance evaluation matrix.\n\n");
        String cm = DeepKnowledgeBank.getRichExplanation("confusion_matrix");
        if (cm != null) {
            sb.append(cm).append("\n\n");
        }
        String f1 = DeepKnowledgeBank.getRichExplanation("f1_score");
        if (f1 != null) {
            sb.append(f1).append("\n\n");
        }
        sb.append("*(⚡ Processed locally using on-device OCR - 100% offline)*");
        return sb.toString();
    }

    /**
     * Handles detected ML concepts and respects user questions (e.g., "Explain its types", "Explain this").
     */
    private static String handleMatchedConcepts(String ocrText, String userQuery, List<String> matchedConcepts, ChatbotDatasetHelper helper) {
        StringBuilder sb = new StringBuilder();

        String primaryConcept = matchedConcepts.get(0);
        String secondaryConcept = matchedConcepts.size() > 1 ? matchedConcepts.get(1) : null;

        // Check if user asked about TYPES
        boolean userAskedTypes = userQuery != null && (userQuery.toLowerCase(Locale.ROOT).contains("type") || userQuery.toLowerCase(Locale.ROOT).contains("kind"));
        // Check if user asked about DIFFERENCE
        boolean userAskedDiff = userQuery != null && (userQuery.toLowerCase(Locale.ROOT).contains("difference") || userQuery.toLowerCase(Locale.ROOT).contains("vs") || userQuery.toLowerCase(Locale.ROOT).contains("compare"));

        sb.append("📷 **Recognized ML Content from Image:**\n");
        sb.append("• **Key Concept Identified:** ").append(primaryConcept.replace("_", " ").toUpperCase(Locale.ROOT)).append("\n");
        if (secondaryConcept != null) {
            sb.append("• **Related Concept:** ").append(secondaryConcept.replace("_", " ").toUpperCase(Locale.ROOT)).append("\n");
        }
        sb.append("\n");

        if (userAskedDiff && secondaryConcept != null) {
            // Difference between two concepts found in image
            String diffAns = helper.getAnswer("difference between " + primaryConcept.replace("_", " ") + " and " + secondaryConcept.replace("_", " "));
            sb.append(diffAns);
        } else if (userAskedTypes) {
            // Types of concept found in image
            String typesAns = helper.getAnswer("types of " + primaryConcept.replace("_", " "));
            sb.append(typesAns);
        } else if (!userQuery.isEmpty() && !isGenericImagePrompt(userQuery)) {
            // User asked a specific query related to the image
            String specificAns = helper.getAnswer(userQuery + " " + primaryConcept.replace("_", " "));
            if (!specificAns.equals(ChatbotDatasetHelper.FALLBACK_MESSAGE)) {
                sb.append(specificAns);
            } else {
                String rich = DeepKnowledgeBank.getRichExplanation(primaryConcept);
                if (rich != null) sb.append(rich);
                else sb.append(helper.getAnswer(primaryConcept.replace("_", " ")));
            }
        } else {
            // Generic prompt like "Explain this" or no text prompt
            String rich = DeepKnowledgeBank.getRichExplanation(primaryConcept);
            if (rich != null) {
                sb.append(rich);
            } else {
                sb.append(helper.getAnswer(primaryConcept.replace("_", " ")));
            }
        }

        sb.append("\n\n*(⚡ Generated offline using on-device OCR and local ML Knowledge Base)*");
        return sb.toString();
    }

    /**
     * Extracts an explicit question from OCR text if present.
     */
    private static String extractQuestionFromText(String text) {
        String[] lines = text.split("\\r?\\n");
        for (String line : lines) {
            String l = line.trim();
            if (l.endsWith("?") && l.length() > 6) {
                return l;
            }
            String lower = l.toLowerCase(Locale.ROOT);
            if (lower.startsWith("what is ") || lower.startsWith("explain ") || lower.startsWith("how does ") || lower.startsWith("define ") || lower.startsWith("difference between ")) {
                return l;
            }
        }
        return null;
    }

    /**
     * Identifies ML concepts present in the text using ChatbotDatasetHelper aliases.
     */
    private static List<String> findConceptsInText(String text, ChatbotDatasetHelper helper) {
        String clean = helper.cleanAndNormalize(text);
        List<ChatbotDatasetHelper.MatchedConcept> list = helper.detectConcepts(clean);
        Set<String> unique = new LinkedHashSet<>();
        for (ChatbotDatasetHelper.MatchedConcept mc : list) {
            unique.add(mc.conceptId);
        }
        return new ArrayList<>(unique);
    }

    private static String previewText(String text, int maxChars) {
        if (text == null) return "";
        String singleLine = text.replaceAll("\\s+", " ").trim();
        if (singleLine.length() <= maxChars) return singleLine;
        return singleLine.substring(0, maxChars) + "...";
    }
}
