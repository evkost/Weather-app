package com.evkost.weatherapp.ui.feature.home.weather;

public class WeatherSideEffect {
    private String errorMessage;

    public WeatherSideEffect(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
