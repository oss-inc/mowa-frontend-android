package com.inc.mowa.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.data.user.LoginRequest
import com.inc.mowa.data.user.LoginResponse
import com.inc.mowa.data.user.LoginView
import com.inc.mowa.data.user.UserService
import com.inc.mowa.databinding.ActivityLoginBinding
import com.inc.mowa.ui.main.MainActivity
import com.inc.mowa.ui.password.ChangePasswordStep1Activity
import com.inc.mowa.ui.signup.SignUpActivity
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.showToast
import com.inc.mowa.utils.setUserEmail

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var binding: ActivityLoginBinding

    private var userService: UserService = UserService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    override fun onStop() {
        super.onStop()
        binding.loginEmailEt.text.clear()
        binding.loginPasswordEt.text.clear()
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
            val loginRequest = LoginRequest(
                binding.loginEmailEt.text.toString(),
                binding.loginPasswordEt.text.toString()
            )

            userService.login(this, loginRequest)
        }
    }

    override fun onLoginSuccess(response: LoginResponse) {
        setUserEmail(binding.loginEmailEt.text.toString())
        showToast(this@LoginActivity, "로그인에 성공했습니다.")

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginFailure(message: String) {
        Log.w(LOG_API, "Error on response of login: $message")
        showToast(this@LoginActivity, "로그인에 실패했습니다.")
    }
}