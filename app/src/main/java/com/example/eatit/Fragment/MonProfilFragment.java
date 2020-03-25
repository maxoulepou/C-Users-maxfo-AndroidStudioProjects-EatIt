package com.example.eatit.Fragment;


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

import com.example.eatit.Model.BD;
import com.example.eatit.Model.Patient;


/**
 * com.example.eatit.Fragment gérant l'enregistrement du profil dans la base de données.
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
                System.out.println(sexe);
                champMasculin.setHighlightColor(Color.GRAY);
            }
        });

        champMasculin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexe = "Homme";
                System.out.println(sexe);
                champFeminin.setHighlightColor(Color.GRAY);
            }
        });

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(email.getText().toString());
                System.out.println(champNom.getText().toString());
                System.out.println(champPrenom.getText().toString());
                System.out.println(sexe);
                System.out.println(dateN.getText().toString());
                System.out.println(ville.getText().toString());
                System.out.println(champAdrresse.getText().toString());
                System.out.println(codePostale.getText().toString());
                System.out.println(contactDUrgence.getText().toString());

                Patient p = new Patient(email.getText().toString(), champNom.getText().toString(),
                        champPrenom.getText().toString(), sexe, dateN.getText().toString(),
                        ville.getText().toString(), champAdrresse.getText().toString(),
                        codePostale.getText().toString(), contactDUrgence.getText().toString());

                boolean isModified = mBD.modifierInfosUtilisateurs(p);
                if (isModified == true) {
                    Toast.makeText(getContext(), "Info Utilisateur modifié", Toast.LENGTH_SHORT).show();
                    Intent menuBas = new Intent(getContext(), com.example.eatit.Controleur.MenuBasActivity.class);
                    startActivity(menuBas);
                } else {
                    Toast.makeText(getContext(), "Info utilisateurs non modifié", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}