package com.inc.mowa.data.statistics

import com.google.gson.annotations.SerializedName

data class DailyStatisticsResponse(
    @SerializedName("activity_stats") var activityStats: DailyActivityStats,
)

data class MonthlyStatisticsResponse(
    @SerializedName("activity_stats") var activityStats: MonthlyActivityStats,
)

data class DailyActivityStats(
    @SerializedName("warning_count") var warningCount: Int = 0,
    @SerializedName("activity_count") var activityCount: Int = 0,
    @SerializedName("fall_count") var fallCount: Int = 0
)

data class MonthlyActivityStats(
    @SerializedName("email") var date: String,
    @SerializedName("warning_count") var warningCount: Int = 0,
    @SerializedName("activity_count") var activityCount: Int = 0,
    @SerializedName("fall_count") var fallCount: Int = 0
)