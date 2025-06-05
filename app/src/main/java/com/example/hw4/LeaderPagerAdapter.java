package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.util.Log;

public class LeaderPagerAdapter extends FragmentStateAdapter {

    private static final String TAG = "LeaderPagerAdapter";

    public LeaderPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(TAG, "LeaderPagerAdapter constructor called");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d(TAG, "createFragment called for position: " + position);

        try {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new Leader1Fragment();
                    Log.d(TAG, "Leader1Fragment created successfully");
                    break;
                case 1:
                    fragment = new Leader2Fragment();
                    Log.d(TAG, "Leader2Fragment created successfully");
                    break;
                case 2:
                    fragment = new Leader3Fragment();
                    Log.d(TAG, "Leader3Fragment created successfully");
                    break;
                default:
                    Log.e(TAG, "Invalid position: " + position + ", returning Leader1Fragment as fallback");
                    fragment = new Leader1Fragment();
                    break;
            }
            return fragment;
        } catch (Exception e) {
            Log.e(TAG, "Error creating fragment: " + e.getMessage());
            e.printStackTrace();
            return new Leader1Fragment(); // fallback
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount called, returning: 3");
        return 3;
    }
}