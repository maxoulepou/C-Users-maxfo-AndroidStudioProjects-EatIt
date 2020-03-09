package Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Model.Contact;
import Model.UnContactListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    ArrayList<Contact> mes_contacts;
    private UnContactListener monContactListener;


    public ContactAdapter(ArrayList<Contact> mes_contacts, UnContactListener unContactListener) {
        this.mes_contacts = mes_contacts;
        this.monContactListener = unContactListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_contact, parent, false);
        return new ContactViewHolder(view, monContactListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.display(mes_contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_contacts.size();
    }


}
