package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {

    private static final String TAG = "CountriesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
        setContentView(R.layout.activity_countries);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Countries");
        }

        // Find views - EXACTLY match XML IDs
        TabLayout tabLayoutCountries = findViewById(R.id.tabLayoutCountries);
        ViewPager2 viewPagerCountries = findViewById(R.id.viewPagerCountries);

        // Debug: Check if views are found
        if (tabLayoutCountries == null) {
            Log.e(TAG, "ERROR: tabLayoutCountries is NULL! Check XML file.");
            return;
        }
        if (viewPagerCountries == null) {
            Log.e(TAG, "ERROR: viewPagerCountries is NULL! Check XML file.");
            return;
        }

        Log.d(TAG, "Both views found successfully");

        // Create and set adapter
        CountryPagerAdapter adapter = new CountryPagerAdapter(this);
        viewPagerCountries.setAdapter(adapter);
        Log.d(TAG, "Adapter set");

        // Setup tabs with shorter titles
        String[] tabTitles = {"UK", "France", "Italy"};
        new TabLayoutMediator(tabLayoutCountries, viewPagerCountries,
                (tab, position) -> {
                    if (position < tabTitles.length) {
                        tab.setText(tabTitles[position]);
                        Log.d(TAG, "Tab " + position + " set to: " + tabTitles[position]);
                    }
                }).attach();

        Log.d(TAG, "Setup complete, tab count: " + tabLayoutCountries.getTabCount());
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