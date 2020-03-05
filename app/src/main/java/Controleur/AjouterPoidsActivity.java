package Controleur;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.BD_Poids;

public class AjouterPoidsActivity extends AppCompatActivity {


    String date_selectionnee;    //Nous sert à récupérer la date sélectionnée dans le calendrier
    BD_Poids bdp;    //Nous sert à appeler les fonctions qu'on trouve dans BD_Poids, notamment "insererPoids"

    // On crée des variables qui correspondent aux différents EditText + bouton du layout
    // "activity_ajouter_poids"

    EditText editPoids, editTaille, editDate, editTT, editMuscle, editGraisse;
    Button boutonAjouter;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_poids);
        bdp = new BD_Poids(this);


        // On cast les variables EditText et Button en recherchant les edittext et boutons grâce à leur ID

        editPoids = (EditText) findViewById(R.id.et_poids_poids);
        editTaille = (EditText) findViewById(R.id.et_poids_taille);
        editDate = (EditText) findViewById(R.id.et_poids_date);
        editDate.setInputType(InputType.TYPE_NULL);
        editTT = (EditText) findViewById(R.id.et_poids_tt);
        editMuscle = (EditText) findViewById(R.id.et_poids_muscle);
        editGraisse = (EditText) findViewById(R.id.et_poids_graisse);

        boutonAjouter = (Button) findViewById(R.id.but_poids_enregistrer);


        //On va ajouter un listener sur le champ qui sert à rentrer la date pour déclencher l'ouverture du calendrier
        editDate.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            //On crée un objet de type Calendar
                                            final Calendar cldr = Calendar.getInstance();

                                            //On définit le DatePickerDialog aka la fenêtre du calendrier sur lequel on va venir sélectionner la date
                                            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                                                @Override
                                                //Cette méthode elle nous sert à enregistrer la date sélectionnée
                                                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                                      int dayOfMonth) {
                                                    cldr.set(Calendar.YEAR, year);           //On enregistre l'année sélectionnée dans notre objet cldr de type Calendar
                                                    cldr.set(Calendar.MONTH, monthOfYear);   //On enregistre le mois sélectionné dans notre objet cldr de type Calendar
                                                    cldr.set(Calendar.DAY_OF_MONTH, dayOfMonth);    //On enregistre le jour sélectionné dans notre objet cldr de type Calendar

                                                    //L'idée est maintenant de récupérer la date qu'on vient d'enregistrer dans notre calendrier et de la
                                                    //formater, cad lui imposer une syntaxe. On va imposer deux syntaxe différente : une qui est destinée à
                                                    //être rentrée dans la BD avec un format de type "yyyy-MM-dd HH:mm:ss" et l'autre qu'on va afficher dans
                                                    //l'edittext de la date une fois qu'on aura cliqué sur la date du calendrier (pour que ce soit plus clair
                                                    //pour l'utilisateur.

                                                    //Formatage pour la BD.
                                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
                                                    date_selectionnee = dateFormat.format(cldr.getTime()); //cldr.getTime() envoie un objet de type Date. La date est formatée en String de la forme "yyyy-MM-dd HH:mm:ss".

                                                    //Formatage pour l'affichage de l'edittext qui s'appelle "editDate"
                                                    DateFormat df_date = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE); //DateFormat.LONG ça met la date sous la forme 28 février 2020.
                                                    String dateDF = df_date.format(cldr.getTime());
                                                    editDate.setText(dateDF);
                                                }

                                            };

                                            new DatePickerDialog(AjouterPoidsActivity.this, date, cldr
                                                    .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                                    cldr.get(Calendar.DAY_OF_MONTH)).show();


                                        }

                                    }
        );

        ajouterPoids();
    }


    public void ajouterPoids() {

        boutonAjouter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String date;
                double poids;
                double taille;
                double imc;
                double tt;
                double muscle;
                double graisse;

                date = date_selectionnee;

                if (editPoids.getText().toString().isEmpty()) {
                    poids = -1;
                }
                else {
                    poids = Double.parseDouble(editPoids.getText().toString());
                }

                if (editTaille.getText().toString().isEmpty()) {
                    taille = -1;
                }
                else {
                    taille = Double.parseDouble(editTaille.getText().toString());
                }

                if (editTT.getText().toString().isEmpty()) {
                    tt = -1;
                }
                else {
                    tt = Double.parseDouble(editTT.getText().toString());
                }

                if (editGraisse.getText().toString().isEmpty()) {
                    graisse = -1;
                }
                else {
                    graisse = Double.parseDouble(editGraisse.getText().toString());
                }

                if (editMuscle.getText().toString().isEmpty()) {
                    muscle = -1;
                }
                else {
                    muscle = Double.parseDouble(editGraisse.getText().toString());
                }

                if (taille == -1 || poids == -1) {
                    imc = -1;
                }
                else {
                    imc = poids / (Math.pow(taille, 2));
                }


                boolean isInserted = bdp.insererPoids(date, poids, taille, imc, tt, graisse, muscle);


                if (isInserted == true)
                    Toast.makeText(AjouterPoidsActivity.this, "Vos données ont été ajoutées", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AjouterPoidsActivity.this, "Vos données n'ont pas été ajoutées", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

