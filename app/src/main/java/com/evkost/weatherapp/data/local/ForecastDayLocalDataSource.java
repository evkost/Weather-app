package com.evkost.weatherapp.data.local;

import com.evkost.weatherapp.model.entity.ForecastDayEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface ForecastDayLocalDataSource {
    Single<Long> save(ForecastDayEntity entity);

    Flowable<ForecastDayEntity> observeByDate(String date);
}
