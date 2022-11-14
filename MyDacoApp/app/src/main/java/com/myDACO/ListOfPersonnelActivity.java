package com.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myDACO.data.Personnel;
import com.myDACO.utilities.FileHelper;
import com.myDACO.utilities.PersonnelArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfPersonnelActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    static List<Personnel> personnelList = new ArrayList<>();
    PersonnelArrayAdapter personnelAdapter;

    @Override
    public void onStart(){
        super.onStart();

        //listens for changes to the firestore databases in real time
        ListenerRegistration personnelListener = db.collection("personnel").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("snapshot listener", "listen failed", error);
                    return;
                }
                personnelList.clear();
                for (QueryDocumentSnapshot document : value) {
                    Personnel person = document.toObject(Personnel.class);
                    personnelList.add(person);
                    personnelAdapter.notifyDataSetChanged();
                }
                Collections.sort(personnelList, new Comparator<Personnel>() {
                    public int compare(Personnel p1, Personnel p2) {
                        String fn1 = p1.getFirstName();
                        String fn2 = p2.getFirstName();

                        int res = fn1.compareTo(fn2);
                        if (res != 0) {
                            return res;
                        } else {
                            String ln1 = p1.getLastName();
                            String ln2 = p1.getLastName();
                            return ln1.compareTo(ln2);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnel_master_list_screen);

        // Get the list view of cargos
        ListView listView = (ListView) findViewById(R.id.personnel_list);
        personnelAdapter = new PersonnelArrayAdapter(this, personnelList);
        listView.setAdapter(personnelAdapter);
        // Go to see a cargo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nextScreen = new Intent(ListOfPersonnelActivity.this, SinglePersonnelActivity.class);
                nextScreen.putExtra("PERSONNEL_FTEXT", personnelList.get(position).getFirstName());
                nextScreen.putExtra("PERSONNEL_LTEXT", personnelList.get(position).getLastName());
                nextScreen.putExtra("PERSONNEL_planeID", personnelList.get(position).getAssignedPlaneID());
                nextScreen.putExtra("PERSONNEL_WEIGHT", personnelList.get(position).getWeight());
                nextScreen.putExtra("PERSONNEL_PRIORITY", personnelList.get(position).getPriority());
                nextScreen.putExtra("PERSONNEL_ID", personnelList.get(position).getId());
                ListOfPersonnelActivity.this.startActivity(nextScreen);
            }
        });

        // User clicks on the menu bar to sign out action
        FileHelper file = new FileHelper();
        ImageView menuIcon = (ImageView) findViewById(R.id.menu_icon);
        file.showMenu(ListOfPersonnelActivity.this, menuIcon);

        // Go to add plane activity
        ImageView addIcon = (ImageView) findViewById(R.id.add_personnel);
        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to screen with UI for adding a plane
                Intent nextScreen = new Intent(ListOfPersonnelActivity.this, AddPersonnelActivity.class);
                ListOfPersonnelActivity.this.startActivity(nextScreen);
            }
        });
    }
}
