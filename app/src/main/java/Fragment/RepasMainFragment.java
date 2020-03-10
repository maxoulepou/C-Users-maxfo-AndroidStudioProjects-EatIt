package Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import Controleur.AjouterRepasActivity;
import Model.BD_Repas;
import Model.Repas;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepasMainFragment extends Fragment {

    @BindView(R.id.recyclerView_mesRepas) RecyclerView recyclerView;
    //private Disposable disposable;
    private ArrayList<Repas> lRepas;
    private RepasAdapter mAdapter;
    private String mDate;
    private EditText mTextDate;
    private BD_Repas mBD_repas;
    private RepasAdapter mRepasAdapter;
    private RecyclerView mRecyclerView;
    private Button buttonAjoutRepas;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
//        View view = inflater.inflate(R.layout.)
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mes_repas);
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_mes_repas, container, false);
        mTextDate = (EditText) view.findViewById(R.id.jourRepas_mesRepas);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_mesRepas);
        buttonAjoutRepas = (Button) view.findViewById(R.id.button_add_repas);
        mBD_repas = new BD_Repas(getContext());
        mDate = Calendar.getInstance().toString();
        lRepas = new ArrayList<Repas>();
        lRepas = mBD_repas.getlRepasDate(mDate);
        ButterKnife.bind(this, view);

        mTextDate.setOnClickListener(new View.OnClickListener() {
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
                                                   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                                                   mDate = dateFormat.format(cldr.getTime());

                                                   // On récupère les ressentis_tete qui sont à la date selectionnée :
                                                   lRepas = mBD_repas.getlRepasDate(mDate);

                                                   mRepasAdapter = new RepasAdapter(lRepas);
                                                   mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                                                   mRecyclerView.setAdapter(mRepasAdapter);
                                                   //mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(espace));


                                                   //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                                   DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                                   String dateDF = df_date.format(cldr.getTime());
                                                   mTextDate.setText(dateDF);
                                               }
                                           };

                                           new DatePickerDialog(getActivity(), date, cldr
                                                   .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                                   cldr.get(Calendar.DAY_OF_MONTH)).show();
                                       }
                                   }
        );

        buttonAjoutRepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajoutRepas = new Intent(getContext(), AjouterRepasActivity.class);
                startActivity(ajoutRepas);
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    //Configuration du recycler, adapter et layoutManager ensemble
    public void configureRecyclerView(String date){
        this.mDate = date;
        this.lRepas = new ArrayList<>(); //Remet à zéro la liste
        this.mAdapter = new RepasAdapter(this.lRepas);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void disposeWhenDestroy(){
        // if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    private void updateUI(ArrayList<Repas> lRepas){
        this.lRepas.addAll(lRepas);
        mAdapter.notifyDataSetChanged();
    }

}
