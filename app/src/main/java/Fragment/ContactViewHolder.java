package Fragment;

import android.view.View;
import android.widget.TextView;

import Model.Contact;
import Model.UnContactListener;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

//Il s'agit du modèle pour toute nos vues.

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView profession;
    private TextView prenom;
    private TextView nom;
    UnContactListener unContactListener;

    public ContactViewHolder(View itemView, UnContactListener unContactListener) {
        super(itemView);
        profession = (TextView) itemView.findViewById(R.id.tv_contact_profession);
        prenom = (TextView) itemView.findViewById(R.id.tv_contact_prenom);
        nom = (TextView) itemView.findViewById(R.id.tv_contact_nom);
        this.unContactListener = unContactListener;
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
        unContactListener.clicSurUnContact(getAdapterPosition());

    }
}