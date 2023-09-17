package com.example.class_attendence;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class adapterDays extends BaseAdapter {
    String arr[];
    LayoutInflater inflater;
    Context c;

    public adapterDays(String[] arr, Context c) {
        this.arr = arr;
        this.c = c;
        this.inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        return arr.length;
    }

    @Override
    public Object getItem(int i) {
        return arr[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.coustomfordays, null);
        TextView b = view.findViewById(R.id.buttonCoustom);
        b.setText(arr[i]);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass the selected day name to the weekDays activity
                if (c instanceof weekDays) {
                    ((weekDays) c).onDayItemClick(arr[i]);
                }
            }

        });
        return  view;
    }
}

