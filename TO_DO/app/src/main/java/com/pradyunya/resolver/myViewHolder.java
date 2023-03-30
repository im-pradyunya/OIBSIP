package com.pradyunya.resolver;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2,t3,t4;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        t1=itemView.findViewById(R.id.titles);
        t2=itemView.findViewById(R.id.desc);
        t3=itemView.findViewById(R.id.date);
        t4=itemView.findViewById(R.id.time);
    }


}
