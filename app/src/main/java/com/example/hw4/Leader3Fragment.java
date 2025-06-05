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

public class Leader3Fragment extends Fragment {

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

                // Set Leader 3 data (Example: Italian Prime Minister)
                ivLeaderPhoto.setImageResource(R.drawable.leader3_photo);
                tvLeaderName.setText("Giorgia Meloni");
                tvLeaderTitle.setText("Prime Minister of Italy");
                tvCountry.setText("Italy");
                tvBirthDate.setText("15 January 1977");
                tvInOffice.setText("October 2022 - Present");
                tvBiography.setText("Giorgia Meloni is an Italian politician who has been serving " +
                        "as the Prime Minister of Italy since October 2022, the first woman to hold " +
                        "this position. A member of the Chamber of Deputies since 2006, she has led " +
                        "the Brothers of Italy (FdI) political party since 2014, and she has been the " +
                        "president of the European Conservatives and Reformists Party since 2020. " +
                        "Born and raised in Rome, Meloni joined the Youth Front, the youth wing of " +
                        "the Italian Social Movement, a neo-fascist political party, in 1992. She " +
                        "later became the national leader of Student Action, the student movement " +
                        "of the National Alliance (AN), a post-fascist party that became the " +
                        "successor party to the Italian Social Movement.");
            }
        }, 2000); // 2 seconds delay
    }
}