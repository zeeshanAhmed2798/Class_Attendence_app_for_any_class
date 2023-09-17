package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Attendence extends AppCompatActivity {
    TextView session_id,course,day;
    adapterAttendence adapter;
    ListView list_item_student;
    MydataBase database;
     EditText datePicker;
    moelClasses model;
    CircleImageView icon;
    String selectedDate;
    String subject;
    List<moelClasses> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        list_item_student = findViewById(R.id.list_item_student);
        session_id = findViewById(R.id.session_id);
        icon = findViewById(R.id.icon);
        day = findViewById(R.id.day);
        course = findViewById(R.id.course);
        datePicker=findViewById(R.id.datePicker);
        Intent g=getIntent();
        String da=g.getStringExtra("Dayname");
        String classname=g.getStringExtra("SEMESTER");
        Log.e("day",classname);
        day.setText("Day: "+da);
        database=new MydataBase(Attendence.this);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String sectionName = sharedPreferences.getString("sectionName", "");
        String semesterNumber = sharedPreferences.getString("semesterNum", "");
        session_id.setText("Attendance of " + semesterNumber + sectionName);
        SharedPreferences sharedPreference = getSharedPreferences("MyData", MODE_PRIVATE);
        String rollnumberString = sharedPreference.getString("rollSt", "");
        int numOfStudent = sharedPreference.getInt("numOfStudent", 0);
        int integerPart = sharedPreference.getInt("intPar", 0);
        String date=datePicker.getText().toString();
        Log.e("Debug====>", sectionName + " " + rollnumberString + " " + numOfStudent + " " + integerPart);
        course.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Dialog dialog = new Dialog(Attendence.this);
                dialog.setContentView(R.layout.coursedetails);
                Button applyCourse;
                EditText courseName;
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                applyCourse = dialog.findViewById(R.id.applyCourse);
                courseName = dialog.findViewById(R.id.courseName);
                applyCourse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the 'apply' button click event
                        String editTextValue = courseName.getText().toString().trim();
                        course.setText(editTextValue);
                         subject=course.getText().toString();
                        // String day_go=day.getText().toString();
                        Log.e("COURSEEE",subject);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return  true;
            }
        });
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        Log.e("Studentsss", String.valueOf(numOfStudent));
        int k; // Declare k outside the loop
        for (k = 0; k < numOfStudent; k++) {
            Log.d("listttt", String.valueOf(k));
            model = new moelClasses(numOfStudent, integerPart + k, rollnumberString,date);
            model.setDay(da);
            myList.add(model);
        }
        adapter = new adapterAttendence(myList, Attendence.this);
        list_item_student.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.e("myList size", String.valueOf(myList.size()));
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedDate == null || selectedDate.isEmpty())
                {
                    Toast.makeText(Attendence.this, "Enter date", Toast.LENGTH_SHORT).show();
                }else {
                    for (int i = 0; i < numOfStudent; i++) {
                        database.insert(myList.get(i).rollNumsString, myList.get(i).getVal(), myList.get(i).getAttendence(), da, selectedDate);
                        Log.e("ANSWERG", myList.get(i).rollNumsString + " " + myList.get(i).getVal() + " " + myList.get(i).getAttendence() + " " + da + " " + selectedDate);
                    }
                    Intent k = new Intent(Attendence.this, Results.class);
                    k.putExtra("COURSE", subject);
                    k.putExtra("SECTION", classname);
                    k.putExtra("DATE", selectedDate);
                    startActivity(k);
                }
            }
        });


    }



    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        // Handle the selected date here (e.g., update a TextView)
                         selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                        datePicker.setText(selectedDate);
                    }
                },
                year, month, day);

        // Show the date picker dialog
        datePickerDialog.show();
    }
}
