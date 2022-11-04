package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.data.Personnel;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

import java.util.ArrayList;
import java.util.List;

public class SinglePersonnelActivity extends AppCompatActivity {

    private EditText personnel_fname;
    private EditText personnel_lname;
    private EditText personnel_id;
    private EditText personnel_weight;
    private EditText personnel_priority;
    private Button updateBtn;
    private Personnel person;
    private String id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_personnel);

        // Get the selected cargo from "ListOfPersonnelActivity.class"
        Intent intent = getIntent();
        String fpersonnel = intent.getStringExtra("PERSONNEL_FTEXT");
        String lpersonnel = intent.getStringExtra("PERSONNEL_LTEXT");
        String planedid = intent.getStringExtra("PERSONNEL_planeID");
        String weight = intent.getStringExtra("PERSONNEL_WEIGHT");
        String priority = intent.getStringExtra("PERSONNEL_PRIORITY");
        id = intent.getStringExtra("PERSONNEL_ID");
        person = new Personnel(fpersonnel, lpersonnel, planedid, id, priority, weight);

//        FirestoreQuery fq = new FirestoreQuery();
//        ArrayList<Personnel> pList = fq.searchForPersonnel("id", id);
//        Log.d("FirestoreQuery 2", " Found that person " + pList.size());

        // Get the values of EditText
        personnel_fname = (EditText) findViewById(R.id.personnel_fname_input);
        personnel_lname = (EditText) findViewById(R.id.personnel_lname_input);
        personnel_id = (EditText) findViewById(R.id.personnel_id_input);
        personnel_weight = (EditText) findViewById(R.id.personnel_weight_input);
        personnel_priority = (EditText) findViewById(R.id.personnel_priority_input);

        // Set default input fields to stored values
        personnel_fname.setHint(person.getFirstName());
        personnel_lname.setHint(person.getLastName());
        personnel_id.setHint(person.getAssignedPlaneID());
        personnel_weight.setHint(person.getWeight());
        personnel_priority.setHint(person.getPriority());

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
        final String fname = personnel_fname.getText().toString();
        final String lname = personnel_lname.getText().toString();
        final String pId = personnel_id.getText().toString();
        final String weight = personnel_weight.getText().toString();
        final String priority = personnel_priority.getText().toString();
        boolean isChanged = false;

        // 1. Check if any text field is changed, then update them to firebase
        FirestoreQuery fq = new FirestoreQuery();
        if (!(fname.matches(person.getFirstName()))) {
            isChanged = true;
            Log.d("FirestoreQuery 1", " Found that person " + fname);
            fq.updatePersonnel("firstName", fname, id);
        }
        if (!(lname.matches(person.getLastName()))) {
            isChanged = true;
            Log.d("FirestoreQuery 2", " Found that person " + fname);
            fq.updatePersonnel("lastName", lname, id);
        }
        if (!(pId.matches(person.getAssignedPlaneID()))) {
            isChanged = true;
            Log.d("FirestoreQuery 3", " Found that person " + fname);
            fq.updatePersonnel("assignedPlaneID", pId, id);
        }
        if (!(weight.matches(person.getWeight()))) {
            isChanged = true;
            Log.d("FirestoreQuery 4", " Found that person " + fname);
            fq.updatePersonnel("weight", weight, id);
        }
        if (!(priority.matches(person.getPriority()))) {
            isChanged = true;
            Log.d("FirestoreQuery 5", " Found that person " + fname);
            fq.updatePersonnel("priority", priority, id);
        }
        if (!isChanged) {
            Toast.makeText(getApplicationContext(), "You did not update anything", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "You Did update", Toast.LENGTH_SHORT).show();
        }
    }
}
