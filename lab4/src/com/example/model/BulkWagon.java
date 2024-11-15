package com.example.model;


public class BulkWagon extends Wagon {
    private float capacity;
    // GET
    public float getCapacity() {
        return capacity;
    }
    //SET
    public void setCapacity() {
        this.capacity = capacity;
    }
    //CONSTRUCTOR
    public BulkWagon(String cargoName, float capacity) {
        super(cargoName);
        this.capacity = capacity;
    }
    //STRING
    public String toString() {
        return "Вагон для сыпучих грузов" + "\t" + super.toString() + "\t" + + capacity + " кг";
    }
}

