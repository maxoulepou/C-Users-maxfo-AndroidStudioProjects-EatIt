package Fragment;

import com.example.eatit.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.BD;
import Model.ObjectifPersonnel;
import Model.Objectifs;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesObjsAtteintsFragment extends Fragment {

    RecyclerView rv_objectifs_atteints;
    BD bd;
    ArrayList<Objectifs> mes_obj;
    ObjectifAtteintsAdapter obj_adapter;
    ObjectifAtteintsViewHolder obj_vh;
    Button ajouter;

    public MesObjsAtteintsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_objs_atteints, container, false);

        bd = new BD(getActivity());

        rv_objectifs_atteints = (RecyclerView) view.findViewById(R.id.recycler_view);
        ajouter = (Button) view.findViewById(R.id.ajouter_obj_part);


        mes_obj = bd.getObjectifsAtteints();

        obj_adapter = new ObjectifAtteintsAdapter(mes_obj);
        rv_objectifs_atteints.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_objectifs_atteints.setAdapter(obj_adapter);

        return view;
    }

}
