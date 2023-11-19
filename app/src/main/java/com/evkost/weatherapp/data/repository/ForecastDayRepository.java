package com.evkost.weatherapp.data.repository;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface ForecastDayRepository {
    Single<Result<List<ForecastDay>>> fetchByDate(String key, String region, Integer days, String date);

    Single<Long> save(ForecastDay forecastDay);

    Flowable<ForecastDay> observeByDate(String date);
}
