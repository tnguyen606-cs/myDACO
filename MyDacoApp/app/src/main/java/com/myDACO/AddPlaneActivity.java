package com.myDACO;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import com.myDACO.data.*;
import com.myDACO.utilities.FirestoreQuery;

public class AddPlaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plane);

        EditText planeNameInput = (EditText) findViewById(R.id.plane_name_box);
        EditText personnelCapacityInput = (EditText) findViewById(R.id.plane_personnel_capacity_input);
        EditText cargoCapacityInput = (EditText) findViewById(R.id.plane_cargo_capacity_input);
        Button addBtn = (Button) findViewById(R.id.add_plane_button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (planeNameInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a plane name.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    planeNameInput.setError("Please enter a plane name.");
                } else if(personnelCapacityInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a personnel capacity value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    personnelCapacityInput.setError("Please enter a personnel capacity value.");
                } else if(cargoCapacityInput.getText().toString().matches("")) {
                    // Show Toast
                    Toast.makeText(getApplicationContext(), "You did not enter a cargo capacity value.", Toast.LENGTH_SHORT).show();
                    // Show Error on edittext
                    cargoCapacityInput.setError("Please enter a cargo capacity value.");
                } else {
                    // all fields are populated, so add the plane
                    //Plane Name
                    String planeName = planeNameInput.getText().toString();
                    // Personnel Capacity
                    int personnelCapacity = Integer.parseInt(personnelCapacityInput.getText().toString());
                    // Cargo Capacity
                    int cargoCapacity = Integer.parseInt(cargoCapacityInput.getText().toString());

                    AlertDialog.Builder alert = new AlertDialog.Builder(AddPlaneActivity.this);
                    alert.setTitle("Add Plane Confirmation");
                    alert.setMessage("Are you sure you want to add this plane?\nPlane Name: "
                            + planeName + "\nPersonnel Capacity: " + Integer.toString(personnelCapacity) +
                            "\nCargo Capacity: " + Integer.toString(cargoCapacity));
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            // Generate the Plane ID
                            Random rand = new Random();
                            // Autogenerate plane id (2 letter + 1 int)
                            String c1 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String c2 = Character.toString((char)(rand.nextInt(26) + 'a'));
                            String n = Integer.toString(rand.nextInt(10));
                            String plane_id = c1 + c2 + n;

                            Planes newPlane = new Planes(planeName, plane_id, true, new ArrayList<>(),
                                    0,personnelCapacity,new ArrayList<>(),0,cargoCapacity);

                            FirestoreQuery fq = new FirestoreQuery();
                            fq.addPlane(newPlane);

                            planeNameInput.getText().clear();
                            personnelCapacityInput.getText().clear();
                            cargoCapacityInput.getText().clear();

                            Toast.makeText(getApplicationContext(), "Plane added", Toast.LENGTH_SHORT).show();
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

    }
}
