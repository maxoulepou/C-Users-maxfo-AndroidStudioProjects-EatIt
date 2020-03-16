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

import java.util.ArrayList;

import Controleur.AfficherUnContactActivity;
import Controleur.AjouterObjectifPersoActivity;
import Controleur.ModifierObjectifPersoActivity;
import Model.BD;
import Model.ObjectifPersonnel;
import Model.UnItemListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesObjPersonnelsFragment extends Fragment implements UnItemListener {

    RecyclerView rv_objectifs_personnels;
    BD bd;
    ArrayList<ObjectifPersonnel> mes_obj;
    ObjectifPersoAdapter obj_adapter;
    ObjectifPersoViewHolder obj_vh;
    Button ajouter;


    public MesObjPersonnelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_obj_personnels, container, false);

        bd = new BD(getActivity());

        rv_objectifs_personnels = (RecyclerView) view.findViewById(R.id.recycler_view);
        ajouter = (Button) view.findViewById(R.id.ajouter_obj_perso);

        mes_obj = bd.getObjectifsPersonnels();

        obj_adapter = new ObjectifPersoAdapter(mes_obj, this);
        rv_objectifs_personnels.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_objectifs_personnels.setAdapter(obj_adapter);

        ajouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openNewActivity(AjouterObjectifPersoActivity.class);
                    }
                }
        );

        return view;
    }

    @Override
    public void clicSurUnItem(int position) {
        Intent intent = new Intent(getActivity(), ModifierObjectifPersoActivity.class);
        intent.putExtra("objectif_perso", mes_obj.get(position).getId());
        System.out.println(mes_obj.get(position).getId());
        startActivity(intent);
    }

    public void openNewActivity(Class nouvelle_activite) {
        Intent intent = new Intent(this.getActivity(), nouvelle_activite);
        startActivity(intent);
    }


}
