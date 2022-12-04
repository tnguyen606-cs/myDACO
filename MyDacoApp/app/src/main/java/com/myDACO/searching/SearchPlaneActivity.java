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

import com.myDACO.PlanesActivity;
import com.myDACO.R;
import com.myDACO.SinglePlaneActivity;
import com.myDACO.data.Planes;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchPlaneActivity extends AppCompatActivity {

    private List<Planes> singlePlane = new ArrayList<>();
    private PlaneArrayAdapter planeAdapter;

    private EditText searchText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);

        singlePlane.clear();

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
                finish();
            }
        });
    }

    private void searchItem() {
        String text = searchText.getText().toString();
        boolean found = false;
        // Search a name of the input plane
        for (Planes p : PlanesActivity.planesList) {
            if (text.equals(p.getPlaneName())) {
                found = true;
                singlePlane.add(p);
                // Get the handle for ListView
                ListView listView = (ListView) findViewById(R.id.search_list);
                planeAdapter = new PlaneArrayAdapter(SearchPlaneActivity.this, singlePlane);
                listView.setAdapter(planeAdapter);
                // Go to view screen of a single plane
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent nextScreen = new Intent(SearchPlaneActivity.this, SinglePlaneActivity.class);
                        nextScreen.putExtra("PLANE", singlePlane.get(position));
                        SearchPlaneActivity.this.startActivity(nextScreen);
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
