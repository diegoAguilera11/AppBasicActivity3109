package com.proyectos_2022.appbasicactivity.model;

public class Operation {
    private String nameOperation;
    private int imageOperation;

    public Operation(String nameOperation, int imageOperation) {
        this.nameOperation = nameOperation;
        this.imageOperation = imageOperation;
    }

    public String getNameOperation() {
        return this.nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }

    public int getImageOperation() {
        return this.imageOperation;
    }

    public void setImageOperation(int imageOperation) {
        this.imageOperation = imageOperation;
    }
}
