package Controleur;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eatit.R;
import Model.Repas;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepasViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_texte_typeRepas) TextView typeRepas;
    @BindView(R.id.fragment_heureRepas) TextView heureRepas;
    @BindView(R.id.fragment_NivFaim) TextView NivFaim;
    @BindView(R.id.fragment_dureeRepas) TextView duree;
    @BindView(R.id.fragment_commentaireRepas) TextView commentaire;

    public RepasViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void update(Repas repas){
        typeRepas.setText(repas.getTypeRepas());
        heureRepas.setText(repas.getHeure());
        NivFaim.setText(repas.getNiveauFaim());
        duree.setText(repas.getDuree());
        commentaire.setText(repas.getDescription());
    }
}
