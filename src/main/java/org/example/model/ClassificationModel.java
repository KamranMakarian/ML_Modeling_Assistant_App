package org.example.model;

public abstract class ClassificationModel extends SupervisedModel {

    public ClassificationModel(String modelName) {
        super(modelName, "Classification");
    }
}
