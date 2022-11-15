package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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
import com.myDACO.data.Planes;
import com.myDACO.searching.SearchCargoActivity;
import com.myDACO.searching.SearchPersonnelActivity;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AssignCargoActivity extends AppCompatActivity {

        private FirestoreQuery fq  = new FirestoreQuery();
        private Mission currentMission;
        private Planes currentPlane;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cargo_master_list_screen);

            currentMission = (Mission) getIntent().getSerializableExtra("MISSION");
            currentPlane = (Planes) getIntent().getSerializableExtra("PLANE");
            // Get the list view of cargos
            ListView listView = (ListView) findViewById(R.id.cargo_list);
            CargoArrayAdapter cargoAdapter = new CargoArrayAdapter(this, ListOfCargosActivity.cargoList);
            listView.setAdapter(cargoAdapter);
            // Go to see a cargo
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Intent nextScreen = new Intent(AssignCargoActivity.this, MissionActivity.class);
                    fq.reassignCargo(ListOfCargosActivity.cargoList.get(position), currentPlane.getId());
                    nextScreen.putExtra("MISSION", currentMission);
                    nextScreen.putExtra("CARGO_TEXT", ListOfCargosActivity.cargoList.get(position).getCargoName());
                    nextScreen.putExtra("CARGO_ID", ListOfCargosActivity.cargoList.get(position).getAssignedPlaneID());
                    com.myDACO.AssignCargoActivity.this.startActivity(nextScreen);
                }
            });

            // Search for an item
            ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
            searchIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Go to screen with UI for adding a plane
                    Intent nextScreen = new Intent(AssignCargoActivity.this, SearchCargoActivity.class);
                    AssignCargoActivity.this.startActivity(nextScreen);
                }
            });

            // User clicks on the menu bar to sign out action
            FileHelper file = new FileHelper();
            ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
            file.showMenu(AssignCargoActivity.this, menuIcon);
        }


}
