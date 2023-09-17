package com.example.class_attendence;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class adapterAttendence extends BaseAdapter {

List<moelClasses> myList=new ArrayList<>();
LayoutInflater inflater;
Context c;
public adapterAttendence()
{

}

    public adapterAttendence(List<moelClasses> myList, Context c) {
        this.myList = myList;
        this.inflater = LayoutInflater.from(c);
        this.c = c;
    }

    @Override
    public int getCount() {
        Log.e("size", String.valueOf(myList.size()));
        return myList.size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.e("getView", "Position: " + i);
        if (view == null) {
            view = inflater.inflate(R.layout.coustomforattendence, null);
        }
        LinearLayout myLinear=view.findViewById(R.id.myLinear);
        Button presentAbsent = view.findViewById(R.id.presentAbsent);
        TextView intval = view.findViewById(R.id.intval);
        Button rollNum = view.findViewById(R.id.rollNum);
        int red = Integer.parseInt("09", 16);    // Red component
        int green = Integer.parseInt("A6", 16);  // Green component
        int blue = Integer.parseInt("ED", 16);   // Blue component

// Create a ColorStateList with the custom color
        int customColor = Color.rgb(red, green, blue);
        ColorStateList colorStateList2 = ColorStateList.valueOf(customColor);
        int customColor1 = Color.rgb(244, 87, 87);
        ColorStateList colorStateList = ColorStateList.valueOf(customColor1);
        // Log the data to ensure it's correct
        Log.e("Data", myList.get(i).getAttendence() + " " + myList.get(i).getVal() + " " + i + " " + myList.get(i).getRollNumsString());

        presentAbsent.setText(myList.get(i).getAttendence());
        intval.setText(" "+myList.get(i).getVal());
        rollNum.setText(myList.get(i).getRollNumsString());
        presentAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moelClasses item = myList.get(i);
                if ("P".equals(item.getAttendence())) {
                    item.setAttendence("A");
                } else {
                    item.setAttendence("P");
                }
                notifyDataSetChanged();
            }
        });
        presentAbsent.setText(myList.get(i).getAttendence());
        // Set background color based on the color state
        if ("P".equals(myList.get(i).getAttendence())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                presentAbsent.setBackgroundTintList(colorStateList2);
            }
            myLinear.setBackgroundResource(R.drawable.attendence);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                presentAbsent.setBackgroundTintList(colorStateList);
            }
            myLinear.setBackgroundResource(R.drawable.backgroundforpa);
        }
        intval.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                moelClasses item = myList.get(i);
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.dialogboxforedit);
                Button apply;
                EditText editroll;
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                apply = dialog.findViewById(R.id.apply);
                editroll = dialog.findViewById(R.id.editroll);
                apply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the 'apply' button click event
                        String editTextValue = editroll.getText().toString().trim();
                        try {
                            int r = Integer.parseInt(editTextValue);
                            item.setVal(r);
                        } catch (NumberFormatException e) {
                            // Handle the case where editTextValue is not a valid integer
                            // You can display an error message or take appropriate action here
                        }
                        // Dismiss the dialog when the 'apply' button is clicked
                        dialog.dismiss();
                    }
                });


                dialog.show();
                return  true;
            }
        });
        rollNum.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                moelClasses item = myList.get(i);
                Dialog dialog = new Dialog(c);
                dialog.setContentView(R.layout.layoutforstringrollnum);
                Button apply;
                EditText editroll;
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                apply = dialog.findViewById(R.id.applyRes);
                editroll = dialog.findViewById(R.id.editrollNum);
                apply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the 'apply' button click event
                        String editTextValue = editroll.getText().toString().trim();
                        item.setRollNumsString(editTextValue);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return  true;
            }
        });

        return view;
    }

}
