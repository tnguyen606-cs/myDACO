package com.myDACO.data;

import android.app.Person;

import java.io.Serializable;

public class Personnel implements Serializable {
    private String firstName;
    private String lastName;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private int priority;
    private int weight;
    private String id;
    private boolean manualAssign;



    public Personnel() {}


    public Personnel(String firstName, String lastName, int priority, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
        this.manualAssign = false;
    }
    public Personnel(String firstName, String lastName, String assignedPlaneID, int priority, int weight, String id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.weight = weight;
        this.assignedPlaneID = assignedPlaneID;
        this.id = id;
        this.weight = weight;
        this.bumpPlaneID = bumpPlaneID;
        this.manualAssign = false;
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

    public boolean isManualAssign() {
        return manualAssign;
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

    public void setManualAssign(boolean manualAssign) {
        this.manualAssign = manualAssign;
    }

    /*
     * This method checks if whether it is a same assigned Personnel
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Personnel) {
            Personnel otherPer = (Personnel) o;
            return this.firstName.equals(otherPer.getFirstName())
                    && this.lastName.equals(otherPer.getLastName())
                    && this.assignedPlaneID.equals(otherPer.getAssignedPlaneID())
                    && this.id.equals(otherPer.getId())
                    && (this.priority == otherPer.getPriority())
                    && (this.weight == otherPer.getWeight());
        }
        return false;

    }
}
