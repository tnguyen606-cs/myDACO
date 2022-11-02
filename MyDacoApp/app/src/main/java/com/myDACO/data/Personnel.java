package com.myDACO.data;

import java.io.Serializable;

public class Personnel implements Serializable {
    private String firstName;
    private String lastName;
    private int priority;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private int weight;
    private String id;

    public Personnel() {}

    public Personnel(String firstName, String lastName, int priority, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }
    public Personnel(String firstName, String lastName, String assignedPlaneID, int priority, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.assignedPlaneID = assignedPlaneID;
        this.id = id;
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

    public int getWeight() {
        return this.weight;
    }

    public String getAssignedPlaneID() {
        return assignedPlaneID;
    }

    public String getBumpPlaneID() {
        return bumpPlaneID;
    }

    public String getId() {return id;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        return firstName + " " + lastName;
    }
}
