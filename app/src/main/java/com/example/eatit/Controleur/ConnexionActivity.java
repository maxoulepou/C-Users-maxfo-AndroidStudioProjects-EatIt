package com.example.eatit.Controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.eatit.Model.BD;

/**
 * Activité qui gère la connexion.
 */
public class ConnexionActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button mConnexionButton;
    private EditText mTextEmail, mTextPassword;
    private TextView mCreateCompte;
    private BD mBd;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mBd = new BD(this);
        setContentView(R.layout.activity_connexion);
        mConnexionButton = (Button) findViewById(R.id.activity_connexion_button_connexion);
        mTextEmail = (EditText) findViewById(R.id.editText_email_creationCompte);
        mTextPassword = (EditText) findViewById(R.id.editText_Password);
        mCreateCompte = (TextView) findViewById(R.id.activity_connexion_textview_createCompte);

        mConnexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mAuth.signInWithEmailAndPassword(mTextEmail.getText().toString(), mTextPassword.getText().toString());
                if (mBd.seConnecter(mTextEmail.getText().toString(), mTextPassword.getText().toString()) == true){
                    mBd.estConnecte(mTextEmail.getText().toString());
                    Intent MenuBas = new Intent(ConnexionActivity.this, MenuBasActivity.class);
                    startActivity(MenuBas);
                }
                else {
                    Toast.makeText(ConnexionActivity.this, "Votre identifiants sont erronés.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCreateCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MenuBas = new Intent(ConnexionActivity.this, CreationCompteActivity.class);
                startActivity(MenuBas);
            }
        });

    }
/**
    @Override
    public void onStart(){
        super.onStart();
        //on vérifie que l'utilisateur ne s'est pas déjà connecté
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        Intent ConnexionActivity = new Intent(ConnexionActivity.this, MenuBasActivity.class);
        startActivity(ConnexionActivity);
    } **/

    public void  updateUI(FirebaseUser account){
        if(account != null){
            Toast.makeText(this,"You Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MenuBasActivity.class));
        }else {
            Toast.makeText(this,"You must signed in", Toast.LENGTH_LONG).show();
        }
    }
}
