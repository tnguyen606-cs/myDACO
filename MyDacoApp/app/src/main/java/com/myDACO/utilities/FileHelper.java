package com.myDACO.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;
import com.myDACO.ListOfCargosActivity;
import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.MissionActivity;
import com.myDACO.PlanesActivity;
import com.myDACO.MainActivity;
import com.myDACO.R;

public class FileHelper {

    public void showMenu(Activity context, ImageView menuIcon) {
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

                            case R.id.mission_manifest_item:
                                Intent intent4 = new Intent(context, MissionActivity.class);
                                context.startActivity(intent4);
                                break;

                            case R.id.excel_item:
                                showCustomDialog(context);
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

    void showCustomDialog(Activity context) {
        Dialog dialog = new Dialog(context);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog by clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.activity_excel_dialog);

        //Initializing the views of the dialog.
        Button cancelBtn = dialog.findViewById(R.id.cancelBtn);
        Button confirmBtn = dialog.findViewById(R.id.confirmBtn);

        // Buttons' listener
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        confirmBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        }));

        dialog.show();
    }
}
