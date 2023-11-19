package com.evkost.weatherapp.data.remote;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.ForecastDto;

import io.reactivex.rxjava3.core.Single;

public interface WeatherRemoteDataSource {
    Single<Result<CurrentWeatherDto>> getCurrentWeather(
            String key,
            String city,
            String aqi
    );

    Single<Result<ForecastDto>> getForecast(
            String key,
            String city,
            Integer days,
            String date,
            String includeAqi,
            String includeAlerts
    );
}
