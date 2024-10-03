package com.example.model;

public class BulkWagon extends Wagon {
    public BulkWagon() {
        super("Цистерна для сыпучих грузов");
    }

    @Override
    public boolean canLoad(Product product) {
        return product instanceof Bulk;
    }
}