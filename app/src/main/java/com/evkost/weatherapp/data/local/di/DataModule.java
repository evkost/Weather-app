package com.evkost.weatherapp.data.local.di;

import com.evkost.weatherapp.data.local.CurrentWeatherLocalDataSource;
import com.evkost.weatherapp.data.local.ForecastDayLocalDataSource;
import com.evkost.weatherapp.data.local.PreferencesManager;
import com.evkost.weatherapp.data.local.database.SQLiteCurrentWeatherLocalDataSource;
import com.evkost.weatherapp.data.local.database.SQLiteForecastDayLocalDataSource;
import com.evkost.weatherapp.data.local.datastore.DataStorePreferencesManager;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface DataModule {
    @Binds
    CurrentWeatherLocalDataSource bindCurrentWeatherLocalDataSource(
            SQLiteCurrentWeatherLocalDataSource impl
    );

    @Binds
    ForecastDayLocalDataSource bindForecastDayLocalDataSource(
            SQLiteForecastDayLocalDataSource impl
    );

    @Binds
    PreferencesManager bindPreferencesManager(
            DataStorePreferencesManager impl
    );
}
