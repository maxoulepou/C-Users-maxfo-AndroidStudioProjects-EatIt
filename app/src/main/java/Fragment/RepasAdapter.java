package Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.BD_Repas;
import Model.ObjectifPersonnel;
import Model.Repas;

public class RepasAdapter extends RecyclerView.Adapter<RepasViewHolder> {

    private ArrayList<Repas> lRepas;
    private BD_Repas mBD_repas;
    private String mDate;
    private SimpleDateFormat sdf;

    public RepasAdapter(ArrayList<Repas> lRepas) {
//        sdf = new SimpleDateFormat("dd-MM-yyyy");
//        mDate = sdf.format(date);
        this.lRepas = lRepas;
    }

    //Creer le view holder
    @NonNull
    @Override
    public RepasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.ligne_repas1, parent, false);
//        return new RepasViewHolder(view);

        View view;
        if (viewType == 0) {
            LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
            view = layoutinflater.inflate(R.layout.ligne_repas1, parent, false);
            return new RepasViewHolder(view);
        } else {
            if (viewType == 1) {
                LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
                view = layoutinflater.inflate(R.layout.ligne_repas2, parent, false);
                return new RepasViewHolder(view);
            } else {
                if (viewType == 2) {
                    LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
                    view = layoutinflater.inflate(R.layout.ligne_repas3, parent, false);
                    return new RepasViewHolder(view);
                } else {
                    if (viewType == 3) {
                        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
                        view = layoutinflater.inflate(R.layout.ligne_repas4, parent, false);
                        return new RepasViewHolder(view);
                    } else {

                        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
                        view = layoutinflater.inflate(R.layout.ligne_repas5, parent, false);
                        return new RepasViewHolder(view);

                    }
                }
            }
        }


    }

    //Renvoie da la liste de repas au view holder pour update affichage
    @Override
    public void onBindViewHolder(@NonNull RepasViewHolder viewHolder, int position) {
        viewHolder.update(this.lRepas.get(position));
    }

    //Retourne le compte total d'item dans la liste
    @Override
    public int getItemCount() {
        return lRepas.size();
    }

    public int getItemViewType(int position) {
        if (lRepas.get(position).getTypeRepas().equals("Petit déjeuner")) {
            return 0;
        } else {
            if (lRepas.get(position).getTypeRepas().equals("Déjeuner")) {
                return 1;
            } else {
                if (lRepas.get(position).getTypeRepas().equals("Collation")) {
                    return 2;
                } else {
                    if (lRepas.get(position).getTypeRepas().equals("Diner")) {
                        return 3;
                    } else {
                        return 4;
                    }
                }
            }
        }
    }
}
