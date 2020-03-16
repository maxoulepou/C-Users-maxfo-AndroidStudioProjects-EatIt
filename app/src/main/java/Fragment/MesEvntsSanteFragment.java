package Fragment;


import android.os.Bundle;

import Controleur.MonRessentiActivity;
import Model.BD_Evenement;
import Model.BD_Poids;
import Model.BD_Ressenti;
import Model.Evenement;
import Model.Poids;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesEvntsSanteFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Evenement> mes_evenements;
    private EvenementAdapter adapter;
    private BD_Evenement bde;
    private Button bouton;
    TextView date, commentaires, evenement;

    public MesEvntsSanteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bde = new BD_Evenement(getActivity());

        View view = inflater.inflate(R.layout.fragment_mes_evnt_sante, container, false);
        bouton = (Button) view.findViewById(R.id.bouton_ajouter_evnt_sante);
        date = (TextView) view.findViewById(R.id.tv_date);
        commentaires = (TextView) view.findViewById(R.id.tv_commentaire);
        evenement = (TextView) view.findViewById(R.id.tv_evenement);
        rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        return view;
    }


}
