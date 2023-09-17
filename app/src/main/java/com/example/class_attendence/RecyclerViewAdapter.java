package com.example.class_attendence;

import android.content.Context;
import android.hardware.camera2.MultiResolutionImageReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<viewHolder> {
    Context c;
    ArrayList<modelClassForDB> mylist1;

    public RecyclerViewAdapter(Context c, ArrayList<modelClassForDB> mylist1) {
        this.c = c;
        this.mylist1 = mylist1;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RecyclerViewAdapter", "Data size: " + mylist1.size());
        View view = LayoutInflater.from(c).inflate(R.layout.coustomforresults,null);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {Log.d("Adapter", "Attendence: " + mylist1.get(position).getId());holder.attendences.setText(mylist1.get(position).getAttendences());
  holder.id.setText(" "+mylist1.get(position).getId());
  holder.rollNum.setText(mylist1.get(position).getRollnumS());
  holder.rollNumint.setText(" "+mylist1.get(position).getRollnumInt());
  holder.attendences.setText(mylist1.get(position).getAttendences());
        // Assuming "holder" is a reference to a view holder
        if (mylist1.get(position).getAttendences().equals("A")) {
            // Set the background color of the specific view to red
            holder.attendences.setTextColor(ContextCompat.getColor(c, R.color.red));
            holder.id.setTextColor(ContextCompat.getColor(c, R.color.red));
            holder.rollNum.setTextColor(ContextCompat.getColor(c, R.color.red));
            holder.rollNumint.setTextColor(ContextCompat.getColor(c, R.color.red));
        }else {
            holder.attendences.setTextColor(ContextCompat.getColor(c, R.color.black));
            holder.id.setTextColor(ContextCompat.getColor(c, R.color.black));
            holder.rollNum.setTextColor(ContextCompat.getColor(c, R.color.black));
            holder.rollNumint.setTextColor(ContextCompat.getColor(c, R.color.black));
        }

    }

    @Override
    public int getItemCount() {
        return mylist1.size();

    }

    public void clearList() {
        mylist1.clear();
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

}
