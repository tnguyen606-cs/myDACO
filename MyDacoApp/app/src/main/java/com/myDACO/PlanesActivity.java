package com.myDACO;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PlaneArrayAdapter;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PlanesActivity extends AppCompatActivity {
    int chkId = 1001;
    private String plane_position;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    String selectedPlanes;
    static List<Planes> planesList = new ArrayList<>();
    PlaneArrayAdapter planeAdapter;
    ListenerRegistration planeListener;
    //private AbsListView listView;


    @Override
    public void onStart(){
        super.onStart();

        //listens for changes to the firestore databases in real time
        ListenerRegistration planeListener = db.collection("planes").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                planesList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Planes plane = document.toObject(Planes.class);
                    planesList.add(plane);
                    planeAdapter.notifyDataSetChanged();
                }

            }
        });
        //selectedPlanes = planesList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_manifest);
        //this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Open JSON file and extract to List
        FileHelper file = new FileHelper();
        InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
        JSONArray jsonArray = file.convertJSONtoArray(inputStream, "planes");
        // List<Planes> planesList = file.toList(jsonArray);


        // If a removed plane is selected, remove that plane and update the list
        Intent intent = getIntent();
        plane_position = intent.getStringExtra("REMOVED_PLANE_AT");
        if (plane_position != null) {
            int i = 0;
            try {
                i = Integer.parseInt(plane_position);
                planesList.remove(i);
            } catch (NumberFormatException nfe) {
                System.out.println("Could not parse " + i);
            }
        }

        // Get the handle for ListView
        ListView listView = (ListView) findViewById(R.id.planes_list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Specify an adapter and pass context along with all the arrays in constructor
        planeAdapter = new PlaneArrayAdapter(this, planesList);


        // Set the adapter with the ListView
        listView.setAdapter(planeAdapter);

        // Go to view screen of a single plane
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(PlanesActivity.this, SinglePlaneActivity.class);
                nextScreen.putExtra("PLANE_TEXT", planesList.get(position).getPlaneName());
                nextScreen.putExtra("PLANE_POSITION", String.valueOf(position));
                nextScreen.putExtra("PLANE_ACTIVE", String.valueOf(planesList.get(position).isActive()));
                PlanesActivity.this.startActivity(nextScreen);
            }
        });

        // Go to mission activity
        Button missionBtn = (Button) findViewById(R.id.missionBtn);
        missionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast("check");

                Intent nextScreen = new Intent(PlanesActivity.this, MissionActivity.class);
                PlanesActivity.this.startActivity(nextScreen);
            }
        });

        // Go to add plane activity
        ImageView editIcon = (ImageView) findViewById(R.id.add_plane);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(PlanesActivity.this, AddPlaneActivity.class);
                PlanesActivity.this.startActivity(nextScreen);

            }
        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            selectedPlanes+= view.toString();
        }

    }
    /*public void startMission(View view) {
        displayToast("sfdsfdfs");
    }*/
    public void displayToast(String message) {
        Toast.makeText(getBaseContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}


