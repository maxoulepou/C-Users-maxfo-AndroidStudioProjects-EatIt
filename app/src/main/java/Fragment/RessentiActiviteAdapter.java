package Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import Model.RessentiActivite;
import Model.RessentiCorps;

public class RessentiActiviteAdapter extends RecyclerView.Adapter<RessentiActiviteViewHolder> {

    ArrayList<RessentiActivite> mes_ra;


    public RessentiActiviteAdapter(ArrayList<RessentiActivite> mes_ressentis) {
        this.mes_ra = mes_ressentis;
    }

    @NonNull
    @Override
    public RessentiActiviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_ressenti_activite, parent, false);
        return new RessentiActiviteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RessentiActiviteViewHolder holder, int position) {
        holder.display(mes_ra.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_ra.size();
    }


}