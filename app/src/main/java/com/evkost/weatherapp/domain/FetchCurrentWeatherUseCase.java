package com.evkost.weatherapp.domain;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import io.reactivex.rxjava3.core.Single;

public interface FetchCurrentWeatherUseCase {
    Single<Result<CurrentWeather>> invoke();
}
