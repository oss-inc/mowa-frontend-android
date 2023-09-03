package com.inc.mowa.data.weather;

import android.util.Log
import com.inc.mowa.BuildConfig
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OpenWeatherService {

    /**
     * Call open weather api for getting weather
     * The parameters are latitude, longitude, API KEY, exceptedOptions, units
     *
     * @author seonwoo
     */
    fun getOpenWeather(openWeatherView: OpenWeatherView, latitude: Double, longitude: Double) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.OPEN_WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val openWeatherService = retrofit.create(OpenWeatherInterface::class.java)

        openWeatherService
            .getWeather(latitude, longitude, BuildConfig.OPEN_WEATHER_API_KEY, "metric")
            .enqueue(object : Callback<OpenWeather> {

                override fun onResponse(call: Call<OpenWeather>, response: Response<OpenWeather>) {
                    val mData = response.body()!!
                    val weather = mData.weather[0]
                    val todayWeather = weather.main
                    val todayTemperature = mData.main.temp

                    openWeatherView.onGetWeatherSuccess(todayWeather, todayTemperature)
                }

                override fun onFailure(call: Call<OpenWeather>, t: Throwable) {
                    Log.d(LOG_API, "Fail to call API: ${t.message}")
                    openWeatherView.onGetWeatherFailure(400, "네트워크 오류")
                }
            })
    }
}