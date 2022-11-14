package com.myDACO;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.*;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanesActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Planes> planesList = new ArrayList<>();
    PlaneArrayAdapter planeAdapter;

    @Override
    public void onStart(){
        super.onStart();

        //listens for changes to the firestore databases in real time
        ListenerRegistration planeListener = db.collection("planes").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                planesList.clear();
                for (QueryDocumentSnapshot document : value) {
                    try{
                        Planes plane = document.toObject(Planes.class);
                        planesList.add(plane);
                        planeAdapter.notifyDataSetChanged();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                Collections.sort(planesList, new Comparator<Planes>() {
                    public int compare(Planes p1, Planes p2) {
                        return p1.getPlaneName().compareTo(p2.getPlaneName());
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_manifest);

        // Get the handle for ListView
        ListView listView = (ListView) findViewById(R.id.planes_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        planeAdapter = new PlaneArrayAdapter(this, planesList);

        // Set the adapter with the ListView
        listView.setAdapter(planeAdapter);

        // Go to view screen of a single plane
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(PlanesActivity.this, SinglePlaneActivity.class);
                nextScreen.putExtra("PLANE_TEXT", planesList.get(position).getPlaneName());
                nextScreen.putExtra("PLANE_POSITION", String.valueOf(position));
                nextScreen.putExtra("PLANE_ID", planesList.get(position).getId());
                PlanesActivity.this.startActivity(nextScreen);
            }
        });

        // Go to mission activity
        Button missionBtn = (Button) findViewById(R.id.missionBtn);
        missionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create mission class to encapsulate mission planes list, then pass it to the next screen
                Mission currentMission = new Mission(new ArrayList<Planes>());
                Intent nextScreen = new Intent(PlanesActivity.this, MissionActivity.class);
                nextScreen.putExtra("MISSION", currentMission);
                PlanesActivity.this.startActivity(nextScreen);
            }
        });

        // Go to add plane activity
        ImageView addIcon = (ImageView) findViewById(R.id.add_plane);
        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(PlanesActivity.this, AddPlaneActivity.class);
                PlanesActivity.this.startActivity(nextScreen);

            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(PlanesActivity.this, menuIcon);
    }
}


