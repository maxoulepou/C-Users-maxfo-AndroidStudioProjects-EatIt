package Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.eatit.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import Controleur.AfficherListeContactsActivity;
import Controleur.ExporterDonneesActivity;
import Controleur.MesRepasActivity;
import Controleur.MonProfilEtEvntActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * Gère l'affichage du fragment des objectifs avec affichage des onglets ma tête, mon corps, mon activité.
 */
public class ObjectifsFragment extends Fragment {

    ImageButton menu;


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2,tab3;
    public PageAdapterObjectifs pageradapter;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_objectifs, container, false);

        tabLayout=(TabLayout) view.findViewById(R.id.tablayout);
        tab1=(TabItem) view.findViewById(R.id.Tab1);
        tab2=(TabItem) view.findViewById(R.id.Tab2);
        tab3=(TabItem) view.findViewById(R.id.Tab3);
        viewPager= view.findViewById(R.id.viewpager);

        pageradapter=new PageAdapterObjectifs(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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









        menu = (ImageButton) view.findViewById(R.id.menu);
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

        return view;
    }

    /**
     * Ouvre une nouvelle activité à partir de l'activité courante.
     * @param nouvelle_classe
     */
    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(getContext(), nouvelle_classe);
        startActivity(intent);
    }
}

