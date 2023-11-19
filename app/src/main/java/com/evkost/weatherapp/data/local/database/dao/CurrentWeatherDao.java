package com.evkost.weatherapp.data.local.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.dao.core.AbstractRxDao;
import com.evkost.weatherapp.data.local.database.table.CurrentWeatherTable;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherDao extends AbstractRxDao<CurrentWeatherEntity> {

    @Inject
    public CurrentWeatherDao(SQLiteDatabase db, TransactionManager transactionManager) {
        super(db, transactionManager, CurrentWeatherTable.NAME);
    }

    @Override
    protected ContentValues entityToContentValues(CurrentWeatherEntity entity) {
        ContentValues values = new ContentValues();
        values.put(CurrentWeatherTable.Columns.TZ_ID, entity.getTzId());
        values.put(CurrentWeatherTable.Columns.TEMP_C, entity.getTempC());
        values.put(CurrentWeatherTable.Columns.WIND_MPH, entity.getWindMph());
        values.put(CurrentWeatherTable.Columns.WIND_DEGREE, entity.getWindDegree());
        values.put(CurrentWeatherTable.Columns.WIND_DIR, entity.getWindDir());
        values.put(CurrentWeatherTable.Columns.PRESSURE_MB, entity.getPressureMb());
        values.put(CurrentWeatherTable.Columns.PRECIPITATION_MM, entity.getPrecipitationMm());
        values.put(CurrentWeatherTable.Columns.HUMIDITY, entity.getHumidity());
        values.put(CurrentWeatherTable.Columns.CLOUD, entity.getCloud());
        values.put(CurrentWeatherTable.Columns.FEELS_LIKE_C, entity.getFeelsLikeC());
        values.put(CurrentWeatherTable.Columns.WEATHER_CONDITION_CODE, entity.getConditionCode());
        return values;
    }

    @Override
    protected CurrentWeatherEntity parseCursor(Cursor cursor) {
        CurrentWeatherEntity entity = new CurrentWeatherEntity();
        entity.setId(cursor.getLong(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns._ID)));
        entity.setTzId(cursor.getString(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.TZ_ID)));
        entity.setTempC(cursor.getDouble(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.TEMP_C)));
        entity.setWindMph(cursor.getDouble(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.WIND_MPH)));
        entity.setWindDegree(cursor.getInt(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.WIND_DEGREE)));
        entity.setWindDir(cursor.getString(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.WIND_DIR)));
        entity.setPressureMb(cursor.getDouble(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.PRESSURE_MB)));
        entity.setPrecipitationMm(cursor.getDouble(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.PRECIPITATION_MM)));
        entity.setHumidity(cursor.getInt(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.HUMIDITY)));
        entity.setCloud(cursor.getInt(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.CLOUD)));
        entity.setFeelsLikeC(cursor.getDouble(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.FEELS_LIKE_C)));
        entity.setConditionCode(cursor.getInt(cursor.getColumnIndexOrThrow(CurrentWeatherTable.Columns.WEATHER_CONDITION_CODE)));
        return entity;
    }
}
