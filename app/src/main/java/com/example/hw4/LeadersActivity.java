package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LeadersActivity extends AppCompatActivity {

    private TabLayout tabLayoutLeaders;
    private ViewPager2 viewPagerLeaders;
    private LeaderPagerAdapter leaderPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("World Leaders");
        }

        // Initialize views
        initViews();

        // Setup ViewPager and TabLayout
        setupViewPager();
    }

    private void initViews() {
        tabLayoutLeaders = findViewById(R.id.tabLayoutLeaders);
        viewPagerLeaders = findViewById(R.id.viewPagerLeaders);
    }

    private void setupViewPager() {
        // Create adapter
        leaderPagerAdapter = new LeaderPagerAdapter(this);
        viewPagerLeaders.setAdapter(leaderPagerAdapter);

        // Connect TabLayout with ViewPager2 using string array for tab titles
        String[] tabTitles = {"Starmer", "Macron", "Meloni"}; // Shortened titles

        new TabLayoutMediator(tabLayoutLeaders, viewPagerLeaders,
                (tab, position) -> {
                    if (position < tabTitles.length) {
                        tab.setText(tabTitles[position]);
                    }
                }).attach();

        // Optional: Add page change callback
        viewPagerLeaders.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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