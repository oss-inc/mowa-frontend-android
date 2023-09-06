package com.inc.mowa.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inc.mowa.data.statistics.DailyActivityStats
import com.inc.mowa.data.statistics.DailyStatisticsResponse
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API

class StatisticsViewModel : ViewModel() {
    private val _statistics = MutableLiveData<DailyActivityStats?>()

    val statistics get() = _statistics

    init {
        setDailyStatistics(0, 0, 0)
    }

    fun setDailyStatistics(warningCount: Int, activityCount: Int, fallCount: Int) {
        _statistics.value = DailyActivityStats(warningCount, activityCount, fallCount)
        Log.d(
            LOG_API,
            "Warning count: $warningCount, Activity count: $activityCount, Fall count: $fallCount"
        )
    }
}