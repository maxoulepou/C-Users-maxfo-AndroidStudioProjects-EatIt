package Controleur;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.BD_Contact;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Activité qui permet d'ajouter un contact à la base de données.
 */
public class AjouterContactActivity extends AppCompatActivity {

    BD_Contact bdc;

    // On crée des variables qui correspondent aux différents EditText + bouton du layout
    // "activity_ajouter_contact"

    EditText editPrenom, editNom, editProfession, editEmail, editTelephone, editAdresse;
    Button boutonAjouter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);
        bdc = new BD_Contact(this);

        // On cast les variables EditText et Button

        editPrenom = (EditText) findViewById(R.id.et_contact_prenom);
        editNom = (EditText) findViewById(R.id.et_contact_nom);
        editProfession = (EditText) findViewById(R.id.et_contact_profession);
        editEmail = (EditText) findViewById(R.id.et_contact_email);
        editTelephone = (EditText) findViewById(R.id.et_contact_telephone);
        editAdresse = (EditText) findViewById(R.id.et_contact_adresse);
        boutonAjouter = (Button) findViewById(R.id.but_contact_enregistrer);

        ajouterContact();

    }

    /**
     * Méthode qui permet d'ajouter un contact à la base de données.
     */
    public void ajouterContact() {
        boutonAjouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Pattern pattern1 = Pattern.compile( "^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+");

                        Matcher matcher1 = pattern1.matcher(editEmail.getText().toString());

                        if (matcher1.matches()) {
                            boolean isInserted = bdc.insererContact(editPrenom.getText().toString(),
                                    editNom.getText().toString(),
                                    editProfession.getText().toString(),
                                    editEmail.getText().toString(),
                                    editTelephone.getText().toString(),
                                    editAdresse.getText().toString());
                            if (isInserted == true) {
                                Toast.makeText(AjouterContactActivity.this, "Contact ajouté", Toast.LENGTH_SHORT).show();
                                openNewActivity(AfficherListeContactsActivity.class);
                            }
                        } else {
                            Toast.makeText(AjouterContactActivity.this, "Veuillez renseigner une adresse mail valide.", Toast.LENGTH_SHORT).show();
                        }


                    }

                }

        );

    }

    /**
     * Ouvre l'activité nouvelle_classe à partir de l'activité courante.
     * @param nouvelle_classe
     */
    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(this, nouvelle_classe);
        startActivity(intent);
    }

}
