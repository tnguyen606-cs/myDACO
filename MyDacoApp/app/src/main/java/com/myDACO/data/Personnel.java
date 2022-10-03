package com.myDACO.data;

public class Personnel {
    private String name;
    private int priority;
    private String assignedPlaneID;
    private String bumpPlaneID;

    public Personnel() {}

    public Personnel(String name, Planes assignedPlane, Planes bumpPlane) {
        this.name = name;
        this.priority = 0;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }

    public Personnel(String name, int priority, Planes assignedPlane, Planes bumpPlane) {
        this.name = name;
        this.priority = priority;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }

    public String getPersonnelName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getAssignedPlaneID() {
        return assignedPlaneID;
    }

    public String getBumpPlaneID() {
        return bumpPlaneID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setAssignedPlaneID(String assignedPlaneID) {
        this.assignedPlaneID = assignedPlaneID;
    }

    public void setBumpPlaneID(String bumpPlaneID) {
        this.bumpPlaneID = bumpPlaneID;
    }
}
