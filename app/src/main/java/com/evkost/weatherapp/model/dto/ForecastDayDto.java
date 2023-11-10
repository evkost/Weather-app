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
    private Astro astro;
    @JsonProperty("hour")
    private List<Hour> hour;

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
    public Day getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Day day) {
        this.day = day;
    }

    @JsonProperty("astro")
    public Astro getAstro() {
        return astro;
    }

    @JsonProperty("astro")
    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    @JsonProperty("hour")
    public List<Hour> getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }

}
