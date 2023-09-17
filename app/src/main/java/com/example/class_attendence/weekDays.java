package com.example.class_attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class weekDays extends AppCompatActivity {
    String[] arr={"Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday"};
    ListView list_item_weeks;
    String classnmae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_days); // Set the content view first
        Intent p=getIntent();
         classnmae=p.getStringExtra("SEMESTER");
        list_item_weeks = findViewById(R.id.list_item_weeks); // Find the ListView by its ID

        adapterDays a = new adapterDays(arr, weekDays.this);
        list_item_weeks.setAdapter(a);
        a.notifyDataSetChanged();

        list_item_weeks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // You can start a new activity and pass data as an extra
                Intent pt = new Intent(weekDays.this, Attendence.class);
                pt.putExtra("Dayname", arr[i]);
                pt.putExtra("SEMESTER",classnmae);
                startActivity(pt);

                // Or show a Toast message
                 Toast.makeText(weekDays.this, "Clicked on " + arr[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

        // ... (your existing code)

        // Method to handle item click from adapter
        public void onDayItemClick(String selectedDay) {
            Intent pt = new Intent(weekDays.this, Attendence.class);
            Log.e("error",selectedDay);
            pt.putExtra("Dayname", selectedDay);
            pt.putExtra("SEMESTER", classnmae);
            startActivity(pt);
        }


}
