package com.evkost.weatherapp.domain;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import io.reactivex.rxjava3.core.Flowable;

public interface ObserveCurrentWeatherUseCase {
    Flowable<Result<CurrentWeather>> invoke(boolean fetch);
}
