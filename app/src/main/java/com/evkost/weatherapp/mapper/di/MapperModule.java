package com.evkost.weatherapp.mapper.di;

import com.evkost.weatherapp.mapper.CurrentWeatherMapper;
import com.evkost.weatherapp.mapper.ForecastDayMapper;
import com.evkost.weatherapp.mapper.ForecastHourMapper;
import com.evkost.weatherapp.mapper.impl.CurrentWeatherMapperImpl;
import com.evkost.weatherapp.mapper.impl.ForecastDayMapperImpl;
import com.evkost.weatherapp.mapper.impl.ForecastHourMapperImpl;

import java.time.format.DateTimeFormatter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class MapperModule {
    @Provides
    @Singleton
    public static DateTimeFormatter provideDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    @Binds
    abstract CurrentWeatherMapper bindCurrentWeatherMapper(CurrentWeatherMapperImpl impl);

    @Binds
    abstract ForecastDayMapper bindForecastDayMapper(ForecastDayMapperImpl impl);

    @Binds
    abstract ForecastHourMapper dindForecastHourMapper(ForecastHourMapperImpl impl);
}
