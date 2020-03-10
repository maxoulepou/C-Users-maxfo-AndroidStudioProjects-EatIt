package Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterObjectifs extends FragmentPagerAdapter {

    private int numberoftabs;

    public PageAdapterObjectifs(FragmentManager fm, int numberoftabs) {
        super(fm);
        this.numberoftabs=numberoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MesObjPersonnelsFragment();
            case 1:
                return new MesObjPartagesFragment();
            case 2:
                return new MesObjsAtteintsFragment();
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