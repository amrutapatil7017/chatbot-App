package amruta.newproject;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    private ChatbotDatasetHelper helper;

    @Before
    public void setUp() throws Exception {
        File csvFile = new File("src/main/assets/AIML_NLP_200plus_Dataset.csv");
        assertTrue("AIML NLP dataset file should exist", csvFile.exists());
        InputStream is = new FileInputStream(csvFile);
        helper = new ChatbotDatasetHelper(is);
    }

    @Test
    public void testConversationContextAndFollowUpFlows() {
        helper.resetContext();

        // Flow 1: Machine Learning & Types
        String ansMl = helper.getAnswer("What is ML?");
        assertTrue(ansMl.toLowerCase().contains("machine learning"));

        String ansMlTypes = helper.getAnswer("What are its types?");
        assertTrue(ansMlTypes.toLowerCase().contains("supervised learning"));
        assertTrue(ansMlTypes.toLowerCase().contains("unsupervised learning"));
        assertTrue(ansMlTypes.toLowerCase().contains("semi-supervised learning"));
        assertTrue(ansMlTypes.toLowerCase().contains("reinforcement learning"));
        assertFalse(ansMlTypes.toLowerCase().contains("branch of ai that enables computers to learn"));

        // Flow 2: CNN follow-ups (applications, advantages, working)
        String ansCnn = helper.getAnswer("What is CNN?");
        assertTrue(ansCnn.toLowerCase().contains("convolutional"));

        String ansCnnApps = helper.getAnswer("What are its applications?");
        assertTrue(ansCnnApps.toLowerCase().contains("image classification")
                || ansCnnApps.toLowerCase().contains("facial recognition")
                || ansCnnApps.toLowerCase().contains("autonomous vehicle"));

        String ansCnnAdv = helper.getAnswer("What are its advantages?");
        assertTrue(ansCnnAdv.toLowerCase().contains("feature extraction")
                || ansCnnAdv.toLowerCase().contains("parameter sharing"));

        String ansCnnWork = helper.getAnswer("How does it work?");
        assertTrue(ansCnnWork.toLowerCase().contains("convolutional layers")
                || ansCnnWork.toLowerCase().contains("pooling layers"));

        // Flow 3: Supervised learning & examples
        String ansSup = helper.getAnswer("What is supervised learning?");
        assertTrue(ansSup.toLowerCase().contains("labeled data") || ansSup.toLowerCase().contains("known target"));

        String ansSupTypes = helper.getAnswer("What are its types?");
        assertTrue(ansSupTypes.toLowerCase().contains("classification") && ansSupTypes.toLowerCase().contains("regression"));

        String ansSupEx = helper.getAnswer("Give examples.");
        assertTrue(ansSupEx.toLowerCase().contains("spam") || ansSupEx.toLowerCase().contains("house price"));

        // Flow 4: NLP & techniques
        String ansNlp = helper.getAnswer("What is NLP?");
        assertTrue(ansNlp.toLowerCase().contains("natural language") || ansNlp.toLowerCase().contains("human language"));

        String ansNlpTech = helper.getAnswer("What are its techniques?");
        assertTrue(ansNlpTech.toLowerCase().contains("tokenization") || ansNlpTech.toLowerCase().contains("stemming"));
    }

    @Test
    public void testImportantIntentRuleDifferentAnswersForFacets() {
        helper.resetContext();

        // User: "What is ML?" → Definition of ML
        String def = helper.getAnswer("What is ML?");

        // User: "What are the types of ML?" → Types of ML
        String types = helper.getAnswer("What are the types of ML?");

        // User: "What are the algorithms of ML?" → ML algorithms
        String algos = helper.getAnswer("What are the algorithms of ML?");

        // User: "What are the advantages of ML?" → Advantages of ML
        String adv = helper.getAnswer("What are the advantages of ML?");

        // Verify all 4 are distinct answers tailored to each facet
        assertNotEquals(def, types);
        assertNotEquals(def, algos);
        assertNotEquals(def, adv);
        assertNotEquals(types, algos);

        assertTrue(types.toLowerCase().contains("supervised learning") && types.toLowerCase().contains("reinforcement"));
        assertTrue(algos.toLowerCase().contains("linear regression") || algos.toLowerCase().contains("decision tree"));
        assertTrue(adv.toLowerCase().contains("automated pattern discovery") || adv.toLowerCase().contains("self-improvement"));
    }

    @Test
    public void testSemanticMatchingAndPhrasingVariations() {
        helper.resetContext();

        // Algorithms variations
        String a1 = helper.getAnswer("algo of ml");
        String a2 = helper.getAnswer("ML algorithms");
        String a3 = helper.getAnswer("algorithms used in machine learning");
        String a4 = helper.getAnswer("which algorithms are used in ML?");

        assertTrue(a1.toLowerCase().contains("linear regression") || a1.toLowerCase().contains("decision tree"));
        assertTrue(a2.toLowerCase().contains("linear regression") || a2.toLowerCase().contains("decision tree"));
        assertTrue(a3.toLowerCase().contains("linear regression") || a3.toLowerCase().contains("decision tree"));
        assertTrue(a4.toLowerCase().contains("linear regression") || a4.toLowerCase().contains("decision tree"));

        // Types variations
        String t1 = helper.getAnswer("ML has which types?");
        String t2 = helper.getAnswer("Which types of ML are there?");
        String t3 = helper.getAnswer("Tell me ML types.");
        String t4 = helper.getAnswer("Types of machine learning?");

        assertTrue(t1.toLowerCase().contains("supervised") && t1.toLowerCase().contains("unsupervised"));
        assertTrue(t2.toLowerCase().contains("supervised") && t2.toLowerCase().contains("unsupervised"));
        assertTrue(t3.toLowerCase().contains("supervised") && t3.toLowerCase().contains("unsupervised"));
        assertTrue(t4.toLowerCase().contains("supervised") && t4.toLowerCase().contains("unsupervised"));
    }

    @Test
    public void testTypoAndGrammarHandling() {
        helper.resetContext();

        // "wht is ml" → "what is ML"
        String ansWht = helper.getAnswer("wht is ml");
        assertTrue(ansWht.toLowerCase().contains("machine learning"));

        // "it's type" → "its types" (as follow up after ML)
        String ansItsType = helper.getAnswer("it's type");
        assertTrue(ansItsType.toLowerCase().contains("supervised learning"));

        // "what r types of ml" → "what are types of ML"
        String ansWhatR = helper.getAnswer("what r types of ml");
        assertTrue(ansWhatR.toLowerCase().contains("supervised learning"));

        // "algorithum of ml" → "algorithm of ML"
        String ansAlgoTypo = helper.getAnswer("algorithum of ml");
        assertTrue(ansAlgoTypo.toLowerCase().contains("linear regression") || ansAlgoTypo.toLowerCase().contains("decision tree"));

        // "supervized learning" → "supervised learning"
        String ansSupTypo = helper.getAnswer("supervized learning");
        assertTrue(ansSupTypo.toLowerCase().contains("labeled data") || ansSupTypo.toLowerCase().contains("known target"));
    }

    @Test
    public void testAbbreviations() {
        helper.resetContext();

        // AI
        assertTrue(helper.getAnswer("What is AI?").toLowerCase().contains("artificial intelligence")
                || helper.getAnswer("What is AI?").toLowerCase().contains("human intelligence"));

        // DL
        assertTrue(helper.getAnswer("What is DL?").toLowerCase().contains("deep learning")
                || helper.getAnswer("What is DL?").toLowerCase().contains("neural"));

        // RNN
        assertTrue(helper.getAnswer("What is RNN?").toLowerCase().contains("recurrent"));

        // LSTM
        assertTrue(helper.getAnswer("What is LSTM?").toLowerCase().contains("long short-term memory")
                || helper.getAnswer("What is LSTM?").toLowerCase().contains("memory"));

        // GRU
        assertTrue(helper.getAnswer("What is GRU?").toLowerCase().contains("gated recurrent unit")
                || helper.getAnswer("What is GRU?").toLowerCase().contains("gates"));

        // KNN
        assertTrue(helper.getAnswer("What is KNN?").toLowerCase().contains("nearest"));

        // SVM
        assertTrue(helper.getAnswer("What is SVM?").toLowerCase().contains("support vector")
                || helper.getAnswer("What is SVM?").toLowerCase().contains("boundary"));

        // PCA
        assertTrue(helper.getAnswer("What is PCA?").toLowerCase().contains("principal component")
                || helper.getAnswer("What is PCA?").toLowerCase().contains("dimensionality"));

        // LLM
        assertTrue(helper.getAnswer("What is an LLM?").toLowerCase().contains("large language model"));

        // RAG
        assertTrue(helper.getAnswer("What is RAG?").toLowerCase().contains("retrieval"));
    }

    @Test
    public void testNaturalGreetings() {
        String expectedIntro = "Hello! I am ChAI, your AI assistant. I can help you with programming, machine learning, AIML, and general questions.";
        assertEquals(expectedIntro, helper.getAnswer("Hi"));
        assertEquals(expectedIntro, helper.getAnswer("Hello"));
        assertEquals(expectedIntro, helper.getAnswer("Hii"));
        assertEquals(expectedIntro, helper.getAnswer("Hey"));
        assertEquals(expectedIntro, helper.getAnswer("Who are you?"));
        assertEquals(expectedIntro, helper.getAnswer("Who are u?"));
        assertEquals(expectedIntro, helper.getAnswer("What is your name?"));
        assertEquals("I'm doing great, thank you! 😊 How can I help you with AI and Machine Learning today?", helper.getAnswer("How are you?"));
        assertEquals("Good morning! ☀️ How can I help you with Artificial Intelligence and Machine Learning?", helper.getAnswer("Good morning"));
        assertEquals("Good evening! How can I help you with Artificial Intelligence and Machine Learning?", helper.getAnswer("Good evening"));
    }

    @Test
    public void testRequiredPrompts() {
        helper.resetContext();
        String pythonAns = helper.getAnswer("What is Python?");
        assertTrue("Should explain Python", pythonAns.toLowerCase().contains("python"));

        String datasetAns = helper.getAnswer("What is a labeled dataset?");
        assertTrue("Should explain labeled dataset", datasetAns.toLowerCase().contains("labeled") || datasetAns.toLowerCase().contains("dataset"));
    }

    @Test
    public void testUnknownAndUnrelatedQuestions() {
        String expected = "Sorry, I don't have the answer to that question in my AIML knowledge base.";

        helper.resetContext();
        assertEquals(expected, helper.getAnswer("What is the recipe for pasta?"));
        assertEquals(expected, helper.getAnswer("Who won the FIFA world cup?"));
        assertEquals(expected, helper.getAnswer("What is the capital of France?"));
        assertEquals(expected, helper.getAnswer("Where can I buy a washing machine?"));
        assertEquals(expected, helper.getAnswer("Where can I buy shoes?"));
        assertEquals(expected, helper.getAnswer("How to change a car tire?"));
        assertEquals(expected, helper.getAnswer("Tell me a joke about dogs."));
    }

    @Test
    public void testUserPromptExampleMultiTurnConversationFlow() {
        helper.resetContext();

        // Turn 1: User: What is ML?
        String ans1 = helper.getAnswer("What is ML?");
        assertTrue("Should explain machine learning", ans1.toLowerCase().contains("machine learning"));

        // Turn 2: User: What are its types?
        String ans2 = helper.getAnswer("What are its types?");
        assertTrue("Should answer ML types", ans2.toLowerCase().contains("supervised learning"));
        assertTrue("Should answer ML types", ans2.toLowerCase().contains("unsupervised learning"));
        assertTrue("Should answer ML types", ans2.toLowerCase().contains("semi-supervised learning"));
        assertTrue("Should answer ML types", ans2.toLowerCase().contains("reinforcement learning"));

        // Turn 3: User: What is supervised learning?
        String ans3 = helper.getAnswer("What is supervised learning?");
        assertTrue("Should explain supervised learning", ans3.toLowerCase().contains("labeled data"));

        // Turn 4: User: What are its types?
        String ans4 = helper.getAnswer("What are its types?");
        assertTrue("Should answer supervised learning types", ans4.toLowerCase().contains("classification")
                && ans4.toLowerCase().contains("regression"));
        assertFalse("Should NOT answer general ML types like reinforcement learning",
                ans4.toLowerCase().contains("reinforcement learning"));

        // Turn 5: User: What are its algorithms?
        String ans5 = helper.getAnswer("What are its algorithms?");
        assertTrue("Should answer supervised learning algorithms",
                ans5.toLowerCase().contains("linear regression") || ans5.toLowerCase().contains("decision tree"));

        // Turn 6: User: Give examples
        String ans6 = helper.getAnswer("Give examples");
        assertTrue("Should give supervised learning examples",
                ans6.toLowerCase().contains("spam") || ans6.toLowerCase().contains("house price"));
    }

    @Test
    public void testAllTenAimldomains() {
        helper.resetContext();

        // 1. AI Fundamentals
        String aiFund = helper.getAnswer("Explain AI fundamentals.");
        assertTrue(aiFund.toLowerCase().contains("artificial intelligence") || aiFund.toLowerCase().contains("knowledge representation"));
        String turing = helper.getAnswer("What is the Turing Test?");
        assertTrue(turing.toLowerCase().contains("turing"));

        // 2. Machine Learning
        String cvTest = helper.getAnswer("What is K-Fold Cross Validation?");
        assertTrue(cvTest.toLowerCase().contains("cross-validation") || cvTest.toLowerCase().contains("folds"));
        String featEng = helper.getAnswer("What is feature engineering?");
        assertTrue(featEng.toLowerCase().contains("feature") && (featEng.toLowerCase().contains("scaling") || featEng.toLowerCase().contains("encoding")));

        // 3. Deep Learning
        String backprop = helper.getAnswer("What is backpropagation?");
        assertTrue(backprop.toLowerCase().contains("chain rule") || backprop.toLowerCase().contains("loss"));
        String vanishGrad = helper.getAnswer("What is the vanishing gradient problem?");
        assertTrue(vanishGrad.toLowerCase().contains("vanishing gradient") || vanishGrad.toLowerCase().contains("relu"));

        // 4. NLP
        String tok = helper.getAnswer("What is tokenization?");
        assertTrue(tok.toLowerCase().contains("token") || tok.toLowerCase().contains("byte-pair"));
        String tfidf = helper.getAnswer("What is TF-IDF?");
        assertTrue(tfidf.toLowerCase().contains("inverse document frequency") || tfidf.toLowerCase().contains("frequency"));

        // 5. Computer Vision
        String yolo = helper.getAnswer("What is YOLO in computer vision?");
        assertTrue(yolo.toLowerCase().contains("you only look once") || yolo.toLowerCase().contains("bounding box"));
        String seg = helper.getAnswer("What is image segmentation?");
        assertTrue(seg.toLowerCase().contains("semantic segmentation") || seg.toLowerCase().contains("instance segmentation"));

        // 6. Generative AI
        String gan = helper.getAnswer("What is a GAN?");
        assertTrue(gan.toLowerCase().contains("generator") && gan.toLowerCase().contains("discriminator"));
        String promptEng = helper.getAnswer("What is prompt engineering?");
        assertTrue(promptEng.toLowerCase().contains("chain-of-thought") || promptEng.toLowerCase().contains("few-shot"));

        // 7. LLMs
        String tf = helper.getAnswer("What is the Transformer architecture?");
        assertTrue(tf.toLowerCase().contains("attention") || tf.toLowerCase().contains("self-attention"));
        String lora = helper.getAnswer("What is LoRA?");
        assertTrue(lora.toLowerCase().contains("low-rank") || lora.toLowerCase().contains("fine-tuning"));

        // 8. AI Algorithms
        String rf = helper.getAnswer("What is Random Forest?");
        assertTrue(rf.toLowerCase().contains("decision trees") || rf.toLowerCase().contains("bagging"));
        String dbscan = helper.getAnswer("What is DBSCAN?");
        assertTrue(dbscan.toLowerCase().contains("density") || dbscan.toLowerCase().contains("clustering"));

        String bias = helper.getAnswer("What is AI bias?");
        assertTrue(bias.toLowerCase().contains("bias") || bias.toLowerCase().contains("fairness"));
        String xai = helper.getAnswer("What is Explainable AI?");
        assertTrue(xai.toLowerCase().contains("shap") || xai.toLowerCase().contains("lime") || xai.toLowerCase().contains("explainable"));

        // 10. Python & Data Concepts
        String numpy = helper.getAnswer("What is NumPy?");
        assertTrue(numpy.toLowerCase().contains("array") || numpy.toLowerCase().contains("numerical"));
        String pandas = helper.getAnswer("What is Pandas?");
        assertTrue(pandas.toLowerCase().contains("dataframe") || pandas.toLowerCase().contains("series"));
    }

    @Test
    public void testShortQuestions() {
        helper.resetContext();

        assertTrue(helper.getAnswer("ML").toLowerCase().contains("machine learning"));
        assertTrue(helper.getAnswer("CNN").toLowerCase().contains("convolutional"));
        assertTrue(helper.getAnswer("RAG").toLowerCase().contains("retrieval"));
        assertTrue(helper.getAnswer("YOLO").toLowerCase().contains("you only look once") || helper.getAnswer("YOLO").toLowerCase().contains("object detection"));
        assertTrue(helper.getAnswer("BERT").toLowerCase().contains("transformer") || helper.getAnswer("BERT").toLowerCase().contains("bidirectional"));
        assertTrue(helper.getAnswer("PCA").toLowerCase().contains("principal component") || helper.getAnswer("PCA").toLowerCase().contains("dimensionality"));
    }

    @Test
    public void testExplainTypesMandatoryExplanations() {
        helper.resetContext();

        // Direct query: "Explain types of clustering"
        String ansClusterTypes = helper.getAnswer("Explain types of clustering");
        assertTrue("Must include K-Means Clustering", ansClusterTypes.toLowerCase().contains("k-means"));
        assertTrue("Must include DBSCAN", ansClusterTypes.toLowerCase().contains("dbscan"));
        assertTrue("Must include Hierarchical Clustering", ansClusterTypes.toLowerCase().contains("hierarchical"));
        assertTrue("Must explain K-Means, not just name", ansClusterTypes.toLowerCase().contains("divides the data") || ansClusterTypes.toLowerCase().contains("cluster centers"));
        assertTrue("Must explain DBSCAN density", ansClusterTypes.toLowerCase().contains("density") && ansClusterTypes.toLowerCase().contains("outliers"));
        assertTrue("Must explain Hierarchical approaches", ansClusterTypes.toLowerCase().contains("dendrogram") || ansClusterTypes.toLowerCase().contains("tree"));

        // Multi-turn context: "What is clustering?" followed by "Explain its types"
        helper.resetContext();
        String ansClust = helper.getAnswer("What is clustering?");
        assertTrue(ansClust.toLowerCase().contains("unsupervised") && ansClust.toLowerCase().contains("groups"));

        String ansFollowUpTypes = helper.getAnswer("Explain its types");
        assertTrue("Follow-up must include K-Means", ansFollowUpTypes.toLowerCase().contains("k-means"));
        assertTrue("Follow-up must include DBSCAN", ansFollowUpTypes.toLowerCase().contains("dbscan"));
        assertTrue("Follow-up must include Hierarchical", ansFollowUpTypes.toLowerCase().contains("hierarchical"));
        assertTrue("Must explain K-Means", ansFollowUpTypes.toLowerCase().contains("divides the data") || ansFollowUpTypes.toLowerCase().contains("cluster centers"));

        // Follow-up with "Explain the types"
        helper.resetContext();
        helper.getAnswer("What is clustering?");
        String ansTheTypes = helper.getAnswer("Explain the types");
        assertTrue(ansTheTypes.toLowerCase().contains("k-means") && ansTheTypes.toLowerCase().contains("dbscan"));

        // Types of Classification
        String ansClassTypes = helper.getAnswer("Explain types of classification");
        assertTrue(ansClassTypes.toLowerCase().contains("binary classification"));
        assertTrue(ansClassTypes.toLowerCase().contains("multi-class"));
        assertTrue(ansClassTypes.toLowerCase().contains("multi-label"));

        // Types of Regression
        String ansRegTypes = helper.getAnswer("Explain types of regression");
        assertTrue(ansRegTypes.toLowerCase().contains("linear regression"));
        assertTrue(ansRegTypes.toLowerCase().contains("polynomial regression"));
    }

    @Test
    public void testIndividualAlgorithmDefinitionWorkingExample() {
        helper.resetContext();

        // K-Means separately: definition, working, and example
        String ansKmeans = helper.getAnswer("What is K-Means clustering?");
        assertTrue(ansKmeans.toLowerCase().contains("definition"));
        assertTrue(ansKmeans.toLowerCase().contains("working") || ansKmeans.toLowerCase().contains("how it works"));
        assertTrue(ansKmeans.toLowerCase().contains("example"));

        // DBSCAN separately: definition, working, and example
        String ansDbscan = helper.getAnswer("What is DBSCAN?");
        assertTrue(ansDbscan.toLowerCase().contains("definition"));
        assertTrue(ansDbscan.toLowerCase().contains("working") || ansDbscan.toLowerCase().contains("how it works"));
        assertTrue(ansDbscan.toLowerCase().contains("example"));

        // Hierarchical clustering separately
        String ansHier = helper.getAnswer("What is Hierarchical Clustering?");
        assertTrue(ansHier.toLowerCase().contains("definition"));
        assertTrue(ansHier.toLowerCase().contains("working") || ansHier.toLowerCase().contains("how it works"));
        assertTrue(ansHier.toLowerCase().contains("example"));
    }

    @Test
    public void testImageQuestionMatcher_MLQuestionScreenshot() {
        helper.resetContext();
        String ocr = "What is supervised learning?";
        String result = ImageQuestionMatcher.analyzeImageContent(ocr, "Explain this", helper);

        assertTrue("Should contain question recognition indicator", result.contains("Recognized Question") || result.contains("Image Analysis") || result.contains("Question"));
        assertTrue("Should explain supervised learning", result.toLowerCase().contains("supervised learning"));
        assertTrue("Should mention labeled data", result.toLowerCase().contains("labeled data"));
    }

    @Test
    public void testImageQuestionMatcher_MLWorkflowDiagram() {
        helper.resetContext();
        String ocr = "Dataset -> Preprocessing -> Training Data -> Train Model -> Evaluate -> Predictions";
        String result = ImageQuestionMatcher.analyzeImageContent(ocr, "Explain this diagram", helper);

        assertTrue("Should detect diagram / workflow", result.toLowerCase().contains("diagram") || result.toLowerCase().contains("workflow") || result.toLowerCase().contains("pipeline"));
        assertTrue("Should explain model or training", result.toLowerCase().contains("training") || result.toLowerCase().contains("model"));
        assertTrue("Should explain predictions or evaluation", result.toLowerCase().contains("prediction") || result.toLowerCase().contains("evaluate"));
    }

    @Test
    public void testImageQuestionMatcher_PythonCodeScreenshot() {
        helper.resetContext();
        String ocr = "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.linear_model import LinearRegression\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)\n" +
                "model = LinearRegression()\n" +
                "model.fit(X_train, y_train)";

        String result = ImageQuestionMatcher.analyzeImageContent(ocr, "Explain this code", helper);

        assertTrue("Should identify Python / ML code", result.toLowerCase().contains("python") || result.toLowerCase().contains("code"));
        assertTrue("Should identify scikit-learn or model training", result.toLowerCase().contains("scikit") || result.toLowerCase().contains("sklearn") || result.toLowerCase().contains("regression"));
        assertTrue("Should explain train test split or fit", result.toLowerCase().contains("train_test_split") || result.toLowerCase().contains("fit"));
    }

    @Test
    public void testImageQuestionMatcher_ConfusionMatrixTable() {
        helper.resetContext();
        String ocr = "Predicted Positive Predicted Negative\nActual Positive TP: 80 FN: 20\nActual Negative FP: 10 TN: 90";
        String result = ImageQuestionMatcher.analyzeImageContent(ocr, "What is this table?", helper);

        assertTrue("Should identify confusion matrix or evaluation metrics", result.toLowerCase().contains("confusion matrix") || result.toLowerCase().contains("evaluation"));
        assertTrue("Should mention true positives or metrics", result.toLowerCase().contains("true positive") || result.toLowerCase().contains("tp") || result.toLowerCase().contains("accuracy"));
    }

    @Test
    public void testImageQuestionMatcher_NeuralNetworkArchitecture() {
        helper.resetContext();
        String ocr = "Input Layer -> Hidden Layer (ReLU) -> Output Layer (Softmax)";
        String result = ImageQuestionMatcher.analyzeImageContent(ocr, "Explain this architecture", helper);

        assertTrue("Should identify neural network", result.toLowerCase().contains("neural network") || result.toLowerCase().contains("layer"));
        assertTrue("Should mention activation functions or layers", result.toLowerCase().contains("relu") || result.toLowerCase().contains("hidden layer") || result.toLowerCase().contains("softmax"));
    }

    @Test
    public void testImageQuestionMatcher_UnreadableOrNonMLImageHonestFallback() {
        helper.resetContext();

        // 1. Completely blank / unreadable image
        String blankResult = ImageQuestionMatcher.analyzeImageContent("", "Explain this", helper);
        assertTrue("Should honestly state that no readable text was detected",
                blankResult.toLowerCase().contains("could not detect") || blankResult.toLowerCase().contains("no readable text"));
        assertTrue("Should mention offline OCR limitation note",
                blankResult.toLowerCase().contains("offline") || blankResult.toLowerCase().contains("limitation"));

        // 2. Non-ML image text (e.g., pizza menu / grocery store discount)
        String nonMlOcr = "Delicious Margherita Pizza 20% discount on large size today only call 555-0199";
        String nonMlResult = ImageQuestionMatcher.analyzeImageContent(nonMlOcr, "Explain this", helper);
        assertTrue("Should indicate image does not appear to contain ML concepts",
                nonMlResult.toLowerCase().contains("could not identify") || nonMlResult.toLowerCase().contains("non-ml"));
    }

    @Test
    public void testStudentFriendlyExamFormatAndExplainVariants() {
        helper.resetContext();

        // Exact User Example: "What is Artificial Intelligence?"
        String ansAi = helper.getAnswer("What is Artificial Intelligence?");
        assertTrue("Should contain definition of AI", ansAi.contains("branch of computer science that enables machines to perform tasks"));
        assertTrue("Should contain Example", ansAi.contains("Example:"));
        assertFalse("Must NOT contain double stars (**)", ansAi.contains("**"));
        assertFalse("Must NOT contain Key Points unless asked", ansAi.contains("Key Points"));
        assertFalse("Must NOT contain Core Pillars unless asked", ansAi.contains("Core Pillars"));

        // Question: "What is ML?"
        String ansMl = helper.getAnswer("What is ML?");
        assertTrue("Should contain definition of ML", ansMl.toLowerCase().contains("machine learning"));
        assertTrue("Should contain Example", ansMl.contains("Example:"));
        assertFalse("Must NOT contain double stars (**)", ansMl.contains("**"));
        assertFalse("Must NOT contain Key Points header", ansMl.contains("Key Points"));

        // "Explain ML"
        String ansMlExp = helper.getAnswer("Explain ML");
        assertTrue(ansMlExp.toLowerCase().contains("machine learning"));
        assertFalse("Must NOT contain double stars (**)", ansMlExp.contains("**"));

        // Programming Language: Python
        String ansPy = helper.getAnswer("What is Python?");
        assertTrue("Should explain Python", ansPy.toLowerCase().contains("python"));
        assertTrue("Should contain Example", ansPy.contains("Example:"));
        assertFalse("Must NOT contain double stars (**)", ansPy.contains("**"));

        // Programming Language: Java
        String ansJava = helper.getAnswer("What is Java?");
        assertTrue("Should explain Java", ansJava.toLowerCase().contains("java"));
        assertTrue("Should contain Example", ansJava.contains("Example:"));
        assertFalse("Must NOT contain double stars (**)", ansJava.contains("**"));

        // Programming Language: C++
        String ansCpp = helper.getAnswer("What is C++?");
        assertTrue("Should explain C++", ansCpp.toLowerCase().contains("c++"));
        assertFalse("Must NOT contain double stars (**)", ansCpp.contains("**"));

        // CS Topic: OOP
        String ansOop = helper.getAnswer("What is OOP?");
        assertTrue("Should explain OOP", ansOop.toLowerCase().contains("object-oriented programming") || ansOop.toLowerCase().contains("objects"));
        assertFalse("Must NOT contain double stars (**)", ansOop.contains("**"));

        // CS Topic: Explain OOP types
        String ansOopTypes = helper.getAnswer("Explain its types");
        assertTrue("Should explain encapsulation", ansOopTypes.toLowerCase().contains("encapsulation"));
        assertTrue("Should explain inheritance", ansOopTypes.toLowerCase().contains("inheritance"));
        assertTrue("Should explain polymorphism", ansOopTypes.toLowerCase().contains("polymorphism"));
        assertFalse("Must NOT contain double stars (**)", ansOopTypes.contains("**"));

        // CS Topic: DBMS
        String ansDbms = helper.getAnswer("What is DBMS?");
        assertTrue("Should explain DBMS", ansDbms.toLowerCase().contains("database management system"));
        assertFalse("Must NOT contain double stars (**)", ansDbms.contains("**"));

        // CS Topic: Operating System
        String ansOs = helper.getAnswer("What is Operating System?");
        assertTrue("Should explain OS", ansOs.toLowerCase().contains("operating system"));
        assertFalse("Must NOT contain double stars (**)", ansOs.contains("**"));
    }

    @Test
    public void testProgrammingLanguagesAndComputerScienceSuite() {
        helper.resetContext();

        // Exact User Prompt Example
        String exactAi = helper.getAnswer("What is Artificial Intelligence?");
        assertEquals("Artificial Intelligence (AI) is a branch of computer science that enables machines to perform tasks that normally require human intelligence, such as learning, reasoning and problem-solving.\n\nExample: Chatbots and voice assistants use AI.", exactAi);

        // Programming Languages
        String cAns = helper.getAnswer("What is C programming?");
        assertTrue(cAns.toLowerCase().contains("procedural"));
        assertFalse(cAns.contains("**"));

        String csharpAns = helper.getAnswer("What is C#?");
        assertTrue(csharpAns.toLowerCase().contains("type-safe") || csharpAns.toLowerCase().contains(".net"));
        assertFalse(csharpAns.contains("**"));

        String jsAns = helper.getAnswer("What is JavaScript?");
        assertTrue(jsAns.toLowerCase().contains("web") && jsAns.contains("Example:"));
        assertFalse(jsAns.contains("**"));

        String tsAns = helper.getAnswer("What is TypeScript?");
        assertTrue(tsAns.toLowerCase().contains("superset") || tsAns.toLowerCase().contains("javascript"));
        assertFalse(tsAns.contains("**"));

        String htmlAns = helper.getAnswer("What is HTML?");
        assertTrue(htmlAns.toLowerCase().contains("markup language"));
        assertFalse(htmlAns.contains("**"));

        String cssAns = helper.getAnswer("What is CSS?");
        assertTrue(cssAns.toLowerCase().contains("style sheet") || cssAns.toLowerCase().contains("presentation"));
        assertFalse(cssAns.contains("**"));

        String sqlAns = helper.getAnswer("What is SQL?");
        assertTrue(sqlAns.toLowerCase().contains("structured query language") || sqlAns.toLowerCase().contains("relational"));
        assertFalse(sqlAns.contains("**"));

        String sqlTypes = helper.getAnswer("Explain types of SQL commands");
        assertTrue(sqlTypes.contains("DDL") && sqlTypes.contains("DML") && sqlTypes.contains("DQL"));
        assertFalse(sqlTypes.contains("**"));

        String phpAns = helper.getAnswer("What is PHP?");
        assertTrue(phpAns.toLowerCase().contains("server-side") || phpAns.toLowerCase().contains("scripting"));
        assertFalse(phpAns.contains("**"));

        String kotlinAns = helper.getAnswer("What is Kotlin?");
        assertTrue(kotlinAns.toLowerCase().contains("android"));
        assertFalse(kotlinAns.contains("**"));

        String swiftAns = helper.getAnswer("What is Swift?");
        assertTrue(swiftAns.toLowerCase().contains("apple") || swiftAns.toLowerCase().contains("ios"));
        assertFalse(swiftAns.contains("**"));

        String rustAns = helper.getAnswer("What is Rust?");
        assertTrue(rustAns.toLowerCase().contains("memory safety") || rustAns.toLowerCase().contains("speed"));
        assertFalse(rustAns.contains("**"));

        String goAns = helper.getAnswer("What is Go language?");
        assertTrue(goAns.toLowerCase().contains("google") || goAns.toLowerCase().contains("concurrency"));
        assertFalse(goAns.contains("**"));

        // Data Structures
        String dsTypes = helper.getAnswer("Explain types of data structures");
        assertTrue(dsTypes.toLowerCase().contains("linear") && dsTypes.toLowerCase().contains("non-linear"));
        assertFalse(dsTypes.contains("**"));

        String arrAns = helper.getAnswer("What is an array?");
        assertTrue(arrAns.toLowerCase().contains("contiguous memory"));
        assertFalse(arrAns.contains("**"));

        String llTypes = helper.getAnswer("Explain types of linked list");
        assertTrue(llTypes.toLowerCase().contains("singly") && llTypes.toLowerCase().contains("doubly"));
        assertFalse(llTypes.contains("**"));

        String stackAns = helper.getAnswer("What is a stack?");
        assertTrue(stackAns.toLowerCase().contains("lifo"));
        assertFalse(stackAns.contains("**"));

        String queueTypes = helper.getAnswer("Explain types of queue");
        assertTrue(queueTypes.toLowerCase().contains("circular queue") || queueTypes.toLowerCase().contains("priority queue"));
        assertFalse(queueTypes.contains("**"));

        String bstAns = helper.getAnswer("What is a binary search tree?");
        assertTrue(bstAns.toLowerCase().contains("left") && bstAns.toLowerCase().contains("right"));
        assertFalse(bstAns.contains("**"));

        String graphAns = helper.getAnswer("What is a graph data structure?");
        assertTrue(graphAns.toLowerCase().contains("vertices") || graphAns.toLowerCase().contains("edges"));
        assertFalse(graphAns.contains("**"));

        // Algorithms & Complexity
        String tcAns = helper.getAnswer("What is time complexity?");
        assertTrue(tcAns.toLowerCase().contains("big-o") || tcAns.toLowerCase().contains("input size"));
        assertFalse(tcAns.contains("**"));

        String sortTypes = helper.getAnswer("Explain types of sorting");
        assertTrue(sortTypes.toLowerCase().contains("bubble sort") && sortTypes.toLowerCase().contains("merge sort") && sortTypes.toLowerCase().contains("quick sort"));
        assertFalse(sortTypes.contains("**"));

        String searchTypes = helper.getAnswer("Explain types of searching");
        assertTrue(searchTypes.toLowerCase().contains("linear search") && searchTypes.toLowerCase().contains("binary search"));
        assertFalse(searchTypes.contains("**"));

        String recAns = helper.getAnswer("What is recursion?");
        assertTrue(recAns.toLowerCase().contains("calls itself"));
        assertFalse(recAns.contains("**"));

        // DBMS & OS & Networks
        String acidAns = helper.getAnswer("Explain ACID properties");
        assertTrue(acidAns.toLowerCase().contains("atomicity") && acidAns.toLowerCase().contains("consistency") && acidAns.toLowerCase().contains("isolation") && acidAns.toLowerCase().contains("durability"));
        assertFalse(acidAns.contains("**"));

        String dlConditions = helper.getAnswer("Explain deadlock conditions");
        assertTrue(dlConditions.toLowerCase().contains("mutual exclusion") && dlConditions.toLowerCase().contains("hold and wait") && dlConditions.toLowerCase().contains("circular wait"));
        assertFalse(dlConditions.contains("**"));

        String osiAns = helper.getAnswer("What is the OSI model?");
        assertTrue(osiAns.toLowerCase().contains("7-layer") || osiAns.toLowerCase().contains("layers"));
        assertFalse(osiAns.contains("**"));

        String tcpUdp = helper.getAnswer("What is the difference between TCP and UDP?");
        assertTrue(tcpUdp.toLowerCase().contains("connection-oriented") || tcpUdp.toLowerCase().contains("reliable"));
        assertFalse(tcpUdp.contains("**"));

        String compInter = helper.getAnswer("What is the difference between compiler and interpreter?");
        assertTrue(compInter.toLowerCase().contains("machine code") || compInter.toLowerCase().contains("line by line"));
        assertFalse(compInter.contains("**"));
    }

    @Test
    public void testWelcomeScreenCardBehavior() {
        List<ChatMessage> list = new ArrayList<>();
        String welcomeText = "Hello! I am your AI Assistant powered by Google Gemini and a Supercharged Knowledge Engine. Ask me anything!";
        
        // Initial state: Only welcome card exists
        list.add(new ChatMessage(welcomeText, false, System.currentTimeMillis(), false, true));
        assertEquals(1, list.size());
        assertTrue(list.get(0).isWelcome());
        assertEquals(welcomeText, list.get(0).getText());
        assertFalse(list.get(0).isUser());

        // Simulate user sends first message: welcome card is immediately removed
        boolean welcomeRemoved = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).isWelcome()) {
                list.remove(i);
                welcomeRemoved = true;
            }
        }
        assertTrue("Welcome card should be removed immediately when user sends a message", welcomeRemoved);

        // Add user message
        list.add(new ChatMessage("What is Artificial Intelligence?", true, System.currentTimeMillis()));
        assertEquals(1, list.size());
        assertFalse(list.get(0).isWelcome());
        assertTrue(list.get(0).isUser());
        assertEquals("What is Artificial Intelligence?", list.get(0).getText());

        // Add bot message
        list.add(new ChatMessage("Artificial Intelligence is ...", false, System.currentTimeMillis()));
        assertEquals(2, list.size());

        // Verify none of the messages in current chat are welcome card
        for (ChatMessage msg : list) {
            assertFalse(msg.isWelcome());
        }

        // Simulate chat reset: list is cleared and welcome card is restored
        list.clear();
        list.add(new ChatMessage(welcomeText, false, System.currentTimeMillis(), false, true));
        assertEquals(1, list.size());
        assertTrue(list.get(0).isWelcome());
    }

    @Test
    public void testDefineDefinitionWhatIsQuestions() {
        helper.resetContext();

        String[] queries = {
                "Define Artificial Intelligence",
                "Definition of Machine Learning",
                "What is Deep Learning?",
                "Define Supervised Learning",
                "Definition of Neural Network",
                "What is Python?",
                "Define Recursion",
                "Definition of DBMS",
                "What is an array?",
                "Define CNN",
                "Definition of Operating System"
        };

        for (String q : queries) {
            String answer = helper.getAnswer(q);
            assertTrue("Query '" + q + "' should produce an answer", answer != null && !answer.isEmpty());
            assertTrue("Query '" + q + "' should contain an example", answer.contains("Example:") || answer.contains("example:"));
            assertFalse("Query '" + q + "' must not contain double stars (**)", answer.contains("**"));
            assertFalse("Query '" + q + "' must not contain unnecessary 'Key Points' section", answer.contains("Key Points"));
            assertFalse("Query '" + q + "' must not contain unnecessary 'Core Pillars' section", answer.contains("Core Pillars"));
        }
    }

    @Test
    public void testRecentChatTitleGenerator() {
        // Topic extraction
        String title1 = RecentChatTitleGenerator.generateTitle("What is Supervised Learning?", helper);
        assertEquals("Supervised Learning", title1);

        String title2 = RecentChatTitleGenerator.generateTitle("Difference between AI and ML", helper);
        assertEquals("AI vs ML", title2);

        String title3 = RecentChatTitleGenerator.generateTitle("Explain types of Machine Learning", helper);
        assertTrue(title3.toLowerCase().contains("types of"));

        // Multilingual/Hindi filler removal
        String title4 = RecentChatTitleGenerator.generateTitle("Machine learning kya hai", helper);
        assertEquals("Machine Learning", title4);

        // General programming question
        String title5 = RecentChatTitleGenerator.generateTitle("What is a binary search tree?", helper);
        assertTrue(title5.toLowerCase().contains("binary search tree"));

        // Empty question fallback
        String title6 = RecentChatTitleGenerator.generateTitle("", helper);
        assertEquals("New Conversation", title6);
    }

    @Test
    public void testRecentChatModel() {
        RecentChat chat = new RecentChat("123", "Supervised Learning", "What is supervised learning?", 1700000000000L);
        assertEquals("123", chat.getId());
        assertEquals("Supervised Learning", chat.getTitle());
        assertEquals("What is supervised learning?", chat.getQuestion());
        assertEquals(1700000000000L, chat.getTimestamp());
    }

    @Test
    public void testChAiLogoAssetsAndLauncherIcons() {
        File drawableDir = new File("src/main/res/drawable");
        File iconFile = new File(drawableDir, "ic_chai_icon.png");
        File logoFile = new File(drawableDir, "ic_chai_logo.png");
        File markFile = new File(drawableDir, "ic_chai_mark.png");

        assertTrue("ic_chai_icon.png should exist in drawable", iconFile.exists() && iconFile.length() > 0);
        assertTrue("ic_chai_logo.png should exist in drawable", logoFile.exists() && logoFile.length() > 0);
        assertTrue("ic_chai_mark.png should exist in drawable", markFile.exists() && markFile.length() > 0);

        String[] densities = {"mipmap-mdpi", "mipmap-hdpi", "mipmap-xhdpi", "mipmap-xxhdpi", "mipmap-xxxhdpi"};
        for (String density : densities) {
            File dir = new File("src/main/res", density);
            File launcher = new File(dir, "ic_launcher.webp");
            File launcherRound = new File(dir, "ic_launcher_round.webp");
            File launcherFg = new File(dir, "ic_launcher_foreground.webp");

            assertTrue("ic_launcher.webp should exist in " + density, launcher.exists() && launcher.length() > 0);
            assertTrue("ic_launcher_round.webp should exist in " + density, launcherRound.exists() && launcherRound.length() > 0);
            assertTrue("ic_launcher_foreground.webp should exist in " + density, launcherFg.exists() && launcherFg.length() > 0);
        }

        File anydpiDir = new File("src/main/res/mipmap-anydpi-v26");
        File adaptiveLauncher = new File(anydpiDir, "ic_launcher.xml");
        File adaptiveRound = new File(anydpiDir, "ic_launcher_round.xml");
        assertTrue("adaptive ic_launcher.xml should exist", adaptiveLauncher.exists());
        assertTrue("adaptive ic_launcher_round.xml should exist", adaptiveRound.exists());
    }
}