package com.ieti.duolingoproyect.Models;

import com.ieti.duolingoproyect.*;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ieti.duolingoproyect.MainActivity_Exercice;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    ArrayList<Category> arrayCategories;
    ArrayList<Level> arrayCurrentLevels;
    private Context context;
    private int count;
    public RecyclerAdapter(ArrayList<Category> arrayCategories, ArrayList<Level> arrayCurrentLevels, Context context) {
        this.arrayCategories = arrayCategories;
        this.arrayCurrentLevels = arrayCurrentLevels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCategory.setText(arrayCategories.get(position).getName());
        holder.tvCurrentLevel.setText(String.valueOf(arrayCurrentLevels.get(position).getIndexLevel()));
    }

    @Override
    public int getItemCount() {
        return arrayCategories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCategory, tvCurrentLevel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvCurrentLevel = itemView.findViewById(R.id.tvCurrentLevel);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            count++;
            Toast.makeText(v.getContext(), arrayCategories.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            if (count >= 1)
                {
                    Intent intent = new Intent(context, MainActivity_Exercice.class);
                    context.startActivity(intent);
            }


        }
    }
}
