package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;

import java.io.InputStream;
import java.util.List;

public class SinglePlaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

        Intent intent = getIntent();
        String plane_position = intent.getStringExtra("PLANE_POSITION");
        int index = Integer.valueOf(plane_position);

        InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
        FileHelper file = new FileHelper();
        List<Planes> planesList = file.toList(inputStream);
        Planes singlePlane = planesList.get(index);

        String plane_name = singlePlane.getPlane();
        TextView planeText = (TextView) findViewById(R.id.plane_text);
        planeText.setText(plane_name + " Manifest");

        // Get the handle for ListView
        ListView cargoListView = (ListView) findViewById(R.id.cargo_list);
        ListView passengerListView = (ListView) findViewById(R.id.passenger_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        ArrayAdapter cargoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedCargo());
        ArrayAdapter personnelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedPersonnel());

        // Set the adapter with the ListView
        cargoListView.setAdapter(cargoAdapter);
        passengerListView.setAdapter(personnelAdapter);

        ImageView editIcon = (ImageView) findViewById(R.id.edit_icon);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(SinglePlaneActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.plane_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.edit_icon) {

                } else if (menuItem.getItemId() == R.id.delete) {
                    InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
                    FileHelper file = new FileHelper();


                }
                return false;
            }
        });
        popupMenu.show();
    }
}
