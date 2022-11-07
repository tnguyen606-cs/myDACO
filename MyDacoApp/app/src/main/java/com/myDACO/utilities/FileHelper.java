package com.myDACO.utilities;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;
import com.myDACO.ListOfCargosActivity;
import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.MainActivity;
import com.myDACO.R;

public class FileHelper {

    public void showMenu(Context context, ImageView menuIcon) {
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.page_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.cargo_item:
                                Intent intent1 = new Intent(context, ListOfCargosActivity.class);
                                context.startActivity(intent1);
                                break;

                            case R.id.personnel_item:
                                Intent intent2 = new Intent(context, ListOfPersonnelActivity.class);
                                context.startActivity(intent2);
                                break;
                                
                            case R.id.planes_manifest_item:
                                Intent intent3 = new Intent(context, PlanesActivity.class);
                                context.startActivity(intent3);
                                break;

                            case R.id.sign_out_item:
                                FirebaseAuth myAuth = FirebaseAuth.getInstance();
                                myAuth.signOut();
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                                break;

                            default:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
