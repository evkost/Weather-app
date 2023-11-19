package com.evkost.weatherapp.mapper.impl;

import com.evkost.weatherapp.mapper.ForecastDayMapper;
import com.evkost.weatherapp.mapper.ForecastHourMapper;
import com.evkost.weatherapp.model.domain.ForecastDay;
import com.evkost.weatherapp.model.dto.ForecastDayDto;
import com.evkost.weatherapp.model.entity.ForecastDayEntity;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ForecastDayMapperImpl implements ForecastDayMapper {
    private final ForecastHourMapper forecastHourMapper;

    @Inject
    public ForecastDayMapperImpl(ForecastHourMapper forecastHourMapper) {
        this.forecastHourMapper = forecastHourMapper;
    }

    @Override
    public ForecastDayEntity domainToEntity(ForecastDay dto) {
        ForecastDayEntity entity = new ForecastDayEntity();
        entity.setMaxTempC(dto.getMaxTempC());
        entity.setMinTempC(dto.getMinTempC());
        entity.setMaxWindMph(dto.getMaxWindMph());
        entity.setTotalPrecipitationMm(dto.getTotalPrecipitationMm());
        entity.setTotalSnowCm(dto.getTotalSnowCm());
        entity.setAvgHumidity(dto.getAvgHumidity());
        entity.setDailyChanceOfRain(dto.getDailyChanceOfRain());
        entity.setDailyChanceOfSnow(dto.getDailyChanceOfSnow());
        entity.setConditionCode(dto.getConditionCode());
        entity.setDate(dto.getDate().toString());
        entity.setForecastHours(
                dto.getForecastHours()
                        .stream()
                        .map(forecastHourMapper::domainToEntity)
                        .collect(Collectors.toList())
        );

        return entity;
    }

    @Override
    public ForecastDay dtoToDomain(ForecastDayDto dto) {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setMaxTempC(dto.getDay().getMaxTempC());
        forecastDay.setMinTempC(dto.getDay().getMinTempC());
        forecastDay.setMaxWindMph(dto.getDay().getMaxWindMph());
        forecastDay.setTotalPrecipitationMm(dto.getDay().getTotalPrecipitationMm());
        forecastDay.setTotalSnowCm(dto.getDay().getTotalSnowCm());
        forecastDay.setAvgHumidity(dto.getDay().getAvgHumidity());
        forecastDay.setDailyChanceOfRain(dto.getDay().getDailyChanceOfRain());
        forecastDay.setDailyChanceOfSnow(dto.getDay().getDailyChanceOfSnow());
        forecastDay.setConditionCode(dto.getDay().getCondition().getCode());
        forecastDay.setDate(LocalDate.parse(dto.getDate()));
        forecastDay.setForecastHours(
                dto.getHour()
                        .stream()
                        .map(forecastHourMapper::dtoToDomain)
                        .collect(Collectors.toList())
        );

        return forecastDay;
    }

    @Override
    public ForecastDay entityToDomain(ForecastDayEntity entity) {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setMaxTempC(entity.getMaxTempC());
        forecastDay.setMinTempC(entity.getMinTempC());
        forecastDay.setMaxWindMph(entity.getMaxWindMph());
        forecastDay.setTotalPrecipitationMm(entity.getTotalPrecipitationMm());
        forecastDay.setTotalSnowCm(entity.getTotalSnowCm());
        forecastDay.setAvgHumidity(entity.getAvgHumidity());
        forecastDay.setDailyChanceOfRain(entity.getDailyChanceOfRain());
        forecastDay.setDailyChanceOfSnow(entity.getDailyChanceOfSnow());
        forecastDay.setConditionCode(entity.getConditionCode());
        forecastDay.setDate(LocalDate.parse(entity.getDate()));
        forecastDay.setForecastHours(
                entity.getForecastHours()
                        .stream()
                        .map(forecastHourMapper::entityToDomain)
                        .collect(Collectors.toList())
        );

        return forecastDay;
    }
}
