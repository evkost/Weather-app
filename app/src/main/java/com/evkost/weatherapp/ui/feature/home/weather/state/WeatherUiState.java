package com.evkost.weatherapp.ui.feature.home.weather.state;

public class WeatherUiState {
    private Boolean isRefreshing;

    public Boolean isRefreshing() {
        return isRefreshing;
    }

    public WeatherUiState setRefreshing(Boolean isRefreshing) {
        this.isRefreshing = isRefreshing;
        return this;
    }
}
