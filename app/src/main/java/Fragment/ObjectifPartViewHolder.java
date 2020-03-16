package Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.ObjectifPartage;
import Model.ObjectifPersonnel;
import Model.UnItemListener;

public class ObjectifPartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView intitule;
    private TextView dateDebut;
    private TextView dateFin;
    private TextView commentaire;
    private TextView avancement;
    private TextView pro;
    UnItemListener item;

    public ObjectifPartViewHolder(View itemView, UnItemListener item) {
        super(itemView);
        intitule = (TextView) itemView.findViewById(R.id.intitule);
        dateDebut = (TextView) itemView.findViewById(R.id.dateDebut);
        commentaire = (TextView) itemView.findViewById(R.id.commentaire);
        dateFin = (TextView) itemView.findViewById(R.id.datefinprevue);
        avancement = (TextView) itemView.findViewById(R.id.valeurlikert);
        pro = (TextView) itemView.findViewById(R.id.professionnel);
        this.item = item;
        itemView.setOnClickListener(this);
    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(ObjectifPartage pds) {
        intitule.setText(pds.getIntitule());
        dateDebut.setText(pds.getDateDebut());
        dateFin.setText(pds.getDateFin());
        commentaire.setText(pds.getCommentaire());
        avancement.setText(String.valueOf(pds.getAccomplissement()));
        pro.setText(pds.getProfessionnel());
    }

    @Override
    public void onClick(View v) {
        item.clicSurUnItem(getAdapterPosition());

    }

}
