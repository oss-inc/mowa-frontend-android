package com.inc.mowa.data.statistics

interface DailyStatisticsView {
    fun onGetDailyStatisticsSuccess(statistics: DailyStatisticsResponse)
    fun onGetDailyStatisticsFailure(message: String)
}

interface MonthlyStatisticsView {
    fun onGetMonthlyStatisticsSuccess(statistics: MonthlyStatisticsResponse)
    fun onGetMonthlyStatisticsFailure(message: String)
}