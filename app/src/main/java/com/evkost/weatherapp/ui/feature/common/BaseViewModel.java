package com.evkost.weatherapp.ui.feature.common;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.reactivex.rxjava3.subjects.PublishSubject;

public abstract class BaseViewModel<SE> extends ViewModel {
    private final MutableLiveData<SE> sideEffectLiveData = new MutableLiveData<>();

    public MutableLiveData<SE> getSideEffectLiveData() {
        return sideEffectLiveData;
    }

    @MainThread
    protected <S> void update(MutableLiveData<S> liveData, Function<S, S> function) {
        liveData.setValue(function.apply(liveData.getValue()));
    }

    @MainThread
    protected void sendSideEffect(SE sideEffect) {
        sideEffectLiveData.setValue(sideEffect);
    }

    @MainThread
    public final void sideEffectAccepted() {
        sideEffectLiveData.setValue(null);
    }
}
