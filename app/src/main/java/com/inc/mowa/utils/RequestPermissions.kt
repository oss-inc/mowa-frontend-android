package com.inc.mowa.utils

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.inc.mowa.ui.main.MainActivity
import com.inc.mowa.utils.ApplicationClass.Companion.REQUEST_LOCATION
import com.inc.mowa.viewmodel.LocationViewModel

class RequestPermissions(private val context: Context, private val locationViewModel: LocationViewModel) {

    @RequiresApi(Build.VERSION_CODES.Q)
    private val permissionLocationUpApi29Impl = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.ACCESS_BACKGROUND_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS
    )

    @TargetApi(Build.VERSION_CODES.P)
    private val permissionsLocationDownApi29Impl = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS
    )

    /**
     * Request location information permission
     *
     * @author seonwoo
     */
    fun requestLocation() {

        if (Build.VERSION.SDK_INT >= 29) {

            if (ContextCompat.checkSelfPermission(
                    context,
                    permissionLocationUpApi29Impl[0]
                ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    permissionLocationUpApi29Impl[1]
                ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    permissionLocationUpApi29Impl[2]
                ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    permissionLocationUpApi29Impl[3]
                ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    context,
                    permissionLocationUpApi29Impl[4]
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    context as MainActivity,
                    permissionLocationUpApi29Impl,
                    REQUEST_LOCATION
                )
            } else {
                locationViewModel.startLocationUpdates()
            }
        } else {
            // Build.VERSION.SDK_INT < 29
            if (ActivityCompat.checkSelfPermission(
                    context,
                    permissionsLocationDownApi29Impl[0]
                ) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    context,
                    permissionsLocationDownApi29Impl[1]
                ) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    context,
                    permissionsLocationDownApi29Impl[2]
                ) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    context,
                    permissionsLocationDownApi29Impl[3]
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    context as MainActivity,
                    permissionsLocationDownApi29Impl,
                    REQUEST_LOCATION
                )
            } else {
                locationViewModel.startLocationUpdates()
            }
        }
    }
}