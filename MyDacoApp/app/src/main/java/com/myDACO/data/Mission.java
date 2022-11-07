package com.myDACO.data;
import com.myDACO.MissionActivity;

import java.io.Serializable;
import java.util.*;

public class Mission implements Serializable {
    private List<Planes> missionPlanes;
    private PriorityQueue cargos = new PriorityQueue<Cargo>();
    private PriorityQueue personnels = new PriorityQueue<Personnel>();


    public Mission() {
    }

    public Mission(List<Planes> planes) {
        missionPlanes = planes;
        //append personnels PQ using fq
        //append cargos PQ using fq
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
        for (Planes p : missionPlanes) {
            //while planes not full && personnel is not empty
                //fq.reassign(personnel.pop(), plane)
            //while personnel is empty && cargo not empty && planes not full
                //fq.reassign(cargo.pop(),plane)
        }
    }


}
