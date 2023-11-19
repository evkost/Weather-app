package com.evkost.weatherapp.ui;

public class MainSideEffect {
    private Destination toDestination;

    public MainSideEffect(Destination toDestination) {
        this.toDestination = toDestination;
    }

    public Destination getToDestination() {
        return toDestination;
    }

    public void setToDestination(Destination toDestination) {
        this.toDestination = toDestination;
    }

    enum Destination {
        WELCOME, HOME
    }
}
