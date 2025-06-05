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

public class TajMahalFragment extends Fragment {

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
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                // Hide loading and show content
                loadingLayout.setVisibility(View.GONE);
                contentScrollView.setVisibility(View.VISIBLE);

                // Set Taj Mahal data
                ivWonderImage.setImageResource(R.drawable.taj_mahal);
                tvWonderName.setText("The Taj Mahal");
                tvLocation.setText("Agra, India");
                tvBuilt.setText("1632-1653");
                tvLength.setText("73 meters");
                tvHeight.setText("73 meters");
                tvUnescoSite.setText("Yes (1983)");
                tvDescription.setText("The Taj Mahal is an ivory-white marble mausoleum on the " +
                        "right bank of the river Yamuna in the Indian city of Agra. It was " +
                        "commissioned in 1632 by the Mughal emperor Shah Jahan (r. 1628–1658) " +
                        "to house the tomb of his favourite wife, Mumtaz Mahal; it also houses " +
                        "the tomb of Shah Jahan himself. The tomb is the centrepiece of a " +
                        "17-hectare (42-acre) complex, which includes a mosque and a guest house, " +
                        "and is set in formal gardens bounded on three sides by a crenellated wall. " +
                        "Construction of the mausoleum was essentially completed in 1643, but work " +
                        "continued on other phases of the project for another 10 years. The Taj " +
                        "Mahal complex is believed to have been completed in its entirety in 1653 " +
                        "at a cost estimated at the time to be around 32 million rupees, which " +
                        "in 2020 would be approximately 70 billion rupees (about US $1 billion).");
            }
        }, 2000); // 2 seconds delay
    }
}