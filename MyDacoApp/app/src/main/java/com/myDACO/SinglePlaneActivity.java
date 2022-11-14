package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.*;


public class SinglePlaneActivity extends AppCompatActivity {

    private String plane_name;
    private String plane_id;
    private String plane_position = null;

    private List<Personnel> assignedPersonnelList = new ArrayList<>();

    PersonnelArrayAdapter personnelAdapter;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onStart(){
        super.onStart();
        ListenerRegistration personnelListener = db.collection("personnel").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                assignedPersonnelList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Personnel personnel = document.toObject(Personnel.class);
                    if (personnel.getAssignedPlaneID().equals(plane_id)) {
                        assignedPersonnelList.add(personnel);
                        personnelAdapter.notifyDataSetChanged();
                    }
                }
                Collections.sort(assignedPersonnelList, new Comparator<Personnel>() {
                    public int compare(Personnel p1, Personnel p2) {
                        return p1.getLastName().compareTo(p2.getFirstName());
                    }
                });
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

        // Get all information from the selection Plane
        Intent intent = getIntent();
        plane_name = intent.getStringExtra("PLANE_TEXT");
        TextView planeText = (TextView) findViewById(R.id.plane_text);
        plane_id = intent.getStringExtra("PLANE_ID");
        planeText.setText(plane_name + " Manifest");
        plane_position = intent.getStringExtra("PLANE_POSITION");
        int index = Integer.valueOf(plane_position);

        //firebase conversion
        Planes singlePlane = PlanesActivity.planesList.get(index);

        // Get the handle for ListView
        ListView cargoListView = (ListView) findViewById(R.id.cargo_list);
        ListView passengerListView = (ListView) findViewById(R.id.passenger_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        ArrayAdapter cargoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedCargo());
        personnelAdapter = new PersonnelArrayAdapter(this, assignedPersonnelList);

        // Set the adapter with the ListView
        cargoListView.setAdapter(cargoAdapter);
        passengerListView.setAdapter(personnelAdapter);

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SinglePlaneActivity.this, menuIcon);
    }



}