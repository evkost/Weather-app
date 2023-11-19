package com.evkost.weatherapp.data.repository.di;

import com.evkost.weatherapp.data.repository.CurrentWeatherRepository;
import com.evkost.weatherapp.data.repository.ForecastDayRepository;
import com.evkost.weatherapp.data.repository.impl.CurrentWeatherRepositoryImpl;
import com.evkost.weatherapp.data.repository.impl.ForecastDayRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface RepositoryModule {
    @Binds
    CurrentWeatherRepository bindCurrentWeatherRepository(CurrentWeatherRepositoryImpl impl);

    @Binds
    ForecastDayRepository bindForecastDayRepository(ForecastDayRepositoryImpl impl);
}
