package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.myDACO.data.*;
import com.myDACO.searching.SearchPlaneActivity;
import com.myDACO.utilities.*;

import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

public class MissionActivity extends AppCompatActivity {

    static List<Planes> missionPlanes = new ArrayList<>();

    private Mission currentMission;
    private MissionArrayAdapter missionPlaneAdapter;

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

    }
}
