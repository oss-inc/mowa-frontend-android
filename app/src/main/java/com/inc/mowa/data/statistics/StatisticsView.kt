package com.inc.mowa.data.statistics

interface DailyStatisticsView {
    fun onGetDailyStatisticsSuccess(statistics: DailyActivityStats)
    fun onGetDailyStatisticsFailure(message: String)
}

interface MonthlyStatisticsView {
    fun onGetMonthlyStatisticsSuccess(statistics: MonthlyActivityStats)
    fun onGetMonthlyStatisticsFailure(message: String)
}