package Fragment;


import android.os.Bundle;
import com.example.eatit.R;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonProfilFragment extends Fragment {

    private EditText champNom, champPrenom, champAdrresse, champMasculin, champFeminin;
    private EditText email, tel, adresse, codePostale, ville, adressePostale;
    private Button enregistrer;

    public MonProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mon_profil, container, false);
    }

}
