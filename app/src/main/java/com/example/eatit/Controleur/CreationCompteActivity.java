package com.example.eatit.Controleur;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import com.example.eatit.Model.BD;
import com.example.eatit.Model.Patient;

/**
 * Activité qui gère la création de compte.
 */
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
        textMail = (EditText) findViewById(R.id.editText_email_creationCompte);
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
                if (mBD.getId(textMail.getText().toString()).equals("Pas de mail trouve")){
                    Patient p = new Patient(textMail.getText().toString(), textMdp.getText().toString(), textNom.getText().toString(), textPrenom.getText().toString(), sexe, textDateNaissance.getText().toString());
                    mBD.creerCompte(p);
                    Toast.makeText(CreationCompteActivity.this, "Votre compte a bien été créé", Toast.LENGTH_SHORT).show();
                    Intent ContactActivity = new Intent(CreationCompteActivity.this, MenuBasActivity.class);
                    startActivity(ContactActivity);
                }
                else {
                    Toast.makeText(CreationCompteActivity.this, "Ce compte existe déjà.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
