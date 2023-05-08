package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.graphics.Color;
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
    Float h, w, resultCalc;
=======
    Double h, w, resultCalc;
>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        findViews();

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                h = Float.valueOf(String.valueOf(edH.getText())) / 100;
                w = Float.valueOf(String.valueOf(edW.getText()));
                resultCalc = w/(h*h);
                resTxt.setText(String.valueOf(resultCalc));
                if(resultCalc > 18 && resultCalc < 25){
                    resTxt.setTextColor(getColor(R.color.goodweight));
                }else if(resultCalc < 18 && resultCalc > 15){
                    resTxt.setTextColor(getColor(R.color.yellow_base));
                }else if(resultCalc < 15){
                    resTxt.setTextColor(getColor(R.color.badweight));
                }else if(resultCalc > 25 && resultCalc < 30){
                    resTxt.setTextColor(getColor(R.color.yellow_base));
                }else if(resultCalc > 30){
                    resTxt.setTextColor(getColor(R.color.badweight));
                }
=======
                h = Double.valueOf(String.valueOf(edH.getText())) / 100;
                w = Double.valueOf(String.valueOf(edW.getText()));
                resultCalc = w/(h*h);
                resTxt.setText(String.valueOf(resultCalc));
>>>>>>> origin/master
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