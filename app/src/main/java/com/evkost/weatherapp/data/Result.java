package com.evkost.weatherapp.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nullable;

import retrofit2.Response;

public class Result<T> {
    private T value;
    private Type type;
    private Integer code;
    private String errorMessage;
    private Throwable exception;

    public Result() {}

    private Result(Type type) {
        this.type = type;
    }

    public static <T> Result<T> success(T value) {
        Result<T> result = new Result<>(Type.SUCCESS);
        result.value = value;
        return result;
    }

    public static <T> Result<T> fromResponse(Response<T> response) {
        Result<T> result;
        if (response.isSuccessful()) {
            result = Result.success(response.body());
        } else {
            result = Result.error(response.message(), response.code());
        }
        return result;
    }
    public static <T> Result<T> error(String message, int code) {
        Result<T> result = new Result<>(Type.ERROR);
        result.errorMessage = message;
        result.code = code;
        return result;
    }

    public static <T> Result<T> exception(Throwable exception) {
        Result<T> result = new Result<>(Type.EXCEPTION);
        result.exception = exception;
        return result;
    }

    @Nullable
    public T get() {
        return this.value;
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public Throwable getException() {
        return this.exception;
    }

    public <S> Result<S> map(Function<T, S> function) {
        Result<S> result = new Result<>(type);
        result.value = function.apply(value);
        result.code = code;
        result.errorMessage = errorMessage;
        result.exception = exception;
        return result;
    }

    public Result<T> ifSuccess(Consumer<T> consumer) {
        if (type.equals(Type.SUCCESS)) {
            consumer.accept(value);
        }

        return this;
    }

    public Result<T> ifError(BiConsumer<String, Integer> consumer) {
        if (type.equals(Type.ERROR)) {
            consumer.accept(errorMessage, code);
        }

        return this;
    }

    public Result<T> ifException(Consumer<Throwable> consumer) {
        if (type.equals(Type.EXCEPTION)) {
            consumer.accept(exception);
        }

        return this;
    }

    public boolean isSuccess() {
        return type.equals(Type.SUCCESS);
    }

    public boolean isError() {
        return type.equals(Type.ERROR);
    }

    public boolean isException() {
        return type.equals(Type.EXCEPTION);
    }

    private enum Type {
        SUCCESS, ERROR, EXCEPTION
    }
}
