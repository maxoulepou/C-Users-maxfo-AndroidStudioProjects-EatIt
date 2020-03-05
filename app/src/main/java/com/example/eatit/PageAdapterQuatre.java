package com.example.eatit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterQuatre extends FragmentPagerAdapter {

    private int numberoftabs;

    public PageAdapterQuatre(FragmentManager fm, int numberoftabs) {
        super(fm);
        this.numberoftabs=numberoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MonSuivi();
            case 1:
                return new MesDonnees();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberoftabs;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
