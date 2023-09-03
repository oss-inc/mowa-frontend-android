package com.inc.mowa.utils

import com.inc.mowa.utils.ApplicationClass.Companion.TAG_INTRODUCTION_VIEW_STATUS
import com.inc.mowa.utils.ApplicationClass.Companion.TAG_USER_ID
import com.inc.mowa.utils.ApplicationClass.Companion.sharedPreferences

/**
 * Save user id to SharedPreferences
 *
 * @author namseonu
 */
fun setUserId(userId: String) {
    val editor = sharedPreferences.edit()
    editor.putString(TAG_USER_ID, userId)
    editor.apply()
}

/**
 * Get user id from SharedPreferences
 *
 * @author namseonu
 */
fun getUserId(): String? {
    return sharedPreferences.getString(TAG_USER_ID, "")
}

/**
 * Save introduction view status to SharedPreferences
 * The value 0 means 'not show'
 * The value 1 means 'allow show again'
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
