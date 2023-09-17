package com.example.class_attendence;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class modelforResult {
    int id;
    String rollnumST;
    int rollNumint;
    String day;
    String attendencecon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollnumST() {
        return rollnumST;
    }

    public void setRollnumST(String rollnumST) {
        this.rollnumST = rollnumST;
    }

    public int getRollNumint() {
        return rollNumint;
    }

    public void setRollNumint(int rollNumint) {
        this.rollNumint = rollNumint;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAttendencecon() {
        return attendencecon;
    }

    public void setAttendencecon(String attendencecon) {
        this.attendencecon = attendencecon;
    }

    public modelforResult(int id, String rollnumST, int rollNumint, String day, String attendencecon) {
        this.id = id;
        this.rollnumST = rollnumST;
        this.rollNumint = rollNumint;
        this.day = day;
        this.attendencecon = attendencecon;
    }
}
