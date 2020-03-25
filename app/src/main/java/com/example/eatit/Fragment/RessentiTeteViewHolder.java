package com.example.eatit.Fragment;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import com.example.eatit.Model.RessentiTete;

//Il s'agit du modèle pour toute nos vues.

public class RessentiTeteViewHolder extends RecyclerView.ViewHolder {

    private TextView emotions;
    private TextView commentaire;

    public RessentiTeteViewHolder(View itemView) {
        super(itemView);
        emotions = (TextView) itemView.findViewById(R.id.tv_emotion);
        commentaire = (TextView) itemView.findViewById(R.id.tv_commentaire);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(RessentiTete pds) {
        emotions.setText(pds.getEmotions());
        commentaire.setText(pds.getCommentaire());
    }

}