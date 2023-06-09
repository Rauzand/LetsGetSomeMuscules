package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yy.letsgetsomemuscules.R;

public class MainActivity extends AppCompatActivity {

    Button btnWorkout, btnUser, btnTimer, btnCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
            }
        });

        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(intent);
            }
        });

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(intent);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListTrainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        btnWorkout = findViewById(R.id.btnWorkout);
        btnUser = findViewById(R.id.btnUserProfile);
        btnTimer = findViewById(R.id.btnTimer);
        btnCalcul = findViewById(R.id.btnCalcul);
    }


}