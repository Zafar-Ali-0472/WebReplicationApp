package com.example.webreplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectileMotionCalculatorActivity extends AppCompatActivity {

    EditText initialVelocityInput, angleInput, initialHeightInput, timeInput;
    TextView timeOfFlightOutput, distanceOutput, maxHeightOutput, velocityOutput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectile_motion_calculator);

        initialVelocityInput = findViewById(R.id.editText1);
        angleInput = findViewById(R.id.editText2);
        initialHeightInput = findViewById(R.id.editText3);
        timeInput = findViewById(R.id.editText4);
        timeOfFlightOutput = findViewById(R.id.editText7);
        distanceOutput = findViewById(R.id.editText5);
        maxHeightOutput = findViewById(R.id.editText6);
        velocityOutput = findViewById(R.id.editText8);
        calculateButton = findViewById(R.id.button10);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateProjectileMotion();
            }
        });
    }

    private void calculateProjectileMotion() {
        double V = Double.parseDouble(initialVelocityInput.getText().toString());
        double ang = Double.parseDouble(angleInput.getText().toString());
        double h = Double.parseDouble(initialHeightInput.getText().toString());
        double t = Double.parseDouble(timeInput.getText().toString());

        double angRad = Math.toRadians(ang);
        double Vx = V * Math.cos(angRad);
        double Vy = V * Math.sin(angRad);
        double g = 9.81;
        double vfy = Vy - g * t;
        double vf = Math.sqrt(Math.pow(Vx, 2) + Math.pow(vfy, 2));

        if (h == 0) {
            double T = (2 * Vy) / g;
            double hmax = Math.pow(Vy, 2) / (2 * g);
            double R = (2 * Vx * Vy) / g;
            timeOfFlightOutput.setText("Time of flight (t): " + T + " sec");
            distanceOutput.setText("Distance (d): " + R + " m");
            maxHeightOutput.setText("Maximum height (hmax): " + hmax + " m");
        } else if (h > 0) {
            double Tg = (Vy + Math.sqrt((Math.pow(Vy, 2)) + (2 * g * h))) / g;
            double hmaxg = h + ((Math.pow(Vy, 2)) / (2 * g));
            double Rg = Vx * (Vy + Math.sqrt((Math.pow(Vy, 2)) + (2 * g * h))) / g;
            timeOfFlightOutput.setText("Time of flight (t): " + Tg + " sec");
            distanceOutput.setText("Distance (d): " + Rg + " m");
            maxHeightOutput.setText("Maximum height (hmax): " + hmaxg + " m");
        } else {
            Toast.makeText(this, "Height must be positive", Toast.LENGTH_SHORT).show();
        }

        velocityOutput.setText("Velocity: " + vf + " m/s");
    }
}
