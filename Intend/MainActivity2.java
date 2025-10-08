package com.example.intend;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = findViewById(R.id.images);

        int index = getIntent().getIntExtra("ImageIndex", -1); // -1 is fallback if not found
        setImage(index);
    }

    private void setImage(int index) {
        switch (index) {
            case 1:
                imageView.setImageResource(R.drawable.kunfu);
                break;
            case 2:
                imageView.setImageResource(R.drawable.kunfu2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.kunfu3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.kunfu4);
                break;
            default:
                Toast.makeText(this, "Index is not available", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
