package com.myDACO.data;
import java.util.*;

public class Planes {
    private String planeName;
    private String id;
    private boolean isActive;
    private List<String> assignedPersonnel;
    private int personnelCount;
    private int personnelCapacity;
    private List<String> assignedCargo;
    private int cargoWeight;
    private int cargoCapacity;

    public Planes() {}

    public Planes(String plane, String id, List<String> assignedCargo, List<String> assignedPersonnel) {
        this.planeName = plane;
        this.id = id;
        this.assignedPersonnel = assignedPersonnel;
        this.assignedCargo = assignedCargo;
    }

    public String getPlane() {
        return planeName;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getAssignedPersonnel() {
        return assignedPersonnel;
    }

    public int getPersonnelCount() {
        return personnelCount;
    }

    public int getPersonnelCapacity() {
        return personnelCapacity;
    }

    public List<String> getAssignedCargo() {
        return assignedCargo;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }
}
