package com.evkost.weatherapp.model.response;

import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.LocationDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "location",
        "current"
})
public class GetCurrentWeatherResponse {

    @JsonProperty("location")
    private LocationDto location;
    @JsonProperty("current")
    private CurrentWeatherDto currentWeather;

    @JsonProperty("location")
    public LocationDto getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(LocationDto location) {
        this.location = location;
    }

    @JsonProperty("current")
    public CurrentWeatherDto getCurrentWeather() {
        return currentWeather;
    }

    @JsonProperty("current")
    public void setCurrentWeather(CurrentWeatherDto currentWeather) {
        this.currentWeather = currentWeather;
    }
}
