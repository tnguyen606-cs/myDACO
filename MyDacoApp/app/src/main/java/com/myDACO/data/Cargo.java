package com.myDACO.data;

import java.io.Serializable;

public class Cargo implements Serializable {
    private String cargoName;
    private int weight;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private String id;

    public Cargo() {}

    public Cargo(String cargoName, String id, int weight) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.id = id;
    }

    public Cargo(String cargoName, String id, int weight, String assignedPlaneID) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.id = id;
    }

    public Cargo(String cargoName, String id, int weight, String assignedPlaneID, String bumpPlaneID) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public int getWeight() {
        return weight;
    }

    public String getAssignedPlaneID() {
        return assignedPlaneID;
    }

    public String getBumpPlaneID() {
        return bumpPlaneID;
    }

    public String getId(){return id;}

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAssignedPlaneID(String assignedPlaneID) {
        this.assignedPlaneID = assignedPlaneID;
    }

    public void setBumpPlaneID(String bumpPlaneID) {
        this.bumpPlaneID = bumpPlaneID;
    }

    public void setId(String id) {this.id = id;}

    public String toString() {
        return cargoName;
    }
}

