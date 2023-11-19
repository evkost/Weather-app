package com.evkost.weatherapp.ui;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

class MainUiState {
    private Boolean isLoaded;

    public MainUiState(Boolean isLoaded) {
        this.isLoaded = isLoaded;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public MainUiState setIsLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
        return this;
    }
}
