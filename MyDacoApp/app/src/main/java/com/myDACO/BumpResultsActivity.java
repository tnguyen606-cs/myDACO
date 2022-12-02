package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.myDACO.data.Cargo;
import com.myDACO.data.Planes;
import com.myDACO.data.Personnel;
import com.myDACO.data.BumpResult;
import com.myDACO.searching.SearchCargoActivity;
import com.myDACO.searching.SearchPlaneActivity;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.PlaneArrayAdapter;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class BumpResultsActivity extends AppCompatActivity {

    BumpResult bumpResult;
    PlaneArrayAdapter downedPlanesAdapter;
    PersonnelArrayAdapter reassignedPersonnelAdapter;
    CargoArrayAdapter reassignedCargoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bump_results);

        bumpResult = (BumpResult) getIntent().getSerializableExtra("BUMPRESULTS");

        // Get passed in lists of personnel, cargo, and planes
        List<Planes> downedPlanesList = bumpResult.getDownedPlanes();
        List<Cargo> cargoList = bumpResult.getReassignedCargo();
        List<Personnel> personnelList = bumpResult.getReassignedPersonnel();

        // Get the handle for ListViews
        ListView downedPlanesListView = (ListView) findViewById(R.id.downed_planes_list);
        ListView reassignedPersonnelListView = (ListView) findViewById(R.id.reassigned_personnel_list);
        ListView reassignedCargoListView = (ListView) findViewById(R.id.reassigned_cargo_list);

        // Create array adapters
        downedPlanesAdapter = new PlaneArrayAdapter(this, downedPlanesList);
        reassignedPersonnelAdapter = new PersonnelArrayAdapter(this, personnelList);
        reassignedCargoAdapter = new CargoArrayAdapter(this, cargoList);

        // Set the adapter with the ListView
        downedPlanesListView.setAdapter(downedPlanesAdapter);
        reassignedPersonnelListView.setAdapter(reassignedPersonnelAdapter);
        reassignedCargoListView.setAdapter(reassignedCargoAdapter);

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(BumpResultsActivity.this, menuIcon);

        // User clicks search button
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(BumpResultsActivity.this, SearchPlaneActivity.class);
                BumpResultsActivity.this.startActivity(nextScreen);
            }
        });
    }

}
