package com.evkost.weatherapp.model.domain;

import java.time.LocalDate;
import java.util.List;

public class ForecastDay {
    private Double maxTempC;
    private Double minTempC;
    private Double maxWindMph;
    private Double totalPrecipitationMm;
    private Double totalSnowCm;
    private Double avgHumidity;
    private Integer dailyChanceOfRain;
    private Integer dailyChanceOfSnow;
    private Integer conditionCode;
    private LocalDate date;
    private List<ForecastHour> forecastHours;

    public Double getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(Double maxTempC) {
        this.maxTempC = maxTempC;
    }

    public Double getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(Double minTempC) {
        this.minTempC = minTempC;
    }

    public Double getMaxWindMph() {
        return maxWindMph;
    }

    public void setMaxWindMph(Double maxWindMph) {
        this.maxWindMph = maxWindMph;
    }

    public Double getTotalPrecipitationMm() {
        return totalPrecipitationMm;
    }

    public void setTotalPrecipitationMm(Double totalPrecipitationMm) {
        this.totalPrecipitationMm = totalPrecipitationMm;
    }

    public Double getTotalSnowCm() {
        return totalSnowCm;
    }

    public void setTotalSnowCm(Double totalSnowCm) {
        this.totalSnowCm = totalSnowCm;
    }

    public Double getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(Double avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public Integer getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public Integer getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setDailyChanceOfSnow(Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public Integer getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ForecastHour> getForecastHours() {
        return forecastHours;
    }

    public void setForecastHours(List<ForecastHour> forecastHours) {
        this.forecastHours = forecastHours;
    }
}
