package com.example.model;

public abstract class Wagon {
    protected String type;

    public Wagon(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract boolean canLoad(Product product);
}
