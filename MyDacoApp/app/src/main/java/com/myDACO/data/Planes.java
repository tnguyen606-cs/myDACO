package com.myDACO.data;
import java.util.*;

public class Planes {
    private String planeName;
    private String id;
    private boolean isActive;
    private List<Personnel> assignedPersonnel;
    private int personnelCount;
    private int personnelCapacity;
    private List<Cargo> assignedCargo;
    private int cargoWeight;
    private int cargoCapacity;

    public Planes() {}


    public Planes(String planeName, String id, boolean isActive, List<Cargo> assignedCargo, List<Personnel> assignedPersonnel) {

        this.planeName = planeName;
        this.id = id;
        this.isActive = isActive;
        this.assignedPersonnel = assignedPersonnel;
        this.assignedCargo = assignedCargo;
    }

    public Planes(String planeName, String id, boolean isActive, List<Personnel> assignedPersonnel, int personnelCount, int personnelCapacity, List<Cargo> assignedCargo, int cargoWeight, int cargoCapacity) {

        this.planeName = planeName;
        this.id = id;
        this.isActive = isActive;
        this.assignedPersonnel = assignedPersonnel;
        this.assignedCargo = assignedCargo;
        this.personnelCapacity = personnelCapacity;
        this.personnelCount = personnelCount;
        this.cargoCapacity = cargoCapacity;
        this.cargoWeight = cargoWeight;
    }

    public Planes(String planeName, String id) {
        this.planeName = planeName;
        this.id = id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Personnel> getAssignedPersonnel() {
        return assignedPersonnel;
    }

    public int getPersonnelCount() {
        return personnelCount;
    }

    public int getPersonnelCapacity() {
        return personnelCapacity;
    }

    public List<Cargo> getAssignedCargo() {
        return assignedCargo;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAssignedPersonnel(List<Personnel> assignedPersonnel) {
        this.assignedPersonnel = assignedPersonnel;
    }

    public void setPersonnelCount(int personnelCount) {
        this.personnelCount = personnelCount;
    }

    public void setPersonnelCapacity(int personnelCapacity) {
        this.personnelCapacity = personnelCapacity;
    }

    public void setAssignedCargo(List<Cargo> assignedCargo) {
        this.assignedCargo = assignedCargo;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
