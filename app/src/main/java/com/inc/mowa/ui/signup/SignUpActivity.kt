package com.inc.mowa.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // back to the previous activity (LoginActivity)
        binding.signupBtnBackV.setOnClickListener {
            finish()
        }

        // send email for verification
        binding.signupSendEmailIv.setOnClickListener {
        }

        // verify code from email
        binding.signupVerifyCodeIv.setOnClickListener {
        }

        // click sign up button
        binding.signupBtn.setOnClickListener {
        }
    }
}