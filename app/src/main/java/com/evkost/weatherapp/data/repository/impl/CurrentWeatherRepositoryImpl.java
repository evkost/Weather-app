package com.evkost.weatherapp.data.repository.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.local.CurrentWeatherLocalDataSource;
import com.evkost.weatherapp.data.remote.WeatherRemoteDataSource;
import com.evkost.weatherapp.data.repository.CurrentWeatherRepository;
import com.evkost.weatherapp.mapper.CurrentWeatherMapper;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class CurrentWeatherRepositoryImpl implements CurrentWeatherRepository {
    private final WeatherRemoteDataSource weatherRemoteDataSource;
    private final CurrentWeatherLocalDataSource currentWeatherLocalDataSource;
    private final CurrentWeatherMapper currentWeatherMapper;

    @Inject
    public CurrentWeatherRepositoryImpl(
            WeatherRemoteDataSource weatherRemoteDataSource,
            CurrentWeatherLocalDataSource currentWeatherLocalDataSource,
            CurrentWeatherMapper currentWeatherMapper) {
        this.weatherRemoteDataSource = weatherRemoteDataSource;
        this.currentWeatherLocalDataSource = currentWeatherLocalDataSource;
        this.currentWeatherMapper = currentWeatherMapper;
    }

    @Override
    public Single<Result<CurrentWeather>> fetch(String key, String region) {
        return weatherRemoteDataSource.getCurrentWeather(key, region, "no")
                .map(result -> result.map(currentWeatherMapper::dtoToDomain));
    }

    @Override
    public Single<Long> save(CurrentWeather currentWeather) {
        return currentWeatherLocalDataSource.save(currentWeatherMapper.domainToEntity(currentWeather));
    }

    @Override
    public Flowable<CurrentWeather> observeByDate(String date) {
        return currentWeatherLocalDataSource.observeByDate(date)
                .map(currentWeatherMapper::entityToDomain);
    }
}
