package Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterPoids extends FragmentPagerAdapter {

    private int numberoftabs;

    public PageAdapterPoids(FragmentManager fm, int numberoftabs) {
        super(fm);
        this.numberoftabs=numberoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MonSuiviFragment();
            case 1:
                return new MesDonneesFragment();
            default:
                return new MonSuiviFragment();
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