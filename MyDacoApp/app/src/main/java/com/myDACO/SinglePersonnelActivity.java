package com.myDACO;

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

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.searching.SearchPersonnelActivity;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

public class SinglePersonnelActivity extends AppCompatActivity {

    private EditText personnel_fname;
    private EditText personnel_lname;
    private Spinner assignedPlaneDropdown;
    private EditText personnel_weight;
    private EditText personnel_priority;
    private Button updateBtn;
    private Personnel person;
    private ArrayAdapter<Planes> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_personnel);

        // Get the selected cargo from "ListOfPersonnelActivity.class"
        person = (Personnel) getIntent().getSerializableExtra("PERSONNEL");

        // Get the values of EditText
        personnel_fname = (EditText) findViewById(R.id.personnel_fname_input);
        personnel_lname = (EditText) findViewById(R.id.personnel_lname_input);
        personnel_weight = (EditText) findViewById(R.id.personnel_weight_input);
        personnel_priority = (EditText) findViewById(R.id.personnel_priority_input);
        assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<Planes>(this,R.layout.spinner_item, PlanesActivity.planesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set default input fields to stored values
        personnel_fname.setHint(person.getFirstName());
        personnel_lname.setHint(person.getLastName());
        personnel_weight.setHint(String.valueOf(person.getWeight()));
        personnel_priority.setHint(String.valueOf(person.getPriority()));
        assignedPlaneDropdown.setAdapter(adapter);

        // Button is clicked to update
        updateBtn = (Button) findViewById(R.id.update_personnel_button);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked();
            }
        });

        // Search for an item
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(SinglePersonnelActivity.this, SearchPersonnelActivity.class);
                SinglePersonnelActivity.this.startActivity(nextScreen);

            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SinglePersonnelActivity.this, menuIcon);
    }

    private void isClicked() {
        FirestoreQuery fq = new FirestoreQuery();

        String fname = personnel_fname.getText().toString().matches("") ? person.getFirstName() : personnel_fname.getText().toString();
        String lname = personnel_lname.getText().toString().matches("") ? person.getLastName() : personnel_lname.getText().toString();
        Planes plane = (Planes) assignedPlaneDropdown.getSelectedItem();
        String pId = plane.getId();
        int priority = personnel_priority.getText().toString().matches("") ? person.getPriority() : Integer.parseInt(personnel_priority.getText().toString());
        int weight = personnel_weight.getText().toString().matches("") ? person.getWeight() : Integer.parseInt(personnel_weight.getText().toString());

        Personnel updatedPersonnel = new Personnel(fname, lname, pId, person.getId(), priority, weight);
        if (person.equals(updatedPersonnel)) {
            Toast.makeText(getApplicationContext(), "You did not make any change", Toast.LENGTH_SHORT).show();
        } else { // If a person is updated or not,
            // If the plane assigned is different from the current plane, call the reassign query before updating personnel.
            fq.reassignPersonnel(updatedPersonnel, pId);
            Toast.makeText(getApplicationContext(), "Personnel is updated", Toast.LENGTH_SHORT).show();
        }

        // Go back to the list view
        Intent nextScreen = new Intent(SinglePersonnelActivity.this, ListOfPersonnelActivity.class);
        SinglePersonnelActivity.this.startActivity(nextScreen);

    }
}
