package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.yy.letsgetsomemuscules.Activities.adapters.TrainingAdapter;
import com.yy.letsgetsomemuscules.Activities.models.TrainingModel;
import com.yy.letsgetsomemuscules.R;

import java.util.ArrayList;
import java.util.List;

public class TrainingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TrainingAdapter trainingAdapter;
    List<TrainingModel> trainingModelList;

    Toolbar toolbar;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        String type = getIntent().getStringExtra("type");

        toolbar = findViewById(R.id.trainingToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        firestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.training_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        trainingModelList = new ArrayList<>();
        trainingAdapter = new TrainingAdapter(this, trainingModelList);
        recyclerView.setAdapter(trainingAdapter);

        if (type != null && type.equalsIgnoreCase("плаванье")){
            firestore.collection("Exercises").whereEqualTo("type", "плаванье")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc :task.getResult().getDocuments()){
                                    TrainingModel showAllModel = doc.toObject(TrainingModel.class);
                                    trainingModelList.add(showAllModel);
                                    trainingAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("спина")){
            firestore.collection("Exercises").whereEqualTo("type", "спина")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc :task.getResult().getDocuments()){
                                    TrainingModel showAllModel = doc.toObject(TrainingModel.class);
                                    trainingModelList.add(showAllModel);
                                    trainingAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("руки")){
            firestore.collection("Exercises").whereEqualTo("type", "руки")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc :task.getResult().getDocuments()){
                                    TrainingModel showAllModel = doc.toObject(TrainingModel.class);
                                    trainingModelList.add(showAllModel);
                                    trainingAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("ноги")){
            firestore.collection("Exercises").whereEqualTo("type", "ноги")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc :task.getResult().getDocuments()){
                                    TrainingModel showAllModel = doc.toObject(TrainingModel.class);
                                    trainingModelList.add(showAllModel);
                                    trainingAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
        }
        if (type != null && type.equalsIgnoreCase("пресс")){
            firestore.collection("Exercises").whereEqualTo("type", "пресс")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc :task.getResult().getDocuments()){
                                    TrainingModel showAllModel = doc.toObject(TrainingModel.class);
                                    trainingModelList.add(showAllModel);
                                    trainingAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });
        }
    }
}