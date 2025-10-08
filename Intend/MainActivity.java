package com.example.intend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text);
    }

    public void OnIndexSendButtonClicked(View view) {
        String indexStr = editText.getText().toString().trim();

        if (indexStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int index;
        try {
            index = Integer.parseInt(indexStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (index < 1 || index > 4) {
            Toast.makeText(this, "Please enter a number between 1 and 4", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("ImageIndex", index); // send as int
        startActivity(intent);
    }
}
