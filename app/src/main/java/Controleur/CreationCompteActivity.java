package Controleur;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import Model.BD;
import Model.Patient;

public class CreationCompteActivity extends AppCompatActivity {

    private Button mButtonCreationCompte;
    private EditText textMail, textMdp, textNom, textPrenom, textDateNaissance;
    private ImageButton buttonHomme, buttonFemme;
    private String sexe;
    private BD mBD;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBD = new BD(this);
        setContentView(R.layout.activity_creation_compte);
        textMail = (EditText) findViewById(R.id.editText_email);
        textMdp = (EditText) findViewById(R.id.editText_Password);
        textNom = (EditText) findViewById(R.id.editTextNom);
        textPrenom = (EditText) findViewById(R.id.editTextPrenom);
        textDateNaissance = (EditText) findViewById(R.id.edit_text_date_naissance);
        buttonFemme = (ImageButton) findViewById(R.id.imageButtonfemme);
        buttonHomme = (ImageButton) findViewById(R.id.imageButtonhomme);
        mButtonCreationCompte = (Button) findViewById(R.id.activity_creation_button_creatCompte);

        buttonHomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHomme.setColorFilter(null);
                buttonFemme.setColorFilter(Color.GRAY);
                sexe = "Homme";
            }
        });

        buttonFemme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFemme.setColorFilter(null);
                buttonHomme.setColorFilter(Color.GRAY);
                sexe = "Femme";
            }
        });

        mButtonCreationCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBD.getId(textMail.getText().toString()).equals("Error")){
                    Patient p = new Patient(textMail.getText().toString(), textMdp.getText().toString(), textNom.getText().toString(), textPrenom.getText().toString(), sexe, textDateNaissance.getText().toString());
                    mBD.creerCompte(p);
                    Intent ContactActivity = new Intent(CreationCompteActivity.this, MenuBasActivity.class);
                    startActivity(ContactActivity);
                }
                else {
                    System.out.println("Ce compte existe deja");
                }
            }
        });
    }
}
