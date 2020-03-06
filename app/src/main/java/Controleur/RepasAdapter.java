package Controleur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eatit.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.BD_Repas;
import Model.Repas;

public class RepasAdapter extends RecyclerView.Adapter<RepasViewHolder>{

    private ArrayList<Repas> lRepas;
    private BD_Repas mBD_repas;
    private String mDate;
    private SimpleDateFormat sdf;

    public RepasAdapter(ArrayList<Repas> lRepas, String date){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mDate = sdf.format(date).toString();
        this.lRepas = mBD_repas.getlRepasDate(mDate);
    }

    //Creer le view holder
    @NonNull
    @Override
    public RepasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_repas, parent, false);
        return new RepasViewHolder(view);
    }

    //Renvoie da la liste de repas au view holder pour update affichage
    @Override
    public void onBindViewHolder(@NonNull RepasViewHolder viewHolder, int position) {
        for(int i = 0; i<lRepas.size(); i++){
            viewHolder.update(this.lRepas.get(i));
        }
    }

    //Retourne le compte total d'item dans la liste
    @Override
    public int getItemCount() {
        return this.lRepas.size();
    }
}
