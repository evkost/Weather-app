package com.evkost.weatherapp.data.remote.result;

import androidx.annotation.NonNull;

import com.evkost.weatherapp.data.Result;

import kotlin.NotImplementedError;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultCall<T> implements Call<Result<T>> {
    private final Call<T> proxy;

    public ResultCall(Call<T> proxy) {
        this.proxy = proxy;
    }

    public void enqueue(@NonNull Callback<Result<T>> callback) {
        proxy.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                Result<T> result;
                if (response.isSuccessful()) {
                    result = Result.success(response.body());
                } else {
                    result = Result.error(response.message(), response.code());
                }
                callback.onResponse(ResultCall.this, Response.success(result));
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                Result<T> result = Result.exception(t);
                callback.onResponse(ResultCall.this, Response.success(result));
            }
        });
    }

    @NonNull
    @Override
    public Response<Result<T>> execute() {
        throw new NotImplementedError();
    }
    @NonNull
    @Override
    public Call<Result<T>> clone() {
        return new ResultCall<>(proxy.clone());
    }
    @NonNull
    @Override
    public Request request() {
        return proxy.request();
    }
    @NonNull
    @Override
    public Timeout timeout() {
        return proxy.timeout();
    }

    @Override
    public boolean isExecuted() {
        return proxy.isExecuted();
    }

    @Override
    public boolean isCanceled() {
        return proxy.isCanceled();
    }

    @Override
    public void cancel() {
        proxy.cancel();
    }
}
