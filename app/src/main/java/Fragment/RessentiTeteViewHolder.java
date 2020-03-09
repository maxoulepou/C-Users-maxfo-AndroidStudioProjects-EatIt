package Fragment;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.RessentiTete;

//Il s'agit du modèle pour toute nos vues.

public class RessentiTeteViewHolder extends RecyclerView.ViewHolder {

    private TextView date;
    private TextView emotions;
    private TextView commentaire;

    public RessentiTeteViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        emotions = (TextView) itemView.findViewById(R.id.tv_emotion);
        commentaire = (TextView) itemView.findViewById(R.id.tv_commentaire);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(RessentiTete pds) {

        date.setText(pds.getDate());
        emotions.setText(pds.getEmotions());
        commentaire.setText(pds.getCommentaire());
    }

}