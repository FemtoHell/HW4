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

public class BritishMuseumFragment extends Fragment {

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

                // Set British Museum data
                ivMuseumImage.setImageResource(R.drawable.british_museum); // Use placeholder icon
                tvMuseumName.setText("The British Museum");
                tvLocation.setText("London, United Kingdom");
                tvFounded.setText("1753");
                tvVisitors.setText("6 million per year");
                tvFamousFor.setText("Egyptian mummies, Rosetta Stone, Elgin Marbles");
                tvDescription.setText("The British Museum is a public museum dedicated to human " +
                        "history, art and culture located in the Bloomsbury area of London. Its " +
                        "permanent collection of eight million works is among the largest and most " +
                        "comprehensive in existence. It documents the story of human culture from " +
                        "its beginnings to the present. The British Museum was the first public " +
                        "national museum to cover all fields of knowledge. The museum was established " +
                        "in 1753, largely based on the collections of the Anglo-Irish physician and " +
                        "scientist Sir Hans Sloane. It first opened to the public in 1759, in " +
                        "Montagu House, on the site of the current building. The museum's expansion " +
                        "over the following 250 years was largely a result of British colonisation " +
                        "and resulted in the creation of several branch institutions.");
            }
        }, 2000); // 2 seconds delay
    }
}