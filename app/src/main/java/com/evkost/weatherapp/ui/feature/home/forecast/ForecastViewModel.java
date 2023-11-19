package com.evkost.weatherapp.ui.feature.home.forecast;

import androidx.lifecycle.MutableLiveData;

import com.evkost.weatherapp.data.local.PreferencesManager;
import com.evkost.weatherapp.domain.FetchForecastDayUseCase;
import com.evkost.weatherapp.domain.ObserveForecastDayUseCase;
import com.evkost.weatherapp.ui.feature.common.BaseViewModel;
import com.evkost.weatherapp.ui.feature.common.Outcome;
import com.evkost.weatherapp.ui.feature.home.forecast.state.DatePanelState;
import com.evkost.weatherapp.ui.feature.home.forecast.state.ForecastDayInfoState;
import com.evkost.weatherapp.ui.feature.home.forecast.state.ForecastHoursListState;

import java.time.LocalDate;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@HiltViewModel
public class ForecastViewModel extends BaseViewModel<ForecastSideEffect> {
    private final MutableLiveData<DatePanelState> datePanelStateLiveData
            = new MutableLiveData<>();
    private final MutableLiveData<Outcome<ForecastDayInfoState>> forecastDayInfoStateLiveData
            = new MutableLiveData<>();
    private final MutableLiveData<Outcome<ForecastHoursListState>> forecastHoursListLiveData
            = new MutableLiveData<>();

    private final FetchForecastDayUseCase fetchForecastDayUseCase;
    private final ObserveForecastDayUseCase observeForecastDayUseCase;
    private final PreferencesManager preferencesManager;

    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public ForecastViewModel(
            FetchForecastDayUseCase fetchForecastDayUseCase,
            ObserveForecastDayUseCase observeForecastDayUseCase,
            PreferencesManager preferencesManager
    ) {
        this.fetchForecastDayUseCase = fetchForecastDayUseCase;
        this.observeForecastDayUseCase = observeForecastDayUseCase;
        this.preferencesManager = preferencesManager;
    }

    public void init() {

    }

    public void refreshAll() {

    }

    private void fetchData() {

    }
}
