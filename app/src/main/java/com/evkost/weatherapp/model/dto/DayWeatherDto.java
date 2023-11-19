package com.evkost.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "maxtemp_c",
        "maxtemp_f",
        "mintemp_c",
        "mintemp_f",
        "avgtemp_c",
        "avgtemp_f",
        "maxwind_mph",
        "maxwind_kph",
        "totalprecip_mm",
        "totalprecip_in",
        "totalsnow_cm",
        "avgvis_km",
        "avgvis_miles",
        "avghumidity",
        "daily_will_it_rain",
        "daily_chance_of_rain",
        "daily_will_it_snow",
        "daily_chance_of_snow",
        "condition",
        "uv"
})
public class DayWeatherDto {
    @JsonProperty("maxtemp_c")
    private Double maxTempC;
    @JsonProperty("maxtemp_f")
    private Double maxTempF;
    @JsonProperty("mintemp_c")
    private Double minTempC;
    @JsonProperty("mintemp_f")
    private Double minTempF;
    @JsonProperty("avgtemp_c")
    private Double avgTempC;
    @JsonProperty("avgtemp_f")
    private Double avgTempF;
    @JsonProperty("maxwind_mph")
    private Double maxWindMph;
    @JsonProperty("maxwind_kph")
    private Double maxWindKph;
    @JsonProperty("totalprecip_mm")
    private Double totalPrecipitationMm;
    @JsonProperty("totalprecip_in")
    private Double totalPrecipitationIn;
    @JsonProperty("totalsnow_cm")
    private Double totalSnowCm;
    @JsonProperty("avgvis_km")
    private Double avgVisKm;
    @JsonProperty("avgvis_miles")
    private Double avgVisMiles;
    @JsonProperty("avghumidity")
    private Double avgHumidity;
    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain;
    @JsonProperty("daily_chance_of_rain")
    private Integer dailyChanceOfRain;
    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow;
    @JsonProperty("daily_chance_of_snow")
    private Integer dailyChanceOfSnow;
    @JsonProperty("condition")
    private WeatherConditionDto condition;
    @JsonProperty("uv")
    private Double uv;

    @JsonProperty("maxtemp_c")
    public Double getMaxTempC() {
        return maxTempC;
    }

    @JsonProperty("maxtemp_c")
    public void setMaxTempC(Double maxTempC) {
        this.maxTempC = maxTempC;
    }

    @JsonProperty("maxtemp_f")
    public Double getMaxTempF() {
        return maxTempF;
    }

    @JsonProperty("maxtemp_f")
    public void setMaxTempF(Double maxTempF) {
        this.maxTempF = maxTempF;
    }

    @JsonProperty("mintemp_c")
    public Double getMinTempC() {
        return minTempC;
    }

    @JsonProperty("mintemp_c")
    public void setMinTempC(Double minTempC) {
        this.minTempC = minTempC;
    }

    @JsonProperty("mintemp_f")
    public Double getMinTempF() {
        return minTempF;
    }

    @JsonProperty("mintemp_f")
    public void setMinTempF(Double minTempF) {
        this.minTempF = minTempF;
    }

    @JsonProperty("avgtemp_c")
    public Double getAvgTempC() {
        return avgTempC;
    }

    @JsonProperty("avgtemp_c")
    public void setAvgTempC(Double avgTempC) {
        this.avgTempC = avgTempC;
    }

    @JsonProperty("avgtemp_f")
    public Double getAvgTempF() {
        return avgTempF;
    }

    @JsonProperty("avgtemp_f")
    public void setAvgTempF(Double avgTempF) {
        this.avgTempF = avgTempF;
    }

    @JsonProperty("maxwind_mph")
    public Double getMaxWindMph() {
        return maxWindMph;
    }

    @JsonProperty("maxwind_mph")
    public void setMaxWindMph(Double maxWindMph) {
        this.maxWindMph = maxWindMph;
    }

    @JsonProperty("maxwind_kph")
    public Double getMaxWindKph() {
        return maxWindKph;
    }

    @JsonProperty("maxwind_kph")
    public void setMaxWindKph(Double maxWindKph) {
        this.maxWindKph = maxWindKph;
    }

    @JsonProperty("totalprecip_mm")
    public Double getTotalPrecipitationMm() {
        return totalPrecipitationMm;
    }

    @JsonProperty("totalprecip_mm")
    public void setTotalPrecipitationMm(Double totalPrecipitationMm) {
        this.totalPrecipitationMm = totalPrecipitationMm;
    }

    @JsonProperty("totalprecip_in")
    public Double getTotalPrecipitationIn() {
        return totalPrecipitationIn;
    }

    @JsonProperty("totalprecip_in")
    public void setTotalPrecipitationIn(Double totalPrecipitationIn) {
        this.totalPrecipitationIn = totalPrecipitationIn;
    }

    @JsonProperty("totalsnow_cm")
    public Double getTotalSnowCm() {
        return totalSnowCm;
    }

    @JsonProperty("totalsnow_cm")
    public void setTotalSnowCm(Double totalSnowCm) {
        this.totalSnowCm = totalSnowCm;
    }

    @JsonProperty("avgvis_km")
    public Double getAvgVisKm() {
        return avgVisKm;
    }

    @JsonProperty("avgvis_km")
    public void setAvgVisKm(Double avgVisKm) {
        this.avgVisKm = avgVisKm;
    }

    @JsonProperty("avgvis_miles")
    public Double getAvgVisMiles() {
        return avgVisMiles;
    }

    @JsonProperty("avgvis_miles")
    public void setAvgVisMiles(Double avgVisMiles) {
        this.avgVisMiles = avgVisMiles;
    }

    @JsonProperty("avghumidity")
    public Double getAvgHumidity() {
        return avgHumidity;
    }

    @JsonProperty("avghumidity")
    public void setAvgHumidity(Double avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    @JsonProperty("daily_will_it_rain")
    public Integer getDailyWillItRain() {
        return dailyWillItRain;
    }

    @JsonProperty("daily_will_it_rain")
    public void setDailyWillItRain(Integer dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public Integer getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public void setDailyChanceOfRain(Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    @JsonProperty("daily_will_it_snow")
    public Integer getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    @JsonProperty("daily_will_it_snow")
    public void setDailyWillItSnow(Integer dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public Integer getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public void setDailyChanceOfSnow(Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    @JsonProperty("condition")
    public WeatherConditionDto getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(WeatherConditionDto condition) {
        this.condition = condition;
    }

    @JsonProperty("uv")
    public Double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
    }
}
