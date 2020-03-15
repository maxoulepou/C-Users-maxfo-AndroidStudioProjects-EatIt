package Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.ObjectifPersonnel;
import Model.Objectifs;
import Model.RessentiActivite;

public class ObjectifPersoViewHolder extends RecyclerView.ViewHolder {

    private TextView intitule;
    private TextView dateDebut;
    private TextView dateFin;
    private TextView commentaire;
    private TextView avancement;

    public ObjectifPersoViewHolder(View itemView) {
        super(itemView);
        intitule = (TextView) itemView.findViewById(R.id.intitule);
        dateDebut = (TextView) itemView.findViewById(R.id.dateDebut);
        commentaire = (TextView) itemView.findViewById(R.id.commentaire);
        dateFin = (TextView) itemView.findViewById(R.id.datefinprevue);
        avancement = (TextView) itemView.findViewById(R.id.valeurlikert);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(ObjectifPersonnel pds) {
        intitule.setText(pds.getIntitule());
        dateDebut.setText(pds.getDateDebut());
        dateFin.setText(pds.getDateFin());
        commentaire.setText(String.valueOf(pds.getCommentaire()));
        avancement.setText(String.valueOf(pds.getAccomplissement()));
    }


}
