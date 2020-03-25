package com.example.eatit.Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import com.example.eatit.Model.RessentiActivite;

public class RessentiActiviteViewHolder extends RecyclerView.ViewHolder {

    private TextView activite;
    private TextView duree;
    private TextView difficulte;
    private TextView commentaire;

    public RessentiActiviteViewHolder(View itemView) {
        super(itemView);
        activite = (TextView) itemView.findViewById(R.id.activite);
        difficulte = (TextView) itemView.findViewById(R.id.difficulte);
        commentaire = (TextView) itemView.findViewById(R.id.commentaire);
        duree = (TextView) itemView.findViewById(R.id.duree);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(RessentiActivite pds) {
        activite.setText(pds.getActivite());
        difficulte.setText(String.valueOf(pds.getDifficulte()));
        duree.setText(String.valueOf(pds.getDifficulte()) + " minutes");
        commentaire.setText(pds.getCommentaire());
    }

}
