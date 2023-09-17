package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView menubar;
    List<modelclass> myList;
    ListView list_item;
    String deaptmentName;
Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menubar=findViewById(R.id.menubar);
        list_item=findViewById(R.id.list_item);
        myList=new ArrayList<>();
        Intent intent = getIntent();
        String stringValue = intent.getStringExtra("semester"+deaptmentName);
        menubar.setText(stringValue);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,weekDays.class);
                intent.putExtra("SEMESTER",deaptmentName);
                startActivity(intent);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isUserAuthenticated = sharedPreferences.getBoolean("isAuthenticated", false);
        if (isUserAuthenticated) {

            String sName=sharedPreferences.getString("sectionName",null);
            deaptmentName=sharedPreferences.getString("departmentName",null);
            String semesterNumber=sharedPreferences.getString("semesterNum",null);
            int noOfWeeks=sharedPreferences.getInt("numOfWeeks",0);
            menubar.setText("Attendence of "+semesterNumber+" "+sName);
            Log.e("all thisngs",sName+" "+deaptmentName+" "+semesterNumber+" "+noOfWeeks);
            myadapter=new Myadapter(deaptmentName,semesterNumber,sName,noOfWeeks,MainActivity.this);
            list_item.setAdapter(myadapter);
            myadapter.notifyDataSetChanged();
        } else {
            // User is not authenticated, show the sign-up page
            Intent i=new Intent(MainActivity.this,dataEntry.class);
            startActivity(i);
        }


    }
    public void onBackPressed() {
        Dialog dialog = new Dialog(MainActivity.this);
        TextView okay_text, cancel_text;
        dialog.setContentView(R.layout.backwardlayout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        okay_text = dialog.findViewById(R.id.okay_text);
        cancel_text = dialog.findViewById(R.id.cancel_text);
        /////////////////////////
        okay_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "YES clicked", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        cancel_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "NO clicked", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}