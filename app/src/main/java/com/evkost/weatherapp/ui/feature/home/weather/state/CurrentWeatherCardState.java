package com.evkost.weatherapp.ui.feature.home.weather.state;

public class CurrentWeatherCardState {
    private Double tempC;
    private Double feelsLikeTempC;
    private Integer conditionCode;

    public Double getTempC() {
        return tempC;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Double getFeelsLikeTempC() {
        return feelsLikeTempC;
    }

    public void setFeelsLikeTempC(Double feelsLikeTempC) {
        this.feelsLikeTempC = feelsLikeTempC;
    }

    public Integer getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }
}
