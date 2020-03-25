package com.example.eatit.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import com.example.eatit.Model.ObjectifPartage;
import com.example.eatit.Model.UnItemListener;

public class ObjectifPartAdapter extends RecyclerView.Adapter<ObjectifPartViewHolder> {

    ArrayList<ObjectifPartage> mes_obj;
    UnItemListener item;


    public ObjectifPartAdapter(ArrayList<ObjectifPartage> mes_ressentis, UnItemListener itemListener) {
        this.mes_obj = mes_ressentis;
        this.item = itemListener;
    }

    @NonNull
    @Override
    public ObjectifPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_objectifs_partage, parent, false);
        return new ObjectifPartViewHolder(view, item);
    }


    @Override
    public void onBindViewHolder(@NonNull ObjectifPartViewHolder holder, int position) {
        holder.display(mes_obj.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_obj.size();
    }


}