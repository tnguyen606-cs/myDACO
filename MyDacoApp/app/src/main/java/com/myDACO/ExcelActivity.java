package com.myDACO;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExcelActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox plane, cargo, personnel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_dialog);

        // initiate views
        plane = (CheckBox) findViewById(R.id.planeCheckBox);
        cargo = (CheckBox) findViewById(R.id.cargoCheckBox);
        personnel = (CheckBox) findViewById(R.id.personnelCheckBox);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.planeCheckBox:
                if (plane.isChecked())
                    Toast.makeText(getApplicationContext(), "Plane", Toast.LENGTH_LONG).show();
                break;
            case R.id.cargoCheckBox:
                if (cargo.isChecked())
                    Toast.makeText(getApplicationContext(), "Cargos", Toast.LENGTH_LONG).show();
                break;
            case R.id.personnelCheckBox:
                if (personnel.isChecked())
                    Toast.makeText(getApplicationContext(), "Personnel", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
