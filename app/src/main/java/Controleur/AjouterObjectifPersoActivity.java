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

/**
 * Activité permettant d'ajouter un nouvel objectif personnel.
 */
public class AjouterObjectifPersoActivity extends AppCompatActivity {

    BD bd;
    String datepicked_debut;
    String datepicked_fin;

    EditText editIntitule, editAvancement, editCommentaire;
    TextView editDateDebut, editDateFin;
    Button boutonAjouter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_un_objectif_perso);
        bd = new BD(this);

        // On cast les variables EditText et Button

        editIntitule = (EditText) findViewById(R.id.editObjectif);
        editDateDebut = (TextView) findViewById(R.id.editDateDebut);
        editDateFin = (TextView) findViewById(R.id.editDateFin);
        editCommentaire = (EditText) findViewById(R.id.editCommentaires);
        boutonAjouter = (Button) findViewById(R.id.but_contact_enregistrer);

        getDateFin();
        getDateDebut();
        ajouterObjPerso();

    }

    /**
     * Méthode permettant d'ajouter un nouvel objectif personnel dans la base de données.
     */
    public void ajouterObjPerso() {
        boutonAjouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String intitule = editIntitule.getText().toString();
                        String commentaire = editCommentaire.getText().toString();

                        boolean isInserted = bd.addObjectifs(intitule, "personnel", datepicked_debut, datepicked_fin, commentaire, 0, "");

                        if (isInserted == true) {
                            Toast.makeText(AjouterObjectifPersoActivity.this, "Objectif ajouté", Toast.LENGTH_SHORT).show();
                            openNewActivity(MenuBasActivity.class);
                        }
                        else
                            Toast.makeText(AjouterObjectifPersoActivity.this, "Tous les champs sont obligatoires à l'exception du commentaire", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        //openNewActivity(AfficherListeContactsActivity.class);

    }

    /**
     * Récupère la date de début sélectionnée avec un date picker et affiche la date dans le textview associé.
     * @return un String contenant la date sélectionnée avec le date picker.
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

                                //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                String dateDF = df_date.format(cldr.getTime());
                                editDateDebut.setText(dateDF);
                            }
                        };

                        new DatePickerDialog(AjouterObjectifPersoActivity.this, date, cldr
                                .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                cldr.get(Calendar.DAY_OF_MONTH)).show();
                    }
                }

        );
        return datepicked_debut;
    }

    /**
     * Récupère la date de fin sélectionnée avec un date picker et affiche la date dans le textview associé.
     * @return un String contenant la date sélectionnée avec le date picker.
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

                                //On formate pour l'ajout dans la BD.
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                                datepicked_fin = dateFormat.format(cldr.getTime());

                                //Formatage pour l'affichage de l'edittext qui s'appelle "et_date"
                                DateFormat df_date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                String dateDF = df_date.format(cldr.getTime());
                                editDateFin.setText(dateDF);
                            }
                        };

                        new DatePickerDialog(AjouterObjectifPersoActivity.this, date, cldr
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

