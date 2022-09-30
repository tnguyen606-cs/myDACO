package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SinglePlaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

        Intent intent = getIntent();
        String plane_name = intent.getStringExtra("PLANE_TEXT");
        TextView planeText = (TextView) findViewById(R.id.plane_text);
        planeText.setText(plane_name + " Manifest");

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

                }
                return false;
            }
        });
        popupMenu.show();
    }
}
