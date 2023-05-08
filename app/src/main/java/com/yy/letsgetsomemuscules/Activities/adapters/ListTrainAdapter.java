package com.yy.letsgetsomemuscules.Activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yy.letsgetsomemuscules.Activities.models.ListTrainModel;
import com.yy.letsgetsomemuscules.R;

import java.util.List;

public class ListTrainAdapter extends RecyclerView.Adapter<ListTrainAdapter.ViewHolder> {

    Context context;
    List<ListTrainModel> listTrainModelList;
    FirebaseAuth auth;
    FirebaseFirestore firestore;

    public ListTrainAdapter(Context context, List<ListTrainModel> listTrainModelList) {
        this.context = context;
        this.listTrainModelList = listTrainModelList;
        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    @NonNull
    @Override
    public ListTrainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_train_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListTrainAdapter.ViewHolder holder, int position) {
        holder.name.setText(listTrainModelList.get(position).getExName());
        holder.finalCount.setText(listTrainModelList.get(position).getFinalCount());

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firestore.collection("TrainingList").document(auth.getCurrentUser().getUid())
                        .collection("Sportsman")
                        .document(listTrainModelList.get(position).getDocumentId())
                        .delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    listTrainModelList.remove(listTrainModelList.get(position));
                                    notifyDataSetChanged();
                                    Toast.makeText(context, "удалено", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "ошибка!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTrainModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, finalCount;
        ImageView deleteImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ex_name_name);
            finalCount = itemView.findViewById(R.id.final_count_count);
            deleteImg = itemView.findViewById(R.id.delete);

        }
    }
}
