package com.myDACO.data;
import java.io.Serializable;
import java.util.*;

public class Planes implements Serializable {
    private String planeName;
    private String id;
    private boolean active;
    private boolean onMission;
    private List<Personnel> assignedPersonnel;
    private int personnelCount;
    private int personnelCapacity;
    private List<Cargo> assignedCargo;
    private int cargoWeight;
    private int cargoCapacity;

    public Planes() {}


    public Planes(String planeName, String id, boolean active, boolean onMission, List<Cargo> assignedCargo, List<Personnel> assignedPersonnel) {
        this.planeName = planeName;
        this.id = id;
        this.active = active;
        this.onMission = onMission;
        this.assignedPersonnel = assignedPersonnel;
        this.assignedCargo = assignedCargo;
    }

    public Planes(String planeName, String id, boolean active, boolean onMission, List<Personnel> assignedPersonnel, int personnelCount, int personnelCapacity, List<Cargo> assignedCargo, int cargoWeight, int cargoCapacity) {

        this.planeName = planeName;
        this.id = id;
        this.active = active;
        this.onMission = onMission;
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

    public boolean isActive() {return active;}

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

    public void setActive(boolean active) { this.active = active; }

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

    public boolean isOnMission() {
        return onMission;
    }

    public void setOnMission(boolean onMission) {
        this.onMission = onMission;
    }

    @Override
    public String toString() {
        return planeName;
    }

}
