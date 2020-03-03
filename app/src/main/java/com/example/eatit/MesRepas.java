package com.example.eatit;

import Controleur.MainActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MesRepas extends AppCompatActivity {

    private static final String TAG="MesRepas";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateListener;
    private EditText jourRepas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_repas);
        jourRepas = (EditText)findViewById(R.id.jourRepas);

        jourRepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Calendar cal= Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month= cal.get(Calendar.MONTH);
               int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MesRepas.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month=month+1;
            Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

            String date = month + "/" + day + "/" + year;
                jourRepas.setText(date);
            }
        };
    }
}
