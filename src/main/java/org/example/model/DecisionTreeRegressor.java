package org.example.model;

public class DecisionTreeRegressor extends RegressionModel {

    public DecisionTreeRegressor() {
        super("Decision Tree Regressor");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Decision Tree Regressor is a supervised machine learning algorithm that" +
                " predicts continuous values by partitioning data based on feature values." +
                " It works well for non-linear relationships but can overfit, especially with deep trees.\n" +
                "\n" +
                "Code Example:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.tree import DecisionTreeRegressor\n" +
                "from sklearn.datasets import fetch_california_housing\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import mean_squared_error\n" +
                "\n" +
                "# Load the California Housing dataset\n" +
                "data = fetch_california_housing()\n" +
                "X = data.data\n" +
                "y = data.target\n" +
                "\n" +
                "# Split the dataset into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Decision Tree Regressor\n" +
                "regressor = DecisionTreeRegressor(max_depth=5, random_state=42)\n" +
                "regressor.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = regressor.predict(X_test)\n" +
                "\n" +
                "# Calculate Mean Squared Error\n" +
                "mse = mean_squared_error(y_test, y_pred)\n" +
                "print(f\"Mean Squared Error: {mse:.2f}\")\n";
    }
}
