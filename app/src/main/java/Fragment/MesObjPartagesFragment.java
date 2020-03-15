package Fragment;


import android.os.Bundle;
import com.example.eatit.R;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import Model.BD;
import Model.ObjectifPartage;
import Model.ObjectifPersonnel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesObjPartagesFragment extends Fragment {

    RecyclerView rv_objectifs_partages;
    BD bd;
    ArrayList<ObjectifPartage> mes_obj;
    ObjectifPartAdapter obj_adapter;


    public MesObjPartagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_obj_partages, container, false);

        bd = new BD(getActivity());

        rv_objectifs_partages = (RecyclerView) view.findViewById(R.id.recycler_view);

        mes_obj = bd.getObjectifsPartages();

        obj_adapter = new ObjectifPartAdapter(mes_obj);
        rv_objectifs_partages.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_objectifs_partages.setAdapter(obj_adapter);

        return view;
    }

}

