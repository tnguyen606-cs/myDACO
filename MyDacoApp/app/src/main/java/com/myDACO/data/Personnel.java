package com.myDACO.data;

public class Personnel {
    private String firstName;
    private String lastName;
    private int priority;
    private Planes assignedPlane;
    private Planes bumpPlane;

    public Personnel()
    {}

    public Personnel(String firstName, String lastName, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = 0;
        this.assignedPlane = assignedPlane;
        this.bumpPlane = bumpPlane;
    }

    public Personnel(String firstName, String lastName, int priority, Planes assignedPlane, Planes bumpPlane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.assignedPlane = assignedPlane;
        this.bumpPlane = bumpPlane;
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

    public Planes getAssignedPlane() {
        return assignedPlane;
    }

    public Planes getBumpPlane() {
        return bumpPlane;
    }
}
