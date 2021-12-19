package com.example.fragmentcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class SwipeNavActivity extends FragmentActivity {
    private ViewPager2 viewPager;
    private DemoFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_nav);

        ViewPager2 viewPager
                = findViewById(
                R.id.viewPager2);

        // Create an adapter that
        // knows which fragment should
        // be shown on each page
        DemoFragmentPagerAdapter
                adapter
                = new DemoFragmentPagerAdapter(this);

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);
    }
}