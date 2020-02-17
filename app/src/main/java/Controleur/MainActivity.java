package Controleur;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eatit.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    private Button mConnexionButton;
    private TextView mCreateCompte;
    private static final int ACCUEIL_ACTIVITY_REQUEST_CODE = 1;
    private static final int RC_SIGN_IN = 123;

    //Get coordinator layout
    @BindView(R.id.main_activity_coordinator_layout) CoordinatorLayout coordinatorLayout;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenue);

        mConnexionButton = (Button) findViewById(R.id.activity_bienvenue_button_connexion);
        mCreateCompte = (TextView) findViewById(R.id.activity_bienvenue_textview_createCompte);

        mConnexionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent ConnexionActivity = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(ConnexionActivity);
            }
        });

        mCreateCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CreationCompteActivity = new Intent(MainActivity.this, Controleur.CreationCompteActivity.class);
                startActivity(CreationCompteActivity);
            }
        });

    }

}
