package com.evkost.weatherapp.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "date_epoch",
        "day",
        "astro",
        "hour"
})
public class ForecastDayDto {

    @JsonProperty("date")
    private String date;
    @JsonProperty("date_epoch")
    private Integer dateEpoch;
    @JsonProperty("day")
    private DayWeatherDto day;
    @JsonProperty("astro")
    private AstroDto astro;
    @JsonProperty("hour")
    private List<ForecastHourDto> hour;

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_epoch")
    public Integer getDateEpoch() {
        return dateEpoch;
    }

    @JsonProperty("date_epoch")
    public void setDateEpoch(Integer dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    @JsonProperty("day")
    public DayWeatherDto getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(DayWeatherDto day) {
        this.day = day;
    }

    @JsonProperty("astro")
    public AstroDto getAstro() {
        return astro;
    }

    @JsonProperty("astro")
    public void setAstro(AstroDto astro) {
        this.astro = astro;
    }

    @JsonProperty("hour")
    public List<ForecastHourDto> getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(List<ForecastHourDto> hour) {
        this.hour = hour;
    }

}
