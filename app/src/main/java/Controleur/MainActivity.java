package Controleur;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eatit.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextBienvenu;
    private Button mConnexionButton;
    private static final int ACCUEIL_ACTIVITY_REQUEST_CODE = 1;
    private static final int RC_SIGN_IN = 123;

    //Get coordinator layout
    @BindView(R.id.main_activity_coordinator_layout) CoordinatorLayout coordinatorLayout;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.handleResponseAfterSignIn(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextBienvenu = (TextView) findViewById(R.id.activity_main_text_bienvenu);
        mConnexionButton = (Button) findViewById(R.id.activity_main_connexion_btn);

        mConnexionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Intent AccueilActivity = new Intent(MainActivity.this, AccueuilActivity.class);
                //startActivity(AccueilActivity);
                startSignInActivity();
            }
        });
    }

    private void startSignInActivity(){
        startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setTheme(R.style.LoginTheme)
                    .setAvailableProviders(Arrays.asList( new AuthUI
                                                            .IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                    .setIsSmartLockEnabled(false, true)
                    //.setLogo(R.drawable.ic_logo_auth)
                    .build(), RC_SIGN_IN
        );
    }

    private void showSnackBar(CoordinatorLayout coordinatorLayout, String message){
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    //methode qui gère la réponse suite au SIgnInActivity
    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data){
        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK){ //Connexion réussi
                showSnackBar(this.coordinatorLayout, "Connexion réussi"); //getString(R.string.connection_succed)
            }
            else { //Erreur lors de la connexion
                if (response == null){
                    showSnackBar(this.coordinatorLayout, "Identification annulé"); //getString(R.string.error_authentication_canceled)
                } else if (response.getErrorCode() == ErrorCodes.NO_NETWORK){
                    showSnackBar(this.coordinatorLayout, "Identifiaction impossible: pas d'accès à internet"); //getString(R.string.error_no_internet)
                } else if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR){
                    showSnackBar(this.coordinatorLayout, "Identification impossible: message d'erreur inconnu"); //getString(R.string.error_unknow_error)
                }

            }
        }
    }

}
