package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.eatit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.BD_Ressenti;

public class MaTeteFragment extends Fragment {

    private BD_Ressenti bdr;
    private String liste_emotion;
    private ToggleButton calme, serein, fier, reconnaissant, pensif, confiant, anxieux, triste, deprime, perdu, mefiant, coupable, surpris, enerve, apeure, embarasse, autre;
    private EditText commentaires;
    private Button enregistrer;
    private ToggleButton heureux;
    private String date_selectionne;


    public MaTeteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bdr = new BD_Ressenti(getContext());

        View view = inflater.inflate(R.layout.fragment_ma_tete, container, false);

        date_selectionne = getActivity().getIntent().getStringExtra("date_choisie");

        if (date_selectionne == null) {
            Calendar cldr = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            date_selectionne = dateFormat.format(cldr.getTime());

        }

        commentaires = (EditText) view.findViewById(R.id.commentaires);

        enregistrer = (Button) view.findViewById(R.id.bouton_enregistrer_tete);

        heureux = (ToggleButton) view.findViewById(R.id.bouton_heureux);
        calme = (ToggleButton) view.findViewById(R.id.bouton_calme);
        serein = (ToggleButton) view.findViewById(R.id.bouton_serein);
        fier = (ToggleButton) view.findViewById(R.id.bouton_fier);
        reconnaissant = (ToggleButton) view.findViewById(R.id.bouton_reconnaissant);
        pensif = (ToggleButton) view.findViewById(R.id.bouton_pensif);
        confiant = (ToggleButton) view.findViewById(R.id.bouton_confiant);
        anxieux = (ToggleButton) view.findViewById(R.id.bouton_anxieux);
        triste = (ToggleButton) view.findViewById(R.id.bouton_triste);
        deprime = (ToggleButton) view.findViewById(R.id.bouton_deprime);
        perdu = (ToggleButton) view.findViewById(R.id.bouton_perdu);
        mefiant = (ToggleButton) view.findViewById(R.id.bouton_mefiant);
        coupable = (ToggleButton) view.findViewById(R.id.bouton_coupable);
        surpris = (ToggleButton) view.findViewById(R.id.bouton_surpris);
        enerve = (ToggleButton) view.findViewById(R.id.bouton_enerve);
        apeure = (ToggleButton) view.findViewById(R.id.bouton_apeure);
        embarasse = (ToggleButton) view.findViewById(R.id.bouton_embarasse);
        autre = (ToggleButton) view.findViewById(R.id.bouton_autree);

        ajouterRessentiTete();

        return view;
    }


    public void ajouterRessentiTete() {
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = getListe_emotion();
                String commentaire = commentaires.getText().toString();

                boolean isInserted = bdr.insererRessentiTete(date_selectionne, emotion, commentaire);


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


    public String getListe_emotion() {

        liste_emotion = "";

        /* heureux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liste_emotion += "Heureux(se) ";
                heureux.setBackgroundResource(R.drawable.ressource_boutons_emotions);
            }
        });*/

        if (heureux.isChecked()) {
            liste_emotion += "Heureux(se) ";
            heureux.setBackgroundResource(R.drawable.heureuxbis);
        }

        if (calme.isChecked()) {
            liste_emotion += "Calme ";
            calme.setBackgroundResource(R.drawable.calmebis);
        }

        if (serein.isChecked()) {
            liste_emotion += "Serein(e) ";
            serein.setBackgroundDrawable(getResources().getDrawable(R.drawable.sereinbis));
        }

        if (fier.isChecked()) {
            liste_emotion += "Fier(ère) ";
            fier.setBackgroundDrawable(getResources().getDrawable(R.drawable.fierbis));
        }

        if (reconnaissant.isChecked()) {
            liste_emotion += "Reconnaissant(e) ";
            reconnaissant.setBackgroundDrawable(getResources().getDrawable(R.drawable.reconnaissantbis));
        }

        if (pensif.isChecked()) {
            liste_emotion += "Pensif(ve) ";
            pensif.setBackgroundDrawable(getResources().getDrawable(R.drawable.pensifbis));
        }

        if (confiant.isChecked()) {
            liste_emotion += "Confiant(e) ";
            confiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.confiantbis));
        }

        if (anxieux.isChecked()) {
            liste_emotion += "Anxieux(se) ";
            anxieux.setBackgroundDrawable(getResources().getDrawable(R.drawable.anxieuxbis));
        }

        if (triste.isChecked()) {
            liste_emotion += "Triste ";
            triste.setBackgroundDrawable(getResources().getDrawable(R.drawable.tristebis));
        }

        if (deprime.isChecked()) {
            liste_emotion += "Déprimé(e) ";
            deprime.setBackgroundDrawable(getResources().getDrawable(R.drawable.deprimebis));
        }

        if (perdu.isChecked()) {
            liste_emotion += "Perdu(e) ";
            perdu.setBackgroundDrawable(getResources().getDrawable(R.drawable.perdubis));
        }

        if (mefiant.isChecked()) {
            liste_emotion += "Méfiant(e) ";
            mefiant.setBackgroundDrawable(getResources().getDrawable(R.drawable.mefiantbis));
        }

        if (coupable.isChecked()) {
            liste_emotion += "Coupable ";
            coupable.setBackgroundDrawable(getResources().getDrawable(R.drawable.coupablebis));
        }

        if (surpris.isChecked()) {
            liste_emotion += "Surpris(e) ";
            surpris.setBackgroundDrawable(getResources().getDrawable(R.drawable.surprisbis));
        }

        if (enerve.isChecked()) {
            liste_emotion += "Enervé(e) ";
            enerve.setBackgroundDrawable(getResources().getDrawable(R.drawable.enervebis));
        }

        if (apeure.isChecked()) {
            liste_emotion += "Apeuré(e) ";
            apeure.setBackgroundDrawable(getResources().getDrawable(R.drawable.apeurebis));
        }

        if (embarasse.isChecked()) {
            liste_emotion += "Embarassé(e) ";
            embarasse.setBackgroundDrawable(getResources().getDrawable(R.drawable.embarassebis));
        }

        if (autre.isChecked()) {
            liste_emotion += "Autre ";
            autre.setBackgroundDrawable(getResources().getDrawable(R.drawable.autreebis));
        }

        return liste_emotion;
    }
}
