package com.evkost.weatherapp.ui.feature.common;


import com.evkost.weatherapp.data.Result;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nullable;

public class Outcome<T> {
    private T value;
    private final State state;
    private String errorMessage;

    private Outcome(State state) {
        this.state = state;
    }

    public static <T> Outcome<T> success(T value) {
        Outcome<T> outcome = new Outcome<>(State.SUCCESS);
        outcome.value = value;
        return outcome;
    }

    public static <T> Outcome<T> error(String message) {
        Outcome<T> outcome = new Outcome<>(State.ERROR);
        outcome.errorMessage = message;
        return outcome;
    }

    public static <T> Outcome<T> loading() {
        return new Outcome<>(State.LOADING);
    }

    @Nullable
    public T get() {
        return this.value;
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean isSuccess() {
        return state == State.SUCCESS;
    }

    public boolean isError() {
        return state == State.ERROR;
    }

    public boolean isLoading() {
        return state == State.LOADING;
    }

    public Outcome<T> ifSuccess(Consumer<T> consumer) {
        if (state.equals(State.SUCCESS)) {
            consumer.accept(value);
        }

        return this;
    }

    public Outcome<T> ifError(Consumer<String> consumer) {
        if (state.equals(State.ERROR)) {
            consumer.accept(errorMessage);
        }

        return this;
    }

    public Outcome<T> ifLoading(Runnable runnable) {
        if (state.equals(State.LOADING)) {
            runnable.run();
        }

        return this;
    }

    public static <S, V> Outcome<V> fromResultMapping(Result<S> result, Function<S, V> map) {
        if (result.isSuccess()) {
             return Outcome.success(map.apply(result.get()));
        } else if (result.isError()) {
             return Outcome.error(result.getErrorMessage());
        } else if (result.isException()) {
            return Outcome.error(result.getException().getMessage());
        }
        return null;
    }

    private enum State {
        SUCCESS, ERROR, LOADING
    }
}
