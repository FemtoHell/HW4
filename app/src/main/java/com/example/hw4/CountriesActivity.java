package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {

    private TabLayout tabLayoutCountries;
    private ViewPager2 viewPagerCountries;
    private CountryPagerAdapter countryPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Countries");
        }

        // Initialize views
        initViews();

        // Setup ViewPager and TabLayout
        setupViewPager();
    }

    private void initViews() {
        tabLayoutCountries = findViewById(R.id.tabLayoutCountries);
        viewPagerCountries = findViewById(R.id.viewPagerCountries);
    }

    private void setupViewPager() {
        // Create adapter
        countryPagerAdapter = new CountryPagerAdapter(this);
        viewPagerCountries.setAdapter(countryPagerAdapter);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayoutCountries, viewPagerCountries,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("United Kingdom");
                            break;
                        case 1:
                            tab.setText("France");
                            break;
                        case 2:
                            tab.setText("Italy");
                            break;
                    }
                }).attach();

        // Optional: Add page change callback
        viewPagerCountries.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // You can add analytics or other logic here
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