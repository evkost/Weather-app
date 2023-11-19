package com.evkost.weatherapp.domain;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.model.domain.ForecastDay;

import java.time.LocalDate;

import io.reactivex.rxjava3.core.Single;

public interface FetchForecastDayUseCase {
    Single<Result<ForecastDay>> invoke(LocalDate date);
}
