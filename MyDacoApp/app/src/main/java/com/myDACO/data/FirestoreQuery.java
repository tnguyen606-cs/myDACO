package com.myDACO.data;
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

import java.util.*;

public class FirestoreQuery {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference planeRef = db.collection("planes");

    public Planes addPlane(Planes plane) {
        // todo: check uniqueness before adding to prevent duplicate plane ids (Idk how to do this)
        planeRef.add(plane)
        return plane;
    }

    public void deletePlane(String id) {
        // Delete plane based on the 'id' field of the plane

        //First, query the database for the plane with the specified id
        // There might be multiple planes with the same id since uniqueness isn't enforced (yet)
        planeRef.where("id", '==', id)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        WriteBatch batch = db.batch();

                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot snapshot : snapshotList) {
                            batch.delete(snapshot.getReference());
                        }
                        Log.d('FirestoreQuery', 'Deleted all planes with the id ' + id);
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
                        Log.d('FirestoreQuery', 'Get all planes query complete');
                    }
                });
        return planeList;
    }





}
