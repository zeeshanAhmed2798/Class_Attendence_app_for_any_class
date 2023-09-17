package com.example.class_attendence;

public class modelClassForDB {
    int id;
    String rollnumS;
    int rollnumInt;
    String  attendences;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollnumS() {
        return rollnumS;
    }

    public void setRollnumS(String rollnumS) {
        this.rollnumS = rollnumS;
    }

    public int getRollnumInt() {
        return rollnumInt;
    }

    public void setRollnumInt(int rollnumInt) {
        this.rollnumInt = rollnumInt;
    }

    public String getAttendences() {
        return attendences;
    }

    public void setAttendences(String attendences) {
        this.attendences = attendences;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    String Day;
}
