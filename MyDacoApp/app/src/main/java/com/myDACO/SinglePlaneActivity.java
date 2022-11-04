package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
public class SinglePlaneActivity extends AppCompatActivity {

    private String plane_name;
    private String plane_position = null;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

        // Get all information from the selection Plane
        Intent intent = getIntent();
        plane_name = intent.getStringExtra("PLANE_TEXT");
        TextView planeText = (TextView) findViewById(R.id.plane_text);
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
        ArrayAdapter personnelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedPersonnel());

        // Set the adapter with the ListView
        cargoListView.setAdapter(cargoAdapter);
        passengerListView.setAdapter(personnelAdapter);

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SinglePlaneActivity.this, menuIcon);
    }


}