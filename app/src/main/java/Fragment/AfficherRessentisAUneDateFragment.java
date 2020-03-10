package Fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import Model.BD_Ressenti;
import Model.RessentiTete;


public class AfficherRessentisAUneDateFragment extends Fragment {

    TextView date, commentaires, emotions;
    String datepicked;
    EditText et_date;
    RecyclerView rv_tete;
    RecyclerView rv_corps;
    RecyclerView rv_activite;
    BD_Ressenti bdr;
    RessentiTeteAdapter rt_adapter;
    private static final int espace = 10;
    ArrayList<RessentiTete> mes_rt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bdr = new BD_Ressenti(getActivity());

        View view = inflater.inflate(R.layout.fragment_afficher_ressentis, container, false);

        date = (TextView) view.findViewById(R.id.tv_date);
        commentaires = (TextView) view.findViewById(R.id.tv_commentaire);
        emotions = (TextView) view.findViewById(R.id.tv_emotion);
        et_date = (EditText) view.findViewById(R.id.et_datepick);
        rv_tete = (RecyclerView) view.findViewById(R.id.rv_ma_tete);

        rt_adapter = new RessentiTeteAdapter(mes_rt);
        rv_tete.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_tete.setAdapter(rt_adapter);
        rv_tete.addItemDecoration(new VerticalSpaceItemDecoration(espace));

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

                                                   // On récupère les ressentis_tete qui sont à la date selectionnée :
                                                   mes_rt = bdr.getTousLesRessentisTete(datepicked);

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

        return view;
    }


}
