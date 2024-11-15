package com.example.model;


public class CarWagon extends Wagon{
    private int capacity;
    // GET
    public int getCapacity() {
        return capacity;
    }
    //SET
    public void setCapacity() {
        this.capacity = capacity;
    }
    //CONSTRUCTOR
    public CarWagon(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }
    //STRING
    public String toString() {
        return "Платформа для автомобилей" + "\t" + super.toString() + "\t" + capacity + " шт.";
    }
}
