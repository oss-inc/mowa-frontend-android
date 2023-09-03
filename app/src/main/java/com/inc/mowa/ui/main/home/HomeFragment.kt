package com.inc.mowa.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.inc.mowa.data.weather.OpenWeatherService
import com.inc.mowa.data.weather.OpenWeatherView
import com.inc.mowa.databinding.FragmentHomeBinding
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import com.inc.mowa.utils.ApplicationClass.Companion.showToast
import com.inc.mowa.viewmodel.LocationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment(), OpenWeatherView {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var openWeatherService: OpenWeatherService

    private val locationViewModel: LocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initService()
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
    }

    /**
     * Initialize api services
     *
     * @author seonwoo
     */
    private fun initService() {
        openWeatherService = OpenWeatherService()
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
    private fun getDateTime(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
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
}