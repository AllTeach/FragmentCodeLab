package com.example.fragmentcodelab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DemoFragmentPagerAdapter extends FragmentStateAdapter {
    public DemoFragmentPagerAdapter(
            FragmentActivity f)
    {
        super(f);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1)
        {
            return new SecondExampleFragment();

        }
        else
        {
            return new FirstExampleFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
