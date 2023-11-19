package com.evkost.weatherapp.data.local;

import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface CurrentWeatherLocalDataSource {
    Single<Long> save(CurrentWeatherEntity entity);

    Flowable<CurrentWeatherEntity> observeByDate(String date);
}
