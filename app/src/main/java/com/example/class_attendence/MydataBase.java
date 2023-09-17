package com.example.class_attendence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MydataBase extends SQLiteOpenHelper {
    private static final String DataBaseName = "AttendenceDB";
    private static final String Table_name = "Attencence";
    private static final int DataBase_Version = 2;
    private static final String KEY_ID = "Id";
    private static final String RollNumber = "RollNumber";
    private static final String RollNumberINTPart = "Numeric_part";
    private static final String Attendence = "Attendence";
    private static final String DAY = "DAY";
    private static final String DATE = "DATE";

    public MydataBase(@Nullable Context context) {
        super(context, DataBaseName, null, DataBase_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("MydataBase", "Creating database and table");
        sqLiteDatabase.execSQL("CREATE TABLE " + Table_name +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RollNumber + " TEXT, " + RollNumberINTPart +
                " INTEGER, " + Attendence + " TEXT, " + DAY + " TEXT, " + DATE + " TEXT)");
        Log.d("MydataBase", "onCreate method is being called");
    }

//    public Cursor getData(MydataBase db) {
//
//        SQLiteDatabase DOB = db.getReadableDatabase();
//        String[] col = {KEY_ID,RollNumber,RollNumberINTPart,Attendence,DAY};
//        Cursor cr = DOB.query(false, Table_name, col, null, null, null, null, null, null);
//
//        return cr;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);
    }

    public void insert(String rollNumber, int numericPart, String atten, String day, String date) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RollNumber, rollNumber);
        values.put(RollNumberINTPart, numericPart);
        values.put(Attendence, atten);
        values.put(DAY, day);
        values.put(DATE, date);
        database.insert(Table_name, null, values);
    }

    public ArrayList<modelClassForDB> fetchData(String date) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + Table_name, null);
        ArrayList<modelClassForDB> arr = new ArrayList<>();
        arr.clear();
        while (cursor.moveToNext()) {
            String dateFromDB = cursor.getString(5);  // Assuming date is at index 5
            // Assuming you have a method to get the current date
             Log.e("dateeee",dateFromDB+" "+date);
            if (dateFromDB.equals(date)) {
                modelClassForDB model = new modelClassForDB();
                model.setId(cursor.getInt(0));
                model.setRollnumS(cursor.getString(1));
                model.setRollnumInt(cursor.getInt(2));
                model.setAttendences(cursor.getString(3));
                model.setDay(cursor.getString(4));
                model.setDate(dateFromDB);  // Set the date from the database
                arr.add(model);
            }
            else {

            }

        }
        cursor.close();
        return arr;
    }
}

