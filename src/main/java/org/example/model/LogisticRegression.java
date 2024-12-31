package org.example.model;

public class LogisticRegression extends ClassificationModel {

    public LogisticRegression() {
        super("Logistic Regression");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "Logistic Regression is a supervised learning algorithm used for binary or " +
                "multi-class classification. It models the probability of class membership " +
                "using a sigmoid function and works well for linearly separable data but " +
                "may require regularization to avoid overfitting.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "from sklearn.datasets import make_classification\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import accuracy_score\n" +
                "\n" +
                "# Generate sample classification data\n" +
                "X, y = make_classification(n_samples=200, n_features=2, n_classes=2, random_state=42)\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Logistic Regression model\n" +
                "logistic_reg = LogisticRegression()\n" +
                "logistic_reg.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = logistic_reg.predict(X_test)\n" +
                "\n" +
                "# Calculate accuracy\n" +
                "accuracy = accuracy_score(y_test, y_pred)\n" +
                "print(f\"Accuracy: {accuracy:.2f}\")\n";
    }
}

