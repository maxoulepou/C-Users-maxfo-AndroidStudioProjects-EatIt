package com.example.eatit.Fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.eatit.Controleur.AfficherListeContactsActivity;
import com.example.eatit.Controleur.ExporterDonneesActivity;
import com.example.eatit.Controleur.MonProfilEtEvntActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.example.eatit.Controleur.MonRessentiActivity;
import com.example.eatit.Model.BD_Ressenti;
import com.example.eatit.Model.RessentiActivite;
import com.example.eatit.Model.RessentiCorps;
import com.example.eatit.Model.RessentiTete;

/**
 * Gère l'affichage des ressentis à partir d'une date sélectionnée. Ce fragment contient 3 RecyclerView, un pour chaque type de ressenti.
 */
public class RessentiFragment extends Fragment {

    TextView et_date;
    TextView date, commentaires, emotions;
    String datepicked;
    RecyclerView rv_tete, rv_corps, rv_activite;
    BD_Ressenti bdr;

    RessentiTeteAdapter rt_adapter;
    RessentiCorpsAdapter rc_adapter;
    RessentiActiviteAdapter ra_adapter;

    private static final int espace = 10;

    ArrayList<RessentiTete> mes_rt;
    ArrayList<RessentiCorps> mes_rc;
    ArrayList<RessentiActivite> mes_ra;

    Button bouton_ajouter_ressenti;
    ImageButton menu;

    public RessentiFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bdr = new BD_Ressenti(getActivity());

        View view = inflater.inflate(R.layout.fragment_afficher_ressentis, container, false);
        menu = (ImageButton) view.findViewById(R.id.menu);
        bouton_ajouter_ressenti = (Button) view.findViewById(R.id.but_ajouter_ressenti);
        date = (TextView) view.findViewById(R.id.tv_date);
        commentaires = (TextView) view.findViewById(R.id.tv_commentaire);
        emotions = (TextView) view.findViewById(R.id.tv_emotion);
        et_date = (TextView) view.findViewById(R.id.et_datepick);
        rv_tete = (RecyclerView) view.findViewById(R.id.rv_ma_tete);
        rv_corps = (RecyclerView) view.findViewById(R.id.rv_mon_corps);
        rv_activite = (RecyclerView) view.findViewById(R.id.rv_mon_activite);

        final Calendar cldr = Calendar.getInstance();

        cldr.getInstance().get(Calendar.MONTH);
        cldr.getInstance().get(Calendar.YEAR);
        cldr.getInstance().get(Calendar.DAY_OF_MONTH);

        //On formate pour la recherche dans la BD.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        datepicked = dateFormat.format(cldr.getTime());
        et_date.setText(datepicked);

        // On récupère les ressentis_tete qui sont à la date selectionnée :
        mes_rt = bdr.getTousLesRessentisTete(datepicked);
        //System.out.println("BLAAAAAAAAAABLABLABLABLABLAAAA LA DATE EST = " + mes_rt.get(0).getDate());

        rt_adapter = new RessentiTeteAdapter(mes_rt);
        rv_tete.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_tete.setAdapter(rt_adapter);
        rv_tete.addItemDecoration(new VerticalSpaceItemDecoration(espace));


        mes_rc = bdr.getTousLesRessentisCorps(datepicked);

        rc_adapter = new RessentiCorpsAdapter(mes_rc);
        rv_corps.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_corps.setAdapter(rc_adapter);
        rv_corps.addItemDecoration(new VerticalSpaceItemDecoration(espace));


        mes_ra = bdr.getTousLesRessentisActivite(datepicked);

        ra_adapter = new RessentiActiviteAdapter(mes_ra);
        rv_activite.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_activite.setAdapter(ra_adapter);
        rv_activite.addItemDecoration(new VerticalSpaceItemDecoration(espace));

        et_date.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           final Calendar cldr = Calendar.getInstance();
                                           final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                                               @Override
                                               //Cette méthode elle nous sert à enregistrer la date sélectionnée
                                               public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                                     int dayOfMonth) {
                                                   cldr.set(Calendar.YEAR, year);
                                                   cldr.set(Calendar.MONTH, monthOfYear);
                                                   cldr.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                                   //On formate pour la recherche dans la BD.
                                                   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                                                   datepicked = dateFormat.format(cldr.getTime());
                                                   System.out.println("BLABLAAAAAAAAAAAAAAAAAAAAA : " + datepicked);

                                                   // On récupère les ressentis_tete qui sont à la date selectionnée :
                                                   mes_rt = bdr.getTousLesRessentisTete(datepicked);
                                                   //System.out.println("BLAAAAAAAAAABLABLABLABLABLAAAA LA DATE EST = " + mes_rt.get(0).getDate());

                                                   rt_adapter = new RessentiTeteAdapter(mes_rt);
                                                   rv_tete.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                                                   rv_tete.setAdapter(rt_adapter);
                                                   rv_tete.addItemDecoration(new VerticalSpaceItemDecoration(espace));


                                                   mes_rc = bdr.getTousLesRessentisCorps(datepicked);

                                                   rc_adapter = new RessentiCorpsAdapter(mes_rc);
                                                   rv_corps.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                                                   rv_corps.setAdapter(rc_adapter);
                                                   rv_corps.addItemDecoration(new VerticalSpaceItemDecoration(espace));


                                                   mes_ra = bdr.getTousLesRessentisActivite(datepicked);

                                                   ra_adapter = new RessentiActiviteAdapter(mes_ra);
                                                   rv_activite.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                                                   rv_activite.setAdapter(ra_adapter);
                                                   rv_activite.addItemDecoration(new VerticalSpaceItemDecoration(espace));


                                                   //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                                   DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                                   String dateDF = df_date.format(cldr.getTime());
                                                   et_date.setText(dateDF);
                                               }

                                           };

                                           new DatePickerDialog(getActivity(), date, cldr
                                                   .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                                   cldr.get(Calendar.DAY_OF_MONTH)).show();


                                       }

                                   }
        );


        bouton_ajouter_ressenti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNewActivity(MonRessentiActivity.class);
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                PopupMenu popupMenu= new PopupMenu(getActivity().getApplicationContext(),menu);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item1:
                                openNewActivity(MonProfilEtEvntActivity.class);
                                break;
                            case R.id.item2:
                                openNewActivity(AfficherListeContactsActivity.class);
                                break;
                            case R.id.item3:
                                openNewActivity(ExporterDonneesActivity.class);
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        return view;
    }


    /**
     * Ouvre une nouvelle activité à partir de l'activité courante.
     * @param nouvelle_classe
     */
    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(this.getActivity(), nouvelle_classe);
        intent.putExtra("date_choisie", datepicked);
        startActivity(intent);
    }

}