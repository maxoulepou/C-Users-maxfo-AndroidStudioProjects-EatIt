package Contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

public class AfficherUnContactActivity extends AppCompatActivity {

    EditText prenom, nom, profession, email, telephone, adresse;
    Contact contact_selectionne;
    Button bouton_modifier;
    BD_Contact bdc;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_un_contact);

        bdc = new BD_Contact(this);

        contact_selectionne = getIntent().getParcelableExtra("contact");

        prenom = (EditText) findViewById(R.id.et_contact_prenom2);
        nom = (EditText) findViewById(R.id.et_contact_nom2);
        profession = (EditText) findViewById(R.id.et_contact_profession2);
        email = (EditText) findViewById(R.id.et_contact_email2);
        telephone = (EditText) findViewById(R.id.et_contact_telephone2);
        adresse = (EditText) findViewById(R.id.et_contact_adresse2);

        bouton_modifier = (Button) findViewById(R.id.but_contact_modifier);

        tv = (TextView) findViewById(R.id.tv_contact_supprimer);

        prenom.setText(contact_selectionne.getPrenom());
        nom.setText(contact_selectionne.getNom());
        profession.setText(contact_selectionne.getProfession());
        email.setText(contact_selectionne.getEmail());
        telephone.setText(contact_selectionne.getNumTel());
        adresse.setText(contact_selectionne.getAdresse());

        bouton_modifier.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isModified = bdc.modifierContact(contact_selectionne.getIdContact(),
                                prenom.getText().toString(),
                                nom.getText().toString(),
                                profession.getText().toString(),
                                email.getText().toString(),
                                telephone.getText().toString(),
                                adresse.getText().toString());

                        if (isModified == true) {
                            Toast.makeText(AfficherUnContactActivity.this, "Contact modifié", Toast.LENGTH_SHORT).show();
                            openNewActivity(AfficherListeContactsActivity.class);
                        } else {
                            Toast.makeText(AfficherUnContactActivity.this, "Contact pas modifié", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
        );

        tv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isDeleted = bdc.supprimerContact(contact_selectionne.getIdContact());

                        if (isDeleted == true) {
                            Toast.makeText(AfficherUnContactActivity.this, "Contact supprimé", Toast.LENGTH_SHORT).show();
                            openNewActivity(AfficherListeContactsActivity.class);
                        } else {
                            Toast.makeText(AfficherUnContactActivity.this, "Contact pas supprimé", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void openNewActivity(Class classe) {
        Intent intent = new Intent(this, classe);
        startActivity(intent);
    }
}
