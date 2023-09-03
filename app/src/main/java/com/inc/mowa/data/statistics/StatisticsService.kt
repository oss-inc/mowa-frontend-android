package com.inc.mowa.data.statistics

import android.util.Log
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatisticsService {

    private val statisticsRetrofitInterface: StatisticsRetrofitInterface =
        retrofit.create(StatisticsRetrofitInterface::class.java)

    fun getDailyStatistics(
        statisticsView: DailyStatisticsView,
        userEmail: String,
        year: Int,
        month: Int,
        day: Int
    ) {

        statisticsRetrofitInterface.getDailyStatistics(userEmail, year, month, day)
            .enqueue(object : Callback<DailyStatisticsResponse> {

                override fun onResponse(
                    call: Call<DailyStatisticsResponse>,
                    response: Response<DailyStatisticsResponse>
                ) {
                    if (!response.isSuccessful) {
                        Log.w(LOG_API, "Error on response of getDailyStatistics")
                        return
                    }

                    Log.d(LOG_API, "getDailyStatistics: ${response.body().toString()}")

                    // if success
                    when (response.code()) {
                        200 -> statisticsView.onGetDailyStatisticsSuccess(response.body()!!)
                        else -> statisticsView.onGetDailyStatisticsFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<DailyStatisticsResponse>, t: Throwable) {
                    Log.w(LOG_API, "Error on response of getDailyStatistics: $t")
                    statisticsView.onGetDailyStatisticsFailure(t.message!!)
                }

            })
    }

    fun getMonthlyStatistics(
        statisticsView: MonthlyStatisticsView,
        userEmail: String,
        year: Int,
        month: Int
    ) {

        statisticsRetrofitInterface.getMonthlyStatistics(userEmail, year, month)
            .enqueue(object : Callback<MonthlyStatisticsResponse> {

                override fun onResponse(
                    call: Call<MonthlyStatisticsResponse>,
                    response: Response<MonthlyStatisticsResponse>
                ) {
                    if (!response.isSuccessful) {
                        Log.w(LOG_API, "Error on response of getMonthlyStatistics")
                        return
                    }

                    // if success
                    when (response.code()) {
                        200 -> statisticsView.onGetMonthlyStatisticsSuccess(response.body()!!)
                        else -> statisticsView.onGetMonthlyStatisticsFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<MonthlyStatisticsResponse>, t: Throwable) {
                    Log.w(LOG_API, "Error on response of getMonthlyStatistics: $t")
                    statisticsView.onGetMonthlyStatisticsFailure(t.message!!)
                }

            })
    }
}