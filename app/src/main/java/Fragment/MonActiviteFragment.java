package Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eatit.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import Model.BD_Ressenti;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonActiviteFragment extends Fragment {

    String date_selectionne;


    public MonActiviteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mon_activite, container, false);

        date_selectionne = getActivity().getIntent().getStringExtra("date_choisie");

        //Si il n'y a aucune date sélectionnée dans RessentiFragment, alors on affecte la date à la date du jour.
        if (date_selectionne == null) {
            Calendar cldr = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            date_selectionne = dateFormat.format(cldr.getTime());

        }
        return view;
    }


    public void ajouterRessentiActivite() {
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                liste_sensations = mOutputSpinnerTv.getText().toString() + ", " + mOutputSpinnerTv2.getText().toString() + ", " + mOutputSpinnerTv3.getText().toString();

                if (liste_sensations.isEmpty()) {
                    liste_sensations = "Aucune";
                }

                commentaires = et_commentaires.getText().toString();


                boolean isInserted = bdr.insererRessentiCorps(date_selectionne, liste_sensations, commentaires, valeurSB);


                if (isInserted == true) {
                    Toast.makeText(getActivity(), "Vos données ont été ajoutées", Toast.LENGTH_SHORT).show();
                    System.out.println("HELLO WORLD");
                } else {
                    Toast.makeText(getActivity(), "Vos données n'ont pas été ajoutées", Toast.LENGTH_SHORT).show();
                    System.out.println("NOT WORLD");
                }

            }
        });

    }
}
