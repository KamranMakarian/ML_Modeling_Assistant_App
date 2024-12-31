package org.example.model;

public class RandomForestClassifier extends ClassificationModel {

    public RandomForestClassifier() {
        super("Random Forest Classifier");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Random Forest Classifier is a supervised ensemble learning algorithm that builds " +
                "multiple decision trees and combines their predictions for classification tasks. " +
                "It handles missing data, reduces overfitting, and works well with large datasets, " +
                "but can be computationally intensive.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.ensemble import RandomForestClassifier\n" +
                "from sklearn.datasets import load_iris\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import accuracy_score\n" +
                "\n" +
                "# Load the Iris dataset\n" +
                "data = load_iris()\n" +
                "X = data.data\n" +
                "y = data.target\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Random Forest Classifier\n" +
                "rf_classifier = RandomForestClassifier(n_estimators=100, max_depth=5, random_state=42)\n" +
                "rf_classifier.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = rf_classifier.predict(X_test)\n" +
                "\n" +
                "# Calculate accuracy\n" +
                "accuracy = accuracy_score(y_test, y_pred)\n" +
                "print(f\"Accuracy: {accuracy:.2f}\")\n";
    }
}
