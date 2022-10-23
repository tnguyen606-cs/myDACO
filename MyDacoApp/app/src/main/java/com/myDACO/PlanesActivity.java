package com.myDACO;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.*;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PlaneArrayAdapter;
import com.myDACO.utilities.SearchAdapter;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PlanesActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Planes> planesList = new ArrayList<>();
    PlaneArrayAdapter planeAdapter;
    private SearchAdapter adapter;
    private RecyclerView planeRV;

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
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_manifest);

        // Get the handle for ListView
        ListView listView = (ListView) findViewById(R.id.planes_list);

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
                PlanesActivity.this.startActivity(nextScreen);
            }
        });

        // Go to mission activity
        Button missionBtn = (Button) findViewById(R.id.missionBtn);
        missionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create mission class to encapsulate mission planes list, then pass it to the next screen
                Mission currentMission = new Mission(new ArrayList<Planes>());
                Intent nextScreen = new Intent(PlanesActivity.this, MissionActivity.class);
                nextScreen.putExtra("MISSION", currentMission);
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

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(PlanesActivity.this, menuIcon);

        // Search
        planeRV = (RecyclerView) findViewById(R.id.search_view);
        buildRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        Log.d("Print", "printnttttttttt");

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        List<Planes> filteredlist = new ArrayList<Planes>();

        // running a for loop to compare elements.
        for (Planes item : planesList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getPlaneName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {
        // initializing our adapter class.
        adapter = new SearchAdapter(planesList, PlanesActivity.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        planeRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        planeRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        planeRV.setAdapter(adapter);
    }
}


