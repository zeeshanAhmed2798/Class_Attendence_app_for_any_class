package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Results extends AppCompatActivity {
RecyclerView recyclerview;
TextView resultsxml,datee,lecture;
    MydataBase database;
    ArrayList<modelClassForDB> myList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        recyclerview=findViewById(R.id.recyclerView);
        resultsxml=findViewById(R.id.resultsxml);
        recyclerview=findViewById(R.id.recyclerView);
        datee=findViewById(R.id.datee);
        lecture=findViewById(R.id.lecture);
        database=new MydataBase(Results.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(Results.this,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);
        ArrayList<modelClassForDB> myarray= new ArrayList<>();

        Intent p=getIntent();
        // i.putExtra("DATE",selectedDate);
        //                i.putExtra("COURSE",subject);
        //
        String sub=p.getStringExtra("SECTION");
        String date=p.getStringExtra("DATE");
        String course=p.getStringExtra("COURSE");
        myarray=database.fetchData(date);

        Log.e("WHATTTTTT",date);
        resultsxml.setText("Attendence of : "+sub);
       // datee.setText("Date:"+date);
        lecture.setText("lec:"+course);
        if (!myarray.isEmpty()) {
            // Access the first element and set the date
            datee.setText(myarray.get(0).getDate());
        } else {
            datee.setText("No attendance data available."); // Handle empty array
        }
        Log.d("Results", "Fetched data size: " + myarray.size());
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(Results.this,myarray);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}