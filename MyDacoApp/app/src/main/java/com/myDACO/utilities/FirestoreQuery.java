package com.myDACO.utilities;

import android.util.Log;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

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
    CollectionReference cargoRef = db.collection("cargo");
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

    public MutableLiveData<List<Planes>> getAllPlanes() {
        //Get all planes in the "planes" collection in the Firestore DB
        MutableLiveData<List<Planes>> output = new MutableLiveData<>();
        planeRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        ArrayList<Planes> planeList = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Planes plane = document.toObject(Planes.class);
                                planeList.add(plane);
                                Log.d("Firestore query", "added " + plane.getPlaneName());
                            }
                            output.setValue(planeList);
                        } else {
                            Log.d("Firestore query", "Error getting documents: ", task.getException());
                        }
                    }
                });
        return output;
    }

    
    //returns all instances of cargo that contain the given search parameter in the given field
    public <T> MutableLiveData<List<Cargo>> searchForCargo(String field, T searchVal) {
        MutableLiveData<List<Cargo>> output = new MutableLiveData<>();


        cargoRef.whereEqualTo(field, searchVal)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Cargo> retCargo = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                retCargo.add(document.toObject(Cargo.class));
                            }
                            output.setValue(retCargo);
                        }

                    }
                });
        return output;
    }

    //returns all instances of cargo that contain the given search parameter in the given field
    public <T> MutableLiveData<List<Personnel>> searchForPersonnel(String field, T searchVal) {
        MutableLiveData<List<Personnel>> output = new MutableLiveData<>();
        personnelRef.whereEqualTo(field, searchVal)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Personnel> retPersonnel = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                retPersonnel.add(document.toObject(Personnel.class));
                            }
                            output.setValue(retPersonnel);
                        }
                    }
                });
        return output;
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
                        planeRef.document(plane.getId()).update("personnelCount", FieldValue.increment(1));
                    }
                }
            });
    }


    public void removePersonnel(Planes plane, String id) {
        planeRef.document(plane.getId()).update("assignedPersonnel", FieldValue.arrayRemove(id));
        DocumentReference docRef = personnelRef.document(id);
        db.runTransaction(new Transaction.Function<Personnel>() {
            @Override
            public Personnel apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.delete(docRef);
                return null;
            }
        });
    }

    public void removePersonnel(String id) {
        DocumentReference docRef = personnelRef.document(id);
        db.runTransaction(new Transaction.Function<Personnel>() {
            @Override
            public Personnel apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.delete(docRef);
                return null;
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
                            planeRef.document(plane.getId()).update("cargoWeight", FieldValue.increment(cargo.getWeight()));
                            cargoRef.document(cargo.getId()).set(cargo);

                        }
                    }
                });
    }


    public void removeCargo(Planes plane, String id) {
        planeRef.document(plane.getId()).update("assignedCargo", FieldValue.arrayRemove(id));
        DocumentReference docRef = cargoRef.document(id);
        db.runTransaction(new Transaction.Function<Cargo>() {
            @Override
            public Cargo apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.delete(docRef);
                return null;
            }
        });
    }

    public void removeCargo(String id) {
        DocumentReference docRef = cargoRef.document(id);
        db.runTransaction(new Transaction.Function<Cargo>() {
            @Override
            public Cargo apply(Transaction transaction) throws FirebaseFirestoreException {
                transaction.delete(docRef);
                return null;
            }
        });
    }


    public void reassignCargo(Cargo cargo, String planeID) {
        DocumentReference oldPlane = planeRef.document(cargo.getAssignedPlaneID());
        oldPlane.update("assignedCargo", FieldValue.arrayRemove(cargo.getId()));
        oldPlane.update("cargoWeight", FieldValue.increment(-cargo.getWeight()));

        DocumentReference newPlane = planeRef.document(planeID);
        newPlane.update("assignedCargo", FieldValue.arrayUnion(cargo.getId()));
        newPlane.update("cargoWeight", FieldValue.increment(cargo.getWeight()));

        cargoRef.document(cargo.getId()).update("assignedPlaneID", planeID);
    }

    public void reassignPersonnel(Personnel personnel, String planeID) {
        DocumentReference oldPlane= planeRef.document(personnel.getAssignedPlaneID());
        oldPlane.update("assignedPersonnel", FieldValue.arrayRemove(personnel.getId()));
        oldPlane.update("personnelCount", FieldValue.increment(-1));

        DocumentReference newPlane = planeRef.document(planeID);
        newPlane.update("assignedPersonnel", FieldValue.arrayUnion(personnel.getId()));
        newPlane.update("personnelCount", FieldValue.increment(1));

        personnelRef.document(personnel.getId()).update("assignedPlaneID", planeID);
      }

    public MutableLiveData<List<Cargo>> getCargo(List<Planes> planes) {
        MutableLiveData<List<Cargo>> output = new MutableLiveData<>();
        ArrayList<String> cargoIDs = new ArrayList<>();
        for (Planes plane : planes) {
           cargoIDs.addAll(plane.getAssignedCargo());
        }

        for (String id : cargoIDs) {
            cargoRef.whereIn("id", cargoIDs).get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            output.setValue(queryDocumentSnapshots.toObjects(Cargo.class));
                        }
                    });
        }
        return output;
    }

    public MutableLiveData<List<Personnel>> getPersonnel(List<Planes> planes) {
        MutableLiveData<List<Personnel>> output = new MutableLiveData<>();
        ArrayList<String> personnelIDs = new ArrayList<>();

        for (Planes plane : planes) {
            personnelIDs.addAll(plane.getAssignedPersonnel());
        }
        personnelRef.whereIn("id", personnelIDs).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                 output.setValue(queryDocumentSnapshots.toObjects(Personnel.class));

            }
        });
        return output;
    }

    public void updatePersonnel(String id, Personnel person) {
        personnelRef.document(id).set(person);
    }

    public void updateCargo(String id, Cargo cargo) {
        cargoRef.document(id).set(cargo);
    }
}

