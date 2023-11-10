package com.evkost.weatherapp.ui;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
class MainUiState {
    private final Boolean isLoaded;
    @Nullable private final Destination destination;

    public MainUiState(Boolean isLoaded, @Nullable Destination destination) {
        this.isLoaded = isLoaded;
        this.destination = destination;
    }

    public Boolean isLoaded() {
        return this.isLoaded;
    }

    @Nullable
    public Destination getDestination() {
        return this.destination;
    }

    enum Destination {
        WELCOME, HOME
    }
}
