package Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.ObjectifPartage;
import Model.ObjectifPersonnel;
import Model.UnItemListener;

public class ObjectifPartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
        if (pds.getAccomplissement() == 0) {
            avancement.setBackgroundResource(R.drawable.echellejaune0);
        }
        if (pds.getAccomplissement() == 1) {
            avancement.setBackgroundResource(R.drawable.echellejaune1);
        }
        if (pds.getAccomplissement() == 2) {
            avancement.setBackgroundResource(R.drawable.echellejaune2);
        }
        if (pds.getAccomplissement() == 3) {
            avancement.setBackgroundResource(R.drawable.echellejaune3);
        }
        if (pds.getAccomplissement() == 4) {
            avancement.setBackgroundResource(R.drawable.echellejaune4);
        }
        if (pds.getAccomplissement() == 5) {
            avancement.setBackgroundResource(R.drawable.echellejaune5);
        }
        if (pds.getAccomplissement() == 6) {
            avancement.setBackgroundResource(R.drawable.echellejaune6);
        }
        if (pds.getAccomplissement() == 7) {
            avancement.setBackgroundResource(R.drawable.echellejaune7);
        }
        if (pds.getAccomplissement() == 8) {
            avancement.setBackgroundResource(R.drawable.echellejaune8);
        }
        if (pds.getAccomplissement() == 9) {
            avancement.setBackgroundResource(R.drawable.echellejaune9);
        }
        if (pds.getAccomplissement() == 10) {
            avancement.setBackgroundResource(R.drawable.echellejaune10);
        }
        pro.setText(pds.getProfessionnel());
    }

    @Override
    public void onClick(View v) {
        item.clicSurUnItem(getAdapterPosition());

    }

}
