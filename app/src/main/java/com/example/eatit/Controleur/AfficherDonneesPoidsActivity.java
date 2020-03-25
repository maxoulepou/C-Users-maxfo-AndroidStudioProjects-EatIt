package com.example.eatit.Controleur;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import com.example.eatit.Model.BD_Poids;
import com.example.eatit.Model.Poids;
import com.example.eatit.Fragment.PoidsAdapter;


/**
 * Activité qui permet d'afficherr les données de poids sous forme de RecyclerView.
 */
public class AfficherDonneesPoidsActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Poids> mes_poids;
    private PoidsAdapter adapter;
    private BD_Poids bdp;

    /**
     * Crée la page permettant d'afficher le recycler view contenant la liste des différents poids enregistrés dans la base de données.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mes_donnees2);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        bdp = new BD_Poids(this);

        mes_poids = bdp.getTousLesPoids();

        adapter = new PoidsAdapter(mes_poids);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapter);
    }

}
