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

public class UffiziFragment extends Fragment {

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
            @Override
            public void run() {
                // Hide loading and show content
                loadingLayout.setVisibility(View.GONE);
                contentScrollView.setVisibility(View.VISIBLE);

                // Set Uffizi Gallery data
                ivMuseumImage.setImageResource(R.drawable.uffizi_gallery);
                tvMuseumName.setText("The Uffizi Gallery");
                tvLocation.setText("Florence, Italy");
                tvFounded.setText("1581");
                tvVisitors.setText("2 million per year");
                tvFamousFor.setText("Botticelli's Birth of Venus, Renaissance paintings");
                tvDescription.setText("The Uffizi Gallery is a prominent art museum located adjacent " +
                        "to the Piazza della Signoria in the Historic Centre of Florence in the " +
                        "region of Tuscany, Italy. One of the most important Italian museums and " +
                        "the most visited, it is also one of the largest and best known in the " +
                        "world and holds a collection of priceless works, particularly from the " +
                        "period of the Italian Renaissance. After the ruling house of Medici died " +
                        "out, their art collections were gifted to the city of Florence under the " +
                        "famous Patto di famiglia negotiated by Anna Maria Luisa, the last Medici " +
                        "heiress. The Uffizi is one of the first modern museums. The gallery had " +
                        "been open to visitors by request since the sixteenth century, and in 1765 " +
                        "it was officially opened to the public, formally becoming a museum in 1865.");
            }
        }, 2000); // 2 seconds delay
    }
}