package com.evkost.weatherapp.ui.feature.common;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class DefaultPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> pagerFragments;

    public DefaultPagerAdapter(Fragment fragment, List<Fragment> pagerFragments) {
        super(fragment);
        this.pagerFragments = pagerFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return pagerFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return pagerFragments.size();
    }
}
