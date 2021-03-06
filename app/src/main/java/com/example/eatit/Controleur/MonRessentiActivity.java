package com.example.eatit.Controleur;

import android.os.Bundle;

import com.example.eatit.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import com.example.eatit.Fragment.PageAdapterRessenti;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * Activité gérant les ressentis. Contient tous les fragments associés (ma tête, mon corps, mon activité).
 */
public class MonRessentiActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2,tab3;
    public PageAdapterRessenti pageradapter;
    String date_selectionnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_ressenti);

        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        tab1=(TabItem) findViewById(R.id.Tab1);
        tab2=(TabItem) findViewById(R.id.Tab2);
        tab3=(TabItem) findViewById(R.id.Tab3);
        viewPager= findViewById(R.id.viewpager);

        pageradapter=new PageAdapterRessenti(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);

        //tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() ==0) {
                    pageradapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() ==1) {
                    pageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
