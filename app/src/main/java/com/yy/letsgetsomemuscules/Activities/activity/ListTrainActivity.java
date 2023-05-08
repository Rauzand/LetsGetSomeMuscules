package com.yy.letsgetsomemuscules.Activities.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.yy.letsgetsomemuscules.Activities.adapters.ListTrainAdapter;
import com.yy.letsgetsomemuscules.Activities.models.ListTrainModel;
import com.yy.letsgetsomemuscules.R;

import java.util.ArrayList;
import java.util.List;

public class ListTrainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<ListTrainModel> listTrainModelList;
    ListTrainAdapter listTrainAdapter;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_train);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        toolbar = findViewById(R.id.list_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rec_list_ex);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listTrainModelList = new ArrayList<>();
        listTrainAdapter = new ListTrainAdapter(this, listTrainModelList);
        recyclerView.setAdapter(listTrainAdapter);

        firestore.collection("TrainingList").document(auth.getCurrentUser().getUid())
                .collection("Sportsman").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (DocumentSnapshot doc :task.getResult().getDocuments()){

                                String documentId = doc.getId();

                                ListTrainModel listTrainModel = doc.toObject(ListTrainModel.class);
                                listTrainModel.setDocumentId(documentId);
                                listTrainModelList.add(listTrainModel);
                                listTrainAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}