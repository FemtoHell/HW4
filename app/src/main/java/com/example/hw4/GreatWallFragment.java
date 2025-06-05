package com.example.hw4;

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

public class GreatWallFragment extends Fragment {

    private LinearLayout loadingLayout;
    private ScrollView contentScrollView;
    private ImageView ivWonderImage;
    private TextView tvWonderName, tvLocation, tvBuilt, tvLength, tvHeight, tvUnescoSite, tvDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wonder, container, false);

        // Initialize views
        loadingLayout = view.findViewById(R.id.loadingLayout);
        contentScrollView = view.findViewById(R.id.contentScrollView);
        ivWonderImage = view.findViewById(R.id.ivWonderImage);
        tvWonderName = view.findViewById(R.id.tvWonderName);
        tvLocation = view.findViewById(R.id.tvLocation);
        tvBuilt = view.findViewById(R.id.tvBuilt);
        tvLength = view.findViewById(R.id.tvLength);
        tvHeight = view.findViewById(R.id.tvHeight);
        tvUnescoSite = view.findViewById(R.id.tvUnescoSite);
        tvDescription = view.findViewById(R.id.tvDescription);

        // Load data with delay to show loading
        loadData();

        return view;
    }

    private void loadData() {
        // Show loading for 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hide loading and show content
                loadingLayout.setVisibility(View.GONE);
                contentScrollView.setVisibility(View.VISIBLE);

                // Set Great Wall of China data
                ivWonderImage.setImageResource(R.drawable.great_wall);
                tvWonderName.setText("The Great Wall of China");
                tvLocation.setText("China");
                tvBuilt.setText("7th century BC - 17th century AD");
                tvLength.setText("21,196 km");
                tvHeight.setText("5-8 meters average");
                tvUnescoSite.setText("Yes (1987)");
                tvDescription.setText("The Great Wall of China is a series of fortifications that " +
                        "were built across the historical northern borders of ancient Chinese states " +
                        "and Imperial China as protection against various nomadic groups from the " +
                        "Eurasian Steppe. Several walls were built from as early as the 7th century BC, " +
                        "with selective stretches later joined together by Qin Shi Huang (220–206 BC), " +
                        "the first emperor of China. Little of the Qin wall remains. Later on, many " +
                        "successive dynasties built and maintained multiple stretches of border walls. " +
                        "The most well-known sections of the wall were built by the Ming dynasty " +
                        "(1368–1644). Apart from defense, other purposes of the Great Wall have " +
                        "included border controls, allowing the imposition of duties on goods " +
                        "transported along the Silk Road, regulation or encouragement of trade " +
                        "and the control of immigration and emigration.");
            }
        }, 2000); // 2 seconds delay
    }
}