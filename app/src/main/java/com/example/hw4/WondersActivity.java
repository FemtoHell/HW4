package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WondersActivity extends AppCompatActivity {

    private TabLayout tabLayoutWonders;
    private ViewPager2 viewPagerWonders;
    private WonderPagerAdapter wonderPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Seven Wonders of the World");
        }

        // Initialize views
        initViews();

        // Setup ViewPager and TabLayout
        setupViewPager();
    }

    private void initViews() {
        tabLayoutWonders = findViewById(R.id.tabLayoutWonders);
        viewPagerWonders = findViewById(R.id.viewPagerWonders);
    }

    private void setupViewPager() {
        // Create adapter
        wonderPagerAdapter = new WonderPagerAdapter(this);
        viewPagerWonders.setAdapter(wonderPagerAdapter);

        // Connect TabLayout with ViewPager2
        String[] tabTitles = {"Great Wall", "Colosseum", "Taj Mahal"};

        new TabLayoutMediator(tabLayoutWonders, viewPagerWonders,
                (tab, position) -> {
                    if (position < tabTitles.length) {
                        tab.setText(tabTitles[position]);
                    }
                }).attach();

        // Set offscreen page limit
        viewPagerWonders.setOffscreenPageLimit(1);

        // Page change callback
        viewPagerWonders.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String wonderName = "";
                switch (position) {
                    case 0: wonderName = "Great Wall of China"; break;
                    case 1: wonderName = "Colosseum"; break;
                    case 2: wonderName = "Taj Mahal"; break;
                }
            }
        });

        // FIXED: Simple PageTransformer like MuseumsActivity - no complex transformations
        viewPagerWonders.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // Simple fade animation only - no scale or translation interference
                page.setAlpha(1 - Math.abs(position));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}