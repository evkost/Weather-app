package com.evkost.weatherapp.data.provider.impl;

import com.evkost.weatherapp.BuildConfig;
import com.evkost.weatherapp.data.provider.WeatherApiKeyProvider;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class BuildConfigApiKeyProvider implements WeatherApiKeyProvider {
    @Inject
    public BuildConfigApiKeyProvider() {}

    @Override
    public String getApiKey() {
        return BuildConfig.WEATHER_API_KEY;
    }
}
