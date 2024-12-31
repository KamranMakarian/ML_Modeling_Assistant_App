package org.example.model;

public class NeuralNetworkClassifier extends ClassificationModel {

    public NeuralNetworkClassifier() {
        super("Neural Network Classifier");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Neural Network Classifier is a supervised learning algorithm inspired by the human brain, " +
                "consisting of layers of interconnected nodes (neurons). It is highly flexible and effective " +
                "for complex, nonlinear relationships, but it requires a large dataset and careful tuning of " +
                "hyperparameters like the number of layers, learning rate, and activation functions.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.neural_network import MLPClassifier\n" +
                "from sklearn.datasets import make_classification\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import accuracy_score\n" +
                "\n" +
                "# Generate sample classification data\n" +
                "X, y = make_classification(n_samples=200, n_features=10, n_classes=2, random_state=42)\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Neural Network Classifier\n" +
                "nn_classifier = MLPClassifier(hidden_layer_sizes=(100, 50), max_iter=500, random_state=42)\n" +
                "nn_classifier.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = nn_classifier.predict(X_test)\n" +
                "\n" +
                "# Calculate accuracy\n" +
                "accuracy = accuracy_score(y_test, y_pred)\n" +
                "print(f\"Accuracy: {accuracy:.2f}\")\n";
    }
}