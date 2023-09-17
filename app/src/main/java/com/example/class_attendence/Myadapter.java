package com.example.class_attendence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.class_attendence.R;
import com.example.class_attendence.modelclass;

import java.util.List;

public class Myadapter extends BaseAdapter {
String departmentName;
String semester;
String section;

LayoutInflater inflater;
int size;
Context c;

    public Myadapter(String departmentName, String semester, String section, int size, Context c) {
        this.departmentName = departmentName;
        this.semester = semester;
        this.section = section;
        this.inflater = LayoutInflater.from(c);
        this.size = size;
        this.c = c;
    }

    @Override
    public int getCount() {
        return this.size;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.coustom_for_weeks,null);
        TextView weekName=view.findViewById(R.id.weekName);
        TextView se=view.findViewById(R.id.section);
        TextView d=view.findViewById(R.id.department);
        String w="Week NO "+(i+1);
        weekName.setText(w);
        se.setText(semester+" "+section);
        d.setText(departmentName);
        return view;
    }
}
