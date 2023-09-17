package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class dataEntry extends AppCompatActivity {
    EditText departmentName,sectionName;
    EditText SemesterNum;
    EditText noOfWeeks;
    Button button;

Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        sectionName=findViewById(R.id.sectionName);
        departmentName=findViewById(R.id.numOfStudent);
        SemesterNum=findViewById(R.id.SemesterNum);
        noOfWeeks=findViewById(R.id.noOfWeeks);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sn=sectionName.getText().toString();
                String departmentn=departmentName.getText().toString();
                String Sename=SemesterNum.getText().toString();
                int noOf=Integer.parseInt(noOfWeeks.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isAuthenticated", true);
                editor.putString("sectionName",sn);
                editor.putString("departmentName",departmentn);
                editor.putString("semesterNum",Sename);
                editor.putInt("numOfWeeks",noOf);
                editor.apply();
                Intent p=new Intent(dataEntry.this, Student_Data.class);
                startActivity(p);
            }
        });
    }
}