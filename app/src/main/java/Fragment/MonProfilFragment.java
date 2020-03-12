package Fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.example.eatit.R;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Controleur.MainActivity;
import Controleur.MenuBasActivity;
import Model.BD;
import Model.Patient;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonProfilFragment extends Fragment {

    private EditText champNom, champPrenom, champAdrresse, contactDUrgence;
    private EditText email, tel, codePostale, ville, adressePostale, dateN;
    private Button enregistrer, champMasculin, champFeminin;
    private BD mBD;
    private String sexe;

    public MonProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mon_profil, container, false);
        // Inflate the layout for this fragment
        champNom = (EditText) view.findViewById(R.id.rentrer_nom_monProfil);
        champPrenom = (EditText) view.findViewById(R.id.rentrer_prenom_monProfil);
        champAdrresse = (EditText) view.findViewById(R.id.rentrer_adresse);
        codePostale = (EditText) view.findViewById(R.id.rentrer_code_postal);
        ville = (EditText) view.findViewById(R.id.rentrer_ville);
        adressePostale = (EditText) view.findViewById(R.id.rentrer_adresse_postale);
        email = (EditText) view.findViewById(R.id.rentrer_email_monProfil);
        tel = (EditText) view.findViewById(R.id.rentrer_telephone_monProfil);
        champMasculin = (Button) view.findViewById(R.id.rentrer_masculin_monProfil);
        champFeminin = (Button) view.findViewById(R.id.rentrer_feminin_monProfil);
        contactDUrgence = (EditText) view.findViewById(R.id.rentrer_contact_urgence);
        enregistrer = (Button) view.findViewById(R.id.bouton_enregistrer_monProfil);
        dateN = (EditText) view.findViewById(R.id.rentrer_date_naissance_monProfil);
        mBD = new BD(this.getContext());

        champFeminin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexe = "Femme";
                champMasculin.setHighlightColor(Color.GRAY);
            }
        });

        champMasculin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexe = "Homme";
                champFeminin.setHighlightColor(Color.GRAY);
            }
        });

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Patient p = new Patient(email.getText().toString(), champNom.getText().toString(),
                        champPrenom.getText().toString(), sexe, dateN.getText().toString(),
                        ville.getText().toString(), champAdrresse.getText().toString(),
                        codePostale.getText().toString(), contactDUrgence.getText().toString());

                boolean isModified = mBD.modifierInfosUtilisateurs(p);
                if (isModified == true) {
                    Toast.makeText(getContext(), "Info Utilisateur modifié", Toast.LENGTH_SHORT).show();
                    Intent menuBas = new Intent(getContext(), Controleur.MenuBasActivity.class);
                    startActivity(menuBas);
                } else {
                    Toast.makeText(getContext(), "Info utilisateurs non modifié", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}