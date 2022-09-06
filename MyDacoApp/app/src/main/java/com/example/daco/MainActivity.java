package com.example.daco;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.example.daco.data.Users;
import com.example.daco.utilities.FileHelper;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText) findViewById(R.id.usernamebox);
        EditText password = (EditText) findViewById(R.id.passwordbox);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);
        Button forgotBtn = (Button) findViewById(R.id.forgotBtn);
        Button newUsersBtn = (Button) findViewById(R.id.newUsersBtn);

        InputStream inputStream= getResources().openRawResource(R.raw.user_data);

        // admin
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FileHelper file = new FileHelper();
                Set<Users> strUsersArray = file.getResource(inputStream);

                if (username.getText().length() > 0 && password.getText().length() > 0) {
                    String toastMessage = "Username: " + username.getText().toString() + ", Password: " + password.getText().toString();
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                } else {
                    String toastMessage = "Username or Password are not populated";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // forgot Password
        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                MainActivity.this.startActivity(nextScreen);
            }
        });

        // sign up
        newUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivity.this, SignUpActivity.class);
                MainActivity.this.startActivity(nextScreen);
            }
        });
    }
}