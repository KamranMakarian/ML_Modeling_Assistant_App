package org.example.model;

public class DecisionTreeClassifier extends ClassificationModel {

    public DecisionTreeClassifier() {
        super("Decision Tree Classifier");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Decision Tree Classifier is a supervised machine learning algorithm that splits" +
                " data into subsets based on feature values to classify target labels. It is easy to" +
                " interpret and suitable for both small and large datasets but prone to overfitting" +
                " without pruning.\n" +
                "\n" +
                "Code Example:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.tree import DecisionTreeClassifier\n" +
                "from sklearn.datasets import load_iris\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import accuracy_score\n" +
                "\n" +
                "# Load the Iris dataset\n" +
                "data = load_iris()\n" +
                "X = data.data\n" +
                "y = data.target\n" +
                "\n" +
                "# Split the dataset into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Decision Tree Classifier\n" +
                "classifier = DecisionTreeClassifier(max_depth=3, random_state=42)\n" +
                "classifier.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = classifier.predict(X_test)\n" +
                "\n" +
                "# Calculate accuracy\n" +
                "accuracy = accuracy_score(y_test, y_pred)\n" +
                "print(f\"Accuracy: {accuracy:.2f}\")\n";
    }
}
