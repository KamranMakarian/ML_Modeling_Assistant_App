package org.example.model;

public abstract class MLModel {
    public String modelName;
    public String modelFunction;
    public String modelType;

    public MLModel(String modelName, String modelFunction, String modelType) {
        this.modelName = modelName;
        this.modelFunction = modelFunction;
        this.modelType = modelType;
    }

    public abstract String recommendModel();

    public abstract String describeModel();
}
