package com.inc.mowa.data.weather.field;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    private float temp;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }
}
