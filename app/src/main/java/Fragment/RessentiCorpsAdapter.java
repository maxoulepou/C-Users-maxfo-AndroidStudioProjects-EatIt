package Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import Model.RessentiCorps;

public class RessentiCorpsAdapter extends RecyclerView.Adapter<RessentiCorpsViewHolder> {

    ArrayList<RessentiCorps> mes_rc;


    public RessentiCorpsAdapter(ArrayList<RessentiCorps> mes_ressentis) {
        this.mes_rc = mes_ressentis;
    }

    @NonNull
    @Override
    public RessentiCorpsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.ligne_ressenti_corps, parent, false);
        return new RessentiCorpsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RessentiCorpsViewHolder holder, int position) {
        holder.display(mes_rc.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_rc.size();
    }


}