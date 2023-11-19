package com.evkost.weatherapp.domain;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.CurrentWeather;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.time.LocalDate;

import io.reactivex.rxjava3.core.Flowable;

public interface ObserveForecastDayUseCase {
    Flowable<Result<ForecastDay>> invoke(boolean fetch, LocalDate date);
}
