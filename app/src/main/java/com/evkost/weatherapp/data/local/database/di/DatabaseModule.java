package com.evkost.weatherapp.data.local.database.di;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.WeatherAppDbHelper;
import com.evkost.weatherapp.data.local.database.dao.CurrentWeatherDao;
import com.evkost.weatherapp.data.local.database.dao.ForecastDayDao;
import com.evkost.weatherapp.data.local.database.dao.ForecastHourDao;
import com.evkost.weatherapp.data.local.database.dao.core.RxDao;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManagerImpl;
import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;
import com.evkost.weatherapp.model.entity.ForecastDayEntity;
import com.evkost.weatherapp.model.entity.ForecastHourEntity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class DatabaseModule {
    @Provides
    @Singleton
    public static SQLiteDatabase provideSQLiteDatabase(
            WeatherAppDbHelper dbHelper
    ) {
        return dbHelper.getWritableDatabase();
    }

    @Binds
    abstract RxDao<CurrentWeatherEntity> bindCurrentWeatherDao(CurrentWeatherDao impl);

    @Binds
    abstract RxDao<ForecastDayEntity> bindForecastDayDao(ForecastDayDao impl);

    @Binds
    abstract RxDao<ForecastHourEntity> bindForecastHourDao(ForecastHourDao impl);

    @Binds
    abstract TransactionManager bindTransactionManager(TransactionManagerImpl impl);
}
