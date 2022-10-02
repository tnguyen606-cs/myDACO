package com.myDACO.utilities;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentChange.Type;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
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
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Planes plane = documentSnapshot.toObject(Planes.class);
                            planeList.add(plane);
                        }
                        Log.d("FirestoreQuery", "Get all planes query complete");
                    }
                });
        return planeList;
    }

    public ArrayList<Personnel> getPersonnelFromPlane(String planeID) {
        // Gets all the personnel associated with a specified plane (input is a plane ID, output is an ArrayList of Personnel objects)
        ArrayList<Personnel> personnelList = new ArrayList<>();

        // Get Firestore document ID of plane using plane ID to query
        // Nested query: First query the plane we want to get personnel for. Then query the assignedPersonnel list of that plane
        planeRef.whereEqualTo("id", planeID).limit(1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                String docID = documentSnapshot.getId();
                                CollectionReference planePersonnelRef = planeRef.document(docID).collection("assignedPersonnel");
                                planePersonnelRef.get()
                                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                            @Override
                                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                                    personnelList.add(documentSnapshot.toObject(Personnel.class));
                                                }
                                            }
                                        });
                            }
                        }
                    }
                });
        return personnelList;
    }

    public ArrayList<Cargo> getCargoFromPlane(String planeID) {
        // Gets all the cargo associated with a specified plane (input is a plane ID, output is an ArrayList of Cargo objects)
        ArrayList<Cargo> cargoList = new ArrayList<>();

        // Get Firestore document ID of plane using plane ID to query
        // Nested query: First query the plane we want to get personnel for. Then query the assignedCargo list of that plane
        planeRef.whereEqualTo("id", planeID).limit(1)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                String docID = documentSnapshot.getId();
                                CollectionReference planePersonnelRef = planeRef.document(docID).collection("assignedCargo");
                                planePersonnelRef.get()
                                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                            @Override
                                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                                    cargoList.add(documentSnapshot.toObject(Cargo.class));
                                                }
                                            }
                                        });
                            }
                        }
                    }
                });

        return cargoList;
    }
}
