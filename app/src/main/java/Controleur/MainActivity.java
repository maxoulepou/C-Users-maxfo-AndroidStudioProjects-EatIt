package Controleur;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.eatit.R;

public class MainActivity extends AppCompatActivity {


    private Button mConnexionButton;
    private TextView mCreateCompte;
    private static final int ACCUEIL_ACTIVITY_REQUEST_CODE = 1;
    private static final int RC_SIGN_IN = 123;

    //Get coordinator layout
   // @BindView(R.id.main_activity_coordinator_layout) CoordinatorLayout coordinatorLayout;

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
                Intent ConnexionActivity = new Intent(MainActivity.this, Controleur.ConnexionActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_haut, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Mes contacts selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Exporter mes données selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "F.A.Q selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
