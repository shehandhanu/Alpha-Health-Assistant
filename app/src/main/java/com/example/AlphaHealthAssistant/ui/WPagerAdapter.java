package com.example.AlphaHealthAssistant.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.AlphaHealthAssistant.ui.wreminder.WaterHistoryFragment;
import com.example.AlphaHealthAssistant.ui.wreminder.WaterReminderFragment;
import com.example.AlphaHealthAssistant.ui.wreminder.WaterSettingsFragment;

public class WPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public WPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new WaterReminderFragment();
            case 1:
                return new WaterHistoryFragment();
            case 2:
                return new WaterSettingsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
