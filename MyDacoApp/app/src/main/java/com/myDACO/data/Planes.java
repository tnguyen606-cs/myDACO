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

    public Planes(String plane, String id, boolean isActive, List<Personnel> assignedPersonnel, int personnelCount, int personnelCapacity, List<Cargo> assignedCargo, int cargoWeight, int cargoCapacity) {
        this.planeName = plane;
        this.id = id;
        this.isActive = isActive;
        this.assignedPersonnel = assignedPersonnel;
        this.personnelCount = personnelCount;
        this.personnelCapacity = personnelCapacity;
        this.assignedCargo = assignedCargo;
        this.cargoWeight = cargoWeight;
        this.cargoCapacity = cargoCapacity;
    }

    public Planes(String plane, String id) {
        this.planeName = plane;
        this.id = id;
    }

    public String getPlane() {
        return this.planeName;
    }

    public void setPlane(String name) {
        this.planeName = name;
    }

    public String getPlaneId() {
        return this.id;
    }

    public void setPlaneId(String id) {
        this.id = id;
    }

    public void setIsActive(boolean selected) {
        this.isActive = selected;
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
}
