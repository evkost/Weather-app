package com.evkost.weatherapp.domain.di;

import com.evkost.weatherapp.domain.FetchCurrentWeatherUseCase;
import com.evkost.weatherapp.domain.FetchForecastDayUseCase;
import com.evkost.weatherapp.domain.FormattedDateStringUseCase;
import com.evkost.weatherapp.domain.ObserveCurrentWeatherUseCase;
import com.evkost.weatherapp.domain.ObserveForecastDayUseCase;
import com.evkost.weatherapp.domain.impl.FetchCurrentWeatherUseCaseImpl;
import com.evkost.weatherapp.domain.impl.FetchForecastDayUseCaseImpl;
import com.evkost.weatherapp.domain.impl.FormattedDateStringUseCaseImpl;
import com.evkost.weatherapp.domain.impl.ObserveCurrentWeatherUseCaseImpl;
import com.evkost.weatherapp.domain.impl.ObserveForecastDayUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface DomainModule {
    @Binds
    FetchForecastDayUseCase provideFetchForecastDayUseCase(FetchForecastDayUseCaseImpl impl);

    @Binds
    FetchCurrentWeatherUseCase provideFetchCurrentWeatherUseCase(FetchCurrentWeatherUseCaseImpl impl);

    @Binds
    ObserveForecastDayUseCase provideObserveForecastDayUseCase(ObserveForecastDayUseCaseImpl impl);

    @Binds
    ObserveCurrentWeatherUseCase provideObserveCurrentWeatherUseCase(ObserveCurrentWeatherUseCaseImpl impl);

    @Binds
    FormattedDateStringUseCase bindFormattedDateStringUseCase(FormattedDateStringUseCaseImpl impl);
}
