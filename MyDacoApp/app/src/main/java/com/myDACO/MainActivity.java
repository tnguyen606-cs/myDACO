package com.myDACO;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.example.myDACO.data.Users;
import com.example.myDACO.utilities.FileHelper;
import com.google.android.material.button.MaterialButton;

import java.io.InputStream;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameInput = (EditText) findViewById(R.id.usernamebox);
        EditText passwordInput = (EditText) findViewById(R.id.passwordbox);

        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);
        Button forgotBtn = (Button) findViewById(R.id.forgotBtn);
        Button newUsersBtn = (Button) findViewById(R.id.newUsersBtn);

        InputStream inputStream = getResources().openRawResource(R.raw.user_data);

        // admin
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileHelper file = new FileHelper();
                Set<Users> strUsersArray = file.getResource(inputStream);

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                boolean validUser = false;

                for (Users u : strUsersArray) {
                    if (u.getDacoUsername().equals(username) && u.getDacoPassword().equals(password)) {
                        validUser = true;
                        String toastMessage = "Username: " + username + ", Password: " + password;
                        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
                        break;
                    }
                }
               if (!validUser) {
                   String toastMessage = "Username or Password are not correct. Please enter the correct one";
                   Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
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