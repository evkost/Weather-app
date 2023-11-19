package com.evkost.weatherapp.ui.feature.common;

import com.evkost.weatherapp.R;

import java.util.HashMap;
import java.util.Map;

public class WeatherResourceProvider {
    private static Map<Integer, WeatherResource> weatherResourceMap = new HashMap<>();

    static {
//        weatherResourceMap.put(
//                1000,
//                new WeatherResource(
//                        R.string.sunny_weather_message,
//                        R.drawable.sunny_weather_backgroung
//                )
//        );
//
//        weatherResourceMap.put(
//                1003,
//                new WeatherResource(
//                        R.string.partly_cloudy_weather_message,
//                        R.drawable.partly_cloudy_weather_backgroung
//                )
//        );
//
//        weatherResourceMap.put(
//                1006,
//                new WeatherResource(
//                        R.string.cloudy_weather_message,
//                        R.drawable.cloudy_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1009,
//                new WeatherResource(
//                        R.string.overcast_weather_message,
//                        R.drawable.overcast_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1030,
//                new WeatherResource(
//                        R.string.mist_weather_message,
//                        R.drawable.mist_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1063,
//                new WeatherResource(
//                        R.string.patchy_rain_possible_weather_message,
//                        R.drawable.patchy_rain_possible_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1066,
//                new WeatherResource(
//                        R.string.patchy_snow_possible_weather_message,
//                        R.drawable.patchy_snow_possible_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1069,
//                new WeatherResource(
//                        R.string.patchy_sleet_possible_weather_message,
//                        R.drawable.patchy_sleet_possible_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1072,
//                new WeatherResource(
//                        R.string.patchy_freezing_drizzle_possible_weather_message,
//                        R.drawable.patchy_freezing_drizzle_possible_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1087,
//                new WeatherResource(
//                        R.string.thundery_outbreaks_possible_weather_message,
//                        R.drawable.thundery_outbreaks_possible_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1114,
//                new WeatherResource(
//                        R.string.blowing_snow_weather_message,
//                        R.drawable.blowing_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1117,
//                new WeatherResource(
//                        R.string.blizzard_weather_message,
//                        R.drawable.blizzard_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1135,
//                new WeatherResource(
//                        R.string.fog_weather_message,
//                        R.drawable.fog_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1147,
//                new WeatherResource(
//                        R.string.freezing_fog_weather_message,
//                        R.drawable.freezing_fog_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1150,
//                new WeatherResource(
//                        R.string.light_rain_weather_message,
//                        R.drawable.light_rain_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1153,
//                new WeatherResource(
//                        R.string.drizzle_weather_message,
//                        R.drawable.drizzle_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1168,
//                new WeatherResource(
//                        R.string.light_rain_shower_weather_message,
//                        R.drawable.light_rain_shower_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1171,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_rain_shower_weather_message,
//                        R.drawable.moderate_or_heavy_rain_shower_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1180,
//                new WeatherResource(
//                        R.string.light_sleet_weather_message,
//                        R.drawable.light_sleet_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1183,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_sleet_weather_message,
//                        R.drawable.moderate_or_heavy_sleet_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1186,
//                new WeatherResource(
//                        R.string.light_snow_weather_message,
//                        R.drawable.light_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1189,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_snow_weather_message,
//                        R.drawable.moderate_or_heavy_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1192,
//                new WeatherResource(
//                        R.string.light_showers_of_ice_pellets_weather_message,
//                        R.drawable.light_showers_of_ice_pellets_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1195,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_showers_of_ice_pellets_weather_message,
//                        R.drawable.moderate_or_heavy_showers_of_ice_pellets_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1198,
//                new WeatherResource(
//                        R.string.patchy_light_rain_with_thunder_weather_message,
//                        R.drawable.patchy_light_rain_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1201,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_rain_with_thunder_weather_message,
//                        R.drawable.moderate_or_heavy_rain_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1240,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_snow_with_thunder_weather_message,
//                        R.drawable.moderate_or_heavy_snow_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1243,
//                new WeatherResource(
//                        R.string.patchy_light_rain_weather_message,
//                        R.drawable.patchy_light_rain_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1246,
//                new WeatherResource(
//                        R.string.patchy_moderate_rain_weather_message,
//                        R.drawable.patchy_moderate_rain_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1249,
//                new WeatherResource(
//                        R.string.patchy_heavy_rain_weather_message,
//                        R.drawable.patchy_heavy_rain_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1252,
//                new WeatherResource(
//                        R.string.patchy_light_snow_weather_message,
//                        R.drawable.patchy_light_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1255,
//                new WeatherResource(
//                        R.string.patchy_moderate_snow_weather_message,
//                        R.drawable.patchy_moderate_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1258,
//                new WeatherResource(
//                        R.string.patchy_heavy_snow_weather_message,
//                        R.drawable.patchy_heavy_snow_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1261,
//                new WeatherResource(
//                        R.string.thundery_outbreaks_in_nearby_weather_message,
//                        R.drawable.thundery_outbreaks_in_nearby_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1264,
//                new WeatherResource(
//                        R.string.patchy_light_rain_in_area_with_thunder_weather_message,
//                        R.drawable.patchy_light_rain_in_area_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1273,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_rain_in_area_with_thunder_weather_message,
//                        R.drawable.moderate_or_heavy_rain_in_area_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1276,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_snow_in_area_with_thunder_weather_message,
//                        R.drawable.moderate_or_heavy_snow_in_area_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1279,
//                new WeatherResource(
//                        R.string.patchy_light_sleet_in_area_with_thunder_weather_message,
//                        R.drawable.patchy_light_sleet_in_area_with_thunder_weather_background
//                )
//        );
//
//        weatherResourceMap.put(
//                1282,
//                new WeatherResource(
//                        R.string.moderate_or_heavy_sleet_in_area_with_thunder_weather_message,
//                        R.drawable.moderate_or_heavy_sleet_in_area_with_thunder_weather_background
//                )
//        );
    }

    public static WeatherResource getByCode(Integer code) {
        return weatherResourceMap.get(code);
    }
}
