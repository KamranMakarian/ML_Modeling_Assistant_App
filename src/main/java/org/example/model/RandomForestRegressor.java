package org.example.model;

public class RandomForestRegressor extends RegressionModel {

    public RandomForestRegressor() {
        super("Random Forest Regressor");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Random Forest Regressor is a supervised ensemble learning algorithm that uses " +
                "multiple decision trees to predict continuous values by averaging their outputs. " +
                "It is robust to overfitting, works well with missing data, and handles complex " +
                "relationships, but requires more computation.\n" +
                "\n"+
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.ensemble import RandomForestRegressor\n" +
                "from sklearn.datasets import fetch_california_housing\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import mean_squared_error\n" +
                "\n" +
                "# Load the California Housing dataset\n" +
                "data = fetch_california_housing()\n" +
                "X = data.data\n" +
                "y = data.target\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Random Forest Regressor\n" +
                "rf_regressor = RandomForestRegressor(n_estimators=100, max_depth=10, random_state=42)\n" +
                "rf_regressor.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = rf_regressor.predict(X_test)\n" +
                "\n" +
                "# Calculate Mean Squared Error\n" +
                "mse = mean_squared_error(y_test, y_pred)\n" +
                "print(f\"Mean Squared Error: {mse:.2f}\")\n";
    }
}