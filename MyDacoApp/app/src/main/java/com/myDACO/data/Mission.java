package com.myDACO.data;
import com.myDACO.MissionActivity;
import com.myDACO.utilities.FirestoreQuery;

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
    public List<Planes> bumpPlan(List<Planes> planes, PriorityQueue<Personnel> personnel, PriorityQueue<Cargo> cargo, FirestoreQuery fq) {
        for (Planes p : planes) {
            while (p.getPersonnelCount() < p.getPersonnelCapacity() && !personnel.isEmpty()) {
                fq.reassignPersonnel(personnel.poll(), p);
                p.setPersonnelCount(p.getPersonnelCount() + 1);
            }


            while (p.getCargoCapacity() < p.getCargoCapacity() && !cargo.isEmpty()) {
                Cargo currCargo = cargo.poll();
                fq.reassignCargo(currCargo, p);
                p.setCargoWeight(currCargo.getWeight() + p.getCargoWeight());
            }

        }

        return null;
    }


}
