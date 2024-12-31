package org.example.model;

public class NeuralNetworkRegressor extends RegressionModel {

    public NeuralNetworkRegressor() {
        super("Neural Network Regressor");
    }

    @Override
    public String recommendModel() {
        return modelName + " is the recommended model.";
    }

    @Override
    public String describeModel() {
        return "A Neural Network Regressor is a supervised learning algorithm that predicts continuous " +
                "values by modeling complex relationships using layers of interconnected neurons. " +
                "It is powerful for handling non-linear data but requires a significant amount of " +
                "computational resources and is prone to overfitting without regularization.\n" +
                "\n" +
                "Example Code: \n" +
                "# Import necessary libraries\n" +
                "from sklearn.neural_network import MLPRegressor\n" +
                "from sklearn.datasets import make_regression\n" +
                "from sklearn.model_selection import train_test_split\n" +
                "from sklearn.metrics import mean_squared_error\n" +
                "\n" +
                "# Generate sample regression data\n" +
                "X, y = make_regression(n_samples=200, n_features=5, noise=0.1, random_state=42)\n" +
                "\n" +
                "# Split the data into training and testing sets\n" +
                "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)\n" +
                "\n" +
                "# Train a Neural Network Regressor\n" +
                "nn_regressor = MLPRegressor(hidden_layer_sizes=(100, 50), max_iter=500, random_state=42)\n" +
                "nn_regressor.fit(X_train, y_train)\n" +
                "\n" +
                "# Predict on the test set\n" +
                "y_pred = nn_regressor.predict(X_test)\n" +
                "\n" +
                "# Calculate Mean Squared Error\n" +
                "mse = mean_squared_error(y_test, y_pred)\n" +
                "print(f\"Mean Squared Error: {mse:.2f}\")\n";
    }
}