package com.inc.mowa.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.databinding.ActivityLoginBinding
import com.inc.mowa.ui.main.MainActivity
import com.inc.mowa.ui.password.ChangePasswordStep1Activity
import com.inc.mowa.ui.signup.SignUpActivity
import com.inc.mowa.utils.setUserEmail

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // click sign up button
        binding.loginSignupTv.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // click change password button
        binding.loginChangePasswordTv.setOnClickListener {
            val intent = Intent(this, ChangePasswordStep1Activity::class.java)
            startActivity(intent)
        }

        // click login button
        binding.loginBtn.setOnClickListener {
            // TODO: confirm email login id & password

            setUserEmail(binding.loginEmailEt.text.toString())

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // click google login button
        binding.loginGoogleCl.setOnClickListener {
            // TODO: implement google login
        }
    }
}