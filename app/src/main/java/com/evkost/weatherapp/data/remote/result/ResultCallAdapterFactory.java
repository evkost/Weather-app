package com.evkost.weatherapp.data.remote.result;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evkost.weatherapp.data.Result;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class ResultCallAdapterFactory extends CallAdapter.Factory {
    private ResultCallAdapterFactory() {}

    @Nullable
    @Override
    public CallAdapter<?, ?> get(
            @NonNull Type returnType,
            @NonNull Annotation[] annotations,
            @NonNull Retrofit retrofit
    ) {
        Type callType = getParameterUpperBound(0, (ParameterizedType) returnType);
        if (!getRawType(callType).equals(Result.class)) {
            return null;
        }

        Type resultType = getParameterUpperBound(0, (ParameterizedType) callType);
        return new ResultCallAdapter(resultType);
    }

    public static ResultCallAdapterFactory create() {
        return new ResultCallAdapterFactory();
    }
}
