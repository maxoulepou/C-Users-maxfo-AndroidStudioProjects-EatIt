package Views;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import Model.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_contact_recycler_view) TextView mTextView;

    public ContactViewHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    // Methode a modifier plus tard pour l'affichage des informations des pro
    public void updateWithContact(Contact contact){
        //this.mTextView.setText(contact.getLogin());
    }
}
