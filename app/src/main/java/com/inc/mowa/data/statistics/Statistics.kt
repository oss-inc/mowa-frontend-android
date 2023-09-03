package com.inc.mowa.data.statistics

import com.google.gson.annotations.SerializedName

data class DailyStatisticsResponse(
    @SerializedName("warning_count") var warningCount: Int = 0,
    @SerializedName("activity_count") var activityCount: Int = 0,
    @SerializedName("fall_count") var fallCount: Int = 0
)

data class MonthlyStatisticsResponse(
    @SerializedName("email") var date: String,
    @SerializedName("warning_count") var warningCount: Int = 0,
    @SerializedName("activity_count") var activityCount: Int = 0,
    @SerializedName("fall_count") var fallCount: Int = 0
)