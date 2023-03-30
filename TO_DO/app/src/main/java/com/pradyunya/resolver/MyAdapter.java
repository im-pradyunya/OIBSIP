package com.pradyunya.resolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
Context context;
List<Item> tasks;

    public MyAdapter(Context context, List<Item> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.t1.setText(tasks.get(position).getTitle());
        holder.t2.setText(tasks.get(position).getDesc());
        holder.t3.setText(tasks.get(position).getDate());
        holder.t4.setText(tasks.get(position).getTime());
    }

    @Override
    public int getItemCount() {

        return tasks.size();
    }
}
