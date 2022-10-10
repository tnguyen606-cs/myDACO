package com.myDACO;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;
import com.myDACO.data.Planes;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.FirestoreQuery;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.List;

public class SinglePlaneActivity extends AppCompatActivity {

    private String plane_name;
    private String plane_position = null;
    private boolean plane_isActive;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference planeRef = db.collection("planes");
    FirestoreQuery fq = new FirestoreQuery();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_plane);

      //fix all of this



        // Get all information from the selection Plane
        Intent intent = getIntent();
        plane_isActive = Boolean.parseBoolean(intent.getStringExtra("PLANE_ACTIVE"));
        plane_name = intent.getStringExtra("PLANE_TEXT");
        TextView planeText = (TextView) findViewById(R.id.plane_text);
        planeText.setText(plane_name + " Manifest");
        plane_position = intent.getStringExtra("PLANE_POSITION");
        int index = Integer.valueOf(plane_position);



        //firebase conversion

        Planes singlePlane = PlanesActivity.planesList.get(index);


        // Get the handle for ListView
        ListView cargoListView = (ListView) findViewById(R.id.cargo_list);
        ListView passengerListView = (ListView) findViewById(R.id.passenger_list);

        // Specify an adapter and pass context along with all the arrays in constructor
        ArrayAdapter cargoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedCargo());
        ArrayAdapter personnelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singlePlane.getAssignedPersonnel());

        // Set the adapter with the ListView
        cargoListView.setAdapter(cargoAdapter);
        passengerListView.setAdapter(personnelAdapter);

        // Edit Icon Action
        ImageView editIcon = (ImageView) findViewById(R.id.edit_icon);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view, index);
            }
        });
    }

    public void showMenu(View v, int index) {
        PopupMenu popupMenu = new PopupMenu(SinglePlaneActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.plane_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.edit_name:
                        // Alert Dialog that asks the user for name input
                        final EditText input = new EditText(SinglePlaneActivity.this);

                        // Set the default text to a link of the Queen
                        input.setHint("New plane name");

                        new AlertDialog.Builder(SinglePlaneActivity.this)
                                .setTitle("Edit Plane Name")
                                .setMessage("Please input the new plane name.")
                                .setView(input)
                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String newPlaneName = input.getText().toString();
                                        // Perform update name query
                                        if (newPlaneName.matches("")) {
                                            Toast.makeText(SinglePlaneActivity.this, "Please enter a plane name.",Toast.LENGTH_LONG).show();
                                        } else {
                                            planeRef.whereEqualTo("id", PlanesActivity.planesList.get(index).getId())
                                                    .get()
                                                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                        @Override
                                                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                            for (DocumentSnapshot doc : queryDocumentSnapshots) {
                                                                planeRef.document(doc.getId()).update("planeName", newPlaneName);
                                                                Toast.makeText(SinglePlaneActivity.this, "Plane name successfully updated.",Toast.LENGTH_LONG).show();
                                                            }
                                                        }
                                                    });
                                        }
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                    }
                                })
                                .show();

                        break;

                    case R.id.delete:
                        if (plane_isActive) { // If plane is ACTIVE, then display error message saying cannot remove plane
                            Toast.makeText(getApplicationContext(), "Cannot remove a plane while still takes on mission", Toast.LENGTH_LONG).show();
                        } else {
                            showCustomDialog(index);
                        }

                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    void showCustomDialog(int index) {
        Dialog dialog = new Dialog(SinglePlaneActivity.this);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.activity_custom_dialog);

        //Initializing the views of the dialog.
        Button cancelBtn = dialog.findViewById(R.id.cancelBtn);
        Button deleteBtn = dialog.findViewById(R.id.deleteBtn);

        // Buttons' listener
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        deleteBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fq.deletePlane(PlanesActivity.planesList.get(index).getId());
                Intent nextScreen = new Intent(SinglePlaneActivity.this, PlanesActivity.class);
                nextScreen.putExtra("REMOVED_PLANE_AT", plane_position);
                SinglePlaneActivity.this.startActivity(nextScreen);
            }
        }));

        dialog.show();
    }
}


//                        InputStream inputStream = getResources().openRawResource(R.raw.plane_data);
//                        FileHelper file = new FileHelper();
//                        JSONArray jsonArray = file.convertJSONtoArray(inputStream, "planes");
//                        jsonArray.remove(plane_position);

//                            obj.put("planes", jsonArray);
//                            String string = obj.toString();
//                            FileOutputStream fos = openFileOutput("FILENAME", Context.MODE_PRIVATE);
//                            fos.write(string.getBytes());
//                            fos.close();
