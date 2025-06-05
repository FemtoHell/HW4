package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView cardCountries, cardLeaders, cardMuseums, cardWonders;
    private TextView tvAppTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        initViews();

        // Set click listeners
        setClickListeners();
    }

    private void initViews() {
        // Initialize CardViews
        cardCountries = findViewById(R.id.cardCountries);
        cardLeaders = findViewById(R.id.cardLeaders);
        cardMuseums = findViewById(R.id.cardMuseums);
        cardWonders = findViewById(R.id.cardWonders);

        // Initialize TextView
        tvAppTitle = findViewById(R.id.tvAppTitle);
    }

    private void setClickListeners() {
        // Countries Card Click
        cardCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // Leaders Card Click
        cardLeaders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LeadersActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // Museums Card Click
        cardMuseums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // Seven Wonders Card Click
        cardWonders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WondersActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // Add hover effect for cards (optional)
        addCardHoverEffect(cardCountries);
        addCardHoverEffect(cardLeaders);
        addCardHoverEffect(cardMuseums);
        addCardHoverEffect(cardWonders);
    }

    private void addCardHoverEffect(final CardView cardView) {
        cardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cardView.setCardElevation(8f);
                } else {
                    cardView.setCardElevation(4f);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Double tap to exit
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private boolean doubleBackToExitPressedOnce = false;
}