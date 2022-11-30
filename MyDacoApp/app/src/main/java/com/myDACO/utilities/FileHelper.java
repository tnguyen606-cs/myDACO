package com.myDACO.utilities;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.myDACO.ListOfCargosActivity;
import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.MissionActivity;
import com.myDACO.PlanesActivity;
import com.myDACO.MainActivity;
import com.myDACO.R;

public class FileHelper {

    private boolean isNotchecked = true;
//    private Activity context;

    public void showMenu(Activity ctx, ImageView menuIcon) {
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ctx, view);
                popupMenu.getMenuInflater().inflate(R.menu.page_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.cargo_item:
                                Intent intent1 = new Intent(ctx, ListOfCargosActivity.class);
                                ctx.startActivity(intent1);
                                break;

                            case R.id.personnel_item:
                                Intent intent2 = new Intent(ctx, ListOfPersonnelActivity.class);
                                ctx.startActivity(intent2);
                                break;
                                
                            case R.id.planes_manifest_item:
                                Intent intent3 = new Intent(ctx, PlanesActivity.class);
                                ctx.startActivity(intent3);
                                break;

                            case R.id.mission_manifest_item:
                                Intent intent4 = new Intent(ctx, MissionActivity.class);
                                ctx.startActivity(intent4);
                                break;

                            case R.id.excel_item:
                                showCustomDialog(ctx);
                                break;

                            case R.id.sign_out_item:
                                FirebaseAuth myAuth = FirebaseAuth.getInstance();
                                myAuth.signOut();
                                Intent intent = new Intent(ctx, MainActivity.class);
                                ctx.startActivity(intent);
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

    void showCustomDialog(Activity ctx) {
        Dialog dialog = new Dialog(ctx);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog by clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.activity_excel_dialog);

        //Initializing the views of the dialog.
        Button cancelBtn = dialog.findViewById(R.id.cancelBtn);
        Button confirmBtn = dialog.findViewById(R.id.confirmBtn);

        // initiate views
        CheckBox plane = (CheckBox) dialog.findViewById(R.id.planeCheckBox);
        CheckBox cargo = (CheckBox) dialog.findViewById(R.id.cargoCheckBox);
        CheckBox personnel = (CheckBox) dialog.findViewById(R.id.personnelCheckBox);

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
                if (plane.isChecked()) {
//                    Toast.makeText(ctx.getApplicationContext(), "Excelled Planes to Firebase", Toast.LENGTH_LONG).show();
                    Log.d("Print:   ", "Plane is clicked");
                } else if (cargo.isChecked()) {
//                    Toast.makeText(ctx.getApplicationContext(), "Excelled Cargos to Firebase", Toast.LENGTH_LONG).show();
                    Log.d("Print:   ", "CArgo is clicked");
                } else if (personnel.isChecked()) {
//                    Toast.makeText(ctx.getApplicationContext(), "Excelled Personnel to Firebase", Toast.LENGTH_LONG).show();
                    Log.d("Print:   ", "Person is clicked");
                } else {
//                    Toast.makeText(ctx.getApplicationContext(), "Please make sure you checked one of the box!", Toast.LENGTH_LONG).show();
                    Log.d("Print:   ", "Please make sure you checked ");
                    isNotchecked = false;
                }
                if (isNotchecked) {
                    if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        selectfile(ctx);
                    } else {
                        ActivityCompat.requestPermissions(ctx, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
                        Log.w("Print:   ", "Permission Not granted plaoajnajnd");
                        onRequestPermissionsFailed(101, ctx);
                    }
                    dialog.dismiss();
                }
                dialog.dismiss();
            }
        }));
        dialog.show();
    }

    // request for storage permission if not given
    public void onRequestPermissionsFailed(int requestCode, Activity ctx) {
        Log.w("Print:   ",  "plaoajnajnd");
        if (requestCode == 101) {
            selectfile(ctx);
        }
    }

    private void selectfile(Activity ctx) {
        // select the file from the file storage
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
        chooseFile.setType("*/*");
        Intent intentFile = Intent.createChooser(chooseFile, "Choose a file");
        ctx.startActivityForResult(intentFile, 102);
        Log.w("Print:   ", "Select File");
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 102) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                // If excel file then only select the file
                if (filepath.endsWith(".xlsx") || filepath.endsWith(".xls")) {
//                    readfile(data.getData());
                    Log.d("Print:   ", "Plane");
                }
                // else show the error
                else {
                    Log.d("Print:   ", "Plane");
                }
            }
        }
    }
}
