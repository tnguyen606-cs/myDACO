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

    public int bumpPlan(List<Planes> planes, PriorityQueue<Personnel> personnel, PriorityQueue<Cargo> cargo, FirestoreQuery fq) {
        for (Planes p : planes) {
            while (p.getPersonnelCount() < p.getPersonnelCapacity() && !personnel.isEmpty()) {
                fq.reassignPersonnel(personnel.poll(), p.getId());
                p.setPersonnelCount(p.getPersonnelCount() + 1);
            }


            while (p.getCargoWeight() < p.getCargoCapacity() && !cargo.isEmpty()) {
                Cargo currCargo = cargo.peek();
                fq.reassignCargo(cargo.poll(), p.getId());
                p.setCargoWeight(currCargo.getWeight() + p.getCargoWeight());
            }
        }
        if (!personnel.isEmpty() || !cargo.isEmpty()) {
            return -1;
        }

        return 0;
    }


}
