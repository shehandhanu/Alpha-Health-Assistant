package com.example.AlphaHealthAssistant.ui.bmi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.AlphaHealthAssistant.R;

import com.google.android.material.tabs.TabLayout;

public class bmiFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi,null);
        final TabLayout tabLayout1 = (TabLayout) view.findViewById(R.id.tabBMILayout);
        tabLayout1.addTab(tabLayout1.newTab().setText("Reminder"));
        tabLayout1.addTab(tabLayout1.newTab().setText("History"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Settings"));

        tabLayout1.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager1 = (ViewPager) view.findViewById(R.id.bmiviewpager);
        BMIList adapter = new BMIList(getChildFragmentManager(),tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);
        viewPager1.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
}
class BMIList extends FragmentStatePagerAdapter {

    int noOfTabs;

    public BMIList(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.noOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;


        if (position == 0) {
            fragment = new BMICalculatorFragment();
        }
        if (position == 1) {
            fragment = new BMIHistoryFragment();
        }
        if (position == 2) {
            fragment = new BMITipsFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
