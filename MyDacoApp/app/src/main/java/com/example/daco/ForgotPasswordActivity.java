package com.example.daco;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pasword_screen);

        Button cont = (Button) findViewById(R.id.continueBtn);
        Button newUsersBtn = (Button) findViewById(R.id.newUsersBtn);

        // continue
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage = "A new reset password link just sent to your email";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        // sign up
        newUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
                ForgotPasswordActivity.this.startActivity(nextScreen);
            }
        });
    }
}
