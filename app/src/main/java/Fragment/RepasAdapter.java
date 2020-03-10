package Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eatit.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Fragment.RepasViewHolder;
import Model.BD_Repas;
import Model.Repas;

public class RepasAdapter extends RecyclerView.Adapter<RepasViewHolder>{

    private ArrayList<Repas> lRepas;
    private BD_Repas mBD_repas;
    private String mDate;
    private SimpleDateFormat sdf;

    public RepasAdapter(ArrayList<Repas> lRepas){
//        sdf = new SimpleDateFormat("dd-MM-yyyy");
//        mDate = sdf.format(date);
        this.lRepas = lRepas;
    }

    //Creer le view holder
    @NonNull
    @Override
    public RepasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_repas, parent, false);
        return new RepasViewHolder(view);
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
}
