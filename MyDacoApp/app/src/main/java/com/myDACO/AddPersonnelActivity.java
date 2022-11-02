package com.myDACO;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import com.myDACO.data.*;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

public class AddPersonnelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personnel);

        FirestoreQuery fq = new FirestoreQuery();

        EditText fnameInput = (EditText) findViewById(R.id.personnel_fname_input);
        EditText lnameInput= (EditText) findViewById(R.id.personnel_lname_input);
        EditText assignedPlaneIDInput = (EditText) findViewById(R.id.personnel_id_input);
        EditText personnelPriorityInput = (EditText) findViewById(R.id.personnel_priority_input);
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
                } else if(assignedPlaneIDInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter an assigned plane ID.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    assignedPlaneIDInput.setError("Please enter an assigned plane ID.");
                } else if(personnelPriorityInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a priority value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    personnelPriorityInput.setError("Please enter a priority value.");
                } else {
                    // all fields are populated, so add the plane
                    //Personnel first name and last name
                    String firstName = fnameInput.getText().toString();
                    String lastName = lnameInput.getText().toString();

                    // Assigned plane ID
                    String assignedPlaneID = assignedPlaneIDInput.getText().toString();

                    // Cargo Capacity
                    int personnelPriority = Integer.parseInt(personnelPriorityInput.getText().toString());

                    AlertDialog.Builder alert = new AlertDialog.Builder(AddPersonnelActivity.this);
                    alert.setTitle("Add Personnel Confirmation");
                    alert.setMessage("Are you sure you want to add this personnel?\nFirst Name: "
                            + firstName + "\nLast Name: " + lastName + "\nAssigned Plane ID: " + assignedPlaneID
                            + "\nPersonnel Priority: " + Integer.toString(personnelPriority));
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

                            Personnel newPersonnel = new Personnel(firstName, lastName, assignedPlaneID,
                                    personnelPriority, personnel_id);

                            fq.addPersonnel();


                            fnameInput.getText().clear();
                            lnameInput.getText().clear();
                            personnelPriorityInput.getText().clear();
                            assignedPlaneIDInput.getText().clear();

                            Toast.makeText(getApplicationContext(), "Personnel added", Toast.LENGTH_SHORT).show();
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
        file.showMenu(AddPersonnelActivity.this, menuIcon);

    }

}
