package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, email, mobile, password, confirmPassword;
    Button submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure XML file name is activity_main.xml

        // Linking views with their IDs
        username = findViewById(R.id.editUsername);
        email = findViewById(R.id.editEmail);
        mobile = findViewById(R.id.editMobile);
        password = findViewById(R.id.editPassword);
        confirmPassword = findViewById(R.id.editConfirmPassword);
        submit = findViewById(R.id.buttonSubmit);

        // Initializing SharedPreferences
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String mobileNum = mobile.getText().toString().trim();
                String pass1 = password.getText().toString().trim();
                String pass2 = confirmPassword.getText().toString().trim();

                // Input validations
                if (usernames.isEmpty()) {
                    username.setError("Username is empty");
                    username.requestFocus();
                    return;
                }

                if (emails.isEmpty()) {
                    email.setError("Email is empty");
                    email.requestFocus();
                    return;
                }

                if (mobileNum.isEmpty()) {
                    mobile.setError("Mobile number is empty");
                    mobile.requestFocus();
                    return;
                }

                if (pass1.isEmpty()) {
                    password.setError("Password is empty");
                    password.requestFocus();
                    return;
                }

                if (pass2.isEmpty()) {
                    confirmPassword.setError("Confirm password is empty");
                    confirmPassword.requestFocus();
                    return;
                }

                if (pass1.length() < 6) {
                    password.setError("Password must be at least 6 characters");
                    password.requestFocus();
                    return;
                }

                if (!pass1.equals(pass2)) {
                    confirmPassword.setError("Passwords do not match");
                    confirmPassword.requestFocus();
                    return;
                }

                // Save to SharedPreferences
                editor.putString("keyUsername", usernames);
                editor.putString("keyEmail", emails);
                editor.putString("keyMobile", mobileNum);
                editor.putString("keyPassword", pass2);
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
