package com.myDACO;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import java.util.*;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.*;
import com.myDACO.searching.SearchPersonnelActivity;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

public class AddPersonnelActivity extends AppCompatActivity {

    static ArrayAdapter<Planes> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personnel);

        FirestoreQuery fq = new FirestoreQuery();

        EditText fnameInput = (EditText) findViewById(R.id.personnel_fname_input);
        EditText lnameInput= (EditText) findViewById(R.id.personnel_lname_input);

        Spinner assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<Planes>(this,R.layout.spinner_item, PlanesActivity.planesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assignedPlaneDropdown.setAdapter(adapter);

        EditText personnelPriorityInput = (EditText) findViewById(R.id.personnel_priority_input);
        EditText personnelWeightInput = (EditText) findViewById(R.id.personnel_weight_input);

        Button addBtn = (Button) findViewById(R.id.add_personnel_button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fnameInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a first name.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    fnameInput.setError("Please enter a first name.");
                } else if(lnameInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a last name.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    lnameInput.setError("Please enter a last name.");
                } else if(personnelPriorityInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a priority value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    personnelPriorityInput.setError("Please enter a priority value.");
                } else if(personnelWeightInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a weight value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    personnelWeightInput.setError("Please enter a weight value.");
                } else {
                    // all fields are populated, so add the plane
                    //Personnel first name and last name
                    String firstName = fnameInput.getText().toString();
                    String lastName = lnameInput.getText().toString();

                    // Assigned plane
                    Planes assignedPlane = (Planes) assignedPlaneDropdown.getSelectedItem();

                    // Weight
                    int personnelWeight = Integer.parseInt(personnelWeightInput.getText().toString());

                    // Priority
                    int personnelPriority = Integer.parseInt(personnelPriorityInput.getText().toString());

                    AlertDialog.Builder alert = new AlertDialog.Builder(AddPersonnelActivity.this);
                    alert.setTitle("Add Personnel Confirmation");
                    alert.setMessage("Are you sure you want to add this personnel?\nFirst Name: "
                            + firstName + "\nLast Name: " + lastName + "\nAssigned Plane: " + assignedPlane.getPlaneName()
                            + "\nPersonnel Priority: " + Integer.toString(personnelPriority) + "\nPersonnel Weight: "+ Integer.toString(personnelWeight));
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            // Generate the personnel ID
                            Random rand = new Random();
                            // Autogenerate personnel id ('p' + 2 letter + 1 int)
                            String p = "p";
                            String c1 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String c2 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String n = Integer.toString(rand.nextInt(10));
                            String personnel_id = p + c1 + c2 + n;

                            String assignedPlaneID = null;
                            if (assignedPlane != null) {
                                assignedPlaneID = assignedPlane.getId();
                            }
                            Personnel newPersonnel = new Personnel(firstName, lastName, assignedPlaneID,
                                    personnel_id, personnelPriority, personnelWeight);

                            // Insert Firestore query here
                            // Add the personnel to the personnel collection
                            // Add personnel to the plane
                            if (assignedPlane.getCargoWeight() + newPersonnel.getWeight() <= assignedPlane.getCargoCapacity()) {
                                fq.addPersonnel(assignedPlane, newPersonnel);
                                fnameInput.getText().clear();
                                lnameInput.getText().clear();
                                personnelPriorityInput.getText().clear();
                                personnelWeightInput.getText().clear();
                                Toast.makeText(getApplicationContext(), "Personnel added", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Could not add personnel. Personnel weight exceeds remaining capacity.", Toast.LENGTH_LONG).show();
                            }
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

        // Search for an item
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(AddPersonnelActivity.this, SearchPersonnelActivity.class);
                AddPersonnelActivity.this.startActivity(nextScreen);

            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(AddPersonnelActivity.this, menuIcon);

    }

}
