package com.example.webreplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MidpointCalculatorActivity extends AppCompatActivity {

    EditText x1Input, y1Input, x2Input, y2Input;
    TextView xMidpointOutput, yMidpointOutput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midpoint_calculator);

        x1Input = findViewById(R.id.editText1);
        y1Input = findViewById(R.id.editText2);
        x2Input = findViewById(R.id.editText3);
        y2Input = findViewById(R.id.editText4);
        xMidpointOutput = findViewById(R.id.editText5);
        yMidpointOutput = findViewById(R.id.editText6);
        calculateButton = findViewById(R.id.button5);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMidpoint();
            }
        });
    }

    private void calculateMidpoint() {
        double x1 = Double.parseDouble(x1Input.getText().toString());
        double y1 = Double.parseDouble(y1Input.getText().toString());
        double x2 = Double.parseDouble(x2Input.getText().toString());
        double y2 = Double.parseDouble(y2Input.getText().toString());

        double xMidpoint = (x1 + x2) / 2;
        double yMidpoint = (y1 + y2) / 2;

        xMidpointOutput.setText("x midpoint = " + xMidpoint);
        yMidpointOutput.setText("y midpoint = " + yMidpoint);
    }
}
