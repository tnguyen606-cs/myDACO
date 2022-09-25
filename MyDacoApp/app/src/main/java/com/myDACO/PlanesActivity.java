package com.myDACO;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        setContentView(R.layout.main_planes_screen);

        InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
        FileHelper file = new FileHelper();
        List<Planes> planesList = file.toList(inputStream);
        String[] planes = new String[planesList.size()];
        for (int i = 0; i < planesList.size(); i++) {
            planes[i] = planesList.get(i).getPlane();
        }

        // Get the handle for ListView
        ListView list = (ListView) findViewById(R.id.planes_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        PlaneArrayAdapter planeAdapter = new PlaneArrayAdapter(this, planes);

        // Set the adapter with the ListView
        list.setAdapter(planeAdapter);
    }
}
