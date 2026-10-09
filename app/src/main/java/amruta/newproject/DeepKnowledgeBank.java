package amruta.newproject;

import java.util.HashMap;
import java.util.Map;

/**
 * Supercharged AIML Deep Knowledge Bank.
 * Authoritative, structured, and comprehensive expert answers
 * across all 11 core AIML domains:
 * 1. Artificial Intelligence
 * 2. Machine Learning
 * 3. ML Algorithms
 * 4. Model Evaluation
 * 5. Deep Learning
 * 6. Natural Language Processing (NLP)
 * 7. Transformers
 * 8. Computer Vision
 * 9. Generative AI
 * 10. Data Science & Python
 * 11. Advanced AI/ML
 */
public class DeepKnowledgeBank {

    private static final Map<String, String> KNOWLEDGE = new HashMap<>();
    private static final Map<String, String> DEFINITIONS = new HashMap<>();

    static {
        initAiFundamentals();
        initAiSearchAndLogic();
        initAiEthicsAndSafety();
        initMachineLearning();
        initMlAlgorithms();
        initClusteringAlgorithms();
        initTypesExplanations1();
        initTypesExplanations2();
        initModelEvaluation();
        initDeepLearning();
        initDeepLearningComponents();
        initNLP();
        initNlpAdvanced();
        initTransformers();
        initComputerVision();
        initGenerativeAI();
        initPythonDataScience();
        initAdvancedAiMl();
        initComparisons();
        initDetailedSyllabusConcepts1();
        initDetailedSyllabusConcepts2();
        initProgrammingLanguages();
        initComputerScience();
        initDefinitionsAi();
        initDefinitionsMl();
        initDefinitionsDlAndNlp();
        initDefinitionsCvGenAiData();
        initDefinitionsCsAndLanguages();
    }

    // =========================================================================
    // 1. ARTIFICIAL INTELLIGENCE
    // =========================================================================
    private static void initAiFundamentals() {
        KNOWLEDGE.put("ai_fundamentals",
                "Artificial Intelligence (AI) is a branch of computer science that enables machines to perform tasks that normally require human intelligence, such as learning, reasoning and problem-solving.\n\n" +
                "Example: Chatbots and voice assistants use AI.");

        KNOWLEDGE.put("ai_fundamentals_explain",
                "Artificial Intelligence (AI) is a branch of computer science that enables machines to perform tasks that normally require human intelligence.\n\n" +
                "1. Learning: Systems learn patterns from data and past experience.\n" +
                "2. Reasoning: Systems use logical rules to make decisions and draw conclusions.\n" +
                "3. Problem Solving: Systems analyze complex situations to find solutions.\n" +
                "4. Applications: Used in self-driving cars, healthcare diagnosis, search engines, and virtual assistants.");

        KNOWLEDGE.put("ai_history",
                "📜 **History & Milestones of Artificial Intelligence**\n\n" +
                "• **1950 (Turing Test):** Alan Turing publishes 'Computing Machinery and Intelligence', proposing the imitation game to test machine intelligence.\n" +
                "• **1956 (Dartmouth Conference):** John McCarthy, Marvin Minsky, Nathaniel Rochester, and Claude Shannon officially coin the term 'Artificial Intelligence'.\n" +
                "• **1960s-1970s (Symbolic AI & Expert Systems):** Early rule engines like ELIZA, DENDRAL, and MYCIN demonstrate domain reasoning.\n" +
                "• **1974-1980 & 1987-1993 (AI Winters):** Periods of reduced funding and skepticism due to unmet expectations in automated translation and general reasoning.\n" +
                "• **1997 (Deep Blue):** IBM's Deep Blue defeats world chess champion Garry Kasparov.\n" +
                "• **2012 (AlexNet & Deep Learning Boom):** AlexNet wins ImageNet, establishing Convolutional Neural Networks as state of the art.\n" +
                "• **2017 (Transformer Revolution):** Google publishes 'Attention Is All You Need', laying the architectural foundation for modern LLMs.\n" +
                "• **2020s (Generative AI Era):** Emergence of GPT-4, Gemini, Claude, diffusion models, and multimodal foundation agents.");

        KNOWLEDGE.put("types_of_ai",
                "🌐 **The 3 Main Types and Stages of Artificial Intelligence**\n\n" +
                "Think of the stages of AI like climbing a ladder of intelligence:\n\n" +
                "1. 🎯 **Artificial Narrow AI (ANI / Weak AI) - What We Have Today:**\n" +
                "   • Designed to perform **one specific task** exceptionally well.\n" +
                "   • *Analogy:* A grandmaster chess computer that plays flawless chess, but cannot tell you the weather or cook dinner!\n" +
                "   • *Examples:* Siri, Alexa, Google Search ranking, chess engines (Stockfish), facial recognition, spam filters, ChatGPT.\n" +
                "   • *Note:* 100% of all current AI in existence today is Narrow AI.\n\n" +
                "2. 🧠 **Artificial General AI (AGI / Strong AI) - Human-Level Intelligence:**\n" +
                "   • A theoretical machine intelligence capable of understanding, learning, and applying knowledge across **any domain**, just like a human brain.\n" +
                "   • Features cross-domain transfer learning, common-sense reasoning, and abstract thinking.\n" +
                "   • *Status:* Active research goal (pursued by OpenAI, DeepMind, etc.), but does not exist yet.\n\n" +
                "3. 🚀 **Artificial Super AI (ASI) - Beyond Human Intellect:**\n" +
                "   • A speculative future AI that surpasses collective human intellect across scientific discovery, creativity, emotional intelligence, and strategic planning.\n\n" +
                "**Functional Classifications:**\n" +
                "• *Reactive Machines:* No memory; purely react to current state (e.g., Deep Blue).\n" +
                "• *Limited Memory:* Uses past experiences to inform present decisions (e.g., Self-driving cars, modern ML).\n" +
                "• *Theory of Mind & Self-Aware:* Future conceptual machines that understand human feelings or have self-awareness.");

        KNOWLEDGE.put("narrow_ai",
                "🎯 **Narrow AI (ANI / Weak AI)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Narrow AI is an expert at one specific job, but completely clueless at anything else! For example, an AI that detects spam in your email cannot play chess, and a face unlock system cannot recommend music.\n\n" +
                "**Key Characteristics:**\n" +
                "• Focused entirely on a single, predetermined task within defined boundaries.\n" +
                "• Does not have feelings, self-awareness, or consciousness.\n" +
                "• Represents 100% of all practical AI applications in production today.\n\n" +
                "**Everyday Examples:** AlphaGo, Siri/Alexa, Tesla Autopilot lane-keeping, and Netflix movie recommendations.");

        KNOWLEDGE.put("general_ai",
                "🧠 **General AI (AGI / Strong AI)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Imagine a machine with the mental versatility of an adult human. It could learn to play piano, diagnose illnesses, write poetry, and drive a car—all with the same mind! That is Artificial General Intelligence (AGI).\n\n" +
                "**Key Requirements for AGI:**\n" +
                "• General-purpose reasoning and abstract concept formulation.\n" +
                "• Cross-domain transfer learning without catastrophic forgetting.\n" +
                "• Common-sense reasoning and causal inference.\n" +
                "• Autonomous goal formulation and creative planning.\n\n" +
                "**Current Status:** A major research goal pursued by leading AI labs (OpenAI, Google DeepMind, Anthropic), but not yet achieved.");

        KNOWLEDGE.put("super_ai",
                "🚀 **Super AI (Artificial Superintelligence / ASI)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Super AI is the hypothetical future stage where machine intelligence becomes vastly smarter than all human minds on Earth combined—excelling in science, creativity, wisdom, and emotional intelligence!\n\n" +
                "**Concept:**\n" +
                "A speculative stage where an AI could invent cures for diseases overnight, solve physics mysteries, and recursively self-improve, triggering what researchers call the 'Technological Singularity'.");

        KNOWLEDGE.put("ai_applications",
                "💡 **Real-World Applications of Artificial Intelligence**\n\n" +
                "• **Healthcare:** Automated medical imaging diagnosis, drug discovery, genomic analysis, and robotic surgery.\n" +
                "• **Autonomous Systems:** Self-driving vehicles, drone delivery, and warehouse logistics automation.\n" +
                "• **Finance:** High-frequency algorithmic trading, credit risk scoring, fraud detection, and anti-money laundering.\n" +
                "• **Natural Language:** Real-time speech translation, legal document summarization, virtual customer service agents.\n" +
                "• **Retail & E-commerce:** Personalized recommendation engines, dynamic pricing, and cashierless checkout stores.");

        KNOWLEDGE.put("ai_agents",
                "🤖 **AI Agents & Intelligent Agents**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Think of an AI Agent like a smart robotic vacuum cleaner (Roomba) or a thermostat (Nest). It uses sensors to 'see' what is happening around it, makes a decision using its AI brain, and takes an action to get the job done!\n\n" +
                "**Core Concept:**\n" +
                "An AI Agent is an autonomous entity that perceives its environment through sensors, makes decisions using an internal reasoning engine, and acts upon the environment through actuators to achieve specified goals.\n\n" +
                "**The 5 Main Agent Types:**\n" +
                "• **Simple Reflex Agents:** 'If condition, do action' based on immediate percept (no memory).\n" +
                "• **Model-Based Reflex Agents:** Maintains an internal state reflecting unobserved parts of the environment.\n" +
                "• **Goal-Based Agents:** Combines environment models with explicit goal descriptions to plan actions.\n" +
                "• **Utility-Based Agents:** Chooses actions that maximize a utility function measuring degree of happiness/success.\n" +
                "• **Learning Agents:** Continuously learns and improves performance over time through experience.");

        KNOWLEDGE.put("rational_agents",
                "⚖️ **Rational Agents & The PEAS Framework**\n\n" +
                "**Concept of Rationality:**\n" +
                "A Rational Agent is one that selects an action expected to maximize its performance measure, based on the evidence provided by its percept sequence and its built-in knowledge.\n\n" +
                "**The PEAS Framework:**\n" +
                "• **P**erformance measure: The success criteria (e.g., speed, safety, profit, accuracy).\n" +
                "• **E**nvironment: Operating context (e.g., city streets, chessboard, web database).\n" +
                "• **A**ctuators: Mechanisms to affect the environment (e.g., steering wheel, screen display, API call).\n" +
                "• **S**ensors: Devices for gathering percepts (e.g., cameras, LIDAR, keyboard input, microphone).");

        KNOWLEDGE.put("environment_types",
                "🌍 **Environment Types in Artificial Intelligence**\n\n" +
                "An agent's environment dictates the complexity of its design across these key dimensions:\n\n" +
                "• **Fully Observable vs. Partially Observable:** Does the agent have complete sensory access to the entire state (e.g., Chess) or incomplete/noisy access (e.g., Poker, driving)?\n" +
                "• **Deterministic vs. Stochastic:** Is the next state completely determined by the current state and action (e.g., Tic-tac-toe) or is there randomness/uncertainty (e.g., Weather, self-driving)?\n" +
                "• **Episodic vs. Sequential:** Are agent experiences divided into independent atomic episodes or does current action affect all future decisions?\n" +
                "• **Static vs. Dynamic:** Does the environment remain unchanged while the agent deliberates, or does it evolve dynamically?\n" +
                "• **Discrete vs. Continuous:** Are states, time, and actions distinctly countable or continuous real numbers?\n" +
                "• **Single-Agent vs. Multi-Agent:** Does the agent operate alone, or are there competitive/cooperative other agents?");
    }

    private static void initAiSearchAndLogic() {
        KNOWLEDGE.put("problem_solving_ai",
                "🧩 **Problem Solving & State Space in AI**\n\n" +
                "**Problem Formulation:**\n" +
                "In AI, problem solving is framed as searching through a state space to find a sequence of actions that leads from an initial state to a designated goal state.\n\n" +
                "**Core Components:**\n" +
                "1. **Initial State:** The starting condition where the agent begins.\n" +
                "2. **Actions:** The set of valid moves or operators available to the agent at state s: Actions(s).\n" +
                "3. **Transition Model:** Function Result(s, a) defining the outcome of taking action a in state s.\n" +
                "4. **State Space:** The set of all valid states reachable from the initial state.\n" +
                "5. **Goal Test:** Predicate function determining if a given state satisfies the goal condition.\n" +
                "6. **Path Cost:** Sum of step costs along a path from initial to goal state; optimal solution minimizes path cost.");

        KNOWLEDGE.put("search_algorithms_ai",
                "🔍 **Search Algorithms in Artificial Intelligence**\n\n" +
                "Search algorithms systematically explore the state space tree to find a path from initial state to goal state.\n\n" +
                "**Classification:**\n" +
                "• **Uninformed (Blind) Search:** Explores without domain-specific estimates (BFS, DFS, Uniform Cost Search).\n" +
                "• **Informed (Heuristic) Search:** Uses heuristic evaluation function h(n) estimating cost to goal (A* Search, Greedy Best-First Search).\n" +
                "• **Adversarial (Game) Search:** Evaluates competitive multi-agent decisions (Minimax, Alpha-Beta Pruning).");

        KNOWLEDGE.put("bfs",
                "🌳 **Breadth-First Search (BFS)**\n\n" +
                "**Mechanism:**\n" +
                "BFS expands nodes level by level starting from the root using a First-In-First-Out (FIFO) queue data structure.\n\n" +
                "**Key Properties:**\n" +
                "• **Completeness:** Complete (guaranteed to find a solution if one exists).\n" +
                "• **Optimality:** Optimal for unweighted graphs or when all step costs are equal.\n" +
                "• **Time Complexity:** O(bᵈ), where b is branching factor and d is depth of shallowest solution.\n" +
                "• **Space Complexity:** O(bᵈ) — major limitation, as all generated nodes are retained in memory.");

        KNOWLEDGE.put("dfs",
                "🌲 **Depth-First Search (DFS)**\n\n" +
                "**Mechanism:**\n" +
                "DFS explores as deeply as possible along each branch before backtracking, utilizing a Last-In-First-Out (LIFO) stack (or recursion).\n\n" +
                "**Key Properties:**\n" +
                "• **Completeness:** Incomplete on infinite-depth spaces or graphs with loops without cycle checking.\n" +
                "• **Optimality:** Not optimal (may find a longer solution path first).\n" +
                "• **Time Complexity:** O(bᵐ), where m is the maximum depth.\n" +
                "• **Space Complexity:** O(b · m) — highly memory-efficient compared to BFS.");

        KNOWLEDGE.put("uniform_cost_search",
                "💰 **Uniform Cost Search (UCS)**\n\n" +
                "**Mechanism:**\n" +
                "UCS expands the node n with the lowest path cost g(n) from the root, implemented using a priority queue ordered by path cost (equivalent to Dijkstra's algorithm).\n\n" +
                "**Key Properties:**\n" +
                "• **Completeness:** Complete if step costs are strictly positive (ε > 0).\n" +
                "• **Optimality:** Optimal; guarantees finding the lowest-cost solution path for weighted graphs.\n" +
                "• **Complexity:** O(b^(1 + ⌊C*/ε⌋)), where C* is optimal path cost.");

        KNOWLEDGE.put("greedy_best_first_search",
                "🎯 **Greedy Best-First Search**\n\n" +
                "**Mechanism:**\n" +
                "An informed search algorithm that expands the node that appears closest to the goal according to a heuristic function: f(n) = h(n).\n\n" +
                "**Key Properties:**\n" +
                "• Fast in practice on easy problems.\n" +
                "• Not optimal (can be easily led astray by deceptive heuristics).\n" +
                "• Incomplete (can get trapped in infinite loops like DFS without cycle checking).");

        KNOWLEDGE.put("a_star_search",
                "⭐ **A* Search Algorithm**\n\n" +
                "**Concept & Evaluation Function:**\n" +
                "A* Search evaluates nodes by combining the actual cost to reach the node g(n) and the estimated cost to reach the goal h(n):\n" +
                "f(n) = g(n) + h(n)\n\n" +
                "**Optimality Conditions:**\n" +
                "• **Tree Search:** A* is optimal if h(n) is **admissible** (never overestimates the true cost to reach the goal).\n" +
                "• **Graph Search:** A* is optimal if h(n) is **consistent / monotonic** (satisfies triangle inequality: h(n) ≤ c(n, a, n') + h(n')).\n\n" +
                "**Completeness:** Complete and optimally efficient among all heuristic search algorithms.");

        KNOWLEDGE.put("minimax",
                "♟️ **Minimax Algorithm**\n\n" +
                "**Concept:**\n" +
                "A decision-theoretic algorithm used in two-player zero-sum games (e.g., Chess, Checkers, Tic-Tac-Toe) with perfect information.\n\n" +
                "**Working Mechanism:**\n" +
                "• **MAX Player:** Seeks the move that maximizes the utility score.\n" +
                "• **MIN Player:** Seeks the move that minimizes the utility score.\n" +
                "• The game tree is evaluated recursively from the leaf terminal states back to the root node.\n" +
                "• **Complexity:** Time O(bᵈ), Space O(b · d) with depth-first search.");

        KNOWLEDGE.put("alpha_beta_pruning",
                "✂️ **Alpha-Beta Pruning**\n\n" +
                "**Concept:**\n" +
                "An optimization technique for the Minimax algorithm that eliminates branches that cannot possibly influence the final decision, returning the exact same optimal move.\n\n" +
                "**Two Bounds Maintained:**\n" +
                "• **α (Alpha):** Best (highest) value that the MAX player is guaranteed along the path.\n" +
                "• **β (Beta):** Best (lowest) value that the MIN player is guaranteed along the path.\n" +
                "• **Pruning Condition:** Whenever α ≥ β, the current branch is pruned.\n\n" +
                "**Efficiency:** With optimal move ordering, cuts time complexity from O(bᵈ) to O(b^(d/2)), effectively doubling searchable search depth.");

        KNOWLEDGE.put("propositional_logic",
                "🔣 **Propositional Logic in AI**\n\n" +
                "**Definition:**\n" +
                "A branch of formal logic that deals with declarative propositions that can be either True or False, connected by logical operators.\n\n" +
                "**Core Operators:**\n" +
                "• Negation (¬ / NOT), Conjunction (∧ / AND), Disjunction (∨ / OR)\n" +
                "• Implication (→ / IF-THEN): P → Q is False only when P is True and Q is False.\n" +
                "• Biconditional (↔ / IFF): True when both propositions have identical truth values.\n\n" +
                "**Inference Methods:** Truth tables, Modus Ponens, Resolution refutation, and CNF (Conjunctive Normal Form).");

        KNOWLEDGE.put("predicate_logic",
                "📜 **First-Order Predicate Logic (FOL)**\n\n" +
                "**Why FOL Extends Propositional Logic:**\n" +
                "Propositional logic lacks expressive power to make statements about objects, properties, and relationships. FOL adds objects, relations, functions, and quantifiers.\n\n" +
                "**Key Elements:**\n" +
                "• **Constants:** Specific objects (e.g., Alice, Car1).\n" +
                "• **Predicates:** Properties or relations (e.g., IsStudent(x), Loves(x, y)).\n" +
                "• **Universal Quantifier (∀):** 'For all' (e.g., ∀x Human(x) → Mortal(x)).\n" +
                "• **Existential Quantifier (∃):** 'There exists' (e.g., ∃x Dog(x) ∧ Friendly(x)).");

        KNOWLEDGE.put("expert_systems",
                "💼 **Expert Systems & Rule-Based Systems**\n\n" +
                "**Definition:**\n" +
                "An Expert System is an AI program that simulates human expert decision-making in a specialized domain using explicit heuristic rules.\n\n" +
                "**Core Architecture:**\n" +
                "1. **Knowledge Base:** Stores domain facts and IF-THEN production rules.\n" +
                "2. **Inference Engine:** Applies logical rules to deduce answers (Forward chaining: data-driven; Backward chaining: goal-driven).\n" +
                "3. **Working Memory:** Maintains facts about the current case.\n" +
                "4. **Explanation Facility:** Clarifies the reasoning trace behind recommendations.");

        KNOWLEDGE.put("fuzzy_logic",
                "🌫️ **Fuzzy Logic**\n\n" +
                "**Concept:**\n" +
                "Unlike classical Boolean logic where propositions are strictly 0 (False) or 1 (True), Fuzzy Logic permits continuous degrees of truth between [0.0, 1.0], modeling real-world vagueness and uncertainty.\n\n" +
                "**Fuzzy Processing Pipeline:**\n" +
                "1. **Fuzzification:** Maps crisp input values (e.g., Speed = 68 km/h) into linguistic variables ('Moderate', 'Fast') using membership functions.\n" +
                "2. **Rule Evaluation:** Evaluates fuzzy IF-THEN rules (e.g., IF Temperature is High THEN Fan Speed is Fast).\n" +
                "3. **Defuzzification:** Converts fuzzy output set back into a crisp action value (e.g., Centroid method).\n\n" +
                "**Applications:** Washing machines, climate controllers, automotive ABS braking systems.");
    }

    private static void initAiEthicsAndSafety() {
        KNOWLEDGE.put("ai_ethics",
                "⚖️ **AI Ethics & Responsible AI**\n\n" +
                "**Core Pillars:**\n" +
                "• **Fairness & Justice:** Preventing unfair discrimination across demographics.\n" +
                "• **Accountability:** Establishing clear human responsibility for AI decisions.\n" +
                "• **Transparency:** Making model decision processes auditable and interpretable.\n" +
                "• **Safety & Reliability:** Ensuring robust operation without unintended harm.\n" +
                "• **Privacy:** Preserving user confidentiality and preventing unauthorized data leaks.");

        KNOWLEDGE.put("ai_bias",
                "⚠️ **Algorithmic Bias in Artificial Intelligence**\n\n" +
                "**Definition:**\n" +
                "Systematic errors in an AI system that generate unfair, prejudicial outcomes favoring one demographic group over another.\n\n" +
                "**Primary Sources of Bias:**\n" +
                "• **Historical Bias:** Pre-existing socioeconomic inequalities present in training data.\n" +
                "• **Representation Bias:** Underrepresentation of minority populations in dataset sampling.\n" +
                "• **Measurement Bias:** Flawed proxy features or biased annotation labels.\n\n" +
                "**Mitigation:** Balanced sampling, re-weighting, fairness constraints, adversarial debiasing, and disparate impact audits.");

        KNOWLEDGE.put("explainable_ai",
                "🔍 **Explainable AI (XAI)**\n\n" +
                "**Importance:**\n" +
                "Complex models (deep neural networks, gradient boosting) act as black boxes. XAI provides understandable explanations to foster trust, regulatory compliance (GDPR Right to Explanation), and model validation.\n\n" +
                "**Key Frameworks:**\n" +
                "• **SHAP (SHapley Additive exPlanations):** Game-theoretic metric computing each feature's marginal contribution.\n" +
                "• **LIME (Local Interpretable Model-agnostic Explanations):** Explains single predictions by fitting local interpretable linear surrogates.\n" +
                "• **Feature Importance:** Permutation importance and tree-based impurity reduction.");

        KNOWLEDGE.put("ai_safety",
                "🛡️ **AI Safety & Alignment**\n\n" +
                "**Core Concept:**\n" +
                "AI Safety ensures that autonomous AI systems operate reliably, predictably, and in strict alignment with human intentions and moral values without catastrophic failures.\n\n" +
                "**Key Challenges:**\n" +
                "• **Outer Alignment:** Formulating objective loss functions that truly capture human intent without specification gaming.\n" +
                "• **Inner Alignment:** Ensuring the trained model internally optimizes for the specified objective rather than an unintended proxy (Goodhart's Law).\n" +
                "• **Robustness Against Adversarial Attacks:** Preventing evasion attacks via adversarial perturbation inputs.");

        KNOWLEDGE.put("data_privacy_ai",
                "🔒 **AI Privacy & Privacy-Preserving Machine Learning**\n\n" +
                "• **Federated Learning:** Decentralized training across edge devices where raw data remains local, aggregating only parameter gradients.\n" +
                "• **Differential Privacy (DP):** Adding mathematically calibrated noise to data queries or gradients, guaranteeing individual records cannot be re-identified.\n" +
                "• **Homomorphic Encryption:** Performing neural network inferences directly on encrypted ciphertexts without decrypting data.");
    }

    // =========================================================================
    // 2. MACHINE LEARNING & EVALUATION
    // =========================================================================
    private static void initMachineLearning() {
        KNOWLEDGE.put("machine_learning",
                "Machine Learning (ML) is a branch of Artificial Intelligence that allows computers to learn from data and improve from experience without being explicitly programmed.\n\n" +
                "Example: Email spam filtering and video recommendations on YouTube or Netflix.");

        KNOWLEDGE.put("machine_learning_explain",
                "Machine Learning (ML) is a branch of Artificial Intelligence where computers learn from data and improve on their own without explicit step-by-step programming.\n\n" +
                "1. Data Collection: Relevant data such as text, numbers, or images is gathered.\n" +
                "2. Training: An ML algorithm analyzes the data to learn underlying patterns.\n" +
                "3. Evaluation: The trained model is tested on unseen data to measure accuracy.\n" +
                "4. Prediction: The model is deployed to make real-world decisions and predictions.");

        KNOWLEDGE.put("machine_learning_types",
                "The types of Machine Learning are:\n\n" +
                "1. Supervised Learning: The model trains on labeled data where each input is paired with the correct answer. It is used for classification and regression tasks like spam filtering and price prediction.\n\n" +
                "2. Unsupervised Learning: The model finds hidden patterns or groups in unlabeled data without predefined answers. It is commonly used for customer segmentation and clustering.\n\n" +
                "3. Semi-Supervised Learning: The model trains on a small set of labeled data combined with a large set of unlabeled data to improve accuracy efficiently.\n\n" +
                "4. Reinforcement Learning: An agent learns optimal actions through trial and error by receiving rewards for good decisions and penalties for mistakes. It is used in robotics and gaming.");

        KNOWLEDGE.put("supervised_learning",
                "Supervised Learning is a type of Machine Learning where a model is trained using labeled data, meaning the input data is paired with the known target answer.\n\n" +
                "Example: Email spam filtering and house price prediction.");

        KNOWLEDGE.put("supervised_learning_explain",
                "Supervised Learning is a machine learning method where an algorithm learns from labeled training data containing both inputs and correct answers.\n\n" +
                "1. Training: The algorithm receives input features along with correct target labels.\n" +
                "2. Pattern Learning: The model calculates errors between its guesses and actual labels, adjusting its parameters.\n" +
                "3. Classification: Predicts discrete categorical labels such as spam vs. not spam.\n" +
                "4. Regression: Predicts continuous numerical values such as house prices.");

        KNOWLEDGE.put("unsupervised_learning",
                "Unsupervised Learning is a type of Machine Learning that analyzes unlabeled data to find hidden patterns, groupings, or structures on its own without predefined answers.\n\n" +
                "Example: Customer segmentation based on buying habits.");

        KNOWLEDGE.put("unsupervised_learning_explain",
                "Unsupervised Learning is a machine learning method where an algorithm explores unlabeled data without human supervision or known target answers.\n\n" +
                "1. Data Input: The algorithm receives raw data without any labels or categories.\n" +
                "2. Pattern Discovery: It computes similarities and distances among data points.\n" +
                "3. Clustering: It groups similar data points into clusters.\n" +
                "4. Dimensionality Reduction: It reduces the number of features while keeping essential information.");

        KNOWLEDGE.put("semi_supervised_learning",
                "Semi-Supervised Learning is a Machine Learning approach that uses a small amount of labeled data paired with a large amount of unlabeled data during training.\n\n" +
                "Example: Medical diagnosis where only a few X-rays are labeled by doctors while thousands of unlabeled X-rays are available.");

        KNOWLEDGE.put("labeled_dataset",
                "A labeled dataset is a collection of data that has been tagged or annotated with informative labels, classes, or target values (ground truth) that a machine learning model can learn from during supervised training.\n\n" +
                "Example: A folder of cat and dog images where each image file is labeled as 'cat' or 'dog'.");

        KNOWLEDGE.put("reinforcement_learning",
                "Reinforcement Learning is a type of Machine Learning where an agent learns to make optimal decisions by interacting with an environment through trial and error, guided by rewards and penalties.\n\n" +
                "Example: Self-driving cars learning safe driving decisions and AI playing chess.");

        KNOWLEDGE.put("reinforcement_learning_explain",
                "Reinforcement Learning is a machine learning method where an agent learns to solve problems by interacting with an environment.\n\n" +
                "1. Agent: The learner or decision-maker that interacts with the environment.\n" +
                "2. State: The current situation or position of the agent in the environment.\n" +
                "3. Action: The move or decision chosen by the agent.\n" +
                "4. Reward: Feedback score where positive rewards encourage good actions and penalties discourage mistakes.");

        KNOWLEDGE.put("supervised_learning_algorithms",
                "Common Supervised Learning algorithms are:\n\n" +
                "1. Linear Regression: Predicts continuous numerical values by fitting a straight line between input features and target output.\n" +
                "2. Logistic Regression: Predicts categorical outcomes and probabilities, commonly used for classification tasks.\n" +
                "3. Decision Tree: Uses a tree-like model of decisions and possible consequences to classify data or predict values.\n" +
                "4. Random Forest: An ensemble of multiple decision trees that combines their outputs to improve accuracy.\n" +
                "5. Support Vector Machine (SVM): Finds an optimal hyperplane that maximizes the margin between different classes.\n" +
                "6. K-Nearest Neighbors (KNN): Classifies data points based on the majority class among nearest neighbors.");

        KNOWLEDGE.put("unsupervised_learning_algorithms",
                "Common Unsupervised Learning algorithms are:\n\n" +
                "1. K-Means Clustering: Partitions data into K distinct clusters based on distance to cluster centroids.\n" +
                "2. Hierarchical Clustering: Builds a tree of clusters using bottom-up merging or top-down splitting.\n" +
                "3. DBSCAN: Groups data points based on density and identifies outliers as noise.\n" +
                "4. Principal Component Analysis (PCA): Reduces data dimensionality while preserving maximum variance.");

        KNOWLEDGE.put("machine_learning_algorithms",
                "Common Machine Learning algorithms include:\n\n" +
                "1. Supervised Learning: Linear Regression, Logistic Regression, Decision Tree, Random Forest, and Support Vector Machine (SVM).\n" +
                "2. Unsupervised Learning: K-Means Clustering, Hierarchical Clustering, DBSCAN, and PCA.\n" +
                "3. Reinforcement Learning: Q-Learning, Deep Q-Networks (DQN), and Policy Gradient methods.");

        KNOWLEDGE.put("supervised_learning_examples",
                "Examples of Supervised Learning include:\n\n" +
                "1. Email Spam Detection: Classifying incoming emails as spam or not spam based on email text.\n" +
                "2. House Price Prediction: Estimating the market price of a house using its size, location, and bedrooms.\n" +
                "3. Medical Diagnosis: Predicting whether a patient has a condition based on clinical test results.");

        KNOWLEDGE.put("unsupervised_learning_examples",
                "Examples of Unsupervised Learning include:\n\n" +
                "1. Customer Segmentation: Grouping online shoppers based on purchasing patterns and browsing history.\n" +
                "2. Anomaly Detection: Identifying unusual credit card transactions to prevent fraud.\n" +
                "3. Topic Modeling: Grouping news articles into topics like sports, politics, and technology.");

        KNOWLEDGE.put("train_test_val_data",
                "📁 **Training, Validation, and Testing Data**\n\n" +
                "💡 **Think of it like preparing for school exams:**\n" +
                "• **Training Set (60-80%):** The textbook and homework exercises you practice on every day to learn the concepts.\n" +
                "• **Validation Set (10-20%):** The mock practice tests you take to tune your study strategy and see if you need to adjust your focus.\n" +
                "• **Test Set (10-20%):** The final exam! Brand-new unseen questions used once at the end to evaluate your real mastery without cheating (preventing data leakage).\n\n" +
                "**Key Rule:** Never train on the test set, otherwise the model just memorizes answers rather than truly learning!");

        KNOWLEDGE.put("features_and_labels",
                "🏷️ **Features & Labels in Machine Learning**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Imagine you are predicting house prices:\n" +
                "• **Features ($X$):** The clues and input details! (e.g., number of bedrooms, square footage, neighborhood, school rating).\n" +
                "• **Labels ($Y$):** The answer you want to predict! (e.g., the actual price: $450,000).\n\n" +
                "• **Features ($X$):** Measurable input attributes used by the model to learn and make predictions.\n" +
                "• **Labels ($Y$):** The ground truth target outcome the model is trained to predict (e.g., 'Spam' vs. 'Not Spam', house price, medical diagnosis).");

        KNOWLEDGE.put("regression",
                "📈 **Regression in Machine Learning**\n\n" +
                "**Definition:**\n" +
                "Regression is a supervised learning task where the model learns to predict a continuous numerical quantity (a real-valued number) based on one or more input predictor features.\n\n" +
                "**How It Works (Working):**\n" +
                "1. The model takes input features $X$ paired with continuous target values $Y$.\n" +
                "2. It fits a mathematical mapping function (such as a line $y = mx + b$ or curved manifold) that minimizes the prediction errors (residuals) between predicted and actual values.\n" +
                "3. For new unseen inputs, it computes and returns the continuous estimated value.\n\n" +
                "**Common Algorithms:** Linear Regression, Multiple Linear Regression, Polynomial Regression, Ridge/Lasso, Random Forest Regressor, XGBoost.\n\n" +
                "📌 **Simple Example:**\n" +
                "Predicting house prices: An algorithm takes features like square footage (1,800 sq ft), number of bedrooms (3), and neighborhood rating, and predicts a continuous market value of $425,000.");

        KNOWLEDGE.put("classification",
                "🎯 **Classification in Machine Learning**\n\n" +
                "**Definition:**\n" +
                "Classification is a supervised learning task where the model learns from labeled training data to assign new input instances into discrete categorical classes or labels.\n\n" +
                "**How It Works (Working):**\n" +
                "1. The model is trained on feature vectors $X$ paired with predefined categorical labels $Y$.\n" +
                "2. It learns an optimal decision boundary separating the feature space between classes.\n" +
                "3. For a new query point, it calculates class probabilities and assigns the point to the highest-probability category.\n\n" +
                "**Common Algorithms:** Logistic Regression, Decision Trees, Random Forest, Support Vector Machines (SVM), Naive Bayes, Neural Networks.\n\n" +
                "📌 **Simple Example:**\n" +
                "Email spam detection: The classifier analyzes incoming email text and sender headers. If the email exhibits spam patterns, it classifies the message as 'Spam'; otherwise, it directs it to 'Inbox'.");

        KNOWLEDGE.put("clustering",
                "🫧 **Clustering in Machine Learning**\n\n" +
                "**Definition:**\n" +
                "Clustering is an unsupervised learning task that groups unlabeled data points into clusters such that points within the same cluster share high similarity, while points in different clusters are distinct.\n\n" +
                "**How It Works (Working):**\n" +
                "1. The algorithm receives unlabeled data without predefined answers.\n" +
                "2. It computes pairwise distances or densities among data points.\n" +
                "3. It iteratively organizes data points into clusters based on proximity to cluster centers (Centroid-based), connected dense regions (Density-based), or nested trees (Hierarchical).\n\n" +
                "**Major Approaches:** K-Means (Centroid-based), DBSCAN (Density-based), and Hierarchical Clustering.\n\n" +
                "📌 **Simple Example:**\n" +
                "Customer market segmentation: A retail company groups 10,000 shoppers by purchasing frequency and average order value. The model automatically discovers clusters of budget shoppers, frequent regular buyers, and luxury VIP spenders.");

        KNOWLEDGE.put("anomaly_detection",
                "🚨 **Anomaly Detection (Outlier Detection)**\n\n" +
                "**Concept:**\n" +
                "Identifying rare items, events, or observations that deviate significantly from the majority of the data distribution.\n\n" +
                "**Common Techniques:**\n" +
                "• **Statistical:** Z-score, Interquartile Range (IQR).\n" +
                "• **Machine Learning:** Isolation Forest, One-Class SVM, Local Outlier Factor (LOF).\n" +
                "• **Deep Learning:** Autoencoders (high reconstruction error flags anomalies).\n\n" +
                "**Applications:** Credit card fraud detection, industrial machine failure prediction, cyber intrusion monitoring.");

        KNOWLEDGE.put("feature_engineering",
                "🛠️ **Feature Engineering, Selection & Scaling**\n\n" +
                "• **Feature Engineering:** Creating new informative features from raw data (e.g., date $\\to$ day_of_week, text $\\to$ word_count).\n" +
                "• **Feature Selection:** Identifying the most relevant predictor subset (Filter methods: correlation; Wrapper methods: RFE; Embedded: Lasso, Tree importance).\n" +
                "• **Feature Scaling:**\n" +
                "  - *Normalization (Min-Max Scaling):* Scales features to [0, 1]: $X_{norm} = (X - X_{min}) / (X_{max} - X_{min})$.\n" +
                "  - *Standardization (Z-score):* Centers at mean 0 with unit variance: $z = (X - \\mu) / \\sigma$. Essential for algorithms calculating distances (KNN, SVM, K-Means) and Gradient Descent.");

        KNOWLEDGE.put("bias_variance_tradeoff",
                "⚖️ **Bias, Variance & The Bias-Variance Tradeoff**\n\n" +
                "• **Bias (Underfitting):** Error from overly simplistic model assumptions. High bias models underfit, showing poor accuracy on both train and test data.\n" +
                "• **Variance (Overfitting):** Sensitivity to small fluctuations/noise in training data. High variance models overfit, memorizing training noise with near-zero training error but high test error.\n" +
                "• **The Tradeoff:** Expected Error = $\\text{Bias}^2 + \\text{Variance} + \\text{Irreducible Error}$. Optimal models strike the balance that minimizes total error.");

        KNOWLEDGE.put("overfitting",
                "📈 **Overfitting (High Variance)**\n\n" +
                "**Concept:** Model learns noise and details in training data so closely that it fails to generalize to unseen test data.\n" +
                "**Remedies:** Gather more training data, apply data augmentation, use cross-validation, apply regularization (L1/L2), use Dropout in neural networks, prune decision trees, and use early stopping.");

        KNOWLEDGE.put("underfitting",
                "📉 **Underfitting (High Bias)**\n\n" +
                "**Concept:** Model is too simple to capture underlying structural patterns in the data.\n" +
                "**Remedies:** Increase model capacity/complexity, engineer non-linear and interaction features, decrease regularization penalties, and train for more epochs.");

        KNOWLEDGE.put("cross_validation",
                "🔄 **Cross Validation (CV)**\n\n" +
                "**Concept:**\n" +
                "A statistical resampling technique to evaluate model generalization and prevent overfitting from a lucky or unlucky single train/test split.\n\n" +
                "**K-Fold Cross Validation:**\n" +
                "1. Splits data into K equal folds.\n" +
                "2. Trains on K-1 folds and evaluates on the remaining fold.\n" +
                "3. Repeats K times, with each fold acting as test set once.\n" +
                "4. Averages the scores across all K iterations.\n\n" +
                "**Variants:** Stratified K-Fold (preserves class proportions in imbalanced datasets) and TimeSeriesSplit.");

        KNOWLEDGE.put("hyperparameter_tuning",
                "🎛️ **Hyperparameter Tuning**\n\n" +
                "**Parameters vs Hyperparameters:**\n" +
                "• *Parameters:* Internal variables learned by the algorithm from data (weights, biases, tree split thresholds).\n" +
                "• *Hyperparameters:* Configuration settings chosen before training starts (learning rate, tree depth, number of estimators, regularization strength C).\n\n" +
                "**Optimization Methods:**\n" +
                "• **Grid Search (GridSearchCV):** Exhaustive search through all specified parameter combinations.\n" +
                "• **Random Search (RandomizedSearchCV):** Samples random parameter combinations; faster and often finds better configurations.\n" +
                "• **Bayesian Optimization:** Uses probabilistic models to guide parameter selection toward high-performing regions.");
    }

    private static void initMlAlgorithms() {
        KNOWLEDGE.put("linear_regression",
                "📈 **Linear Regression**\n\n" +
                "**Definition:**\n" +
                "Linear Regression is a supervised learning algorithm that models the linear relationship between a continuous dependent target variable $Y$ and one or more independent predictor features $X$.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Equation:** Fits the linear relationship $Y = \\beta_0 + \\beta_1 X_1 + \\dots + \\epsilon$ through the feature space.\n" +
                "2. **Optimization:** Minimizes the sum of squared differences (residuals) between actual and predicted target values using Ordinary Least Squares (OLS) or Gradient Descent.\n" +
                "3. **Prediction:** Evaluates new feature values using the learned coefficients $\\beta$ to compute continuous numeric predictions.\n\n" +
                "📌 **Simple Example:**\n" +
                "Predicting salary: An organization uses years of work experience to predict an employee's annual salary, finding that every additional year of experience adds $5,000 to base compensation.");

        KNOWLEDGE.put("multiple_linear_regression",
                "📈 **Multiple Linear Regression & Polynomial Regression**\n\n" +
                "• **Multiple Linear Regression:** Extends linear regression to multiple predictor variables ($X_1, X_2, \\dots, X_p$) to predict target $Y$.\n" +
                "• **Polynomial Regression:** Models non-linear curvilinear relationships by adding polynomial powers of predictor variables ($X^2, X^3$), while remaining linear in coefficients.");

        KNOWLEDGE.put("logistic_regression",
                "🎯 **Logistic Regression**\n\n" +
                "**Definition:**\n" +
                "Logistic Regression is a supervised classification algorithm that estimates the probability of discrete categorical outcomes (such as binary Yes/No) using the logistic sigmoid function.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Linear Combination:** Computes a weighted sum of input features $z = W^T X + b$.\n" +
                "2. **Sigmoid Mapping:** Passes $z$ through the sigmoid function $\\sigma(z) = \\frac{1}{1 + e^{-z}}$, squashing any value into a probability between 0.0 and 1.0.\n" +
                "3. **Classification Decision:** Applies a probability decision threshold (typically 0.5); if $P \\ge 0.5$, it predicts the positive class, otherwise the negative class.\n\n" +
                "📌 **Simple Example:**\n" +
                "Email spam filter: The algorithm calculates a 92% probability that an incoming email with trigger words like 'free prize' is spam, routing it directly to the Spam folder.");

        KNOWLEDGE.put("knn",
                "📍 **K-Nearest Neighbors (KNN)**\n\n" +
                "**Definition:**\n" +
                "K-Nearest Neighbors is an instance-based, non-parametric supervised learning algorithm that classifies new data points based on the majority class of their $K$ closest neighbors in feature space.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Store Data:** Stores all training data points without explicit model training (lazy learning).\n" +
                "2. **Calculate Distance:** Measures the distance (such as Euclidean or Manhattan distance) between a new query point and all stored training samples.\n" +
                "3. **Majority Vote:** Identifies the $K$ nearest points and assigns the most common class label among those $K$ neighbors (or averages their values for regression).\n\n" +
                "📌 **Simple Example:**\n" +
                "Movie recommendations: If a user's movie taste is closest to 5 other subscribers who all loved 'Interstellar', KNN predicts and recommends 'Interstellar' for that user.");

        KNOWLEDGE.put("decision_tree",
                "🌲 **Decision Tree (CART / ID3)**\n\n" +
                "**Definition:**\n" +
                "A Decision Tree is a supervised machine learning algorithm that recursively splits data into branch-like if-else decision rules based on feature values to predict target classes or continuous values.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Select Best Split:** Evaluates all available features and finds the split that maximizes purity or information gain (using Gini Impurity or Entropy).\n" +
                "2. **Recursive Partitioning:** Divides the dataset into subsets at each internal decision node.\n" +
                "3. **Leaf Prediction:** Continues splitting until stopping conditions (like max depth) are met, assigning the majority class or average value at terminal leaf nodes.\n\n" +
                "📌 **Simple Example:**\n" +
                "Loan approval: A bank checks IF credit score $> 700$ AND income $> $50,000 THEN approve loan; ELSE reject loan.");

        KNOWLEDGE.put("random_forest",
                "🌳 **Random Forest (Ensemble Bagging)**\n\n" +
                "**Definition:**\n" +
                "Random Forest is an ensemble supervised learning algorithm that builds a multitude of uncorrelated decision trees during training and combines their predictions to produce higher accuracy and reduce overfitting.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Bootstrap Aggregating (Bagging):** Draws multiple independent random samples with replacement from the training dataset.\n" +
                "2. **Feature Randomization:** Trains an individual tree on each bootstrap sample, considering only a random subset of features (typically $\\sqrt{p}$) at each node split to decorrelate trees.\n" +
                "3. **Aggregate Predictions:** Averages the predictions (regression) or takes the majority vote (classification) across all trees in the forest.\n\n" +
                "📌 **Simple Example:**\n" +
                "Medical diagnosis: Rather than relying on a single doctor's opinion, a panel of 100 independent medical specialists evaluate a patient's symptoms and vote on the final diagnosis.");

        KNOWLEDGE.put("svm",
                "📐 **Support Vector Machine (SVM)**\n\n" +
                "**Definition:**\n" +
                "Support Vector Machine is a supervised learning algorithm that finds the optimal hyperplane that separates different classes with the maximum functional margin in high-dimensional feature space.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Identify Support Vectors:** Finds the closest training data points from each class to the decision boundary.\n" +
                "2. **Maximize Geometric Margin:** Calculates the separating hyperplane that maximizes the geometric distance (margin) between support vectors of opposite classes.\n" +
                "3. **Kernel Trick:** When data is linearly non-separable, uses kernel functions (RBF/Gaussian, Polynomial) to project data into higher dimensions where a linear boundary can separate them.\n\n" +
                "📌 **Simple Example:**\n" +
                "Handwriting recognition: SVM identifies distinct characters by drawing wide decision margins between stroke curvature and loop features of handwritten letters.");

        KNOWLEDGE.put("naive_bayes",
                "🎲 **Naive Bayes Classifier**\n\n" +
                "**Definition:**\n" +
                "Naive Bayes is a probabilistic supervised classifier based on Bayes' Theorem that calculates class probabilities under the simplifying assumption that all predictor features are conditionally independent given the class label.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Bayes' Rule:** Computes posterior probabilities for each class: $P(C|X) = \\frac{P(X|C) \\cdot P(C)}{P(X)}$.\n" +
                "2. **Independence Assumption:** Multiplies individual feature probabilities: $P(X|C) = \\prod P(x_i|C)$.\n" +
                "3. **Class Assignment:** Selects the class with the highest resulting posterior probability.\n\n" +
                "📌 **Simple Example:**\n" +
                "Spam detection: It calculates the probability an email is spam based on the independent presence of words like 'free', 'lottery', and 'click', classifying it as spam if that probability is highest.");

        KNOWLEDGE.put("pca",
                "📉 **Principal Component Analysis (PCA)**\n\n" +
                "**Concept:**\n" +
                "An unsupervised linear dimensionality reduction algorithm that projects high-dimensional correlated features onto a smaller set of orthogonal, uncorrelated directions called **Principal Components** that maximize variance.\n\n" +
                "**Steps:** Standardize data $\\to$ Compute covariance matrix $\\to$ Calculate eigenvalues & eigenvectors $\\to$ Project data onto top $k$ eigenvectors.");

        KNOWLEDGE.put("gradient_descent",
                "📉 **Gradient Descent & SGD**\n\n" +
                "**Concept:**\n" +
                "A first-order iterative optimization algorithm that finds the local minimum of a differentiable loss function by taking steps proportional to the negative gradient.\n\n" +
                "**Update Rule:** $\\theta := \\theta - \\alpha \\nabla J(\\theta)$, where $\\alpha$ is learning rate.\n\n" +
                "• **Batch Gradient Descent:** Uses entire dataset per update (slow, stable).\n" +
                "• **Stochastic Gradient Descent (SGD):** Uses 1 random sample per step (fast, noisy).\n" +
                "• **Mini-Batch SGD:** Uses batches of 32/64/128 samples (optimal hardware parallelism).");

        KNOWLEDGE.put("ensemble_learning",
                "🤝 **Ensemble Learning: Bagging, Boosting & Stacking**\n\n" +
                "**Concept:** Combining multiple diverse base models to produce a collective model with superior generalization performance.\n\n" +
                "• **Bagging (Bootstrap Aggregation):** Trains diverse estimators in parallel on random data subsets with replacement (e.g., Random Forest). Reduces variance.\n" +
                "• **Boosting:** Trains models sequentially, where each new tree corrects the residual errors of previous trees (e.g., AdaBoost, Gradient Boosting, XGBoost). Reduces bias.\n" +
                "• **Stacking:** Trains a meta-model to optimally combine the predictions of multiple diverse base algorithms.");

        KNOWLEDGE.put("adaboost",
                "⚡ **AdaBoost (Adaptive Boosting)**\n\n" +
                "**Concept:**\n" +
                "A sequential ensemble boosting algorithm where base models (typically decision tree stumps) are trained iteratively. In each iteration, data points misclassified by previous learners are assigned higher sample weights, forcing the next learner to focus on hard-to-classify instances.");

        KNOWLEDGE.put("xgboost",
                "🚀 **Gradient Boosting & XGBoost**\n\n" +
                "• **Gradient Boosting (GBDT):** Sequentially fits shallow decision trees to the negative gradient (pseudo-residuals) of the loss function.\n" +
                "• **XGBoost (Extreme Gradient Boosting):** An engineered scalable implementation that uses second-order Taylor approximations (gradients and Hessians), built-in L1/L2 tree regularization, and cache-aware parallelization.");
    }

    private static void initClusteringAlgorithms() {
        KNOWLEDGE.put("kmeans",
                "🎯 **K-Means Clustering**\n\n" +
                "**Definition:**\n" +
                "K-Means is an unsupervised machine learning algorithm that partitions a dataset into a predefined number ($K$) of distinct, non-overlapping clusters where each data point belongs to the cluster with the nearest mean (centroid).\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Initialize Centroids:** Choose $K$ initial cluster centers randomly or using smart initialization like K-Means++.\n" +
                "2. **Assign Points:** Compute the distance (such as Euclidean distance) from every data point to each centroid, assigning each point to its nearest cluster.\n" +
                "3. **Update Centroids:** Recalculate each centroid's coordinates as the average (mean) of all points currently assigned to that cluster.\n" +
                "4. **Iterate to Convergence:** Repeat the assignment and update steps until centroid positions stabilize and stop shifting.\n\n" +
                "📌 **Simple Example:**\n" +
                "Customer segmentation: A store groups shoppers into $K=3$ clusters based on income and shopping frequency, uncovering distinct segments of Budget Shoppers, Regular Buyers, and VIP Customers.");

        KNOWLEDGE.put("dbscan",
                "🌐 **DBSCAN (Density-Based Spatial Clustering of Applications with Noise)**\n\n" +
                "**Definition:**\n" +
                "DBSCAN is an unsupervised clustering algorithm that groups together data points that are closely packed in high-density regions while marking points lying in low-density sparse regions as noise or outliers.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Parameters:** Uses two hyperparameters: Epsilon ($\\epsilon$, search radius) and MinPts (minimum points needed to form a dense neighborhood).\n" +
                "2. **Classify Points:** Labels points as **Core points** (at least MinPts neighbors within $\\epsilon$), **Border points** (reachable from a core point but fewer than MinPts neighbors), or **Noise points** (isolated outliers).\n" +
                "3. **Expand Clusters:** Connects adjacent core points and their reachable border points into dense clusters of arbitrary, non-spherical shapes.\n" +
                "4. **Detect Outliers:** Points that do not satisfy density thresholds remain unassigned and are flagged as outliers without forcing them into a cluster.\n\n" +
                "📌 **Simple Example:**\n" +
                "Credit card fraud detection: Normal daily customer purchases cluster tightly in typical dollar amounts and geographical locations, while an abnormal transaction made in a distant country appears in a sparse region and is immediately flagged as an outlier.");

        KNOWLEDGE.put("hierarchical_clustering",
                "🌿 **Hierarchical Clustering**\n\n" +
                "**Definition:**\n" +
                "Hierarchical Clustering is an unsupervised algorithm that builds a nested tree-like hierarchy of clusters called a **Dendrogram**, showing step-by-step how clusters are grouped together or divided.\n\n" +
                "**How It Works (Working):**\n" +
                "1. **Choose Strategy:** Can be built using **Agglomerative (Bottom-Up)** or **Divisive (Top-Down)** approaches.\n" +
                "2. **Agglomerative Process:** Starts with every single data point as an individual cluster of its own.\n" +
                "3. **Compute Linkage & Merge:** Calculates pairwise distances between clusters using linkage criteria (such as Ward's linkage, complete linkage, or average linkage) and merges the two closest clusters.\n" +
                "4. **Cut Dendrogram:** Merging continues until all points form one root cluster. Cutting the dendrogram horizontally at an appropriate height yields the desired number of clusters without choosing $K$ upfront.\n\n" +
                "📌 **Simple Example:**\n" +
                "Biological classification: Organizing animal species into genera, families, and orders based on anatomical and genetic similarities, visualized as an evolutionary tree of life.");
    }

    private static void initTypesExplanations1() {
        KNOWLEDGE.put("clustering_types",
                "🫧 **Types of Clustering in Machine Learning**\n\n" +
                "1. **K-Means Clustering:** K-Means divides the data into a fixed number of groups called clusters. Data points with similar characteristics are placed in the same cluster based on proximity to cluster centers (centroids). It works best for spherical, well-separated data distributions.\n\n" +
                "2. **DBSCAN (Density-Based Spatial Clustering):** DBSCAN groups data points based on their density. It can also detect outliers and can handle clusters of different arbitrary shapes. Unlike K-Means, it does not require you to pre-specify the number of clusters beforehand.\n\n" +
                "3. **Hierarchical Clustering:** Hierarchical clustering creates a tree-like structure of clusters called a dendrogram. It can be done using agglomerative (bottom-up merging) or divisive (top-down splitting) approaches without requiring a predetermined cluster count.");

        KNOWLEDGE.put("supervised_learning_types",
                "🎯 **Types of Supervised Learning**\n\n" +
                "Supervised learning trains on labeled datasets and is divided into two primary types based on the target output:\n\n" +
                "1. **Classification:** Classification is used when the target output is a discrete categorical label or class. The algorithm learns decision boundaries to assign inputs into distinct categories, such as sorting emails into 'Spam' or 'Inbox'. Common algorithms include Logistic Regression, Decision Trees, and Support Vector Machines.\n\n" +
                "2. **Regression:** Regression is used when the target output is a continuous numerical value or real number. The algorithm learns mathematical relationships to predict continuous quantities, such as forecasting house prices or estimating tomorrow's temperature. Common algorithms include Linear Regression, Polynomial Regression, and Random Forest Regressors.");

        KNOWLEDGE.put("unsupervised_learning_types",
                "🔍 **Types of Unsupervised Learning**\n\n" +
                "Unsupervised learning analyzes unlabeled data to uncover hidden patterns and consists of three main types:\n\n" +
                "1. **Clustering:** Clustering groups similar data points together based on inherent feature similarities and distances. Points with similar traits are assigned to the same cluster without needing predefined labels. Common algorithms include K-Means, DBSCAN, and Hierarchical Clustering for customer segmentation.\n\n" +
                "2. **Dimensionality Reduction:** Dimensionality reduction compresses high-dimensional datasets into a smaller set of informative features while preserving most of the original variation. It simplifies data analysis, speeds up training, and aids visualization. Prominent algorithms include PCA (Principal Component Analysis) and t-SNE.\n\n" +
                "3. **Association Rule Learning:** Association rule learning discovers interesting relationships and co-occurrences between items in large datasets. It identifies rules showing that the presence of one item implies the likelihood of another. A classic example is market basket analysis, such as discovering that customers who buy milk often also purchase bread.");

        KNOWLEDGE.put("classification_types",
                "🎯 **Types of Classification**\n\n" +
                "Classification tasks in machine learning are categorized into three main types based on label structure:\n\n" +
                "1. **Binary Classification:** Binary classification predicts between exactly two mutually exclusive classes or categories. The model determines which of the two labels an input belongs to, such as classifying an email as 'Spam' or 'Not Spam'. Other common examples include credit card fraud detection and medical diagnosis (disease present or absent).\n\n" +
                "2. **Multi-Class Classification:** Multi-class classification assigns each input instance to exactly one category chosen from three or more possible classes. The model evaluates probability distributions across all potential categories and selects the most likely one. Examples include classifying handwritten digits (0 through 9), recognizing animal species (dog, cat, bird), or detecting the language of a sentence.\n\n" +
                "3. **Multi-Label Classification:** Multi-label classification allows a single data instance to be assigned multiple non-exclusive labels simultaneously. Each label represents a distinct property that can be independently true or false for the same input. Common examples include tagging news articles with several topics (like 'Technology', 'Business', and 'AI') or identifying multiple objects present within a single photo.");

        KNOWLEDGE.put("regression_types",
                "📈 **Types of Regression**\n\n" +
                "Regression techniques are categorized based on the relationship between predictor features and continuous targets:\n\n" +
                "1. **Linear Regression:** Linear regression models a straight-line relationship between a single independent variable and a continuous dependent target. It calculates the best-fitting line by minimizing the sum of squared differences between predictions and actual values. A simple example is predicting an employee's salary based solely on years of work experience.\n\n" +
                "2. **Multiple Linear Regression:** Multiple linear regression extends simple linear regression by using two or more input features to predict a continuous outcome. It accounts for multiple factors simultaneously to produce more accurate estimates. A classic example is estimating a house's market price using its square footage, number of bedrooms, and neighborhood crime rate.\n\n" +
                "3. **Polynomial Regression:** Polynomial regression models non-linear relationships by incorporating higher-degree powers of predictor features (such as $X^2$ or $X^3$). It allows the regression curve to bend and capture curvature in data patterns while still using linear optimization techniques. It is ideal for physical or biological processes that accelerate or decelerate over time.\n\n" +
                "4. **Ridge & Lasso Regression (Regularized Regression):** Regularized regression adds mathematical penalty terms to the loss function to prevent overfitting and handle multicollinearity. Ridge uses an L2 penalty to shrink large weights, while Lasso uses an L1 penalty that can shrink unnecessary weights to zero for automatic feature selection.");
    }

    private static void initTypesExplanations2() {
        KNOWLEDGE.put("deep_learning_types",
                "🧠 **Types of Neural Networks & Deep Learning Architectures**\n\n" +
                "Deep learning employs specialized neural network architectures tailored to different data types:\n\n" +
                "1. **Artificial Neural Networks (ANN / Feedforward):** ANNs consist of an input layer, one or more hidden layers, and an output layer where signals flow strictly forward. Each artificial neuron computes a weighted sum followed by a non-linear activation function. They are primarily used for tabular structured datasets and general predictive modeling.\n\n" +
                "2. **Convolutional Neural Networks (CNN):** CNNs use specialized convolutional filters and pooling layers to detect spatial hierarchies and visual patterns directly from raw pixels. They share weights across receptive fields to remain robust against image translation and distortion. They dominate computer vision applications like facial recognition, object detection, and medical imaging.\n\n" +
                "3. **Recurrent Neural Networks (RNN & LSTM/GRU):** RNNs feature internal recurrent connections that pass memory from previous time steps to process sequential data. Modern architectures like Long Short-Term Memory (LSTM) and GRU use internal gates to retain long-term context and prevent vanishing gradients. They are widely applied in natural language processing, speech recognition, and time series forecasting.\n\n" +
                "4. **Transformers:** Transformers replace sequential recurrence with self-attention mechanisms, allowing models to process entire text sequences simultaneously in parallel. They capture long-range dependencies across tokens with high efficiency. Transformers form the backbone of modern Large Language Models such as GPT-4, BERT, and Gemini.");

        KNOWLEDGE.put("generative_ai_types",
                "🎨 **Types of Generative AI Models**\n\n" +
                "Generative AI models create new, original content through several distinct architectural approaches:\n\n" +
                "1. **Large Language Models (LLMs):** LLMs are autoregressive transformer models trained on vast text corpora to predict the next token in a sequence. They generate human-like text, answer questions, write code, and perform complex reasoning. Well-known examples include ChatGPT, Gemini, and Claude.\n\n" +
                "2. **Diffusion Models:** Diffusion models generate photorealistic images and media by learning to reverse a gradual noise-adding process. During inference, they start with pure random Gaussian noise and iteratively remove noise step by step until a clear image emerges. Popular examples include Stable Diffusion, Midjourney, and DALL-E.\n\n" +
                "3. **Generative Adversarial Networks (GANs):** GANs consist of two competing neural networks: a Generator that creates fake synthetic data and a Discriminator that attempts to distinguish real data from fakes. As both networks train against each other, the generator learns to produce hyper-realistic samples. They are widely used for deepfakes, style transfer, and super-resolution.\n\n" +
                "4. **Variational Autoencoders (VAEs):** VAEs encode input data into a compressed, continuous probabilistic latent space and decode samples back into reconstructed data. Because the latent space is smooth and continuous, they allow easy generation and interpolation of novel synthetic samples.");

        KNOWLEDGE.put("reinforcement_learning_types",
                "🎮 **Types of Reinforcement Learning**\n\n" +
                "Reinforcement learning algorithms are categorized based on how the agent chooses actions and learns from its environment:\n\n" +
                "1. **Model-Free Reinforcement Learning:** In model-free RL, the agent learns optimal policies purely through direct trial-and-error interactions without building an explicit simulation model of the environment. It relies either on estimating state-action values (such as Q-Learning and Deep Q-Networks) or optimizing policy gradients directly (such as REINFORCE and PPO). It is widely used in complex games and simulated environments.\n\n" +
                "2. **Model-Based Reinforcement Learning:** In model-based RL, the agent builds or uses an explicit internal model that predicts state transitions and future rewards. This allows the agent to simulate hypothetical trajectories and plan ahead before executing real actions. It is highly sample-efficient and well-suited for robotics and industrial control where real-world trials are costly.\n\n" +
                "3. **Policy-Based vs. Value-Based Methods:** Value-based methods learn an action-value function ($Q(s, a)$) to find the action with the highest expected reward, while policy-based methods directly optimize policy parameters using gradient ascent. Policy-based methods are particularly effective when dealing with continuous action spaces such as robot joint movements.");

        KNOWLEDGE.put("search_algorithms_types",
                "🔍 **Types of Search Algorithms in Artificial Intelligence**\n\n" +
                "Search algorithms in AI are divided into primary categories based on domain knowledge and problem setup:\n\n" +
                "1. **Uninformed Search (Blind Search):** Uninformed search explores the state space without any domain-specific estimate of distance to the goal. It evaluates nodes using only the problem definition and path costs. Common examples include Breadth-First Search (BFS, guarantees shortest step path), Depth-First Search (DFS, memory-efficient), and Uniform Cost Search (UCS, optimal for weighted graphs).\n\n" +
                "2. **Informed Search (Heuristic Search):** Informed search uses heuristic functions ($h(n)$) to estimate how close a given state is to the goal. This domain insight guides the search toward the most promising paths first. Examples include Greedy Best-First Search and A* Search (which guarantees optimal paths when using an admissible heuristic).\n\n" +
                "3. **Adversarial Game Search:** Adversarial search is used in competitive, multi-agent environments where opposing agents have conflicting objectives. The agent must anticipate opponent moves and choose optimal counter-actions. Examples include the Minimax algorithm and Alpha-Beta Pruning, which power chess and checkers engines.");

        KNOWLEDGE.put("tokenization_types",
                "✂️ **Types of Tokenization in NLP**\n\n" +
                "Tokenization breaks raw text into individual linguistic tokens through three primary approaches:\n\n" +
                "1. **Word-Level Tokenization:** Word-level tokenization splits text into individual words based on spaces and punctuation marks. It produces simple and easily readable vocabularies for language modeling. However, it cannot handle unseen out-of-vocabulary (OOV) words and leads to massive vocabulary sizes in diverse languages.\n\n" +
                "2. **Character-Level Tokenization:** Character-level tokenization breaks text down into individual letters and symbols. It completely eliminates out-of-vocabulary issues because any word can be spelled character by character. However, it results in extremely long sequences that make it harder for models to learn rich word meanings.\n\n" +
                "3. **Subword Tokenization:** Subword tokenization strikes an optimal balance by keeping common words intact while breaking rare or unknown words into meaningful subword units. It handles unseen words gracefully while keeping vocabulary sizes manageable. Standard algorithms like Byte-Pair Encoding (BPE), WordPiece, and SentencePiece are used by state-of-the-art models like GPT and BERT.");

        KNOWLEDGE.put("ensemble_learning_types",
                "🤝 **Types of Ensemble Learning**\n\n" +
                "Ensemble learning combines multiple individual models to create a stronger predictive system through three core techniques:\n\n" +
                "1. **Bagging (Bootstrap Aggregating):** Bagging trains multiple base models in parallel on different random subsets of data sampled with replacement. The final prediction is obtained by averaging predictions or taking a majority vote. It significantly reduces variance and prevents overfitting, with Random Forest being the prime example.\n\n" +
                "2. **Boosting:** Boosting trains base models sequentially, where each new model focuses on correcting the errors and misclassifications made by previous models. It assigns higher weights to difficult instances and combines models through weighted voting. It effectively reduces bias and yields high accuracy, with examples like AdaBoost, Gradient Boosting, and XGBoost.\n\n" +
                "3. **Stacking (Stacked Generalization):** Stacking trains several different types of base models (such as SVM, Decision Trees, and Logistic Regression) simultaneously. A higher-level meta-model is then trained to optimally combine their individual predictions. It leverages the distinct strengths of diverse algorithms for maximum generalization.");
    }

    private static void initModelEvaluation() {
        KNOWLEDGE.put("model_evaluation",
                "📊 **Model Evaluation Overview**\n\n" +
                "Evaluating machine learning models requires domain-appropriate metrics beyond raw training accuracy to ensure proper generalization to unseen data.\n\n" +
                "• **Classification:** Accuracy, Precision, Recall, F1 Score, Confusion Matrix, ROC-AUC, Log Loss.\n" +
                "• **Regression:** MAE, MSE, RMSE, R² Score, Adjusted R².\n" +
                "• **Clustering:** Silhouette Score, Davies-Bouldin Index.");

        KNOWLEDGE.put("confusion_matrix",
                "🔲 **Confusion Matrix**\n\n" +
                "A tabular layout that visualizes the performance of a classification algorithm:\n\n" +
                "| | Predicted Positive | Predicted Negative |\n" +
                "| :--- | :--- | :--- |\n" +
                "| **Actual Positive** | **True Positive (TP)** | **False Negative (FN)** (Type II Error) |\n" +
                "| **Actual Negative** | **False Positive (FP)** (Type I Error) | **True Negative (TN)** |\n\n" +
                "Forms the mathematical basis for Accuracy, Precision, Recall, Specificity, and F1 Score.");

        KNOWLEDGE.put("roc_auc",
                "📈 **ROC Curve & AUC Score**\n\n" +
                "• **ROC Curve (Receiver Operating Characteristic):** Plots True Positive Rate (Sensitivity / Recall) on the y-axis against False Positive Rate (1 - Specificity) on the x-axis across all classification decision thresholds.\n" +
                "• **AUC (Area Under the Curve):** Scalar metric from 0.0 to 1.0 measuring classification capability regardless of threshold. AUC = 0.5 represents random guessing; AUC = 1.0 represents perfect discrimination.");

        KNOWLEDGE.put("f1_score",
                "⚖️ **Accuracy, Precision, Recall & F1 Score**\n\n" +
                "• **Accuracy:** $\\frac{TP + TN}{TP + TN + FP + FN}$. Misleading on imbalanced datasets.\n" +
                "• **Precision:** $\\frac{TP}{TP + FP}$. Percentage of positive predictions that were actually correct. Prioritize when False Positives are costly (spam detection).\n" +
                "• **Recall (Sensitivity):** $\\frac{TP}{TP + FN}$. Percentage of actual positive cases detected. Prioritize when False Negatives are dangerous (cancer diagnosis).\n" +
                "• **F1 Score:** $2 \\cdot \\frac{\\text{Precision} \\cdot \\text{Recall}}{\\text{Precision} + \\text{Recall}}$. Harmonic mean balancing Precision and Recall.");

        KNOWLEDGE.put("regression_metrics",
                "📐 **Regression Metrics: MAE, MSE, RMSE, R²**\n\n" +
                "• **MAE (Mean Absolute Error):** $\\frac{1}{n} \\sum |y_i - \\hat{y}_i|$. Average error magnitude; robust to outliers.\n" +
                "• **MSE (Mean Squared Error):** $\\frac{1}{n} \\sum (y_i - \\hat{y}_i)^2$. Heavily penalizes large outlier errors.\n" +
                "• **RMSE (Root Mean Squared Error):** $\\sqrt{MSE}$. In the same units as the target variable.\n" +
                "• **R² Score:** $1 - \\frac{\\sum (y_i - \\hat{y}_i)^2}{\\sum (y_i - \\bar{y})^2}$. Proportion of target variance explained by predictor features (1.0 = perfect).");

        KNOWLEDGE.put("log_loss",
                "📉 **Log Loss (Cross-Entropy Loss)**\n\n" +
                "**Concept:**\n" +
                "Measures the performance of a classification model whose output is a probability value between 0 and 1.\n\n" +
                "**Formula (Binary):** $-\\frac{1}{n} \\sum [y_i \\log(\\hat{p}_i) + (1 - y_i) \\log(1 - \\hat{p}_i)]$.\n\n" +
                "Heavily penalizes predictions that are confident and wrong.");

        KNOWLEDGE.put("silhouette_score",
                "✨ **Silhouette Score**\n\n" +
                "**Concept:**\n" +
                "Measures how similar an object is to its own cluster (cohesion) compared to other clusters (separation).\n\n" +
                "**Formula:** $s(i) = \\frac{b(i) - a(i)}{\\max(a(i), b(i))}$, where $a(i)$ is mean intra-cluster distance, $b(i)$ is mean nearest-cluster distance.\n\n" +
                "**Range:** [-1, +1]. High value near +1 indicates well-separated, dense clusters.");
    }

    // =========================================================================
    // 3. DEEP LEARNING & COMPONENTS
    // =========================================================================
    private static void initDeepLearning() {
        KNOWLEDGE.put("deep_learning",
                "🧠 **Deep Learning (DL)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "Deep Learning is a specialized subfield of Machine Learning based on Artificial Neural Networks with multiple hidden layers (deep neural networks). It mimics how neurons in the human brain process data.\n\n" +
                "**Key Points:**\n" +
                "• **Why 'Deep':** Uses neural networks with 3 or more hidden layers.\n" +
                "• **Automatic Feature Learning:** Automatically extracts features from raw data (like images and audio) without manual feature engineering.\n" +
                "• **Core Architectures:** Multi-Layer Perceptrons (MLP), CNNs (images), RNNs/LSTMs (sequences), and Transformers (LLMs).\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• Face recognition on smartphones\n" +
                "• Voice assistants like Siri and Google Assistant\n" +
                "• Autonomous vehicle vision\n" +
                "• ChatGPT and generative AI systems");

        KNOWLEDGE.put("deep_learning_explain",
                "🧠 **Explanation: Deep Learning (DL)**\n\n" +
                "**1. What is Deep Learning?**\n" +
                "Deep Learning is a subset of Machine Learning that uses deep neural networks with many stacked layers. It takes raw data (like photos or sound) and learns to recognize complex patterns on its own.\n\n" +
                "**2. How Deep Learning Works:**\n" +
                "• **Layer 1 (Input):** Receives raw input data (like image pixel values).\n" +
                "• **Early Hidden Layers:** Detect low-level patterns like edges, lines, and colors.\n" +
                "• **Middle Hidden Layers:** Combine edges into shapes, textures, and object parts.\n" +
                "• **Final Output Layer:** Makes the high-level decision or prediction (e.g., classifying an image as 'Cat').\n\n" +
                "**3. Main Neural Network Architectures:**\n" +
                "1. **Artificial Neural Networks (ANN):** Best for tabular data and general predictions.\n" +
                "2. **Convolutional Neural Networks (CNN):** Best for computer vision and image processing.\n" +
                "3. **Recurrent Neural Networks (RNN & LSTM):** Best for sequential text, speech, and time-series data.\n" +
                "4. **Transformers:** State-of-the-art architecture powering modern LLMs like GPT and Gemini.\n\n" +
                "**4. Important Real-World Uses:**\n" +
                "• Autonomous driving (Tesla Autopilot detecting roads and pedestrians)\n" +
                "• Healthcare (detecting cancer and diseases in MRI/CT scans)\n" +
                "• Language translation (Google Translate)\n" +
                "• Voice assistants (Siri, Alexa)");

        KNOWLEDGE.put("neural_network",
                "🕸️ **Artificial Neural Networks (ANN)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "An Artificial Neural Network is modeled loosely on how neurons in the human brain work together! Signals flow through layers of interconnected virtual neurons, each applying a small calculation until the final layer reaches a smart decision.\n\n" +
                "**Concept:**\n" +
                "A computational model inspired by biological neurons in the human brain, designed to approximate complex non-linear functions.\n\n" +
                "**Core Architecture:**\n" +
                "1. **Input Layer:** Receives numerical raw feature inputs.\n" +
                "2. **Hidden Layers:** Performs linear transformations ($z = W x + b$) followed by non-linear activations.\n" +
                "3. **Output Layer:** Generates predictions (probabilities or continuous values).\n\n" +
                "**Training Cycle:** Forward Propagation $\\to$ Loss Calculation $\\to$ Backpropagation $\\to$ Weight Update.");

        KNOWLEDGE.put("perceptron",
                "⚡ **Artificial Neuron & The Perceptron**\n\n" +
                "**Concept:**\n" +
                "Invented by Frank Rosenblatt (1958), the Perceptron is the foundational artificial neuron unit.\n\n" +
                "**Equation:** $y = f\\left(\\sum_{i=1}^n w_i x_i + b\\right)$.\n\n" +
                "**Limitation:** A single perceptron can only solve linearly separable problems. It cannot solve the XOR problem, which led to Multi-Layer Perceptrons (MLPs).");

        KNOWLEDGE.put("cnn",
                "🖼️ **Convolutional Neural Network (CNN)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "A Convolutional Neural Network (CNN) is a deep learning neural network designed specifically for processing and analyzing visual data, such as images and videos.\n\n" +
                "**Key Layers (Working Mechanism):**\n" +
                "• **Convolutional Layers:** Use sliding filters to extract visual features (like edges, textures, and shapes).\n" +
                "• **Pooling Layers:** Reduce image size and computation while preserving important features.\n" +
                "• **Fully Connected Layer:** Combines all features to make the final classification prediction.\n\n" +
                "**Key Advantages:**\n" +
                "• **Feature extraction:** Automatically learns visual features directly from raw pixels.\n" +
                "• **Parameter sharing:** Reuses filter weights across the image to reduce model parameters.\n\n" +
                "**Everyday Applications:**\n" +
                "• Image classification (e.g., detecting dogs vs. cats).\n" +
                "• Facial recognition and biometric phone unlock.\n" +
                "• Autonomous vehicle vision (detecting pedestrians, lane markings, and road signs).\n" +
                "• Medical imaging (detecting tumors and fractures in X-rays).");

        KNOWLEDGE.put("cnn_explain",
                "🖼️ **Explanation: Convolutional Neural Network (CNN)**\n\n" +
                "**1. What is a CNN?**\n" +
                "A Convolutional Neural Network (CNN) is a type of deep neural network built to understand images. Instead of flattening an image into a simple list of numbers, a CNN keeps the 2D spatial arrangement of pixels intact.\n\n" +
                "**2. How a CNN Works (Step-by-Step):**\n" +
                "• **Step 1 - Convolutional Layer:** Small filters (kernels) slide across the image, multiplying pixel values to detect features like edges, curves, and textures.\n" +
                "• **Step 2 - ReLU Activation:** Replaces negative numbers with zero to help the model learn complex, non-linear patterns.\n" +
                "• **Step 3 - Pooling Layer:** Max pooling shrinks the image dimensions by keeping only the strongest feature signals.\n" +
                "• **Step 4 - Stacking Layers:** Stacking multiple conv-pool layers allows the network to learn hierarchical patterns (Edges $\\to$ Textures $\\to$ Parts $\\to$ Full Objects).\n" +
                "• **Step 5 - Fully Connected Layer:** Flattens the feature map and uses Softmax to predict the final category.\n\n" +
                "**3. Why CNNs are Powerful (Advantages):**\n" +
                "• **Automatic feature extraction:** No need to manually calculate image properties.\n" +
                "• **Parameter sharing:** The same filter is used across the entire image, drastically cutting down memory.\n\n" +
                "**4. Everyday Applications:**\n" +
                "• Image classification and object detection (YOLO, OpenCV)\n" +
                "• Face recognition and biometric security\n" +
                "• Self-driving cars identifying road objects\n" +
                "• Medical imaging for automated disease diagnosis");

        KNOWLEDGE.put("cnn_working",
                "⚙️ **How a Convolutional Neural Network (CNN) Works**\n\n" +
                "💡 **Step-by-Step Breakdown:**\n\n" +
                "1. **Input Stage:** An image matrix (e.g., 224x224x3 for RGB) is fed into the network.\n" +
                "2. **Feature Extraction with Convolutional Layers:** Small learnable filter kernels slide across the image computing dot products to produce 2D activation feature maps.\n" +
                "3. **Non-Linear Rectification:** Activation functions (ReLU) zero out negative values to model non-linear boundaries.\n" +
                "4. **Spatial Downsampling with Pooling Layers:** Max pooling selects dominant activations in each window, shrinking dimensions and retaining dominant features.\n" +
                "5. **High-Level Hierarchy:** Stacking multiple conv-pool blocks extracts hierarchical abstractions: Edges → Textures → Parts → Entire Objects.\n" +
                "6. **Classification via Dense Layers:** Flattened feature vectors pass through fully connected layers with Softmax to output class probabilities.");

        KNOWLEDGE.put("rnn",
                "🔁 **Recurrent Neural Networks (RNN)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "A Recurrent Neural Network (RNN) is a type of neural network designed for processing sequential data (like text, speech, or time series) by remembering previous inputs through internal loops.\n\n" +
                "**Key Points:**\n" +
                "• **Internal Memory:** Unlike standard neural networks that treat each input independently, an RNN passes information from previous steps into the current step.\n" +
                "• **Hidden State:** Acts as the network's short-term memory ($h_t$).\n" +
                "• **Limitation:** Suffers from the vanishing gradient problem, making it hard to remember long sequences.\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• Speech-to-text recognition.\n" +
                "• Next-word text prediction on smartphone keyboards.\n" +
                "• Weather forecasting and time-series analysis.");

        KNOWLEDGE.put("rnn_explain",
                "🔁 **Explanation: Recurrent Neural Network (RNN)**\n\n" +
                "**1. What is an RNN?**\n" +
                "A Recurrent Neural Network (RNN) is a deep learning model built specifically for data that comes in a sequence—such as words in a sentence or daily stock prices.\n\n" +
                "**2. How Does It Work?**\n" +
                "• When reading a word, the network creates a hidden state (its memory).\n" +
                "• When reading the next word, it combines the new word with the memory from the previous word.\n" +
                "• This loop allows the network to keep context across sequential steps.\n\n" +
                "**3. Why Are Standard RNNs Limited?**\n" +
                "During training via Backpropagation Through Time (BPTT), gradients shrink exponentially (vanishing gradients). This causes RNNs to forget information from words that appeared earlier in long sentences.\n\n" +
                "**4. Modern Solutions:**\n" +
                "• **LSTMs and GRUs:** Use internal gates to maintain long-term memory.\n" +
                "• **Transformers:** Process entire sequences in parallel using self-attention.");

        KNOWLEDGE.put("lstm",
                "🧠 **Long Short-Term Memory (LSTM)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "Long Short-Term Memory (LSTM) is an advanced type of Recurrent Neural Network (RNN) designed to solve the vanishing gradient problem and remember information over long sequences.\n\n" +
                "**Key Points (The 3 Gates):**\n" +
                "• **Forget Gate:** Decides what useless information to discard from memory.\n" +
                "• **Input Gate:** Decides what new information to add to the cell memory.\n" +
                "• **Output Gate:** Decides what information to output at the current step.\n" +
                "• **Cell State:** The long-term memory wire carrying context across all time steps.\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• Language translation (e.g., English to Spanish or Hindi).\n" +
                "• Voice assistants converting speech to text.\n" +
                "• Sentiment analysis on long product reviews.");

        KNOWLEDGE.put("lstm_explain",
                "🧠 **Explanation: Long Short-Term Memory (LSTM)**\n\n" +
                "**1. What is an LSTM?**\n" +
                "An LSTM is a specialized recurrent neural network that can maintain memory over long time periods. It was created by Hochreiter & Schmidhuber to overcome the standard RNN's tendency to forget early inputs.\n\n" +
                "**2. How LSTM Works (The Cell State & 3 Gates):**\n" +
                "• **Cell State (Memory Wire):** A continuous line running through all time steps with minimal linear interactions, preserving memory intact.\n" +
                "• **Forget Gate:** Uses a Sigmoid function to drop unnecessary past details.\n" +
                "• **Input Gate:** Adds new candidate values into the cell state.\n" +
                "• **Output Gate:** Reads the updated cell state and outputs the hidden state for the next step.\n\n" +
                "**3. Why LSTMs Are Better than Standard RNNs:**\n" +
                "• Prevents vanishing gradients using additive cell state updates.\n" +
                "• Successfully handles sentences with 100+ words without losing the beginning context.\n\n" +
                "**4. Applications:**\n" +
                "• Speech recognition and virtual assistants\n" +
                "• Autocomplete and predictive text\n" +
                "• Financial time-series prediction");


        KNOWLEDGE.put("gru",
                "⚡ **Gated Recurrent Unit (GRU)**\n\n" +
                "**Concept:**\n" +
                "A streamlined variant of LSTM that merges the cell state and hidden state, using only two gates:\n" +
                "• **Reset Gate:** Controls how much past information to forget.\n" +
                "• **Update Gate:** Decides how much previous information to carry forward.\n\n" +
                "**Comparison:** Fewer parameters, trains faster, and achieves comparable accuracy to LSTM on smaller datasets.");

        KNOWLEDGE.put("autoencoders",
                "📦 **Autoencoders & VAEs**\n\n" +
                "**Concept:**\n" +
                "An unsupervised neural network trained to reconstruct its input through a low-dimensional bottleneck layer.\n\n" +
                "**Structure:** Encoder (compresses input $x \\to$ latent space $z$) $\\to$ Bottleneck $\\to$ Decoder (reconstructs $\\hat{x}$ from $z$).\n" +
                "**Variational Autoencoder (VAE):** Enforces a continuous probabilistic latent distribution (Gaussian $\\mu, \\sigma$), enabling generative sampling.");

        KNOWLEDGE.put("transfer_learning",
                "🔄 **Transfer Learning**\n\n" +
                "**Concept:**\n" +
                "Taking a model pre-trained on a massive dataset (e.g., ImageNet, web text) and adapting it to a smaller, specialized target dataset.\n\n" +
                "**Approaches:**\n" +
                "• **Feature Extraction:** Freeze base pre-trained weights and train only newly added classification head layers.\n" +
                "• **Fine-Tuning:** Unfreeze top layers (or all layers) with a small learning rate to adjust weights to target domain.");
    }

    private static void initDeepLearningComponents() {
        KNOWLEDGE.put("activation_function",
                "📈 **Activation Functions**\n\n" +
                "Activation functions introduce non-linearity into neural networks, enabling them to learn arbitrary, complex boundaries.\n\n" +
                "• **Sigmoid:** $\\sigma(x) = \\frac{1}{1 + e^{-x}}$. Range (0, 1). Ideal for binary output; prone to vanishing gradients.\n" +
                "• **Tanh:** $\\tanh(x) = \\frac{e^x - e^{-x}}{e^x + e^{-x}}$. Range (-1, 1). Zero-centered.\n" +
                "• **ReLU (Rectified Linear Unit):** $f(x) = \\max(0, x)$. Default for hidden layers; avoids vanishing gradient for positive values; prone to 'Dying ReLU'.\n" +
                "• **Leaky ReLU:** $f(x) = \\max(\\alpha x, x)$ (where $\\alpha \\approx 0.01$). Fixes dying ReLU by maintaining a small gradient for negative inputs.\n" +
                "• **Softmax:** Converts logits into a normalized probability distribution summing to 1 for multi-class classification.");

        KNOWLEDGE.put("forward_propagation",
                "⏩ **Forward Propagation & Backpropagation**\n\n" +
                "• **Forward Propagation:** Inputs $X$ pass sequentially through layers computing linear combinations $z = Wx + b$ and activations $a = f(z)$ to generate prediction $\\hat{y}$ and calculate loss $L$.\n" +
                "• **Backpropagation:** Computes partial derivatives of the loss with respect to all weights using the calculus chain rule ($\\frac{\\partial L}{\\partial W}$), propagating errors backward to update parameters.");

        KNOWLEDGE.put("loss_functions",
                "📉 **Loss Functions in Deep Learning**\n\n" +
                "• **Regression:**\n" +
                "  - *MSE (Mean Squared Error):* $\\frac{1}{n} \\sum (y - \\hat{y})^2$.\n" +
                "  - *MAE (Mean Absolute Error):* $\\frac{1}{n} \\sum |y - \\hat{y}|$.\n" +
                "  - *Huber Loss:* Combines MSE for small errors and MAE for large errors.\n" +
                "• **Classification:**\n" +
                "  - *Binary Cross-Entropy:* $-[y \\log \\hat{y} + (1-y) \\log(1-\\hat{y})]$.\n" +
                "  - *Categorical Cross-Entropy:* $-\\sum y_i \\log \\hat{y}_i$ for multi-class.\n" +
                "  - *Focal Loss:* Down-weights easy examples to focus on hard imbalanced samples.");

        KNOWLEDGE.put("optimizers",
                "⚙️ **Optimizers: SGD, Momentum, RMSprop, Adam**\n\n" +
                "• **SGD:** Updates weights via negative gradient: $w := w - \\alpha \\nabla L$.\n" +
                "• **Momentum:** Accelerates SGD in consistent directions, dampening oscillations.\n" +
                "• **RMSprop:** Adapts learning rates per parameter using moving average of squared gradients.\n" +
                "• **Adam (Adaptive Moment Estimation):** Combines Momentum (1st moment / mean) and RMSprop (2nd moment / variance). Standard default optimizer.\n" +
                "• **AdamW:** Corrects Adam's weight decay formulation; industry standard for Transformers.");

        KNOWLEDGE.put("training_hyperparameters",
                "⏱️ **Batch Size, Epoch, Learning Rate, Dropout & BatchNorm**\n\n" +
                "• **Batch Size:** Number of training examples processed before updating weights.\n" +
                "• **Epoch:** One complete forward and backward pass through the entire training dataset.\n" +
                "• **Learning Rate ($\\alpha$):** Step size taken toward the minimum of the loss function.\n" +
                "• **Dropout:** Regularization that randomly drops neurons (e.g., 20-50%) during training to prevent co-adaptation.\n" +
                "• **Batch Normalization (BatchNorm):** Normalizes activations across the mini-batch to zero mean and unit variance, stabilizing deep training.");

        KNOWLEDGE.put("vanishing_gradient",
                "📉 **The Vanishing Gradient Problem**\n\n" +
                "**Definition & Cause:**\n" +
                "During backpropagation in deep neural networks, gradients are computed via the calculus chain rule by multiplying derivatives backwards from layer to layer. When using saturating activation functions whose derivatives are less than 1 (like Sigmoid where $\\sigma'(x) \\le 0.25$ or Tanh where $\\tanh'(x) \\le 1$), multiplying these small fractions across many layers causes the vanishing gradient problem—gradients shrink exponentially toward zero, preventing early layers from updating their weights.\n\n" +
                "**Consequences:**\n" +
                "• Deep network layers fail to train or learn meaningful hierarchical features.\n" +
                "• Training speed drops to zero and convergence stalls.\n\n" +
                "**Solutions:**\n" +
                "1. **ReLU Activation:** Using non-saturating functions like ReLU ($f(x)=\\max(0,x)$) or Leaky ReLU where the gradient is 1 for positive values, preventing gradient decay.\n" +
                "2. **Residual Connections (ResNet):** Skip connections allow gradients to flow directly backwards without passing through multiple attenuating weight matrices.\n" +
                "3. **Weight Initialization:** He (Kaiming) or Xavier (Glorot) initialization preserves variance across layers.\n" +
                "4. **Batch Normalization:** Keeps intermediate activation scales stable, controlling gradient magnitude.\n" +
                "5. **Gated Architectures (LSTM / GRU):** Additive cell state propagation avoids exponential decay in recurrent networks.");
    }

    // =========================================================================
    // 4. NATURAL LANGUAGE PROCESSING (NLP)
    // =========================================================================
    private static void initNLP() {
        KNOWLEDGE.put("nlp",
                "💬 **Natural Language Processing (NLP)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "Natural Language Processing (NLP) is a branch of Artificial Intelligence (AI) that allows computers to understand, interpret, and generate human language (text and speech).\n\n" +
                "**Key Points:**\n" +
                "• **Goal:** It helps computers communicate with humans in natural language instead of computer code.\n" +
                "• **Two Main Parts:**\n" +
                "  1. **NLU (Natural Language Understanding):** Helps the machine understand the meaning and intent of words.\n" +
                "  2. **NLG (Natural Language Generation):** Helps the machine generate human-like sentences and replies.\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• **Chatbots & Virtual Assistants:** Siri, Google Assistant, and customer service bots.\n" +
                "• **Machine Translation:** Google Translate converting English to other languages.\n" +
                "• **Auto-correct & Predictive Text:** Smartphone keyboards suggesting the next word.");

        KNOWLEDGE.put("nlp_explain",
                "💬 **Explanation: Natural Language Processing (NLP)**\n\n" +
                "**1. What is NLP?**\n" +
                "Natural Language Processing (NLP) is a subfield of Artificial Intelligence that enables computers to read, understand, and produce everyday human languages such as English.\n\n" +
                "**2. The Two Core Components:**\n" +
                "• **NLU (Natural Language Understanding):** Reading text or listening to speech to understand intent, sentiment, and context.\n" +
                "• **NLG (Natural Language Generation):** Producing coherent, grammatically correct responses in human language.\n\n" +
                "**3. Standard NLP Processing Steps:**\n" +
                "• **Step 1 - Tokenization:** Splitting sentences into individual words or tokens.\n" +
                "• **Step 2 - Stop Word Removal:** Filtering out common words like 'is', 'the', and 'at'.\n" +
                "• **Step 3 - Stemming / Lemmatization:** Reducing words to their base root (e.g., 'playing' $\\to$ 'play').\n" +
                "• **Step 4 - Feature Extraction:** Converting words into numbers using TF-IDF or Word Embeddings.\n" +
                "• **Step 5 - Model Prediction:** Performing classification, sentiment analysis, or translation.\n\n" +
                "**4. Important Applications:**\n" +
                "• Search engines (Google Search)\n" +
                "• Spam detection in email\n" +
                "• Language translation (Google Translate)\n" +
                "• Voice assistants and modern LLMs (like ChatGPT and Gemini)");

        KNOWLEDGE.put("text_preprocessing",
                "🧹 **Text Preprocessing in NLP**\n\n" +
                "Crucial step preparing raw text for machine learning models:\n" +
                "1. **Lowercasing:** Normalizing case sensitivity ('Machine' $\\to$ 'machine').\n" +
                "2. **Punctuation & Special Character Removal:** Stripping HTML tags, URLs, and non-alphanumeric noise.\n" +
                "3. **Tokenization:** Breaking text into words or sentences.\n" +
                "4. **Stop Word Removal:** Filtering frequent grammatical words ('is', 'the', 'at').\n" +
                "5. **Stemming & Lemmatization:** Reducing inflected words to base forms.");

        KNOWLEDGE.put("tokenization",
                "🔤 **Tokenization: Word, Sentence & Subword**\n\n" +
                "• **Word Tokenization:** Splitting text into individual words based on whitespace and delimiters.\n" +
                "• **Sentence Tokenization:** Splitting text into grammatical sentences.\n" +
                "• **Subword Tokenization (Modern Standard):** Decomposes words into frequent subword units, effortlessly handling Out-Of-Vocabulary (OOV) words:\n" +
                "  - *Byte-Pair Encoding (BPE):* Merges frequent character pairs (GPT-2/3/4, LLaMA).\n" +
                "  - *WordPiece:* Likelihood-based subword merging (BERT).\n" +
                "  - *SentencePiece:* Language-independent subword tokenizer (T5, Mistral).");

        KNOWLEDGE.put("stemming",
                "✂️ **Stemming & Lemmatization**\n\n" +
                "• **Stemming:** Crude heuristic rule-based suffix removal without vocabulary awareness (e.g., 'running' $\\to$ 'run', 'studies' $\\to$ 'studi'). Algorithm: Porter Stemmer.\n" +
                "• **Lemmatization:** Linguistic morphological analysis using dictionary lookups (WordNet) returning valid dictionary base words (lemmas) (e.g., 'better' $\\to$ 'good', 'caring' $\\to$ 'care').");

        KNOWLEDGE.put("bag_of_words",
                "👜 **Bag of Words & TF-IDF**\n\n" +
                "• **Bag of Words (BoW):** Represents documents as word occurrence counts, ignoring grammar, syntax, and word order.\n" +
                "• **TF-IDF:** Weights terms by importance: $\\text{TF-IDF} = \\text{TF}(t, d) \\times \\text{IDF}(t, D)$.\n" +
                "  - *TF (Term Frequency):* Frequency of word in document.\n" +
                "  - *IDF (Inverse Document Frequency):* $\\log(N / df_t)$. Penalizes ubiquitous stop words while boosting informative keywords.");

        KNOWLEDGE.put("ngrams",
                "🔗 **N-Grams in NLP**\n\n" +
                "**Concept:**\n" +
                "Contiguous sequences of $n$ items (words or characters) extracted from text.\n\n" +
                "• **Unigram (n=1):** ['machine', 'learning']\n" +
                "• **Bigram (n=2):** ['machine learning', 'learning algorithm']\n" +
                "• **Trigram (n=3):** ['machine learning algorithm']\n\n" +
                "**Advantage:** Captures local word ordering and context that Bag of Words misses (e.g., 'not good' vs 'good').");

        KNOWLEDGE.put("word_embeddings",
                "🌐 **Word Embeddings: Word2Vec, GloVe & FastText**\n\n" +
                "**Concept:** Dense real-valued vector representations mapping words with semantic similarity to proximate points in continuous vector space.\n\n" +
                "• **Word2Vec (Mikolov et al., 2013):**\n" +
                "  - *CBOW:* Predicts target word from surrounding context.\n" +
                "  - *Skip-gram:* Predicts surrounding context words given target word.\n" +
                "• **GloVe:** Factorizes global word-word co-occurrence matrix.\n" +
                "• **FastText:** Represents words as bags of character n-grams, effortlessly handling typos and unseen OOV words.");
    }

    private static void initNlpAdvanced() {
        KNOWLEDGE.put("sentiment_analysis",
                "🎭 **Sentiment Analysis & Text Classification**\n\n" +
                "• **Sentiment Analysis:** Classifying text by emotional tone (Positive, Negative, Neutral) and aspect-based sentiment.\n" +
                "• **Text Classification:** Assigning categories to text documents (e.g., spam detection, news topic labeling, customer support ticket routing).");

        KNOWLEDGE.put("ner",
                "🏷️ **Named Entity Recognition (NER) & POS Tagging**\n\n" +
                "• **Named Entity Recognition (NER):** Locating and classifying entities in text into predefined categories (Persons, Organizations, Locations, Dates, Moneys).\n" +
                "• **Part-of-Speech (POS) Tagging:** Assigning grammatical markers (Noun, Verb, Adjective, Adverb) to each token.");

        KNOWLEDGE.put("nlp_applications_extended",
                "🌐 **Core NLP Application Tasks**\n\n" +
                "• **Language Detection:** Classifying natural language of input text using n-gram frequency models.\n" +
                "• **Text Summarization:** Extractive (selecting key sentences) vs Abstractive (generating new summary sentences using LLMs/Transformers).\n" +
                "• **Machine Translation:** Translating text between natural languages using Seq2Seq attention models.\n" +
                "• **Question Answering:** Extracting answers from reference documents (SQuAD) or generating grounded answers via RAG.\n" +
                "• **Speech Recognition (ASR):** Transcribing spoken audio signals into text (Whisper, Wav2Vec).");
    }

    // =========================================================================
    // 5. TRANSFORMERS & LLMS
    // =========================================================================
    private static void initTransformers() {
        KNOWLEDGE.put("transformers",
                "🚀 **The Transformer Architecture**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "A Transformer is a modern deep learning architecture that processes sequential data in parallel using a mechanism called Self-Attention instead of recurrent loops.\n\n" +
                "**Key Points:**\n" +
                "• **Introduced By:** Vaswani et al. (Google Brain, 2017) in 'Attention Is All You Need'.\n" +
                "• **Self-Attention:** Allows the model to look at all words in a sentence at once and weigh how strongly words connect to each other.\n" +
                "• **Parallel Processing:** Processes entire sentences simultaneously on GPUs, training much faster than RNNs.\n\n" +
                "**What It Powers:**\n" +
                "• Modern Large Language Models like ChatGPT, Google Gemini, and Claude.\n" +
                "• BERT for search engines, modern translation, and code generation.");

        KNOWLEDGE.put("transformers_explain",
                "🚀 **Explanation: Transformer Architecture**\n\n" +
                "**1. What is a Transformer?**\n" +
                "A Transformer is a neural network architecture that changed AI and Natural Language Processing. Before Transformers, models read text word-by-word sequentially. Transformers read entire passages at once in parallel.\n\n" +
                "**2. Core Building Blocks:**\n" +
                "• **Self-Attention Mechanism:** Computes attention scores between every word and all other words using Query (Q), Key (K), and Value (V) matrices.\n" +
                "• **Multi-Head Attention:** Runs multiple attention calculations at the same time to capture different nuances (syntax, grammar, tone).\n" +
                "• **Positional Encoding:** Adds position numbers to word embeddings so the model knows the exact order of words.\n" +
                "• **Feed-Forward Layers:** Processes attended representations through non-linear layers.\n\n" +
                "**3. Why Transformers Replaced RNNs:**\n" +
                "• No vanishing gradient problems across long distances.\n" +
                "• Massively parallel training on modern GPUs and TPUs.\n" +
                "• Scales effectively to hundreds of billions of parameters.\n\n" +
                "**4. Foundation for Modern AI:**\n" +
                "• **Encoder-only (BERT):** Ideal for text classification and search.\n" +
                "• **Decoder-only (GPT-4, Gemini):** Ideal for text and code generation.\n" +
                "• **Encoder-Decoder (T5):** Ideal for translation and summarization.");


        KNOWLEDGE.put("transformer_components",
                "🧩 **Query, Key, Value & Transformer Components**\n\n" +
                "💡 **Think of it like a library search:**\n" +
                "• **Query (Q):** What the current token is searching for (your search term).\n" +
                "• **Key (K):** What other tokens offer as identities (the book titles and tags).\n" +
                "• **Value (V):** The actual informational content of the token (the book pages).\n\n" +
                "• **Scaled Dot-Product:** Dividing by $\\sqrt{d_k}$ prevents vanishing gradients in the softmax.\n" +
                "• **Encoder:** Processes input sequence bidirectionally to create contextual representations.\n" +
                "• **Decoder:** Generates output sequence autoregressively using causal masked self-attention.");

        KNOWLEDGE.put("bert",
                "📘 **BERT (Encoder-Only Transformer)**\n\n" +
                "**Developed by:** Google (2018).\n\n" +
                "**Architecture:** Encoder-only Transformer that reads text bidirectionally.\n\n" +
                "**Pre-Training Tasks:**\n" +
                "1. **Masked Language Modeling (MLM):** 15% of tokens are masked; model predicts original word from surrounding context.\n" +
                "2. **Next Sentence Prediction (NSP):** Predicts if Sentence B logically follows Sentence A.\n\n" +
                "**Ideal For:** Text classification, NER, search ranking, semantic similarity.");

        KNOWLEDGE.put("gpt",
                "📗 **GPT (Decoder-Only Transformer)**\n\n" +
                "**Developed by:** OpenAI (2018-present).\n\n" +
                "**Architecture:** Autoregressive decoder-only Transformer with causal masking (tokens attend only to previous tokens).\n\n" +
                "**Pre-Training Task:** Next-Token Prediction on massive internet text corpora.\n\n" +
                "**Ideal For:** Generative text, creative writing, code generation, multi-turn chat, instruction following.");

        KNOWLEDGE.put("t5",
                "📕 **T5 (Encoder-Decoder Transformer)**\n\n" +
                "**Developed by:** Google (Raffel et al., 2020) 'Text-to-Text Transfer Transformer'.\n\n" +
                "**Framework:** Unifies all NLP tasks into a single text-in $\\to$ text-out format (e.g., 'translate English to German: ...', 'summarize: ...').\n\n" +
                "**Ideal For:** Machine translation, text summarization, and question answering.");
    }

    // =========================================================================
    // 6. COMPUTER VISION
    // =========================================================================
    private static void initComputerVision() {
        KNOWLEDGE.put("computer_vision",
                "👁️ **Computer Vision (CV)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "Computer Vision is a branch of Artificial Intelligence that enables computers to capture, process, and understand visual data from digital images and videos.\n\n" +
                "**Key Points:**\n" +
                "• **Digital Representation:** Images are stored as numbers called pixels (values from 0 to 255) in RGB (Red, Green, Blue) channels.\n" +
                "• **Core Technology:** Convolutional Neural Networks (CNNs) are used to extract visual patterns automatically.\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• Face Unlock on smartphones\n" +
                "• Self-driving cars detecting pedestrians and traffic signs\n" +
                "• Medical AI detecting diseases from X-rays and MRI scans");

        KNOWLEDGE.put("computer_vision_explain",
                "👁️ **Explanation: Computer Vision (CV)**\n\n" +
                "**1. What is Computer Vision?**\n" +
                "Computer Vision is a field of Artificial Intelligence where computers are trained to capture, interpret, and understand visual data such as images and live video streams.\n\n" +
                "**2. How It Works:**\n" +
                "• **Step 1 - Image Input:** A camera or sensor captures an image as a matrix of numbers (pixels).\n" +
                "• **Step 2 - Preprocessing:** The image is cleaned, resized, or converted to grayscale.\n" +
                "• **Step 3 - Feature Extraction:** Deep learning models (like CNNs) detect edges, shapes, and textures.\n" +
                "• **Step 4 - Output Decision:** The model identifies objects or classifies the scene.\n\n" +
                "**3. Core Computer Vision Tasks:**\n" +
                "• **Image Classification:** Identifying what is in an image (e.g., 'Cat' vs. 'Dog').\n" +
                "• **Object Detection:** Finding objects and drawing bounding boxes around them (e.g., YOLO).\n" +
                "• **Image Segmentation:** Labeling every individual pixel (e.g., separating roads from sidewalks).\n" +
                "• **OCR (Optical Character Recognition):** Reading text printed inside photos.\n\n" +
                "**4. Everyday Applications:**\n" +
                "• Smartphone cameras and Face ID\n" +
                "• Autonomous driving (Tesla Autopilot)\n" +
                "• Hospital imaging and cancer screening\n" +
                "• QR code and barcode scanners");

        KNOWLEDGE.put("image_processing",
                "🖼️ **Image Processing & Image Augmentation**\n\n" +
                "• **Image Preprocessing:** Resizing, grayscale conversion, Gaussian blurring, histogram equalization, thresholding.\n" +
                "• **Image Augmentation:** Generating synthetic training variations (random rotation, horizontal flip, zooming, cropping, color jitter, CutMix) to prevent overfitting.");

        KNOWLEDGE.put("object_detection",
                "🎯 **Object Detection & Localization**\n\n" +
                "**Concept:** Identifies *what* objects are present and *where* they are located by drawing bounding boxes $[x, y, w, h]$ with class probabilities.\n\n" +
                "• **Two-Stage Detectors (High Accuracy):** R-CNN, Fast R-CNN, Faster R-CNN (Region Proposal $\\to$ Classification).\n" +
                "• **One-Stage Detectors (Real-Time Speed):** YOLO (You Only Look Once), SSD, RetinaNet.\n\n" +
                "**Metrics:** IoU (Intersection over Union) and mAP (mean Average Precision).");

        KNOWLEDGE.put("yolo",
                "⚡ **YOLO (You Only Look Once)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Traditional object detectors had to scan different corners of an image thousands of times, which was slow. YOLO looks at the entire image just ONCE! In a single split-second glance, it instantly draws bounding boxes around all people, cars, and objects in real time!\n\n" +
                "**Architecture:**\n" +
                "Reframes object detection from a multi-stage pipeline into a single regression problem. The image is split into an $S \\times S$ grid; each grid cell predicts bounding boxes and class probabilities in a single forward pass.\n\n" +
                "**Advantage:** Ultra-fast real-time inference (45-150+ FPS) enabling deployment on edge devices, drones, and autonomous vehicles.");

        KNOWLEDGE.put("image_segmentation",
                "✂️ **Image Segmentation: Semantic & Instance**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Instead of just drawing a rectangular box around an object, image segmentation colors in every individual pixel of the object with extreme pinpoint precision!\n\n" +
                "• **Semantic Segmentation:** Classifies every pixel into a categorical class label without separating individual objects (e.g., all cars share one single blue mask). Popular model: **U-Net**.\n" +
                "• **Instance Segmentation:** Detects and delineates each individual instance of an object with separate pixel masks (e.g., Car 1 is blue, Car 2 is red). Popular model: **Mask R-CNN**.\n\n" +
                "**Applications:** Self-driving cars distinguishing roads from sidewalks, and medical AI highlighting tumors in MRI scans.");

        KNOWLEDGE.put("opencv_and_faces",
                "👤 **OpenCV, Face Recognition & OCR**\n\n" +
                "• **OpenCV:** Open source library for image transformations, filtering, camera capture, and feature detection (`cv2.imread`, `cv2.Canny`).\n" +
                "• **Face Detection & Recognition:** Detecting facial landmarks (MTCNN) and generating vector embeddings (FaceNet) for identity matching.\n" +
                "• **OCR (Optical Character Recognition):** Converting printed or handwritten document images into machine-encoded editable text (Tesseract, EasyOCR).");
    }

    // =========================================================================
    // 7. GENERATIVE AI & ADVANCED LLMS
    // =========================================================================
    private static void initGenerativeAI() {
        KNOWLEDGE.put("generative_ai",
                "✨ **Generative AI (GenAI)**\n\n" +
                "**Definition (2-Mark Exam Answer):**\n" +
                "Generative AI is a branch of Artificial Intelligence that can create new and original content—such as text, images, music, audio, and code—based on user prompts.\n\n" +
                "**Key Points:**\n" +
                "• **How it works:** It learns patterns and language structures from massive training data and predicts what should come next.\n" +
                "• **Generative vs. Discriminative:** Discriminative AI classifies existing data (e.g., 'Is this spam?'), while Generative AI creates new data (e.g., 'Write an essay').\n\n" +
                "**Simple Real-World Examples:**\n" +
                "• **ChatGPT & Gemini:** Generating essays, emails, and answers to questions.\n" +
                "• **Midjourney & DALL-E:** Generating realistic images from text prompts.\n" +
                "• **GitHub Copilot:** Writing computer programming code automatically.");

        KNOWLEDGE.put("generative_ai_explain",
                "✨ **Explanation: Generative AI (GenAI)**\n\n" +
                "**1. What is Generative AI?**\n" +
                "Generative AI refers to artificial intelligence models that create brand-new content such as text, images, audio, and computer code rather than just analyzing existing data.\n\n" +
                "**2. How Does It Work?**\n" +
                "• It trains on massive amounts of books, articles, code, or images.\n" +
                "• It learns the statistical rules and structures of human communication.\n" +
                "• When a user provides a prompt, the model generates output step-by-step by predicting the most probable next word or pixel.\n\n" +
                "**3. Core Types of Generative Models:**\n" +
                "• **Large Language Models (LLMs):** Generate coherent text, answer questions, and write code (e.g., GPT-4, Gemini).\n" +
                "• **Diffusion Models:** Create photorealistic images from text prompts (e.g., Stable Diffusion, Midjourney).\n" +
                "• **Generative Adversarial Networks (GANs):** Generate synthetic faces and images through competing generator and discriminator networks.\n\n" +
                "**4. Key Benefits:**\n" +
                "• Speeds up writing, design, and software development.\n" +
                "• Assists students and professionals with research and problem solving.\n" +
                "• Automates repetitive creative tasks.");

        KNOWLEDGE.put("llm",
                "📖 **Large Language Models (LLMs) & Foundation Models**\n\n" +
                "💡 **In Simple Words:**\n" +
                "An LLM is like a super-encyclopedia that has read billions of books, articles, and websites! By studying all that human writing, it learns how words and concepts connect so well that it can hold natural conversations, answer questions, write stories, explain code, and solve logic puzzles.\n\n" +
                "• **LLMs:** Multi-billion parameter neural networks trained on vast web corpora using Transformer architectures.\n" +
                "• **Foundation Models:** Adaptable broad base models (GPT-4, Gemini, Claude, LLaMA) that serve as common platforms for diverse downstream applications.\n" +
                "• **Multimodal AI:** Foundation models natively accepting and generating multiple modalities (text, vision, audio, code) simultaneously.");

        KNOWLEDGE.put("prompt_engineering",
                "✍️ **Prompt Engineering: Zero-Shot, Few-Shot & CoT**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Prompt Engineering is the skill of asking questions and giving instructions to an AI in the clearest way possible so you get the best, most accurate answer on the very first try!\n\n" +
                "• **Zero-Shot Prompting:** Querying the model without providing any examples.\n" +
                "• **Few-Shot Prompting:** Providing 2-5 input-output demonstration pairs in context to establish the pattern.\n" +
                "• **Chain-of-Thought (CoT):** Directing the model to 'think step by step', breaking complex logic into intermediate reasoning steps.\n" +
                "• **ReAct (Reason + Act):** Interleaving reasoning traces and external API action calls.");

        KNOWLEDGE.put("rag",
                "📚 **RAG (Retrieval-Augmented Generation)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Think of standard LLMs like taking a closed-book exam relying only on memory (which can lead to making things up or hallucinating). RAG is like giving the AI an open book! Before answering your question, the AI searches a private database or document library, finds the exact relevant facts, and uses them to write an accurate, grounded answer.\n\n" +
                "**Workflow in 3 Steps:**\n" +
                "1. **Retrieval:** User query is searched via Cosine Similarity in a Vector Database (Pinecone, ChromaDB, Milvus) to pull relevant document chunks.\n" +
                "2. **Augmentation:** The retrieved verified passages are injected into the prompt context.\n" +
                "3. **Generation:** The LLM synthesizes the answer grounded strictly on the retrieved source material without hallucination.");

        KNOWLEDGE.put("fine_tuning",
                "🔧 **Fine-Tuning, PEFT & RLHF**\n\n" +
                "• **Fine-Tuning (SFT):** Training base models on specialized instruction-response datasets.\n" +
                "• **PEFT (LoRA & QLoRA):** Parameter-Efficient Fine-Tuning; keeps base model weights frozen and trains small low-rank decomposition matrices ($<1\\%$ parameters).\n" +
                "• **RLHF / DPO:** Aligning models with human values using preference pairs and reward models.");

        KNOWLEDGE.put("lora",
                "LoRA (Low-Rank Adaptation) is a parameter-efficient fine-tuning technique that freezes pre-trained model weights and injects trainable low-rank decomposition matrices into Transformer layers.\n\n" +
                "Example: Fine-tuning a 70-billion parameter language model on a single GPU instead of a massive multi-server cluster.");

        KNOWLEDGE.put("genai_parameters",
                "🎚️ **Tokens, Context Window & Generation Parameters**\n\n" +
                "• **Tokens:** Basic units of text processed by LLMs (~1 token $\\approx$ 0.75 words).\n" +
                "• **Context Window:** Maximum token capacity an LLM can process in one session.\n" +
                "• **Temperature:** Controls output randomness (0.0 = deterministic; 0.8+ = creative).\n" +
                "• **Top-P (Nucleus Sampling):** Samples from smallest subset of tokens whose cumulative probability $\\ge P$.\n" +
                "• **Hallucination:** When an LLM produces factually incorrect assertions with high confidence.");

        KNOWLEDGE.put("gan",
                "🎭 **Generative Adversarial Networks (GANs)**\n\n" +
                "**Introduced By:** Ian Goodfellow et al. (2014).\n\n" +
                "**Concept & Minimax Game:**\n" +
                "A GAN consists of two neural networks competing against each other in a zero-sum game:\n" +
                "1. **Generator ($G$):** Takes random noise $z$ as input and attempts to generate realistic synthetic data instances: $G(z)$. Its goal is to fool the discriminator.\n" +
                "2. **Discriminator ($D$):** Acts as an evaluator/critic, taking real data $x$ and generated data $G(z)$ and determining whether each instance is authentic or fabricated ($D(x) \\in [0, 1]$).\n\n" +
                "**Minimax Objective:**\n" +
                "$\\min_G \\max_D V(D, G) = \\mathbb{E}_{x \\sim p_{data}}[\\log D(x)] + \\mathbb{E}_{z \\sim p_z}[\\log(1 - D(G(z)))]$\n\n" +
                "**Applications:** Photorealistic image generation, deepfakes, style transfer (CycleGAN), super-resolution, and synthetic data augmentation.");
    }

    // =========================================================================
    // 8. DATA SCIENCE & PYTHON CONCEPTS
    // =========================================================================
    private static void initPythonDataScience() {
        KNOWLEDGE.put("data_science_lifecycle",
                "📊 **Data Science Pipeline & Data Cleaning**\n\n" +
                "1. **Data Collection:** Sourcing data from APIs, databases, web scraping, and CSV/Parquet files.\n" +
                "2. **Data Cleaning:** Handling missing values, removing duplicates, and detecting outliers.\n" +
                "3. **Exploratory Data Analysis (EDA):** Computing summary statistics, inspecting distributions, and analyzing correlations.\n" +
                "4. **Feature Engineering:** Creating domain features, encoding categories, and scaling.\n" +
                "5. **Modeling & Deployment:** Training, cross-validation, hyperparameter tuning, and containerized deployment.");

        KNOWLEDGE.put("missing_values_and_outliers",
                "🧹 **Handling Missing Values & Outliers**\n\n" +
                "• **Missing Values:**\n" +
                "  - Deletion: Dropping rows/columns (`df.dropna()`) when missingness is $<5\\%$.\n" +
                "  - Imputation: Mean/median for numerical data, mode for categorical data, or KNN Imputer.\n" +
                "• **Outlier Detection:**\n" +
                "  - *IQR Method:* Outliers fall beyond $[Q_1 - 1.5 \\times IQR, Q_3 + 1.5 \\times IQR]$.\n" +
                "  - *Z-Score Method:* Values with $|z| > 3$ standard deviations from mean.");

        KNOWLEDGE.put("numpy",
                "🔢 **NumPy (Numerical Python)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Standard Python lists are great, but they become sluggish when doing math on millions of numbers. NumPy introduces supercharged arrays (`ndarray`) that run at blazing C-language speeds—making it the mathematical engine behind almost every AI and Data Science library in Python!\n\n" +
                "• **Vectorization:** Replaces slow Python `for` loops with optimized C-speed array math.\n" +
                "• **Broadcasting:** Automatic dimension expansion enabling arithmetic between different array shapes.\n" +
                "• **Linear Algebra:** Matrix multiplication (`@`, `np.dot`), inversions, and numerical arrays.");

        KNOWLEDGE.put("pandas",
                "🐼 **Pandas (Data Manipulation & Analysis)**\n\n" +
                "💡 **In Simple Words:**\n" +
                "Think of Pandas like 'Excel spreadsheets on steroids inside Python'! It is the ultimate tool for loading, exploring, filtering, cleaning, and transforming tabular datasets.\n\n" +
                "**Core Data Structures:**\n" +
                "• **Series (1D):** A single labeled column (like a single column in Excel).\n" +
                "• **DataFrame (2D):** A full two-dimensional table of rows and columns.\n\n" +
                "• **Loading:** `pd.read_csv()`, `pd.read_sql()`.\n" +
                "• **Indexing:** `.loc[]` (label-based) and `.iloc[]` (integer-based).\n" +
                "• **Cleaning:** `df.dropna()`, `df.fillna()`, `df.drop_duplicates()`.\n" +
                "• **Aggregation:** `df.groupby('col').agg()`, `pd.merge()`, `pd.concat()`.");

        KNOWLEDGE.put("data_visualization",
                "📈 **Matplotlib & Seaborn (Data Visualization)**\n\n" +
                "• **Matplotlib:** Core low-level plotting library providing full control over line plots, bar charts, scatter plots, and subplots (`plt.plot()`, `plt.scatter()`).\n" +
                "• **Seaborn:** High-level statistical visualization library built on Matplotlib providing beautiful heatmaps (`sns.heatmap()`), pairplots, violin plots, and distribution plots.");

        KNOWLEDGE.put("scikit_learn",
                "⚙️ **Scikit-Learn & Pipelines**\n\n" +
                "The standard Python machine learning library with a consistent unified Object-Oriented API.\n\n" +
                "• **Estimator API:** `.fit(X, y)`, `.predict(X)`, `.transform(X)`.\n" +
                "• **Pipelines (`Pipeline`):** Chains preprocessing (scaling, imputation) and model estimation into a single atomic object, preventing data leakage during cross-validation.");

        KNOWLEDGE.put("tensorflow_and_pytorch",
                "🔥 **PyTorch vs. TensorFlow**\n\n" +
                "• **PyTorch (Meta):** Dynamic computational graphs (define-by-run), highly Pythonic, overwhelmingly preferred in AI research and modern LLM development.\n" +
                "• **TensorFlow & Keras (Google):** Static/dynamic computation, enterprise production deployment (TF Serving, TFLite for mobile/embedded), TensorBoard visualization.");
    }

    // =========================================================================
    // 9. ADVANCED AI/ML & MLOPS
    // =========================================================================
    private static void initAdvancedAiMl() {
        KNOWLEDGE.put("mdp",
                "🎲 **Markov Decision Process (MDP)**\n\n" +
                "The mathematical framework modeling sequential decision-making under uncertainty in Reinforcement Learning.\n\n" +
                "**Tuple (S, A, P, R, γ):**\n" +
                "• **S (States):** Set of all valid environment situations.\n" +
                "• **A (Actions):** Set of actions available to the agent.\n" +
                "• **P (Transition Probability):** $P(s' | s, a)$ probability of reaching state $s'$ from $s$ via action $a$.\n" +
                "• **R (Reward Function):** $R(s, a, s')$ immediate numerical reward.\n" +
                "• **γ (Discount Factor):** $\\gamma \\in [0, 1)$ discounting future rewards.\n" +
                "• **Markov Property:** Future depends only on the present state, not on past history.");

        KNOWLEDGE.put("q_learning",
                "🕹️ **Q-Learning & Deep Q-Networks (DQN)**\n\n" +
                "• **Q-Learning:** A model-free off-policy algorithm learning the quality of state-action pairs:\n" +
                "  $Q(s, a) \\leftarrow Q(s, a) + \\alpha [r + \\gamma \\max_{a'} Q(s', a') - Q(s, a)]$.\n" +
                "• **Deep Q-Networks (DQN):** DeepMind's breakthrough replacing the Q-table with a deep neural network, stabilizing training with **Experience Replay** and **Target Networks** to master Atari games.");

        KNOWLEDGE.put("recommendation_systems",
                "🛍️ **Recommendation Systems**\n\n" +
                "Algorithms suggesting relevant items to users (movies, songs, products).\n\n" +
                "• **Collaborative Filtering:** Recommends based on past user behavior and similar user ratings (User-User, Item-Item, Matrix Factorization / SVD).\n" +
                "• **Content-Based Filtering:** Recommends items with attributes similar to items the user liked in the past.\n" +
                "• **Hybrid Systems:** Combines collaborative and content-based approaches (Netflix, Spotify).");

        KNOWLEDGE.put("time_series_forecasting",
                "⏱️ **Time Series Analysis & Forecasting**\n\n" +
                "Analyzing and modeling sequential data points collected over discrete time intervals.\n\n" +
                "• **Components:** Trend, Seasonality, Cyclical patterns, and Residual noise.\n" +
                "• **Stationarity:** Constant mean, variance, and autocorrelation over time; verified via Augmented Dickey-Fuller (ADF) test.\n" +
                "• **Models:** ARIMA (AutoRegressive Integrated Moving Average), SARIMA (Seasonal), Prophet, and LSTMs.");

        KNOWLEDGE.put("mlops",
                "🚀 **MLOps: Model Deployment, Monitoring & Drift**\n\n" +
                "**Definition:**\n" +
                "Machine Learning Operations (MLOps) unifies ML development and operations to automate testing, CI/CD, deployment, and monitoring in production.\n\n" +
                "• **Deployment:** Packaging models into Docker containers, serving via REST endpoints (FastAPI).\n" +
                "• **Data Drift (Covariate Shift):** Distribution of input features $P(X)$ changes over time.\n" +
                "• **Concept Drift:** Relationship between features and target $P(Y|X)$ changes over time.\n" +
                "• **Monitoring:** Tracking latency, error rates, feature distributions, and triggering automated retraining pipelines.");
    }

    private static void initComparisons() {
        KNOWLEDGE.put("ai_vs_ml",
                "⚖️ **Comparison: Artificial Intelligence (AI) vs. Machine Learning (ML)**\n\n" +
                "• **Scope:**\n" +
                "  - **AI** is the overarching umbrella field focused on creating systems capable of simulating human intelligence.\n" +
                "  - **ML** is a specific technical subset of AI that drives learning through data rather than hand-coded rules.\n\n" +
                "• **Mechanism:**\n" +
                "  - **AI** encompasses rule engines, expert systems, search algorithms, and evolutionary algorithms.\n" +
                "  - **ML** relies on statistical modeling, loss functions, and iterative optimization.\n\n" +
                "• **Relationship:**\n" +
                "  All Machine Learning is AI, but not all AI is Machine Learning.");

        KNOWLEDGE.put("ml_vs_dl",
                "⚖️ **Comparison: Machine Learning (ML) vs. Deep Learning (DL)**\n\n" +
                "| Criterion | Traditional Machine Learning | Deep Learning |\n" +
                "| :--- | :--- | :--- |\n" +
                "| **Feature Engineering** | Requires manual hand-crafted feature engineering | Learns hierarchical features automatically from raw data |\n" +
                "| **Data Requirements** | Performs well on small-to-medium tabular datasets | Requires massive datasets (millions of images/tokens) |\n" +
                "| **Hardware Needs** | Runs efficiently on standard CPUs | Requires dedicated hardware accelerators (GPUs, TPUs) |\n" +
                "| **Interpretability** | Moderate to High (decision trees, linear coefficients) | Low (black-box multi-layer neural networks) |\n" +
                "| **Performance Scaling** | Accuracy plateaus as data volume increases | Accuracy continues improving with more data and compute |");

        KNOWLEDGE.put("supervised_vs_unsupervised",
                "⚖️ **Comparison: Supervised vs. Unsupervised Learning**\n\n" +
                "| Dimension | Supervised Learning | Unsupervised Learning |\n" +
                "| :--- | :--- | :--- |\n" +
                "| **Training Data** | Labeled data with known target ground truth | Unlabeled data without target labels |\n" +
                "| **Objective** | Predict target output for unseen input feature vectors | Discover hidden patterns, clusters, or structures |\n" +
                "| **Core Tasks** | Classification and Regression | Clustering, Dimensionality Reduction, Association |\n" +
                "| **Key Algorithms** | Random Forest, SVM, Linear/Logistic Regression, XGBoost | K-Means, DBSCAN, PCA, Autoencoders, Apriori |\n" +
                "| **Human Effort** | High (expensive manual labeling) | Minimal (learns directly from raw data distributions) |");

        KNOWLEDGE.put("classification_vs_regression",
                "⚖️ **Comparison: Classification vs. Regression**\n\n" +
                "| Criterion | Classification | Regression |\n" +
                "| :--- | :--- | :--- |\n" +
                "| **Target Variable** | Discrete categorical classes (e.g., Cat, Dog, Bird) | Continuous numerical values (e.g., $350,000) |\n" +
                "| **Output** | Class probabilities / discrete labels | Real-valued numbers |\n" +
                "| **Evaluation Metrics** | Accuracy, Precision, Recall, F1-Score, ROC-AUC | Mean Squared Error (MSE), RMSE, MAE, R² |\n" +
                "| **Common Algorithms** | Logistic Regression, Decision Trees, SVM, Naive Bayes | Linear Regression, Ridge, Lasso, Gradient Boosting |");

        KNOWLEDGE.put("overfitting_vs_underfitting",
                "⚖️ **Overfitting vs. Underfitting (The Bias-Variance Tradeoff)**\n\n" +
                "• **Underfitting (High Bias):**\n" +
                "  - Model is too simple to capture underlying data patterns (high error on both train and test sets).\n" +
                "  - Fix: Increase model capacity, add non-linear features, reduce regularization.\n\n" +
                "• **Overfitting (High Variance):**\n" +
                "  - Model memorizes training noise and specifics rather than generalizing (near-zero train error, high test error).\n" +
                "  - Fix: Add more training data, apply L1/L2 regularization, implement Dropout, prune trees, or use early stopping.");

        KNOWLEDGE.put("bagging_vs_boosting",
                "⚖️ **Comparison: Bagging vs. Boosting**\n\n" +
                "• **Training Paradigm:**\n" +
                "  - **Bagging (Bootstrap Aggregation):** Trains multiple diverse estimators **in parallel** on random data subsets with replacement (e.g., Random Forest).\n" +
                "  - **Boosting:** Trains models **sequentially**, where each subsequent model focuses on correcting the errors/residuals of predecessors (e.g., XGBoost, AdaBoost).\n\n" +
                "• **Primary Error Targeted:**\n" +
                "  - **Bagging** reduces **variance** (combats overfitting).\n" +
                "  - **Boosting** reduces **bias** (improves underfitting models into strong predictors).");

        KNOWLEDGE.put("precision_vs_recall",
                "⚖️ **Comparison: Precision vs. Recall**\n\n" +
                "• **Precision = TP / (TP + FP):** Prioritize when False Positives are costly (spam filtering, stock buying signals).\n" +
                "• **Recall = TP / (TP + FN):** Prioritize when False Negatives are dangerous (cancer diagnosis, fraud detection).\n" +
                "• **Tradeoff:** Balanced by the harmonic mean **F1-Score**.");

        KNOWLEDGE.put("bert_vs_gpt",
                "⚖️ **Comparison: BERT vs. GPT**\n\n" +
                "| Dimension | BERT | GPT |\n" +
                "| :--- | :--- | :--- |\n" +
                "| **Architecture** | Transformer Encoder-only | Transformer Decoder-only |\n" +
                "| **Context Direction** | Bidirectional (attends left and right simultaneously) | Autoregressive (causal, attends left-to-right only) |\n" +
                "| **Pre-training Task** | Masked Language Modeling (MLM) | Next-Token Prediction |\n" +
                "| **Primary Strength** | Understanding, text classification, NER, search ranking | Generation, conversational chat, creative writing, coding |");
    }

    private static void initDetailedSyllabusConcepts1() {
        KNOWLEDGE.put("adam_optimizer",
                "⚙️ **Adam Optimizer (Adaptive Moment Estimation)**\n\n" +
                "**Overview:**\n" +
                "Adam is an adaptive learning rate optimization algorithm combining the advantages of AdaGrad and RMSprop.\n\n" +
                "**Mechanism:**\n" +
                "• Computes exponentially decaying average of past gradients (first moment / mean): $m_t = \\beta_1 m_{t-1} + (1-\\beta_1) g_t$.\n" +
                "• Computes exponentially decaying average of squared gradients (second moment / uncentered variance): $v_t = \\beta_2 v_{t-1} + (1-\\beta_2) g_t^2$.\n" +
                "• Applies bias correction: $\\hat{m}_t = \\frac{m_t}{1 - \\beta_1^t}$, $\\hat{v}_t = \\frac{v_t}{1 - \\beta_2^t}$.\n" +
                "• Updates parameters: $\\theta_{t+1} = \\theta_t - \\frac{\\alpha}{\\sqrt{\\hat{v}_t} + \\epsilon} \\hat{m}_t$.\n\n" +
                "**Why Popular:** Default standard optimizer for deep neural networks with fast convergence and minimal hyperparameter tuning.");

        KNOWLEDGE.put("artificial_neuron",
                "⚡ **Artificial Neuron (Perceptron Model)**\n\n" +
                "**Definition:**\n" +
                "The fundamental computational building block of neural networks, modeled loosely after biological neurons.\n\n" +
                "**Mathematical Formulation:**\n" +
                "$y = f\\left( \\sum_{i=1}^n w_i x_i + b \\right) = f(W^T X + b)$\n" +
                "• **Inputs ($x_i$):** Feature signals received by the neuron.\n" +
                "• **Weights ($w_i$):** Relative importance or strength of each input.\n" +
                "• **Bias ($b$):** Trainable offset allowing activation threshold shifting independently of input.\n" +
                "• **Activation Function ($f$):** Introduces non-linearity to map weighted sum to output $y$.");

        KNOWLEDGE.put("backpropagation",
                "🔄 **Backpropagation (Backward Propagation of Errors)**\n\n" +
                "**Definition & Purpose:**\n" +
                "The central algorithm for training feedforward artificial neural networks by computing the gradient of the loss function with respect to every weight and bias using the calculus chain rule.\n\n" +
                "**Step-by-Step Mechanism:**\n" +
                "1. **Forward Pass:** Inputs propagate forward through layers to compute network prediction $\\hat{y}$ and calculate loss $L(y, \\hat{y})$.\n" +
                "2. **Error Calculation:** Compute gradient of loss with respect to output layer activations: $\\frac{\\partial L}{\\partial a^{(L)}}$.\n" +
                "3. **Backward Gradient Flow:** Using chain rule, propagate gradients backward through hidden layers: $\\frac{\\partial L}{\\partial W^{(l)}} = \\delta^{(l)} (a^{(l-1)})^T$.\n" +
                "4. **Parameter Updates:** Gradient descent optimizer adjusts weights in the opposite direction of the gradient: $W \\leftarrow W - \\alpha \\frac{\\partial L}{\\partial W}$.");

        KNOWLEDGE.put("bagging",
                "📦 **Bagging (Bootstrap Aggregating)**\n\n" +
                "**Concept:**\n" +
                "An ensemble meta-algorithm designed to reduce variance and mitigate overfitting by training multiple base models independently in parallel on bootstrap sample subsets.\n\n" +
                "**How It Works:**\n" +
                "1. **Bootstrapping:** Draw $B$ random subsets of the training set with replacement ($N$ samples each).\n" +
                "2. **Parallel Training:** Train an independent base learner (e.g., deep Decision Tree) on each bootstrap subset.\n" +
                "3. **Aggregation:**\n" +
                "   • Classification: Majority voting across base estimators.\n" +
                "   • Regression: Arithmetic average of predictions.\n\n" +
                "**Classic Example:** Random Forest, which adds random feature subset selection to standard Bagging.");

        KNOWLEDGE.put("boosting",
                "🚀 **Boosting in Machine Learning**\n\n" +
                "**Concept:**\n" +
                "A sequential ensemble technique that trains a series of weak learners (typically shallow trees or decision stumps) sequentially, where each new model focuses on correcting the residual errors and misclassifications made by previous models.\n\n" +
                "**How It Works:**\n" +
                "1. Train initial weak learner on original dataset.\n" +
                "2. Identify misclassified or high-error samples.\n" +
                "3. Increase sample weights or compute residual error targets.\n" +
                "4. Train next weak learner to fit weighted errors/residuals.\n" +
                "5. Combine models via weighted sum to produce a strong learner.\n\n" +
                "**Key Algorithms:** AdaBoost, Gradient Boosting (GBM), XGBoost, LightGBM, CatBoost.");

        KNOWLEDGE.put("decoder_only_models",
                "📖 **Decoder-Only Transformer Models**\n\n" +
                "**Architecture & Function:**\n" +
                "Transformer models utilizing only masked causal self-attention layers where each token can only attend to previous tokens (autoregressive generation).\n\n" +
                "**Key Characteristics:**\n" +
                "• Trained on next-token prediction objective: $P(w_t | w_1, ..., w_{t-1})$.\n" +
                "• Unidirectional / causal attention mask prevents looking into future tokens.\n" +
                "• Highly optimized for open-ended text generation, creative writing, dialogue, and in-context few-shot learning.\n\n" +
                "**Prominent Models:** OpenAI GPT family (GPT-2, GPT-3, GPT-4), Meta LLaMA, Mistral, Google Gemma.");

        KNOWLEDGE.put("dimensionality_reduction",
                "📐 **Dimensionality Reduction**\n\n" +
                "**Concept:**\n" +
                "The process of transforming high-dimensional feature spaces into lower-dimensional representations while preserving as much meaningful information, variance, or geometrical structure as possible.\n\n" +
                "**Why It Is Needed:**\n" +
                "• Overcomes the Curse of Dimensionality.\n" +
                "• Reduces computational complexity and storage requirements.\n" +
                "• Eliminates multicollinearity and noise.\n" +
                "• Enables 2D/3D visualization.\n\n" +
                "**Major Techniques:**\n" +
                "• **Linear:** Principal Component Analysis (PCA), Linear Discriminant Analysis (LDA), SVD.\n" +
                "• **Non-Linear (Manifold Learning):** t-SNE, UMAP, Kernel PCA, Autoencoders.");

        KNOWLEDGE.put("encoder_decoder_models",
                "🔄 **Encoder-Decoder Transformer Models (Sequence-to-Sequence)**\n\n" +
                "**Architecture & Function:**\n" +
                "Complete Transformer architecture comprising a bidirectional Encoder that processes source context, and an autoregressive Decoder that generates target sequences while attending to encoder outputs via cross-attention.\n\n" +
                "**Key Characteristics:**\n" +
                "• Encoder processes the entire input bidirectionally.\n" +
                "• Decoder generates tokens step-by-step using cross-attention over encoder hidden states.\n" +
                "• Ideal for tasks where input and output lengths differ significantly.\n\n" +
                "**Primary Use Cases:** Machine Translation, Text Summarization, Question Answering.\n" +
                "**Prominent Models:** Original Attention Is All You Need Transformer, T5 (Text-to-Text Transfer Transformer), BART.");

        KNOWLEDGE.put("encoder_only_models",
                "🔍 **Encoder-Only Transformer Models**\n\n" +
                "**Architecture & Function:**\n" +
                "Transformer models using bidirectional self-attention to process entire text sequences simultaneously, allowing every token to attend to tokens before and after it.\n\n" +
                "**Key Characteristics:**\n" +
                "• Trained with Masked Language Modeling (MLM) and Next Sentence Prediction.\n" +
                "• Excels at understanding, semantic representation, classification, and extraction rather than open-ended text generation.\n\n" +
                "**Primary Use Cases:** Named Entity Recognition (NER), Sentiment Analysis, Text Classification, Extractive Question Answering, Semantic Search.\n" +
                "**Prominent Models:** BERT, RoBERTa, DeBERTa, ALBERT.");

        KNOWLEDGE.put("fasttext",
                "⚡ **FastText Word Embeddings**\n\n" +
                "**Developed By:** Facebook AI Research (FAIR, 2016).\n\n" +
                "**Key Innovation:**\n" +
                "Unlike Word2Vec and GloVe which treat whole words as atomic units, FastText breaks words into character n-grams (subwords). A word vector is represented as the sum of its character n-gram vectors.\n\n" +
                "**Key Advantages:**\n" +
                "• **Out-Of-Vocabulary (OOV) Robustness:** Can construct embeddings for unseen or rare words from known subword n-grams.\n" +
                "• **Handles Typos & Morphologies:** Recognizes prefixes, suffixes, and compounds easily across morphologically rich languages (e.g., German, Finnish, Turkish).");

        KNOWLEDGE.put("feature_scaling",
                "📏 **Feature Scaling**\n\n" +
                "**Purpose:**\n" +
                "Transforming numerical features to a similar scale so distance-based models (KNN, SVM, K-Means) and gradient descent algorithms do not become dominated by large-magnitude variables.\n\n" +
                "**Primary Techniques:**\n" +
                "1. **Normalization (Min-Max Scaling):** Scales data to range $[0, 1]$: $x_{scaled} = \\frac{x - x_{min}}{x_{max} - x_{min}}$. Useful when distributions are bounded and non-Gaussian.\n" +
                "2. **Standardization (Z-score Scaling):** Rescales data to $\\mu=0, \\sigma=1$: $z = \\frac{x - \\mu}{\\sigma}$. Preferred for algorithms assuming Gaussian inputs (Linear/Logistic Regression, PCA, Neural Networks).\n" +
                "3. **Robust Scaling:** Uses median and interquartile range (IQR): $x_{scaled} = \\frac{x - Q_2}{Q_3 - Q_1}$. Best when datasets have significant outliers.");

        KNOWLEDGE.put("feature_selection",
                "🎯 **Feature Selection**\n\n" +
                "**Purpose:**\n" +
                "Selecting a subset of the most relevant and non-redundant features to enhance model accuracy, prevent overfitting, speed up training, and improve interpretability.\n\n" +
                "**Three Primary Methods:**\n" +
                "• **Filter Methods:** Evaluate features independently of model based on statistical metrics (Correlation coefficient, Chi-Square test, ANOVA F-test, Mutual Information).\n" +
                "• **Wrapper Methods:** Evaluate feature combinations using predictive models (Forward Selection, Backward Elimination, Recursive Feature Elimination / RFE).\n" +
                "• **Embedded Methods:** Feature selection occurs naturally during model training (Lasso / L1 Regularization driving weights to zero, Decision Tree feature importances).");

        KNOWLEDGE.put("glove",
                "🌐 **GloVe (Global Vectors for Word Representation)**\n\n" +
                "**Developed By:** Stanford University (Pennington et al., 2014).\n\n" +
                "**Concept:**\n" +
                "An unsupervised word representation algorithm that combines the advantages of global matrix factorization (like LSA) and local context window methods (like Word2Vec).\n\n" +
                "**Mechanism:**\n" +
                "Trained on global word-word co-occurrence statistics from a large text corpus. The dot product of two word vectors equals the logarithm of their probability of co-occurrence: $w_i^T \\tilde{w}_j + b_i + \\tilde{b}_j = \\log(X_{ij})$.\n\n" +
                "**Advantage:** Encodes linear substructures and semantic relationships (e.g., 'king' - 'man' + 'woman' $\\approx$ 'queen').");

        KNOWLEDGE.put("gradient_boosting",
                "📈 **Gradient Boosting (GBM / GBDT)**\n\n" +
                "**Concept:**\n" +
                "A powerful boosting ensemble method where base learners (shallow regression decision trees) are sequentially trained to predict the negative gradient (pseudo-residuals) of the loss function.\n\n" +
                "**Mechanism:**\n" +
                "1. Initialize base model with constant prediction minimizing initial loss (e.g., mean target value).\n" +
                "2. For each iteration $m=1$ to $M$, compute pseudo-residuals $r_{im} = -\\left[ \\frac{\\partial L(y_i, f(x_i))}{\\partial f(x_i)} \\right]$.\n" +
                "3. Train a regression tree to fit residuals $r_{im}$.\n" +
                "4. Update model: $F_m(x) = F_{m-1}(x) + \\alpha \\gamma_m h_m(x)$ where $\\alpha$ is the shrinkage learning rate.\n\n" +
                "**Implementations:** Scikit-learn GradientBoosting, XGBoost, LightGBM, CatBoost.");

        KNOWLEDGE.put("image_representation",
                "🖼️ **Image Representation in Computer Vision**\n\n" +
                "**Concept:**\n" +
                "Digital images are stored as multi-dimensional numerical matrices (tensors) of pixel intensity values.\n\n" +
                "**Common Formats:**\n" +
                "• **Grayscale:** 2D matrix of shape $(H, W)$ with pixel intensities ranging from 0 (pure black) to 255 (pure white) for 8-bit depth.\n" +
                "• **RGB Color:** 3D tensor of shape $(H, W, 3)$ consisting of 3 color channels: Red, Green, and Blue.\n" +
                "• **RGBA:** Includes a 4th alpha transparency channel.\n" +
                "• **HSV / HSL:** Hue (color type), Saturation (vibrancy), and Value/Lightness (brightness) representation often used for color thresholding and filtering.");

        KNOWLEDGE.put("inference_engine",
                "🧠 **Inference Engine**\n\n" +
                "**Definition:**\n" +
                "The brain or reasoning component of an expert system or rule-based AI system that applies logical deduction rules to the knowledge base to infer new facts or make decisions.\n\n" +
                "**Two Primary Reasoning Modes:**\n" +
                "1. **Forward Chaining (Data-Driven):** Starts with known facts and applies rules to deduce new facts until a target goal is achieved (e.g., monitoring and diagnostics).\n" +
                "2. **Backward Chaining (Goal-Driven):** Starts with a hypothesis or goal and works backward to see if supporting evidence/facts exist in the knowledge base (e.g., medical diagnosis, debugging).");

        KNOWLEDGE.put("instance_segmentation",
                "✂️ **Instance Segmentation**\n\n" +
                "**Concept:**\n" +
                "Combines object detection and semantic segmentation. It detects individual objects of interest and classifies every pixel belonging to each specific object, distinguishing separate instances of the same class.\n\n" +
                "**Difference vs Semantic Segmentation:**\n" +
                "• Semantic segmentation labels all chairs with the same color.\n" +
                "• Instance segmentation identifies 'Chair 1', 'Chair 2', and 'Chair 3' as distinct individual mask instances.\n\n" +
                "**Leading Architecture:** Mask R-CNN, YOLACT, Segment Anything (SAM).");
    }

    private static void initDetailedSyllabusConcepts2() {
        KNOWLEDGE.put("lemmatization",
                "📖 **Lemmatization in NLP**\n\n" +
                "**Concept:**\n" +
                "The algorithmic process of reducing inflected word forms to their canonical base dictionary form (known as a lemma) using vocabulary lookups and grammatical morphological analysis.\n\n" +
                "**Difference vs Stemming:**\n" +
                "• **Stemming:** Heuristic chopping of word ends, often producing non-words ('studying' $\\to$ 'studi').\n" +
                "• **Lemmatization:** Uses part-of-speech context and lexicons to yield valid words ('studying' $\\to$ 'study', 'better' $\\to$ 'good', 'was' $\\to$ 'be').\n\n" +
                "**Tools:** NLTK WordNetLemmatizer, spaCy, Stanford CoreNLP.");

        KNOWLEDGE.put("matplotlib",
                "📊 **Matplotlib in Data Science & Python**\n\n" +
                "**Overview:**\n" +
                "The foundational 2D plotting and data visualization library in Python, providing an object-oriented API and a procedural MATLAB-like interface (`matplotlib.pyplot`).\n\n" +
                "**Key Chart Types:**\n" +
                "• Line plots (`plt.plot`), Scatter plots (`plt.scatter`)\n" +
                "• Bar charts (`plt.bar`), Histograms (`plt.hist`)\n" +
                "• Subplots (`plt.subplots`), Box plots (`plt.boxplot`)\n\n" +
                "**Usage:** Works seamlessly with NumPy arrays and Pandas DataFrames, serving as the underlying visualization engine for Seaborn.");

        KNOWLEDGE.put("neural_network_layers",
                "🧱 **Neural Network Layers: Input, Hidden, and Output**\n\n" +
                "**1. Input Layer:**\n" +
                "The entry point that receives raw numerical feature vectors without performing mathematical transformations.\n\n" +
                "**2. Hidden Layers:**\n" +
                "Intermediate computational layers that perform linear transformations followed by non-linear activations ($a = f(W x + b)$). Stacking multiple hidden layers enables deep networks to learn hierarchical representations (e.g., edges $\\to$ shapes $\\to$ complex objects).\n\n" +
                "**3. Output Layer:**\n" +
                "Final layer configured to deliver model predictions according to the task:\n" +
                "• Binary Classification: 1 unit with Sigmoid activation.\n" +
                "• Multi-class Classification: $K$ units with Softmax activation.\n" +
                "• Regression: 1 or more linear units without activation.");

        KNOWLEDGE.put("polynomial_regression",
                "📈 **Polynomial Regression**\n\n" +
                "**Concept:**\n" +
                "A form of regression analysis in which the relationship between the independent variable $X$ and dependent variable $Y$ is modeled as an $n$-th degree polynomial:\n" +
                "$y = \\beta_0 + \\beta_1 x + \\beta_2 x^2 + \\dots + \\beta_n x^n + \\epsilon$.\n\n" +
                "**Key Characteristics:**\n" +
                "• Even though it models non-linear curvilinear curves, it is still considered a linear model because it is linear in the parameters $\\beta$.\n" +
                "• High-degree polynomials easily suffer from severe overfitting (Runge's phenomenon), requiring regularization (Ridge / Lasso).");

        KNOWLEDGE.put("pos_tagging",
                "🏷️ **Part-Of-Speech (POS) Tagging**\n\n" +
                "**Concept:**\n" +
                "The NLP process of marking each token in a sentence with its corresponding grammatical syntactic category (e.g., Noun, Verb, Adjective, Adverb, Preposition) based on its definition and linguistic context.\n\n" +
                "**Significance:**\n" +
                "Disambiguates words with identical spellings that have different grammatical functions (e.g., 'book a flight' [Verb] vs 'read a book' [Noun]).\n\n" +
                "**Techniques:** Hidden Markov Models (HMM), Maximum Entropy Markov Models (MEMM), Conditional Random Fields (CRF), and Transformer encoders.");

        KNOWLEDGE.put("positional_encoding",
                "📍 **Positional Encoding in Transformers**\n\n" +
                "**Concept:**\n" +
                "Transformers process all tokens simultaneously in parallel without recurrence or convolution. Because self-attention is permutation-invariant, positional encoding injects sequence order information directly into token embeddings.\n\n" +
                "**Sinusoidal Positional Encoding (Vaswani et al.):**\n" +
                "$\\text{PE}_{(pos, 2i)} = \\sin\\left(\\frac{pos}{10000^{2i/d_{model}}}\\right)$\n" +
                "$\\text{PE}_{(pos, 2i+1)} = \\cos\\left(\\frac{pos}{10000^{2i/d_{model}}}\\right)$\n\n" +
                "**Modern Alternatives:** Learnable positional embeddings, Rotary Position Embeddings (RoPE), ALiBi.");

        KNOWLEDGE.put("rule_based_systems",
                "📋 **Rule-Based Systems in AI**\n\n" +
                "**Concept:**\n" +
                "A classical symbolic AI methodology that encodes human expert domain knowledge into deterministic IF-THEN production rules.\n\n" +
                "**Components:**\n" +
                "1. **Knowledge Base:** Set of rules: `IF <conditions> THEN <actions>`.\n" +
                "2. **Working Memory / Fact Base:** Current assertions and observed state facts.\n" +
                "3. **Inference Engine:** Matches facts with rule conditions (e.g., using Rete algorithm) and fires appropriate actions.\n\n" +
                "**Tradeoffs:** Highly transparent, explainable, and verifiable, but brittle and labor-intensive to scale.");

        KNOWLEDGE.put("semantic_segmentation",
                "🎨 **Semantic Segmentation**\n\n" +
                "**Concept:**\n" +
                "Pixel-level computer vision classification where every single pixel in an image is assigned a categorical class label (e.g., road, person, sky, vehicle).\n\n" +
                "**Difference vs Instance Segmentation:**\n" +
                "Semantic segmentation does NOT distinguish between individual object instances—all pixels belonging to pedestrians are assigned the identical label.\n\n" +
                "**Popular Architectures:** U-Net, Fully Convolutional Networks (FCN), DeepLabV3+, SegNet.");

        KNOWLEDGE.put("sentence_word_tokenization",
                "✂️ **Sentence and Word Tokenization**\n\n" +
                "• **Word Tokenization:** Divides text strings into individual word units, handling punctuation, contractions ('don\\'t' $\\to$ 'do', 'n\\'t'), and special symbols.\n" +
                "• **Sentence Tokenization (Sentence Splitting):** Segments continuous paragraphs into distinct grammatical sentences using punctuation and capitalization rules while avoiding false splits at abbreviations (e.g., 'Dr.', 'e.g.').\n\n" +
                "**Common Libraries:** NLTK (`sent_tokenize`, `word_tokenize`), spaCy, HuggingFace Tokenizers.");

        KNOWLEDGE.put("sgd",
                "📉 **Stochastic Gradient Descent (SGD)**\n\n" +
                "**Concept:**\n" +
                "An optimization variant of gradient descent that updates model parameters using only a single randomly chosen training sample at each step, rather than computing gradients across the entire batch.\n\n" +
                "**Update Rule:** $\\theta \\leftarrow \\theta - \\alpha \\nabla L_i(\\theta)$.\n\n" +
                "**Comparison:**\n" +
                "• **Batch Gradient Descent:** Computes exact gradient across entire dataset; slow and memory-intensive for large datasets.\n" +
                "• **SGD:** Fast, computationally lightweight, noisy trajectory allows escaping shallow local minima.\n" +
                "• **Mini-Batch SGD:** Compromise processing small batches (e.g., 32, 64) with vectorization.");

        KNOWLEDGE.put("sklearn_pipelines",
                "🔧 **Scikit-Learn Machine Learning Pipelines**\n\n" +
                "**Concept:**\n" +
                "A powerful abstraction in Scikit-Learn (`sklearn.pipeline.Pipeline`) that chains together multiple data preprocessing transformers and a final estimator into a unified workflow object.\n\n" +
                "**Key Benefits:**\n" +
                "• **Prevents Data Leakage:** Ensures transformations (scaling, imputation, encoding) are fitted solely on training folds during cross-validation.\n" +
                "• **Reproducibility & Clean Code:** Encapsulates the complete preprocessing and modeling pipeline into standard `.fit()` and `.predict()` calls.\n" +
                "• **Hyperparameter Search:** Allows joint tuning of preprocessing steps and model parameters using `GridSearchCV`.");

        KNOWLEDGE.put("stop_words",
                "🛑 **Stop Words in NLP**\n\n" +
                "**Definition:**\n" +
                "Extremely frequent, common words in a language (such as 'the', 'is', 'in', 'at', 'which', 'and') that carry minimal informative semantic meaning for text categorization and retrieval tasks.\n\n" +
                "**Why Remove Stop Words:**\n" +
                "• Reduces vocabulary size and computational memory requirements.\n" +
                "• Focuses models on high-value domain keywords.\n\n" +
                "**When NOT to Remove:**\n" +
                "Must be kept in modern contextual models (Transformers, BERT, GPT) and sentiment tasks where words like 'not' invert sentiment ('not good').");

        KNOWLEDGE.put("text_classification",
                "📑 **Text Classification in NLP**\n\n" +
                "**Definition:**\n" +
                "The supervised learning task of assigning predefined category labels to raw unstructured text documents.\n\n" +
                "**Common Applications:**\n" +
                "• Spam Detection (Spam vs Ham)\n" +
                "• Sentiment Analysis (Positive, Negative, Neutral)\n" +
                "• Topic Classification (Sports, Finance, Technology)\n" +
                "• Intent Detection in conversational chatbots.\n\n" +
                "**Approaches:** TF-IDF with Naive Bayes/SVM, CNN/LSTM for text, and fine-tuned Transformer Encoders (BERT).");

        KNOWLEDGE.put("tfidf",
                "📊 **TF-IDF (Term Frequency - Inverse Document Frequency)**\n\n" +
                "**Concept:**\n" +
                "A statistical measure that evaluates how relevant a word is to a document in a collection or corpus.\n\n" +
                "**Formula:** $\\text{TF-IDF}(t, d, D) = \\text{TF}(t, d) \\times \\text{IDF}(t, D)$\n" +
                "• **Term Frequency (TF):** Relative frequency of term $t$ in document $d$: $\\text{TF}(t, d) = \\frac{\\text{count}(t, d)}{\\text{total words in } d}$.\n" +
                "• **Inverse Document Frequency (IDF):** $\\log(N / \\text{count}(d \\in D : t \\in d))$. Downweights ubiquitous words while boosting unique keywords.\n\n" +
                "**Use Cases:** Search engines, information retrieval, feature extraction for classical ML classification.");

        KNOWLEDGE.put("weights_and_bias",
                "⚖️ **Weights and Biases in Neural Networks**\n\n" +
                "**Core Components:**\n" +
                "• **Weights ($W$):** Multiplicative learnable parameters that determine the connection strength and influence of each input feature on subsequent neuron activations.\n" +
                "• **Bias ($b$):** Additive learnable constant that allows the activation function curve to be shifted horizontally, ensuring the neuron can activate even when all input values are zero.\n\n" +
                "**Update Process:**\n" +
                "Both weights and biases are iteratively updated during training using gradient descent: $W \\leftarrow W - \\alpha \\frac{\\partial L}{\\partial W}$ and $b \\leftarrow b - \\alpha \\frac{\\partial L}{\\partial b}$." );

        KNOWLEDGE.put("word2vec",
                "📚 **Word2Vec (Mikolov et al., 2013)**\n\n" +
                "**Concept:**\n" +
                "A shallow, two-layer neural network architecture trained to produce dense, continuous vector representations of words capturing semantic and syntactic relationships based on distributional semantics.\n\n" +
                "**Two Model Architectures:**\n" +
                "1. **Continuous Bag of Words (CBOW):** Predicts a target word given its surrounding context words. Faster to train, higher accuracy on frequent words.\n" +
                "2. **Continuous Skip-Gram:** Predicts surrounding context words given a single center word. Excels on small datasets and rare words.\n\n" +
                "**Key Training Optimizations:** Hierarchical Softmax and Negative Sampling.");
    }

    // =========================================================================
    // 12. PROGRAMMING LANGUAGES
    // =========================================================================
    private static void initProgrammingLanguages() {
        KNOWLEDGE.put("programming_language",
                "A programming language is a set of instructions, commands, and syntax used by developers to create software programs and communicate with computers.\n\n" +
                "Example: Python, Java, and C++ are popular programming languages.");

        KNOWLEDGE.put("programming_language_explain",
                "A programming language allows developers to write instructions that a computer can execute.\n\n" +
                "1. High-Level Languages: Human-readable languages like Python and Java that are easy to write and maintain.\n" +
                "2. Low-Level Languages: Machine-oriented languages like Assembly and C that interact directly with computer hardware.\n" +
                "3. Translation: Code is translated into machine binary (0s and 1s) using a compiler or interpreter.\n" +
                "4. Usage: Used to build web apps, mobile apps, operating systems, and AI models.");

        KNOWLEDGE.put("programming_language_types",
                "The main types of programming languages are:\n\n" +
                "1. Procedural Programming Languages: Follow a step-by-step sequence of instructions and functions to solve problems (e.g., C, Pascal).\n\n" +
                "2. Object-Oriented Programming Languages: Organize code into reusable classes and objects that contain data and methods (e.g., Java, C++, Python).\n\n" +
                "3. Functional Programming Languages: Treat computation as the evaluation of mathematical functions and avoid changing state (e.g., Haskell, Scala).\n\n" +
                "4. Scripting Languages: Interpreted languages designed for automating tasks and web development (e.g., JavaScript, Python, PHP).");

        KNOWLEDGE.put("python",
                "Python is a high-level, interpreted programming language known for its simple syntax, readability, and versatile libraries.\n\n" +
                "Example: Python is widely used in Machine Learning, Data Science, Web Development, and Automation.");

        KNOWLEDGE.put("python_explain",
                "Python is a popular general-purpose programming language designed for code readability and developer productivity.\n\n" +
                "1. Easy Syntax: Uses clean, English-like syntax that is beginner-friendly.\n" +
                "2. Interpreted: Executes code line by line, making debugging fast and convenient.\n" +
                "3. Rich Libraries: Offers powerful libraries like NumPy, Pandas, Scikit-learn, and Django.\n" +
                "4. Versatile: Used across AI, data science, web development, and cloud scripting.");

        KNOWLEDGE.put("python_types",
                "Python programming encompasses several core domains and implementations:\n\n" +
                "1. CPython: The standard reference implementation of Python written in C, which compiles Python code to bytecode and interprets it.\n\n" +
                "2. PyPy: A fast alternative implementation that includes a Just-In-Time (JIT) compiler for significantly improved execution speed.\n\n" +
                "3. MicroPython and CircuitPython: Lightweight implementations optimized to run on microcontrollers and embedded devices.");

        KNOWLEDGE.put("java",
                "Java is a high-level, class-based, object-oriented programming language designed to follow the Write Once, Run Anywhere principle.\n\n" +
                "Example: Java is used for building Android mobile applications and enterprise banking backend systems.");

        KNOWLEDGE.put("java_explain",
                "Java is a reliable, object-oriented language developed by Sun Microsystems (now Oracle).\n\n" +
                "1. Platform Independent: Java code compiles to bytecode that runs on any device equipped with a Java Virtual Machine (JVM).\n" +
                "2. Object-Oriented: Enforces OOP concepts including classes, inheritance, and encapsulation.\n" +
                "3. Robust and Secure: Provides automatic memory management via garbage collection and strong type checking.\n" +
                "4. Multithreading: Allows concurrent execution of multiple threads for high performance.");

        KNOWLEDGE.put("c_programming",
                "C is a general-purpose, procedural programming language developed by Dennis Ritchie in 1972 that provides low-level memory access and high execution speed.\n\n" +
                "Example: Operating systems like Linux, Windows kernels, and embedded hardware controllers are built using C.");

        KNOWLEDGE.put("c_programming_explain",
                "C is a foundational programming language that combines high-level structures with low-level hardware control.\n\n" +
                "1. Procedural: Follows a structured approach based on functions and sequential logic.\n" +
                "2. Direct Memory Access: Provides pointers to manipulate system memory addresses directly.\n" +
                "3. Fast and Efficient: Compiles straight to native machine instructions without virtual machine overhead.\n" +
                "4. Foundation Language: Modern languages like C++, Java, and C# are derived from C syntax.");

        KNOWLEDGE.put("cpp_programming",
                "C++ is a high-performance, general-purpose programming language developed by Bjarne Stroustrup as an extension of C that adds object-oriented features.\n\n" +
                "Example: C++ is used in video game engines like Unreal Engine, high-frequency financial trading systems, and web browsers.");

        KNOWLEDGE.put("cpp_programming_explain",
                "C++ is a multi-paradigm language that supports procedural, object-oriented, and generic programming.\n\n" +
                "1. High Speed: Offers near-hardware performance with manual memory management.\n" +
                "2. Object-Oriented: Supports classes, inheritance, polymorphism, and encapsulation.\n" +
                "3. Standard Template Library (STL): Provides built-in data structures like vectors, queues, and sorting algorithms.\n" +
                "4. System Level: Ideal for resource-intensive applications, operating systems, and game engines.");

        KNOWLEDGE.put("csharp_programming",
                "C# is a modern, object-oriented, type-safe programming language developed by Microsoft as part of the .NET platform.\n\n" +
                "Example: C# is widely used for building Windows desktop apps, enterprise web services, and video games in Unity.");

        KNOWLEDGE.put("csharp_programming_explain",
                "C# combines the power of C++ with the simplicity of Visual Basic and Java.\n\n" +
                "1. Object-Oriented: Fully supports classes, interfaces, and inheritance.\n" +
                "2. Type-Safe: Prevents common memory and type conversion errors.\n" +
                "3. .NET Integration: Runs on the Common Language Runtime (CLR) with rich framework libraries.\n" +
                "4. Game Development: The primary language for scripting in the Unity game engine.");

        KNOWLEDGE.put("javascript",
                "JavaScript is a high-level, lightweight programming language used alongside HTML and CSS to create interactive, dynamic web pages.\n\n" +
                "Example: JavaScript handles button clicks, form validations, dynamic content updates, and powers frontend frameworks like React and Vue.");

        KNOWLEDGE.put("javascript_explain",
                "JavaScript is the core programming language of the World Wide Web.\n\n" +
                "1. Client-Side Interactivity: Runs directly inside web browsers to animate and update pages.\n" +
                "2. Event-Driven: Reacts to user interactions such as clicks, typing, and page scrolling.\n" +
                "3. Full-Stack Development: With Node.js, JavaScript can also run on servers and handle backend databases.\n" +
                "4. Asynchronous: Uses promises and async/await to fetch data from APIs without freezing the user interface.");

        KNOWLEDGE.put("typescript",
                "TypeScript is an open-source programming language developed by Microsoft that acts as a statically typed superset of JavaScript.\n\n" +
                "Example: Large web applications built with React or Angular use TypeScript to catch type errors during development.");

        KNOWLEDGE.put("typescript_explain",
                "TypeScript compiles into clean, plain JavaScript that runs on any browser or JavaScript engine.\n\n" +
                "1. Static Typing: Developers declare variable and parameter types, catching bugs before runtime.\n" +
                "2. Tooling Support: Provides intelligent code autocompletion and refactoring in IDEs.\n" +
                "3. Superset: Any valid JavaScript code is also valid TypeScript code.\n" +
                "4. Enterprise Scale: Helps teams maintain large, complex web codebases reliably.");

        KNOWLEDGE.put("html",
                "HTML (HyperText Markup Language) is the standard markup language used to structure and display content on the World Wide Web.\n\n" +
                "Example: HTML uses tags like <h1> for headings, <p> for paragraphs, and <a> for links to structure web pages.");

        KNOWLEDGE.put("html_explain",
                "HTML creates the foundational structure and skeleton of websites.\n\n" +
                "1. Elements and Tags: Uses opening and closing tags to define text, images, and links.\n" +
                "2. Semantic Structure: Modern HTML5 uses tags like <header>, <nav>, and <article> for accessibility.\n" +
                "3. Browser Rendering: Web browsers parse HTML code to render pages visually.\n" +
                "4. Foundation: Works together with CSS for styling and JavaScript for interactivity.");

        KNOWLEDGE.put("css",
                "CSS (Cascading Style Sheets) is a style sheet language used to describe the presentation, colors, fonts, and layout of documents written in HTML.\n\n" +
                "Example: CSS styles web page buttons with rounded corners, background colors, and responsive grid layouts.");

        KNOWLEDGE.put("css_explain",
                "CSS handles the visual styling, presentation, and responsiveness of web pages.\n\n" +
                "1. Separation of Concerns: Separates visual design from HTML content structure.\n" +
                "2. Selectors and Rules: Targets HTML elements using classes, IDs, and element names.\n" +
                "3. Responsive Layouts: Uses Flexbox, CSS Grid, and media queries to adapt to mobile screens.\n" +
                "4. Animations: Supports transitions and keyframe animations for smooth visual effects.");

        KNOWLEDGE.put("sql",
                "SQL (Structured Query Language) is the standard database programming language used to manage, store, query, and manipulate data in relational database systems.\n\n" +
                "Example: SELECT * FROM students WHERE grade = 'A'; retrieves all students who received an A grade.");

        KNOWLEDGE.put("sql_explain",
                "SQL is used to communicate with relational databases like MySQL, PostgreSQL, and Oracle.\n\n" +
                "1. Data Querying (DQL): Retrieves data using SELECT statements with filters and sorting.\n" +
                "2. Data Manipulation (DML): Inserts, updates, and deletes records using INSERT, UPDATE, and DELETE.\n" +
                "3. Data Definition (DDL): Creates and alters table structures using CREATE, ALTER, and DROP.\n" +
                "4. Data Control (DCL): Manages user security and permissions using GRANT and REVOKE.");

        KNOWLEDGE.put("sql_types",
                "The commands in SQL are categorized into five main types:\n\n" +
                "1. DDL (Data Definition Language): Defines and modifies database schemas (e.g., CREATE, ALTER, DROP, TRUNCATE).\n\n" +
                "2. DML (Data Manipulation Language): Modifies and manipulates records stored in tables (e.g., INSERT, UPDATE, DELETE).\n\n" +
                "3. DQL (Data Query Language): Retrieves specific data matching conditions from tables (e.g., SELECT).\n\n" +
                "4. DCL (Data Control Language): Manages database user rights, permissions, and security (e.g., GRANT, REVOKE).\n\n" +
                "5. TCL (Transaction Control Language): Manages transactions and consistency (e.g., COMMIT, ROLLBACK, SAVEPOINT).");

        KNOWLEDGE.put("php",
                "PHP (Hypertext Preprocessor) is an open-source, server-side scripting language primarily used for web development to generate dynamic web pages.\n\n" +
                "Example: PHP powers content management systems like WordPress, Drupal, and Joomla.");

        KNOWLEDGE.put("php_explain",
                "PHP runs on web servers and generates dynamic HTML sent to client browsers.\n\n" +
                "1. Server-Side: Executes on the web server before the page reaches the user.\n" +
                "2. Database Integration: Easily connects to databases like MySQL and PostgreSQL.\n" +
                "3. Open Source: Free to use with broad web hosting support.\n" +
                "4. Dynamic Content: Handles forms, user logins, cookies, and session management.");

        KNOWLEDGE.put("kotlin",
                "Kotlin is a modern, statically typed, cross-platform programming language developed by JetBrains and officially recommended by Google for Android app development.\n\n" +
                "Example: Kotlin is used to build modern Android mobile applications with concise, null-safe code.");

        KNOWLEDGE.put("kotlin_explain",
                "Kotlin is designed to be fully interoperable with Java while improving developer safety and productivity.\n\n" +
                "1. Concise: Reduces boilerplate code compared to traditional Java.\n" +
                "2. Null Safety: Eliminates NullPointerException errors through built-in null checking.\n" +
                "3. Java Interoperability: Can seamlessly call existing Java libraries and code.\n" +
                "4. Coroutines: Provides lightweight concurrency for smooth background tasks and UI rendering.");

        KNOWLEDGE.put("swift",
                "Swift is a powerful, modern, and type-safe programming language developed by Apple for building iOS, macOS, watchOS, and tvOS applications.\n\n" +
                "Example: Swift is used to create iPhone and iPad apps published on Apple's App Store.");

        KNOWLEDGE.put("swift_explain",
                "Swift was created by Apple to replace Objective-C with modern syntax and performance.\n\n" +
                "1. Fast and Safe: Designed for high execution speed with type safety to avoid memory crashes.\n" +
                "2. Clean Syntax: Uses concise, expressive syntax that is easy to read.\n" +
                "3. Memory Management: Uses Automatic Reference Counting (ARC) to handle memory.\n" +
                "4. Apple Ecosystem: The standard language for all modern Apple platforms.");

        KNOWLEDGE.put("rust",
                "Rust is a systems programming language focused on extreme speed, memory safety, and thread concurrency without using a garbage collector.\n\n" +
                "Example: Rust is used to build web browsers (like Firefox components), high-performance operating systems, and blockchain infrastructure.");

        KNOWLEDGE.put("rust_explain",
                "Rust prevents common programming bugs like null pointers and data races at compile time.\n\n" +
                "1. Ownership Model: Manages memory safety through compile-time ownership and borrowing rules.\n" +
                "2. No Garbage Collector: Achieves predictable low latency comparable to C and C++.\n" +
                "3. Concurrency: Guarantees thread safety and prevents data race conditions.\n" +
                "4. Modern Tooling: Includes Cargo for package management and automated testing.");

        KNOWLEDGE.put("go_programming",
                "Go (Golang) is an open-source, statically typed, compiled programming language developed by Google designed for simplicity, speed, and scalable concurrency.\n\n" +
                "Example: Go powers cloud infrastructure tools like Docker and Kubernetes.");

        KNOWLEDGE.put("go_programming_explain",
                "Go was designed at Google to build scalable, high-concurrency cloud and network services.\n\n" +
                "1. Simplicity: Has a clean, minimalistic syntax that is easy to learn and maintain.\n" +
                "2. Built-in Concurrency: Uses lightweight goroutines and channels for efficient parallel tasks.\n" +
                "3. Fast Compilation: Compiles directly into standalone machine binaries in seconds.\n" +
                "4. Cloud Standard: Widely used for microservices, web servers, and DevOps tooling.");
    }

    // =========================================================================
    // 13. COMPUTER SCIENCE CORE TOPICS
    // =========================================================================
    private static void initComputerScience() {
        // --- Object-Oriented Programming (OOP) ---
        KNOWLEDGE.put("oop",
                "Object-Oriented Programming (OOP) is a programming paradigm based on the concept of objects, which combine data fields (attributes) and code procedures (methods).\n\n" +
                "Example: A Car class with attributes like color and speed, and methods like drive() and brake().");

        KNOWLEDGE.put("oop_explain",
                "Object-Oriented Programming (OOP) organizes software design around data and objects rather than functions and logic.\n\n" +
                "1. Encapsulation: Bundles data and methods into a single class, hiding internal details.\n" +
                "2. Abstraction: Hides complex background implementation and exposes only essential features.\n" +
                "3. Inheritance: Enables child classes to reuse code and properties from parent classes.\n" +
                "4. Polymorphism: Allows methods to perform different actions based on the object calling them.");

        KNOWLEDGE.put("oop_types",
                "The 4 core pillars of Object-Oriented Programming are:\n\n" +
                "1. Encapsulation: Bundling data and methods into a single unit called a class, and restricting direct external access to internal data using private variables and public getters and setters.\n\n" +
                "2. Abstraction: Hiding internal complex implementation details and showing only necessary features to the user, achieved through abstract classes and interfaces.\n\n" +
                "3. Inheritance: A mechanism where a child class acquires properties and behaviors from a parent class, promoting code reusability and reducing duplication.\n\n" +
                "4. Polymorphism: The ability of a message or method to be processed in more than one form, including compile-time method overloading and runtime method overriding.");

        KNOWLEDGE.put("class_concept",
                "A class is a user-defined blueprint or template from which individual objects are created in object-oriented programming.\n\n" +
                "Example: A Student class defining properties like name, roll number, and methods like study().");

        KNOWLEDGE.put("class_concept_explain",
                "A class defines the structure and behavior that its objects will have.\n\n" +
                "1. Blueprint: Acts as a template specifying attributes (data) and methods (functions).\n" +
                "2. User-Defined Type: Serves as a custom data type in programming languages.\n" +
                "3. Instantiation: Multiple independent objects can be created from a single class.\n" +
                "4. Access Modifiers: Uses public, private, and protected to control visibility.");

        KNOWLEDGE.put("object_concept",
                "An object is a basic runtime instance of a class that holds actual data values and occupies memory.\n\n" +
                "Example: In a Car class, myCar = new Car(\"Red\", 120); is an object.");

        KNOWLEDGE.put("object_concept_explain",
                "An object represents a real-world entity with state and behavior.\n\n" +
                "1. State: Represented by the attributes or variable values of the object.\n" +
                "2. Behavior: Represented by the methods or functions the object can execute.\n" +
                "3. Identity: Each object has a unique memory address in system RAM.\n" +
                "4. Lifecycle: Objects are created using the new keyword and destroyed when no longer needed.");

        KNOWLEDGE.put("inheritance",
                "Inheritance is an OOP mechanism where a new child class acquires the properties and methods of an existing parent class.\n\n" +
                "Example: A Dog class inherits common animal traits like age and weight from an Animal parent class.");

        KNOWLEDGE.put("inheritance_explain",
                "Inheritance promotes code reusability and establishes an is-a relationship between classes.\n\n" +
                "1. Code Reusability: Child classes reuse existing parent class code without retyping it.\n" +
                "2. Extensibility: Child classes can add new methods or override parent methods.\n" +
                "3. Method Overriding: Child classes provide custom implementations of parent methods.\n" +
                "4. Hierarchy: Creates an organized hierarchy from general to specialized classes.");

        KNOWLEDGE.put("inheritance_types",
                "The types of Inheritance are:\n\n" +
                "1. Single Inheritance: A child class inherits properties and methods from a single parent class.\n\n" +
                "2. Multilevel Inheritance: A class inherits from a child class, forming a chain of inheritance (e.g., Grandparent -> Parent -> Child).\n\n" +
                "3. Hierarchical Inheritance: Multiple child classes inherit from the same single parent class.\n\n" +
                "4. Multiple Inheritance: A child class inherits from more than one parent class (supported directly in C++ and Python, and via interfaces in Java).\n\n" +
                "5. Hybrid Inheritance: A combination of two or more types of inheritance in a single program.");

        KNOWLEDGE.put("polymorphism",
                "Polymorphism means many forms and refers to the ability of a method or operator to perform different actions based on the object that invokes it.\n\n" +
                "Example: A draw() method that draws a circle for a Circle object and a square for a Square object.");

        KNOWLEDGE.put("polymorphism_explain",
                "Polymorphism allows one interface to control access to a general class of actions.\n\n" +
                "1. Flexibility: Enables code to process objects of different types through a unified interface.\n" +
                "2. Compile-Time: Resolved before execution through method overloading and operator overloading.\n" +
                "3. Run-Time: Resolved during execution through method overriding and dynamic method dispatch.\n" +
                "4. Maintenance: Simplifies code expansion by letting new classes fit into existing systems.");

        KNOWLEDGE.put("polymorphism_types",
                "The types of Polymorphism are:\n\n" +
                "1. Compile-Time Polymorphism (Static Polymorphism): Resolved during program compilation. It is achieved through method overloading, where multiple methods share the same name with different parameters, or through operator overloading.\n\n" +
                "2. Run-Time Polymorphism (Dynamic Polymorphism): Resolved during program execution. It is achieved through method overriding, where a child class provides its own specific implementation of a method declared in its parent class.");

        KNOWLEDGE.put("encapsulation",
                "Encapsulation is the OOP concept of wrapping data (variables) and code (methods) together into a single unit (class), while restricting direct external access.\n\n" +
                "Example: Declaring class variables as private and providing public getter and setter methods to access them.");

        KNOWLEDGE.put("encapsulation_explain",
                "Encapsulation protects object state from unintended direct modification.\n\n" +
                "1. Data Hiding: Prevents external code from modifying internal fields directly.\n" +
                "2. Controlled Access: Public getters and setters validate data before updating variables.\n" +
                "3. Modularity: Keeps source code clean, maintainable, and loosely coupled.\n" +
                "4. Security: Shields critical internal object states from unauthorized tampering.");

        KNOWLEDGE.put("abstraction",
                "Abstraction is the OOP principle of hiding internal complex implementation details and showing only the essential features of an object to the outside world.\n\n" +
                "Example: Pressing the brake pedal in a car stops the vehicle without you needing to know the hydraulic mechanics.");

        KNOWLEDGE.put("abstraction_explain",
                "Abstraction simplifies system complexity by focusing on what an object does rather than how it does it.\n\n" +
                "1. Interface Definition: Exposes only essential methods required by the caller.\n" +
                "2. Abstract Classes: Classes that cannot be instantiated directly and contain abstract methods.\n" +
                "3. Interfaces: Blueprints of classes specifying method signatures that implementing classes must fulfill.\n" +
                "4. Reduced Complexity: Allows developers to work with high-level concepts without getting bogged down in low-level details.");

        // --- Data Structures ---
        KNOWLEDGE.put("data_structure",
                "A data structure is a specialized format for organizing, processing, retrieving, and storing data in a computer so that it can be used efficiently.\n\n" +
                "Example: Arrays, linked lists, stacks, and hash tables are common data structures.");

        KNOWLEDGE.put("data_structure_explain",
                "Data structures provide efficient ways to manage and manipulate program data.\n\n" +
                "1. Organization: Arranges data logically in computer memory.\n" +
                "2. Efficiency: Optimizes time and space complexity for search, insertion, and deletion.\n" +
                "3. Reusability: Implements standard algorithms across different applications.\n" +
                "4. Abstraction: Separates the logical representation of data from its physical memory layout.");

        KNOWLEDGE.put("data_structure_types",
                "The main types of Data Structures are:\n\n" +
                "1. Linear Data Structures: Elements are arranged sequentially one after another, where each element is connected to its previous and next elements (e.g., Arrays, Linked Lists, Stacks, Queues).\n\n" +
                "2. Non-Linear Data Structures: Elements are arranged in hierarchical or interconnected relationships rather than a single sequence (e.g., Trees, Graphs).\n\n" +
                "3. Primitive Data Structures: Basic data types built into the programming language (e.g., int, float, char, boolean).\n\n" +
                "4. Non-Primitive Data Structures: Complex user-defined structures created by combining primitive types (e.g., Arrays, Lists, Files).");

        KNOWLEDGE.put("array",
                "An array is a linear data structure that stores a fixed-size sequential collection of elements of the same data type in contiguous memory locations.\n\n" +
                "Example: int scores[5] = {90, 85, 78, 92, 88}; stores 5 test scores accessible by index from 0 to 4.");

        KNOWLEDGE.put("array_explain",
                "Arrays provide fast access to elements using numerical indexing.\n\n" +
                "1. Contiguous Memory: Elements are stored side-by-side in adjacent memory blocks.\n" +
                "2. Constant-Time Access: Accessing any element by index takes O(1) time.\n" +
                "3. Fixed Size: Array size must be defined at creation and cannot easily grow dynamically.\n" +
                "4. Homogeneous Elements: All stored values must share the same data type.");

        KNOWLEDGE.put("array_types",
                "The types of Arrays are:\n\n" +
                "1. One-Dimensional Array: A single list of elements arranged in a linear row accessible using a single index.\n\n" +
                "2. Two-Dimensional Array: Elements arranged in rows and columns like a grid or matrix, accessible using row and column indices.\n\n" +
                "3. Multi-Dimensional Array: Arrays having three or more dimensions, used for complex mathematical modeling and 3D graphics.");

        KNOWLEDGE.put("linked_list",
                "A linked list is a linear data structure where elements, called nodes, are not stored in contiguous memory, but are linked together using pointers.\n\n" +
                "Example: A playlist where each song contains a link pointing to the next song to play.");

        KNOWLEDGE.put("linked_list_explain",
                "A linked list consists of nodes containing a data field and a reference pointer to the next node.\n\n" +
                "1. Dynamic Size: Can easily grow and shrink at runtime without reallocating memory.\n" +
                "2. Efficient Insertions: Inserting or deleting elements at the beginning takes O(1) time.\n" +
                "3. Sequential Access: Accessing the nth element requires traversing from head, taking O(n) time.\n" +
                "4. Memory Overhead: Requires extra memory to store pointer references alongside data.");

        KNOWLEDGE.put("linked_list_types",
                "The types of Linked Lists are:\n\n" +
                "1. Singly Linked List: Each node contains data and a single pointer pointing forward to the next node in the list.\n\n" +
                "2. Doubly Linked List: Each node contains data and two pointers, one pointing to the next node and one pointing to the previous node, allowing bidirectional traversal.\n\n" +
                "3. Circular Linked List: The last node points back to the first node instead of null, forming a continuous loop.");

        KNOWLEDGE.put("stack",
                "A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, where elements can only be added or removed from the top.\n\n" +
                "Example: A stack of plates or the Undo button in a text editor.");

        KNOWLEDGE.put("stack_explain",
                "A stack restricts insertion and removal operations to a single end called top.\n\n" +
                "1. Push Operation: Adds an element to the top of the stack in O(1) time.\n" +
                "2. Pop Operation: Removes the most recently added top element in O(1) time.\n" +
                "3. Peek Operation: Views the top element without removing it.\n" +
                "4. Applications: Used for function call execution stacks, expression evaluation, and backtracking algorithms.");

        KNOWLEDGE.put("queue",
                "A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle, where elements are inserted at the rear and removed from the front.\n\n" +
                "Example: A line of people at a ticket counter or print jobs waiting in a printer queue.");

        KNOWLEDGE.put("queue_explain",
                "A queue processes elements in the exact order of their arrival.\n\n" +
                "1. Enqueue: Inserts a new element at the rear of the queue in O(1) time.\n" +
                "2. Dequeue: Removes the oldest element from the front of the queue in O(1) time.\n" +
                "3. Front and Rear: Maintained using two pointers tracking entry and exit points.\n" +
                "4. Applications: Used in CPU task scheduling, disk scheduling, and breadth-first search.");

        KNOWLEDGE.put("queue_types",
                "The types of Queues are:\n\n" +
                "1. Simple Queue: Elements are inserted at the rear and removed from the front in strict FIFO order.\n\n" +
                "2. Circular Queue: The last position wraps around to connect back to the first position, preventing memory waste.\n\n" +
                "3. Priority Queue: Elements are served based on priority values rather than strictly arrival order.\n\n" +
                "4. Deque (Double-Ended Queue): Elements can be inserted and removed from both the front and rear ends.");

        KNOWLEDGE.put("tree_ds",
                "A tree is a non-linear, hierarchical data structure consisting of nodes connected by edges, starting from a single top node called the root.\n\n" +
                "Example: Computer file systems where a root folder contains nested subfolders and files.");

        KNOWLEDGE.put("tree_ds_explain",
                "A tree organizes data hierarchically with parent-child relationships.\n\n" +
                "1. Root Node: The topmost node of the tree with no parent.\n" +
                "2. Leaf Nodes: Bottom nodes that have no children.\n" +
                "3. Subtree: Any node and its descendants form a smaller tree.\n" +
                "4. Traversals: Explored using Inorder, Preorder, Postorder, or Level-order algorithms.");

        KNOWLEDGE.put("binary_search_tree",
                "A Binary Search Tree (BST) is a binary tree where each node's left child has a smaller value, and each node's right child has a greater value.\n\n" +
                "Example: Searching for a number in a balanced BST takes O(log n) time.");

        KNOWLEDGE.put("binary_search_tree_explain",
                "A BST provides fast search, insertion, and deletion operations.\n\n" +
                "1. Left Subtree: Contains only keys smaller than the parent node.\n" +
                "2. Right Subtree: Contains only keys greater than the parent node.\n" +
                "3. Inorder Traversal: Visiting nodes in left-root-right order yields elements in sorted ascending order.\n" +
                "4. Time Complexity: Average O(log n) for search, insertion, and deletion in balanced trees.");

        KNOWLEDGE.put("graph_ds",
                "A graph is a non-linear data structure consisting of a set of vertices (nodes) and edges (connections) connecting pairs of vertices.\n\n" +
                "Example: Social networks where users are vertices and friendships are edges, or road maps connecting cities.");

        KNOWLEDGE.put("graph_ds_explain",
                "Graphs model complex network relationships between interconnected entities.\n\n" +
                "1. Vertices (Nodes): Represent individual entities or data points.\n" +
                "2. Edges (Links): Represent connections or relationships between vertices.\n" +
                "3. Representations: Stored using Adjacency Matrices or Adjacency Lists.\n" +
                "4. Algorithms: Traversed using BFS (Breadth-First Search) and DFS (Depth-First Search).");

        KNOWLEDGE.put("hash_table",
                "A hash table (or hash map) is a data structure that maps keys to values using a mathematical hash function for fast data retrieval.\n\n" +
                "Example: A phonebook where a contact's name directly maps to their phone number with average O(1) lookup time.");

        KNOWLEDGE.put("hash_table_explain",
                "A hash table computes an index into an array of buckets from which desired values can be found.\n\n" +
                "1. Hash Function: Converts an input key into an integer array index.\n" +
                "2. Fast Lookups: Provides average O(1) time complexity for search, insertion, and deletion.\n" +
                "3. Collision Handling: Solves hash collisions using Chaining or Open Addressing.\n" +
                "4. Common Uses: Used in database indexing, caching systems, and symbol tables.");

        // --- Algorithms & Complexity ---
        KNOWLEDGE.put("algorithm_concept",
                "An algorithm is a step-by-step sequence of well-defined, unambiguous instructions designed to solve a specific problem or complete a task.\n\n" +
                "Example: An algorithm to find the largest number in a list by comparing each item one by one.");

        KNOWLEDGE.put("algorithm_concept_explain",
                "An algorithm defines the exact computational steps to produce an output from an input.\n\n" +
                "1. Input and Output: Accepts zero or more inputs and produces at least one clear output.\n" +
                "2. Finiteness: Must terminate after a finite number of execution steps.\n" +
                "3. Unambiguous: Each step must be clear and precisely defined.\n" +
                "4. Efficiency: Evaluated based on execution speed and memory consumption.");

        KNOWLEDGE.put("time_complexity",
                "Time complexity is a computational measure that describes the amount of time an algorithm takes to run as a function of the input size (n), expressed using Big-O notation.\n\n" +
                "Example: Array index lookup takes O(1) constant time, while linear search takes O(n) linear time.");

        KNOWLEDGE.put("space_complexity",
                "Space complexity is the total amount of computer memory space required by an algorithm to execute and produce an output as a function of the input size (n).\n\n" +
                "Example: An algorithm that creates an auxiliary array of size n has O(n) space complexity.");

        KNOWLEDGE.put("sorting_algorithms",
                "Sorting algorithms are step-by-step methods used to rearrange elements of a list or array into a specific order, typically ascending or descending.\n\n" +
                "Example: Sorting student exam marks from highest to lowest.");

        KNOWLEDGE.put("sorting_algorithms_types",
                "The main types of Sorting Algorithms are:\n\n" +
                "1. Bubble Sort: Repeatedly compares adjacent elements and swaps them if they are in the wrong order, with O(n^2) time complexity.\n\n" +
                "2. Selection Sort: Repeatedly finds the smallest element from the unsorted section and places it at the beginning, with O(n^2) time complexity.\n\n" +
                "3. Insertion Sort: Builds the sorted array one element at a time by inserting each item into its correct position, with O(n^2) time complexity.\n\n" +
                "4. Merge Sort: A divide-and-conquer algorithm that divides the array into halves, sorts each half recursively, and merges them in O(n log n) time.\n\n" +
                "5. Quick Sort: A divide-and-conquer algorithm that picks a pivot element, partitions the array around the pivot, and recursively sorts sub-arrays in average O(n log n) time.");

        KNOWLEDGE.put("searching_algorithms",
                "Searching algorithms are methods used to locate a specific target value or element within a collection of data.\n\n" +
                "Example: Searching for a student name in an alphabetical class attendance register.");

        KNOWLEDGE.put("searching_algorithms_types",
                "The main types of Searching Algorithms are:\n\n" +
                "1. Linear Search: Sequentially checks every element in the collection from beginning to end until the target is found, with O(n) time complexity. It works on both sorted and unsorted lists.\n\n" +
                "2. Binary Search: Repeatedly divides a sorted collection in half, comparing the target value to the middle element, with O(log n) time complexity. It requires the collection to be sorted beforehand.");

        KNOWLEDGE.put("recursion",
                "Recursion is a programming technique where a function calls itself directly or indirectly to solve a problem by breaking it into smaller instances of the same problem.\n\n" +
                "Example: Calculating factorial: factorial(n) = n * factorial(n - 1) with base case factorial(0) = 1.");

        KNOWLEDGE.put("recursion_explain",
                "Recursion solves problems by dividing them into simpler sub-problems.\n\n" +
                "1. Base Case: The condition that terminates recursion to avoid infinite loops.\n" +
                "2. Recursive Step: The part of the function that calls itself with smaller inputs.\n" +
                "3. Call Stack: Each recursive call adds a frame to the execution call stack in memory.\n" +
                "4. Common Uses: Tree traversals, divide-and-conquer algorithms, and Tower of Hanoi.");

        // --- Database Management Systems (DBMS) ---
        KNOWLEDGE.put("dbms",
                "A Database Management System (DBMS) is software used to store, manage, organize, and retrieve data efficiently and securely.\n\n" +
                "Example: MySQL, Oracle, PostgreSQL, and SQLite are popular DBMS software.");

        KNOWLEDGE.put("dbms_explain",
                "A DBMS provides a systematic way to create, update, and manage databases.\n\n" +
                "1. Data Integrity: Enforces constraints and rules to maintain accurate data.\n" +
                "2. Concurrent Access: Allows multiple users to access and update data simultaneously.\n" +
                "3. Data Security: Restricts access through authentication and user permissions.\n" +
                "4. Backup and Recovery: Recovers data reliably following system crashes or hardware failures.");

        KNOWLEDGE.put("dbms_types",
                "The main types of Database Management Systems are:\n\n" +
                "1. Relational DBMS (RDBMS): Stores data in structured tables with rows and columns, linked by primary and foreign keys (e.g., MySQL, PostgreSQL, Oracle).\n\n" +
                "2. NoSQL DBMS: Stores unstructured or semi-structured data using document, key-value, column-family, or graph models for high scalability (e.g., MongoDB, Cassandra, Redis).\n\n" +
                "3. Hierarchical DBMS: Organizes data in a tree-like structure with parent-child relationships where each child has one parent (e.g., IBM IMS).\n\n" +
                "4. Network DBMS: Organizes data in a graph structure where each record can have multiple parent and child records.");

        KNOWLEDGE.put("acid_properties",
                "ACID properties are four critical guarantees (Atomicity, Consistency, Isolation, Durability) that ensure database transactions are processed reliably.\n\n" +
                "Example: In online bank transfers, ACID properties ensure money is deducted and credited together without disappearing if the server fails.");

        KNOWLEDGE.put("acid_properties_explain",
                "The ACID properties ensure reliability and validity in database transactions:\n\n" +
                "1. Atomicity: Guarantees that a transaction is all-or-nothing; either all operations succeed, or the entire transaction is rolled back.\n" +
                "2. Consistency: Ensures that transactions bring the database from one valid state to another, obeying all integrity constraints.\n" +
                "3. Isolation: Ensures that concurrent transactions execute independently without interfering with each other.\n" +
                "4. Durability: Guarantees that once a transaction commits, its changes are permanently recorded in storage and survive system failures.");

        KNOWLEDGE.put("database_keys",
                "Database keys are attributes or sets of attributes used to uniquely identify records and establish relationships between tables in a relational database.\n\n" +
                "Example: A student's Roll Number or Social Security Number serves as a primary key.");

        KNOWLEDGE.put("database_keys_types",
                "The main types of Database Keys are:\n\n" +
                "1. Primary Key: A unique attribute that uniquely identifies each row in a table. It cannot contain null values.\n\n" +
                "2. Candidate Key: Any set of attributes that can uniquely identify a record. The primary key is chosen from candidate keys.\n\n" +
                "3. Foreign Key: An attribute in one table that references the primary key of another table, establishing a relationship between them.\n\n" +
                "4. Composite Key: A key made up of two or more attributes combined together to uniquely identify a record.");

        KNOWLEDGE.put("normalization_dbms",
                "Normalization is the process of organizing data in a database to reduce data redundancy and eliminate anomalies during insertion, update, and deletion.\n\n" +
                "Example: Splitting a large customer-order table into separate Customer and Order tables linked by CustomerID.");

        KNOWLEDGE.put("normalization_dbms_types",
                "The main normal forms in database normalization are:\n\n" +
                "1. 1NF (First Normal Form): Eliminates repeating groups and ensures each column contains only atomic (indivisible) values.\n\n" +
                "2. 2NF (Second Normal Form): Satisfies 1NF and eliminates partial dependencies, meaning all non-key attributes depend fully on the primary key.\n\n" +
                "3. 3NF (Third Normal Form): Satisfies 2NF and eliminates transitive dependencies, meaning non-key attributes depend only on the primary key.\n\n" +
                "4. BCNF (Boyce-Codd Normal Form): A stricter version of 3NF where every determinant must be a candidate key.");

        // --- Operating Systems ---
        KNOWLEDGE.put("operating_system",
                "An Operating System (OS) is system software that manages computer hardware, system resources, and provides common services for computer programs.\n\n" +
                "Example: Microsoft Windows, Linux, macOS, and Android are operating systems.");

        KNOWLEDGE.put("operating_system_explain",
                "An Operating System acts as an intermediary between users, application programs, and computer hardware.\n\n" +
                "1. Process Management: Allocates CPU time and schedules running tasks.\n" +
                "2. Memory Management: Allocates and tracks physical RAM for applications.\n" +
                "3. File Management: Organizes files and directories on storage drives.\n" +
                "4. Device Management: Communicates with hardware peripherals through device drivers.");

        KNOWLEDGE.put("operating_system_types",
                "The main types of Operating Systems are:\n\n" +
                "1. Batch Operating System: Groups similar jobs together into batches and executes them in sequence without direct user interaction.\n\n" +
                "2. Time-Sharing Operating System: Allocates CPU time slices among multiple concurrent users to ensure quick response times.\n\n" +
                "3. Distributed Operating System: Manages a collection of independent networked computers, presenting them to users as a single coherent system.\n\n" +
                "4. Real-Time Operating System (RTOS): Serves applications with strict time constraints where processing must complete within defined deadlines (e.g., flight control systems).");

        KNOWLEDGE.put("process_vs_thread",
                "A process is an independent program in execution with its own dedicated memory space, while a thread is a lightweight execution unit inside a process that shares memory and resources with other threads in the same process.\n\n" +
                "Example: A web browser is a process, while individual open browser tabs or background downloads are separate threads.");

        KNOWLEDGE.put("deadlock",
                "A deadlock is a situation in an operating system where two or more processes are permanently blocked because each process is holding a resource and waiting for another resource held by another process.\n\n" +
                "Example: Process 1 holds the printer and waits for the scanner, while Process 2 holds the scanner and waits for the printer.");

        KNOWLEDGE.put("deadlock_conditions",
                "The 4 necessary conditions for a Deadlock (Coffman conditions) are:\n\n" +
                "1. Mutual Exclusion: At least one resource must be held in a non-shareable mode by one process at a time.\n\n" +
                "2. Hold and Wait: A process holding at least one resource is actively waiting to acquire additional resources held by other processes.\n\n" +
                "3. No Preemption: Resources cannot be forcibly taken away from a process; they can only be released voluntarily after the process completes.\n\n" +
                "4. Circular Wait: A closed loop of processes exists such that each process is waiting for a resource held by the next process in the cycle.");

        KNOWLEDGE.put("virtual_memory",
                "Virtual memory is a memory management technique that allows a computer to run programs larger than physical RAM by temporarily transferring pages of data to secondary hard disk storage.\n\n" +
                "Example: Running modern 16 GB video editing software smoothly on a computer with only 8 GB of physical RAM.");

        // --- Computer Networks ---
        KNOWLEDGE.put("computer_network",
                "A computer network is a collection of interconnected computing devices that share resources, exchange data, and communicate with each other over physical or wireless links.\n\n" +
                "Example: The Internet, which connects billions of computers, phones, and servers globally.");

        KNOWLEDGE.put("computer_network_explain",
                "Computer networks enable communication and resource sharing across distributed machines.\n\n" +
                "1. Resource Sharing: Shares hardware peripherals like printers and storage servers.\n" +
                "2. Data Transfer: Transmits files, emails, web pages, and media streams.\n" +
                "3. Reliability: Multiple connection paths provide fault tolerance if one link fails.\n" +
                "4. Protocols: Uses standardized rules like TCP/IP and HTTP to coordinate data exchange.");

        KNOWLEDGE.put("computer_network_types",
                "The main types of Computer Networks are:\n\n" +
                "1. LAN (Local Area Network): Connects computers within a limited geographical area such as a single home, school, or office building.\n\n" +
                "2. MAN (Metropolitan Area Network): Covers a larger geographical area such as an entire city, connecting multiple LANs (e.g., municipal cable TV networks).\n\n" +
                "3. WAN (Wide Area Network): Spans large geographical regions connecting cities, countries, or continents, with the global Internet being the largest WAN.\n\n" +
                "4. PAN (Personal Area Network): Covers a small personal space around an individual (within 10 meters), such as Bluetooth connections between a phone and smartwatch.");

        KNOWLEDGE.put("osi_model",
                "The OSI (Open Systems Interconnection) model is a conceptual 7-layer framework that standardizes how telecommunication and computer systems communicate over a network.\n\n" +
                "Example: Network administrators use the OSI model to diagnose network issues layer by layer.");

        KNOWLEDGE.put("osi_model_layers",
                "The 7 layers of the OSI Model from bottom to top are:\n\n" +
                "1. Physical Layer: Transmits raw unstructured bit streams over physical cables, radio waves, or fiber optics.\n\n" +
                "2. Data Link Layer: Handles node-to-node frame delivery, error checking, and physical MAC addressing (e.g., Ethernet, Wi-Fi switches).\n\n" +
                "3. Network Layer: Routes packets across multiple networks using logical IP addressing (e.g., Routers, IP protocol).\n\n" +
                "4. Transport Layer: Manages end-to-end data delivery, flow control, and error recovery (e.g., TCP, UDP).\n\n" +
                "5. Session Layer: Establishes, maintains, and terminates conversational communication sessions between applications.\n\n" +
                "6. Presentation Layer: Formats, encrypts, and compresses data so that application software can read it (e.g., SSL/TLS, JPEG).\n\n" +
                "7. Application Layer: Interacts directly with software applications and end-user network services (e.g., HTTP, HTTPS, FTP, DNS).");

        KNOWLEDGE.put("tcp_vs_udp",
                "TCP (Transmission Control Protocol) is connection-oriented and guarantees reliable, ordered data delivery through handshakes, whereas UDP (User Datagram Protocol) is connectionless and sends packets faster without guaranteeing delivery or order.\n\n" +
                "Example: Web pages and file downloads use TCP for accuracy, while video streaming and online gaming use UDP for speed.");

        KNOWLEDGE.put("compiler_vs_interpreter",
                "A compiler translates the entire source code into machine code all at once before execution, creating a fast standalone binary, while an interpreter translates and runs source code line by line at runtime.\n\n" +
                "Example: C and C++ use compilers for maximum speed, while Python and JavaScript use interpreters for flexible debugging.");
    }

    // =========================================================================
    // DEFINITIONS WITH SIMPLE EXAMPLES (FOR "DEFINE", "DEFINITION", "WHAT IS")
    // =========================================================================
    private static void initDefinitionsAi() {
        DEFINITIONS.put("ai_fundamentals",
                "Artificial Intelligence (AI) is a branch of computer science that enables machines to perform tasks that normally require human intelligence, such as learning, reasoning and problem-solving.\n\n" +
                "Example: Chatbots and voice assistants use AI.");

        DEFINITIONS.put("narrow_ai",
                "Narrow AI (also known as Weak AI) is an artificial intelligence system designed and trained to perform a single specific task exceptionally well.\n\n" +
                "Example: Apple Siri, facial recognition, and email spam filters.");

        DEFINITIONS.put("general_ai",
                "General AI (AGI or Strong AI) is a theoretical form of machine intelligence capable of understanding, learning, and applying knowledge across any intellectual task just like a human brain.\n\n" +
                "Example: A versatile robot capable of learning any human job, science, or art from scratch.");

        DEFINITIONS.put("super_ai",
                "Super AI (Artificial Superintelligence) is a hypothetical future AI that surpasses collective human intelligence in every field, including creativity, wisdom, and problem-solving.\n\n" +
                "Example: A superintelligent system capable of solving complex global scientific mysteries in seconds.");

        DEFINITIONS.put("ai_applications",
                "AI applications are real-world uses of artificial intelligence technology to automate tasks and solve practical problems across industries.\n\n" +
                "Example: Autonomous self-driving cars navigating traffic and medical AI diagnosing diseases from X-rays.");

        DEFINITIONS.put("ai_agents",
                "An AI agent is an autonomous entity that perceives its environment through sensors and takes actions using actuators to achieve its goals.\n\n" +
                "Example: An automated vacuum cleaning robot sensing obstacles and cleaning floor areas.");

        DEFINITIONS.put("rational_agents",
                "A rational agent is an AI agent that always selects actions that maximize its expected performance measure based on its built-in knowledge and perceptual history.\n\n" +
                "Example: A self-driving taxi that chooses routes to safely deliver passengers while obeying traffic laws.");

        DEFINITIONS.put("environment_types",
                "Environment types in AI describe the nature of the operating surroundings an agent interacts with, such as observable, deterministic, or dynamic.\n\n" +
                "Example: A chessboard is a fully observable, deterministic environment, while city traffic is partially observable and stochastic.");

        DEFINITIONS.put("problem_solving_ai",
                "Problem solving in AI is the systematic process of finding a sequence of valid actions that transforms an initial state into a designated goal state within a state space.\n\n" +
                "Example: Solving the 8-puzzle game by sliding numbered tiles step-by-step into the correct order.");

        DEFINITIONS.put("search_algorithms_ai",
                "Search algorithms in AI are step-by-step methods used by an agent to explore a state space and find a path from a starting state to a goal state.\n\n" +
                "Example: A navigation app searching for the shortest driving route between two addresses.");

        DEFINITIONS.put("bfs",
                "Breadth-First Search (BFS) is a graph traversal algorithm that explores all neighbor nodes at the present depth level before moving on to nodes at the next depth level.\n\n" +
                "Example: Finding the shortest path between two cities on an unweighted road map.");

        DEFINITIONS.put("dfs",
                "Depth-First Search (DFS) is a graph traversal algorithm that explores as deep as possible along each branch before backtracking.\n\n" +
                "Example: Solving a maze puzzle by following each path to a dead end before backtracking.");

        DEFINITIONS.put("uniform_cost_search",
                "Uniform Cost Search (UCS) is an uninformed search algorithm that always expands the node with the lowest cumulative path cost from the start node.\n\n" +
                "Example: Finding the cheapest toll-route across highways with varying toll costs.");

        DEFINITIONS.put("greedy_best_first_search",
                "Greedy Best-First Search is an informed search algorithm that expands the node that appears closest to the goal according to a heuristic function.\n\n" +
                "Example: Navigating toward a destination by always choosing the road that points most directly toward it as the crow flies.");

        DEFINITIONS.put("a_star_search",
                "A* Search is an informed pathfinding and graph search algorithm that finds the optimal shortest path by combining actual path cost with a heuristic estimate to the goal.\n\n" +
                "Example: GPS navigation systems calculating the quickest driving route to a destination.");

        DEFINITIONS.put("minimax",
                "Minimax is a decision-making algorithm used in two-player zero-sum turn-based games that determines the optimal move by assuming both players play rationally.\n\n" +
                "Example: Chess and Tic-Tac-Toe computer opponents choosing their next best move.");

        DEFINITIONS.put("alpha_beta_pruning",
                "Alpha-Beta Pruning is an optimization technique for the Minimax algorithm that eliminates branches in a game tree that cannot influence the final decision.\n\n" +
                "Example: Speeding up a chess computer engine by skipping moves that are already worse than an alternative.");

        DEFINITIONS.put("propositional_logic",
                "Propositional Logic is a branch of formal logic that deals with declarative statements that are either True or False, connected by logical operators like AND, OR, and NOT.\n\n" +
                "Example: The statement 'If it rains, the grass is wet' expressed as P implies Q.");

        DEFINITIONS.put("predicate_logic",
                "First-Order Predicate Logic (FOL) is a formal logic system that extends propositional logic by introducing objects, properties, relations, and quantifiers like For All and There Exists.\n\n" +
                "Example: Representing 'All humans are mortal' as For All x, Human(x) implies Mortal(x).");

        DEFINITIONS.put("expert_systems",
                "An Expert System is an AI software program that mimics the decision-making ability of a human specialist in a specific domain using knowledge bases and inference rules.\n\n" +
                "Example: Medical diagnostic systems that recommend treatments based on patient symptoms and disease rules.");

        DEFINITIONS.put("inference_engine",
                "An Inference Engine is the brain or reasoning component of an expert system that applies logical deduction rules to facts to infer new conclusions.\n\n" +
                "Example: Forward chaining in a medical expert system deriving a diagnosis from observed patient symptoms.");

        DEFINITIONS.put("rule_based_systems",
                "A Rule-Based System is an AI system that uses human-crafted IF-THEN rules to make decisions and solve problems in a specific domain.\n\n" +
                "Example: Automated email sorting rules that move messages containing 'invoice' to a Finance folder.");

        DEFINITIONS.put("fuzzy_logic",
                "Fuzzy Logic is a mathematical approach to computing that handles reasoning with degrees of truth between 0 and 1, rather than strictly binary true or false values.\n\n" +
                "Example: An automatic washing machine adjusting its wash cycle time based on the degree of water cloudiness.");

        DEFINITIONS.put("ai_ethics",
                "AI Ethics is a set of moral values and guidelines ensuring artificial intelligence systems are developed and deployed fairly, transparently, and without harm.\n\n" +
                "Example: Auditing job recruitment algorithms to prevent gender and racial discrimination.");

        DEFINITIONS.put("ai_bias",
                "AI Bias occurs when an artificial intelligence algorithm produces systematically unfair or prejudiced decisions due to flawed training data or human prejudices.\n\n" +
                "Example: Facial recognition systems exhibiting higher error rates for certain demographic groups due to unrepresentative training data.");

        DEFINITIONS.put("explainable_ai",
                "Explainable AI (XAI) refers to methods and frameworks, such as SHAP and LIME, that make the internal decisions of complex black-box machine learning models transparent and understandable to humans.\n\n" +
                "Example: Explaining why a credit scoring AI approved or rejected a customer's loan application.");

        DEFINITIONS.put("ai_safety",
                "AI Safety is the field of research dedicated to ensuring artificial intelligence systems operate reliably, predictably, and in alignment with human values without unintended harms.\n\n" +
                "Example: Designing fail-safe override systems in autonomous driving cars and medical robots.");

        DEFINITIONS.put("data_privacy_ai",
                "Data Privacy in AI refers to techniques and policies that protect sensitive personal user information from unauthorized exposure during model training and inference.\n\n" +
                "Example: Federated learning training smartphone keyboard models on devices without uploading private messages to the cloud.");
    }

    private static void initDefinitionsMl() {
        DEFINITIONS.put("machine_learning",
                "Machine Learning (ML) is a branch of Artificial Intelligence that allows computers to learn from data and improve from experience without being explicitly programmed.\n\n" +
                "Example: Email spam filtering and video recommendations on YouTube or Netflix.");

        DEFINITIONS.put("supervised_learning",
                "Supervised Learning is a type of Machine Learning where a model is trained using labeled data, meaning the input data is paired with the known target answer.\n\n" +
                "Example: Email spam filtering and house price prediction.");

        DEFINITIONS.put("unsupervised_learning",
                "Unsupervised Learning is a type of Machine Learning that analyzes unlabeled data to find hidden patterns, groupings, or structures on its own without predefined answers.\n\n" +
                "Example: Customer segmentation based on buying habits.");

        DEFINITIONS.put("semi_supervised_learning",
                "Semi-Supervised Learning is a Machine Learning approach that uses a small amount of labeled data paired with a large amount of unlabeled data during training.\n\n" +
                "Example: Medical diagnosis where only a few X-rays are labeled by doctors while thousands of unlabeled X-rays are available.");

        DEFINITIONS.put("labeled_dataset",
                "A labeled dataset is a collection of data that has been tagged or annotated with informative labels, classes, or target values (ground truth) that a machine learning model can learn from during supervised training.\n\n" +
                "Example: A folder of cat and dog images where each image file is labeled as 'cat' or 'dog'.");

        DEFINITIONS.put("reinforcement_learning",
                "Reinforcement Learning is a type of Machine Learning where an agent learns to make optimal decisions by interacting with an environment through trial and error, guided by rewards and penalties.\n\n" +
                "Example: Self-driving cars learning safe driving decisions and AI playing chess.");

        DEFINITIONS.put("train_test_val_data",
                "Training, validation, and testing data are distinct portions of a dataset used to train a model, tune its hyperparameters, and evaluate its final unseen performance.\n\n" +
                "Example: Splitting 10,000 patient records into 7,000 for training, 1,500 for validation, and 1,500 for final testing.");

        DEFINITIONS.put("features_and_labels",
                "Features are the measurable input variables used by a model to learn, while labels are the target output values the model is trained to predict.\n\n" +
                "Example: When predicting house prices, features include square footage and bedrooms, while the label is the sale price.");

        DEFINITIONS.put("regression",
                "Regression is a supervised learning task where a model learns to predict a continuous numerical value based on one or more input features.\n\n" +
                "Example: Predicting house prices based on square footage, location, and number of bedrooms.");

        DEFINITIONS.put("classification",
                "Classification is a supervised learning task where a model learns to categorize input data into discrete predefined classes or labels.\n\n" +
                "Example: Classifying incoming emails as Spam or Not Spam.");

        DEFINITIONS.put("clustering",
                "Clustering is an unsupervised learning task that partitions unlabeled data points into groups such that points in the same group share high similarity.\n\n" +
                "Example: Segmenting retail customers into distinct buying persona groups based on purchase history.");

        DEFINITIONS.put("anomaly_detection",
                "Anomaly Detection is the identification of rare items, events, or observations that differ significantly from the majority of the data distribution.\n\n" +
                "Example: Credit card fraud detection flagging an unusually large transaction in an unexpected country.");

        DEFINITIONS.put("feature_engineering",
                "Feature Engineering is the process of selecting, transforming, and creating informative input features from raw data, such as feature scaling and categorical encoding, to improve machine learning model accuracy.\n\n" +
                "Example: Scaling numerical features and one-hot encoding categorical variables to prepare data for training.");

        DEFINITIONS.put("feature_selection",
                "Feature Selection is the process of choosing the most relevant subset of input features while removing redundant or irrelevant variables to improve model performance.\n\n" +
                "Example: Using correlation analysis to remove duplicate financial indicators before training a stock model.");

        DEFINITIONS.put("feature_scaling",
                "Feature Scaling is a data preprocessing technique used to normalize the range of independent features so that features with large values do not dominate distance calculations.\n\n" +
                "Example: Standardizing salaries (thousands of dollars) and ages (tens of years) to have mean 0 and variance 1.");

        DEFINITIONS.put("dimensionality_reduction",
                "Dimensionality Reduction is the process of reducing the number of input variables in a dataset while preserving its essential variance and meaningful information.\n\n" +
                "Example: Using PCA to reduce an image from 1,000 pixel features down to 50 principal components.");

        DEFINITIONS.put("bias_variance_tradeoff",
                "The Bias-Variance Tradeoff is the challenge of simultaneously minimizing bias (underfitting) and variance (overfitting) to achieve minimum total prediction error on unseen data.\n\n" +
                "Example: Tuning a decision tree's depth so it is neither too shallow to learn nor too deep to memorize noise.");

        DEFINITIONS.put("overfitting",
                "Overfitting occurs when a machine learning model memorizes training data and its noise too closely, resulting in high training accuracy but poor generalization to unseen test data.\n\n" +
                "Example: A student memorizing practice test questions word-for-word but failing the real exam with new questions.");

        DEFINITIONS.put("underfitting",
                "Underfitting occurs when a machine learning model is too simple to capture underlying patterns in the data, leading to low accuracy on both training and test datasets.\n\n" +
                "Example: Fitting a straight line to data points that clearly follow a parabolic curve.");

        DEFINITIONS.put("cross_validation",
                "Cross-Validation is a resampling evaluation technique that divides data into multiple training and validation folds to assess how well a model generalizes to unseen data.\n\n" +
                "Example: 5-Fold Cross-Validation, where data is split into 5 parts, training on 4 and testing on 1, repeated 5 times.");

        DEFINITIONS.put("hyperparameter_tuning",
                "Hyperparameter Tuning is the process of finding the optimal configuration settings for a machine learning model before training begins to maximize its accuracy.\n\n" +
                "Example: Using Grid Search or Random Search to find the best learning rate and tree depth for a Random Forest.");

        DEFINITIONS.put("linear_regression",
                "Linear Regression is a supervised learning algorithm that models the linear relationship between independent predictor features and a continuous target variable using a straight line.\n\n" +
                "Example: Predicting an employee's salary based on years of work experience.");

        DEFINITIONS.put("multiple_linear_regression",
                "Multiple Linear Regression is a supervised learning algorithm that uses two or more independent input features to predict a single continuous target variable.\n\n" +
                "Example: Predicting house prices using square footage, age, and number of bedrooms.");

        DEFINITIONS.put("polynomial_regression",
                "Polynomial Regression is a form of regression analysis in which the relationship between an independent variable and dependent variable is modeled as an nth-degree polynomial.\n\n" +
                "Example: Modeling crop yield based on varying amounts of rainfall, where yields decline after optimal water levels.");

        DEFINITIONS.put("logistic_regression",
                "Logistic Regression is a supervised learning algorithm used for classification that models the probability of a categorical outcome using a sigmoid curve.\n\n" +
                "Example: Predicting whether a bank customer will default on a loan (Yes or No).");

        DEFINITIONS.put("knn",
                "K-Nearest Neighbors (KNN) is a supervised learning algorithm that classifies new data points based on the majority class among their K closest neighbors in feature space.\n\n" +
                "Example: Recommending movies to a user based on the movie preferences of similar users.");

        DEFINITIONS.put("decision_tree",
                "A Decision Tree is a supervised machine learning algorithm that recursively splits data into branch-like if-else decision rules based on feature values to predict target outcomes.\n\n" +
                "Example: Deciding whether to approve a bank loan based on credit score and monthly income.");

        DEFINITIONS.put("random_forest",
                "Random Forest is an ensemble supervised learning algorithm that builds a multitude of decision trees using bagging and combines their predictions to produce higher accuracy.\n\n" +
                "Example: Diagnosing a medical condition by combining the voting decisions of multiple decision trees.");

        DEFINITIONS.put("svm",
                "Support Vector Machine (SVM) is a supervised learning algorithm that finds an optimal hyperplane that maximizes the margin between different classes in high-dimensional feature space.\n\n" +
                "Example: Classifying handwritten digits like 0 through 9 based on pixel strokes.");

        DEFINITIONS.put("naive_bayes",
                "Naive Bayes is a probabilistic classifier based on Bayes' Theorem that assumes all predictor features are independent of each other given the class label.\n\n" +
                "Example: Spam email filtering calculating the probability an email is spam based on words like 'free' and 'prize'.");

        DEFINITIONS.put("kmeans",
                "Definition: K-Means Clustering is an unsupervised algorithm that partitions data into K distinct clusters based on distance to cluster centroids.\n\n" +
                "Working: It randomly initializes K centroids, assigns each point to the closest centroid, and iteratively updates centroids until they stop moving.\n\n" +
                "Example: Grouping online store shoppers into 3 customer segments based on spend amount and frequency.");

        DEFINITIONS.put("dbscan",
                "Definition: DBSCAN is a density-based unsupervised clustering algorithm that groups closely packed data points together and marks low-density points as noise or outliers.\n\n" +
                "Working: It identifies core points with minimum neighbors within a search radius epsilon, expands dense clusters, and flags unassigned points as noise.\n\n" +
                "Example: Detecting credit card fraud by identifying unusual transactions that fall outside regular dense spending clusters.");

        DEFINITIONS.put("hierarchical_clustering",
                "Definition: Hierarchical Clustering is an unsupervised algorithm that builds a tree of clusters called a dendrogram by merging or dividing groups.\n\n" +
                "Working: In agglomerative clustering, each point starts as its own cluster, and the closest pairs are iteratively merged until one cluster remains.\n\n" +
                "Example: Grouping biological species into an evolutionary family tree based on shared genetic traits.");

        DEFINITIONS.put("pca",
                "Principal Component Analysis (PCA) is an unsupervised dimensionality reduction technique that transforms correlated features into a smaller set of uncorrelated principal components while preserving maximum variance.\n\n" +
                "Example: Compressing high-resolution facial images to fewer essential features for fast facial recognition.");

        DEFINITIONS.put("gradient_descent",
                "Gradient Descent is an iterative optimization algorithm used to minimize a model's loss function by updating weights in the opposite direction of the gradient.\n\n" +
                "Example: Adjusting the weights of a linear regression line after each training epoch to reduce prediction errors.");

        DEFINITIONS.put("sgd",
                "Stochastic Gradient Descent (SGD) is an optimization algorithm that updates model parameters using only a single randomly chosen training sample at each step for faster training.\n\n" +
                "Example: Training large-scale deep learning models efficiently on millions of online streaming data points.");

        DEFINITIONS.put("ensemble_learning",
                "Ensemble Learning is a machine learning technique that combines predictions from multiple individual models to achieve higher accuracy and generalization than any single model.\n\n" +
                "Example: Random Forest combining hundreds of decision trees to predict customer churn.");

        DEFINITIONS.put("bagging",
                "Bagging (Bootstrap Aggregating) is an ensemble technique where multiple base models are trained in parallel on random bootstrap subsets of training data to reduce variance.\n\n" +
                "Example: Random Forest training multiple decision trees on different random samples of patient data.");

        DEFINITIONS.put("boosting",
                "Boosting is an ensemble technique where base models are trained sequentially, with each new model focusing on correcting the mistakes of previous models to reduce bias.\n\n" +
                "Example: AdaBoost and Gradient Boosting creating high-accuracy classifiers from simple decision stumps.");

        DEFINITIONS.put("adaboost",
                "AdaBoost (Adaptive Boosting) is an ensemble boosting algorithm that iteratively trains weak decision trees, assigning higher weights to instances misclassified by earlier models.\n\n" +
                "Example: Combining 50 simple decision stumps to create a high-accuracy binary classifier.");

        DEFINITIONS.put("gradient_boosting",
                "Gradient Boosting is an ensemble learning method that builds trees sequentially, with each new tree trained to predict the residual errors of the previous trees.\n\n" +
                "Example: Predicting real estate prices with high accuracy by sequentially refining price residuals.");

        DEFINITIONS.put("xgboost",
                "XGBoost (Extreme Gradient Boosting) is an optimized, high-performance distributed gradient boosting library known for fast execution and high accuracy in tabular data competitions.\n\n" +
                "Example: Predicting credit card fraud or loan defaults in Kaggle machine learning competitions.");

        DEFINITIONS.put("model_evaluation",
                "Model Evaluation is the process of assessing a machine learning model's performance and accuracy on unseen test data using statistical metrics.\n\n" +
                "Example: Using Accuracy, Precision, and Recall to measure how well a cancer detection model predicts diagnoses.");

        DEFINITIONS.put("confusion_matrix",
                "A Confusion Matrix is a performance evaluation table for classification algorithms that contrasts actual target values with model predictions across True Positives, True Negatives, False Positives, and False Negatives.\n\n" +
                "Example: Assessing how many cancer patients were correctly diagnosed versus missed by a medical AI model.");

        DEFINITIONS.put("roc_auc",
                "ROC-AUC is an evaluation metric that plots True Positive Rate against False Positive Rate across all classification thresholds, measuring a model's ability to distinguish between classes.\n\n" +
                "Example: An AUC score of 0.95 indicates a 95% likelihood that the classifier ranks a random positive sample higher than a negative one.");

        DEFINITIONS.put("f1_score",
                "The F1 Score is the harmonic mean of Precision and Recall, providing a balanced single performance metric for classification models on imbalanced datasets.\n\n" +
                "Example: Measuring credit card fraud detection where fraudulent transactions make up less than 0.1% of all cases.");

        DEFINITIONS.put("regression_metrics",
                "Regression metrics (such as MAE, MSE, and R-squared) are statistical measures used to quantify the prediction error and goodness of fit of regression models.\n\n" +
                "Example: Calculating an RMSE of $15,000 on a house price prediction model to measure average dollar error.");

        DEFINITIONS.put("log_loss",
                "Log Loss (also called Cross-Entropy Loss) is an evaluation metric for classification models that measures the penalty for wrong probabilistic predictions.\n\n" +
                "Example: Heavily penalizing an AI model that predicts a 99% probability of rain when it actually stays sunny.");

        DEFINITIONS.put("silhouette_score",
                "Silhouette Score is a metric used to calculate the goodness of a clustering technique, measuring how similar a data point is to its own cluster compared to other clusters.\n\n" +
                "Example: Evaluating whether K-Means with K=3 created tighter and more distinct customer segments than K=4.");
    }

    private static void initDefinitionsDlAndNlp() {
        DEFINITIONS.put("deep_learning",
                "Deep Learning is a subset of Machine Learning based on Artificial Neural Networks with multiple hidden layers that automatically extracts representations directly from raw data.\n\n" +
                "Example: Facial recognition on smartphones and autonomous driving vision systems.");

        DEFINITIONS.put("neural_network",
                "An Artificial Neural Network (ANN) is a computing architecture inspired by biological neurons in the human brain, composed of interconnected layers of artificial neurons.\n\n" +
                "Example: Predicting whether a bank customer will leave a subscription service based on past activity.");

        DEFINITIONS.put("perceptron",
                "A Perceptron is the simplest form of an artificial neural network consisting of a single neuron that computes a weighted sum of inputs and passes it through an activation function.\n\n" +
                "Example: Modeling basic binary logic operations like an AND gate or OR gate.");

        DEFINITIONS.put("artificial_neuron",
                "An artificial neuron is the elementary processing unit of a neural network that calculates a weighted sum of inputs, adds a bias term, and applies an activation function.\n\n" +
                "Example: A single neuron in an input layer receiving pixel values of a scanned handwritten number.");

        DEFINITIONS.put("neural_network_layers",
                "Neural network layers are organized tiers of neurons comprising an input layer that receives data, hidden layers that extract features, and an output layer that produces predictions.\n\n" +
                "Example: A 3-layer neural network with 10 input neurons, 20 hidden neurons, and 2 output neurons for binary classification.");

        DEFINITIONS.put("weights_and_bias",
                "Weights are learnable parameters that determine the strength of connections between neurons, while bias is an additive constant that allows shifting the activation function.\n\n" +
                "Example: In linear prediction y = w*x + b, w scales the input and b shifts the baseline output up or down.");

        DEFINITIONS.put("activation_function",
                "An Activation Function is a mathematical formula applied to the output of an artificial neuron that introduces non-linearity, allowing neural networks to learn complex patterns.\n\n" +
                "Example: The ReLU (Rectified Linear Unit) activation function, which outputs the input if positive and zero otherwise.");

        DEFINITIONS.put("forward_propagation",
                "Forward Propagation is the calculation process where input data moves forward through the layers of a neural network to produce an output prediction.\n\n" +
                "Example: Feeding an image into a network to calculate its probability of being a cat or dog.");

        DEFINITIONS.put("backpropagation",
                "Backpropagation is a supervised learning algorithm that computes the gradients of a loss function with respect to neural network weights using the chain rule of calculus to update weights.\n\n" +
                "Example: Propagating output classification errors backward to adjust hidden layer weights after each batch.");

        DEFINITIONS.put("loss_functions",
                "A Loss Function is a mathematical formula that measures the difference between a model's predicted output and the true target label during training.\n\n" +
                "Example: Mean Squared Error (MSE) for regression and Cross-Entropy Loss for classification.");

        DEFINITIONS.put("optimizers",
                "An Optimizer is an algorithm that adjusts the weights and learning rate of a neural network to minimize its loss function during training.\n\n" +
                "Example: The Adam and SGD optimizers used to speed up neural network training convergence.");

        DEFINITIONS.put("adam_optimizer",
                "Adam (Adaptive Moment Estimation) is an advanced optimization algorithm for neural networks that combines the advantages of AdaGrad and RMSProp with adaptive learning rates.\n\n" +
                "Example: Training deep convolutional neural networks faster and more reliably than standard gradient descent.");

        DEFINITIONS.put("vanishing_gradient",
                "The Vanishing Gradient Problem occurs during backpropagation when gradients shrink exponentially as they propagate backward through deep layers, preventing early layers from learning.\n\n" +
                "Example: Standard RNNs failing to remember the beginning words of a long 50-word paragraph.");

        DEFINITIONS.put("cnn",
                "A Convolutional Neural Network (CNN) is a deep neural network architecture designed specifically for processing and analyzing visual data such as images and videos.\n\n" +
                "Example: Face unlock on smartphones and detecting pedestrians in self-driving cars.");

        DEFINITIONS.put("rnn",
                "A Recurrent Neural Network (RNN) is a neural network designed to handle sequential data by maintaining an internal recurrent memory of past inputs.\n\n" +
                "Example: Predicting the next word in a text message or forecasting tomorrow's stock price.");

        DEFINITIONS.put("lstm",
                "Long Short-Term Memory (LSTM) is an advanced type of Recurrent Neural Network designed to learn long-term sequential dependencies and eliminate the vanishing gradient problem using memory cells and gates.\n\n" +
                "Example: Machine translation systems that translate complete paragraphs between languages.");

        DEFINITIONS.put("gru",
                "A Gated Recurrent Unit (GRU) is a streamlined variant of LSTM that uses reset and update gates to retain sequential memory with fewer parameters and faster training.\n\n" +
                "Example: Real-time speech recognition and audio processing on mobile devices.");

        DEFINITIONS.put("autoencoders",
                "An Autoencoder is an unsupervised neural network that learns to compress input data into a lower-dimensional code and then reconstruct the original data from that representation.\n\n" +
                "Example: Image denoising, removing grain and noise from medical scans or photos.");

        DEFINITIONS.put("transfer_learning",
                "Transfer Learning is a machine learning technique where a model pre-trained on a large dataset is repurposed and fine-tuned for a related target task on a smaller dataset.\n\n" +
                "Example: Using an ImageNet pre-trained ResNet model to classify rare skin diseases using only a few hundred patient photos.");

        DEFINITIONS.put("nlp",
                "Natural Language Processing (NLP) is a branch of Artificial Intelligence that enables computers to understand, interpret, and generate human language in text and speech form.\n\n" +
                "Example: Google Translate converting text between languages and voice assistants understanding spoken commands.");

        DEFINITIONS.put("text_preprocessing",
                "Text preprocessing is the preparatory stage in NLP that cleans and transforms raw unstructured text into structured, standardized tokens for model training.\n\n" +
                "Example: Converting text to lowercase, removing punctuation, and stripping HTML tags.");

        DEFINITIONS.put("tokenization",
                "Tokenization is an NLP preprocessing step that splits raw text into smaller individual pieces called tokens, such as words, punctuation, or subwords.\n\n" +
                "Example: Splitting 'Machine learning is fun' into tokens ['Machine', 'learning', 'is', 'fun'].");

        DEFINITIONS.put("stemming",
                "Stemming is a text normalization technique in NLP that cuts off word prefixes and suffixes to reduce words to their base root form using heuristic rules.\n\n" +
                "Example: Reducing 'studying', 'studies', and 'studied' to the root stem 'studi'.");

        DEFINITIONS.put("lemmatization",
                "Lemmatization is an NLP text normalization technique that uses vocabulary and morphological analysis to return the true dictionary base form (lemma) of a word.\n\n" +
                "Example: Converting 'better' to its dictionary lemma 'good', and 'running' to 'run'.");

        DEFINITIONS.put("stop_words",
                "Stop words are common words in a language (such as 'the', 'is', 'at', 'which') that are often filtered out during text processing because they carry minimal unique meaning.\n\n" +
                "Example: Removing 'is' and 'a' from 'A cat is cute' leaving the informative keywords ['cat', 'cute'].");

        DEFINITIONS.put("pos_tagging",
                "Part-of-Speech (POS) Tagging is an NLP process that labels each word in a text corpus with its corresponding grammatical part of speech, such as noun, verb, or adjective.\n\n" +
                "Example: Labeling 'run' as a Verb in 'I run fast' and as a Noun in 'He went for a run'.");

        DEFINITIONS.put("bag_of_words",
                "Bag of Words (BoW) is a text representation technique that represents text as a collection of word frequencies, disregarding grammar and word order.\n\n" +
                "Example: Representing customer reviews as a word frequency count table to classify them as positive or negative.");

        DEFINITIONS.put("ngrams",
                "An N-gram is a contiguous sequence of n items (such as words or characters) extracted from a given sample of text or speech.\n\n" +
                "Example: In 'Machine learning is great', the bigrams (2-grams) are 'Machine learning', 'learning is', and 'is great'.");

        DEFINITIONS.put("tfidf",
                "TF-IDF (Term Frequency-Inverse Document Frequency) is a numerical statistic reflecting how important a word is to a specific document within a collection of documents.\n\n" +
                "Example: Giving higher search ranking weight to rare words like 'photosynthesis' over common words like 'article'.");

        DEFINITIONS.put("word_embeddings",
                "Word Embeddings are dense numerical vector representations of words where words with similar semantic meanings are placed close together in multidimensional vector space.\n\n" +
                "Example: Word2Vec placing 'king' and 'queen' close together in vector space.");

        DEFINITIONS.put("word2vec",
                "Word2Vec is a popular NLP framework developed by Google that uses two-layer neural networks (CBOW or Skip-Gram) to learn continuous word vector embeddings from large text corpora.\n\n" +
                "Example: Capturing relational word analogies such as Vector('King') - Vector('Man') + Vector('Woman') approx Vector('Queen').");

        DEFINITIONS.put("fasttext",
                "FastText is an open-source library and embedding model developed by Facebook that represents words as bags of character n-grams to handle unseen and rare words effectively.\n\n" +
                "Example: Generating accurate embeddings for rare misspelled words like 'artifical' based on shared subwords.");

        DEFINITIONS.put("glove",
                "GloVe (Global Vectors for Word Representation) is an unsupervised embedding algorithm developed at Stanford that maps words to vectors by factorizing a global word-word co-occurrence matrix.\n\n" +
                "Example: Discovering geometric semantic relationships between city names and their respective countries.");

        DEFINITIONS.put("sentiment_analysis",
                "Sentiment Analysis is an NLP task that uses machine learning to classify the emotional tone or opinion expressed in text as positive, negative, or neutral.\n\n" +
                "Example: An e-commerce platform analyzing customer product reviews to measure customer satisfaction.");

        DEFINITIONS.put("ner",
                "Named Entity Recognition (NER) is an NLP subtask that locates and categorizes entities in text into predefined classes such as person names, organizations, and locations.\n\n" +
                "Example: Extracting 'Google' as an Organization and 'California' as a Location from a news article.");

        DEFINITIONS.put("text_classification",
                "Text Classification is an NLP process of automatically assigning predefined categories or tags to open-ended text documents.\n\n" +
                "Example: Classifying news articles into categories such as Sports, Technology, and Politics.");

        DEFINITIONS.put("transformers",
                "A Transformer is a deep learning architecture based on self-attention mechanisms that processes all words in a sentence simultaneously in parallel rather than sequentially.\n\n" +
                "Example: Powering modern AI models like GPT, BERT, and Google Gemini.");

        DEFINITIONS.put("bert",
                "BERT (Bidirectional Encoder Representations from Transformers) is a language model developed by Google that understands context by looking at words from both left and right directions simultaneously.\n\n" +
                "Example: Google Search understanding search queries with subtle contextual meaning.");

        DEFINITIONS.put("gpt",
                "GPT (Generative Pre-trained Transformer) is an autoregressive language model developed by OpenAI that generates human-like text by predicting the most probable next token in a sequence.\n\n" +
                "Example: ChatGPT generating essays, answering questions, and writing computer code.");

        DEFINITIONS.put("t5",
                "T5 (Text-to-Text Transfer Transformer) is an encoder-decoder model developed by Google that frames all NLP tasks into a unified text-in, text-out format.\n\n" +
                "Example: Performing translation by inputting 'translate English to German: Hello' to output 'Hallo'.");

        DEFINITIONS.put("encoder_only_models",
                "Encoder-Only models (such as BERT) use bidirectional self-attention to understand and represent text sequences, excelling at classification and search tasks.\n\n" +
                "Example: BERT classifying whether a movie review is positive or negative.");

        DEFINITIONS.put("decoder_only_models",
                "Decoder-Only models (such as GPT) use causal masked self-attention to generate text sequentially by predicting one next token at a time.\n\n" +
                "Example: ChatGPT generating a conversational response word by word.");

        DEFINITIONS.put("encoder_decoder_models",
                "Encoder-Decoder models (such as T5 and BART) combine a bidirectional encoder and an autoregressive decoder to transform an input sequence into a different output sequence.\n\n" +
                "Example: Translating a sentence from French into English or summarizing a long article.");
    }

    private static void initDefinitionsCvGenAiData() {
        DEFINITIONS.put("computer_vision",
                "Computer Vision is a branch of Artificial Intelligence that enables computers to capture, process, and understand visual information from digital images and videos.\n\n" +
                "Example: Face unlock on smartphones and self-driving cars detecting traffic signs.");

        DEFINITIONS.put("image_processing",
                "Image Processing is the technique of applying computational operations to an image to enhance its quality, extract features, or prepare it for machine learning analysis.\n\n" +
                "Example: Converting a color photo to grayscale and applying edge detection filters.");

        DEFINITIONS.put("image_representation",
                "Image Representation is the mathematical format used by computers to store visual data as multidimensional matrices (tensors) of numerical pixel values.\n\n" +
                "Example: An RGB color image stored as a 3D matrix of height, width, and 3 color channels (Red, Green, Blue) with values from 0 to 255.");

        DEFINITIONS.put("object_detection",
                "Object Detection is a computer vision task that identifies instances of visual objects in an image and locates each one using a bounding box.\n\n" +
                "Example: Self-driving cars drawing bounding boxes around pedestrians, cyclists, and traffic lights.");

        DEFINITIONS.put("yolo",
                "YOLO (You Only Look Once) is an extremely fast real-time object detection algorithm that processes an entire image in a single neural network pass.\n\n" +
                "Example: Real-time traffic surveillance cameras counting vehicles passing through an intersection.");

        DEFINITIONS.put("image_segmentation",
                "Image Segmentation is a computer vision technique that partitions an image into multiple pixel segments, including semantic segmentation and instance segmentation, to simplify image analysis.\n\n" +
                "Example: Outlining the exact pixel boundaries of a tumor in a medical MRI scan.");

        DEFINITIONS.put("semantic_segmentation",
                "Semantic Segmentation is a computer vision task that classifies every individual pixel in an image into a class category without distinguishing separate instances.\n\n" +
                "Example: Labeling all road pixels as 'Road' and all sky pixels as 'Sky' in an autonomous vehicle camera view.");

        DEFINITIONS.put("instance_segmentation",
                "Instance Segmentation is an advanced computer vision task that identifies each individual object instance and outlines its exact pixel-level boundary.\n\n" +
                "Example: Detecting three distinct pedestrians standing together and assigning different mask colors to each person.");

        DEFINITIONS.put("opencv_and_faces",
                "OpenCV is an open-source computer vision library containing thousands of optimized algorithms for real-time image processing and face detection.\n\n" +
                "Example: Detecting human faces in a live webcam stream using OpenCV Haar cascades.");

        DEFINITIONS.put("generative_ai",
                "Generative AI is a branch of Artificial Intelligence that creates new, original content such as text, images, audio, and code based on user prompts.\n\n" +
                "Example: ChatGPT generating answers to questions and DALL-E generating images from text descriptions.");

        DEFINITIONS.put("llm",
                "A Large Language Model (LLM) is an advanced AI model trained on massive amounts of text data using deep learning to understand, process, and generate human-like language.\n\n" +
                "Example: ChatGPT and Google Gemini are large language models.");

        DEFINITIONS.put("prompt_engineering",
                "Prompt Engineering is the practice of designing and refining input prompts, such as few-shot and chain-of-thought prompting, to guide generative AI models toward producing accurate and relevant responses.\n\n" +
                "Example: Directing an AI to 'think step by step' (chain-of-thought) to solve a complex math puzzle.");

        DEFINITIONS.put("rag",
                "Retrieval-Augmented Generation (RAG) is an AI technique that retrieves relevant documents from an external knowledge base to enhance the accuracy of large language model responses.\n\n" +
                "Example: A company chatbot searching internal policy PDF documents before answering employee questions.");

        DEFINITIONS.put("fine_tuning",
                "Fine-Tuning is the process of taking a pre-trained AI model and training it further on a smaller, domain-specific dataset to adapt it for a specialized task.\n\n" +
                "Example: Fine-tuning a general LLM on legal contracts so it acts as a specialized legal assistant.");

        DEFINITIONS.put("lora",
                "LoRA (Low-Rank Adaptation) is a parameter-efficient fine-tuning technique that freezes pre-trained model weights and injects trainable low-rank decomposition matrices into Transformer layers.\n\n" +
                "Example: Fine-tuning a 70-billion parameter language model on a single GPU instead of a massive multi-server cluster.");

        DEFINITIONS.put("gan",
                "A Generative Adversarial Network (GAN) is a machine learning architecture where two neural networks—a generator and a discriminator—compete against each other to create realistic synthetic data.\n\n" +
                "Example: Generating photorealistic human faces that do not exist in the real world.");

        DEFINITIONS.put("numpy",
                "NumPy is a fundamental Python library for scientific computing that provides high-performance support for large multidimensional arrays and mathematical operations.\n\n" +
                "Example: Performing fast matrix multiplication and array operations in machine learning algorithms.");

        DEFINITIONS.put("pandas",
                "Pandas is a popular Python data analysis and manipulation library that provides DataFrame and Series data structures for handling tabular data.\n\n" +
                "Example: Loading a CSV dataset using pd.read_csv() and filtering rows by column conditions.");

        DEFINITIONS.put("scikit_learn",
                "Scikit-learn is an open-source Python machine learning library that provides simple, efficient tools for data preprocessing, classification, regression, and clustering.\n\n" +
                "Example: Training a Linear Regression model in 3 lines of code using model.fit(X, y).");

        DEFINITIONS.put("matplotlib",
                "Matplotlib is a comprehensive 2D plotting library for Python that allows creating static, animated, and interactive visualizations.\n\n" +
                "Example: Plotting line charts and histograms to analyze data distributions with plt.plot() and plt.show().");

        DEFINITIONS.put("data_visualization",
                "Data Visualization is the graphical representation of data and information using visual elements like charts, graphs, and maps to identify trends and patterns.\n\n" +
                "Example: Plotting a scatter plot in Matplotlib or Seaborn to visualize the correlation between student study hours and exam scores.");

        DEFINITIONS.put("tensorflow_and_pytorch",
                "TensorFlow and PyTorch are the two leading open-source deep learning frameworks used to build, train, and deploy artificial neural networks.\n\n" +
                "Example: Using PyTorch in research to build computer vision models, and TensorFlow in production for mobile AI apps.");
    }

    private static void initDefinitionsCsAndLanguages() {
        DEFINITIONS.put("programming_language",
                "A programming language is a formal set of instructions, commands, and syntax used by developers to write software programs that computers can execute.\n\n" +
                "Example: Python, Java, and C++ are programming languages used to create apps and software.");

        DEFINITIONS.put("python",
                "Python is a high-level, interpreted programming language known for its simple syntax, readability, and versatile libraries.\n\n" +
                "Example: Python is widely used in Machine Learning, Data Science, Web Development, and Automation.");

        DEFINITIONS.put("java",
                "Java is a high-level, class-based, object-oriented programming language designed to follow the Write Once, Run Anywhere principle.\n\n" +
                "Example: Java is used for building Android mobile applications and enterprise banking backend systems.");

        DEFINITIONS.put("c_programming",
                "C is a general-purpose, procedural programming language developed by Dennis Ritchie in 1972 that provides low-level memory access and high execution speed.\n\n" +
                "Example: Operating systems like Linux, Windows kernels, and embedded hardware controllers are built using C.");

        DEFINITIONS.put("cpp_programming",
                "C++ is a high-performance, general-purpose programming language developed by Bjarne Stroustrup as an extension of C that adds object-oriented features.\n\n" +
                "Example: C++ is used in video game engines like Unreal Engine, high-frequency financial trading systems, and web browsers.");

        DEFINITIONS.put("csharp_programming",
                "C# is a modern, object-oriented, type-safe programming language developed by Microsoft as part of the .NET platform.\n\n" +
                "Example: C# is widely used for building Windows desktop apps, enterprise web services, and video games in Unity.");

        DEFINITIONS.put("javascript",
                "JavaScript is a high-level, lightweight programming language used alongside HTML and CSS to create interactive, dynamic web pages.\n\n" +
                "Example: JavaScript handles button clicks, form validations, dynamic content updates, and powers frontend frameworks like React and Vue.");

        DEFINITIONS.put("typescript",
                "TypeScript is an open-source programming language developed by Microsoft that acts as a statically typed superset of JavaScript.\n\n" +
                "Example: Large web applications built with React or Angular use TypeScript to catch type errors during development.");

        DEFINITIONS.put("html",
                "HTML (HyperText Markup Language) is the standard markup language used to structure and display content on the World Wide Web.\n\n" +
                "Example: HTML uses tags like <h1> for headings, <p> for paragraphs, and <a> for links to structure web pages.");

        DEFINITIONS.put("css",
                "CSS (Cascading Style Sheets) is a style sheet language used to describe the presentation, colors, fonts, and layout of documents written in HTML.\n\n" +
                "Example: CSS styles web page buttons with rounded corners, background colors, and responsive grid layouts.");

        DEFINITIONS.put("sql",
                "SQL (Structured Query Language) is the standard database programming language used to manage, store, query, and manipulate data in relational database systems.\n\n" +
                "Example: SELECT * FROM students WHERE grade = 'A'; retrieves all students who received an A grade.");

        DEFINITIONS.put("php",
                "PHP (Hypertext Preprocessor) is an open-source, server-side scripting language primarily used for web development to generate dynamic web pages.\n\n" +
                "Example: PHP powers content management systems like WordPress, Drupal, and Joomla.");

        DEFINITIONS.put("kotlin",
                "Kotlin is a modern, statically typed, cross-platform programming language developed by JetBrains and officially recommended by Google for Android app development.\n\n" +
                "Example: Kotlin is used to build modern Android mobile applications with concise, null-safe code.");

        DEFINITIONS.put("swift",
                "Swift is a powerful, modern, and type-safe programming language developed by Apple for building iOS, macOS, watchOS, and tvOS applications.\n\n" +
                "Example: Swift is used to create iPhone and iPad apps published on Apple's App Store.");

        DEFINITIONS.put("rust",
                "Rust is a systems programming language focused on extreme speed, memory safety, and thread concurrency without using a garbage collector.\n\n" +
                "Example: Rust is used to build web browsers (like Firefox components), high-performance operating systems, and blockchain infrastructure.");

        DEFINITIONS.put("go_programming",
                "Go (Golang) is an open-source, statically typed, compiled programming language developed by Google designed for simplicity, speed, and scalable concurrency.\n\n" +
                "Example: Go powers cloud infrastructure tools like Docker and Kubernetes.");

        DEFINITIONS.put("oop",
                "Object-Oriented Programming (OOP) is a programming paradigm organized around objects that contain data (attributes) and code (methods) rather than functions and logic alone.\n\n" +
                "Example: Modeling a banking system using Account objects that store balances and provide deposit() and withdraw() methods.");

        DEFINITIONS.put("class_concept",
                "A class is a user-defined blueprint or template from which individual objects are created in object-oriented programming.\n\n" +
                "Example: A Student class defining properties like name, roll number, and methods like study().");

        DEFINITIONS.put("object_concept",
                "An object is a basic runtime instance of a class that holds actual data values and occupies memory.\n\n" +
                "Example: In a Car class, myCar = new Car(\"Red\", 120); is an object.");

        DEFINITIONS.put("inheritance",
                "Inheritance is an OOP mechanism where a new child class acquires the properties and methods of an existing parent class.\n\n" +
                "Example: A Dog class inherits common animal traits like age and weight from an Animal parent class.");

        DEFINITIONS.put("polymorphism",
                "Polymorphism means many forms and refers to the ability of a method or operator to perform different actions based on the object that invokes it.\n\n" +
                "Example: A draw() method that draws a circle for a Circle object and a square for a Square object.");

        DEFINITIONS.put("encapsulation",
                "Encapsulation is the OOP concept of wrapping data (variables) and code (methods) together into a single unit (class), while restricting direct external access.\n\n" +
                "Example: Declaring class variables as private and providing public getter and setter methods to access them.");

        DEFINITIONS.put("abstraction",
                "Abstraction is the OOP principle of hiding internal complex implementation details and showing only the essential features of an object to the outside world.\n\n" +
                "Example: Pressing the brake pedal in a car stops the vehicle without you needing to know the hydraulic mechanics.");

        DEFINITIONS.put("data_structure",
                "A data structure is a specialized format for organizing, processing, retrieving, and storing data in a computer so that it can be used efficiently.\n\n" +
                "Example: Arrays, linked lists, stacks, and hash tables are common data structures.");

        DEFINITIONS.put("array",
                "An array is a linear data structure that stores a fixed-size sequential collection of elements of the same data type in contiguous memory locations.\n\n" +
                "Example: int scores[5] = {90, 85, 78, 92, 88}; stores 5 test scores accessible by index from 0 to 4.");

        DEFINITIONS.put("linked_list",
                "A linked list is a linear data structure where elements, called nodes, are not stored in contiguous memory, but are linked together using pointers.\n\n" +
                "Example: A playlist where each song contains a link pointing to the next song to play.");

        DEFINITIONS.put("stack",
                "A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, where elements can only be added or removed from the top.\n\n" +
                "Example: A stack of plates or the Undo button in a text editor.");

        DEFINITIONS.put("queue",
                "A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle, where elements are inserted at the rear and removed from the front.\n\n" +
                "Example: A line of people at a ticket counter or print jobs waiting in a printer queue.");

        DEFINITIONS.put("tree_ds",
                "A tree is a non-linear, hierarchical data structure consisting of nodes connected by edges, starting from a single top node called the root.\n\n" +
                "Example: Computer file systems where a root folder contains nested subfolders and files.");

        DEFINITIONS.put("binary_search_tree",
                "A Binary Search Tree (BST) is a binary tree where each node's left child has a smaller value, and each node's right child has a greater value.\n\n" +
                "Example: Searching for a number in a balanced BST takes O(log n) time.");

        DEFINITIONS.put("graph_ds",
                "A graph is a non-linear data structure consisting of a set of vertices (nodes) and edges (connections) connecting pairs of vertices.\n\n" +
                "Example: Social networks where users are vertices and friendships are edges, or road maps connecting cities.");

        DEFINITIONS.put("hash_table",
                "A hash table (or hash map) is a data structure that maps keys to values using a mathematical hash function for fast data retrieval.\n\n" +
                "Example: A phonebook where a contact's name directly maps to their phone number with average O(1) lookup time.");

        DEFINITIONS.put("algorithm_concept",
                "An algorithm is a step-by-step sequence of well-defined, unambiguous instructions designed to solve a specific problem or complete a task.\n\n" +
                "Example: An algorithm to find the largest number in a list by comparing each item one by one.");

        DEFINITIONS.put("time_complexity",
                "Time complexity is a computational measure that describes the amount of time an algorithm takes to run as a function of the input size (n), expressed using Big-O notation.\n\n" +
                "Example: Array index lookup takes O(1) constant time, while linear search takes O(n) linear time.");

        DEFINITIONS.put("space_complexity",
                "Space complexity is the total amount of computer memory space required by an algorithm to execute and produce an output as a function of the input size (n).\n\n" +
                "Example: An algorithm that creates an auxiliary array of size n has O(n) space complexity.");

        DEFINITIONS.put("sorting_algorithms",
                "Sorting algorithms are step-by-step methods used to rearrange elements of a list or array into a specific order, typically ascending or descending.\n\n" +
                "Example: Sorting student exam marks from highest to lowest.");

        DEFINITIONS.put("searching_algorithms",
                "Searching algorithms are methods used to locate a specific target value or element within a collection of data.\n\n" +
                "Example: Searching for a student name in an alphabetical class attendance register.");

        DEFINITIONS.put("recursion",
                "Recursion is a programming technique where a function calls itself directly or indirectly to solve a problem by breaking it into smaller instances of the same problem.\n\n" +
                "Example: Calculating factorial: factorial(n) = n * factorial(n - 1) with base case factorial(0) = 1.");

        DEFINITIONS.put("dbms",
                "A Database Management System (DBMS) is software used to store, manage, organize, and retrieve data efficiently and securely.\n\n" +
                "Example: MySQL, Oracle, PostgreSQL, and SQLite are popular DBMS software.");

        DEFINITIONS.put("acid_properties",
                "ACID properties are four critical guarantees (Atomicity, Consistency, Isolation, Durability) that ensure database transactions are processed reliably.\n\n" +
                "Example: In online bank transfers, ACID properties ensure money is deducted and credited together without disappearing if the server fails.");

        DEFINITIONS.put("database_keys",
                "Database keys are attributes or sets of attributes used to uniquely identify records and establish relationships between tables in a relational database.\n\n" +
                "Example: A student's Roll Number or Social Security Number serves as a primary key.");

        DEFINITIONS.put("normalization_dbms",
                "Normalization is the process of organizing data in a database to reduce data redundancy and eliminate anomalies during insertion, update, and deletion.\n\n" +
                "Example: Splitting a large customer-order table into separate Customer and Order tables linked by CustomerID.");

        DEFINITIONS.put("operating_system",
                "An Operating System (OS) is system software that manages computer hardware, system resources, and provides common services for computer programs.\n\n" +
                "Example: Microsoft Windows, Linux, macOS, and Android are operating systems.");

        DEFINITIONS.put("deadlock",
                "A deadlock is a situation in computing where two or more competing processes are blocked forever because each process is holding a resource and waiting for another resource held by another process.\n\n" +
                "Example: Process A holds Printer and waits for Scanner, while Process B holds Scanner and waits for Printer.");

        DEFINITIONS.put("computer_network",
                "A computer network is a collection of interconnected computing devices that communicate and share resources, data, and applications with each other.\n\n" +
                "Example: The global Internet, connecting billions of personal computers, smartphones, and servers worldwide.");

        DEFINITIONS.put("osi_model",
                "The OSI (Open Systems Interconnection) model is a conceptual 7-layer framework that standardizes the network communication functions between computer systems.\n\n" +
                "Example: When you open a website, your request travels down from the Application layer to the Physical cable layer, and back up on the web server.");
    }

    /**
     * Cleans double stars (**) and unnecessary emojis from answer text.
     */
    public static String cleanDoubleStars(String text) {
        if (text == null) return null;
        return text.replace("**", "").trim();
    }

    /**
     * Retrieves simple and easy-to-understand definition along with a simple example.
     */
    public static String getDefinitionWithExample(String conceptId) {
        if (conceptId == null) return null;
        String key = conceptId.toLowerCase().trim();
        String val = DEFINITIONS.get(key);
        if (val != null) {
            return cleanDoubleStars(val);
        }
        val = KNOWLEDGE.get(key);
        if (val != null) {
            return cleanDoubleStars(val);
        }
        return null;
    }

    /**
     * Retrieves rich, structured explanation for a given concept or intent.
     */
    public static String getRichExplanation(String intent) {
        if (intent == null) return null;
        String key = intent.toLowerCase().trim();
        if (key.endsWith("_explain") || key.endsWith("_types") || key.endsWith("_algorithms")
                || key.endsWith("_applications") || key.endsWith("_advantages") || key.endsWith("_disadvantages")
                || key.endsWith("_working") || key.endsWith("_steps") || key.endsWith("_examples")
                || key.contains("_vs_")) {
            String val = KNOWLEDGE.get(key);
            if (val != null) return cleanDoubleStars(val);
        }
        String def = DEFINITIONS.get(key);
        if (def != null) {
            return cleanDoubleStars(def);
        }
        String val = KNOWLEDGE.get(key);
        if (val != null) {
            return cleanDoubleStars(val);
        }
        return null;
    }

    /**
     * Checks if rich explanation is available.
     */
    public static boolean hasRichExplanation(String intent) {
        if (intent == null) return false;
        String key = intent.toLowerCase().trim();
        return DEFINITIONS.containsKey(key) || KNOWLEDGE.containsKey(key);
    }
}
