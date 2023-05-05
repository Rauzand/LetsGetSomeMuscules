package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yy.letsgetsomemuscules.R;

public class BMIActivity extends AppCompatActivity {

    EditText edW, edH;
    Button btnCalc;
    TextView resTxt;
    Double h, w, resultCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        findViews();

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h = Double.valueOf(String.valueOf(edH.getText())) / 100;
                w = Double.valueOf(String.valueOf(edW.getText()));
                resultCalc = w/(h*h);
                resTxt.setText(String.valueOf(resultCalc));
            }
        });
    }

    private void findViews() {
        edW = findViewById(R.id.ed_weight);
        edH = findViewById(R.id.ed_height);
        btnCalc = findViewById(R.id.btnBMI);
        resTxt = findViewById(R.id.calcul_result);
    }
}