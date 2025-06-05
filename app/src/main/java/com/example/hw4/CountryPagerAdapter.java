package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.util.Log;

public class CountryPagerAdapter extends FragmentStateAdapter {

    private static final String TAG = "CountryPagerAdapter";

    public CountryPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(TAG, "CountryPagerAdapter constructor called");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d(TAG, "createFragment called for position: " + position);

        try {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new UKFragment();
                    Log.d(TAG, "UKFragment created successfully");
                    break;
                case 1:
                    fragment = new FranceFragment();
                    Log.d(TAG, "FranceFragment created successfully");
                    break;
                case 2:
                    fragment = new ItalyFragment();
                    Log.d(TAG, "ItalyFragment created successfully");
                    break;
                default:
                    Log.e(TAG, "Invalid position: " + position + ", returning UKFragment as fallback");
                    fragment = new UKFragment();
                    break;
            }
            return fragment;
        } catch (Exception e) {
            Log.e(TAG, "Error creating fragment: " + e.getMessage());
            e.printStackTrace();
            return new UKFragment(); // fallback
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount called, returning: 3");
        return 3; // MUST return 3 for UK, France, Italy
    }
}