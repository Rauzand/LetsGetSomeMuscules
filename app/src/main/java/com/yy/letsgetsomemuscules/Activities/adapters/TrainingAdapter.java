package com.yy.letsgetsomemuscules.Activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yy.letsgetsomemuscules.Activities.activity.ExerciseActivity;
import com.yy.letsgetsomemuscules.Activities.models.TrainingModel;
import com.yy.letsgetsomemuscules.R;

import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    private Context context;
    private List<TrainingModel> list;

    public TrainingAdapter(Context context, List<TrainingModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrainingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getUrl_img()).into(holder.trainImg);
        holder.nameTxt.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ExerciseActivity.class);
                intent.putExtra("exercise", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView trainImg;
        private TextView nameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            trainImg = itemView.findViewById(R.id.item_image);
            nameTxt = itemView.findViewById(R.id.item_nam);
        }
    }
}
