package Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.ObjectifPersonnel;
import Model.Objectifs;
import Model.RessentiActivite;
import Model.UnItemListener;

public class ObjectifPersoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView intitule;
    private TextView dateDebut;
    private TextView dateFin;
    private TextView commentaire;
    private TextView avancement;
    UnItemListener item;

    public ObjectifPersoViewHolder(View itemView, UnItemListener item) {
        super(itemView);
        intitule = (TextView) itemView.findViewById(R.id.intitule);
        dateDebut = (TextView) itemView.findViewById(R.id.dateDebut);
        commentaire = (TextView) itemView.findViewById(R.id.commentaire);
        dateFin = (TextView) itemView.findViewById(R.id.datefinprevue);
        avancement = (TextView) itemView.findViewById(R.id.valeurlikert);
        this.item = item;
        itemView.setOnClickListener(this);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(ObjectifPersonnel pds) {
        intitule.setText(pds.getIntitule());
        dateDebut.setText(pds.getDateDebut());
        dateFin.setText(pds.getDateFin());
        commentaire.setText(String.valueOf(pds.getCommentaire()));
        if(pds.getAccomplissement()==0){
            avancement.setBackgroundResource(R.drawable.echellebleu0);
        }
        if(pds.getAccomplissement()==1){
            avancement.setBackgroundResource(R.drawable.echellebleu1);
        }
        if(pds.getAccomplissement()==2){
            avancement.setBackgroundResource(R.drawable.echellebleu2);
        }
        if(pds.getAccomplissement()==3){
            avancement.setBackgroundResource(R.drawable.echellebleu3);
        }
        if(pds.getAccomplissement()==4){
            avancement.setBackgroundResource(R.drawable.echellebleu4);
        }
        if(pds.getAccomplissement()==5){
            avancement.setBackgroundResource(R.drawable.echellebleu5);
        }
        if(pds.getAccomplissement()==6){
            avancement.setBackgroundResource(R.drawable.echellebleu6);
        }
        if(pds.getAccomplissement()==7){
            avancement.setBackgroundResource(R.drawable.echellebleu7);
        }
        if(pds.getAccomplissement()==8){
            avancement.setBackgroundResource(R.drawable.echellebleu8);
        }
        if(pds.getAccomplissement()==9){
            avancement.setBackgroundResource(R.drawable.echellebleu9);
        }
        if(pds.getAccomplissement()==10){
            avancement.setBackgroundResource(R.drawable.echellebleu10);
        }
    }

    @Override
    public void onClick(View v) {
        item.clicSurUnItem(getAdapterPosition());

    }

}
