package com.example.view;

import com.example.model.Warehouse;
import com.example.model.Train;
import com.example.model.Product;
import com.example.model.Wagon;

/**
 * Класс для отображения состава поезда и склада продукции.
 */
public class TrainView {
    /**
     * Отображает состав поезда.
     *
     * @param train Состав поезда.
     */
    public void displayTrain(Train train) {
        System.out.println("");
        System.out.println("Состав поезда: ");
        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.getType() + " (Грузоподъемность: " + wagon.getCapacity() + ", Загружено: " + wagon.isLoaded() + ")");
        }
        System.out.println("");
    }

    /**
     * Отображает содержимое склада.
     * @param warehouse Склад продукции.
     */
    public void displayWarehouse(Warehouse warehouse) {
        System.out.println("Склад:");
        if (warehouse.getProducts().isEmpty()) {
            System.out.println("Пустой");
        }
        else {
            for (Product product : warehouse.getProducts()) {
                System.out.println(product.getName() + " (Вес: " + product.getWeight() + ")");
            }
            System.out.println("");
        }
    }
}

