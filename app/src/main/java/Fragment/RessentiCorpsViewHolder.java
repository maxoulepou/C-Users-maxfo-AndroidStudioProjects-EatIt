package Fragment;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.RessentiCorps;

//Il s'agit du modèle pour toute nos vues.

public class RessentiCorpsViewHolder extends RecyclerView.ViewHolder {

    private TextView sensations;
    private TextView bienetre;
    private TextView commentaire;

    public RessentiCorpsViewHolder(View itemView) {
        super(itemView);
        sensations = (TextView) itemView.findViewById(R.id.liste_sentations);
        bienetre = (TextView) itemView.findViewById(R.id.bienetre);
        commentaire = (TextView) itemView.findViewById(R.id.commentaire);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(RessentiCorps pds) {
        sensations.setText(pds.getSensations());
        bienetre.setText(String.valueOf(pds.getNiveau_bienetre()));
        commentaire.setText(pds.getCommentaire());
    }

}