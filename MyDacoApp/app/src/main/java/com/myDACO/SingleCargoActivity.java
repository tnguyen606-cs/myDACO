package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.utilities.FileHelper;

public class SingleCargoActivity extends AppCompatActivity {

    private EditText cargo_name;
    private EditText cargo_id;
    private EditText cargo_weight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_cargo);

        // Get the selected cargo from "ListOfCarosActivity.class"
        Intent intent = getIntent();
        String cargo = intent.getStringExtra("CARGO_TEXT");
        String id = intent.getStringExtra("CARGO_ID");
        int weight = intent.getIntExtra("CARGO_WEIGHT", 0);

        // Get the values of EditText
        cargo_name = (EditText) findViewById(R.id.cargo_name_input);
        cargo_id = (EditText) findViewById(R.id.cargo_id_input);
        cargo_weight = (EditText) findViewById(R.id.cargo_weight_input);

        cargo_name.setHint(cargo);
        cargo_id.setHint(id);
        cargo_weight.setHint(String.valueOf(weight));

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(SingleCargoActivity.this, menuIcon);

    }
}
