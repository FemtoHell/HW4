package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.util.Log;

public class WonderPagerAdapter extends FragmentStateAdapter {

    private static final String TAG = "WonderPagerAdapter";

    public WonderPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d(TAG, "WonderPagerAdapter constructor called");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d(TAG, "createFragment called for position: " + position);

        try {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new GreatWallFragment();
                    Log.d(TAG, "GreatWallFragment created successfully");
                    break;
                case 1:
                    fragment = new ColosseumFragment();
                    Log.d(TAG, "ColosseumFragment created successfully");
                    break;
                case 2:
                    fragment = new TajMahalFragment();
                    Log.d(TAG, "TajMahalFragment created successfully");
                    break;
                default:
                    Log.e(TAG, "Invalid position: " + position + ", returning GreatWallFragment as fallback");
                    fragment = new GreatWallFragment();
                    break;
            }
            return fragment;
        } catch (Exception e) {
            Log.e(TAG, "Error creating fragment: " + e.getMessage());
            e.printStackTrace();
            return new GreatWallFragment(); // fallback
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount called, returning: 3");
        return 3;
    }
}