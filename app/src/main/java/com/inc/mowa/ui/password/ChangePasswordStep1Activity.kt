package com.inc.mowa.ui.password

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.data.CommonResponse
import com.inc.mowa.data.user.SendEmailForChangingPasswordView
import com.inc.mowa.data.user.SendEmailRequest
import com.inc.mowa.data.user.UserService
import com.inc.mowa.data.user.VerifyEmailForChangingPasswordView
import com.inc.mowa.data.user.VerifyEmailRequest
import com.inc.mowa.databinding.ActivityChangePasswordStep1Binding
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.utils.ApplicationClass
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.showToast

class ChangePasswordStep1Activity : AppCompatActivity(), SendEmailForChangingPasswordView,
    VerifyEmailForChangingPasswordView {
    private lateinit var binding: ActivityChangePasswordStep1Binding

    private val userService: UserService = UserService()

    private var isVerified = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordStep1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this@ChangePasswordStep1Activity, callback)

        initClickListener()
    }

    override fun onStop() {
        super.onStop()
        isVerified = false
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
            userService.sendEmailForChangingPassword(
                this,
                SendEmailRequest(binding.changePasswordStep1EmailEt.text.toString())
            )
        }

        // click verify code from email
        binding.changePasswordStep1VerifyCodeIv.setOnClickListener {
            userService.verifyEmailForChangingPassword(
                this,
                VerifyEmailRequest(
                    binding.changePasswordStep1EmailEt.text.toString(),
                    Integer.parseInt(binding.changePasswordStep1VerifyCodeEt.text.toString())
                )
            )
        }

        // click email verification button
        binding.changePasswordStep1Btn.setOnClickListener {
            val intent = Intent(this, ChangePasswordStep2Activity::class.java)
            intent.putExtra("email", binding.changePasswordStep1EmailEt.text.toString())
            startActivity(intent)
            finish()
        }
    }

    override fun onSendEmailForChangingPasswordSuccess(response: CommonResponse) {
        showToast(this@ChangePasswordStep1Activity, "해당 이메일로 인증 코드가 전송되었습니다.")
    }

    override fun onSendEmailForChangingPasswordFailure(message: String) {
        Log.w(LOG_API, "Error on response of send email: $message")
        showToast(this@ChangePasswordStep1Activity, "이메일 전송에 실패하였습니다.")
    }

    override fun onVerifyEmailForChangingPasswordSuccess(response: CommonResponse) {
        isVerified = true
        showToast(this@ChangePasswordStep1Activity, "인증에 성공하였습니다.")
    }

    override fun onVerifyEmailForChangingPasswordFailure(message: String) {
        Log.w(LOG_API, "Error on response of verify email: $message")
        showToast(this@ChangePasswordStep1Activity, "인증에 실패하였습니다.")
    }
}
