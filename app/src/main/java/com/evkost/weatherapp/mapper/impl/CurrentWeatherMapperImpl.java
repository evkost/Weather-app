package com.evkost.weatherapp.mapper.impl;

import com.evkost.weatherapp.mapper.CurrentWeatherMapper;
import com.evkost.weatherapp.model.domain.CurrentWeather;
import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

public class CurrentWeatherMapperImpl implements CurrentWeatherMapper {
    private final DateTimeFormatter dateTimeFormatter;

    @Inject
    public CurrentWeatherMapperImpl(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public CurrentWeatherEntity domainToEntity(CurrentWeather dto) {
        CurrentWeatherEntity entity = new CurrentWeatherEntity();
        entity.setTempC(dto.getTempC());
        entity.setWindMph(dto.getWindMph());
        entity.setWindDegree(dto.getWindDegree());
        entity.setWindDir(dto.getWindDir());
        entity.setPressureMb(dto.getPressureMb());
        entity.setPrecipitationMm(dto.getPrecipitationMm());
        entity.setHumidity(dto.getHumidity());
        entity.setCloud(dto.getCloud());
        entity.setFeelsLikeC(dto.getFeelsLikeC());
        entity.setLastUpdated(dto.getLastUpdated().toString());
        entity.setDate(dto.getDate().toString());
        entity.setConditionCode(dto.getConditionCode());
        return entity;
    }

    @Override
    public CurrentWeather dtoToDomain(CurrentWeatherDto dto) {
        CurrentWeather weather = new CurrentWeather();
        weather.setTempC(dto.getTempC());
        weather.setWindMph(dto.getWindMph());
        weather.setWindDegree(dto.getWindDegree());
        weather.setWindDir(dto.getWindDir());
        weather.setPressureMb(dto.getPressureMb());
        weather.setPrecipitationMm(dto.getPrecipitationMm());
        weather.setHumidity(dto.getHumidity());
        weather.setCloud(dto.getCloud());
        weather.setFeelsLikeC(dto.getFeelsLikeC());
        weather.setConditionCode(dto.getCondition().getCode());
        weather.setDate(LocalDate.parse(dto.getLastUpdated(), dateTimeFormatter));
        weather.setLastUpdated(LocalDateTime.parse(dto.getLastUpdated(), dateTimeFormatter));
        return weather;
    }

    @Override
    public CurrentWeather entityToDomain(CurrentWeatherEntity entity) {
        CurrentWeather weather = new CurrentWeather();
        weather.setTempC(entity.getTempC());
        weather.setWindMph(entity.getWindMph());
        weather.setWindDegree(entity.getWindDegree());
        weather.setWindDir(entity.getWindDir());
        weather.setPressureMb(entity.getPressureMb());
        weather.setPrecipitationMm(entity.getPrecipitationMm());
        weather.setHumidity(entity.getHumidity());
        weather.setCloud(entity.getCloud());
        weather.setFeelsLikeC(entity.getFeelsLikeC());
        weather.setConditionCode(entity.getConditionCode());
        weather.setDate(LocalDate.parse(entity.getDate()));
        weather.setLastUpdated(LocalDateTime.parse(entity.getLastUpdated()));
        return weather;
    }
}
