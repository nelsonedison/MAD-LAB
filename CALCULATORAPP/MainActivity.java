package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnDot, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear;
    TextView tvInput;

    float mValueOne, mValueTwo;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        tvInput = findViewById(R.id.tvInput);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot = findViewById(R.id.btnDot);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        // Number buttons
        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            tvInput.setText(tvInput.getText().toString() + b.getText().toString());
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);
        btnDot.setOnClickListener(numberListener);

        // Clear button
        btnClear.setOnClickListener(v -> tvInput.setText(""));

        // Operator buttons
        btnAdd.setOnClickListener(v -> {
            if (!tvInput.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(tvInput.getText().toString());
                add = true;
                tvInput.setText("");
            }
        });

        btnSub.setOnClickListener(v -> {
            if (!tvInput.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(tvInput.getText().toString());
                sub = true;
                tvInput.setText("");
            }
        });

        btnMul.setOnClickListener(v -> {
            if (!tvInput.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(tvInput.getText().toString());
                mul = true;
                tvInput.setText("");
            }
        });

        btnDiv.setOnClickListener(v -> {
            if (!tvInput.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(tvInput.getText().toString());
                div = true;
                tvInput.setText("");
            }
        });

        // Equal button
        btnEqual.setOnClickListener(v -> {
            if (!tvInput.getText().toString().isEmpty()) {
                mValueTwo = Float.parseFloat(tvInput.getText().toString());

                if (add) {
                    tvInput.setText(String.valueOf(mValueOne + mValueTwo));
                    add = false;
                } else if (sub) {
                    tvInput.setText(String.valueOf(mValueOne - mValueTwo));
                    sub = false;
                } else if (mul) {
                    tvInput.setText(String.valueOf(mValueOne * mValueTwo));
                    mul = false;
                } else if (div) {
                    if (mValueTwo != 0) {
                        tvInput.setText(String.valueOf(mValueOne / mValueTwo));
                    } else {
                        tvInput.setText("Error");
                    }
                    div = false;
                }
            }
        });
    }
}
