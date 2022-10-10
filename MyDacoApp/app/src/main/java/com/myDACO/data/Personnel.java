package com.myDACO.data;

public class Personnel {
    private String firstName;
    private String lastName;
    private int priority;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private int id;

    public Personnel() {}

    public Personnel(String firstName, String lastName, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = 0;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }

    public Personnel(String firstName, String lastName, int priority, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public int getId() {return id;}

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

    public void setId(int id) {this.id = id;}

}
