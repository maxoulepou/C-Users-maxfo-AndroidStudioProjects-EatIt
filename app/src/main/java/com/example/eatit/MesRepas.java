package com.example.eatit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class MesRepas extends AppCompatActivity {

    private EditText jourRepas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_repas);

        jourRepas=(EditText)findViewById(R.id.jourRepas);
        jourRepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Calendar cal= Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month= cal.get(Calendar.MONTH);
               int day= cal.get(Calendar.DAY_OF_MONTH);
            }
        });
    }
}
