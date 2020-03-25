package Controleur;

import android.os.Bundle;

import com.example.eatit.R;

import java.util.ArrayList;

import Fragment.EvenementAdapter;
import Model.BD_Evenement;
import Model.Evenement;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Activité gérant l'affichage des événements de santé dans le RecyclerView d'intérêt.
 */
public class AfficherEvenementsSanteActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Evenement> mes_evenements;
    private BD_Evenement bde;
    private EvenementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mes_evnt_sante);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        bde = new BD_Evenement(this);

        mes_evenements = bde.getTousLesEvenement();

        adapter = new EvenementAdapter(mes_evenements);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapter);
    }

}
