package com.example.webreplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bodyShapeCalculatorButton = findViewById(R.id.button1);
        Button projectileMotionCalculatorButton = findViewById(R.id.button2);
        Button midpointCalculatorButton = findViewById(R.id.button3);
        Button sectorAreaCalculatorButton = findViewById(R.id.button4);

        bodyShapeCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BodyShapeCalculatorActivity.class);
                startActivity(intent);
            }
        });

        projectileMotionCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjectileMotionCalculatorActivity.class);
                startActivity(intent);
            }
        });

        midpointCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MidpointCalculatorActivity.class);
                startActivity(intent);
            }
        });

        sectorAreaCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SectorAreaCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
