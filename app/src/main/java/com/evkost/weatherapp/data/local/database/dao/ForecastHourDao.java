package com.evkost.weatherapp.data.local.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.dao.core.AbstractRxDao;
import com.evkost.weatherapp.data.local.database.table.ForecastHourTable;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.model.entity.ForecastHourEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ForecastHourDao extends AbstractRxDao<ForecastHourEntity> {
    @Inject
    public ForecastHourDao(SQLiteDatabase db, TransactionManager transactionManager) {
        super(db, transactionManager, ForecastHourTable.NAME);
    }

    @Override
    protected ContentValues entityToContentValues(ForecastHourEntity entity) {
        ContentValues values = new ContentValues();
        values.put(ForecastHourTable.Columns.TIME, entity.getTime());
        values.put(ForecastHourTable.Columns.TEMP_C, entity.getTempC());
        values.put(ForecastHourTable.Columns.WIND_MPH, entity.getWindMph());
        values.put(ForecastHourTable.Columns.WIND_DEGREE, entity.getWindDegree());
        values.put(ForecastHourTable.Columns.WIND_DIR, entity.getWindDir());
        values.put(ForecastHourTable.Columns.PRESSURE_MB, entity.getPressureMb());
        values.put(ForecastHourTable.Columns.PRECIPITATION_MM, entity.getPrecipitationMm());
        values.put(ForecastHourTable.Columns.HUMIDITY, entity.getHumidity());
        values.put(ForecastHourTable.Columns.CLOUD, entity.getCloud());
        values.put(ForecastHourTable.Columns.FEELS_LIKE_C, entity.getFeelsLikeC());
        values.put(ForecastHourTable.Columns.CHANCE_OF_RAIN, entity.getChanceOfRain());
        values.put(ForecastHourTable.Columns.CHANCE_OF_SNOW, entity.getChanceOfSnow());
        values.put(ForecastHourTable.Columns.FORECAST_DAY_ID, entity.getForecastDayId());
        values.put(ForecastHourTable.Columns.WEATHER_CONDITION_CODE, entity.getConditionCode());
        return values;
    }

    @Override
    protected ForecastHourEntity parseCursor(Cursor cursor) {
        ForecastHourEntity entity = new ForecastHourEntity();
        entity.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns._ID)));
        entity.setTime(cursor.getString(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.TIME)));
        entity.setTempC(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.TEMP_C)));
        entity.setWindMph(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.WIND_MPH)));
        entity.setWindDegree(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.WIND_DEGREE)));
        entity.setWindDir(cursor.getString(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.WIND_DIR)));
        entity.setPressureMb(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.PRESSURE_MB)));
        entity.setPrecipitationMm(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.PRECIPITATION_MM)));
        entity.setHumidity(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.HUMIDITY)));
        entity.setCloud(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.CLOUD)));
        entity.setFeelsLikeC(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.FEELS_LIKE_C)));
        entity.setChanceOfRain(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.CHANCE_OF_RAIN)));
        entity.setChanceOfSnow(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.CHANCE_OF_SNOW)));
        entity.setForecastDayId(cursor.getLong(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.FORECAST_DAY_ID)));
        entity.setConditionCode(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastHourTable.Columns.WEATHER_CONDITION_CODE)));
        return entity;
    }
}
