package com.myDACO.utilities;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.myDACO.ListOfCargosActivity;
import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.MissionActivity;
import com.myDACO.PlanesActivity;
import com.myDACO.MainActivity;
import com.myDACO.R;

public class FileHelper extends AppCompatActivity {

    private boolean isNotchecked = true;
    private Activity thisContext;

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
//                Log.d("Print:   ", "Plane");
                if (plane.isChecked()) {
                    Toast.makeText(context.getApplicationContext(), "Excelled Planes to Firebase", Toast.LENGTH_LONG).show();
                } else if (cargo.isChecked()) {
                    Toast.makeText(context.getApplicationContext(), "Excelled Cargos to Firebase", Toast.LENGTH_LONG).show();
                } else if (personnel.isChecked()) {
                    Toast.makeText(context.getApplicationContext(), "Excelled Personnel to Firebase", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context.getApplicationContext(), "Please make sure you checked one of the box!", Toast.LENGTH_LONG).show();
                    isNotchecked = false;
                }
                if (isNotchecked) {
                    importExcelFile(context);
                    dialog.dismiss();
                }
            }
        }));
        dialog.show();
    }

    private void importExcelFile(Activity context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            selectfile(context);
        } else {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
        }
    }

//    // request for storage permission if not given
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 101) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                selectfile();
//            } else {
//                Log.d("Print:   ", "Permission Not granted");
////                Toast.makeText(thisContext, "Permission Not granted", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//
    private void selectfile(Activity context) {
        // select the file from the file storage
        Intent chooseFile = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
        chooseFile.setType("*/*");
        Intent intentFile = Intent.createChooser(chooseFile, "Choose a file");
        context.startActivityForResult(intentFile, 102);
        Log.w("Print:   ", "Permission Not granted");
    }

//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 102) {
//            if (resultCode == RESULT_OK) {
//                String filepath = data.getData().getPath();
//                // If excel file then only select the file
//                if (filepath.endsWith(".xlsx") || filepath.endsWith(".xls")) {
////                    readfile(data.getData());
//                    Log.d("Print:   ", "Plane");
//                }
//                // else show the error
//                else {
//                    Log.d("Print:   ", "Plane");
//                }
//            }
//        }
//    }
}
