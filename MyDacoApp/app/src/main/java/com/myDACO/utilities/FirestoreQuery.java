package com.myDACO.utilities;
import android.app.Person;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
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
import com.myDACO.SinglePlaneActivity;
import com.myDACO.data.*;

import org.checkerframework.checker.units.qual.A;

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
                        for (DocumentSnapshot doc : queryDocumentSnapshots) {
                            planeRef.document(doc.getId())
                                    .delete()
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("FirestoreQuery", "Deleted plane with the id " + planeID);
                                        }
                                    });
                        }

                    }
                });

    }

    public void togglePlaneStatus(String planeID) {
        planeRef.whereEqualTo("id", planeID)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot doc : queryDocumentSnapshots) {
                            boolean planeIsActive = doc.toObject(Planes.class).isActive();
                            planeRef.document(doc.getId()).update("active", !planeIsActive);
                        }
                    }
                });

    }

    public void togglePlaneMission(String planeID) {
        planeRef.whereEqualTo("id", planeID)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot doc : queryDocumentSnapshots) {
                            boolean planeOnMission = doc.toObject(Planes.class).isOnMission();
                            planeRef.document(doc.getId()).update("onMission", !planeOnMission);
                        }
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
    
    //returns all instances of cargo that contain the given search parameter in the given field
    public <T> ArrayList<Cargo> searchForCargo(String field, T searchParam) {
        ArrayList<Cargo> retCargo = new ArrayList<>();
        planeRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(Task<QuerySnapshot> task) {
                        ArrayList<CollectionReference> cargoRefs = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                cargoRefs.add(document.getReference().collection("assingedCargo"));
                            }
                            for (CollectionReference cargoRef : cargoRefs) {
                                cargoRef.whereEqualTo(field, searchParam)
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            public void onComplete(Task<QuerySnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                                        retCargo.add(document.toObject(Cargo.class));
                                                    }
                                                }
                                            }
                                        });
                            }

                        }
                    }
                });
        return retCargo;
    }

    //returns all instances of cargo that contain the given search parameter in the given field
    public <T> ArrayList<Personnel> searchForPersonnel(String field, T searchParam) {
        ArrayList<Personnel> retPersonnel = new ArrayList<>();
        planeRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(Task<QuerySnapshot> task) {
                        ArrayList<CollectionReference> personnelRefs = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                personnelRefs.add(document.getReference().collection("assignedPersonnel"));
                            }
                            for (CollectionReference cargoRef : personnelRefs) {
                                cargoRef.whereEqualTo(field, searchParam)
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            public void onComplete(Task<QuerySnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                                        retPersonnel.add(document.toObject(Personnel.class));
                                                    }
                                                }
                                            }
                                        });
                            }

                        }
                    }
                });
        return retPersonnel;
    }

    public void addPersonnel(Planes plane, Personnel personnel) {
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
                            snapshot.getReference().collection("assignedPersonnel").add(personnel);
                        }
                        Log.d("FirestoreQuery", "Added personnel" + personnel.getLastName() + "to" + plane.getId());
                    }
                });
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
    
    public Personnel removePersonnel(Planes plane, int id) {
        final CollectionReference[] personnelRef = new CollectionReference[1];
        final Personnel[] returnPersonnel = new Personnel[1];
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
                            personnelRef[0] = snapshot.getReference().collection("assignedPersonnel");
                        }
                    }
                });

        personnelRef[0].whereEqualTo("id", plane.getId())
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
                            returnPersonnel[0] = snapshot.toObject(Personnel.class);
                            snapshot.getReference().delete();
                        }
                    }
                });
        return returnPersonnel[0];

    }
}

