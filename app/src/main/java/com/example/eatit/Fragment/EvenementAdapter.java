package com.example.eatit.Fragment;

import com.example.eatit.Model.Evenement;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

public class EvenementAdapter extends RecyclerView.Adapter<EvenementViewHolder> {

    ArrayList<Evenement>mes_evenements;

    public EvenementAdapter(ArrayList<Evenement> mes_evenements) { this.mes_evenements = mes_evenements;}

    @NonNull
    @Override
    public EvenementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_evenement_sante, parent, false);
        return new EvenementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvenementViewHolder holder, int position) {
        holder.display(mes_evenements.get(position));
    }

    @Override
    public int getItemCount() { return mes_evenements.size(); }
}
