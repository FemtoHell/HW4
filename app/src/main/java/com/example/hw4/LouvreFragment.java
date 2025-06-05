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

public class LouvreFragment extends Fragment {

    private LinearLayout loadingLayout;
    private ScrollView contentScrollView;
    private ImageView ivMuseumImage;
    private TextView tvMuseumName, tvLocation, tvFounded, tvVisitors, tvFamousFor, tvDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_museum, container, false);

        // Initialize views
        loadingLayout = view.findViewById(R.id.loadingLayout);
        contentScrollView = view.findViewById(R.id.contentScrollView);
        ivMuseumImage = view.findViewById(R.id.ivMuseumImage);
        tvMuseumName = view.findViewById(R.id.tvMuseumName);
        tvLocation = view.findViewById(R.id.tvLocation);
        tvFounded = view.findViewById(R.id.tvFounded);
        tvVisitors = view.findViewById(R.id.tvVisitors);
        tvFamousFor = view.findViewById(R.id.tvFamousFor);
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

                // Set Louvre Museum data
                ivMuseumImage.setImageResource(R.drawable.louvre_museum);
                tvMuseumName.setText("The Louvre Museum");
                tvLocation.setText("Paris, France");
                tvFounded.setText("1793");
                tvVisitors.setText("10 million per year");
                tvFamousFor.setText("Mona Lisa, Venus de Milo, Winged Victory");
                tvDescription.setText("The Louvre, or the Louvre Museum, is the world's most-visited " +
                        "museum, and a historic landmark in Paris, France. It is the home of some of " +
                        "the best-known works of art, including the Mona Lisa and the Venus de Milo. " +
                        "A central landmark of the city, it is located on the Right Bank of the Seine " +
                        "in the city's 1st arrondissement. At any given point in time, approximately " +
                        "38,000 objects from prehistory to the 21st century are being exhibited over " +
                        "an area of 72,735 square meters. Due to the COVID-19 pandemic, the museum " +
                        "was closed for 150 days in 2020, and attendance plunged by 72 percent to " +
                        "2.7 million. Nonetheless, the Louvre still topped the list of most-visited " +
                        "art museums in the world in 2021.");
            }
        }, 2000); // 2 seconds delay
    }
}