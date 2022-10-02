package com.myDACO.data;

public class Cargo {
    private String cargoName;
    private int weight;
    private Planes assignedPlane;
    private Planes bumpPlane;

    public Cargo() {}

    public Cargo(String cargoName, int weight) {
        this.cargoName = cargoName;
        this.weight = weight;
    }

    public Cargo(String cargoName, int weight, Planes assignedPlane) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.assignedPlane = assignedPlane;
    }

    public Cargo(String cargoName, int weight, Planes assignedPlane, Planes bumpPlane) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.assignedPlane = assignedPlane;
        this.bumpPlane = bumpPlane;
    }

    public String getCargoName() {
        return cargoName;
    }

    public int getWeight() {
        return weight;
    }

    public Planes getAssignedPlane() {
        return assignedPlane;
    }

    public Planes getBumpPlane() {
        return bumpPlane;
    }
}
