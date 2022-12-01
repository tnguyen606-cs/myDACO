package com.myDACO;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.myDACO.data.*;
import com.myDACO.searching.SearchPlaneActivity;
import com.myDACO.utilities.*;

import java.util.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MissionActivity extends AppCompatActivity {

    static List<Planes> missionPlanes = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Cargo> missionCargo = new ArrayList<>();
    static List<Personnel> missionPersonnel = new ArrayList<>();
    public FirestoreQuery fq = new FirestoreQuery();

    private Mission currentMission;
    private MissionArrayAdapter missionPlaneAdapter;


    @Override
    public void onStart(){
        super.onStart();
        //listens for changes to the firestore databases in real time
        ListenerRegistration missionPlaneListener = db.collection("planes").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                missionPlanes.clear();
                for (QueryDocumentSnapshot document : value) {
                    Planes plane = document.toObject(Planes.class);
                    // Only add the plane to the list if plane onMission == True
                    if (plane.isOnMission()) {
                        missionPlanes.add(plane);
                        missionPlaneAdapter.notifyDataSetChanged();
                    }
                }
                Collections.sort(missionPlanes, new Comparator<Planes>() {
                    public int compare(Planes p1, Planes p2) {
                        return p1.getPlaneName().compareTo(p2.getPlaneName());
                    }
                });
                Log.d("snapshot listener", "current planes " + missionPlanes);
            }
        });
        CollectionReference cargoRef = db.collection("cargo");
        cargoRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("snapshot listener", "Listen failed.", e);
                    return;
                }

                missionCargo.clear();
                for (QueryDocumentSnapshot doc : snapshot) {
                    missionCargo.add(doc.toObject(Cargo.class));
                }
                Log.d("snapshot listener", "current cargos " + missionCargo);
            }
        });


        CollectionReference personnelRef = db.collection("personnel");
        personnelRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("snapshot listener", "Listen failed.", e);
                    return;
                }

                missionPersonnel.clear();
                for (QueryDocumentSnapshot doc : snapshot) {
                    missionPersonnel.add(doc.toObject(Personnel.class));

                }
                Log.d("snapshot listener", "current personnel " + missionPersonnel);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_planes);
        missionPlanes.clear();
        for (Planes plane : PlanesActivity.planesList) {
            if (plane.isOnMission()) {
                missionPlanes.add(plane);
            }
        }

        // Take in Mission object passed in from manifest activity
        currentMission = (Mission) getIntent().getSerializableExtra("MISSION");
        // TODO: Fix setMissionPlanes method, Cannot directly assign two Lists
//        currentMission.setMissionPlanes(missionPlanes);

        // Get the handle for ListView
        ListView missionPlanesListView = (ListView) findViewById(R.id.mission_planes_list);
        missionPlaneAdapter = new MissionArrayAdapter(this, missionPlanes);
        missionPlanesListView.setAdapter(missionPlaneAdapter);

        // Search for an item
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(MissionActivity.this, SearchPlaneActivity.class);
                MissionActivity.this.startActivity(nextScreen);

            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(MissionActivity.this, menuIcon);

        Button missionBtn = (Button) findViewById(R.id.bumpPlanBtn);
        missionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Planes> downed = new ArrayList<>();
                ArrayList<Planes> notDowned = new ArrayList<>();
                for (Planes p : missionPlanes) {
                    //get downed plane and notDowned plane
                    if (!p.isActive()) {
                        downed.add(p);
                    } else {
                        notDowned.add(p);
                    }
                }
                Log.d("bump Plan", "downed " + downed);
                Log.d("bump Plan", "notdowned " + notDowned);
                PriorityQueue<Cargo> cargoQueue = new PriorityQueue<>(1, new Comparator<Cargo>() {
                    @Override
                    public int compare(Cargo o1, Cargo o2) {
                        return o1.getWeight() - o2.getWeight();
                    }
                });

                PriorityQueue<Personnel> personnelQueue = new PriorityQueue<>(1, new Comparator<Personnel>() {
                    @Override
                    public int compare(Personnel o1, Personnel o2) {
                        return o1.getPriority() - o2.getPriority();
                    }
                });

                for (Planes p : downed) {
                    for (Cargo c : missionCargo) {
                        if (c.getAssignedPlaneID().equals(p.getId())) {
                            cargoQueue.add(c);
                        }
                    }
                    for (Personnel pl : missionPersonnel) {
                        if (pl.getAssignedPlaneID().equals((p.getId()))) {
                            personnelQueue.add(pl);
                        }
                    }
                }
                Log.d("bump Plan", "cargo " + cargoQueue);
                Log.d("bump Plan", "personnel " + personnelQueue);
                Log.d("bump Plan", "fq " + fq.getClass());
                Log.d("bump plan", "curr" + currentMission);
                Mission bumpHelper = new Mission();

                   int code = bumpHelper.bumpPlan(notDowned, personnelQueue, cargoQueue, fq);
                    if (code == -1) {
                        Toast.makeText(MissionActivity.this, "Partial bump performed. Not enough capacity to perform a full bump", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MissionActivity.this, "Bump complete.", Toast.LENGTH_SHORT).show();
                    }



                    //TODO implement bump plan stuff here using needed data from the listeners implemented in the onStart method

            }
        });

    }
}
