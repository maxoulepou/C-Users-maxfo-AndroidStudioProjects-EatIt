package com.example.eatit.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import com.example.eatit.Model.ObjectifPersonnel;
import com.example.eatit.Model.UnItemListener;

public class ObjectifPersoAdapter extends RecyclerView.Adapter<ObjectifPersoViewHolder> {

    ArrayList<ObjectifPersonnel> mes_obj;
UnItemListener item;

    public ObjectifPersoAdapter(ArrayList<ObjectifPersonnel> mes_ressentis, UnItemListener itemListener) {
        this.mes_obj = mes_ressentis;
        this.item = itemListener;
    }

    @NonNull
    @Override
    public ObjectifPersoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_objectifs_personnel, parent, false);
        return new ObjectifPersoViewHolder(view, item);
    }


    @Override
    public void onBindViewHolder(@NonNull ObjectifPersoViewHolder holder, int position) {
        holder.display(mes_obj.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_obj.size();
    }


}