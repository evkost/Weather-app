package com.evkost.weatherapp.mapper.impl;

import com.evkost.weatherapp.mapper.ForecastHourMapper;
import com.evkost.weatherapp.model.domain.ForecastHour;
import com.evkost.weatherapp.model.dto.ForecastHourDto;
import com.evkost.weatherapp.model.entity.ForecastHourEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ForecastHourMapperImpl implements ForecastHourMapper {
    private final DateTimeFormatter dateTimeFormatter;

    @Inject
    public ForecastHourMapperImpl(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public ForecastHourEntity domainToEntity(ForecastHour dto) {
        ForecastHourEntity entity = new ForecastHourEntity();
        entity.setTempC(dto.getTempC());
        entity.setConditionCode(dto.getConditionCode());
        entity.setWindMph(dto.getWindMph());
        entity.setWindDegree(dto.getWindDegree());
        entity.setWindDir(dto.getWindDir());
        entity.setPressureMb(dto.getPressureMb());
        entity.setPrecipitationMm(dto.getPrecipitationMm());
        entity.setHumidity(dto.getHumidity());
        entity.setCloud(dto.getCloud());
        entity.setFeelsLikeC(dto.getFeelsLikeC());
        entity.setChanceOfRain(dto.getChanceOfRain());
        entity.setChanceOfSnow(dto.getChanceOfSnow());
        entity.setTime(dto.getTime().toString());
        return entity;
    }

    @Override
    public ForecastHour dtoToDomain(ForecastHourDto dto) {
        ForecastHour forecastHour = new ForecastHour();
        forecastHour.setTempC(dto.getTempC());
        forecastHour.setConditionCode(dto.getCondition().getCode());
        forecastHour.setWindMph(dto.getWindMph());
        forecastHour.setWindDegree(dto.getWindDegree());
        forecastHour.setWindDir(dto.getWindDir());
        forecastHour.setPressureMb(dto.getPressureMb());
        forecastHour.setPrecipitationMm(dto.getPrecipitationMm());
        forecastHour.setHumidity(dto.getHumidity());
        forecastHour.setCloud(dto.getCloud());
        forecastHour.setFeelsLikeC(dto.getFeelsLikeC());
        forecastHour.setChanceOfRain(dto.getChanceOfRain());
        forecastHour.setChanceOfSnow(dto.getChanceOfSnow());
        forecastHour.setTime(LocalDateTime.parse(dto.getTime(), dateTimeFormatter).toLocalTime());
        return forecastHour;
    }

    @Override
    public ForecastHour entityToDomain(ForecastHourEntity entity) {
        ForecastHour forecastHour = new ForecastHour();
        forecastHour.setTempC(entity.getTempC());
        forecastHour.setConditionCode(entity.getConditionCode());
        forecastHour.setWindMph(entity.getWindMph());
        forecastHour.setWindDegree(entity.getWindDegree());
        forecastHour.setWindDir(entity.getWindDir());
        forecastHour.setPressureMb(entity.getPressureMb());
        forecastHour.setPrecipitationMm(entity.getPrecipitationMm());
        forecastHour.setHumidity(entity.getHumidity());
        forecastHour.setCloud(entity.getCloud());
        forecastHour.setFeelsLikeC(entity.getFeelsLikeC());
        forecastHour.setChanceOfRain(entity.getChanceOfRain());
        forecastHour.setChanceOfSnow(entity.getChanceOfSnow());
        forecastHour.setTime(LocalTime.parse(entity.getTime()));

        return forecastHour;
    }
}
