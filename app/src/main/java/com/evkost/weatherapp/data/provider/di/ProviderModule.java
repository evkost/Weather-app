package com.evkost.weatherapp.data.provider.di;

import com.evkost.weatherapp.data.provider.WeatherApiKeyProvider;
import com.evkost.weatherapp.data.provider.impl.BuildConfigApiKeyProvider;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface ProviderModule {
    @Binds
    WeatherApiKeyProvider bindWeatherApiKeyProvider(BuildConfigApiKeyProvider impl);
}
