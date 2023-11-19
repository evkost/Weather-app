package com.evkost.weatherapp.data.remote.di;

import com.evkost.weatherapp.data.remote.WeatherRemoteDataSource;
import com.evkost.weatherapp.data.remote.impl.RetrofitWeatherRemoteDataSource;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface RemoteModule {
    @Binds
    WeatherRemoteDataSource bindWeatherRemoteDataSource(RetrofitWeatherRemoteDataSource impl);
}
