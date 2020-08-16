package com.example.AlphaHealthAssistant.ui.wreminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.AlphaHealthAssistant.R;
import com.google.android.material.tabs.TabLayout;

public class WreminderFragment extends Fragment {

    TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wreminder,null);
        final TabLayout tabLayout1 = (TabLayout) view.findViewById(R.id.tabwLayout);
        tabLayout1.addTab(tabLayout1.newTab().setText("Reminder"));
        tabLayout1.addTab(tabLayout1.newTab().setText("History"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Settings"));

        tabLayout1.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager1 = (ViewPager) view.findViewById(R.id.wviewpager);
        WreminderList adapter = new WreminderList(getChildFragmentManager(),tabLayout1.getTabCount());
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
class WreminderList extends FragmentStatePagerAdapter {

    int noOfTabs;

    public WreminderList(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.noOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;


        if (position == 0) {
            fragment = new WaterReminderFragment();
        }
        if (position == 1) {
            fragment = new WaterReminderFragment();
        }
        if (position == 2) {
            fragment = new WaterReminderFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
