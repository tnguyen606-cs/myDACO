package com.myDACO.utilities;

import android.util.Log;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Transaction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.myDACO.data.*;

import java.util.*;

public class FirestoreQuery {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference planeRef = db.collection("planes");
    CollectionReference cargoRef = db.collection("cargos");
    CollectionReference personnelRef = db.collection("personnel");

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
                            // Add the plane with docRef set as ID
                            planeRef.document(plane.getId()).set(plane);
                        }
                    }
                });
        return plane;
    }

    public void deletePlane(String planeID) {
        // Delete plane based on the 'id' field of the plane
        planeRef.document(planeID).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("FirestoreQuery", "DocumentSnapshot successfully deleted!");
            }
        });
    }

    public void updatePlaneField(String field, String value, String planeID) {
        DocumentReference docRef = planeRef.document(planeID);

        db.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.update(docRef, field, FieldValue.arrayUnion(value));
                return null;
            }
        });
    }

    public void togglePlaneStatus(String planeID) {
        DocumentReference docRef = planeRef.document(planeID);

        db.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);
                boolean status = snapshot.getBoolean("active");
                transaction.update(docRef, "active", !status);
                return null;
            }
        });
    }

    public void togglePlaneMission(String planeID) {
        DocumentReference docRef = planeRef.document(planeID);

        db.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);
                boolean status = snapshot.getBoolean("onMission");
                transaction.update(docRef, "onMission", !status);
                return null;
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

    public void addPersonnel(Planes plane, Personnel personnel) {
        personnelRef.whereEqualTo("id", personnel.getId())
            .get()
            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        Log.d("FirestoreQuery", "Unable to add plane; Plane ID is not unique");
                    } else {
                        planeRef.document(plane.getId()).update("assignedPersonnel", FieldValue.arrayUnion(personnel.getId()));
                        personnelRef.document(personnel.getId()).set(personnel);
                    }
                }
            });
    }

    public Personnel removePersonnelFromPlane(Planes plane, String id) {
        Personnel[] retPers = new Personnel[1];
        planeRef.document(plane.getId()).update("assignedPersonnel", FieldValue.arrayRemove(id));
        DocumentReference docRef = personnelRef.document(id);
        db.runTransaction(new Transaction.Function<Personnel>() {
            @Override
            public Personnel apply(Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);
                Personnel retPersonnel = snapshot.toObject(Personnel.class);
                transaction.delete(docRef);
                return retPersonnel;
            }
        }).addOnSuccessListener(new OnSuccessListener<Personnel>() {
            @Override
            public void onSuccess(Personnel result) {
                retPers[0] = result;
            }
        });
        return retPers[0];
    }

    public void removePersonnel(String id) {
        personnelRef.document(id)
            .delete()
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("A Personnel DELETION", "DocumentSnapshot successfully deleted!");
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w("A Personnel DELETION", "Error deleting document", e);
                }
            });
    }

    public void addCargo(Planes plane, Cargo cargo) {
        cargoRef.whereEqualTo("id", cargo.getId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            Log.d("FirestoreQuery", "Unable to add cargo; Plane ID is not unique");
                        } else {
                            planeRef.document(plane.getId()).update("assignedCargo", FieldValue.arrayUnion(cargo.getId()));
                            personnelRef.document(cargo.getId()).set(cargo);
                        }
                    }
                });
    }

    public Cargo removeCargoFromPlane(Planes plane, String id) {
        Cargo[] retCargo = new Cargo[1];
        planeRef.document(plane.getId()).update("assignedCargo", FieldValue.arrayRemove(id));
        DocumentReference docRef = cargoRef.document(id);
        db.runTransaction(new Transaction.Function<Cargo>() {
            @Override
            public Cargo apply(Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);
                Cargo retCar = snapshot.toObject(Cargo.class);
                transaction.delete(docRef);
                return retCar;
            }
        }).addOnSuccessListener(new OnSuccessListener<Cargo>() {
            @Override
            public void onSuccess(Cargo result) {
                retCargo[0] = result;
            }
        });
        return retCargo[0];
    }

    public void removeCargo(String id) {
        cargoRef.document(id)
            .delete()
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("A Cargo DELETION", "DocumentSnapshot successfully deleted!");
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w("A Cargo DELETION", "Error deleting document", e);
                }
            });
    }

    public void reassignCargo(Cargo cargo, Planes plane) {
        planeRef.document(cargo.getAssignedPlaneID()).update("assignedCargo", FieldValue.arrayRemove(cargo.getId()));
        planeRef.document(plane.getId()).update("assignedCargo", FieldValue.arrayUnion(cargo.getId()));
        cargoRef.document(cargo.getId()).update("assignedPlaneId", plane.getId());
    }

    public void reassignPersonnel(Personnel personnel, Planes plane) {
        planeRef.document(personnel.getAssignedPlaneID()).update("assignedPersonnel", FieldValue.arrayRemove(personnel.getId()));
        planeRef.document(plane.getId()).update("assignedPersonnel", FieldValue.arrayUnion(personnel.getId()));
        personnelRef.document(personnel.getId()).update("assignedPlaneId", plane.getId());
    }

    public List<Cargo> getCargo(List<Planes> planes) {
        ArrayList<String> cargoIDs = new ArrayList<>();
        ArrayList<Cargo> retCargo = new ArrayList<>();

        for (Planes plane : planes) {
           cargoIDs.addAll(plane.getAssignedCargo());
        }

        for (String id : cargoIDs) {
            cargoRef.document(id).get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            retCargo.add(documentSnapshot.toObject(Cargo.class));
                        }
                    });
        }
        return retCargo;
    }

    public List<Personnel> getPersonnel(List<Planes> planes) {
        ArrayList<String> personnelIDs = new ArrayList<>();
        ArrayList<Personnel> retPersonnel = new ArrayList<>();
        for (Planes plane : planes) {
            personnelIDs.addAll(plane.getAssignedPersonnel());
        }
        for (String id : personnelIDs) {
            personnelRef.document(id).get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            retPersonnel.add(documentSnapshot.toObject(Personnel.class));
                        }
                    });
        }
        return retPersonnel;
    }

    public void updatePersonnel(String id, Personnel person) {
        personnelRef.document(id).set(person);
    }

    public void updateCargo(String id, Cargo cargo) {
        cargoRef.document(id).set(cargo);
    }
}

