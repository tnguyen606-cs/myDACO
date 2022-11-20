package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.data.Planes;
import com.myDACO.searching.SearchPlaneActivity;
import com.myDACO.utilities.FileHelper;

public class SinglePlaneActivity extends AppCompatActivity {

    private Planes currentPlane;

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
        ArrayAdapter<String> cargoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentPlane.getAssignedCargo());
        ArrayAdapter<String> personnelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentPlane.getAssignedPersonnel());

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
}