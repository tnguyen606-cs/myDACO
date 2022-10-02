package com.myDACO.data;

public class Personnel {
    private String firstName;
    private String lastName;
    private int priority;
    private String assignedPlaneID;
    private String bumpPlaneID;

    public Personnel() {}

    public Personnel(String firstName, String lastName, String assignedPlaneID, String bumpPlaneID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = 0;
        this.assignedPlaneID = assignedPlaneID;
        this.bumpPlaneID = bumpPlaneID;
    }

    public Personnel(String firstName, String lastName, int priority, String assignedPlaneID, String bumpPlaneID) {
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
}
