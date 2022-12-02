package com.myDACO.searching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.ListOfCargosActivity;
import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.PlanesActivity;
import com.myDACO.R;
import com.myDACO.SinglePersonnelActivity;
import com.myDACO.SinglePlaneActivity;
import com.myDACO.data.Cargo;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.PersonnelArrayAdapter;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchCargoActivity extends AppCompatActivity {

    private List<Cargo>  cargo = new ArrayList<>();
    private CargoArrayAdapter cargoAdapter;

    private EditText searchText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);

        searchText = (EditText) findViewById(R.id.search_box);

        Button search_Btn = (Button) findViewById(R.id.search_btn);
        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchItem();
            }
        });

        // Close the window
        // Go to add plane activity
        ImageView closeIcon = (ImageView) findViewById(R.id.close_icon);
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go back
                Intent nextScreen = new Intent(SearchCargoActivity.this, ListOfCargosActivity.class);
                SearchCargoActivity.this.startActivity(nextScreen);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent nextScreen = new Intent(SearchCargoActivity.this, ListOfCargosActivity.class);
        SearchCargoActivity.this.startActivity(nextScreen);
    }

    private void searchItem() {
        String text = searchText.getText().toString();
        boolean found = false;
        // Search the name of the plane
        for (Cargo c : ListOfCargosActivity.cargoList) {
            if (text.equals(c.getCargoName())) {
                found = true;
                cargo.add(c);
                // Get the handle for ListView
                ListView listView = (ListView) findViewById(R.id.search_list);
                cargoAdapter = new CargoArrayAdapter(SearchCargoActivity.this, cargo);
                listView.setAdapter(cargoAdapter);
                // Go to view screen of a single plane
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent nextScreen = new Intent(SearchCargoActivity.this, SinglePersonnelActivity.class);
                        nextScreen.putExtra("CARGO", cargo.get(position));
                        SearchCargoActivity.this.startActivity(nextScreen);
                    }
                });
                searchText.getText().clear();
                break;
            }
        }
        if (!found) {
            searchText.setError("No matching item has been found");
        }
    }
}
