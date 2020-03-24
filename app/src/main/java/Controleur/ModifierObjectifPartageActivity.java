package Controleur;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.BD;
import Model.ObjectifPartage;
import Model.ObjectifPersonnel;


/**
 * Gère la motification des objectifs partagés.
 */
public class ModifierObjectifPartageActivity extends AppCompatActivity {

    BD bd;
    String datepicked_debut;
    String datepicked_fin;
    EditText editIntitule, editAvancement, editCommentaire, editPro;
    TextView editDateDebut, editDateFin;
    Button boutonAjouter;
    int id_obj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_un_objectif_partage);

        bd = new BD(this);
        id_obj = getIntent().getExtras().getInt("objectif_part");
        System.out.println("DANS LA MODIFICATION, L'ID RECUPERER EST " + id_obj);


        // On cast les variables EditText et Button

        editIntitule = (EditText) findViewById(R.id.editObjectif);
        editDateDebut = (TextView) findViewById(R.id.editDateDebut);
        editDateFin = (TextView) findViewById(R.id.editDateFin);
        editCommentaire = (EditText) findViewById(R.id.editCommentaires);
        editAvancement = (EditText) findViewById(R.id.editEchelle);
        editPro = (EditText) findViewById(R.id.editAvec);

        boutonAjouter = (Button) findViewById(R.id.but_contact_enregistrer);

        ObjectifPartage obj = bd.getObjectifPartage(id_obj);

        editIntitule.setText(obj.getIntitule());
        editDateDebut.setText(obj.getDateDebut());
        editDateFin.setText(obj.getDateFin());
        editAvancement.setText(String.valueOf(obj.getAccomplissement()));
        editCommentaire.setText(obj.getCommentaire());
        editPro.setText(obj.getProfessionnel());

        getDateFin();
        getDateDebut();
        modifierObjectifPerso();
    }


    /**
     * Méthode pour modifier un objectifs partagé déjà créé.
     */
    public void modifierObjectifPerso() {
        boutonAjouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String intitule = editIntitule.getText().toString();
                        String commentaire = editCommentaire.getText().toString();
                        int accomplissement = 0;
                        String pro = editPro.getText().toString();

                        if (datepicked_debut == null) {
                            datepicked_debut = editDateDebut.getText().toString();
                        }

                        if (datepicked_fin == null) {
                            datepicked_fin = editDateFin.getText().toString();
                        }

                        if (pro.isEmpty()){
                            Toast.makeText(ModifierObjectifPartageActivity.this, "Renseigner un professionnel s'il vous plaît", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            pro = editPro.getText().toString();
                        }

                        if (editAvancement.getText().toString().isEmpty()) {
                            Toast.makeText(ModifierObjectifPartageActivity.this, "Renseigner l'avancement s'il vous plaît", Toast.LENGTH_SHORT).show();
                        } else {
                            accomplissement = Integer.parseInt(editAvancement.getText().toString());

                        }


                        boolean isModified = bd.modifierObjPartage(id_obj, intitule, "partage", datepicked_debut, datepicked_fin, commentaire, accomplissement,pro);

                        if (isModified == true) {
                            Toast.makeText(ModifierObjectifPartageActivity.this, "Objectif modifié avec succès", Toast.LENGTH_SHORT).show();
                            openNewActivity(MenuBasActivity.class);
                        }
                        else
                            Toast.makeText(ModifierObjectifPartageActivity.this, "Il manque des informations", Toast.LENGTH_SHORT).show();
                    }
                }

        );

    }

    /**
     * Récupère la date de début sélectionnée avec un date picker et affiche la date dans le textview associé.
     * @return
     */
    public String getDateDebut() {
        editDateDebut.setOnClickListener(
                new View.OnClickListener() {
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
                                datepicked_debut = dateFormat.format(cldr.getTime());
                                System.out.println("BLABLAAAAAAAAAAAAAAAAAAAAA : " + datepicked_debut);

                                //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                String dateDF = df_date.format(cldr.getTime());
                                editDateDebut.setText(dateDF);

                            }
                        };

                        new DatePickerDialog(ModifierObjectifPartageActivity.this, date, cldr
                                .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                cldr.get(Calendar.DAY_OF_MONTH)).show();
                    }
                }

        );
        return datepicked_debut;
    }


    /**
     * Récupère la date de fin sélectionnée avec un date picker et affiche la date dans le textview associé.
     * @return
     */
    public String getDateFin() {
        editDateFin.setOnClickListener(
                new View.OnClickListener() {
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
                                datepicked_fin = dateFormat.format(cldr.getTime());

                                //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                String dateDF = df_date.format(cldr.getTime());
                                editDateFin.setText(dateDF);
                            }
                        };

                        new DatePickerDialog(ModifierObjectifPartageActivity.this, date, cldr
                                .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                cldr.get(Calendar.DAY_OF_MONTH)).show();
                    }
                }

        );
        return datepicked_fin;
    }

    /**
     * Ouvre une nouvelle activité à partir de l'activité courante.
     * @param nouvelle_classe
     */
    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(this, nouvelle_classe);
        startActivity(intent);
    }

}
