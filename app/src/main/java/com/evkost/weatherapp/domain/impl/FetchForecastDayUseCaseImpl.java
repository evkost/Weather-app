package com.evkost.weatherapp.domain.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.local.PreferencesManager;
import com.evkost.weatherapp.data.provider.WeatherApiKeyProvider;
import com.evkost.weatherapp.data.repository.ForecastDayRepository;
import com.evkost.weatherapp.domain.FetchForecastDayUseCase;
import com.evkost.weatherapp.domain.FormattedDateStringUseCase;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.time.LocalDate;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class FetchForecastDayUseCaseImpl implements FetchForecastDayUseCase {
    private final ForecastDayRepository forecastDayRepository;

    private final WeatherApiKeyProvider apiKeyProvider;

    private final PreferencesManager preferencesManager;

    private final FormattedDateStringUseCase formattedDateStringUseCase;

    @Inject
    public FetchForecastDayUseCaseImpl(
            ForecastDayRepository forecastDayRepository,
            WeatherApiKeyProvider apiKeyProvider,
            PreferencesManager preferencesManager,
            FormattedDateStringUseCase formattedDateStringUseCase) {
        this.forecastDayRepository = forecastDayRepository;
        this.apiKeyProvider = apiKeyProvider;
        this.preferencesManager = preferencesManager;
        this.formattedDateStringUseCase = formattedDateStringUseCase;
    }

    @Override
    public Single<Result<ForecastDay>> invoke(LocalDate date) {
        return preferencesManager.getSelectedRegionFlow()
                .firstOrError()
                .flatMap(region -> forecastDayRepository
                        .fetchByDate(
                                apiKeyProvider.getApiKey(),
                                region,
                                1,
                                formattedDateStringUseCase.invoke(date)
                        )
                        .map(result -> result.map(forecastDays -> forecastDays.get(0)))
                )
                .doOnSuccess(result -> result.ifSuccess(forecastDayRepository::save))
                .onErrorReturn(Result::exception);
    }
}
