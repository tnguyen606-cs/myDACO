package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.myDACO.data.Cargo;
import com.myDACO.data.Planes;
import com.myDACO.searching.SearchCargoActivity;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

public class SingleCargoActivity extends AppCompatActivity {

    private EditText cargo_name;
    private EditText cargo_weight;
    private Spinner assignedPlaneDropdown;
    private Button updateBtn;
    private Cargo cargo;
    private ArrayAdapter<Planes> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_cargo);

        // Get the selected cargo from "ListOfCarosActivity.class"
        cargo = (Cargo) getIntent().getSerializableExtra("CARGO");

        // Get the values of EditText
        cargo_name = (EditText) findViewById(R.id.cargo_name_input);
        cargo_weight = (EditText) findViewById(R.id.cargo_weight_input);
        assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<Planes>(this,R.layout.spinner_item, PlanesActivity.planesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cargo_name.setHint(cargo.getCargoName());
        cargo_weight.setHint(String.valueOf(cargo.getWeight()));
        assignedPlaneDropdown.setAdapter(adapter);

        // Button is clicked to update
        updateBtn = (Button) findViewById(R.id.update_cargo_button);
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
                Intent nextScreen = new Intent(SingleCargoActivity.this, SearchCargoActivity.class);
                SingleCargoActivity.this.startActivity(nextScreen);
            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SingleCargoActivity.this, menuIcon);
    }

    private void isClicked() {
        FirestoreQuery fq = new FirestoreQuery();

        String name = cargo_name.getText().toString().matches("") ? cargo.getCargoName() : cargo_name.getText().toString();
        Planes plane = (Planes) assignedPlaneDropdown.getSelectedItem();
        String pId = plane.getId();
        int weight = cargo_weight.getText().toString().matches("") ? cargo.getWeight() : Integer.parseInt(cargo_weight.getText().toString());

        Cargo updatedCargo = new Cargo(name, pId, cargo.getId(), weight);

        if (cargo.equals(updatedCargo)) {
            Toast.makeText(getApplicationContext(), "You did not make any change", Toast.LENGTH_SHORT).show();
        } else {
            // If an assigned plane is updated, update it in Firebase of planes
            if (!(pId.matches(cargo.getAssignedPlaneID()))) {
                fq.reassignCargo(cargo, pId);
            }
            fq.updateCargo(cargo.getId(), updatedCargo);
            Toast.makeText(getApplicationContext(), "Cargo is updated", Toast.LENGTH_SHORT).show();
        }

        // Go back to the list view
        Intent nextScreen = new Intent(SingleCargoActivity.this, ListOfPersonnelActivity.class);
        SingleCargoActivity.this.startActivity(nextScreen);
    }
}
