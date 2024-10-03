package com.example.model;

public class ContainerWagon extends Wagon {
    public ContainerWagon() {
        super("Платформа для контейнеров");
    }

    @Override
    public boolean canLoad(Product product) {
        return product instanceof Container;
    }
}