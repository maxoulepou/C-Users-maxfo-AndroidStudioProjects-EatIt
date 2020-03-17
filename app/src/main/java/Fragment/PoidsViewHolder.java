package Fragment;

import android.view.View;
import android.widget.TextView;
import Model.Poids;

import androidx.recyclerview.widget.RecyclerView;


import com.example.eatit.R;

import java.text.DecimalFormat;

//Il s'agit du modèle pour toute nos vues.
public class PoidsViewHolder extends RecyclerView.ViewHolder {

    private TextView poids;
    private TextView date;
    private TextView imc;
    private TextView taille;
    private TextView muscle;
    private TextView graisse;
    private TextView tt;
    private static DecimalFormat df2 = new DecimalFormat("#.##");



    public PoidsViewHolder(View itemView) {
        super(itemView);
        poids = (TextView) itemView.findViewById(R.id.tv_valeurpoids);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        taille = (TextView) itemView.findViewById(R.id.tv_valeurtaille);
        imc = (TextView) itemView.findViewById(R.id.tv_valeurimc);
        muscle = (TextView) itemView.findViewById(R.id.tv_valeurm);
        graisse = (TextView) itemView.findViewById(R.id.tv_valeurg);
        tt = (TextView) itemView.findViewById(R.id.tv_valeurtt);


    }

    //A chaque recyclage de cellule elle est appelée.
    void display(Poids pds){

        poids.setText(String.valueOf(pds.getPoids()));
        taille.setText(String.valueOf(pds.getTaille()));
        date.setText(pds.getDate());
        imc.setText(String.valueOf(df2.format(pds.getImc())));
        if(pds.getGraisse()==0){
            graisse.setText("---");
        }
        else {
            graisse.setText(String.valueOf(df2.format(pds.getGraisse())));
        }

        if(pds.getMuscle()==0){
            muscle.setText("---");
        }
        else {
            muscle.setText(String.valueOf(df2.format(pds.getMuscle())));
        }
        if(pds.getTt()==0){
            tt.setText("---");
        }
        else {
            tt.setText(String.valueOf(df2.format(pds.getTt())));
        }
    }
}