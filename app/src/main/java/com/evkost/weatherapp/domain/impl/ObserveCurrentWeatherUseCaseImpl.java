package com.evkost.weatherapp.domain.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.repository.CurrentWeatherRepository;
import com.evkost.weatherapp.domain.FetchCurrentWeatherUseCase;
import com.evkost.weatherapp.domain.FormattedDateStringUseCase;
import com.evkost.weatherapp.domain.ObserveCurrentWeatherUseCase;
import com.evkost.weatherapp.model.domain.CurrentWeather;

import java.time.LocalDate;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class ObserveCurrentWeatherUseCaseImpl implements ObserveCurrentWeatherUseCase {

    private final CurrentWeatherRepository currentWeatherRepository;

    private final FetchCurrentWeatherUseCase fetchCurrentWeatherUseCase;

    private final FormattedDateStringUseCase formattedDateStringUseCase;

    @Inject
    public ObserveCurrentWeatherUseCaseImpl(
            CurrentWeatherRepository currentWeatherRepository,
            FetchCurrentWeatherUseCase fetchCurrentWeatherUseCase,
            FormattedDateStringUseCase formattedDateStringUseCase
    ) {
        this.currentWeatherRepository = currentWeatherRepository;
        this.fetchCurrentWeatherUseCase = fetchCurrentWeatherUseCase;
        this.formattedDateStringUseCase = formattedDateStringUseCase;
    }

    @Override
    public Flowable<Result<CurrentWeather>> invoke(boolean fetch) {
        return// Flowable.concat(
                //fetch ? fetchCurrentWeatherUseCase.invoke().toFlowable() : Flowable.empty(),
                currentWeatherRepository.observeByDate(formattedDateStringUseCase.invoke(LocalDate.now()))
                        .map(Result::success)
        //)
                .distinctUntilChanged()
                .onErrorReturn(Result::exception);
    }
}
