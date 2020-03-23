package Fragment;

import android.view.View;
import android.widget.TextView;

import com.example.eatit.R;

import Model.Evenement;
import androidx.recyclerview.widget.RecyclerView;

public class EvenementViewHolder extends RecyclerView.ViewHolder {

    private TextView evenement;
    private TextView date;
    private TextView commentaire;

    public EvenementViewHolder(View itemView) {
        super(itemView);
        evenement = (TextView) itemView.findViewById(R.id.tv_evenement);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        commentaire = (TextView) itemView.findViewById(R.id.tv_commentaire);
    }

    public void display(Evenement evnt) {
        evenement.setText(evnt.getEvenement());
        date.setText(evnt.getDate());
        commentaire.setText(evnt.getCommentaire());
    }
}
