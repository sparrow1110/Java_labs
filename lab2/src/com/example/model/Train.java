package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Класс железнодорожного состава.
 */
public class Train {
    private List<Wagon> wagons;

    /**
     * Конструктор для создания состава.
     */
    public Train() {
        this.wagons = new ArrayList<>();
    }

    /**
     * Добавляет вагон в состав.
     *
     * @param wagon Вагон для добавления.
     */
    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }

    /**
     * Возвращает список вагонов в составе.
     *
     * @return Список вагонов.
     */
    public List<Wagon> getWagons() {
        return wagons;
    }

    /**
     * Сортирует вагоны по возрастанию грузоподъемности
     */
    public void sort_Wagon () {
        wagons.sort(Comparator.comparingDouble(Wagon::getCapacity));
    }

    /**
     * Загружает продукт в вагон.
     *
     * @param product Продукт для загрузки.
     * @return Загруженный продукт, если вагон найден, иначе null.
     */
    public Product loadProduct(Product product) {
        for (Wagon wagon : wagons) {
            if (wagon.canLoad(product) && !wagon.isLoaded() && wagon.getCapacity() >= product.getWeight()) {

                wagon.setLoaded(true);
                System.out.println("Загрузили " + product.getName() + " в " + wagon.getType());
                return product;
            }
        }
        System.out.println("Нет подоходящего вагона для" + product.getName());
        return null;
    }
}
