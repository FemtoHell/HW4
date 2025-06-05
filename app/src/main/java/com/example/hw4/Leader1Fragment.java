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

                // Set Leader 1 data (Updated: Keir Starmer - current UK PM)
                ivLeaderPhoto.setImageResource(R.drawable.leader1_photo); // Use placeholder icon instead of leader1_photo
                tvLeaderName.setText("Keir Starmer");
                tvLeaderTitle.setText("Prime Minister of the United Kingdom");
                tvCountry.setText("United Kingdom");
                tvBirthDate.setText("2 September 1962");
                tvInOffice.setText("July 2024 - Present");
                tvBiography.setText("Sir Keir Rodney Starmer is a British politician and barrister " +
                        "who has served as Prime Minister of the United Kingdom and Leader of the " +
                        "Labour Party since July 2024. Before entering politics, Starmer was a " +
                        "barrister specialising in human rights issues. He served as Director of " +
                        "Public Prosecutions and head of the Crown Prosecution Service from 2008 " +
                        "to 2013. Starmer was elected as Member of Parliament for Holborn and St " +
                        "Pancras in 2015 and became Leader of the Labour Party in 2020.");
            }
        }, 2000); // 2 seconds delay
    }
}