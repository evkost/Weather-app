package com.evkost.weatherapp.ui.feature.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.evkost.weatherapp.R;
import com.evkost.weatherapp.databinding.FragmentHomeBinding;
import com.evkost.weatherapp.ui.feature.common.DefaultPagerAdapter;
import com.evkost.weatherapp.ui.feature.home.forecast.ForecastFragment;
import com.evkost.weatherapp.ui.feature.home.weather.WeatherFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {
    private HomeViewModel viewModel;
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.toolbar.setOnMenuItemClickListener(menuItem -> {
            if (menuItem.getItemId() == R.id.home_settings_menu_item) {
                HomeFragmentDirections.actionHomeFragmentToSettingsFragment();
                return true;
            }
            return false;
        });

        List<Fragment> pagerFragments = Arrays.asList(
                WeatherFragment.newInstance(), ForecastFragment.newInstance()
        );
        FragmentStateAdapter viewPagerAdapter = new DefaultPagerAdapter(this, pagerFragments);
        binding.homeViewpager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.homeViewpager, (tab, position) -> {}).attach();
    }
}
