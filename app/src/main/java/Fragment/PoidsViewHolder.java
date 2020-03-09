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
    private TextView muscle;
    private TextView graisse;
    private static DecimalFormat df2 = new DecimalFormat("#.##");



    public PoidsViewHolder(View itemView) {
        super(itemView);
        poids = (TextView) itemView.findViewById(R.id.tv_valeurpoids);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        imc = (TextView) itemView.findViewById(R.id.tv_valeurimc);
        muscle = (TextView) itemView.findViewById(R.id.tv_valeurm);
        graisse = (TextView) itemView.findViewById(R.id.tv_valeurg);


    }

    //A chaque recyclage de cellule elle est appelée.
    void display(Poids pds){

        poids.setText(String.valueOf(pds.getPoids()));
        date.setText(pds.getDate());
        imc.setText(String.valueOf(df2.format(pds.getImc())));
        muscle.setText(String.valueOf(df2.format(pds.getMuscle())));
        graisse.setText(String.valueOf(df2.format(pds.getGraisse())));
    }
}