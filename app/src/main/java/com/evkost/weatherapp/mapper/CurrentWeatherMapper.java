package com.evkost.weatherapp.mapper;

import com.evkost.weatherapp.model.domain.CurrentWeather;
import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;

public interface CurrentWeatherMapper {
    CurrentWeatherEntity domainToEntity(CurrentWeather dto);
    CurrentWeather dtoToDomain(CurrentWeatherDto dto);
    CurrentWeather entityToDomain(CurrentWeatherEntity dto);
}
