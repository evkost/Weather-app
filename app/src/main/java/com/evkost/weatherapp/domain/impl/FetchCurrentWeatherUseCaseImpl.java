package com.evkost.weatherapp.domain.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.local.PreferencesManager;
import com.evkost.weatherapp.data.provider.WeatherApiKeyProvider;
import com.evkost.weatherapp.data.repository.CurrentWeatherRepository;
import com.evkost.weatherapp.domain.FetchCurrentWeatherUseCase;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class FetchCurrentWeatherUseCaseImpl implements FetchCurrentWeatherUseCase {
    private final CurrentWeatherRepository currentWeatherRepository;

    private final WeatherApiKeyProvider apiKeyProvider;

    private final PreferencesManager preferencesManager;

    @Inject
    public FetchCurrentWeatherUseCaseImpl(
            CurrentWeatherRepository currentWeatherRepository,
            WeatherApiKeyProvider apiKeyProvider,
            PreferencesManager preferencesManager) {
        this.currentWeatherRepository = currentWeatherRepository;
        this.apiKeyProvider = apiKeyProvider;
        this.preferencesManager = preferencesManager;
    }

    @Override
    public Single<Result<CurrentWeather>> invoke() {
        return preferencesManager.getSelectedRegionFlow()
                .firstOrError()
                .flatMap(region -> currentWeatherRepository.fetch(apiKeyProvider.getApiKey(), region))
                .doOnSuccess(result -> result.ifSuccess(currentWeather ->
                        currentWeatherRepository.save(currentWeather).subscribe()))
                .onErrorReturn(Result::exception);
    }
}
