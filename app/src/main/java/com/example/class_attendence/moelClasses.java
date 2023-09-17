package com.example.class_attendence;

import android.widget.EditText;

public class moelClasses {
    int noOfStudents;
    int firstStudent;
    String rollNumsString;
    String date;
    int val;
    String Day;

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getAttendence() {
        return Attendence;
    }

    public void setAttendence(String attendence) {
        Attendence = attendence;
    }

    String Attendence;

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getFirstStudent() {
        return firstStudent;
    }

    public void setFirstStudent(int firstStudent) {
        this.firstStudent = firstStudent;
    }

    public String getRollNumsString() {
        return rollNumsString;
    }

    public void setRollNumsString(String rollNumsString) {
        this.rollNumsString = rollNumsString;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public moelClasses(int noOfStudents, int firstStudent, String rollNumsString, String date) {
        this.noOfStudents = noOfStudents;
        this.firstStudent = firstStudent;
        this.rollNumsString = rollNumsString;
        this.Attendence="P";
        this.val=firstStudent;
        this.date=date;
    }
}
