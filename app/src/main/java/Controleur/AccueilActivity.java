package Controleur;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.eatit.R;
import android.widget.TextView;

public class AccueilActivity extends AppCompatActivity {

    private TextView infoUtilisateur;
    // private DataBase bd;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);

         //infoUtilisateur = (TextView) findViewById(R.id.infoUtilisateurs);
/**     bd = new DataBase(this);

 bd.nouveauProfil("Anne","Onymous","patient","annie","mdp");
 bd.nouveauProfil("Pierre","Caillou","Dieteticien","pierro","mdp");

 bd.close();
 **/
    }
}
