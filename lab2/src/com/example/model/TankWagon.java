package com.example.model;

public class TankWagon extends Wagon {
    public TankWagon() {
        super("Цистерна для жидкостей");
    }

    @Override
    public boolean canLoad(Product product) {
        return product instanceof Liquid;
    }
}