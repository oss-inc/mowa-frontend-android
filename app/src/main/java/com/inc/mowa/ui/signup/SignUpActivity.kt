package com.inc.mowa.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.R
import com.inc.mowa.data.CommonResponse
import com.inc.mowa.data.user.SendEmailRequest
import com.inc.mowa.data.user.SendEmailView
import com.inc.mowa.data.user.SignUpRequest
import com.inc.mowa.data.user.SignUpResponse
import com.inc.mowa.data.user.SignUpView
import com.inc.mowa.data.user.UserService
import com.inc.mowa.data.user.VerifyEmailRequest
import com.inc.mowa.data.user.VerifyEmailView
import com.inc.mowa.databinding.ActivitySignupBinding
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.showToast

class SignUpActivity : AppCompatActivity(), SignUpView, SendEmailView, VerifyEmailView {
    private lateinit var binding: ActivitySignupBinding

    private val userService: UserService = UserService()

    private var isVerified = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTextWatcher()
        initClickListener()
    }

    override fun onStop() {
        super.onStop()
        isVerified = false
        binding.signupEmailEt.text.clear()
        binding.signupVerifyCodeEt.text.clear()
        binding.signupPasswordEt.text.clear()
        binding.signupPasswordConfirmEt.text.clear()
    }

    /**
     * Set TextWatcher for email validation from email EditText
     *
     * @author seonwoo
     */
    private fun initTextWatcher() {
        binding.signupEmailEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    val email = s.toString()

                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        // valid email
                        binding.signupErrorMessageTv.visibility = android.view.View.INVISIBLE
                    } else {
                        // invalid email
                        binding.signupErrorMessageTv.text = getString(R.string.error_invalid_email)
                        binding.signupErrorMessageTv.visibility = android.view.View.VISIBLE
                    }
                } else {
                    binding.signupErrorMessageTv.visibility = android.view.View.INVISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })
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
            userService.sendEmail(this, SendEmailRequest(binding.signupEmailEt.text.toString()))
        }

        // verify code from email
        binding.signupVerifyCodeIv.setOnClickListener {
            userService.verifyEmail(
                this, VerifyEmailRequest(
                    binding.signupEmailEt.text.toString(),
                    Integer.parseInt(binding.signupVerifyCodeEt.text.toString())
                )
            )
        }

        // click sign up button
        binding.signupBtn.setOnClickListener {

            val password = binding.signupPasswordEt.text.toString()
            val confirmPassword = binding.signupPasswordConfirmEt.text.toString()

            if (password == confirmPassword) {
                // password is same
                val signUpRequest = SignUpRequest(
                    binding.signupEmailEt.text.toString(),
                    binding.signupNameEt.text.toString(),
                    binding.signupPasswordEt.text.toString()
                )
                userService.signUp(this, signUpRequest)
            } else {
                // password is different
                showToast(this@SignUpActivity, getString(R.string.error_different_password))
            }
        }
    }

    override fun onSignUpSuccess(response: SignUpResponse) {
        showToast(this@SignUpActivity, "회원가입에 성공하였습니다.")

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onSignUpFailure(message: String) {
        Log.w(LOG_API, "Error on response of sign up: $message")
        showToast(this@SignUpActivity, "회원가입에 실패하였습니다.")
    }

    override fun onSendEmailSuccess(response: CommonResponse) {
        showToast(this@SignUpActivity, "해당 이메일로 인증 코드가 전송되었습니다.")
    }

    override fun onSendEmailFailure(message: String) {
        Log.w(LOG_API, "Error on response of send email: $message")
        showToast(this@SignUpActivity, "이메일 전송에 실패하였습니다.")
    }

    override fun onVerifyEmailSuccess(response: CommonResponse) {
        isVerified = true
        showToast(this@SignUpActivity, "인증에 성공하였습니다.")
    }

    override fun onVerifyEmailFailure(message: String) {
        Log.w(LOG_API, "Error on response of verify email: $message")
        showToast(this@SignUpActivity, "인증에 실패하였습니다.")
    }
}