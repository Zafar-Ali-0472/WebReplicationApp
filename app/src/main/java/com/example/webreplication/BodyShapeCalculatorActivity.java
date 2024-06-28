package com.example.webreplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BodyShapeCalculatorActivity extends AppCompatActivity {
    EditText bustInput, waistInput, highHipInput, hipsInput;
    TextView bodyShapeOutput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_shape_calculator);

        bustInput = findViewById(R.id.editText1);
        waistInput = findViewById(R.id.editText2);
        highHipInput = findViewById(R.id.editText3);
        hipsInput = findViewById(R.id.editText4);
        bodyShapeOutput = findViewById(R.id.editText5);
        calculateButton = findViewById(R.id.button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBodyShape();
            }
        });
    }

    private void calculateBodyShape() {
        double bust = Double.parseDouble(bustInput.getText().toString());
        double waist = Double.parseDouble(waistInput.getText().toString());
        double highHip = Double.parseDouble(highHipInput.getText().toString());
        double hips = Double.parseDouble(hipsInput.getText().toString());

        if (((bust - hips) <= 1) && ((hips - bust) < 3.6) && ((bust - waist) >= 9) || ((hips - waist) >= 10)) {
            bodyShapeOutput.setText("Body shape: Hourglass");
        } else if (((hips - bust) >= 3.6) && ((hips - bust) < 10) && ((hips - waist) >= 9) && ((highHip / waist) < 1.193)) {
            bodyShapeOutput.setText("Body shape: Bottom hourglass");
        } else if (((bust - hips) > 1) && ((bust - hips) < 10) && ((bust - waist) >= 9)) {
            bodyShapeOutput.setText("Body shape: Top hourglass");
        } else if (((hips - bust) > 2) && ((hips - waist) >= 7) && ((highHip / waist) >= 1.193)) {
            bodyShapeOutput.setText("Body shape: Spoon");
        } else if (((hips - bust) < 3.6) && ((bust - hips) < 3.6) && ((bust - waist) < 9) && ((hips - waist) < 10)) {
            bodyShapeOutput.setText("Body shape: Rectangle");
        } else if (((hips - bust) >= 3.6) && ((hips - waist) < 9)) {
            bodyShapeOutput.setText("Body shape: Triangle");
        } else if (((bust - hips) >= 3.6) && ((bust - waist) < 9)) {
            bodyShapeOutput.setText("Body shape: Inverted triangle");
        }
    }
}
