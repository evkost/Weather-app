package com.evkost.weatherapp.data.local.database.table;

import android.provider.BaseColumns;

public class CurrentWeatherTable {
    public static final String NAME = "current_weather";

    public static class Queries {
        public static final String CREATE_TABLE =
                "CREATE TABLE " + NAME + " (" +
                        Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Columns.TZ_ID + " TEXT," +
                        Columns.TEMP_C + " REAL" +
                        Columns.WIND_MPH + " REAL," +
                        Columns.WIND_DEGREE + " INTEGER," +
                        Columns.WIND_DIR + " TEXT," +
                        Columns.PRESSURE_MB + " REAL," +
                        Columns.PRECIPITATION_MM + " REAL," +
                        Columns.HUMIDITY + " INTEGER," +
                        Columns.CLOUD + " INTEGER," +
                        Columns.FEELS_LIKE_C + " REAL," +
                        Columns.LAST_UPDATED_DATETIME + " TEXT," +
                        Columns.DATE + " TEXT UNIQUE," +
                        Columns.WEATHER_CONDITION_CODE + " INTEGER)";

        public static final String DROP_TABLE =
                "DROP TABLE IF EXISTS " + NAME;
    }

    public static class Columns implements BaseColumns {
        public static final String TZ_ID = "tz_id";
        public static final String TEMP_C = "temp_c";
        public static final String WIND_MPH = "wind_mph";
        public static final String WIND_DEGREE = "wind_degree";
        public static final String WIND_DIR = "wind_dir";
        public static final String PRESSURE_MB = "pressure_mb";
        public static final String PRECIPITATION_MM = "precipitation_mm";
        public static final String HUMIDITY = "humidity";
        public static final String CLOUD = "cloud";
        public static final String FEELS_LIKE_C = "feels_like_c";
        public static final String LAST_UPDATED_DATETIME = "last_updated";
        public static final String DATE = "date";
        public static final String WEATHER_CONDITION_CODE = "weather_condition_code";
    }
}
