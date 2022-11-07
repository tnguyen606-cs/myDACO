package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Cargo;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SingleCargoActivity extends AppCompatActivity {

    private EditText cargo_name;
    private Spinner assignedPlaneDropdown;
    private EditText cargo_weight;
    private Button updateBtn;
    private Cargo cargo;

    private ArrayList<String> cargoList = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayAdapter<String> adapter;

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
                cargoList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Planes plane = document.toObject(Planes.class);
                    cargoList.add(plane.getId());
                    adapter.notifyDataSetChanged();
                }
                Collections.sort(cargoList, new Comparator<String>() {
                    public int compare(String p1, String p2) {
                        return p1.compareTo(p2);
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_cargo);

        // Get the selected cargo from "ListOfCarosActivity.class"
        Intent intent = getIntent();
        String cName = intent.getStringExtra("CARGO_TEXT");
        String planeId = intent.getStringExtra("CARGO_planeID");
        String id = intent.getStringExtra("CARGO_ID");
        int weight = intent.getIntExtra("CARGO_WEIGHT", 0);
        cargo = new Cargo(cName, planeId, id, weight);

        // Get the values of EditText
        cargo_name = (EditText) findViewById(R.id.cargo_name_input);
        assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, cargoList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cargo_weight = (EditText) findViewById(R.id.cargo_weight_input);

        cargo_name.setHint(cargo.getCargoName());
        assignedPlaneDropdown.setAdapter(adapter);
        cargo_weight.setHint(String.valueOf(weight));

        // Button is clicked to update
        updateBtn = (Button) findViewById(R.id.update_personnel_button);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked();
            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SingleCargoActivity.this, menuIcon);
    }

    private void isClicked() {
        FirestoreQuery fq = new FirestoreQuery();

        String name = cargo_name.getText().toString().matches("") ? cargo.getCargoName() : cargo_name.getText().toString();
        String pId = (String) assignedPlaneDropdown.getSelectedItem();
        int weight = cargo_weight.getText().toString().matches("") ? cargo.getWeight() : Integer.parseInt(cargo_weight.getText().toString());

        Cargo c = new Cargo(name, pId, cargo.getId(), weight);

        if (cargo.equals(c)) {
            Toast.makeText(getApplicationContext(), "You did not make any change", Toast.LENGTH_SHORT).show();
        } else {
            // If an assinged plane is updated, update it in Firebase of planes
            if (!(pId.matches(cargo.getAssignedPlaneID()))) {
                fq.updatePlaneField("assignedCargo", cargo.getId(), pId);
            }
            fq.updateCargo(cargo.getId(), c);
            Toast.makeText(getApplicationContext(), "Cargo is updated", Toast.LENGTH_SHORT).show();
        }

        // Go back to the list view
        Intent nextScreen = new Intent(SingleCargoActivity.this, ListOfPersonnelActivity.class);
        SingleCargoActivity.this.startActivity(nextScreen);
    }
}
