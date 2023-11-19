package com.evkost.weatherapp.ui.feature.home.weather.state;

import java.util.List;

public class TodayForecastState {
    private List<ForecastHourCardState> forecastHourCardStates;

    public List<ForecastHourCardState> getForecastCardStates() {
        return forecastHourCardStates;
    }

    public void setForecastCardStates(List<ForecastHourCardState> forecastHourCardStates) {
        this.forecastHourCardStates = forecastHourCardStates;
    }
}
