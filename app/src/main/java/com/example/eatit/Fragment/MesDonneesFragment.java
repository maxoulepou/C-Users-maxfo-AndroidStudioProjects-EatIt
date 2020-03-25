package com.example.eatit.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.eatit.R;

import java.util.ArrayList;

import com.example.eatit.Controleur.AjouterPoidsActivity;
import com.example.eatit.Model.BD_Poids;
import com.example.eatit.Model.Poids;


/**
 * com.example.eatit.Fragment gérant l'affichage des données de poids.
 */
public class MesDonneesFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Poids> mes_poids;
    private PoidsAdapter adapter;
    private BD_Poids bdp;
    private Button bouton;

    public MesDonneesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mes_donnees2, container, false);
        rv = (RecyclerView) view.findViewById(R.id.recycler_view);
        bdp = new BD_Poids(getContext());

        mes_poids = bdp.getTousLesPoids();
        bouton = (Button) view.findViewById(R.id.but_ajouter_poids);
        adapter = new PoidsAdapter(mes_poids);

        rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv.setAdapter(adapter);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), AjouterPoidsActivity.class);
                getActivity().startActivity(myIntent);
            }

        });

        return view;
    }

}
