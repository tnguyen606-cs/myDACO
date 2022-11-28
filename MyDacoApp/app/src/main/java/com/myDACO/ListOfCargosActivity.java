package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.myDACO.data.Cargo;
import com.myDACO.searching.SearchCargoActivity;
import com.myDACO.utilities.CargoArrayAdapter;
import com.myDACO.utilities.FileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfCargosActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static List<Cargo> cargoList = new ArrayList<>();
    private CargoArrayAdapter cargoAdapter;

    @Override
    public void onStart(){
        super.onStart();

        //listens for changes to the firestore databases in real time
        ListenerRegistration cargoListener = db.collection("cargo").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                cargoList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Cargo cargo = document.toObject(Cargo.class);
                    cargoList.add(cargo);
                    cargoAdapter.notifyDataSetChanged();
                }
                Collections.sort(cargoList, new Comparator<Cargo>() {
                    public int compare(Cargo c1, Cargo c2) {
                        return c1.getCargoName().compareTo(c2.getCargoName());
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargo_master_list_screen);

        // Get the list view of cargos
        ListView listView = (ListView) findViewById(R.id.cargo_list);
        cargoAdapter = new CargoArrayAdapter(this, cargoList);
        listView.setAdapter(cargoAdapter);
        // Go to see a cargo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(ListOfCargosActivity.this, SingleCargoActivity.class);
                nextScreen.putExtra("CARGO", cargoList.get(position));
                ListOfCargosActivity.this.startActivity(nextScreen);
            }
        });

        // Search for an item
        ImageView searchIcon = (ImageView) findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(ListOfCargosActivity.this, SearchCargoActivity.class);
                ListOfCargosActivity.this.startActivity(nextScreen);
            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(ListOfCargosActivity.this, menuIcon);

        // Go to add cargo activity
        ImageView addIcon = (ImageView) findViewById(R.id.add_cargo);
        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(ListOfCargosActivity.this, AddCargoActivity.class);
                ListOfCargosActivity.this.startActivity(nextScreen);

            }
        });
    }
}
