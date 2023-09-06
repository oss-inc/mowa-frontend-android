package com.inc.mowa.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.inc.mowa.data.statistics.DailyActivityStats
import com.inc.mowa.data.statistics.DailyStatisticsView
import com.inc.mowa.data.statistics.StatisticsService
import com.inc.mowa.data.weather.OpenWeatherService
import com.inc.mowa.data.weather.OpenWeatherView
import com.inc.mowa.databinding.FragmentHomeBinding
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import com.inc.mowa.utils.ApplicationClass.Companion.showToast
import com.inc.mowa.utils.getUserEmail
import com.inc.mowa.viewmodel.LocationViewModel
import com.inc.mowa.viewmodel.StatisticsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment(), OpenWeatherView, DailyStatisticsView {
    private lateinit var binding: FragmentHomeBinding

    private val locationViewModel: LocationViewModel by viewModels()
    private val statisticsViewModel: StatisticsViewModel by viewModels()
    private var openWeatherService: OpenWeatherService = OpenWeatherService()
    private var statisticsService: StatisticsService = StatisticsService()

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setDate()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationViewModel.currentLocation.observe(viewLifecycleOwner) { location ->
            // update ui whenever the location value is changed
            if (location != null) {
                Log.d(LOG_LOCATION, "location: (${location.latitude}, ${location.longitude})")
                initOpenWeatherService(location.latitude, location.longitude)
            }
        }

        statisticsViewModel.statistics.observe(viewLifecycleOwner) { statistics ->
            if (statistics != null) {
                Log.d(LOG_API, "statistics: $statistics")
                setStatistics(statistics)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        initService()
    }

    /**
     * Initialize api services
     *
     * @author seonwoo
     */
    private fun initService() {

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                statisticsService.getDailyStatistics(this@HomeFragment, getUserEmail()!!, year, month, day)
                delay(60000)
            }
        }
    }

    /**
     * Initialize open weather service api
     *
     * @author seonwoo
     */
    private fun initOpenWeatherService(latitude: Double, longitude: Double) {
        CoroutineScope(Dispatchers.IO).launch {
            openWeatherService.getOpenWeather(this@HomeFragment, latitude, longitude)
        }
    }

    /**
     * @author seonwoo
     */
    private fun setDate() {
        val calendar = Calendar.getInstance()
        calendar.time = Date()

        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH) + 1
        day = calendar.get(Calendar.DAY_OF_MONTH)
    }

    private fun setWeatherIcon(todayWeather: String): String {
        return when (todayWeather) {
            "Clear" ->
                "☀️"

            "Clouds" ->
                "☁️"

            "Rain" ->
                "☔️"

            "Thunderstorm" ->
                "⚡️"

            "Snow" ->
                "❄️"

            else ->
                "🌫️"
        }
    }

    private fun setStatistics(statistics: DailyActivityStats) {
        binding.homeWarningCountTv.text = statistics.warningCount.toString()
        binding.homeActivityCountTv.text = statistics.activityCount.toString()
        binding.homeFallCountTv.text = statistics.fallCount.toString()
    }

    override fun onGetWeatherSuccess(todayWeather: String, todayTemperature: Float) {
        binding.homeWeatherIconTv.text = setWeatherIcon(todayWeather)

        val temperature = String.format(Locale.getDefault(), "%.1f", todayTemperature) + "℃"
        binding.homeTemperatureIconTv.text = temperature
    }

    override fun onGetWeatherFailure(code: Int, message: String) {
        Log.w(LOG_API, "Fail to call getWeather API: $code, $message")
        showToast(requireContext(), "날씨 정보를 불러오지 못하였습니다.")
    }

    override fun onGetDailyStatisticsSuccess(statistics: DailyActivityStats) {
        Log.d(LOG_API, "Success to call getDailyStatistics")
        statisticsViewModel.setDailyStatistics(
            statistics.warningCount,
            statistics.activityCount,
            statistics.fallCount
        )
    }

    override fun onGetDailyStatisticsFailure(message: String) {
        Log.w(LOG_API, "Fail to call getDailyStatistics")
        showToast(requireContext(), "일일 활동 통계 데이터 요청에 실패하였습니다.")
    }
}