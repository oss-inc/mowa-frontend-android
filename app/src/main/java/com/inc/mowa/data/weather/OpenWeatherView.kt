package com.inc.mowa.data.weather;

interface OpenWeatherView {
    fun onGetWeatherSuccess(todayWeather: String, todayTemperature: Float)
    fun onGetWeatherFailure(code: Int, message: String)
}
