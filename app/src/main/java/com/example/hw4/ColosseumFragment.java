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

public class ColosseumFragment extends Fragment {

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

                // Set Colosseum data
                ivWonderImage.setImageResource(R.drawable.colosseum);
                tvWonderName.setText("The Colosseum");
                tvLocation.setText("Rome, Italy");
                tvBuilt.setText("72-80 AD");
                tvLength.setText("189 meters");
                tvHeight.setText("48 meters");
                tvUnescoSite.setText("Yes (1980)");
                tvDescription.setText("The Colosseum is an oval amphitheatre in the centre of the " +
                        "city of Rome, Italy, just east of the Roman Forum. It is the largest " +
                        "ancient amphitheatre ever built, and is still the largest standing " +
                        "amphitheatre in the world today, despite its age. Construction began " +
                        "under the emperor Vespasian (r. 69–79 AD) in 72 and was completed in " +
                        "80 AD under his successor and heir, Titus (r. 79–81). Further modifications " +
                        "were made during the reign of Domitian (r. 81–96). The three emperors that " +
                        "were patrons of the work are known as the Flavian dynasty, and the " +
                        "amphitheatre was named the Flavian Amphitheatre by later classicists " +
                        "and archaeologists for its association with their family name (Flavius). " +
                        "The Colosseum could hold an estimated 50,000 to 80,000 spectators at " +
                        "various points in its history, having an average audience of some 65,000.");
            }
        }, 2000); // 2 seconds delay
    }
}