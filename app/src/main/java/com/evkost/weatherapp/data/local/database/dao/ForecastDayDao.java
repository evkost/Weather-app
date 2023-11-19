package com.evkost.weatherapp.data.local.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.dao.core.AbstractRxDao;
import com.evkost.weatherapp.data.local.database.table.ForecastDayTable;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.model.entity.ForecastDayEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ForecastDayDao extends AbstractRxDao<ForecastDayEntity> {

    @Inject
    public ForecastDayDao(SQLiteDatabase db, TransactionManager transactionManager) {
        super(db, transactionManager, ForecastDayTable.NAME);
    }

    @Override
    protected ContentValues entityToContentValues(ForecastDayEntity entity) {
        ContentValues values = new ContentValues();
        values.put(ForecastDayTable.Columns.TZ_ID, entity.getTzId());
        values.put(ForecastDayTable.Columns.MAX_TEMP_C, entity.getMaxTempC());
        values.put(ForecastDayTable.Columns.MIN_TEMP_C, entity.getMinTempC());
        values.put(ForecastDayTable.Columns.MAX_WIND_MPH, entity.getMaxWindMph());
        values.put(ForecastDayTable.Columns.TOTAL_PRECIPITATION_MM, entity.getTotalPrecipitationMm());
        values.put(ForecastDayTable.Columns.TOTAL_SNOW_CM, entity.getTotalSnowCm());
        values.put(ForecastDayTable.Columns.AVG_HUMIDITY, entity.getAvgHumidity());
        values.put(ForecastDayTable.Columns.DAILY_CHANCE_OF_RAIN, entity.getDailyChanceOfRain());
        values.put(ForecastDayTable.Columns.DAILY_CHANCE_OF_SNOW, entity.getDailyChanceOfSnow());
        values.put(ForecastDayTable.Columns.DATE, entity.getDate());
        values.put(ForecastDayTable.Columns.WEATHER_CONDITION_CODE, entity.getConditionCode());
        return values;
    }

    @Override
    protected ForecastDayEntity parseCursor(Cursor cursor) {
        ForecastDayEntity entity = new ForecastDayEntity();
        entity.setId(cursor.getLong(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns._ID)));
        entity.setTzId(cursor.getString(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.TZ_ID)));
        entity.setMaxTempC(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.MAX_TEMP_C)));
        entity.setMinTempC(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.MIN_TEMP_C)));
        entity.setMaxWindMph(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.MAX_WIND_MPH)));
        entity.setTotalPrecipitationMm(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.TOTAL_PRECIPITATION_MM)));
        entity.setTotalSnowCm(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.TOTAL_SNOW_CM)));
        entity.setAvgHumidity(cursor.getDouble(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.AVG_HUMIDITY)));
        entity.setDailyChanceOfRain(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.DAILY_CHANCE_OF_RAIN)));
        entity.setDailyChanceOfSnow(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.DAILY_CHANCE_OF_SNOW)));
        entity.setDate(cursor.getString(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.DATE)));
        entity.setConditionCode(cursor.getInt(cursor.getColumnIndexOrThrow(ForecastDayTable.Columns.WEATHER_CONDITION_CODE)));
        return entity;
    }
}
