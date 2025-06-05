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

public class Leader1Fragment extends Fragment {

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
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                // Hide loading and show content
                loadingLayout.setVisibility(View.GONE);
                contentScrollView.setVisibility(View.VISIBLE);

                // Set Leader 1 data (Example: UK Prime Minister)
                ivLeaderPhoto.setImageResource(R.drawable.leader1_photo);
                tvLeaderName.setText("Rishi Sunak");
                tvLeaderTitle.setText("Prime Minister of the United Kingdom");
                tvCountry.setText("United Kingdom");
                tvBirthDate.setText("12 May 1980");
                tvInOffice.setText("October 2022 - Present");
                tvBiography.setText("Rishi Sunak is a British politician who has served as Prime Minister " +
                        "of the United Kingdom and Leader of the Conservative Party since October 2022. " +
                        "He previously held two cabinet positions under Boris Johnson, serving as " +
                        "Chancellor of the Exchequer from 2020 to 2022 and Chief Secretary to the " +
                        "Treasury from 2019 to 2020. Sunak was born in Southampton to parents of " +
                        "Indian heritage who migrated to Britain from East Africa in the 1960s. " +
                        "He was educated at Winchester College, studied philosophy, politics and " +
                        "economics at Lincoln College, Oxford, and earned an MBA from Stanford " +
                        "University as a Fulbright Scholar.");
            }
        }, 2000); // 2 seconds delay
    }
}