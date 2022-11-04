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
        id = intent.getStringExtra("PERSONNEL_ID");
        String fpersonnel = intent.getStringExtra("PERSONNEL_FTEXT");
        String lpersonnel = intent.getStringExtra("PERSONNEL_LTEXT");
        String planedid = intent.getStringExtra("PERSONNEL_planeID");
        String weight = intent.getStringExtra("PERSONNEL_WEIGHT");
        String priority = intent.getStringExtra("PERSONNEL_PRIORITY");
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
        String fname = person.getFirstName();
        String lname = person.getLastName();
        String pId = person.getAssignedPlaneID();
        String weight = person.getWeight();
        String priority = person.getPriority();
        boolean isChanged = false;

        // 1. Check if any text field is changed, then update them to firebase
        FirestoreQuery fq = new FirestoreQuery();
        if (!fname.equals(personnel_fname.getText().toString())) {
            isChanged = true;
            fq.updatePersonnel("firstName", personnel_fname.getText().toString(), id);
            Toast.makeText(getApplicationContext(), "You did update " + personnel_fname.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (!lname.equals(personnel_lname.getText().toString())) {
            isChanged = true;
            fq.updatePersonnel("lastName", personnel_lname.getText().toString(), id);
            Toast.makeText(getApplicationContext(), "You did update " + personnel_lname.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (!pId.equals(personnel_id.getText().toString())) {
            isChanged = true;
            fq.updatePersonnel("assignedPlaneID", personnel_id.getText().toString(), id);
            Toast.makeText(getApplicationContext(), "You did update " + personnel_id.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (!(weight).equals(personnel_weight.getText().toString())) {
            isChanged = true;
            fq.updatePersonnel("weight", personnel_weight.getText().toString(), id);
            Toast.makeText(getApplicationContext(), "You did update " + personnel_weight.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (!(priority).equals(personnel_priority.getText().toString())) {
            isChanged = true;
            fq.updatePersonnel("priority", personnel_priority.getText().toString(), id);
            Toast.makeText(getApplicationContext(), "You did update " + personnel_priority.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (!isChanged) {
            Toast.makeText(getApplicationContext(), "You did not update anything", Toast.LENGTH_SHORT).show();
        }
    }
}
