package com.myDACO.utilities;
import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.myDACO.data.*;

import java.util.*;

public class FirestoreQuery {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference planeRef = db.collection("planes");

    public Planes addPlane(Planes plane) {
        // Adds a plane to the "planes" collection in Firestore
        // Uniqueness check of plane.ID to prevent duplicate ID in the database
        planeRef.whereEqualTo("id", plane.getId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()) {
                            Log.d("FirestoreQuery", "Unable to add plane; Plane ID is not unique");
                        } else {
                            // Add the plane
                            planeRef.add(plane).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("FirestoreQuery", "DocumentSnapshot written with internal ID: " + documentReference.getId());
                                }
                            });
                        }
                    }
                });

        return plane;
    }

    public void deletePlane(String planeID) {
        // Delete plane based on the 'id' field of the plane

        // First, query the database for the plane with the specified id
        // Only 1 plane should have a given planeID because uniqueness is enforced in the add method
        planeRef.whereEqualTo("id", planeID)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        WriteBatch batch = db.batch();

                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot snapshot : snapshotList) {
                            batch.delete(snapshot.getReference());
                        }
                        Log.d("FirestoreQuery", "Deleted plane with the id " + planeID);
                    }
                });

    }

    public ArrayList<Planes> getAllPlanes() {
        //Get all planes in the "planes" collection in the Firestore DB
        ArrayList<Planes> planeList = new ArrayList<>();
        planeRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Planes plane = document.toObject(Planes.class);
                                planeList.add(plane);
                                Log.d("Firestore query", "added " + plane.getPlaneName());
                            }
                        } else {
                            Log.d("Firestore query", "Error getting documents: ", task.getException());
                        }
                    }
                });
        return planeList;
    }


    public void addCargo(Planes plane, Cargo cargo) {
        planeRef.whereEqualTo("id", plane.getId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        if (snapshotList.size() > 1) {
                            Log.d("Firestore query", "Snapshot list has more than one element");
                            return;
                        }
                        for (DocumentSnapshot snapshot : snapshotList) {
                            snapshot.getReference().collection("assignedCargo").add(cargo);
                        }
                        Log.d("FirestoreQuery", "Added cargo" + cargo.getCargoName() + "to" + plane.getId());
                    }
                });
    }

    public Cargo removeCargo(Planes plane, int id) {
        final CollectionReference[] cargoRef = new CollectionReference[1];
        final Cargo[] returnCargo = new Cargo[1];
        planeRef.whereEqualTo("id", plane.getId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        if (snapshotList.size() > 1) {
                            Log.d("Firestore query", "Snapshot list has more than one element");
                            return;
                        }
                        for (DocumentSnapshot snapshot : snapshotList) {
                            cargoRef[0] = snapshot.getReference().collection("assignedCargo");
                        }
                    }
                });

        cargoRef[0].whereEqualTo("id", plane.getId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        if (snapshotList.size() > 1) {
                            Log.d("Firestore query", "Snapshot list has more than one element");
                            return;
                        }
                        for (DocumentSnapshot snapshot : snapshotList) {
                            returnCargo[0] = snapshot.toObject(Cargo.class);
                            snapshot.getReference().delete();
                        }
                    }
                });
        return returnCargo[0];

    }

}
