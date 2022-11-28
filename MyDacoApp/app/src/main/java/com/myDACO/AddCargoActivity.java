package com.myDACO;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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
import com.myDACO.data.*;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class AddCargoActivity extends AppCompatActivity {

    private ArrayList<Planes> planesList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayAdapter<Planes> adapter;

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
                    Planes plane = document.toObject(Planes.class);
                    planesList.add(plane);
                    adapter.notifyDataSetChanged();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cargo);

        FirestoreQuery fq = new FirestoreQuery();

        EditText cargoNameInput = (EditText) findViewById(R.id.cargo_name_box);
        EditText cargoIdInput = (EditText) findViewById(R.id.cargo_id_input);

        Spinner assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<Planes>(this,R.layout.spinner_item,
                planesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assignedPlaneDropdown.setAdapter(adapter);

        EditText cargoWeightInput = (EditText) findViewById(R.id.cargo_weight_input);

        Button addBtn = (Button) findViewById(R.id.add_cargo_button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cargoNameInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a cargo name.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    cargoNameInput.setError("Please enter a cargo name.");
                } else if(cargoIdInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a cargo ID.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    cargoIdInput.setError("Please enter a cargo ID.");
                } else if(cargoWeightInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a cargo weight value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    cargoWeightInput.setError("Please enter a cargo weight value.");
                } else {
                    // all fields are populated, so add the plane
                    //Cargo Name
                    String cargoName = cargoNameInput.getText().toString();
                    // Cargo ID
                    String cargoID = cargoIdInput.getText().toString();
                    // Assigned plane
                    Planes assignedPlane = (Planes) assignedPlaneDropdown.getSelectedItem();
                    // Cargo Weight
                    int cargoWeight = Integer.parseInt(cargoWeightInput.getText().toString());

                    AlertDialog.Builder alert = new AlertDialog.Builder(AddCargoActivity.this);
                    alert.setTitle("Add Cargo Confirmation");
                    alert.setMessage("Are you sure you want to add this cargo?\nCargo Name: "
                            + cargoName + "\nCargo ID: " + cargoID +
                            "\nCargo Weight: " + Integer.toString(cargoWeight));
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            // Generate the cargo ID
                            Random rand = new Random();
                            // Autogenerate cargo id ('c' + 2 letter + 1 int)
                            String c = "c";
                            String c1 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String c2 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String n = Integer.toString(rand.nextInt(10));
                            String cargo_id = c + c1 + c2 + n;


                            String assignedPlaneID = null;
                            if (assignedPlane != null) {
                                assignedPlaneID = assignedPlane.getId();
                            }

                            Cargo newCargo = new Cargo(cargoName, cargoWeight, assignedPlaneID, cargo_id);

                            // Insert Firestore query here
                            // Add the cargo to the cargo collection
                            // Add cargo to the plane
                            fq.addCargo(assignedPlane, newCargo);

                            cargoNameInput.getText().clear();
                            cargoWeightInput.getText().clear();
                            cargoIdInput.getText().clear();

                            Toast.makeText(getApplicationContext(), "Cargo added", Toast.LENGTH_SHORT).show();
                        }
                    });

                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    alert.show();

                }

            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(AddCargoActivity.this, menuIcon);
    }
}
