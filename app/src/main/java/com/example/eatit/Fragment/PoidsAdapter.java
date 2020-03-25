package com.example.eatit.Fragment;

import com.example.eatit.Model.Poids;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

public class PoidsAdapter extends RecyclerView.Adapter<PoidsViewHolder> {

    ArrayList<Poids> mes_poids;


    public PoidsAdapter(ArrayList<Poids> mes_poids) {
        this.mes_poids = mes_poids;
    }

    @NonNull
    @Override
    public PoidsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_poids, parent, false);
        return new PoidsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PoidsViewHolder holder, int position) {
        holder.display(mes_poids.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_poids.size();
    }
}
