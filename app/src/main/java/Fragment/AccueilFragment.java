package Fragment;

import com.example.eatit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.timessquare.CalendarPickerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

import Controleur.AfficherListeContactsActivity;
import Controleur.ExporterDonneesActivity;
import Controleur.MainActivity;
import Controleur.MesRepasActivity;
import Controleur.MonProfilEtEvntActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Date;

/**
 * Fragment gérant l'affichage de la page d'accueil..
 */
public class AccueilFragment extends Fragment {

    ImageButton menu;
    ImageView deconnexion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil_image, container, false);
        menu = (ImageButton) view.findViewById(R.id.menu);
        deconnexion = view.findViewById(R.id.deconnexion);



        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                PopupMenu popupMenu= new PopupMenu(getActivity().getApplicationContext(),menu);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item1:
                                openNewActivity(MonProfilEtEvntActivity.class);
                                break;
                            case R.id.item2:
                                openNewActivity(AfficherListeContactsActivity.class);
                                break;
                            case R.id.item3:
                                openNewActivity(ExporterDonneesActivity.class);
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        // Déconnexion

        deconnexion.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
            });

         return view;
    }

    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(getContext(), nouvelle_classe);
        startActivity(intent);
    }
}
