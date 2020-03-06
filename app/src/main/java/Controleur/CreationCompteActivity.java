package Controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.MenuBas;
import com.example.eatit.R;

public class CreationCompteActivity extends AppCompatActivity {

    private Button mButtonCreationCompte;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        mButtonCreationCompte = (Button) findViewById(R.id.activity_creation_button_creatCompte);

        mButtonCreationCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ContactActivity = new Intent(CreationCompteActivity.this, MenuBas.class);
                startActivity(ContactActivity);
            }
        });
    }
}
