package com.evkost.weatherapp.model.response;

import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.ForecastDto;
import com.evkost.weatherapp.model.dto.LocationDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "location",
        "current",
        "forecast"
})
public class GetForecastResponse {
    @JsonProperty("location")
    private LocationDto location;
    @JsonProperty("current")
    private CurrentWeatherDto current;
    @JsonProperty("forecast")
    private ForecastDto forecast;

    @JsonProperty("location")
    public LocationDto getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(LocationDto location) {
        this.location = location;
    }

    @JsonProperty("current")
    public CurrentWeatherDto getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(CurrentWeatherDto current) {
        this.current = current;
    }

    @JsonProperty("forecast")
    public ForecastDto getForecast() {
        return forecast;
    }

    @JsonProperty("forecast")
    public void setForecast(ForecastDto forecast) {
        this.forecast = forecast;
    }
}