package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Cargo;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.searching.SearchPlaneActivity;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SinglePlaneActivity extends AppCompatActivity {

    private Planes currentPlane;
    private List<String> personnelList = new ArrayList<>();
    private List<String> cargoList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayAdapter<String> cargoAdapter;
    private ArrayAdapter<String> personnelAdapter;

    @Override
    public void onStart(){
        super.onStart();

        // Retreive lists of personnel
        getAssignedPersonnel();
        getAssignedCargo();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

        // Get all information from the selection Plane
        currentPlane = (Planes) getIntent().getSerializableExtra("PLANE");

        // Passing from the chosen name
        TextView planeText = (TextView) findViewById(R.id.plane_text);
        planeText.setText(currentPlane.getPlaneName() + " Manifest");

        // Get the handle for ListView
        ListView cargoListView = (ListView) findViewById(R.id.cargo_list);
        ListView passengerListView = (ListView) findViewById(R.id.passenger_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        cargoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cargoList);
        personnelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personnelList);

        // Set the adapter with the ListView
        cargoListView.setAdapter(cargoAdapter);
        passengerListView.setAdapter(personnelAdapter);

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SinglePlaneActivity.this, menuIcon);

        // Search for an item
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(SinglePlaneActivity.this, SearchPlaneActivity.class);
                SinglePlaneActivity.this.startActivity(nextScreen);

            }
        });
    }

    private void getAssignedPersonnel() {
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
                    if (personnel.getAssignedPlaneID().equals(currentPlane.getId())) {
                        personnelList.add(personnel.getFirstName() + " " + personnel.getLastName());
                        personnelAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    private void getAssignedCargo() {
        ListenerRegistration cargoListener = db.collection("cargos").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                cargoList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Cargo cargo = document.toObject(Cargo.class);
                    if (cargo.getAssignedPlaneID().equals(currentPlane.getId())) {
                        cargoList.add(cargo.getCargoName());
                        cargoAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}