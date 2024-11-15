package com.example.model;


import java.io.Serializable;

public abstract class Wagon implements Serializable {
    protected String cargoName;
    //GET
    public String getCargoName() {return cargoName;}
    //SET
    public void setCargoName() {this.cargoName = cargoName;}
    //CONSTRUCTOR
    protected Wagon(String cargoName) {
        this.cargoName = cargoName;
    }
    //STRING
    public String toString() {
        return cargoName;
    }
}
