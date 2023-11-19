package com.evkost.weatherapp.data.repository;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface CurrentWeatherRepository {
    Single<Result<CurrentWeather>> fetch(String key, String region);

    Single<Long> save(CurrentWeather currentWeather);

    Flowable<CurrentWeather> observeByDate(String date);
}
