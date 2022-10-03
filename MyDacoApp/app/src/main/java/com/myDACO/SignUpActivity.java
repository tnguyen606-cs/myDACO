package com.myDACO;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    // Variables
    private EditText firstNamebox, lastNamebox, employeeIdbox, usernamebox, passwordbox;
    private Button regBtn;

    private FirebaseFirestore db;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_screen);

        // Hook to all xml attributes
        firstNamebox = (EditText) findViewById(R.id.firstNamebox);
        lastNamebox = (EditText) findViewById(R.id.lastNamebox);
        employeeIdbox = (EditText) findViewById(R.id.employeeIdbox);
        usernamebox = (EditText) findViewById(R.id.usernamebox);
        passwordbox = (EditText) findViewById(R.id.passwordbox);

        regBtn = (Button) findViewById(R.id.registerBtn);

        db = FirebaseFirestore.getInstance();

        // continue
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNamebox.getText().toString();
                String lastName = lastNamebox.getText().toString();
                String employeeId = employeeIdbox.getText().toString();
                String username = usernamebox.getText().toString();
                String password = passwordbox.getText().toString();
                String name = firstName + " " + lastName;

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(employeeId) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(SignUpActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(username , name , employeeId , password);
                }
            }
        });
    }

    private void registerUser(final String username, final String name, final String employeeId, String password) {

        pd.setMessage("Please Wait!");
        pd.show();

        HashMap<String , Object> map = new HashMap<>();
        map.put("name" , name);
        map.put("username" , username);
        map.put("id" , employeeId);
        map.put("password", password);

        db.collection("data").document("users").set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(SignUpActivity.this, "Value added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this , MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
