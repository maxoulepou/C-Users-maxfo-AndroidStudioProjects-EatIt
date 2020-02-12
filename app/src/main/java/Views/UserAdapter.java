package Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.List;
import Model.Contact;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<Contact> lContact;

    public UserAdapter(List<Contact> lContact){
        this.lContact = lContact;
    }

    // Méthode pour créer un ViewHolder représentant chaque ligne du RecyclerView
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_mes_contacts_item, parent, false);
        return new UserViewHolder(view);
    }

    // Méthode pour mettre à jour l'apparence de chaque ligne
    public void onBindViewHolder(UserViewHolder viewHolder, int i){
        viewHolder.updateWithContact(this.lContact.get(i));
    }

    public int getItemCount(){
        return this.lContact.size();
    }
}
