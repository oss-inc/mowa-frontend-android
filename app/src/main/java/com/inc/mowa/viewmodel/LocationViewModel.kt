package com.inc.mowa.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)
    private val _currentLocation = MutableLiveData<LocationValue?>()

    private val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000)
        .setWaitForAccurateLocation(false)
        .setMinUpdateIntervalMillis(3000)
        .setMaxUpdateDelayMillis(100)
        .build()

    private var locationListener: LocationListener = LocationListener { location ->
        setLocation(location.latitude, location.longitude)
        Log.d(LOG_LOCATION, "location: $location")
    }

    val currentLocation get() = _currentLocation

    init {
        // initialize
        setLocation(37.6583599, 126.8320201)
    }

    override fun onCleared() {
        super.onCleared()
        fusedLocationClient.removeLocationUpdates(locationListener)
    }

    /**
     * Start location service
     *
     * @author seonwoo
     */
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        GlobalScope.launch(Dispatchers.IO) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest, locationListener, Looper.getMainLooper()
            )
        }
    }

    /**
     * Set location value to live data
     *
     * @author seonwoo
     */
    private fun setLocation(latitude: Double, longitude: Double) {
        _currentLocation.value = LocationValue(latitude, longitude)
        Log.d(
            LOG_LOCATION,
            "currentLocation: (${currentLocation.value!!.latitude}, ${currentLocation.value!!.longitude})"
        )
    }
}