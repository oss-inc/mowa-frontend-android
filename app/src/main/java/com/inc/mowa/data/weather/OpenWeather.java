package com.inc.mowa.data.weather;

import com.google.gson.annotations.SerializedName;
import com.inc.mowa.data.weather.field.Coord;
import com.inc.mowa.data.weather.field.Main;
import com.inc.mowa.data.weather.field.Weather;

import java.util.List;

public class OpenWeather {
    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("main")
    private Main main;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
