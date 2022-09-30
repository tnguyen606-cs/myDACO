package com.myDACO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.io.InputStream;
import java.util.List;

public class PlanesActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_manifest);

        InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
        FileHelper file = new FileHelper();
        List<Planes> planesList = file.toList(inputStream);

        // Get the handle for ListView
        ListView listView = (ListView) findViewById(R.id.planes_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        PlaneArrayAdapter planeAdapter = new PlaneArrayAdapter(this, planesList);

        // Set the adapter with the ListView
        listView.setAdapter(planeAdapter);

        // Go to view screen of a single plane
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(PlanesActivity.this, SinglePlaneActivity.class);
                nextScreen.putExtra("PLANE_TEXT", planesList.get(position).getPlane());
                PlanesActivity.this.startActivity(nextScreen);
            }
        });
    }
}
