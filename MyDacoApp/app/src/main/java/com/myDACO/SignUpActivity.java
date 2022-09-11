package com.example.myDACO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_screen);

        Button regBtn = (Button) findViewById(R.id.registerBtn);

        // continue
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage = "A new user is just created";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                Intent nextScreen = new Intent(SignUpActivity.this, MainActivity.class);
                SignUpActivity.this.startActivity(nextScreen);
            }
        });

    }
}
