package com.inc.mowa.data.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherInterface {
    @GET("weather")
    Call<OpenWeather> getWeather(@Query("lat") double lat,
                                 @Query("lon") double lon,
                                 @Query("appid") String appKey,
                                 @Query("units") String unit
    );
}