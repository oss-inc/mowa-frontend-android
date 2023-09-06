package com.inc.mowa.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.inc.mowa.R
import com.inc.mowa.databinding.ActivityMainBinding
import com.inc.mowa.ui.introduction.IntroductionActivity
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.ui.main.home.HomeFragment
import com.inc.mowa.ui.main.phonebook.PhoneBookFragment
import com.inc.mowa.ui.main.statistics.StatisticsFragment
import com.inc.mowa.ui.policy.PrivacyInformationPolicyActivity
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_APP
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import com.inc.mowa.utils.ApplicationClass.Companion.REQUEST_LOCATION
import com.inc.mowa.utils.ApplicationClass.Companion.getNotificationIntent
import com.inc.mowa.utils.RequestPermissions
import com.inc.mowa.utils.getAlarmPermissionStatus
import com.inc.mowa.utils.setUserEmail
import com.inc.mowa.viewmodel.LocationViewModel
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeNavigationItem: MenuItem
    private lateinit var alarmPermissionSwitch: SwitchCompat
    private lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
        initSideMenu()
        initClickListener()

        locationViewModel = ViewModelProvider(this@MainActivity)[LocationViewModel::class.java]
        RequestPermissions(this, locationViewModel).requestLocation()
    }

    override fun onResume() {
        super.onResume()

        val isAlarmPermitted = getAlarmPermissionStatus(this@MainActivity)
        if (isAlarmPermitted) {
            // if alarm was permitted
            alarmPermissionSwitch.toggle()
            alarmPermissionSwitch.isChecked = true
        } else {
            // if alarm was not permitted
            alarmPermissionSwitch.isChecked = false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            // alarm
            R.id.setting_alarm_item -> {
                startActivity(getNotificationIntent(packageName, applicationInfo?.uid!!))
            }

            // logout
            R.id.setting_logout_item -> {
                showLogoutDialog()
            }

            // application introduction
            R.id.setting_app_intro_item -> {
                val intent = Intent(this@MainActivity, IntroductionActivity::class.java)
                startActivity(intent)
            }

            // policy of privacy information
            R.id.setting_privacy_item -> {
                val intent = Intent(this@MainActivity, PrivacyInformationPolicyActivity::class.java)
                startActivity(intent)
            }
        }
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(LOG_APP, "MainActivity.onRequestPermissionsResult")

        when (requestCode) {
            REQUEST_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_LOCATION, "Granted location permission by user")
                    locationViewModel.startLocationUpdates()
                } else {
                    Log.d(LOG_LOCATION, "Not granted location permission by user")
                }
            }
        }
    }

    /**
     * Initialize bottom navigation view
     *
     * @author seonwoo
     */
    private fun initBottomNavigation() {
        homeNavigationItem = binding.mainBnvL.mainBnv.menu.getItem(1)
        binding.mainBnvL.mainBnvCenterIv.bringToFront()
        homeNavigationItem.isChecked = true

        // set home fragment at first
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_bnv_fl, HomeFragment())
            .commitAllowingStateLoss()

        // setup bottom navigation listener
        binding.mainBnvL.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                // statistics fragment
                R.id.bnv_statistics_item -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_bnv_fl, StatisticsFragment())
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }

                // statistics fragment
                R.id.bnv_phonebook_item -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_bnv_fl, PhoneBookFragment())
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    /**
     * Initialize side bar menu (DrawerLayout)
     *
     * @author seonwoo
     */
    private fun initSideMenu() {
        binding.mainNv.setNavigationItemSelectedListener(this)

        val menuItem = binding.mainNv.menu.findItem(R.id.setting_alarm_item)

        alarmPermissionSwitch =
            menuItem.actionView?.findViewById(R.id.setting_menu_switch) as SwitchCompat
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // click home button at bottom navigation
        binding.mainBnvL.mainBnvCenterIv.setOnClickListener {
            homeNavigationItem.isChecked = true

            supportFragmentManager.beginTransaction()
                .replace(R.id.main_bnv_fl, HomeFragment())
                .commitAllowingStateLoss()
        }

        // click side menu icon at main activity
        binding.mainBnvL.mainBnvSettingIv.setOnClickListener {
            if (!binding.mainDl.isDrawerOpen(GravityCompat.START)) {
                // if side menu was closed, then open
                binding.mainDl.openDrawer(GravityCompat.START)
            }
        }

        // click setting menu icon at side menu
        val headerView = binding.mainNv.getHeaderView(0)
        headerView.findViewById<ImageView>(R.id.main_header_iv).setOnClickListener {
            // close side menu
            binding.mainDl.closeDrawer(GravityCompat.START)
        }
    }

    /**
     * Show popup window to check logout
     *
     * @author seonwoo
     */
    private fun showLogoutDialog() {
        AlertDialog.Builder(this@MainActivity, R.style.dialog)
            .setTitle("로그아웃")
            .setMessage("로그아웃을 하시겠습니까?")
            .setIcon(R.drawable.ic_mowa_not_title)
            .setPositiveButton("예") { _, _ ->
                // if click yes
                setUserEmail("")

                val intent: Intent = Intent(this@MainActivity, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("아니오") { dialog, _ ->
                // if click no
                dialog.dismiss()
            }
            .create()
            .show()
    }
}