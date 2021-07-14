package com.example.ibursary;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int NoOfTabs;

    public PagerAdapter(FragmentManager fm, int NoOfTabs){

        super(fm);
        this.NoOfTabs = NoOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeAdminFragment();
            case 1:
                return new ApplicationsFragment();
            case 2:
                return new StatusFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
