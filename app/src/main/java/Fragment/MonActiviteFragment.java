package Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Vibrator;
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
 * Gère l'ajout des activités sportives.
 */
public class MonActiviteFragment extends Fragment {

    String date_selectionne;
    String commentaire;
    String activite;

    int difficulte = -1;
    int duree;

    EditText activite_realisee;
    EditText duree_activite;
    EditText et_commentaire;

    Button aucuneffort;
    Button trestresfacile;
    Button tresfacile;
    Button facile;
    Button effortmodere;
    Button moyen;
    Button unpeudefficile;
    Button difficile;
    Button tresdifficile;
    Button trestresdifficile;
    Button maximal;
    Button enregistrer;
    Spinner spinner;
    
//    Vibrator v = (Vibrator) getActivity().getSystemService(getContext().VIBRATOR_SERVICE);

    BD_Ressenti bdr;

    public MonActiviteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mon_activite, container, false);

        bdr = new BD_Ressenti(getContext());
        duree_activite = (EditText) view.findViewById(R.id.duree_activite);

        aucuneffort = (Button) view.findViewById(R.id.aucun_effort);
        trestresfacile = (Button) view.findViewById(R.id.tres_tres_facile);
        tresfacile = (Button) view.findViewById(R.id.tres_facile);
        facile = (Button) view.findViewById(R.id.facile);
        effortmodere = (Button) view.findViewById(R.id.effort_modere);
        moyen = (Button) view.findViewById(R.id.moyen);
        unpeudefficile = (Button) view.findViewById(R.id.un_peu_difficile);
        difficile = (Button) view.findViewById(R.id.difficile);
        tresdifficile = (Button) view.findViewById(R.id.tres_difficile);
        trestresdifficile = (Button) view.findViewById(R.id.tres_tres_difficile);
        maximal = (Button) view.findViewById(R.id.maximal);
        enregistrer = (Button) view.findViewById(R.id.bouton_enregistrer_activite);
        et_commentaire = (EditText) view.findViewById(R.id.commentaires);
        spinner= view.findViewById(R.id.activite_realisee);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Votre activité");
        categories.add("Marche");
        categories.add("Course");
        categories.add("Vélo");
        categories.add("Gym douce");
        categories.add("Yoga");
        categories.add("Sport collectif");
        categories.add("Natation");
        categories.add("Randonnée");
        categories.add("Aquagym");
        categories.add("Autre");

        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

        //spinner item click handler
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        date_selectionne = getActivity().getIntent().getStringExtra("date_choisie");

        //Si il n'y a aucune date sélectionnée dans RessentiFragment, alors on affecte la date à la date du jour.
        if (date_selectionne == null) {
            Calendar cldr = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            date_selectionne = dateFormat.format(cldr.getTime());

        }
        setDifficulte();
        ajouterRessentiActivite();

        return view;
    }

    /**
     * Permet d'ajouter un nouveau ressenti d'activité dans la base de données.
     */
    public void ajouterRessentiActivite() {
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commentaire = et_commentaire.getText().toString();
                if (duree_activite.getText().toString().isEmpty()) {
                    duree = -1;
                } else {
                    duree = Integer.parseInt(duree_activite.getText().toString());
                }

                activite = spinner.getSelectedItem().toString();

                boolean isInserted = bdr.insererRessentiActivite(date_selectionne, activite, commentaire, difficulte, duree);


                if (isInserted == true) {
                    Toast.makeText(getActivity(), "Vos données ont été ajoutées", Toast.LENGTH_SHORT).show();
                    System.out.println("HELLO WORLD");
                } else {
                    Toast.makeText(getActivity(), "Certains champs ne sont pas remplis", Toast.LENGTH_SHORT).show();
                    System.out.println("NOT WORLD");
                }

            }
        });

    }

    /**
     * Attribue une valeur à l'attribut "difficulte" suivant le bouton sélectionné.
     */
    public void setDifficulte() {

        aucuneffort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Aucun effort", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 0;
            }
        });

        trestresfacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Très très facile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 1;
            }
        });

        tresfacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Très facile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 2;
            }
        });

        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Facile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 3;
            }
        });

        effortmodere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Effort modéré", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 4;
            }
        });

        moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Effort moyen", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 5;
            }
        });

        unpeudefficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Un peu difficile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 6;
            }
        });

        difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Difficile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 7;
            }
        });

        tresdifficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Très difficile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 8;
            }
        });

        trestresdifficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Très très difficile", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 9;
            }
        });

        maximal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Maximal", Toast.LENGTH_SHORT).show();
//                getVibrator().vibrate(300);
                difficulte = 10;
            }
        });

    }

//    public Vibrator getVibrator() {
//        return v;
//    }
}
