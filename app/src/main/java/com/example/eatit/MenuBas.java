package com.example.eatit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuBas extends AppCompatActivity {

    private String fragmentActif;
    private AccueilFragment accueilFragment;
    private RepasFragment mRepasFragment;
    private Fragment fragment, newFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bas);

        //creating fragment transition
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        //adding fragment to current activity
//        if (fragment == null) {
//            fragment = new AccueilFragment();
//        }
//        fragmentTransaction.add(R.id.fragment_layout_menuBas, fragment);
//        fragmentTransaction.commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);

        if (savedInstanceState == null) {
            fragment = new AccueilFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_menuBas,
                    fragment);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_menuBas, fragment).commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = null;

            switch(menuItem.getItemId()) {
                case R.id.navigation_profil:
                    fragment = new ProfilFragment();
                    fragmentTransaction.remove(fragment).addToBackStack("profil");
                    //fragmentTransaction.remove(fragment);
                    //fragmentTransaction.replace(R.id.fragment_layout_menuBas, newFragment);
                    //fragmentTransaction.addToBackStack(null);
                    //newFragment = new ProfilFragment();
                    //fragmentTransaction.add(R.id.fragment_layout_menuBas, fragment);
                    //fragmentTransaction.commit();
                    //fragmentTransaction.remove(fragment);
                    //Intent menuBas = new Intent(MenuBas.this, MenuBas.class);
                    //startActivity(menuBas);
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
            if (fragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_menuBas, fragment).commit();
            }
            else{
                Log.e("MenusBas","Error in creating fragment");
            }
            return true;
        }
    };
}
