package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yy.letsgetsomemuscules.Activities.models.TrainingModel;
import com.yy.letsgetsomemuscules.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ExerciseActivity extends AppCompatActivity {

    ImageView exImg;
    TextView name, description, counter;
    Toolbar toolbar;
    Button btnAdd;
    ImageView plusEx, minusEx;

    int finalCount = 1;

    //упражнения из бд
    TrainingModel trainingModel = null;


    FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.ex_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        final Object obj = getIntent().getSerializableExtra("exercise");

        if(obj instanceof TrainingModel){
            trainingModel = (TrainingModel) obj;
        }

        exImg = findViewById(R.id.ex_img);
        name = findViewById(R.id.ex_name);
        description = findViewById(R.id.ex_disc);
        btnAdd = findViewById(R.id.addToTraining);
        counter = findViewById(R.id.count);
        plusEx = findViewById(R.id.plus);
        minusEx = findViewById(R.id.minus);


        //Установка данных в поля
        if(trainingModel != null){
            Glide.with(getApplicationContext()).load(trainingModel.getUrl_img()).into(exImg);
            name.setText(trainingModel.getName());
            description.setText(trainingModel.getDescription());
        }

        //добавить к своей программе
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExercise();
            }
        });

        plusEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalCount<10){
                    finalCount++;
                    counter.setText(String.valueOf(finalCount));
                }
            }
        });
        minusEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalCount>1){
                    finalCount--;
                    counter.setText(String.valueOf(finalCount));
                }
            }
        });
    }

    private void addExercise() {

        final HashMap<String, Object> cartMap= new HashMap<>();

        cartMap.put("exName", name.getText().toString());
        cartMap.put("finalCount", counter.getText().toString());

        firestore.collection("TrainingList").document(auth.getCurrentUser().getUid())
                .collection("Sportsman").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(ExerciseActivity.this, "now at program", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}