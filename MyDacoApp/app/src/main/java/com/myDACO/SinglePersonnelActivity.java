package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.utilities.FileHelper;

public class SinglePersonnelActivity extends AppCompatActivity {

    private EditText personnel_fname;
    private EditText personnel_lname;
    private EditText personnel_id;
    private EditText personnel_weight;
    private EditText personnel_priority;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_personnel);

        // Get the selected cargo from "ListOfPersonnelActivity.class"
        Intent intent = getIntent();
        String fpersonnel = intent.getStringExtra("PERSONNEL_FTEXT");
        String lpersonnel = intent.getStringExtra("PERSONNEL_LTEXT");
        String id = intent.getStringExtra("PERSONNEL_ID");
        int weight = intent.getIntExtra("PERSONNEL_WEIGHT", 0);
        int priority = intent.getIntExtra("PERSONNEL_PRIORITY", 0);

        // Get the values of EditText
        personnel_fname = (EditText) findViewById(R.id.personnel_fname_input);
        personnel_lname = (EditText) findViewById(R.id.personnel_lname_input);
        personnel_id = (EditText) findViewById(R.id.personnel_id_input);
        personnel_weight = (EditText) findViewById(R.id.personnel_weight_input);
        personnel_priority = (EditText) findViewById(R.id.personnel_priority_input);

        personnel_fname.setHint(fpersonnel);
        personnel_lname.setHint(lpersonnel);
        personnel_id.setHint(id);
        personnel_weight.setHint(String.valueOf(weight));
        personnel_priority.setHint(String.valueOf(priority));


        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SinglePersonnelActivity.this, menuIcon);
    }
}
