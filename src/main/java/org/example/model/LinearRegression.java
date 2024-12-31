package org.example.model;

public class LinearRegression extends RegressionModel {

    public LinearRegression() {
        super("Linear Regression");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "Linear Regression is a supervised learning algorithm that models the relationship" +
                " between features and a continuous target using a linear equation." +
                " It is interpretable and works well for linearly separable data but performs" +
                " poorly with complex, nonlinear relationships.\n" +
                "\n" +
                "Example Code:\n" +
                "# Import necessary libraries\n" +
                "from sklearn.linear_model import LinearRegression\n" +
                "from sklearn.datasets import make_regression\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import mean_squared_error\n" +
                "\n" +
                "# Generate sample regression data\n" +
                "X, y = make_regression(n_samples=200, n_features=1, noise=10, random_state=42)\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Linear Regression model\n" +
                "linear_reg = LinearRegression()\n" +
                "linear_reg.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = linear_reg.predict(X_test)\n" +
                "\n" +
                "# Calculate Mean Squared Error\n" +
                "mse = mean_squared_error(y_test, y_pred)\n" +
                "print(f\"Mean Squared Error: {mse:.2f}\")\n";
    }
}