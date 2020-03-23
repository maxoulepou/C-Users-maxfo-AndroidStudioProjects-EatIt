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
public class MonCorpsFragment extends Fragment {

    private Spinner mSpinner;
    private TextView mOutputSpinnerTv;
    private TextView mOutputSpinnerTv2;
    private TextView mOutputSpinnerTv3;
    private TextView valeur_seekbar;

    private BD_Ressenti bdr;
    private String liste_sensations;
    private String commentaires;
    private SeekBar seekbar;
    private EditText et_commentaires;
    private Button enregistrer, supp1, supp2, supp3;
    private String date_selectionne;
    private int valeurSB;


    public MonCorpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mon_corps, container, false);

        bdr = new BD_Ressenti(getContext());

        mSpinner = view.findViewById(R.id.spinner);
        mOutputSpinnerTv = view.findViewById(R.id.outputSpinnerTv);
        mOutputSpinnerTv2 = view.findViewById(R.id.outputSpinnerTv2);
        mOutputSpinnerTv3 = view.findViewById(R.id.outputSpinnerTv3);
        valeur_seekbar = view.findViewById(R.id.valeurSeekBar);

        seekbar = (SeekBar) view.findViewById(R.id.seekBarCorps);
        et_commentaires = (EditText) view.findViewById(R.id.commentaires);
        enregistrer = (Button) view.findViewById(R.id.bouton_enregistrer);
        supp1=(Button) view.findViewById(R.id.button_supp_1);
        supp2=(Button) view.findViewById(R.id.button_supp_2);
        supp3=(Button) view.findViewById(R.id.button_supp_3);

        //On récupère la date picked dans le fragment afficher ressentis (RessentiFragment)
        date_selectionne = getActivity().getIntent().getStringExtra("date_choisie");

        //Si il n'y a aucune date sélectionnée dans RessentiFragment, alors on affecte la date à la date du jour.
        if (date_selectionne == null) {
            Calendar cldr = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            date_selectionne = dateFormat.format(cldr.getTime());

        }


        List<String> categories = new ArrayList<>();
        categories.add(0, "Votre ressenti");
        categories.add("Je suis gêné(e)");
        categories.add("Je suis douloureux(se)");
        categories.add("Je suis mal à l'aise");
        categories.add("Je suis courbaturé(e)");
        categories.add("Je suis plein(e) d'énergie");
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
                if (parent.getItemAtPosition(position).equals("Votre ressenti")) {

                } else {

                    if (mOutputSpinnerTv.getText().toString().isEmpty()) {
                        mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());
                    } else if (mOutputSpinnerTv2.getText().toString().isEmpty()) {
                        mOutputSpinnerTv2.setText(parent.getItemAtPosition(position).toString());
                    } else if (mOutputSpinnerTv3.getText().toString().isEmpty()) {
                        mOutputSpinnerTv3.setText(parent.getItemAtPosition(position).toString());
                    } else {
                        Toast.makeText(getActivity(), "Vous ne pouvez choisir que 3 ressentis au maximum  ", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        supp1.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         mOutputSpinnerTv.setText("");
                                     }
    });

        supp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOutputSpinnerTv2.setText("");
            }
        });

        supp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOutputSpinnerTv3.setText("");
            }
        });


        //On récupère la valeur de la seekbar et on la stocke dans le int valeurSB.
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                valeur_seekbar.setText(String.valueOf(progress));
                valeurSB = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        ajouterRessentiCorps();
        // Inflate the layout for this fragment
        return view;

    }



    public void ajouterRessentiCorps() {
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                liste_sensations = mOutputSpinnerTv.getText().toString() + mOutputSpinnerTv2.getText().toString() + mOutputSpinnerTv3.getText().toString();

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
