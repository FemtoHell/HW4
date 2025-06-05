package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MuseumsActivity extends AppCompatActivity {

    private TabLayout tabLayoutMuseums;
    private ViewPager2 viewPagerMuseums;
    private MuseumPagerAdapter museumPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Famous Museums");
        }

        // Initialize views
        initViews();

        // Setup ViewPager and TabLayout
        setupViewPager();
    }

    private void initViews() {
        tabLayoutMuseums = findViewById(R.id.tabLayoutMuseums);
        viewPagerMuseums = findViewById(R.id.viewPagerMuseums);
    }

    private void setupViewPager() {
        // Create adapter
        museumPagerAdapter = new MuseumPagerAdapter(this);
        viewPagerMuseums.setAdapter(museumPagerAdapter);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayoutMuseums, viewPagerMuseums,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("British Museum");
                            break;
                        case 1:
                            tab.setText("Louvre");
                            break;
                        case 2:
                            tab.setText("Uffizi");
                            break;
                    }
                }).attach();

        // Optional: Add page change callback with animation
        viewPagerMuseums.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // You can add custom animations or analytics here
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                // Optional: Add parallax or other scroll effects
            }
        });

        // Optional: Set page transformer for animations
        viewPagerMuseums.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // Simple fade animation
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