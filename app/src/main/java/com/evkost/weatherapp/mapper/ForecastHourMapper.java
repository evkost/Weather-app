package com.evkost.weatherapp.mapper;

import com.evkost.weatherapp.model.domain.ForecastHour;
import com.evkost.weatherapp.model.dto.ForecastHourDto;
import com.evkost.weatherapp.model.entity.ForecastHourEntity;

public interface ForecastHourMapper {
    ForecastHourEntity domainToEntity(ForecastHour dto);
    ForecastHour dtoToDomain(ForecastHourDto dto);
    ForecastHour entityToDomain(ForecastHourEntity dto);
}
