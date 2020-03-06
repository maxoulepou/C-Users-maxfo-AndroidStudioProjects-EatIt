package com.example.eatit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class CalendrierActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.fragment_accueil));

//        Date today = new Date();
//        Calendar lastYear = Calendar.getInstance();
//        lastYear.add(Calendar.YEAR, 1);
//
//        CalendarPickerView datePicker = findViewById(R.id.calendar);
//        datePicker.init(today, lastYear.getTime())
//                .inMode(CalendarPickerView.SelectionMode.RANGE)
//                .withSelectedDate(today);

//        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(Date date) {
//                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
//
//                Calendar calSelected = Calendar.getInstance();
//                calSelected.setTime(date);
//
//                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)
//                        + " " + (calSelected.get(Calendar.MONTH) + 1)
//                        + " " + calSelected.get(Calendar.YEAR);
//
//                Toast.makeText(CalendrierActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onDateUnselected(Date date) {
//
//            }
//        });
    }
}
