package com.example.webreplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SectorAreaCalculatorActivity extends AppCompatActivity {
    EditText centralAngleInput, radiusInput;
    TextView diameterOutput, sectorAreaOutput, arcLengthOutput, chordLengthOutput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_area_calculator);

        centralAngleInput = findViewById(R.id.editText1);
        radiusInput = findViewById(R.id.editText2);
        diameterOutput = findViewById(R.id.editText3);
        sectorAreaOutput = findViewById(R.id.editText4);
        arcLengthOutput = findViewById(R.id.editText5);
        chordLengthOutput = findViewById(R.id.editText6);
        calculateButton = findViewById(R.id.button6);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSectorArea();
            }
        });
    }

    private void calculateSectorArea() {
        double deg = Double.parseDouble(centralAngleInput.getText().toString());
        double angle = Math.toRadians(deg);
        double r = Double.parseDouble(radiusInput.getText().toString());
        double d = 2 * r;
        diameterOutput.setText("Diameter (d): " + d + " cm");

        double sectorArea = (r * r * angle) / 2;
        sectorAreaOutput.setText("Sector area (A): " + String.format("%.3f", sectorArea) + " cm²");

        double arcLength = r * angle;
        arcLengthOutput.setText("Arc length (L): " + String.format("%.3f", arcLength) + " cm");

        double chordLength = 2 * r * Math.sin(angle / 2);
        chordLengthOutput.setText("Chord length (c): " + String.format("%.3f", chordLength) + " cm");
    }
}
