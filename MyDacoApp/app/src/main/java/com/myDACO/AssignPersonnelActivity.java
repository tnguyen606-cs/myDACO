package com.myDACO;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Cargo;
import com.myDACO.data.Mission;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AssignPersonnelActivity extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Personnel> personnelList = new ArrayList<>();
    PersonnelArrayAdapter personnelAdapter;
    private Mission currentMission;
    FirestoreQuery fq = new FirestoreQuery();
    private Planes currentPlane;

    @Override
    public void onStart() {
        super.onStart();

        //listens for changes to the firestore databases in real time
        ListenerRegistration personnelListener = db.collection("personnel").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                personnelList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Personnel personnel = document.toObject(Personnel.class);
                    personnelList.add(personnel);
                    personnelAdapter.notifyDataSetChanged();
                }
                Collections.sort(personnelList, new Comparator<Personnel>() {
                    public int compare(Personnel c1, Personnel c2) {
                        return c1.getLastName().compareTo(c2.getLastName());
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnel_master_list_screen);

        currentMission = (Mission) getIntent().getSerializableExtra("MISSION");
        currentPlane = (Planes) getIntent().getSerializableExtra("PLANE");
        // Get the list view of personnels
        ListView listView = (ListView) findViewById(R.id.personnel_list);
        personnelAdapter = new PersonnelArrayAdapter(this, personnelList);
        listView.setAdapter(personnelAdapter);
        // Go to see a personnel
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(com.myDACO.AssignPersonnelActivity.this, MissionActivity.class);
                fq.reassignPersonnel(personnelList.get(position), currentPlane);
                nextScreen.putExtra("MISSION", currentMission);
                nextScreen.putExtra("PERSONNEL_FTEXT", personnelList.get(position).getFirstName());
                nextScreen.putExtra("PERSONNEL_LTEXT", personnelList.get(position).getLastName());
                nextScreen.putExtra("PERSONNEL_ID", personnelList.get(position).getAssignedPlaneID());
                com.myDACO.AssignPersonnelActivity.this.startActivity(nextScreen);
            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(com.myDACO.AssignPersonnelActivity.this, menuIcon);
    }
}
