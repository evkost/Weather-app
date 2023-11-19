package com.evkost.weatherapp.data.repository.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.local.ForecastDayLocalDataSource;
import com.evkost.weatherapp.data.remote.WeatherRemoteDataSource;
import com.evkost.weatherapp.data.repository.ForecastDayRepository;
import com.evkost.weatherapp.mapper.ForecastDayMapper;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class ForecastDayRepositoryImpl implements ForecastDayRepository {
    private final WeatherRemoteDataSource weatherRemoteDataSource;
    private final ForecastDayLocalDataSource forecastDayLocalDataSource;
    private final ForecastDayMapper forecastDayMapper;

    @Inject
    public ForecastDayRepositoryImpl(
            WeatherRemoteDataSource weatherRemoteDataSource,
            ForecastDayLocalDataSource forecastDayLocalDataSource,
            ForecastDayMapper forecastDayMapper
    ) {
        this.weatherRemoteDataSource = weatherRemoteDataSource;
        this.forecastDayLocalDataSource = forecastDayLocalDataSource;
        this.forecastDayMapper = forecastDayMapper;
    }

    @Override
    public Single<Result<List<ForecastDay>>> fetchByDate(String key, String region, Integer days, String date) {
        return weatherRemoteDataSource.getForecast(key, region, days, date, "no", "no")
                .map(result -> result.map(
                                forecastDto -> forecastDto.getForecastDays()
                                        .stream()
                                        .map(forecastDayMapper::dtoToDomain)
                                        .collect(Collectors.toList())
                        )
                );
    }

    @Override
    public Single<Long> save(ForecastDay forecastDay) {
        return forecastDayLocalDataSource.save(forecastDayMapper.domainToEntity(forecastDay));
    }

    @Override
    public Flowable<ForecastDay> observeByDate(String date) {
        return forecastDayLocalDataSource.observeByDate(date)
                .map(forecastDayMapper::entityToDomain);
    }
}
