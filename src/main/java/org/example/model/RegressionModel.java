package org.example.model;

public abstract class RegressionModel extends SupervisedModel {

    public RegressionModel(String modelName) {
        super(modelName, "Regression");
    }
}