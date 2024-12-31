package org.example.model;

public abstract class SupervisedModel extends MLModel {

    public SupervisedModel(String modelName, String modelFunction) {
        super(modelName, modelFunction, "Supervised");
    }
}