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

public class UKFragment extends Fragment {

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

                // Set UK data
                ivFlag.setImageResource(R.drawable.flag_uk); // Use placeholder icon
                tvCapital.setText("London");
                tvLargestCity.setText("London");
                tvLanguage.setText("English");
                tvArea.setText("242,495 km²");
                tvCurrency.setText("GBP");
                tvDescription.setText("The United Kingdom of Great Britain and Northern Ireland, " +
                        "commonly known as the United Kingdom (UK) or Britain, is a country in " +
                        "Northwestern Europe, off the coast of the continental mainland. It comprises " +
                        "England, Scotland, Wales, and Northern Ireland. The UK includes the island of " +
                        "Great Britain, the north-eastern part of the island of Ireland, and most of " +
                        "the smaller islands within the British Isles, covering 94,354 square miles " +
                        "(244,376 km2). Northern Ireland shares a land border with the Republic of " +
                        "Ireland; otherwise, the United Kingdom is surrounded by the Atlantic Ocean, " +
                        "the North Sea, the English Channel, the Celtic Sea, and the Irish Sea. The " +
                        "UK maintains sovereignty over the British Overseas Territories.");
            }
        }, 2000); // 2 seconds delay
    }
}