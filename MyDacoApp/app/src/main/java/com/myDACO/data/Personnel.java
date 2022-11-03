package com.myDACO.data;

import java.io.Serializable;

public class Personnel implements Serializable {
    private String firstName;
    private String lastName;
    private int priority;
    private String assignedPlaneID;
    private String bumpPlaneID;
    private String id;
    private boolean manualAssign;

    public Personnel() {}

    public Personnel(String firstName, String lastName, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = 0;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
        this.manualAssign = false;
    }

    public Personnel(String firstName, String lastName, int priority, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.assignedPlaneID = assignedPlaneID;
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

    public void setAssignedPlaneID(String assignedPlaneID) {
        this.assignedPlaneID = assignedPlaneID;
    }

    public void setBumpPlaneID(String bumpPlaneID) {
        this.bumpPlaneID = bumpPlaneID;
    }

    public void setId(String id) {this.id = id;}

    public void setManualAssign(boolean manualAssign) {
        this.manualAssign = manualAssign;
    }
}
