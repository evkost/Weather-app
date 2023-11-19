package com.evkost.weatherapp.data.local.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evkost.weatherapp.data.local.database.table.CurrentWeatherTable;
import com.evkost.weatherapp.data.local.database.table.ForecastDayTable;
import com.evkost.weatherapp.data.local.database.table.ForecastHourTable;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class WeatherAppDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "weather_app.db";

    @Inject
    public WeatherAppDbHelper(@ApplicationContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CurrentWeatherTable.Queries.CREATE_TABLE);
        db.execSQL(ForecastDayTable.Queries.CREATE_TABLE);
        db.execSQL(ForecastHourTable.Queries.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CurrentWeatherTable.Queries.DROP_TABLE);
        db.execSQL(ForecastDayTable.Queries.DROP_TABLE);
        db.execSQL(ForecastHourTable.Queries.DROP_TABLE);
        this.onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onUpgrade(db, oldVersion, newVersion);
    }
}
