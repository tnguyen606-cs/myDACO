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

    public BumpResult bumpPlan(List<Planes> activePlanes, List<Planes> downedPlanes, PriorityQueue<Personnel> personnel, PriorityQueue<Cargo> cargo, FirestoreQuery fq) {
        ArrayList<Personnel> reassignedPersonnel = new ArrayList<Personnel>();
        ArrayList<Cargo> reassignedCargo = new ArrayList<Cargo>();

        BumpResult result = new BumpResult(0, downedPlanes, reassignedPersonnel, reassignedCargo);
        result.setDownedPlanes(downedPlanes);

        for (Planes p : activePlanes) {
            while (p.getPersonnelCount() < p.getPersonnelCapacity() && !personnel.isEmpty()) {
                Personnel currPersonnel = personnel.poll();
                fq.reassignPersonnel(currPersonnel, p.getId());
                p.setPersonnelCount(p.getPersonnelCount() + 1);

                result.addReassignedPersonnel(currPersonnel);
            }

            while (p.getCargoWeight() < p.getCargoCapacity() && !cargo.isEmpty()) {
                Cargo currCargo = cargo.poll();
                fq.reassignCargo(currCargo, p.getId());
                p.setCargoWeight(currCargo.getWeight() + p.getCargoWeight());

                result.addReassignedCargo(currCargo);
            }
        }
        if (!personnel.isEmpty() || !cargo.isEmpty()) {
            result.setCode(-1);
        }

        return result;
    }


}
