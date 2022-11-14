package com.myDACO;

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
import com.myDACO.data.*;
import com.myDACO.utilities.*;

import java.util.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MissionActivity extends AppCompatActivity {

    private Mission currentMission;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    MissionArrayAdapter missionPlaneAdapter;
    ListenerRegistration missionPlaneListener;

    private List<Planes> missionPlanes = new ArrayList<>();

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

                List<String> cargos = new ArrayList<>();
                for (QueryDocumentSnapshot doc : snapshot) {
                    if (doc.get("cargoName") != null) {
                        cargos.add(doc.getString("cargoName"));
                    }
                }
                Log.d("snapshot listener", "current cargos " + cargos);
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

                List<String> personnel = new ArrayList<>();
                for (QueryDocumentSnapshot doc : snapshot) {
                    if (doc.get("firstName") != null) {
                        personnel.add(doc.getString("firstName") + doc.getString("lastName"));
                    }
                }
                Log.d("snapshot listener", "current personnel " + personnel);
            }
        });
        //TODO add cargo and personnel listeners here like above
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_planes);

        // Take in Mission object passed in from manifest activity
        currentMission = (Mission) getIntent().getSerializableExtra("MISSION");
        currentMission.setMissionPlanes(missionPlanes);

        // Get the handle for ListView
        ListView missionPlanesListView = (ListView) findViewById(R.id.mission_planes_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        missionPlaneAdapter = new MissionArrayAdapter(this, missionPlanes);

        // Set the adapter with the ListView
        missionPlanesListView.setAdapter(missionPlaneAdapter);

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

                    //TODO implement bump plan stuff here using needed data from the listeners implemented in the onStart method
                }
            }
        });

    }
    //getter for mission planes
    public List<Planes> getMissionPlanes() {
        return this.missionPlanes;
    }
}
