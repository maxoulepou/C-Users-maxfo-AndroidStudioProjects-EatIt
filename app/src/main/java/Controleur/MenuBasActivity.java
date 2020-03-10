package Controleur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import Fragment.*;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.eatit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuBasActivity extends AppCompatActivity {

    private String fragmentActif;
    private AccueilFragment accueilFragment;
    private RepasFragment mRepasFragment;
    //private Fragment fragment, newFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bas);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_menuBas,
                    new AccueilFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch(menuItem.getItemId()) {
                case R.id.navigation_ressenti:
                    fragment = new RessentiFragment();
                    break;
                case R.id.navigation_repas:
                    fragment = new RepasFragment();
                    break;
                case R.id.navigation_accueil:
                    fragment = new AccueilFragment();
                    break;
                case R.id.navigation_objectifs:
                    fragment = new ObjectifsFragment();
                    break;
                case R.id.navigation_poids:
                    fragment = new PoidsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_menuBas,fragment).commit();
            return true;
        }
    };
}
