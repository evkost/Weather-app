package com.evkost.weatherapp.ui.feature.home.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.evkost.weatherapp.R;
import com.evkost.weatherapp.databinding.FragmentWeatherBinding;
import com.evkost.weatherapp.ui.feature.common.Outcome;
import com.evkost.weatherapp.ui.feature.home.forecast.state.ForecastDayInfoState;
import com.evkost.weatherapp.ui.feature.home.weather.state.CurrentWeatherCardState;
import com.evkost.weatherapp.ui.feature.home.weather.state.TodayForecastState;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherFragment extends Fragment {
    private WeatherViewModel viewModel;
    private FragmentWeatherBinding binding;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel.init();
        viewModel.getWeatherUiStateLiveData().observe(getViewLifecycleOwner(), weatherUiState -> {
            binding.refreshLayout.setRefreshing(weatherUiState.isRefreshing());
        });
        viewModel.getCurrentWeatherCardLiveData().observe(getViewLifecycleOwner(), this::drawCurrentWeatherCard);
        viewModel.getTodayForecastCardLiveData().observe(getViewLifecycleOwner(), this::drawForecastHourLayout);
        viewModel.getSideEffectLiveData().observe(getViewLifecycleOwner(), this::handeSideEffect);

        binding.refreshLayout.setOnRefreshListener(viewModel::refreshAll);
    }

    private void drawCurrentWeatherCard(Outcome<CurrentWeatherCardState> outcome) {
        outcome.ifLoading(() -> {
            binding.currentWeatherCardContentLayout.setVisibility(View.INVISIBLE);
            binding.currentWeatherCardErrorBar.setVisibility(View.GONE);
            binding.currentWeatherCardProgressBar.setVisibility(View.VISIBLE);
        }).ifSuccess(currentWeatherCardState -> {
            String tempCString = currentWeatherCardState.getTempC() + "℃";
            binding.tempCTextView.setText(tempCString);

            String feelsLikeSString = getResources().getString(R.string.current_weather_feels_like_temp_text)
                    + currentWeatherCardState.getFeelsLikeTempC();
            binding.feelsLikeTempCTextView.setText(feelsLikeSString);
            binding.weatherMessageTextView.setText(String.valueOf(currentWeatherCardState.getConditionCode()));

            binding.currentWeatherCardProgressBar.setVisibility(View.GONE);
            binding.currentWeatherCardErrorBar.setVisibility(View.GONE);
            binding.currentWeatherCardContentLayout.setVisibility(View.VISIBLE);
        }).ifError(errorMessage -> {
            binding.currentWeatherCardContentLayout.setVisibility(View.INVISIBLE);
            binding.currentWeatherCardErrorBar.setVisibility(View.VISIBLE);
            binding.currentWeatherCardProgressBar.setVisibility(View.GONE);
        });
    }

    private void drawForecastHourLayout(Outcome<TodayForecastState> outcome) {
        outcome.ifLoading(() -> {
            binding.forecastHourRecyclerView.setVisibility(View.INVISIBLE);
            binding.forecastHourLayoutErrorBar.setVisibility(View.GONE);
            binding.forecastHourLayoutProgressBar.setVisibility(View.VISIBLE);
        }).ifSuccess(currentWeatherCardState -> {
            binding.forecastHourLayoutProgressBar.setVisibility(View.GONE);
            binding.forecastHourLayoutErrorBar.setVisibility(View.GONE);
            binding.forecastHourRecyclerView.setVisibility(View.VISIBLE);
        }).ifError(errorMessage -> {
            binding.forecastHourRecyclerView.setVisibility(View.INVISIBLE);
            binding.forecastHourLayoutErrorBar.setVisibility(View.VISIBLE);
            binding.forecastHourLayoutProgressBar.setVisibility(View.GONE);
        });
    }

    private void handeSideEffect(WeatherSideEffect sideEffect) {
        if (getView() != null) {
            Snackbar.make(getView(), R.string.base_error_message, Snackbar.LENGTH_LONG)
                    .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    .show();
        }
    }
}
