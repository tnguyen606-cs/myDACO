package com.myDACO.data;

public class Personnel {
    private String name;
    private int priority;
    private Planes assignedPlane;
    private Planes bumpPlane;

    public Personnel() {}

    public Personnel(String name, Planes assignedPlane, Planes bumpPlane) {
        this.name = name;
        this.priority = 0;
        this.assignedPlane = assignedPlane;
        this.bumpPlane = bumpPlane;
    }

    public Personnel(String name, int priority, Planes assignedPlane, Planes bumpPlane) {
        this.name = name;
        this.priority = priority;
        this.assignedPlane = assignedPlane;
        this.bumpPlane = bumpPlane;
    }

    public String getPersonnelName() {
        return name;
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
