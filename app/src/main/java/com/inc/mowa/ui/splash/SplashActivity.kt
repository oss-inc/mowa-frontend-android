package com.inc.mowa.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.databinding.ActivitySplashBinding
import com.inc.mowa.ui.introduction.IntroductionActivity
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.ui.main.MainActivity
import com.inc.mowa.utils.getIntroductionViewStatus
import com.inc.mowa.utils.getUserEmail

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isSeeAgain = getIntroductionViewStatus()
        if (isSeeAgain == 1) {
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
            return
        }

        binding.splashBgV.visibility = View.VISIBLE
        binding.splashLogoIv.visibility = View.VISIBLE

        // after 2 seconds, show next layout(activity)
        Handler(Looper.getMainLooper()).postDelayed({
            if (getUserEmail().equals("")) {
                // if not login, then go to logout layout
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                // if already login, then go to main layout
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }, 2000)
    }
}
