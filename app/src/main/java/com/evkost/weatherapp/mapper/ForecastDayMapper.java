package com.evkost.weatherapp.mapper;

import com.evkost.weatherapp.model.domain.ForecastDay;
import com.evkost.weatherapp.model.dto.ForecastDayDto;
import com.evkost.weatherapp.model.entity.ForecastDayEntity;

public interface ForecastDayMapper {
    ForecastDayEntity domainToEntity(ForecastDay dto);
    ForecastDay dtoToDomain(ForecastDayDto dto);
    ForecastDay entityToDomain(ForecastDayEntity dto);
}
