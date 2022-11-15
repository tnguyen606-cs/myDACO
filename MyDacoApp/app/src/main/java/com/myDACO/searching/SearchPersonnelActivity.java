package com.myDACO.searching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.myDACO.ListOfPersonnelActivity;
import com.myDACO.PlanesActivity;
import com.myDACO.R;
import com.myDACO.SinglePersonnelActivity;
import com.myDACO.SinglePlaneActivity;
import com.myDACO.data.Personnel;
import com.myDACO.data.Planes;
import com.myDACO.utilities.PersonnelArrayAdapter;
import com.myDACO.utilities.PlaneArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchPersonnelActivity extends AppCompatActivity {

    static List<Personnel> person= new ArrayList<>();
    private PersonnelArrayAdapter personnelAdapter;

    private EditText searchText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);

        searchText = (EditText) findViewById(R.id.search_box);

        Button search_Btn = (Button) findViewById(R.id.search_btn);
        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchItem();
            }
        });

        // Close the window
        // Go to add plane activity
        ImageView closeIcon = (ImageView) findViewById(R.id.close_icon);
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go back
                finish();
            }
        });
    }

    private void searchItem() {
        String text = searchText.getText().toString();
        String[] textArray = text.split(" ");
        boolean found = false;
        // Search the name of the plane
        for (Personnel p : ListOfPersonnelActivity.personnelList) {
            String lName = p.getLastName();
            String fName = p.getFirstName();
            if ((textArray.length == 2 && lName.equals(textArray[1]) && fName.equals(textArray[0]))
                || (textArray.length == 1 && (lName.equals(textArray[0]) || fName.equals(textArray[0])))) {
                found = true;
                person.add(p);
                // Get the handle for ListView
                ListView listView = (ListView) findViewById(R.id.search_list);
                personnelAdapter = new PersonnelArrayAdapter(SearchPersonnelActivity.this, person);
                listView.setAdapter(personnelAdapter);
                // Go to view screen of a single plane
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent nextScreen = new Intent(SearchPersonnelActivity.this, SinglePersonnelActivity.class);
                        nextScreen.putExtra("PERSONNEL", person.get(position));
                        SearchPersonnelActivity.this.startActivity(nextScreen);
                    }
                });
                searchText.getText().clear();
                break;
            }
        }
        if (!found) {
            searchText.setError("No matching value has found regarding the search");
        }
    }
}
