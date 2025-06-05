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

public class FranceFragment extends Fragment {

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

                // Set France data
                ivFlag.setImageResource(R.drawable.flag_france); // Use placeholder icon
                tvCapital.setText("Paris");
                tvLargestCity.setText("Paris");
                tvLanguage.setText("French");
                tvArea.setText("643,801 km²");
                tvCurrency.setText("EUR");
                tvDescription.setText("France, officially the French Republic, is a country located " +
                        "primarily in Western Europe. It also includes overseas regions and territories " +
                        "in the Americas and the Atlantic, Pacific, and Indian Oceans, giving it one of " +
                        "the largest discontinuous exclusive economic zones in the world. Metropolitan " +
                        "France shares borders with Belgium and Luxembourg to the north, Germany to the " +
                        "north east, Switzerland to the east, Italy and Monaco to the south east, " +
                        "Andorra and Spain to the south, and a maritime border with the United Kingdom " +
                        "to the north west. Its metropolitan area extends from the Rhine to the Atlantic " +
                        "Ocean and from the Mediterranean Sea to the English Channel and the North Sea. " +
                        "Its overseas territories include French Guiana in South America, Saint Pierre " +
                        "and Miquelon in the North Atlantic, the French West Indies, and many islands " +
                        "in Oceania and the Indian Ocean.");
            }
        }, 2000); // 2 seconds delay
    }
}