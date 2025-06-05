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

public class Leader2Fragment extends Fragment {

    private LinearLayout loadingLayout;
    private ScrollView contentScrollView;
    private ImageView ivLeaderPhoto;
    private TextView tvLeaderName, tvLeaderTitle, tvCountry, tvBirthDate, tvInOffice, tvBiography;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leader, container, false);

        // Initialize views
        loadingLayout = view.findViewById(R.id.loadingLayout);
        contentScrollView = view.findViewById(R.id.contentScrollView);
        ivLeaderPhoto = view.findViewById(R.id.ivLeaderPhoto);
        tvLeaderName = view.findViewById(R.id.tvLeaderName);
        tvLeaderTitle = view.findViewById(R.id.tvLeaderTitle);
        tvCountry = view.findViewById(R.id.tvCountry);
        tvBirthDate = view.findViewById(R.id.tvBirthDate);
        tvInOffice = view.findViewById(R.id.tvInOffice);
        tvBiography = view.findViewById(R.id.tvBiography);

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

                // Set Leader 2 data (Example: French President)
                ivLeaderPhoto.setImageResource(R.drawable.leader2_photo);
                tvLeaderName.setText("Emmanuel Macron");
                tvLeaderTitle.setText("President of France");
                tvCountry.setText("France");
                tvBirthDate.setText("21 December 1977");
                tvInOffice.setText("May 2017 - Present");
                tvBiography.setText("Emmanuel Jean-Michel Frédéric Macron is a French politician " +
                        "who has been serving as the President of France since 2017. Ex officio, " +
                        "he is also one of the two Co-Princes of Andorra. Prior to his presidency, " +
                        "Macron served as the Minister of the Economy, Industry and Digital Affairs " +
                        "from 2014 to 2016. Born in Amiens, Macron studied philosophy at Paris " +
                        "Nanterre University, later completing a master's degree in public affairs " +
                        "at Sciences Po and graduating from the École nationale d'administration " +
                        "in 2004. He worked as a senior civil servant at the Inspectorate General " +
                        "of Finances and later became an investment banker at Rothschild & Co.");
            }
        }, 2000); // 2 seconds delay
    }
}