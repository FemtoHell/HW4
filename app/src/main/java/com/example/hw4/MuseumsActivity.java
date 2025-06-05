package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View; // Add this import for the transformPage method

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MuseumsActivity extends AppCompatActivity {

    private static final String TAG = "MuseumsActivity";
    private TabLayout tabLayoutMuseums;
    private ViewPager2 viewPagerMuseums;
    private MuseumPagerAdapter museumPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
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
        Log.d(TAG, "initViews called");
        tabLayoutMuseums = findViewById(R.id.tabLayoutMuseums);
        viewPagerMuseums = findViewById(R.id.viewPagerMuseums);

        if (tabLayoutMuseums == null) {
            Log.e(TAG, "tabLayoutMuseums is NULL!");
        } else {
            Log.d(TAG, "tabLayoutMuseums found");
        }

        if (viewPagerMuseums == null) {
            Log.e(TAG, "viewPagerMuseums is NULL!");
        } else {
            Log.d(TAG, "viewPagerMuseums found");
        }
    }

    private void setupViewPager() {
        Log.d(TAG, "setupViewPager called");

        // Create adapter
        museumPagerAdapter = new MuseumPagerAdapter(this);
        Log.d(TAG, "Adapter created, item count: " + museumPagerAdapter.getItemCount());

        viewPagerMuseums.setAdapter(museumPagerAdapter);
        Log.d(TAG, "Adapter set to ViewPager2");

        // Connect TabLayout with ViewPager2 using string array for tab titles
        String[] tabTitles = {"British Museum", "Louvre", "Uffizi"};
        Log.d(TAG, "Tab titles array length: " + tabTitles.length);

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayoutMuseums, viewPagerMuseums,
                (tab, position) -> {
                    Log.d(TAG, "Setting tab at position: " + position);
                    if (position < tabTitles.length) {
                        tab.setText(tabTitles[position]);
                        Log.d(TAG, "Tab " + position + " text set to: " + tabTitles[position]);
                    } else {
                        Log.e(TAG, "Position " + position + " >= tabTitles.length " + tabTitles.length);
                    }
                });

        mediator.attach();
        Log.d(TAG, "TabLayoutMediator attached");

        // Check tab count after setup
        int tabCount = tabLayoutMuseums.getTabCount();
        Log.d(TAG, "Final tab count: " + tabCount);

        // Optional: Add page change callback with animation
        viewPagerMuseums.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d(TAG, "Page selected: " + position);
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