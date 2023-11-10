package com.evkost.weatherapp.data.remote.impl;

import com.evkost.weatherapp.data.remote.WeatherRemoteDataSource;
import com.evkost.weatherapp.model.dto.CurrentWeatherDto;
import com.evkost.weatherapp.model.dto.ForecastDto;

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

    @Override
    public Single<Response<CurrentWeatherDto>> getCurrentWeather(
            String key, String city, String aqi
    ) {
        return remoteDataApi.getCurrentWeather(key, city, aqi);
    }

    @Override
    public Single<Response<ForecastDto>> getForecast(
            String key, String city, Integer days, String includeAqi, String includeAlerts
    ) {
        return remoteDataApi.getForecast(key, city, days, includeAqi, includeAlerts);
    }

    private interface RemoteDataApi {
        @GET("/v1/current.json")
        Single<Response<CurrentWeatherDto>> getCurrentWeather(
                @Query("key") String key,
                @Query("q") String city,
                @Query("aqi") String aqi
        );

        @GET("/v1/forecast.json")
        Single<Response<ForecastDto>> getForecast(
                @Query("key") String key,
                @Query("q") String city,
                @Query("days") Integer days,
                @Query("aqi") String includeAqi,
                @Query("alerts") String includeAlerts
        );
    }

}
