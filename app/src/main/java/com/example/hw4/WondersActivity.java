package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

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
        new TabLayoutMediator(tabLayoutWonders, viewPagerWonders,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Great Wall");
                            break;
                        case 1:
                            tab.setText("Colosseum");
                            break;
                        case 2:
                            tab.setText("Taj Mahal");
                            break;
                    }
                }).attach();

        // Optional: Add smooth scroll and custom offscreen page limit
        viewPagerWonders.setOffscreenPageLimit(1);

        // Optional: Add page change callback
        viewPagerWonders.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Log the current wonder being viewed
                String wonderName = "";
                switch (position) {
                    case 0:
                        wonderName = "Great Wall of China";
                        break;
                    case 1:
                        wonderName = "Colosseum";
                        break;
                    case 2:
                        wonderName = "Taj Mahal";
                        break;
                }
                // You can add analytics tracking here
            }
        });

        // Optional: Add custom page transformer for zoom effect
        viewPagerWonders.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                if (position < -1) {
                    page.setAlpha(0);
                } else if (position <= 0) {
                    page.setAlpha(1);
                    page.setTranslationX(0);
                    page.setScaleX(1);
                    page.setScaleY(1);
                } else if (position <= 1) {
                    page.setAlpha(1 - position);
                    page.setTranslationX(page.getWidth() * -position);
                    float scaleFactor = 0.75f + (1 - 0.75f) * (1 - Math.abs(position));
                    page.setScaleX(scaleFactor);
                    page.setScaleY(scaleFactor);
                } else {
                    page.setAlpha(0);
                }
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