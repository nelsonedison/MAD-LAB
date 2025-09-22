package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.edit1);
        EditText password = findViewById(R.id.edit2);
        Button Lbutton = findViewById(R.id.button);
        Lbutton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin123")) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                }
               else
                {
                    Toast.makeText(MainActivity.this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }     });
    }
