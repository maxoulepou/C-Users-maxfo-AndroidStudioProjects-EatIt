package com.example.eatit.Controleur;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import com.example.eatit.Model.BD_Poids;


/**
 * Activité gérant le suivi du poids.
 */
public class Poids_SuiviActivity extends AppCompatActivity {

    BD_Poids bdp;
    TextView poids_act, poids_dep, tt_act, tt_dep, taille_act, imc_act;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mon_suivi);
        bdp = new BD_Poids(this);

        //On cast les variables EditText et Button en recherchant les edittext et boutons grâce à leur ID

        poids_act = (TextView) findViewById(R.id.tv_poids_act);
        poids_dep = (TextView) findViewById(R.id.tv_poids_dep);
        tt_act = (TextView) findViewById(R.id.tv_tt_act);
        tt_dep = (TextView) findViewById(R.id.tv_tt_dep);
        taille_act = (TextView) findViewById(R.id.tv_taille_act);
        imc_act = (TextView) findViewById(R.id.tv_imc_act);

        // On utilise les fonctions de BD_Poids qui permettent de récupérer les données dans la BD
        poids_act.setText(String.valueOf(bdp.getPoidsActuel()));
        poids_dep.setText(String.valueOf(bdp.getPoidsDepart()));
        tt_act.setText(String.valueOf(bdp.getTTActuel()));
        tt_dep.setText(String.valueOf(bdp.getTTDepart()));
        taille_act.setText(String.valueOf(bdp.getTailleActuelle()));
        imc_act.setText(String.valueOf(bdp.getIMC()));

    }
}

