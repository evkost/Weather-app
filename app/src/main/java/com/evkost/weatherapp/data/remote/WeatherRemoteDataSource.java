package com.evkost.weatherapp.data.remote;

import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.ForecastDto;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;

public interface WeatherRemoteDataSource {
    Single<Response<CurrentWeatherDto>> getCurrentWeather(
            String key,
            String city,
            String aqi
    );

    Single<Response<ForecastDto>> getForecast(
            String key,
            String city,
            Integer days,
            String includeAqi,
            String includeAlerts
    );
}
