package com.evkost.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.evkost.weatherapp.MainNavGraphDirections;
import com.evkost.weatherapp.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen
                .installSplashScreen(this)
                .setKeepOnScreenCondition(() -> !viewModel.getMainUiStateLiveData().getValue().isLoaded());

        super.onCreate(savedInstanceState);
        setupBinding();
        initViewModel();
        setupNavController();

        viewModel.getSideEffectLiveData().observe(this, sideEffect -> {
            if (sideEffect == null) return;

            switch (sideEffect.getToDestination()) {
                case HOME:
                    MainNavGraphDirections.actionToHomeFragment();
                    break;
                case WELCOME:
                    MainNavGraphDirections.actionToWelcomeFragment();
                    break;
            }
            viewModel.sideEffectAccepted();
        });
    }
    private void initViewModel() {
        viewModel =  new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void setupBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void setupNavController() {
        NavHostFragment navHostFragment = binding.mainNavHostFragment.getFragment();
        navController = navHostFragment.getNavController();
    }
}