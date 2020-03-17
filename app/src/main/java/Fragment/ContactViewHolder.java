package Fragment;

import android.view.View;
import android.widget.TextView;

import Model.Contact;
import Model.UnItemListener;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

//Il s'agit du modèle pour toute nos vues.

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView profession;
    private TextView prenom;
    private TextView nom;
    UnItemListener unItemListener;

    public ContactViewHolder(View itemView, UnItemListener unItemListener) {
        super(itemView);
        profession = (TextView) itemView.findViewById(R.id.tv_contact_profession);
        prenom = (TextView) itemView.findViewById(R.id.tv_contact_prenom);
        nom = (TextView) itemView.findViewById(R.id.tv_contact_nom);
        this.unItemListener = unItemListener;
        itemView.setOnClickListener(this);

    }

    //A chaque recyclage de cellule elle est appelée.
    public void display(Contact pds) {

        profession.setText(pds.getProfession());
        prenom.setText(pds.getPrenom());
        nom.setText(pds.getNom());
    }


    @Override
    public void onClick(View v) {
        unItemListener.clicSurUnItem(getAdapterPosition());

    }
}