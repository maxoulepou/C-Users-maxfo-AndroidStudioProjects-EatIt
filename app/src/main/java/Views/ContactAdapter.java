package Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.List;
import Model.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private List<Contact> lContact;

    public ContactAdapter(List<Contact> lContact){
        this.lContact = lContact;
    }

    // Méthode pour créer un ViewHolder représentant chaque ligne du RecyclerView
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_mes_contacts_item, parent, false);
        return new ContactViewHolder(view);
    }

    // Méthode pour mettre à jour l'apparence de chaque ligne
    public void onBindViewHolder(ContactViewHolder viewHolder, int i){
        viewHolder.updateWithContact(this.lContact.get(i));
    }

    public int getItemCount(){
        return this.lContact.size();
    }
}
