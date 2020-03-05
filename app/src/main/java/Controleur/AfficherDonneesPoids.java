package Controleur;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import Model.BD_Poids;
import Model.Poids;
import Views.PoidsAdapter;


public class AfficherDonneesPoids extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Poids> mes_poids;
    private PoidsAdapter adapter;
    private BD_Poids bdp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_poids_recycler);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        bdp = new BD_Poids(this);

        mes_poids = bdp.getTousLesPoids();

        adapter = new PoidsAdapter(mes_poids);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapter);
    }

}
