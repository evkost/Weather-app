package com.evkost.weatherapp.data.remote.impl;

import com.evkost.weatherapp.data.Result;
import com.evkost.weatherapp.data.remote.result.ResultCallAdapterFactory;
import com.evkost.weatherapp.data.remote.WeatherRemoteDataSource;
import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.ForecastDto;
import com.evkost.weatherapp.model.response.GetCurrentWeatherResponse;
import com.evkost.weatherapp.model.response.GetForecastResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Singleton
public class RetrofitWeatherRemoteDataSource implements WeatherRemoteDataSource {
    private final RemoteDataApi remoteDataApi = new Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(RemoteDataApi.class);

    @Inject
    public RetrofitWeatherRemoteDataSource() {}

    @Override
    public Single<Result<CurrentWeatherDto>> getCurrentWeather(
            String key, String city, String aqi
    ) {
        return remoteDataApi.getCurrentWeather(key, city, aqi)
                .map(Result::fromResponse)
                .map(result -> result.map(GetCurrentWeatherResponse::getCurrentWeather));
    }

    @Override
    public Single<Result<ForecastDto>> getForecast(
            String key, String city, Integer days, String date, String includeAqi, String includeAlerts
    ) {
        return remoteDataApi.getForecast(key, city, days, date, includeAqi, includeAlerts)
                .map(Result::fromResponse)
                .map(result -> result.map(GetForecastResponse::getForecast));
    }

    private interface RemoteDataApi {
        @GET("/v1/current.json")
        Single<Response<GetCurrentWeatherResponse>> getCurrentWeather(
                @Query("key") String key,
                @Query("q") String city,
                @Query("aqi") String aqi
        );

        @GET("/v1/forecast.json")
        Single<Response<GetForecastResponse>> getForecast(
                @Query("key") String key,
                @Query("q") String city,
                @Query("days") Integer days,
                @Query("dt") String date,
                @Query("aqi") String includeAqi,
                @Query("alerts") String includeAlerts
        );
    }
}
