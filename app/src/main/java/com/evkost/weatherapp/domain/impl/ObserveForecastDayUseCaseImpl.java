package com.evkost.weatherapp.domain.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.local.PreferencesManager;
import com.evkost.weatherapp.data.provider.WeatherApiKeyProvider;
import com.evkost.weatherapp.data.repository.ForecastDayRepository;
import com.evkost.weatherapp.domain.FetchForecastDayUseCase;
import com.evkost.weatherapp.domain.FormattedDateStringUseCase;
import com.evkost.weatherapp.domain.ObserveForecastDayUseCase;
import com.evkost.weatherapp.model.domain.CurrentWeather;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.time.LocalDate;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class ObserveForecastDayUseCaseImpl implements ObserveForecastDayUseCase {
    private final ForecastDayRepository forecastDayRepository;

    private final FetchForecastDayUseCase fetchForecastDayUseCase;

    private final FormattedDateStringUseCase formattedDateStringUseCase;

    @Inject
    public ObserveForecastDayUseCaseImpl(
            ForecastDayRepository forecastDayRepository,
            FetchForecastDayUseCase fetchForecastDayUseCase,
            FormattedDateStringUseCase formattedDateStringUseCase
    ) {
        this.forecastDayRepository = forecastDayRepository;
        this.fetchForecastDayUseCase = fetchForecastDayUseCase;
        this.formattedDateStringUseCase = formattedDateStringUseCase;
    }

    @Override
    public Flowable<Result<ForecastDay>> invoke(boolean fetch, LocalDate date) {
        return //Flowable.concat(
                //fetch ? fetchForecastDayUseCase.invoke(date).toFlowable() : Flowable.empty(),
                forecastDayRepository.observeByDate(formattedDateStringUseCase.invoke(date))
                        .map(Result::success)
       // )
                .distinctUntilChanged()
                .onErrorReturn(Result::exception);
    }
}
