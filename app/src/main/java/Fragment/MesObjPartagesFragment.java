package Fragment;


import android.content.Intent;
import android.os.Bundle;
import com.example.eatit.R;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Controleur.AjouterObjectifPartageActivity;
import Controleur.ModifierObjectifPartageActivity;
import Controleur.ModifierObjectifPersoActivity;
import Model.BD;
import Model.ObjectifPartage;
import Model.ObjectifPersonnel;
import Model.UnItemListener;


/**
 * Fragment gérant la liste des objectifs partagés.
 */
public class MesObjPartagesFragment extends Fragment implements UnItemListener {

    RecyclerView rv_objectifs_partages;
    BD bd;
    ArrayList<ObjectifPartage> mes_obj;
    ObjectifPartAdapter obj_adapter;
    Button ajouter;


    public MesObjPartagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_obj_partages, container, false);

        bd = new BD(getActivity());

        rv_objectifs_partages = (RecyclerView) view.findViewById(R.id.recycler_view);
        ajouter = (Button) view.findViewById(R.id.ajouter_obj_part);


        mes_obj = bd.getObjectifsPartages();

        obj_adapter = new ObjectifPartAdapter(mes_obj, this);
        rv_objectifs_partages.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_objectifs_partages.setAdapter(obj_adapter);

        ajouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openNewActivity(AjouterObjectifPartageActivity.class);
                    }
                }
        );

        return view;
    }

    /**
     * Ouvre une nouvelle activité à partir de l'activité courante.
     * @param nouvelle_activite
     */
    public void openNewActivity(Class nouvelle_activite) {
        Intent intent = new Intent(this.getActivity(), nouvelle_activite);
        startActivity(intent);
    }

    /**
     * Permet de modifier l'objectif personnel sélectionné dans la RecyclerView en l'affichant dans l'activité ModifierObjectifPerso.
     * @param position
     */
    @Override
    public void clicSurUnItem(int position) {
        Intent intent = new Intent(getActivity(), ModifierObjectifPartageActivity.class);
        intent.putExtra("objectif_part", mes_obj.get(position).getId());
        System.out.println(mes_obj.get(position).getId());
        startActivity(intent);
    }


}
