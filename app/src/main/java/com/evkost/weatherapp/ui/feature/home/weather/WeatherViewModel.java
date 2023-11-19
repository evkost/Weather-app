package com.evkost.weatherapp.ui.feature.home.weather;

import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.evkost.weatherapp.domain.FetchCurrentWeatherUseCase;
import com.evkost.weatherapp.domain.FetchForecastDayUseCase;
import com.evkost.weatherapp.domain.ObserveCurrentWeatherUseCase;
import com.evkost.weatherapp.domain.ObserveForecastDayUseCase;
import com.evkost.weatherapp.model.domain.CurrentWeather;
import com.evkost.weatherapp.model.domain.ForecastDay;
import com.evkost.weatherapp.model.domain.ForecastHour;
import com.evkost.weatherapp.ui.feature.common.BaseViewModel;
import com.evkost.weatherapp.ui.feature.common.Outcome;
import com.evkost.weatherapp.ui.feature.home.weather.state.CurrentWeatherCardState;
import com.evkost.weatherapp.ui.feature.home.weather.state.ForecastHourCardState;
import com.evkost.weatherapp.ui.feature.home.weather.state.TodayForecastState;
import com.evkost.weatherapp.ui.feature.home.weather.state.WeatherUiState;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class WeatherViewModel extends BaseViewModel<WeatherSideEffect> {
    private final MutableLiveData<WeatherUiState> weatherUiStateLiveData
            = new MutableLiveData<>(new WeatherUiState().setRefreshing(false));

    private final MutableLiveData<Outcome<CurrentWeatherCardState>> currentWeatherCardLiveData
            = new MutableLiveData<>(Outcome.loading());

    private final MutableLiveData<Outcome<TodayForecastState>> todayForecastCardLiveData
            = new MutableLiveData<>(Outcome.loading());

    private final ObserveCurrentWeatherUseCase observeCurrentWeatherUseCase;
    private final FetchCurrentWeatherUseCase fetchCurrentWeatherUseCase;
    private final ObserveForecastDayUseCase observeForecastDayUseCase;
    private final FetchForecastDayUseCase fetchForecastDayUseCase;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public WeatherViewModel(
            FetchCurrentWeatherUseCase fetchCurrentWeatherUseCase,
            ObserveCurrentWeatherUseCase observeCurrentWeatherUseCase,
            ObserveForecastDayUseCase observeForecastDayUseCase,
            FetchForecastDayUseCase fetchForecastDayUseCase
    ) {
        this.fetchCurrentWeatherUseCase = fetchCurrentWeatherUseCase;
        this.observeCurrentWeatherUseCase = observeCurrentWeatherUseCase;
        this.observeForecastDayUseCase = observeForecastDayUseCase;
        this.fetchForecastDayUseCase = fetchForecastDayUseCase;
    }

    public void init() {
        compositeDisposable.add(
                observeCurrentWeatherUseCase.invoke(true)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(result -> Outcome.fromResultMapping(result, this::mapToState))
                        .subscribe(outcome -> updateAndNotifyIfError(currentWeatherCardLiveData, outcome))
        );

        compositeDisposable.add(
                observeForecastDayUseCase.invoke(true, LocalDate.now())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(result -> Outcome.fromResultMapping(result, this::mapToState))
                        .subscribe(outcome -> updateAndNotifyIfError(todayForecastCardLiveData, outcome))
        );

        refreshAll(false);
    }

    public void refreshAll() {
        refreshAll(true);
    }

    private void refreshAll(boolean showRefreshing) {
        update(weatherUiStateLiveData, state -> state.setRefreshing(showRefreshing));
        compositeDisposable.add(
                Single.zip(
                        fetchCurrentWeatherUseCase.invoke()
                                .map(result -> Outcome.fromResultMapping(result, this::mapToState)),
                        fetchForecastDayUseCase.invoke(LocalDate.now())
                                .map(result -> Outcome.fromResultMapping(result, this::mapToState)),
                        Pair::create
                )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(pair -> {
                            update(weatherUiStateLiveData, state -> state.setRefreshing(false));

                            if (pair.first.isError()) {
                                sendSideEffect(new WeatherSideEffect(pair.first.getErrorMessage()));
                                return;
                            }
                            if (pair.second.isError()) {
                                sendSideEffect(new WeatherSideEffect(pair.second.getErrorMessage()));
                            }
                        })
        );
    }

    private <T> void updateAndNotifyIfError(MutableLiveData<Outcome<T>> liveData, Outcome<T> outcome) {
        liveData.setValue(outcome);
        outcome.ifError(errorMessage -> sendSideEffect(new WeatherSideEffect(errorMessage)));
    }


    private CurrentWeatherCardState mapToState(CurrentWeather currentWeather) {
        CurrentWeatherCardState state = new CurrentWeatherCardState();
        state.setConditionCode(currentWeather.getConditionCode());
        state.setTempC(currentWeather.getTempC());
        state.setFeelsLikeTempC(currentWeather.getFeelsLikeC());
        return state;
    }

    private TodayForecastState mapToState(ForecastDay forecastDay) {
        TodayForecastState state = new TodayForecastState();
        state.setForecastCardStates(
                forecastDay.getForecastHours()
                        .stream()
                        .map(this::mapToState)
                        .collect(Collectors.toList())
        );
        return state;
    }

    private ForecastHourCardState mapToState(ForecastHour forecastHour) {
        ForecastHourCardState state = new ForecastHourCardState();
        state.setConditionCode(forecastHour.getConditionCode());
        state.setTempC(forecastHour.getTempC());
        state.setFeelsLikeC(forecastHour.getFeelsLikeC());
        return state;
    }

    public LiveData<WeatherUiState> getWeatherUiStateLiveData() {
        return weatherUiStateLiveData;
    }

    public LiveData<Outcome<CurrentWeatherCardState>> getCurrentWeatherCardLiveData() {
        return currentWeatherCardLiveData;
    }

    public LiveData<Outcome<TodayForecastState>> getTodayForecastCardLiveData() {
        return todayForecastCardLiveData;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
    }
}
