package com.example.eatit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextBienvenu;
    private Button mConnexionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextBienvenu = (TextView) findViewById(R.id.activity_main_text_bienvenu);
        mConnexionButton = (Button) findViewById(R.id.activity_main_connexion_button);
    }


}
