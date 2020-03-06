package Controleur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eatit.R;
import java.util.ArrayList;
import java.util.Date;
import Model.Repas;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepasMainFragment extends Fragment {

    @BindView(R.id.recyclerView_mesRepas) RecyclerView recyclerView;
    //private Disposable disposable;
    private ArrayList<Repas> lRepas;
    private RepasAdapter mAdapter;
    private String mdate;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, LayoutInflater inflater, ViewGroup container) {
//        View view = inflater.inflate(R.layout.)
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mes_repas);
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, Date date){
        View view = inflater.inflate(R.layout.fragment_repas, container, false);
        ButterKnife.bind(this, view);
        //this.executeHttpRequestWithRetrofit();
        this.mdate = date.toString();
        this.configureRecyclerView(mdate);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    //Configuration du recycler, adapter et layoutManager ensemble
    public void configureRecyclerView(String date){
        this.mdate = date;
        this.lRepas = new ArrayList<>(); //Remet à zéro la liste
        this.mAdapter = new RepasAdapter(this.lRepas, mdate);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void disposeWhenDestroy(){
        // if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    private void updateUI(ArrayList<Repas> lRepas){
        this.lRepas.addAll(lRepas);
        mAdapter.notifyDataSetChanged();
    }

}
