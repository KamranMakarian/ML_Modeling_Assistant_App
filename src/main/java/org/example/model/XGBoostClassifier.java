package org.example.model;

public class XGBoostClassifier extends ClassificationModel {

    public XGBoostClassifier() {
        super("XGBoost Classifier");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "The XGBoost Classifier is a supervised learning algorithm based on gradient " +
                "boosting that builds an ensemble of decision trees to classify data. " +
                "It is highly efficient, scalable, and performs well with structured data but " +
                "requires careful tuning and may overfit if not regularized.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from xgboost import XGBClassifier\n" +
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
                "# Train an XGBoost Classifier\n" +
                "xgb_classifier = XGBClassifier(n_estimators=100, max_depth=5, learning_rate=0.1, random_state=42)\n" +
                "xgb_classifier.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = xgb_classifier.predict(X_test)\n" +
                "\n" +
                "# Calculate accuracy\n" +
                "accuracy = accuracy_score(y_test, y_pred)\n" +
                "print(f\"Accuracy: {accuracy:.2f}\")\n";
    }
}