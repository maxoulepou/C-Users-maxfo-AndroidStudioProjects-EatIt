package com.example.eatit.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eatit.Model.Contact;
import com.example.eatit.Model.UnItemListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

/**
 * Gère la RecyclerView gérant la liste des contacts.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    ArrayList<Contact> mes_contacts;
    private UnItemListener monContactListener;


    public ContactAdapter(ArrayList<Contact> mes_contacts, UnItemListener unItemListener) {
        this.mes_contacts = mes_contacts;
        this.monContactListener = unItemListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
