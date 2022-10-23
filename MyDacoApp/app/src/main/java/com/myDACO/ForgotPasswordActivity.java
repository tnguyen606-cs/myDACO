package com.myDACO;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myDACO.data.Users;
import com.myDACO.utilities.FileHelper;

import java.io.InputStream;
import java.util.Set;


public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pasword_screen);

//        EditText firstname = (EditText) findViewById(R.id.firstNamebox);
//        EditText lastname = (EditText) findViewById(R.id.lastNamebox);
//        EditText employeeId = (EditText) findViewById(R.id.employeeIdbox);
//
//        Button cont = (Button) findViewById(R.id.continueBtn);
//        Button newUsersBtn = (Button) findViewById(R.id.newUsersBtn);
//
//        InputStream inputStream = getResources().openRawResource(R.raw.user_data);
//
//        // continue
//        cont.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FileHelper file = new FileHelper();
//                Set<Users> strUsersArray = file.getUserResource(inputStream);
//                Users user = new Users();
//                String name = user.concatString(firstname.getText().toString(), lastname.getText().toString());
//                String id = employeeId.getText().toString();
//
//                boolean validUser = false;
//                for (Users u : strUsersArray) {
//                    if (u.getDacoName().equals(name) && u.getDacoId().equals(id)) {
//                        validUser = true;
//                        String toastMessage = "A new reset password link just sent to your email";
//                        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
//                        break;
//                    }
//                }
//                if (!validUser) {
//                    String toastMessage = "Are you a new user. Please register to log in!";
//                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        // sign up
//        newUsersBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent nextScreen = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
//                ForgotPasswordActivity.this.startActivity(nextScreen);
//            }
//        });
    }
}
