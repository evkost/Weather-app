package com.evkost.weatherapp.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "forecastday"
})
public class ForecastDto {
    @JsonProperty("forecastday")
    private List<ForecastDayDto> forecastDays;

    @JsonProperty("forecastday")
    public List<ForecastDayDto> getForecastDays() {
        return forecastDays;
    }

    @JsonProperty("forecastday")
    public void setForecastDays(List<ForecastDayDto> forecastDays) {
        this.forecastDays = forecastDays;
    }
}
