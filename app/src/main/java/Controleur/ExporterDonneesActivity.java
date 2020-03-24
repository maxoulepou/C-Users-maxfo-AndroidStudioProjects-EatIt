package Controleur;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eatit.R;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Activité gérant l'export des données.
 */
public class ExporterDonneesActivity extends AppCompatActivity {

    Button exporter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exporter_mes_donnees);
        Toast.makeText(ExporterDonneesActivity.this, "Cette foncionnalité n'existe pas encore", Toast.LENGTH_SHORT).show();

        exporter = (Button) findViewById(R.id.bouton_exporter); //my button with ID btnexport

        exporter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { //main code begins here
                Toast.makeText(ExporterDonneesActivity.this, "Cette foncionnalité n'existe pas encore", Toast.LENGTH_SHORT).show();

                File sd = Environment.getExternalStorageDirectory();
                File data = Environment.getDataDirectory();
                FileChannel source=null;
                FileChannel destination=null;
                String currentDBPath = "/data/"+ "com.example.eatie" +"/databases/"+"dataBase.db";
                String backupDBPath = "dataBase.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);
                try {
                    source = new FileInputStream(currentDB).getChannel();
                    destination = new FileOutputStream(backupDB).getChannel();
                    destination.transferFrom(source, 0, source.size());
                    source.close();
                    destination.close();
                    Toast.makeText(ExporterDonneesActivity.this, "Fichier DB exporte", Toast.LENGTH_SHORT).show();
                } catch(IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
