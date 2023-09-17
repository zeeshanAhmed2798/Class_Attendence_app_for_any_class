package com.example.class_attendence;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {
TextView id,rollNum,rollNumint,attendences;


    public viewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        rollNum = itemView.findViewById(R.id.rollNumString);
        rollNumint = itemView.findViewById(R.id.rollNumint);
        attendences = itemView.findViewById(R.id.attendences);
    }
}
