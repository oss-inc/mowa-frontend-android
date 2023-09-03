package com.inc.mowa.data.statistics

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatisticsRetrofitInterface {

    @GET("/activity/{user_email}/{year}/{month}/{day}")
    fun getDailyStatistics(
        @Path("user_email") userEmail: String,
        @Path("year") year: Int,
        @Path("month") month: Int,
        @Path("day") day: Int
    ): Call<DailyStatisticsResponse>

    @GET("/activity/{user_email}/stats/{year}/{month}")
    fun getMonthlyStatistics(
        @Path("user_email") userEmail: String,
        @Path("year") year: Int,
        @Path("month") month: Int
    ): Call<MonthlyStatisticsResponse>
}