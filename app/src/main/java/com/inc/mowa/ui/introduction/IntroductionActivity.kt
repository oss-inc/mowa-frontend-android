package com.inc.mowa.ui.introduction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.R
import com.inc.mowa.databinding.ActivityIntroductionBinding
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.utils.getIntroductionViewStatus
import com.inc.mowa.utils.setIntroductionViewStatus

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding

    private var isShown = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()
        initClickListener()
    }

    override fun onStart() {
        super.onStart()

        if (getIntroductionViewStatus() == 0) {
            // already check not show
            startLoginActivity()
        }
    }

    /**
     * Initialize fragments containing application introduction contents
     *
     * @author seonwoo
     */
    private fun initFragments() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.introduction_fl, IntroductionFragment())
            .commitAllowingStateLoss()
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // click close button
        binding.introductionExitIv.setOnClickListener {
            isShown = if (binding.introductionNotShowCb.isChecked) 0 else 1
            setIntroductionViewStatus(isShown)
            startLoginActivity()
        }
    }

    /**
     * Start activity (LoginActivity)
     *
     * @author seonwoo
     */
    private fun startLoginActivity() {
        val intent = Intent(this@IntroductionActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}