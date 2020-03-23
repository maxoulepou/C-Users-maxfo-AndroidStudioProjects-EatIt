package Controleur;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eatit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.BD_Evenement;
import androidx.appcompat.app.AppCompatActivity;

public class AjouterEvntActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String date_selectionnee;
    BD_Evenement bde;

    EditText editEvenement, editCommentaire;
    TextView editDate;
    Button boutonAjouter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_evenement_sante);
        bde = new BD_Evenement(this);
        editEvenement = (EditText) findViewById(R.id.evnt_sante);
        editCommentaire = (EditText) findViewById(R.id.commentaires);
        editDate = (TextView) findViewById(R.id.date);
        editDate.setInputType(InputType.TYPE_NULL);
        boutonAjouter = (Button) findViewById(R.id.but_contact_enregistrer);

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

                                            new DatePickerDialog(AjouterEvntActivity.this, date, cldr
                                                    .get(Calendar.YEAR), cldr.get(Calendar.MONTH),
                                                    cldr.get(Calendar.DAY_OF_MONTH)).show();


                                        }

                                    }
        );

        ajouterEvenement();
    }

    private void ajouterEvenement() {
        boutonAjouter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String date;
                String evenement;
                String commentaire;

                date = date_selectionnee;
                evenement = editEvenement.getText().toString();
                commentaire = editCommentaire.getText().toString();

                boolean isInserted = bde.insererEvenement(date, evenement, commentaire);

                if (isInserted == true) {
                    Toast.makeText(AjouterEvntActivity.this, "Vos données ont été ajoutées", Toast.LENGTH_SHORT).show();
                    System.out.println("HELLO WORLD");
                } else {
                    Toast.makeText(AjouterEvntActivity.this, "Vos données n'ont pas été ajoutées", Toast.LENGTH_SHORT).show();
                    System.out.println("NOT WORLD");
                }
            }
            });
    }

    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(this, nouvelle_classe);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
