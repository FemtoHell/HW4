package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.util.Log;

public class MuseumPagerAdapter extends FragmentStateAdapter {

    private static final String TAG = "MuseumPagerAdapter";

    public MuseumPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(TAG, "MuseumPagerAdapter constructor called");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d(TAG, "createFragment called for position: " + position);

        try {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new BritishMuseumFragment();
                    Log.d(TAG, "BritishMuseumFragment created successfully");
                    break;
                case 1:
                    fragment = new LouvreFragment();
                    Log.d(TAG, "LouvreFragment created successfully");
                    break;
                case 2:
                    fragment = new UffiziFragment();
                    Log.d(TAG, "UffiziFragment created successfully");
                    break;
                default:
                    Log.e(TAG, "Invalid position: " + position + ", returning BritishMuseumFragment as fallback");
                    fragment = new BritishMuseumFragment();
                    break;
            }
            return fragment;
        } catch (Exception e) {
            Log.e(TAG, "Error creating fragment: " + e.getMessage());
            e.printStackTrace();
            return new BritishMuseumFragment(); // fallback
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount called, returning: 3");
        return 3;
    }
}