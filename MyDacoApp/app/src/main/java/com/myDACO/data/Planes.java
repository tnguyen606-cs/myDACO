package com.myDACO.data;

public class Planes {
    private String plane;
    private String id;
    private boolean isActive;

    public Planes(String plane, String id) {
        this.plane = plane;
        this.id = id;
    }

    public String getPlane() {
        return this.plane;
    }

    public void setPlane(String name) {
        this.plane = name;
    }

    public String getPlaneId() {
        return this.id;
    }

    public void setPlaneId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setIsActive(boolean selected) {
        this.isActive = selected;
    }
}
