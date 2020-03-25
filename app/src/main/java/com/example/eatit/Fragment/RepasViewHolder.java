package com.example.eatit.Fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eatit.R;
import com.example.eatit.Model.Repas;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepasViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_texte_typeRepas) TextView typeRepas;
    @BindView(R.id.fragment_heureRepas) TextView heureRepas;
    @BindView(R.id.fragment_NivFaim) TextView NivFaim;
    @BindView(R.id.fragment_NivEnvie) TextView NivEnvie;
    @BindView(R.id.fragment_NivSatiete) TextView NivSatiete;
    @BindView(R.id.fragment_contexterepas) TextView Contexte;
    @BindView(R.id.fragment_dureeRepas) TextView duree;
    @BindView(R.id.fragment_commentaireRepas) TextView commentaire;

    public RepasViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void update(Repas repas){
        typeRepas.setText(repas.getTypeRepas() + " : ");
        typeRepas.setAllCaps(true);
        heureRepas.setText(repas.getHeure());
        NivFaim.setText(repas.getNiveauFaim());
        NivEnvie.setText(repas.getNiveauEnvie());
        NivSatiete.setText(repas.getNiveauSatiete());
        Contexte.setText(repas.getContexteRepas());
        duree.setText(repas.getDuree() + " minutes");
        commentaire.setText(repas.getDescription());
    }
}
