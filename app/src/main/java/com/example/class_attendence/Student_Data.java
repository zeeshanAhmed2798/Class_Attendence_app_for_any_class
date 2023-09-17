package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Student_Data extends AppCompatActivity {
    EditText numOfStudent,stringPart,integerPart;
    Button entry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        numOfStudent=findViewById(R.id.studentDATA);
        stringPart=findViewById(R.id.REG);
        integerPart=findViewById(R.id.integerPart);
        entry=findViewById(R.id.entry);
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ip=Integer.parseInt(integerPart.getText().toString());
                int numStudent=Integer.parseInt(numOfStudent.getText().toString());
                String rollString=stringPart.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("intPar",ip);
                editor.putInt("numOfStudent",numStudent);
                editor.putString("rollSt",rollString);
                editor.apply();
                Intent i=new Intent(Student_Data.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}