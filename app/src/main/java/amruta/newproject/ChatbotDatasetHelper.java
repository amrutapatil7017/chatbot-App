package amruta.newproject;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Supercharged AIML Conversational Engine and Knowledge Helper.
 * Handles semantic matching, typo normalization, acronym resolution,
 * multi-turn conversational context tracking, and rich answer generation
 * across all 11 core AIML domains.
 */
public class ChatbotDatasetHelper {

    public static final String FALLBACK_MESSAGE =
            "Sorry, I don't have the answer to that question in my AIML knowledge base.";

    public enum QuestionType {
        TYPES,
        ALGORITHMS,
        DIFFERENCE,
        APPLICATIONS,
        ADVANTAGES,
        DISADVANTAGES,
        EXAMPLES,
        WORKING,
        STEPS,
        ARCHITECTURE,
        FEATURES,
        EXPLAIN,
        DEFINITION
    }

    public static class QAPair {
        public final String intent;
        public final String question;
        public final String answer;
        public final String normalizedQuestion;

        public QAPair(String intent, String question, String answer, String normalizedQuestion) {
            this.intent = intent;
            this.question = question;
            this.answer = answer;
            this.normalizedQuestion = normalizedQuestion;
        }
    }

    public static class ConceptAlias {
        public final String conceptId;
        public final String alias;
        public final String displayPhrase;
        public final Pattern pattern;

        public ConceptAlias(String conceptId, String alias, String displayPhrase) {
            this.conceptId = conceptId;
            this.alias = alias;
            this.displayPhrase = displayPhrase;
            this.pattern = Pattern.compile("\\b" + Pattern.quote(alias) + "\\b");
        }
    }

    public static class MatchedConcept {
        public final String conceptId;
        public final String alias;
        public final String displayPhrase;
        public final int start;
        public final int end;

        public MatchedConcept(String conceptId, String alias, String displayPhrase, int start, int end) {
            this.conceptId = conceptId;
            this.alias = alias;
            this.displayPhrase = displayPhrase;
            this.start = start;
            this.end = end;
        }
    }

    private static final List<ConceptAlias> CONCEPT_ALIASES = new ArrayList<>();
    private static final Map<String, String> TYPO_MAP = new HashMap<>();

    static {
        initTypoMap();
        initConceptAliases();
        // Sort aliases by length descending so longer, more specific multi-word phrases match first
        Collections.sort(CONCEPT_ALIASES, (a, b) -> Integer.compare(b.alias.length(), a.alias.length()));
    }

    private static void initTypoMap() {
        TYPO_MAP.put("wht", "what");
        TYPO_MAP.put("wat", "what");
        TYPO_MAP.put("r", "are");
        TYPO_MAP.put("u", "you");
        TYPO_MAP.put("ur", "your");
        TYPO_MAP.put("pls", "please");
        TYPO_MAP.put("plz", "please");
        TYPO_MAP.put("artifical", "artificial");
        TYPO_MAP.put("inteligence", "intelligence");
        TYPO_MAP.put("intellegence", "intelligence");
        TYPO_MAP.put("algorithum", "algorithm");
        TYPO_MAP.put("algorithums", "algorithms");
        TYPO_MAP.put("algoritm", "algorithm");
        TYPO_MAP.put("algoritms", "algorithms");
        TYPO_MAP.put("algo", "algorithm");
        TYPO_MAP.put("algos", "algorithms");
        TYPO_MAP.put("supervized", "supervised");
        TYPO_MAP.put("unsupervized", "unsupervised");
        TYPO_MAP.put("semisupervized", "semi-supervised");
        TYPO_MAP.put("reinforment", "reinforcement");
        TYPO_MAP.put("reinforcment", "reinforcement");
        TYPO_MAP.put("classifaction", "classification");
        TYPO_MAP.put("clasification", "classification");
        TYPO_MAP.put("regresion", "regression");
        TYPO_MAP.put("cluserting", "clustering");
        TYPO_MAP.put("clustring", "clustering");
        TYPO_MAP.put("aplication", "application");
        TYPO_MAP.put("aplications", "applications");
        TYPO_MAP.put("advantaj", "advantage");
        TYPO_MAP.put("advanteges", "advantages");
        TYPO_MAP.put("advanteg", "advantage");
        TYPO_MAP.put("disadvanteges", "disadvantages");
        TYPO_MAP.put("disadvantaj", "disadvantage");
        TYPO_MAP.put("exampel", "example");
        TYPO_MAP.put("exampels", "examples");
        TYPO_MAP.put("tecnique", "technique");
        TYPO_MAP.put("tecniques", "techniques");
        TYPO_MAP.put("definision", "definition");
        TYPO_MAP.put("defination", "definition");
        TYPO_MAP.put("differnce", "difference");
        TYPO_MAP.put("diffrence", "difference");
        TYPO_MAP.put("explian", "explain");
        TYPO_MAP.put("lern", "learn");
        TYPO_MAP.put("lerning", "learning");
        TYPO_MAP.put("convolutoin", "convolution");
        TYPO_MAP.put("convolusion", "convolution");
        TYPO_MAP.put("pennas", "pandas");
        TYPO_MAP.put("pandaz", "pandas");
        TYPO_MAP.put("padas", "pandas");
        TYPO_MAP.put("numpay", "numpy");
        TYPO_MAP.put("numpi", "numpy");
        TYPO_MAP.put("skleran", "scikit-learn");
        TYPO_MAP.put("sklean", "scikit-learn");
        TYPO_MAP.put("tenserflow", "tensorflow");
        TYPO_MAP.put("tensflow", "tensorflow");
        TYPO_MAP.put("pytroch", "pytorch");
        TYPO_MAP.put("pytrch", "pytorch");
        TYPO_MAP.put("trasnformer", "transformer");
        TYPO_MAP.put("trasformers", "transformers");
        TYPO_MAP.put("tokanize", "tokenize");
        TYPO_MAP.put("tokanization", "tokenization");
        TYPO_MAP.put("lemmatise", "lemmatize");
        TYPO_MAP.put("lematization", "lemmatization");
        TYPO_MAP.put("percision", "precision");
        TYPO_MAP.put("recal", "recall");
        TYPO_MAP.put("overfiting", "overfitting");
        TYPO_MAP.put("underfiting", "underfitting");
        TYPO_MAP.put("gradint", "gradient");
        TYPO_MAP.put("hiperparameter", "hyperparameter");
        TYPO_MAP.put("decison", "decision");
        TYPO_MAP.put("diffuson", "diffusion");
        TYPO_MAP.put("hallusination", "hallucination");
        TYPO_MAP.put("backpropogation", "backpropagation");
        TYPO_MAP.put("backpropogate", "backpropagation");
        TYPO_MAP.put("backprop", "backpropagation");
        TYPO_MAP.put("atention", "attention");
        TYPO_MAP.put("embeding", "embedding");
        TYPO_MAP.put("embedings", "embeddings");
        TYPO_MAP.put("dimensinality", "dimensionality");
        TYPO_MAP.put("dimentionality", "dimensionality");
        TYPO_MAP.put("segentation", "segmentation");
        TYPO_MAP.put("segmentaion", "segmentation");
        TYPO_MAP.put("crossvalidation", "cross validation");
        TYPO_MAP.put("qlearning", "q-learning");
        TYPO_MAP.put("mlops", "mlops");
    }

    private static void initConceptAliases() {
        // ==================== 1. ARTIFICIAL INTELLIGENCE ====================
        addAlias("types_of_ai", "types of ai");
        addAlias("types_of_ai", "stages of ai");
        addAlias("types_of_ai", "reactive machines");
        addAlias("types_of_ai", "limited memory");
        addAlias("types_of_ai", "theory of mind");

        addAlias("narrow_ai", "narrow ai");
        addAlias("narrow_ai", "weak ai");
        addAlias("narrow_ai", "ani");

        addAlias("general_ai", "artificial general intelligence");
        addAlias("general_ai", "general ai");
        addAlias("general_ai", "strong ai");
        addAlias("general_ai", "agi");

        addAlias("super_ai", "artificial superintelligence");
        addAlias("super_ai", "super ai");
        addAlias("super_ai", "asi");

        addAlias("ai_applications", "ai applications");
        addAlias("ai_applications", "applications of ai");
        addAlias("ai_applications", "uses of ai");

        addAlias("ai_agents", "ai agents");
        addAlias("ai_agents", "ai agent");
        addAlias("ai_agents", "intelligent agents");
        addAlias("ai_agents", "intelligent agent");

        addAlias("rational_agents", "rational agents");
        addAlias("rational_agents", "rational agent");
        addAlias("rational_agents", "peas framework");

        addAlias("environment_types", "environment types");
        addAlias("environment_types", "types of environment in ai");
        addAlias("environment_types", "environments in ai");

        addAlias("problem_solving_ai", "problem solving in ai");
        addAlias("problem_solving_ai", "state space search");
        addAlias("problem_solving_ai", "state space");

        addAlias("bfs", "breadth first search");
        addAlias("bfs", "breadth-first search");
        addAlias("bfs", "bfs");

        addAlias("dfs", "depth first search");
        addAlias("dfs", "depth-first search");
        addAlias("dfs", "dfs");

        addAlias("uniform_cost_search", "uniform cost search");
        addAlias("uniform_cost_search", "ucs");

        addAlias("greedy_best_first_search", "greedy best first search");
        addAlias("greedy_best_first_search", "greedy search");

        addAlias("a_star_search", "a* search");
        addAlias("a_star_search", "a star search");
        addAlias("a_star_search", "a* algorithm");
        addAlias("a_star_search", "a star algorithm");

        addAlias("minimax", "minimax algorithm");
        addAlias("minimax", "minimax");

        addAlias("alpha_beta_pruning", "alpha beta pruning");
        addAlias("alpha_beta_pruning", "alpha-beta pruning");

        addAlias("propositional_logic", "propositional logic");
        addAlias("propositional_logic", "proposition logic");

        addAlias("predicate_logic", "first order predicate logic");
        addAlias("predicate_logic", "first order logic");
        addAlias("predicate_logic", "predicate logic");
        addAlias("predicate_logic", "fol");

        addAlias("expert_systems", "expert systems");
        addAlias("expert_systems", "expert system");

        addAlias("inference_engine", "inference engine");
        addAlias("inference_engine", "forward chaining");
        addAlias("inference_engine", "backward chaining");

        addAlias("rule_based_systems", "rule based systems");
        addAlias("rule_based_systems", "rule-based systems");

        addAlias("fuzzy_logic", "fuzzy logic");
        addAlias("fuzzy_logic", "fuzzification");
        addAlias("fuzzy_logic", "defuzzification");

        addAlias("ai_ethics", "ethics in ai");
        addAlias("ai_ethics", "ai ethics");
        addAlias("ai_ethics", "responsible ai");

        addAlias("explainable_ai", "explainable ai");
        addAlias("explainable_ai", "xai");
        addAlias("explainable_ai", "shap");
        addAlias("explainable_ai", "lime");

        addAlias("ai_bias", "algorithmic bias");
        addAlias("ai_bias", "bias in ai");
        addAlias("ai_bias", "ai bias");

        addAlias("ai_safety", "ai safety");
        addAlias("ai_safety", "ai alignment");

        addAlias("data_privacy_ai", "differential privacy");
        addAlias("data_privacy_ai", "federated learning");
        addAlias("data_privacy_ai", "data privacy in ai");

        addAlias("ai_history", "history of ai");
        addAlias("ai_history", "turing test");
        addAlias("ai_history", "dartmouth conference");
        addAlias("ai_history", "ai winter");
        addAlias("ai_history", "alan turing");

        // ==================== 2. MACHINE LEARNING ====================
        addAlias("semi_supervised_learning", "semi-supervised learning");
        addAlias("semi_supervised_learning", "semi supervised learning");
        addAlias("semi_supervised_learning", "semi-supervised ml");
        addAlias("semi_supervised_learning", "semi supervised ml");

        addAlias("supervised_learning", "supervised machine learning");
        addAlias("supervised_learning", "supervised learning");
        addAlias("supervised_learning", "supervised ml");

        addAlias("unsupervised_learning", "unsupervised machine learning");
        addAlias("unsupervised_learning", "unsupervised learning");
        addAlias("unsupervised_learning", "unsupervised ml");

        addAlias("reinforcement_learning", "reinforcement learning");
        addAlias("reinforcement_learning", "reinforcement ml");
        addAlias("reinforcement_learning", "rl");

        addAlias("train_test_val_data", "train test split");
        addAlias("train_test_val_data", "training data");
        addAlias("train_test_val_data", "testing data");
        addAlias("train_test_val_data", "validation data");

        addAlias("labeled_dataset", "labeled dataset");
        addAlias("labeled_dataset", "labeled datasets");
        addAlias("labeled_dataset", "labeled data");

        addAlias("features_and_labels", "features and labels");
        addAlias("features_and_labels", "features in ml");
        addAlias("features_and_labels", "labels in ml");

        addAlias("regression", "regression");
        addAlias("classification", "classification");
        addAlias("clustering", "clustering");
        addAlias("clustering", "clusters");
        addAlias("clustering", "cluster");
        addAlias("clustering", "cluster analysis");

        addAlias("clustering_types", "types of clustering");
        addAlias("clustering_types", "clustering types");
        addAlias("clustering_types", "types of cluster");
        addAlias("clustering_types", "types of clusters");
        addAlias("clustering_types", "kinds of clustering");
        addAlias("clustering_types", "categories of clustering");

        addAlias("supervised_learning_types", "types of supervised learning");
        addAlias("supervised_learning_types", "supervised learning types");
        addAlias("unsupervised_learning_types", "types of unsupervised learning");
        addAlias("unsupervised_learning_types", "unsupervised learning types");
        addAlias("classification_types", "types of classification");
        addAlias("classification_types", "classification types");
        addAlias("regression_types", "types of regression");
        addAlias("regression_types", "regression types");

        addAlias("anomaly_detection", "anomaly detection");
        addAlias("anomaly_detection", "outlier detection");

        addAlias("feature_engineering", "feature engineering");
        addAlias("feature_selection", "feature selection");

        addAlias("feature_scaling", "feature scaling");
        addAlias("feature_scaling", "standardization");
        addAlias("feature_scaling", "normalization");
        addAlias("feature_scaling", "standardscaler");
        addAlias("feature_scaling", "minmaxscaler");

        addAlias("dimensionality_reduction", "dimensionality reduction");
        addAlias("dimensionality_reduction", "dimension reduction");

        addAlias("bias_variance_tradeoff", "bias variance tradeoff");
        addAlias("bias_variance_tradeoff", "bias variance trade off");
        addAlias("bias_variance_tradeoff", "bias vs variance");

        addAlias("overfitting", "overfitting");
        addAlias("overfitting", "over fitting");

        addAlias("underfitting", "underfitting");
        addAlias("underfitting", "under fitting");

        addAlias("cross_validation", "k fold cross validation");
        addAlias("cross_validation", "k-fold cross validation");
        addAlias("cross_validation", "cross-validation");
        addAlias("cross_validation", "cross validation");
        addAlias("cross_validation", "k-fold");

        addAlias("hyperparameter_tuning", "hyperparameter tuning");
        addAlias("hyperparameter_tuning", "grid search");
        addAlias("hyperparameter_tuning", "random search");
        addAlias("hyperparameter_tuning", "bayesian optimization");

        addAlias("model_evaluation", "model evaluation");

        // ==================== 3. ML ALGORITHMS ====================
        addAlias("multiple_linear_regression", "multiple linear regression");
        addAlias("multiple_linear_regression", "multiple regression");

        addAlias("polynomial_regression", "polynomial regression");

        addAlias("linear_regression", "linear regression");
        addAlias("linear_regression", "ordinary least squares");
        addAlias("linear_regression", "ols");

        addAlias("logistic_regression", "logistic regression");

        addAlias("knn", "k nearest neighbors");
        addAlias("knn", "k-nearest neighbors");
        addAlias("knn", "k nearest neighbor");
        addAlias("knn", "knn");

        addAlias("decision_tree", "decision trees");
        addAlias("decision_tree", "decision tree");

        addAlias("random_forest", "random forests");
        addAlias("random_forest", "random forest");
        addAlias("random_forest", "rf");

        addAlias("svm", "support vector machines");
        addAlias("svm", "support vector machine");
        addAlias("svm", "svm");

        addAlias("naive_bayes", "naive bayes classifier");
        addAlias("naive_bayes", "naive bayes");

        addAlias("kmeans", "k-means clustering");
        addAlias("kmeans", "k means clustering");
        addAlias("kmeans", "k-means");
        addAlias("kmeans", "k means");
        addAlias("kmeans", "kmeans");

        addAlias("hierarchical_clustering", "hierarchical clustering");
        addAlias("hierarchical_clustering", "agglomerative clustering");
        addAlias("hierarchical_clustering", "dendrogram");

        addAlias("dbscan", "dbscan");

        addAlias("pca", "principal component analysis");
        addAlias("pca", "pca");

        addAlias("gradient_descent", "gradient descent");
        addAlias("sgd", "stochastic gradient descent");
        addAlias("sgd", "sgd");

        addAlias("ensemble_learning", "ensemble learning");
        addAlias("ensemble_learning", "ensemble models");
        addAlias("ensemble_learning", "ensemble methods");

        addAlias("bagging", "bagging");
        addAlias("bagging", "bootstrap aggregating");

        addAlias("boosting", "boosting");

        addAlias("adaboost", "adaboost");
        addAlias("adaboost", "adaptive boosting");

        addAlias("gradient_boosting", "gradient boosting");
        addAlias("gradient_boosting", "gbdt");

        addAlias("xgboost", "xgboost");
        addAlias("xgboost", "extreme gradient boosting");
        addAlias("xgboost", "xgb");

        // ==================== 4. MODEL EVALUATION ====================
        addAlias("confusion_matrix", "confusion matrix");

        addAlias("roc_auc", "roc-auc");
        addAlias("roc_auc", "auc-roc");
        addAlias("roc_auc", "roc curve");
        addAlias("roc_auc", "auc score");
        addAlias("roc_auc", "roc");
        addAlias("roc_auc", "auc");

        addAlias("f1_score", "f1 score");
        addAlias("f1_score", "f1-score");
        addAlias("f1_score", "f1");

        addAlias("regression_metrics", "mean squared error");
        addAlias("regression_metrics", "mean absolute error");
        addAlias("regression_metrics", "root mean squared error");
        addAlias("regression_metrics", "r-squared");
        addAlias("regression_metrics", "r2 score");
        addAlias("regression_metrics", "rmse");
        addAlias("regression_metrics", "mae");
        addAlias("regression_metrics", "mse");

        addAlias("log_loss", "log loss");
        addAlias("log_loss", "cross-entropy loss");
        addAlias("log_loss", "cross entropy loss");

        addAlias("silhouette_score", "silhouette score");
        addAlias("silhouette_score", "silhouette analysis");

        // ==================== 5. DEEP LEARNING ====================
        addAlias("neural_network", "artificial neural networks");
        addAlias("neural_network", "artificial neural network");
        addAlias("neural_network", "neural networks");
        addAlias("neural_network", "neural network");
        addAlias("neural_network", "ann");

        addAlias("artificial_neuron", "artificial neuron");

        addAlias("neural_network_layers", "input layer");
        addAlias("neural_network_layers", "hidden layer");
        addAlias("neural_network_layers", "hidden layers");
        addAlias("neural_network_layers", "output layer");

        addAlias("weights_and_bias", "weights and bias");
        addAlias("weights_and_bias", "weights in neural networks");

        addAlias("activation_function", "activation functions");
        addAlias("activation_function", "activation function");
        addAlias("activation_function", "relu");
        addAlias("activation_function", "leaky relu");
        addAlias("activation_function", "sigmoid");
        addAlias("activation_function", "tanh");
        addAlias("activation_function", "softmax");
        addAlias("activation_function", "gelu");

        addAlias("forward_propagation", "forward propagation");
        addAlias("forward_propagation", "forward pass");

        addAlias("backpropagation", "backpropagation");
        addAlias("backpropagation", "back propagation");

        addAlias("loss_functions", "loss functions");
        addAlias("loss_functions", "loss function");

        addAlias("adam_optimizer", "adam optimizer");
        addAlias("adam_optimizer", "adam");
        addAlias("adam_optimizer", "adamw");

        addAlias("training_hyperparameters", "batch size");
        addAlias("training_hyperparameters", "epoch");
        addAlias("training_hyperparameters", "learning rate");
        addAlias("training_hyperparameters", "dropout");
        addAlias("training_hyperparameters", "batch normalization");
        addAlias("training_hyperparameters", "batch norm");

        addAlias("vanishing_gradient", "vanishing gradient problem");
        addAlias("vanishing_gradient", "vanishing gradient");
        addAlias("vanishing_gradient", "vanishing gradients");
        addAlias("vanishing_gradient", "exploding gradient problem");
        addAlias("vanishing_gradient", "exploding gradient");
        addAlias("vanishing_gradient", "exploding gradients");

        addAlias("cnn", "convolutional neural networks");
        addAlias("cnn", "convolutional neural network");
        addAlias("cnn", "cnn");
        addAlias("cnn", "cnns");

        addAlias("rnn", "recurrent neural networks");
        addAlias("rnn", "recurrent neural network");
        addAlias("rnn", "rnn");
        addAlias("rnn", "rnns");

        addAlias("lstm", "long short-term memory");
        addAlias("lstm", "long short term memory");
        addAlias("lstm", "lstm");
        addAlias("lstm", "lstms");

        addAlias("gru", "gated recurrent unit");
        addAlias("gru", "gated recurrent units");
        addAlias("gru", "gru");
        addAlias("gru", "grus");

        addAlias("autoencoders", "autoencoders");
        addAlias("autoencoders", "autoencoder");
        addAlias("autoencoders", "variational autoencoder");
        addAlias("autoencoders", "vae");

        addAlias("transfer_learning", "transfer learning");

        // ==================== 6. NLP ====================
        addAlias("text_preprocessing", "text preprocessing");
        addAlias("text_preprocessing", "text cleaning");

        addAlias("sentence_word_tokenization", "sentence tokenization");
        addAlias("sentence_word_tokenization", "word tokenization");

        addAlias("stop_words", "stop words");
        addAlias("stop_words", "stop word");

        addAlias("stemming", "stemming");
        addAlias("stemming", "stemmer");

        addAlias("lemmatization", "lemmatization");
        addAlias("lemmatization", "lemmatize");

        addAlias("bag_of_words", "bag of words");
        addAlias("bag_of_words", "bow");

        addAlias("tfidf", "term frequency inverse document frequency");
        addAlias("tfidf", "tf-idf");
        addAlias("tfidf", "tf idf");
        addAlias("tfidf", "tfidf");

        addAlias("ngrams", "n-grams");
        addAlias("ngrams", "ngrams");
        addAlias("ngrams", "bigrams");
        addAlias("ngrams", "trigrams");

        addAlias("word_embeddings", "word embeddings");
        addAlias("word_embeddings", "word embedding");

        addAlias("word2vec", "word2vec");
        addAlias("word2vec", "cbow");
        addAlias("word2vec", "skip-gram");

        addAlias("glove", "glove");
        addAlias("fasttext", "fasttext");

        addAlias("sentiment_analysis", "sentiment analysis");

        addAlias("text_classification", "text classification");

        addAlias("ner", "named entity recognition");
        addAlias("ner", "ner");

        addAlias("pos_tagging", "pos tagging");
        addAlias("pos_tagging", "part of speech tagging");

        addAlias("nlp_applications_extended", "language detection");
        addAlias("nlp_applications_extended", "text summarization");
        addAlias("nlp_applications_extended", "machine translation");
        addAlias("nlp_applications_extended", "question answering");
        addAlias("nlp_applications_extended", "speech recognition");

        addAlias("nlp", "natural language processing");
        addAlias("nlp", "nlp");

        // ==================== 7. TRANSFORMERS ====================
        addAlias("transformers", "transformer architecture");
        addAlias("transformers", "transformers");
        addAlias("transformers", "transformer");

        addAlias("transformer_components", "encoder decoder");
        addAlias("transformer_components", "query key value");
        addAlias("transformer_components", "self-attention");
        addAlias("transformer_components", "multi-head attention");

        addAlias("positional_encoding", "positional encoding");
        addAlias("positional_encoding", "positional encodings");

        addAlias("bert", "bert");
        addAlias("gpt", "gpt-4");
        addAlias("gpt", "gpt-3");
        addAlias("gpt", "chatgpt");
        addAlias("gpt", "gpt");

        addAlias("t5", "t5 model");
        addAlias("t5", "t5");

        addAlias("encoder_only_models", "encoder-only models");
        addAlias("encoder_only_models", "encoder only models");

        addAlias("decoder_only_models", "decoder-only models");
        addAlias("decoder_only_models", "decoder only models");

        addAlias("encoder_decoder_models", "encoder-decoder models");
        addAlias("encoder_decoder_models", "encoder decoder models");

        // ==================== 8. COMPUTER VISION ====================
        addAlias("image_processing", "image processing");

        addAlias("image_representation", "image representation");
        addAlias("image_representation", "grayscale");
        addAlias("image_representation", "pixels");

        addAlias("object_detection", "object detection");

        addAlias("semantic_segmentation", "semantic segmentation");
        addAlias("instance_segmentation", "instance segmentation");

        addAlias("image_segmentation", "image segmentation");

        addAlias("opencv_and_faces", "face recognition");
        addAlias("opencv_and_faces", "face detection");
        addAlias("opencv_and_faces", "opencv");
        addAlias("opencv_and_faces", "ocr");

        addAlias("yolo", "you only look once");
        addAlias("yolo", "yolo");

        addAlias("computer_vision", "computer vision");
        addAlias("computer_vision", "cv");

        // ==================== 9. GENERATIVE AI ====================
        addAlias("llm", "large language models");
        addAlias("llm", "large language model");
        addAlias("llm", "llms");
        addAlias("llm", "llm");

        addAlias("prompt_engineering", "prompt engineering");
        addAlias("prompt_engineering", "zero-shot prompting");
        addAlias("prompt_engineering", "few-shot prompting");
        addAlias("prompt_engineering", "chain of thought");
        addAlias("prompt_engineering", "cot");

        addAlias("rag", "retrieval augmented generation");
        addAlias("rag", "retrieval-augmented generation");
        addAlias("rag", "rag");

        addAlias("fine_tuning", "fine-tuning");
        addAlias("fine_tuning", "instruction tuning");
        addAlias("fine_tuning", "qlora");
        addAlias("fine_tuning", "rlhf");

        addAlias("lora", "low-rank adaptation");
        addAlias("lora", "lora");

        addAlias("genai_parameters", "context window");
        addAlias("genai_parameters", "hallucination");
        addAlias("genai_parameters", "temperature in llm");
        addAlias("genai_parameters", "token limits");

        addAlias("generative_ai", "generative ai");
        addAlias("generative_ai", "gen ai");
        addAlias("generative_ai", "genai");

        addAlias("gan", "generative adversarial networks");
        addAlias("gan", "generative adversarial network");
        addAlias("gan", "gans");
        addAlias("gan", "gan");

        // ==================== 10. DATA SCIENCE & PYTHON ====================
        addAlias("data_science_lifecycle", "data collection");
        addAlias("data_science_lifecycle", "data cleaning");

        addAlias("missing_values_and_outliers", "missing values");
        addAlias("missing_values_and_outliers", "duplicate data");
        addAlias("missing_values_and_outliers", "outliers");

        addAlias("data_visualization", "data visualization");

        addAlias("numpy", "numpy array");
        addAlias("numpy", "numpy");

        addAlias("pandas", "pandas dataframe");
        addAlias("pandas", "dataframe");
        addAlias("pandas", "pandas");

        addAlias("matplotlib", "matplotlib");
        addAlias("matplotlib", "seaborn");

        addAlias("scikit_learn", "scikit-learn");
        addAlias("scikit_learn", "scikit learn");
        addAlias("scikit_learn", "sklearn");

        addAlias("tensorflow_and_pytorch", "tensorflow");
        addAlias("tensorflow_and_pytorch", "pytorch");
        addAlias("tensorflow_and_pytorch", "keras");

        addAlias("sklearn_pipelines", "pipelines in sklearn");
        addAlias("sklearn_pipelines", "sklearn pipeline");
        addAlias("sklearn_pipelines", "pipelines");

        // ==================== 11. ADVANCED AI/ML ====================
        addAlias("mdp", "markov decision process");
        addAlias("mdp", "mdp");

        addAlias("q_learning", "deep q-network");
        addAlias("q_learning", "deep q network");
        addAlias("q_learning", "q-learning");
        addAlias("q_learning", "q learning");
        addAlias("q_learning", "dqn");

        addAlias("recommendation_systems", "recommendation systems");
        addAlias("recommendation_systems", "recommender systems");

        addAlias("time_series_forecasting", "time series forecasting");
        addAlias("time_series_forecasting", "time series");
        addAlias("time_series_forecasting", "forecasting");

        addAlias("mlops", "model deployment");
        addAlias("mlops", "model monitoring");
        addAlias("mlops", "model drift");
        addAlias("mlops", "data drift");
        addAlias("mlops", "mlops");

        // Broad Parent Concepts
        addAlias("deep_learning", "deep learning");
        addAlias("deep_learning", "dl");

        addAlias("machine_learning", "machine learning");
        addAlias("machine_learning", "ml");

        addAlias("ai_fundamentals", "artificial intelligence");
        addAlias("ai_fundamentals", "ai");

        initProgrammingAndCsAliases();
    }

    private static void initProgrammingAndCsAliases() {
        // ==================== 12. PROGRAMMING LANGUAGES ====================
        addAlias("programming_language", "programming languages");
        addAlias("programming_language", "programming language");

        addAlias("python", "python programming");
        addAlias("python", "python language");
        addAlias("python", "python");

        addAlias("java", "java programming");
        addAlias("java", "java language");
        addAlias("java", "java");

        addAlias("c_programming", "c programming language");
        addAlias("c_programming", "c programming");
        addAlias("c_programming", "c language");

        addAlias("cpp_programming", "c plus plus");
        addAlias("cpp_programming", "cpp programming");
        addAlias("cpp_programming", "c++ programming");
        addAlias("cpp_programming", "cpp");
        addAlias("cpp_programming", "c++");

        addAlias("csharp_programming", "c sharp programming");
        addAlias("csharp_programming", "c# programming");
        addAlias("csharp_programming", "c sharp");
        addAlias("csharp_programming", "csharp");
        addAlias("csharp_programming", "c#");

        addAlias("javascript", "javascript programming");
        addAlias("javascript", "javascript language");
        addAlias("javascript", "javascript");
        addAlias("javascript", "js");

        addAlias("typescript", "typescript programming");
        addAlias("typescript", "typescript");
        addAlias("typescript", "ts");

        addAlias("html", "hypertext markup language");
        addAlias("html", "html5");
        addAlias("html", "html");

        addAlias("css", "cascading style sheets");
        addAlias("css", "css3");
        addAlias("css", "css");

        addAlias("sql", "structured query language");
        addAlias("sql", "sql query");
        addAlias("sql", "sql");

        addAlias("php", "php programming");
        addAlias("php", "php language");
        addAlias("php", "php");

        addAlias("kotlin", "kotlin programming");
        addAlias("kotlin", "kotlin language");
        addAlias("kotlin", "kotlin");

        addAlias("swift", "swift programming");
        addAlias("swift", "swift language");
        addAlias("swift", "swift");

        addAlias("rust", "rust programming");
        addAlias("rust", "rust language");
        addAlias("rust", "rust");

        addAlias("go_programming", "golang programming");
        addAlias("go_programming", "go programming");
        addAlias("go_programming", "golang");
        addAlias("go_programming", "go language");

        // ==================== 13. COMPUTER SCIENCE TOPICS ====================
        // OOP
        addAlias("oop", "object oriented programming concepts");
        addAlias("oop", "object oriented programming");
        addAlias("oop", "object-oriented programming");
        addAlias("oop", "oop concepts");
        addAlias("oop", "oops concepts");
        addAlias("oop", "oops");
        addAlias("oop", "oop");

        addAlias("class_concept", "class in oop");
        addAlias("class_concept", "classes in oop");
        addAlias("class_concept", "class");
        addAlias("class_concept", "classes");

        addAlias("object_concept", "object in oop");
        addAlias("object_concept", "objects in oop");
        addAlias("object_concept", "objects");
        addAlias("object_concept", "object");

        addAlias("inheritance", "types of inheritance");
        addAlias("inheritance", "inheritance in oop");
        addAlias("inheritance", "inheritance");

        addAlias("polymorphism", "types of polymorphism");
        addAlias("polymorphism", "polymorphism in oop");
        addAlias("polymorphism", "polymorphism");

        addAlias("encapsulation", "encapsulation in oop");
        addAlias("encapsulation", "data encapsulation");
        addAlias("encapsulation", "encapsulation");

        addAlias("abstraction", "data abstraction");
        addAlias("abstraction", "abstraction in oop");
        addAlias("abstraction", "abstraction");

        // Data Structures
        addAlias("data_structure", "types of data structures");
        addAlias("data_structure", "data structures");
        addAlias("data_structure", "data structure");

        addAlias("array", "array data structure");
        addAlias("array", "types of array");
        addAlias("array", "arrays");
        addAlias("array", "array");

        addAlias("linked_list", "singly linked list");
        addAlias("linked_list", "doubly linked list");
        addAlias("linked_list", "circular linked list");
        addAlias("linked_list", "types of linked list");
        addAlias("linked_list", "linked list");
        addAlias("linked_list", "linked lists");

        addAlias("stack", "stack data structure");
        addAlias("stack", "lifo data structure");
        addAlias("stack", "stacks");
        addAlias("stack", "stack");

        addAlias("queue", "queue data structure");
        addAlias("queue", "circular queue");
        addAlias("queue", "priority queue");
        addAlias("queue", "types of queue");
        addAlias("queue", "queues");
        addAlias("queue", "queue");

        addAlias("binary_search_tree", "binary search tree");
        addAlias("binary_search_tree", "bst");

        addAlias("tree_ds", "tree data structure");
        addAlias("tree_ds", "trees data structure");
        addAlias("tree_ds", "binary tree");
        addAlias("tree_ds", "tree");
        addAlias("tree_ds", "trees");

        addAlias("graph_ds", "graph data structure");
        addAlias("graph_ds", "graphs data structure");
        addAlias("graph_ds", "graphs");
        addAlias("graph_ds", "graph");

        addAlias("hash_table", "hash table data structure");
        addAlias("hash_table", "hash table");
        addAlias("hash_table", "hash tables");
        addAlias("hash_table", "hash map");
        addAlias("hash_table", "hashmap");

        // Algorithms
        addAlias("algorithm_concept", "algorithm concept");
        addAlias("algorithm_concept", "algorithms");
        addAlias("algorithm_concept", "algorithm");

        addAlias("time_complexity", "time complexity");
        addAlias("time_complexity", "big o notation");
        addAlias("time_complexity", "big o");

        addAlias("space_complexity", "space complexity");

        addAlias("sorting_algorithms", "types of sorting algorithms");
        addAlias("sorting_algorithms", "types of sorting");
        addAlias("sorting_algorithms", "sorting algorithms");
        addAlias("sorting_algorithms", "sorting algorithm");
        addAlias("sorting_algorithms", "sorting");

        addAlias("searching_algorithms", "types of searching algorithms");
        addAlias("searching_algorithms", "types of searching");
        addAlias("searching_algorithms", "searching algorithms");
        addAlias("searching_algorithms", "searching algorithm");
        addAlias("searching_algorithms", "searching");

        addAlias("recursion", "recursion in programming");
        addAlias("recursion", "recursive function");
        addAlias("recursion", "recursion");

        // DBMS
        addAlias("dbms", "database management system");
        addAlias("dbms", "database management");
        addAlias("dbms", "rdbms");
        addAlias("dbms", "dbms");
        addAlias("dbms", "database");

        addAlias("acid_properties", "acid properties in dbms");
        addAlias("acid_properties", "acid properties");
        addAlias("acid_properties", "acid property");
        addAlias("acid_properties", "acid");

        addAlias("database_keys", "keys in dbms");
        addAlias("database_keys", "types of keys in dbms");
        addAlias("database_keys", "primary key");
        addAlias("database_keys", "foreign key");
        addAlias("database_keys", "candidate key");

        addAlias("normalization_dbms", "normalization in dbms");
        addAlias("normalization_dbms", "normal forms in dbms");
        addAlias("normalization_dbms", "normalization");

        // Operating System
        addAlias("operating_system", "types of operating systems");
        addAlias("operating_system", "types of os");
        addAlias("operating_system", "operating system");
        addAlias("operating_system", "os");

        addAlias("process_vs_thread", "difference between process and thread");
        addAlias("process_vs_thread", "process vs thread");
        addAlias("process_vs_thread", "thread vs process");

        addAlias("deadlock_conditions", "deadlock conditions");
        addAlias("deadlock_conditions", "conditions for deadlock");
        addAlias("deadlock_conditions", "coffman conditions");
        addAlias("deadlock", "deadlock in operating system");
        addAlias("deadlock", "deadlock in os");
        addAlias("deadlock", "deadlock");
        addAlias("deadlock", "deadlocks");

        addAlias("virtual_memory", "virtual memory in os");
        addAlias("virtual_memory", "virtual memory");

        // Computer Networks
        addAlias("computer_network", "types of computer networks");
        addAlias("computer_network", "types of networks");
        addAlias("computer_network", "computer networks");
        addAlias("computer_network", "computer network");
        addAlias("computer_network", "networking");

        addAlias("osi_model", "layers of osi model");
        addAlias("osi_model", "7 layers of osi");
        addAlias("osi_model", "osi reference model");
        addAlias("osi_model", "osi model");
        addAlias("osi_model", "osi layers");
        addAlias("osi_model", "osi");

        addAlias("tcp_vs_udp", "difference between tcp and udp");
        addAlias("tcp_vs_udp", "tcp vs udp");
        addAlias("tcp_vs_udp", "udp vs tcp");

        addAlias("compiler_vs_interpreter", "difference between compiler and interpreter");
        addAlias("compiler_vs_interpreter", "compiler vs interpreter");
        addAlias("compiler_vs_interpreter", "interpreter vs compiler");
    }

    private static void addAlias(String conceptId, String alias) {
        CONCEPT_ALIASES.add(new ConceptAlias(conceptId, alias.toLowerCase(Locale.ROOT), alias));
    }

    private static final String[] FOLLOWUP_FACETS = {
            "type", "types", "kind", "kinds", "category", "categories", "variety", "varieties", "subtypes", "sub-types",
            "advantage", "advantages", "benefit", "benefits", "pro", "pros", "strength", "strengths",
            "disadvantage", "disadvantages", "limitation", "limitations", "drawback", "drawbacks", "con", "cons",
            "algorithm", "algorithms", "algo", "algos", "method", "methods", "technique", "techniques", "models",
            "application", "applications", "use", "uses", "where is it used", "where used", "why is it used", "used for",
            "use cases", "real world",
            "example", "examples", "sample", "samples", "give examples", "give example", "instances",
            "how does it work", "how do they work", "how it works", "working", "work", "mechanism", "workflow",
            "step", "steps", "stage", "stages", "pipeline", "process", "lifecycle",
            "architecture", "structure", "features", "characteristics", "property", "properties",
            "difference", "differences", "compare", "comparison"
    };

    private static final String[] FOLLOWUP_ELABORATION_PHRASES = {
            "what is it", "what are they", "what does it mean", "meaning of it", "its meaning", "definition of it",
            "explain it", "explain this", "explain that", "explain them", "explain more",
            "tell me about it", "tell me more", "tell about it", "tell me more about it",
            "can you explain it", "could you explain it", "please explain it",
            "more details", "elaborate", "related to this", "what about it", "what about this"
    };

    private final List<QAPair> datasetList = new ArrayList<>();
    private final Map<String, List<QAPair>> intentMap = new HashMap<>();
    private final Map<String, String> greetingMap = new HashMap<>();
    private final Set<String> loadedQuestionSet = new HashSet<>();

    // Multi-turn Conversation Context State
    private String lastConceptId = null;
    private String lastConceptPhrase = null;
    private String lastIntent = null;

    public ChatbotDatasetHelper(Context context) {
        loadGreetings();
        loadDataset(context);
    }

    // Package-private constructor for unit testing with InputStream
    ChatbotDatasetHelper(InputStream inputStream) {
        loadGreetings();
        loadDatasetStream(inputStream);
    }

    public void resetContext() {
        this.lastConceptId = null;
        this.lastConceptPhrase = null;
        this.lastIntent = null;
    }

    public String getLastConceptId() {
        return lastConceptId;
    }

    public String getLastConceptPhrase() {
        return lastConceptPhrase;
    }

    private void loadGreetings() {
        String assistantIntro = "Hello! I am ChAI, your AI assistant. I can help you with programming, machine learning, AIML, and general questions.";
        greetingMap.put("hi", assistantIntro);
        greetingMap.put("hii", assistantIntro);
        greetingMap.put("hello", assistantIntro);
        greetingMap.put("hey", assistantIntro);
        greetingMap.put("who are you", assistantIntro);
        greetingMap.put("who are you?", assistantIntro);
        greetingMap.put("who are u", assistantIntro);
        greetingMap.put("who are u?", assistantIntro);
        greetingMap.put("what is your name", assistantIntro);
        greetingMap.put("what is your name?", assistantIntro);
        greetingMap.put("good morning", "Good morning! ☀️ How can I help you with Artificial Intelligence and Machine Learning?");
        greetingMap.put("good afternoon", "Good afternoon! How can I help you with Artificial Intelligence and Machine Learning?");
        greetingMap.put("good evening", "Good evening! How can I help you with Artificial Intelligence and Machine Learning?");
        greetingMap.put("namaste", "Namaste! 🙏 How can I help you with Artificial Intelligence and Machine Learning?");
        greetingMap.put("how are you", "I'm doing great, thank you! 😊 How can I help you with AI and Machine Learning today?");
        greetingMap.put("how are u", "I'm doing great, thank you! 😊 How can I help you with AI and Machine Learning today?");
        greetingMap.put("how r u", "I'm doing great, thank you! 😊 How can I help you with AI and Machine Learning today?");
        greetingMap.put("are you fine", "Yes, I am doing great! Thank you. How can I help you with AI and Machine Learning?");
        greetingMap.put("thank you", "You're welcome! 😊 Feel free to ask any other questions about AI and Machine Learning.");
        greetingMap.put("thanks", "You're welcome! 😊 Feel free to ask any other questions about AI and Machine Learning.");
        greetingMap.put("thanks a lot", "You're welcome! 😊 Feel free to ask any other questions about AI and Machine Learning.");
        greetingMap.put("bye", "Goodbye! 👋 Feel free to return anytime you have questions about AI and Machine Learning.");
        greetingMap.put("goodbye", "Goodbye! 👋 Feel free to return anytime you have questions about AI and Machine Learning.");
        greetingMap.put("good night", "Good night! 🌙 Feel free to return anytime with your AI questions.");
    }

    private void loadDataset(Context context) {
        String[] filesToTry = {"AIML_NLP_200plus_Dataset.csv", "AIML_Question_Answer_Dataset.csv", "chatbot_dataset.csv"};
        for (String filename : filesToTry) {
            try {
                InputStream inputStream = context.getAssets().open(filename);
                loadDatasetStream(inputStream);
            } catch (Exception ignored) {
            }
        }
    }

    private void loadDatasetStream(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                line = line.trim();
                if (line.isEmpty()) continue;

                List<String> parsedRow = parseCsvLine(line);
                if (parsedRow.size() >= 3) {
                    String intent = cleanField(parsedRow.get(0));
                    String question = cleanField(parsedRow.get(1));
                    String answer = cleanField(parsedRow.get(2));

                    if (!question.isEmpty() && !answer.isEmpty()) {
                        String normQ = cleanAndNormalize(question);
                        if (loadedQuestionSet.contains(normQ)) {
                            continue;
                        }
                        loadedQuestionSet.add(normQ);

                        QAPair pair = new QAPair(intent, question, answer, normQ);
                        datasetList.add(pair);

                        List<QAPair> pairsForIntent = intentMap.get(intent);
                        if (pairsForIntent == null) {
                            pairsForIntent = new ArrayList<>();
                            intentMap.put(intent, pairsForIntent);
                        }
                        pairsForIntent.add(pair);
                    }
                }
            }
            reader.close();
        } catch (Exception ignored) {
        }
    }

    private String cleanField(String field) {
        if (field == null) return "";
        field = field.trim();
        if (field.startsWith("\"") && field.endsWith("\"") && field.length() >= 2) {
            field = field.substring(1, field.length() - 1).trim();
        }
        return field;
    }

    private List<String> parseCsvLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(sb.toString().trim());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString().trim());
        return result;
    }

    /**
     * Cleans text, resolves grammar / typos, strips punctuation, and collapses whitespace.
     */
    public String cleanAndNormalize(String input) {
        if (input == null) return "";

        String text = input.toLowerCase(Locale.ROOT).trim();
        // Resolve symbols before stripping punctuation
        text = text.replaceAll("\\bc\\+\\+", "cpp");
        text = text.replaceAll("\\bc\\#", "csharp");
        text = text.replaceAll("\\ba\\*", "a star");
        text = text.replaceAll("\\b2-mark\\b", "2 mark");
        text = text.replaceAll("\\b5-mark\\b", "5 mark");

        // Resolve apostrophes and anaphora variations
        text = text.replaceAll("\\bit's\\b", "its");
        text = text.replaceAll("\\bit s\\b", "its");

        // Convert non-alphanumeric punctuation to spaces
        text = text.replaceAll("[^a-z0-9\\s]", " ");

        // Word-level typo correction
        String[] tokens = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String t : tokens) {
            if (!t.isEmpty()) {
                String corrected = TYPO_MAP.get(t);
                sb.append(corrected != null ? corrected : t).append(" ");
            }
        }
        String res = sb.toString().trim();

        // Grammatical phrase normalizations
        res = res.replaceAll("\\bits type\\b", "its types");
        res = res.replaceAll("\\bml has which types\\b", "types of ml");
        res = res.replaceAll("\\bwhich types of ml are there\\b", "types of ml");
        res = res.replaceAll("\\btell me ml types\\b", "types of ml");

        return res;
    }

    private String checkGreeting(String rawInput, String normInput) {
        String rawLower = rawInput.toLowerCase(Locale.ROOT).trim();
        if (greetingMap.containsKey(rawLower)) {
            return greetingMap.get(rawLower);
        }
        if (greetingMap.containsKey(normInput)) {
            return greetingMap.get(normInput);
        }
        return null;
    }

    private QuestionType detectQuestionType(String norm) {
        String q = " " + norm + " ";

        // DIFFERENCE
        String[] diffPhrases = {
                " difference between ", " differences between ", " diff between ",
                " vs ", " versus ", " compare ", " comparison between ", " differ from ", " differs from "
        };
        for (String p : diffPhrases) {
            if (q.contains(p)) return QuestionType.DIFFERENCE;
        }

        // TYPES
        String[] typePhrases = {
                " types of ", " types ", " type of ", " kinds of ", " kinds ", " kind of ",
                " categories of ", " categories ", " category of ", " varieties of ",
                " varieties ", " subtypes ", " sub types ", " classes of ",
                " which types ", " has which types ", " types are there "
        };
        for (String p : typePhrases) {
            if (q.contains(p)) return QuestionType.TYPES;
        }

        // ALGORITHMS (also covers methods, models, and techniques)
        String[] algoPhrases = {
                " algorithms of ", " algorithms in ", " algorithms used in ", " algorithms used ",
                " algorithms ", " algorithm of ", " algorithm in ", " algorithm ",
                " methods of ", " methods in ", " methods ",
                " techniques of ", " techniques in ", " techniques ", " models in ",
                " algo used in ", " algo of ", " algo "
        };
        for (String p : algoPhrases) {
            if (q.contains(p)) return QuestionType.ALGORITHMS;
        }

        // APPLICATIONS (uses, where used, why used)
        String[] appPhrases = {
                " applications of ", " applications in ", " application of ", " applications ",
                " uses of ", " use cases ", " where is it used ", " where used ", " why is it used ",
                " where is ", " why is ", " used for ", " real world applications "
        };
        for (String p : appPhrases) {
            if (q.contains(p)) return QuestionType.APPLICATIONS;
        }

        // ADVANTAGES (benefits, pros)
        String[] advPhrases = {
                " advantages of ", " advantage of ", " advantages ",
                " benefits of ", " benefit of ", " benefits ", " pros of ", " strengths of "
        };
        for (String p : advPhrases) {
            if (q.contains(p)) return QuestionType.ADVANTAGES;
        }

        // DISADVANTAGES (limitations, drawbacks, cons)
        String[] disPhrases = {
                " disadvantages of ", " disadvantage of ", " disadvantages ",
                " limitations of ", " limitation of ", " limitations ",
                " drawbacks of ", " drawbacks ", " cons of ", " challenges of "
        };
        for (String p : disPhrases) {
            if (q.contains(p)) return QuestionType.DISADVANTAGES;
        }

        // EXAMPLES
        String[] exPhrases = {
                " examples of ", " example of ", " examples ", " example ",
                " give examples ", " give example ", " sample ", " samples ", " real world examples "
        };
        for (String p : exPhrases) {
            if (q.contains(p)) return QuestionType.EXAMPLES;
        }

        // WORKING (how does it work)
        String[] workPhrases = {
                " how does it work ", " how do they work ", " how it works ", " how does ",
                " how do ", " working of ", " working ", " mechanism of ", " workflow of "
        };
        for (String p : workPhrases) {
            if (q.contains(p)) return QuestionType.WORKING;
        }

        // STEPS
        String[] stepPhrases = {
                " steps in ", " steps of ", " steps ", " pipeline of ",
                " pipeline ", " stages of ", " phases of ", " process of ", " lifecycle of "
        };
        for (String p : stepPhrases) {
            if (q.contains(p)) return QuestionType.STEPS;
        }

        // ARCHITECTURE
        String[] archPhrases = {
                " architecture of ", " architecture ", " structure of ", " components of ", " layers in "
        };
        for (String p : archPhrases) {
            if (q.contains(p)) return QuestionType.ARCHITECTURE;
        }

        // FEATURES
        String[] featPhrases = {
                " features of ", " features ", " characteristics of ", " properties of "
        };
        for (String p : featPhrases) {
            if (q.contains(p)) return QuestionType.FEATURES;
        }

        // EXPLAIN (Student/Exam Explanation Questions: "Explain ML", "Explain Supervised Learning", "Describe", "In detail")
        String[] explainPhrases = {
                " explain ", " describe ", " elaborate ", " details of ", " in detail ",
                " detailed explanation of ", " overview of "
        };
        for (String p : explainPhrases) {
            if (q.contains(p)) return QuestionType.EXPLAIN;
        }

        return QuestionType.DEFINITION;
    }

    /**
     * Finds non-overlapping concepts ordered by starting position in user string.
     * Longer aliases are matched first so 'semi-supervised learning' is matched
     * instead of subphrase 'supervised learning'.
     */
    List<MatchedConcept> detectConcepts(String norm) {
        List<MatchedConcept> result = new ArrayList<>();
        boolean[] occupied = new boolean[norm.length()];

        for (ConceptAlias ca : CONCEPT_ALIASES) {
            Matcher matcher = ca.pattern.matcher(norm);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                boolean overlaps = false;
                for (int i = start; i < end; i++) {
                    if (occupied[i]) {
                        overlaps = true;
                        break;
                    }
                }
                if (!overlaps) {
                    for (int i = start; i < end; i++) {
                        occupied[i] = true;
                    }
                    result.add(new MatchedConcept(ca.conceptId, ca.alias, ca.displayPhrase, start, end));
                }
            }
        }

        // Sort by start index in sentence
        Collections.sort(result, (a, b) -> Integer.compare(a.start, b.start));
        return result;
    }

    private boolean isValidFollowUp(String normQuery, String lastConcept) {
        if (lastConcept == null || lastConcept.isEmpty()) {
            return false;
        }

        String spaced = " " + normQuery + " ";
        String[] pronouns = {"its", "it", "they", "them", "this", "that", "these", "those"};
        for (String p : pronouns) {
            if (spaced.contains(" " + p + " ")) {
                return true;
            }
        }

        for (String phrase : FOLLOWUP_ELABORATION_PHRASES) {
            if (normQuery.contains(phrase)) {
                return true;
            }
        }

        for (String facet : FOLLOWUP_FACETS) {
            Pattern p = Pattern.compile("\\b" + Pattern.quote(facet) + "\\b");
            if (p.matcher(normQuery).find()) {
                return true;
            }
        }

        return false;
    }

    private String resolveFollowUpQuery(String normQuery, String topicPhrase) {
        if (topicPhrase == null || topicPhrase.isEmpty()) {
            return normQuery;
        }

        String result = " " + normQuery + " ";
        String[] pronounWords = {"its", "it", "they", "them", "this", "that", "these", "those"};
        boolean replaced = false;
        for (String p : pronounWords) {
            String target = " " + p + " ";
            if (result.contains(target)) {
                result = result.replaceFirst(Pattern.quote(target), " " + Matcher.quoteReplacement(topicPhrase) + " ");
                replaced = true;
                break;
            }
        }

        result = result.replace(" related to this ", " " + topicPhrase + " ");
        result = result.replace(" types of it ", " types of " + topicPhrase + " ");
        result = result.replace(" about it ", " about " + topicPhrase + " ");
        result = result.replace(" of it ", " of " + topicPhrase + " ");

        result = result.replaceAll("\\s+", " ").trim();

        if (!replaced && !result.contains(topicPhrase)) {
            result = result + " " + topicPhrase;
        }

        return result.replaceAll("\\s+", " ").trim();
    }

    private String resolveDifference(String c1, String c2) {
        String p1 = c1 + "_vs_" + c2;
        String p2 = c2 + "_vs_" + c1;

        if (DeepKnowledgeBank.hasRichExplanation(p1)) return DeepKnowledgeBank.getRichExplanation(p1);
        if (DeepKnowledgeBank.hasRichExplanation(p2)) return DeepKnowledgeBank.getRichExplanation(p2);

        Set<String> set = new HashSet<>();
        set.add(c1);
        set.add(c2);

        if (set.contains("ai_fundamentals") && set.contains("machine_learning")) {
            return DeepKnowledgeBank.getRichExplanation("ai_vs_ml");
        }
        if (set.contains("machine_learning") && set.contains("deep_learning")) {
            return DeepKnowledgeBank.getRichExplanation("ml_vs_dl");
        }
        if (set.contains("supervised_learning") && set.contains("unsupervised_learning")) {
            return DeepKnowledgeBank.getRichExplanation("supervised_vs_unsupervised");
        }
        if (set.contains("classification") && set.contains("regression")) {
            return DeepKnowledgeBank.getRichExplanation("classification_vs_regression");
        }
        if (set.contains("overfitting") && set.contains("underfitting")) {
            return DeepKnowledgeBank.getRichExplanation("overfitting_vs_underfitting");
        }
        if (set.contains("decision_tree") && set.contains("random_forest")) {
            return DeepKnowledgeBank.getRichExplanation("decision_tree_vs_random_forest");
        }
        if (set.contains("cnn") && set.contains("rnn")) {
            return DeepKnowledgeBank.getRichExplanation("cnn_vs_rnn");
        }
        if (set.contains("stemming") && set.contains("lemmatization")) {
            return DeepKnowledgeBank.getRichExplanation("stemming_vs_lemmatization");
        }
        if (set.contains("bagging") && set.contains("boosting")) {
            return DeepKnowledgeBank.getRichExplanation("bagging_vs_boosting");
        }
        if (set.contains("metrics_classification") && (c1.contains("precision") || c2.contains("precision"))) {
            return DeepKnowledgeBank.getRichExplanation("precision_vs_recall");
        }
        if (set.contains("bert") && set.contains("gpt")) {
            return DeepKnowledgeBank.getRichExplanation("bert_vs_gpt");
        }
        if (set.contains("tensorflow") && set.contains("pytorch")) {
            return DeepKnowledgeBank.getRichExplanation("tensorflow_vs_pytorch");
        }

        return null;
    }

    /**
     * Executes the conversational NLP and intent matching pipeline:
     * 1. Normalization, Typo correction & Natural Greetings handling.
     * 2. Direct exact CSV question matching (uses DeepKnowledgeBank if rich explanation exists).
     * 3. Intent & Topic determination:
     *    a) Explicit AIML concept found (switches active context).
     *    b) Follow-up question (resolves pronouns & facets using previous conversation context).
     *    c) Unrelated / non-AIML question (returns exact sorry fallback).
     * 4. Multi-facet resolution (types, algorithms, applications, advantages, working, examples, etc.).
     * 5. Context state persistence across conversational turns.
     */
    public String getAnswer(String userMessage) {
        String answer = getAnswerInternal(userMessage);
        return cleanDoubleStars(answer);
    }

    private String getAnswerInternal(String userMessage) {
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return FALLBACK_MESSAGE;
        }

        String rawTrimmed = userMessage.trim();
        String normQuery = cleanAndNormalize(rawTrimmed);
        if (normQuery.isEmpty()) {
            return FALLBACK_MESSAGE;
        }

        // STEP 1: Understand natural greetings
        String greetingReply = checkGreeting(rawTrimmed, normQuery);
        if (greetingReply != null) {
            return greetingReply;
        }

        // STEP 2: Exact question match in loaded CSV dataset
        for (QAPair pair : datasetList) {
            if (pair.normalizedQuestion.equals(normQuery)) {
                this.lastConceptId = pair.intent;
                this.lastConceptPhrase = pair.intent.replace("_", " ");
                this.lastIntent = pair.intent;

                if (detectQuestionType(normQuery) == QuestionType.DEFINITION) {
                    List<MatchedConcept> exactConcepts = detectConcepts(normQuery);
                    for (MatchedConcept mc : exactConcepts) {
                        if (!"algorithm_concept".equals(mc.conceptId) && !"programming_language".equals(mc.conceptId)) {
                            String specificDef = DeepKnowledgeBank.getDefinitionWithExample(mc.conceptId);
                            if (specificDef != null) {
                                this.lastConceptId = mc.conceptId;
                                this.lastConceptPhrase = mc.displayPhrase;
                                this.lastIntent = mc.conceptId;
                                return specificDef;
                            }
                        }
                    }
                    String def = DeepKnowledgeBank.getDefinitionWithExample(pair.intent);
                    if (def != null) {
                        return def;
                    }
                }
                String rich = DeepKnowledgeBank.getRichExplanation(pair.intent);
                if (rich != null) {
                    return rich;
                }
                return pair.answer;
            }
        }

        // STEP 3: Detect explicit concepts in user query
        List<MatchedConcept> explicitConcepts = detectConcepts(normQuery);

        // If this query is a follow-up, and the only concept matched is a facet keyword (like algorithm_concept or programming_language), treat it as a follow-up to previous topic!
        if (isValidFollowUp(normQuery, this.lastConceptId)) {
            boolean hasSpecificNonFacet = false;
            for (MatchedConcept mc : explicitConcepts) {
                if (!"algorithm_concept".equals(mc.conceptId) && !"programming_language".equals(mc.conceptId)) {
                    hasSpecificNonFacet = true;
                    break;
                }
            }
            if (!hasSpecificNonFacet) {
                explicitConcepts.clear();
            }
        }

        String activeConceptId = null;
        String activeConceptPhrase = null;
        String queryToProcess = normQuery;

        if (!explicitConcepts.isEmpty()) {
            // Pick the best non-facet concept if multiple concepts matched (e.g. "algo of ml" -> machine_learning)
            activeConceptId = explicitConcepts.get(0).conceptId;
            activeConceptPhrase = explicitConcepts.get(0).displayPhrase;
            for (MatchedConcept mc : explicitConcepts) {
                if (!"algorithm_concept".equals(mc.conceptId) && !"programming_language".equals(mc.conceptId)) {
                    activeConceptId = mc.conceptId;
                    activeConceptPhrase = mc.displayPhrase;
                    break;
                }
            }
        } else if (isValidFollowUp(normQuery, this.lastConceptId)) {
            // Follow-up question using conversation context!
            activeConceptId = this.lastConceptId;
            activeConceptPhrase = this.lastConceptPhrase;
            queryToProcess = resolveFollowUpQuery(normQuery, activeConceptPhrase);
        } else {
            // Non-AIML or completely unrelated query
            return FALLBACK_MESSAGE;
        }

        // Update active context
        this.lastConceptId = activeConceptId;
        this.lastConceptPhrase = activeConceptPhrase;

        // STEP 4: Identify question type
        QuestionType qType = detectQuestionType(queryToProcess);

        // Handle DIFFERENCE between X and Y
        if (qType == QuestionType.DIFFERENCE && explicitConcepts.size() >= 2) {
            String c1 = explicitConcepts.get(0).conceptId;
            String c2 = explicitConcepts.get(1).conceptId;
            String diffAns = resolveDifference(c1, c2);
            if (diffAns != null) {
                this.lastIntent = c1 + "_vs_" + c2;
                return diffAns;
            }
        }

        // STEP 5: Target intent resolution for facet queries
        String targetIntent = null;

        if (qType == QuestionType.TYPES) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_types";
            } else if ("supervised_learning".equals(activeConceptId)) {
                targetIntent = "supervised_learning_types";
            } else if ("unsupervised_learning".equals(activeConceptId)) {
                targetIntent = "unsupervised_learning_types";
            } else if ("ai_fundamentals".equals(activeConceptId)) {
                targetIntent = "types_of_ai";
            } else if ("clustering".equals(activeConceptId)) {
                targetIntent = "clustering_types";
            } else if ("classification".equals(activeConceptId)) {
                targetIntent = "classification_types";
            } else if ("regression".equals(activeConceptId)) {
                targetIntent = "regression_types";
            } else if ("deep_learning".equals(activeConceptId)) {
                targetIntent = "deep_learning_types";
            } else if ("generative_ai".equals(activeConceptId)) {
                targetIntent = "generative_ai_types";
            } else if ("reinforcement_learning".equals(activeConceptId)) {
                targetIntent = "reinforcement_learning_types";
            } else if ("search_algorithms".equals(activeConceptId) || "search_algorithm".equals(activeConceptId)) {
                targetIntent = "search_algorithms_types";
            } else if ("ensemble_learning".equals(activeConceptId)) {
                targetIntent = "ensemble_learning_types";
            } else if ("tokenization".equals(activeConceptId)) {
                targetIntent = "tokenization_types";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_types")) {
                targetIntent = activeConceptId + "_types";
            } else if (intentMap.containsKey(activeConceptId + "_types")) {
                targetIntent = activeConceptId + "_types";
            }
        } else if (qType == QuestionType.ALGORITHMS) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_algorithms";
            } else if ("supervised_learning".equals(activeConceptId)) {
                targetIntent = "supervised_learning_algorithms";
            } else if ("unsupervised_learning".equals(activeConceptId)) {
                targetIntent = "unsupervised_learning_algorithms";
            } else if ("nlp".equals(activeConceptId)) {
                targetIntent = "nlp_techniques";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_algorithms")) {
                targetIntent = activeConceptId + "_algorithms";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_techniques")) {
                targetIntent = activeConceptId + "_techniques";
            } else if (intentMap.containsKey(activeConceptId + "_algorithms")) {
                targetIntent = activeConceptId + "_algorithms";
            }
        } else if (qType == QuestionType.APPLICATIONS) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_applications";
            } else if ("deep_learning".equals(activeConceptId)) {
                targetIntent = "deep_learning_applications";
            } else if ("reinforcement_learning".equals(activeConceptId)) {
                targetIntent = "reinforcement_learning_applications";
            } else if ("ai_fundamentals".equals(activeConceptId)) {
                targetIntent = "ai_applications";
            } else if ("cnn".equals(activeConceptId)) {
                targetIntent = "cnn_applications";
            } else if ("nlp".equals(activeConceptId)) {
                targetIntent = "nlp_applications";
            } else if ("computer_vision".equals(activeConceptId)) {
                targetIntent = "computer_vision_applications";
            } else if ("generative_ai".equals(activeConceptId)) {
                targetIntent = "generative_ai_applications";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_applications")) {
                targetIntent = activeConceptId + "_applications";
            } else if (intentMap.containsKey(activeConceptId + "_applications")) {
                targetIntent = activeConceptId + "_applications";
            }
        } else if (qType == QuestionType.ADVANTAGES) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_advantages";
            } else if ("deep_learning".equals(activeConceptId)) {
                targetIntent = "deep_learning_advantages";
            } else if ("cnn".equals(activeConceptId)) {
                targetIntent = "cnn_advantages";
            } else if ("random_forest".equals(activeConceptId)) {
                targetIntent = "random_forest_advantages";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_advantages")) {
                targetIntent = activeConceptId + "_advantages";
            } else if (intentMap.containsKey(activeConceptId + "_advantages")) {
                targetIntent = activeConceptId + "_advantages";
            }
        } else if (qType == QuestionType.DISADVANTAGES) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_disadvantages";
            } else if ("deep_learning".equals(activeConceptId)) {
                targetIntent = "deep_learning_disadvantages";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_disadvantages")) {
                targetIntent = activeConceptId + "_disadvantages";
            }
        } else if (qType == QuestionType.EXAMPLES) {
            if ("supervised_learning".equals(activeConceptId)) {
                targetIntent = "supervised_learning_examples";
            } else if ("unsupervised_learning".equals(activeConceptId)) {
                targetIntent = "unsupervised_learning_examples";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_examples")) {
                targetIntent = activeConceptId + "_examples";
            } else if (intentMap.containsKey(activeConceptId + "_examples")) {
                targetIntent = activeConceptId + "_examples";
            }
        } else if (qType == QuestionType.WORKING) {
            if ("cnn".equals(activeConceptId)) {
                targetIntent = "cnn_working";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_working")) {
                targetIntent = activeConceptId + "_working";
            } else if (intentMap.containsKey(activeConceptId + "_working")) {
                targetIntent = activeConceptId + "_working";
            }
        } else if (qType == QuestionType.STEPS) {
            if ("machine_learning".equals(activeConceptId)) {
                targetIntent = "machine_learning_steps";
            } else if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_steps")) {
                targetIntent = activeConceptId + "_steps";
            } else if (intentMap.containsKey(activeConceptId + "_steps")) {
                targetIntent = activeConceptId + "_steps";
            }
        } else if (qType == QuestionType.EXPLAIN) {
            if (DeepKnowledgeBank.hasRichExplanation(activeConceptId + "_explain")) {
                targetIntent = activeConceptId + "_explain";
            }
        }

        // STEP 6: Return answer for identified intent
        if (targetIntent != null) {
            this.lastIntent = targetIntent;
            String rich = DeepKnowledgeBank.getRichExplanation(targetIntent);
            if (rich != null) {
                return rich;
            }
            if (intentMap.containsKey(targetIntent)) {
                List<QAPair> pairs = intentMap.get(targetIntent);
                if (pairs != null && !pairs.isEmpty()) {
                    return pairs.get(0).answer;
                }
            }
        }

        // Check if question is asking for definition or what is
        if (qType == QuestionType.DEFINITION) {
            String def = DeepKnowledgeBank.getDefinitionWithExample(activeConceptId);
            if (def != null) {
                this.lastIntent = activeConceptId;
                return def;
            }
        }

        // Check if rich explanation exists for the primary activeConceptId
        if (DeepKnowledgeBank.hasRichExplanation(activeConceptId)) {
            this.lastIntent = activeConceptId;
            return DeepKnowledgeBank.getRichExplanation(activeConceptId);
        }

        // Check if CSV dataset contains pairs for this concept
        List<QAPair> conceptPairs = intentMap.get(activeConceptId);
        if (conceptPairs != null && !conceptPairs.isEmpty()) {
            this.lastIntent = activeConceptId;
            for (QAPair p : conceptPairs) {
                if (normQuery.equals(p.normalizedQuestion)
                        || p.normalizedQuestion.contains(normQuery)
                        || normQuery.contains(p.normalizedQuestion)) {
                    return p.answer;
                }
            }
            return conceptPairs.get(0).answer;
        }

        return FALLBACK_MESSAGE;
    }

    public static String cleanDoubleStars(String text) {
        if (text == null) return null;
        return text.replace("**", "").trim();
    }
}