package com.example.hw4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ItalyFragment extends Fragment {

    private LinearLayout loadingLayout;
    private ScrollView contentScrollView;
    private ImageView ivFlag;
    private TextView tvCapital, tvLargestCity, tvLanguage, tvArea, tvCurrency, tvDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);

        // Initialize views
        loadingLayout = view.findViewById(R.id.loadingLayout);
        contentScrollView = view.findViewById(R.id.contentScrollView);
        ivFlag = view.findViewById(R.id.ivFlag);
        tvCapital = view.findViewById(R.id.tvCapital);
        tvLargestCity = view.findViewById(R.id.tvLargestCity);
        tvLanguage = view.findViewById(R.id.tvLanguage);
        tvArea = view.findViewById(R.id.tvArea);
        tvCurrency = view.findViewById(R.id.tvCurrency);
        tvDescription = view.findViewById(R.id.tvDescription);

        // Load data with delay to show loading
        loadData();

        return view;
    }

    private void loadData() {
        // Show loading for 2 seconds
        new Handler().postDelayed(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                // Hide loading and show content
                loadingLayout.setVisibility(View.GONE);
                contentScrollView.setVisibility(View.VISIBLE);

                // Set Italy data
                ivFlag.setImageResource(R.drawable.flag_italy); // Use placeholder icon
                tvCapital.setText("Rome");
                tvLargestCity.setText("Rome");
                tvLanguage.setText("Italian");
                tvArea.setText("301,340 km²");
                tvCurrency.setText("EUR");
                tvDescription.setText("Italy, officially the Italian Republic, is a country in " +
                        "Southern and Western Europe. Located in the middle of the Mediterranean Sea, " +
                        "it consists of a peninsula delimited by the Alps and several islands surrounding " +
                        "it. Italy shares land borders with France, Switzerland, Austria, Slovenia, as well " +
                        "as the enclaved microstates of Vatican City and San Marino. It has a territorial " +
                        "exclave in Switzerland (Campione) and an archipelago in the African Plate (Pelagie " +
                        "Islands). Italy covers an area of 301,340 km² and has a largely temperate seasonal " +
                        "and Mediterranean climate. With around 60 million inhabitants, Italy is the " +
                        "third-most populous member state of the European Union.");
            }
        }, 2000); // 2 seconds delay
    }
}