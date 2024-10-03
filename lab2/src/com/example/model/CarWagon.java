package com.example.model;

public class CarWagon extends Wagon {
    public CarWagon() {
        super("Автомобильная платформа");
    }

    @Override
    public boolean canLoad(Product product) {
        return product instanceof Car;
    }
}