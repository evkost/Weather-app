package com.evkost.weatherapp.model.entity;

import java.util.List;

public class ForecastDayEntity extends AbstractEntity  {
    private Long id;
    private String tzId;
    private Double maxTempC;
    private Double minTempC;
    private Double maxWindMph;
    private Double totalPrecipitationMm;
    private Double totalSnowCm;
    private Double avgHumidity;
    private Integer dailyChanceOfRain;
    private Integer dailyChanceOfSnow;
    private Integer conditionCode;
    private String date;
    private List<ForecastHourEntity> forecastHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTzId() {
        return tzId;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

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

    public java.lang.Integer getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(java.lang.Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public java.lang.Integer getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setDailyChanceOfSnow(java.lang.Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public Integer getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ForecastHourEntity> getForecastHours() {
        return forecastHours;
    }

    public void setForecastHours(List<ForecastHourEntity> forecastHours) {
        this.forecastHours = forecastHours;
    }
}
