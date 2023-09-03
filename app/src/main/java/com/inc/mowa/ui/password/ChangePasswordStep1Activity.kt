package com.inc.mowa.ui.password

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.databinding.ActivityChangePasswordStep1Binding
import com.inc.mowa.ui.login.LoginActivity

class ChangePasswordStep1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordStep1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordStep1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this@ChangePasswordStep1Activity, callback)

        initClickListener()
    }

    /**
     * When user click back button of android, then start login activity
     *
     * @author seonwoo
     */
    private val callback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            val intent = Intent(this@ChangePasswordStep1Activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // back to the previous activity (LoginActivity)
        binding.changePasswordStep1BtnBackV.setOnClickListener {
            finish()
        }

        // click send email for verification
        binding.changePasswordStep1SendEmailIv.setOnClickListener {
        }

        // click verify code from email
        binding.changePasswordStep1VerifyCodeIv.setOnClickListener {
        }

        // click email verification button
        binding.changePasswordStep1Btn.setOnClickListener {
        }
    }
}