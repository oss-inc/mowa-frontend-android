package com.inc.mowa.ui.main.statistics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.data.statistics.DailyStatisticsResponse
import com.inc.mowa.data.statistics.MonthlyStatisticsResponse
import com.inc.mowa.data.statistics.MonthlyStatisticsView
import com.inc.mowa.data.statistics.StatisticsService
import com.inc.mowa.databinding.FragmentStatisticsBinding
import com.inc.mowa.utils.ApplicationClass
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.getUserEmail
import java.util.Calendar
import java.util.Date

class StatisticsFragment : Fragment(), MonthlyStatisticsView {
    private lateinit var binding: FragmentStatisticsBinding

    private var statisticsService: StatisticsService = StatisticsService()

    private var year: Int = 0
    private var month: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        setDate()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initDate()
        initClickListener()
    }

    private fun setDate() {
        val calendar = Calendar.getInstance()
        calendar.time = Date()

        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH) + 1
    }

    private fun initDate() {
        val date = year.toString() + "년 " + month.toString() + "월"
        binding.statisticsDateTv.text = date
    }

    private fun initClickListener() {

        binding.statisticsPreviousMonthIv.setOnClickListener {
            year = if (month > 1) year else year - 1
            month = if (month == 1) 12 else month - 1

            statisticsService.getMonthlyStatistics(
                this@StatisticsFragment,
                getUserEmail()!!,
                year,
                month
            )
        }

        binding.statisticsNextMonthIv.setOnClickListener {
            year = if (month < 12) year else year + 1
            month = if (month == 12) 1 else (month + 1)

            statisticsService.getMonthlyStatistics(
                this@StatisticsFragment,
                getUserEmail()!!,
                year,
                month
            )
        }
    }

    private fun setStatistics(statistics: MonthlyStatisticsResponse) {
        binding.statisticsWarningCountTv.text = statistics.warningCount.toString()
        binding.statisticsActivityCountTv.text = statistics.activityCount.toString()
        binding.statisticsFallCountTv.text = statistics.fallCount.toString()
    }

    override fun onGetMonthlyStatisticsSuccess(statistics: MonthlyStatisticsResponse) {
        Log.d(LOG_API, "Success to call getMonthlyStatistics")
        setStatistics(statistics)
    }

    override fun onGetMonthlyStatisticsFailure(message: String) {
        Log.w(LOG_API, "Fail to call getMonthlyStatistics")
        ApplicationClass.showToast(requireContext(), "월별 활동 통계 데이터 요청에 실패하였습니다.")
    }
}