package com.example.model;


public class TankWagon extends Wagon{
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
    public TankWagon(String cargoName, float capacity) {
        super(cargoName);
        this.capacity = capacity;
    }
    //STRING
    public String toString() {
        return "Цистерна" + "\t" + super.toString() + "\t" + capacity + " л";
    }
}

