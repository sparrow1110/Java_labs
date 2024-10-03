package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<Wagon> wagons;

    public Train() {
        this.wagons = new ArrayList<>();
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public Product loadProduct(Product product) {
        for (Wagon wagon : wagons) {
            if (wagon.canLoad(product)) {
                System.out.println("Загрузили " + product.getName() + " в " + wagon.getType());
                return product;
            }
        }
        System.out.println("Нет подоходящего вагона для" + product.getName());
        return null;
    }
}
