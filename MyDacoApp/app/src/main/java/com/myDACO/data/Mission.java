package com.myDACO.data;
import java.io.Serializable;
import java.util.*;

public class Mission implements Serializable {
    private List<Planes> missionPlanes;

    public Mission() {}

    public Mission(List<Planes> planes) {
        missionPlanes = planes;
    }

    public List<Planes> getMissionPlanes() {
        return missionPlanes;
    }

    public void setMissionPlanes(List<Planes> planes){
        this.missionPlanes = planes;
    }

    public void addPlane(Planes plane) {
        this.missionPlanes.add(plane);
    }

    //TODO: Implement bump plan method
    public List<Planes> bumpPlan(List<Planes> planes) {
        return null;
    }


}
