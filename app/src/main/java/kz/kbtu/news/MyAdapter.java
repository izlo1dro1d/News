package kz.kbtu.news;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Kaisabekov on 25.05.2015.
 */
public class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fragmentManager){

        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.createNewFragmentToDisplay(position);
    }

    @Override
    public int getCount() {
        return MainActivity.NUMBER_OF_LIST;
    }

    @Override
    public CharSequence getPageTitle(int position){
        if(position==0)
            return "Apple";
        if(position==1)
            return "Google";
        if(position==2)
            return "Hardware";
        if(position==3)
            return "Software";
        return "Other";
    }
}
