package com.evkost.weatherapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.subjects.PublishSubject;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final MutableLiveData<MainUiState> uiState = new MutableLiveData<>(new MainUiState(false, null));

    @Inject
    public MainViewModel() {

        init();
    }

    private void init() {

    }

    public void navActionApplied() {
        uiState.setValue(new MainUiState(true, null));
    }

    public LiveData<MainUiState> getUiState() {
        return this.uiState;
    }
}
