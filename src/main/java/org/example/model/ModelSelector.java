package org.example.model;

import java.util.Set;

public class ModelSelector {

    public static MLModel autoSelectModel(DatasetProcessor datasetProcessor,
                                          boolean targetVariableKnown,
                                          boolean targetVariableNumerical) {

        Set<String> numericalFeatures = datasetProcessor.getNumericalFeatures();
        Set<String> categoricalFeatures = datasetProcessor.getCategoricalFeatures();
        Set<Integer> rowsWithMissingValues = datasetProcessor.getRowsWithMissingValue();
        int numberOfFeatures = datasetProcessor.getNumberOfFeatures();
        int numberOfRows = datasetProcessor.getNumberOfRows();

        if (targetVariableKnown) {
            // Supervised Learning
            if (targetVariableNumerical) {
                // Regression
                if (numberOfRows > 5000 || numberOfFeatures > 50) {
                    return new RandomForestRegressor(); // Large dataset or many features
                } else if (numberOfFeatures > 20) {
                    return new XGBoostRegressor(); // Medium-sized dataset
                } else if (!rowsWithMissingValues.isEmpty()) {
                    return new DecisionTreeRegressor(); // Handles missing data well
                } else if (numberOfRows >= 10000) {
                    return new NeuralNetworkRegressor(); // For complex relationships in large datasets
                } else {
                    return new LinearRegression(); // Simple regression for smaller datasets
                }
            } else {
                // Classification
                if (numberOfRows > 5000 || numberOfFeatures > 50) {
                    return new RandomForestClassifier(); // Large dataset or many features
                } else if (numberOfFeatures > 20) {
                    return new XGBoostClassifier(); // Medium-sized dataset
                } else if (!rowsWithMissingValues.isEmpty()) {
                    return new DecisionTreeClassifier(); // Handles missing data well
                } else if (numberOfRows > 10000) {
                    return new NeuralNetworkClassifier(); // For complex relationships in large datasets
                } else {
                    return new LogisticRegression(); // Simple classification for smaller datasets
                }
            }
        } else {
            // Unsupervised Learning
            if (numericalFeatures.size() > 20) {
                return new PCA(); // Dimensionality reduction for large feature sets
            } else if (numberOfRows > 1000) {
                return new DBSCAN(); // Clustering for noisy datasets or varying density
            } else if (!numericalFeatures.isEmpty() && categoricalFeatures.isEmpty()) {
                return new KMeans(); // Clustering for clean numerical data
            } else {
                return null; // No recommendation for this scenario
            }
        }
    }
}
