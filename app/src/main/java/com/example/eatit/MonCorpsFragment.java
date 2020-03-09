package com.example.eatit;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonCorpsFragment extends Fragment {

    Spinner mSpinner;
    TextView mOutputSpinnerTv;
    TextView mOutputSpinnerTv2;
    TextView mOutputSpinnerTv3;

    public MonCorpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mon_corps, container, false);
        mSpinner = view.findViewById(R.id.spinner);
        mOutputSpinnerTv = view.findViewById(R.id.outputSpinnerTv);
        mOutputSpinnerTv2 = view.findViewById(R.id.outputSpinnerTv2);
        mOutputSpinnerTv3 = view.findViewById(R.id.outputSpinnerTv3);

        List<String> categories = new ArrayList<>();
        categories.add(0,"Votre ressenti physique");
        categories.add("Fatigué");
        categories.add("Plein d'énergie");
        categories.add("Nausées");
        categories.add("Migraine");
        categories.add("Maux de ventre");
        categories.add("Diarrhée");
        categories.add("Constipé");
        categories.add("Mince");
        categories.add("Gros");
        categories.add("Autre");

        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        mSpinner.setAdapter(aa);

        //spinner item click handler
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Votre ressenti physique")) {

                } else {

                    if (mOutputSpinnerTv.getText().toString().isEmpty()) {
                        mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());
                    } else if (mOutputSpinnerTv2.getText().toString().isEmpty()) {
                        mOutputSpinnerTv2.setText(parent.getItemAtPosition(position).toString());
                    }
                    else if (mOutputSpinnerTv3.getText().toString().isEmpty()) {
                        mOutputSpinnerTv3.setText(parent.getItemAtPosition(position).toString());
                    }
                    else {
                        Toast.makeText(getActivity(), "Vous ne pouvez choisir que 3 ressentis physiques au maximum  ", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
