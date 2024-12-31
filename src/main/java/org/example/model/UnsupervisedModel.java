package org.example.model;

public abstract class UnsupervisedModel extends MLModel {

    public UnsupervisedModel(String modelName, String modelFunction) {
        super(modelName, modelFunction, "Unsupervised");
    }
}
