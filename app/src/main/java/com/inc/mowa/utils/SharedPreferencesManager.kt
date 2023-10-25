package com.inc.mowa.utils

import com.inc.mowa.utils.ApplicationClass.Companion.TAG_INTRODUCTION_VIEW_STATUS
import com.inc.mowa.utils.ApplicationClass.Companion.TAG_USER_EMAIL
import com.inc.mowa.utils.ApplicationClass.Companion.sharedPreferences

/**
 * Save user email to SharedPreferences
 *
 * @author namseonu
 */
fun setUserEmail(userEmail: String) {
    val editor = sharedPreferences.edit()
    editor.putString(TAG_USER_EMAIL, userEmail)
    editor.apply()
}

/**
 * Get user email from SharedPreferences
 *
 * @author namseonu
 */
fun getUserEmail(): String? {
    return sharedPreferences.getString(TAG_USER_EMAIL, "")
}

/**
 * Save introduction view status to SharedPreferences
 * The value 0 means 'not show'
 * The value 1 means 'allow show again'
 * The value 2 means 'from settings'
 */
fun setIntroductionViewStatus(introductionViewStatus: Int) {
    val editor = sharedPreferences.edit()
    editor.putInt(TAG_INTRODUCTION_VIEW_STATUS, introductionViewStatus)
    editor.apply()
}

/**
 * Get introduction view status from SharedPreferences
 */
fun getIntroductionViewStatus(): Int {
    return sharedPreferences.getInt(TAG_INTRODUCTION_VIEW_STATUS, 1)
}

fun setLatitude(latitude: String) {
    val editor = sharedPreferences.edit()
    editor.putString(ApplicationClass.TAG_LATITUDE, latitude)
    editor.apply()
}

fun getLatitude(): Double {
    val latitude = sharedPreferences.getString(ApplicationClass.TAG_LATITUDE, "")

    return if (latitude == null || latitude == "") {
        // default
        37.4507
    } else {
        latitude.toDouble()
    }
}

fun setLongitude(longitude: String) {
    val editor = sharedPreferences.edit()
    editor.putString(ApplicationClass.TAG_LONGITUDE, longitude)
    editor.apply()
}

fun getLongitude(): Double {
    val longitude = sharedPreferences.getString(ApplicationClass.TAG_LONGITUDE, "")

    return if (longitude == null || longitude == "") {
        // default
        127.1288
    } else {
        longitude.toDouble()
    }
}
