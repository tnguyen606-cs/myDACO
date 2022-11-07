package com.myDACO.data;

import java.io.Serializable;

public class Personnel implements Serializable {
    private String firstName;
    private String lastName;
    private String priority;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private String weight;
    private String id;

    public Personnel() {}

    public Personnel(String firstName, String lastName, String assignedPlaneID, String id, String priority, String weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.id = id;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPriority() {
        return priority;
    }

    public String getWeight() {
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

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setWeight(String weight) {
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
