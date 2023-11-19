package com.evkost.weatherapp.data.local.database.table;

import android.provider.BaseColumns;

public class ForecastHourTable {
    public static final String NAME = "forecast_hour";

    public static class Queries {
        public static final String CREATE_TABLE =
                "CREATE TABLE " + NAME + " (" +
                        Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Columns.TIME + " TEXT," +
                        Columns.TEMP_C + " REAL" +
                        Columns.WIND_MPH + " REAL," +
                        Columns.WIND_DEGREE + " INTEGER," +
                        Columns.WIND_DIR + " TEXT," +
                        Columns.PRESSURE_MB + " REAL," +
                        Columns.PRECIPITATION_MM + " REAL," +
                        Columns.HUMIDITY + " INTEGER," +
                        Columns.CLOUD + " INTEGER," +
                        Columns.FEELS_LIKE_C + " REAL," +
                        Columns.CHANCE_OF_RAIN + " INTEGER," +
                        Columns.CHANCE_OF_SNOW + " INTEGER," +
                        Columns.FORECAST_DAY_ID + " INTEGER," +
                        Columns.WEATHER_CONDITION_CODE + " INTEGER, " +
                        "FOREIGN KEY (" + ForecastHourTable.Columns.FORECAST_DAY_ID + ") " +
                        "REFERENCES " + ForecastDayTable.NAME + " (" + ForecastDayTable.Columns._ID +
                        ") ON DELETE CASCADE)";

        public static final String DROP_TABLE =
                "DROP TABLE IF EXISTS " + NAME;
    }

    public static class Columns implements BaseColumns {
        public static final String TIME = "time";
        public static final String TEMP_C = "temp_c";
        public static final String WIND_MPH = "wind_mph";
        public static final String WIND_DEGREE = "wind_degree";
        public static final String WIND_DIR = "wind_dir";
        public static final String PRESSURE_MB = "pressure_mb";
        public static final String PRECIPITATION_MM = "precipitation_mm";
        public static final String HUMIDITY = "humidity";
        public static final String CLOUD = "cloud";
        public static final String FEELS_LIKE_C = "feels_like_c";
        public static final String CHANCE_OF_RAIN = "chance_of_rain";
        public static final String CHANCE_OF_SNOW = "chance_of_snow";
        public static final String WEATHER_CONDITION_CODE = "weather_condition_code";
        public static final String FORECAST_DAY_ID = "forecast_day_id";
    }
}
