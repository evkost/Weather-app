package com.evkost.weatherapp.data.remote.result;

import androidx.annotation.NonNull;

import com.evkost.weatherapp.data.Result;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

public class ResultCallAdapter implements CallAdapter<Type, Call<Result<Type>>> {
    private final Type type;

    public ResultCallAdapter(Type type) {
        this.type = type;
    }

    @NonNull
    @Override
    public Type responseType() {
        return type;
    }

    @NonNull
    @Override
    public Call<Result<Type>> adapt(@NonNull Call<Type> call) {
        return new ResultCall<>(call);
    }
}
