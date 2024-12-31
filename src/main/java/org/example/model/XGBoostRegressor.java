package org.example.model;

public class XGBoostRegressor extends RegressionModel {

    public XGBoostRegressor() {
        super("XGBoost Regressor");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "The XGBoost Regressor is a supervised learning algorithm that uses gradient boosting " +
                "with decision trees to predict continuous values. It is fast, highly accurate, " +
                "and handles large datasets well but can be prone to overfitting if hyperparameters " +
                "are not tuned properly.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from xgboost import XGBRegressor\n" +
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
                "# Train an XGBoost Regressor\n" +
                "xgb_regressor = XGBRegressor(n_estimators=100, max_depth=5, learning_rate=0.1, random_state=42)\n" +
                "xgb_regressor.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = xgb_regressor.predict(X_test)\n" +
                "\n" +
                "# Calculate Mean Squared Error\n" +
                "mse = mean_squared_error(y_test, y_pred)\n" +
                "print(f\"Mean Squared Error: {mse:.2f}\")\n";
    }
}