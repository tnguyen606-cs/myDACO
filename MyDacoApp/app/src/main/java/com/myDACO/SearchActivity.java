package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Planes;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Planes> planesList = new ArrayList<>();
    static List<Planes> singlePlane = new ArrayList<>();
    PlaneArrayAdapter planeAdapter;

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
                    try{
                        Planes plane = document.toObject(Planes.class);
                        planesList.add(plane);
                        planeAdapter.notifyDataSetChanged();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                Collections.sort(planesList, new Comparator<Planes>() {
                    public int compare(Planes p1, Planes p2) {
                        return p1.getPlaneName().compareTo(p2.getPlaneName());
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);

        EditText searchText = (EditText) findViewById(R.id.search_box);

        Button search_Btn = (Button) findViewById(R.id.search_btn);
        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = searchText.getText().toString();
                boolean found = false;
                // Search the name of the plane
                for (Planes p : planesList) {
                    if (text.equals(p.getPlaneName())) {
                        singlePlane.add(p);
                        found = true;
                        break;
                    }
                }
                Log.d("Text............", String.valueOf(singlePlane.size()));
                if (!found) {
                    searchText.setError("No matching value has found regarding the search");
                }
                // Get the handle for ListView
                ListView listView = (ListView) findViewById(R.id.search_list);
                planeAdapter = new PlaneArrayAdapter(SearchActivity.this, singlePlane);
                listView.setAdapter(planeAdapter);
                // Go to view screen of a single plane
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent nextScreen = new Intent(SearchActivity.this, SinglePlaneActivity.class);
                        nextScreen.putExtra("PLANE_TEXT", singlePlane.get(position).getPlaneName());
                        nextScreen.putExtra("PLANE_POSITION", String.valueOf(position));
                        nextScreen.putExtra("PLANE_ID", singlePlane.get(position).getId());
                        SearchActivity.this.startActivity(nextScreen);
                    }
                });
            }
        });

        // Close the window
        // Go to add plane activity
        ImageView closeIcon = (ImageView) findViewById(R.id.close_icon);
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                finish();
            }
        });

    }
}
