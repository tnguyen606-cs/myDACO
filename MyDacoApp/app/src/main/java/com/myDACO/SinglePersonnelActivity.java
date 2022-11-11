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
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SinglePersonnelActivity extends AppCompatActivity {

    private EditText personnel_fname;
    private EditText personnel_lname;
    private Spinner assignedPlaneDropdown;
    private EditText personnel_weight;
    private EditText personnel_priority;
    private Button updateBtn;
    private Personnel person;

    private ArrayList<String> planesList = new ArrayList<>();
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
                planesList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Planes plane = document.toObject(Planes.class);
                    planesList.add(plane.getId());
                    adapter.notifyDataSetChanged();
                }
                Collections.sort(planesList, new Comparator<String>() {
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
        setContentView(R.layout.activity_single_personnel);

        // Get the selected cargo from "ListOfPersonnelActivity.class"
        Intent intent = getIntent();
        String fpersonnel = intent.getStringExtra("PERSONNEL_FTEXT");
        String lpersonnel = intent.getStringExtra("PERSONNEL_LTEXT");
        String planedid = intent.getStringExtra("PERSONNEL_planeID");
        int weight = intent.getIntExtra("PERSONNEL_WEIGHT", 0);
        int priority = intent.getIntExtra("PERSONNEL_PRIORITY", 0);
        String id = intent.getStringExtra("PERSONNEL_ID");
        person = new Personnel(fpersonnel, lpersonnel, planedid, id, priority, weight);

        // Get the values of EditText
        personnel_fname = (EditText) findViewById(R.id.personnel_fname_input);
        personnel_lname = (EditText) findViewById(R.id.personnel_lname_input);
        assignedPlaneDropdown = (Spinner) findViewById(R.id.planes_spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, planesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personnel_weight = (EditText) findViewById(R.id.personnel_weight_input);
        personnel_priority = (EditText) findViewById(R.id.personnel_priority_input);

        // Set default input fields to stored values
        personnel_fname.setHint(person.getFirstName());
        personnel_lname.setHint(person.getLastName());
        assignedPlaneDropdown.setAdapter(adapter);
        personnel_weight.setHint(String.valueOf(person.getWeight()));
        personnel_priority.setHint(String.valueOf(person.getPriority()));

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
        file.showMenu(SinglePersonnelActivity.this, menuIcon);
    }

    private void isClicked() {
        FirestoreQuery fq = new FirestoreQuery();

        String fname = personnel_fname.getText().toString().matches("") ? person.getFirstName() : personnel_fname.getText().toString();
        String lname = personnel_lname.getText().toString().matches("") ? person.getLastName() : personnel_lname.getText().toString();
        String pId = (String) assignedPlaneDropdown.getSelectedItem();
        int priority = personnel_priority.getText().toString().matches("") ? person.getPriority() : Integer.parseInt(personnel_priority.getText().toString());
        int weight = personnel_weight.getText().toString().matches("") ? person.getWeight() : Integer.parseInt(personnel_weight.getText().toString());

        Personnel p = new Personnel(fname, lname, pId, person.getId(), priority, weight);

        if (person.equals(p)) {
            Toast.makeText(getApplicationContext(), "You did not make any change", Toast.LENGTH_SHORT).show();
        } else {
            // If an assinged plane is updated, update it in Firebase of planes
            if (!(pId.matches(person.getAssignedPlaneID()))) {
                fq.updatePlaneField("assignedPersonnel", person.getId(), pId);
            }
            fq.updatePersonnel(person.getId(), p);
            Toast.makeText(getApplicationContext(), "Personnel is updated", Toast.LENGTH_SHORT).show();
        }

        // Go back to the list view
        Intent nextScreen = new Intent(SinglePersonnelActivity.this, ListOfPersonnelActivity.class);
        SinglePersonnelActivity.this.startActivity(nextScreen);

    }
}
