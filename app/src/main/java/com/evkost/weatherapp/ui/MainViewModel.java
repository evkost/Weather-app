package com.evkost.weatherapp.ui;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.evkost.weatherapp.ui.feature.common.BaseViewModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

@HiltViewModel
public class MainViewModel extends BaseViewModel<MainSideEffect> {
    private final MutableLiveData<MainUiState> mainUiStateLiveData = new MutableLiveData<>(new MainUiState(false));

    @Inject
    public MainViewModel() {

        init();
    }


    @SuppressLint("CheckResult")
    private void init() {
        Single.timer(0, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(__ -> {
                    update(mainUiStateLiveData, state -> state.setIsLoaded(true));
                    sendSideEffect(new MainSideEffect(MainSideEffect.Destination.HOME));
                });
    }

    public MutableLiveData<MainUiState> getMainUiStateLiveData() {
        return mainUiStateLiveData;
    }
}
