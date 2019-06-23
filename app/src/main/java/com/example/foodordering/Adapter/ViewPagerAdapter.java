package com.example.foodordering.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodordering.ui.FoodFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment currentFragment=null;
        switch (position){
            case 0:currentFragment=new FoodFragment();break;
            case 1:currentFragment=new FoodFragment();break;
            case 2:currentFragment=new FoodFragment();break;
            case 3:currentFragment=new FoodFragment();break;
        }
        return currentFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:title="All Menu";break;
            case 1:title="Salad";break;
            case 2:title="FAst Menu";break;
            case 3:title="Drink";break;
        }
        return title;
    }
}
