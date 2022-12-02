package com.myDACO.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BumpResult implements Serializable {
    int code; // 0 = full bump, 1 = partial bump (some personnel/cargo left unassigned)
    List<Personnel> reassignedPersonnel;
    List<Cargo> reassignedCargo;
    List<Planes> downedPlanes;

    public BumpResult(int code, List<Planes> downedPlanes, List<Personnel> reassignedPersonnel,
                      List<Cargo> reassignedCargo) {
        this.code = code;
        this.downedPlanes = downedPlanes;
        this.reassignedPersonnel = reassignedPersonnel;
        this.reassignedCargo = reassignedCargo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Personnel> getReassignedPersonnel() {
        return reassignedPersonnel;
    }

    public void setReassignedPersonnel(List<Personnel> reassignedPersonnel) {
        this.reassignedPersonnel = reassignedPersonnel;
    }

    public List<Cargo> getReassignedCargo() {
        return reassignedCargo;
    }

    public void setReassignedCargo(List<Cargo> reassignedCargo) {
        this.reassignedCargo = reassignedCargo;
    }

    public List<Planes> getDownedPlanes() {
        return downedPlanes;
    }

    public void setDownedPlanes(List<Planes> downedPlanes) {
        this.downedPlanes = downedPlanes;
    }

    public void addReassignedCargo(Cargo cargo) {
        reassignedCargo.add(cargo);
    }

    public void addReassignedPersonnel(Personnel personnel) {
        reassignedPersonnel.add(personnel);
    }
}
