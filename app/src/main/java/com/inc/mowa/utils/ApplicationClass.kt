package com.inc.mowa.utils

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.provider.Settings
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {

    companion object {

        const val TAG_APP: String = "MOWA"
        const val TAG_USER_ID: String = "USER_ID"
        const val TAG_INTRODUCTION_VIEW_STATUS: String = "INTRODUCTION_VIEW_STATUS"

        const val LOG_APP: String = "MoWA"
        const val LOG_LOCATION: String = "Location"

        const val REQUEST_LOCATION: Int = 0x00000001

        private const val BASE_URL: String = "http://localhost:5000"

        lateinit var sharedPreferences: SharedPreferences
        lateinit var retrofit: Retrofit

        /**
         * Using intent, move to setting associated with alarm
         */
        fun getNotificationIntent(packageName: String, uid: Int): Intent {
            val intent = Intent().apply {
                action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
            }

            return intent
        }
    }

    /**
     * Initialize this application
     */
    override fun onCreate() {
        super.onCreate()

        // initialize shared preferneces
        sharedPreferences = applicationContext.getSharedPreferences(TAG_APP, Context.MODE_PRIVATE)

        // setup http client
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
