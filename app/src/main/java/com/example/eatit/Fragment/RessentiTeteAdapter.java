package com.example.eatit.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import com.example.eatit.Model.RessentiTete;

public class RessentiTeteAdapter extends RecyclerView.Adapter<RessentiTeteViewHolder> {

    ArrayList<RessentiTete> mes_rt;


    public RessentiTeteAdapter(ArrayList<RessentiTete> mes_contacts) {
        this.mes_rt = mes_contacts;
    }

    @NonNull
    @Override
    public RessentiTeteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_ressenti_tete, parent, false);
        return new RessentiTeteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RessentiTeteViewHolder holder, int position) {
        holder.display(mes_rt.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_rt.size();
    }


}
