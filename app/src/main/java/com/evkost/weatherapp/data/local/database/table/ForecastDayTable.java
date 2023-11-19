package com.evkost.weatherapp.data.local.database.table;

import android.provider.BaseColumns;

public class ForecastDayTable {
    public static final String NAME = "forecast_day";

    public static class Queries {
        public static final String CREATE_TABLE =
                "CREATE TABLE " + NAME + " (" +
                        Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Columns.TZ_ID + " TEXT," +
                        Columns.MAX_TEMP_C + " REAL" +
                        Columns.MIN_TEMP_C + " REAL" +
                        Columns.MAX_WIND_MPH + " REAL," +
                        Columns.TOTAL_PRECIPITATION_MM + " REAL," +
                        Columns.TOTAL_SNOW_CM + " REAL," +
                        Columns.AVG_HUMIDITY + " REAL," +
                        Columns.DAILY_CHANCE_OF_RAIN + " INTEGER," +
                        Columns.DAILY_CHANCE_OF_SNOW + " INTEGER," +
                        Columns.DATE + " TEXT UNIQUE," +
                        Columns.WEATHER_CONDITION_CODE + " INTEGER)";

        public static final String DROP_TABLE =
                "DROP TABLE IF EXISTS " + NAME;
    }

    public static class Columns implements BaseColumns {
        public static final String TZ_ID = "tz_id";
        public static final String MAX_TEMP_C = "max_temp_c";
        public static final String MIN_TEMP_C = "mix_temp_c";
        public static final String MAX_WIND_MPH = "max_wind_mph";
        public static final String TOTAL_PRECIPITATION_MM = "precipitation_mm";
        public static final String TOTAL_SNOW_CM = "total_snow_cm";
        public static final String AVG_HUMIDITY = "avg_humidity";
        public static final String DAILY_CHANCE_OF_RAIN = "daily_chance_of_rain";
        public static final String DAILY_CHANCE_OF_SNOW = "daily_chance_of_snow";
        public static final String DATE = "date";
        public static final String WEATHER_CONDITION_CODE = "weather_condition_code";
    }
}
