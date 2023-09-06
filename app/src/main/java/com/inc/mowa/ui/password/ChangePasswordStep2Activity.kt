package com.inc.mowa.ui.password

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.data.CommonResponse
import com.inc.mowa.data.user.ChangePasswordRequest
import com.inc.mowa.data.user.ChangePasswordView
import com.inc.mowa.data.user.UserService
import com.inc.mowa.databinding.ActivityChangePasswordStep2Binding
import com.inc.mowa.ui.login.LoginActivity
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.showToast

class ChangePasswordStep2Activity : AppCompatActivity(), ChangePasswordView {
    private lateinit var binding: ActivityChangePasswordStep2Binding

    private val userService: UserService = UserService()

    private var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordStep2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    override fun onResume() {
        super.onResume()

        intent.getStringExtra("email")?.let {
            email = it
        }
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // back to the previous activity (ChangePasswordStep1Activity)
        binding.changePasswordStep2BtnBackV.setOnClickListener {
            val intent = Intent(this, ChangePasswordStep1Activity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // click change password button
        binding.changePasswordStep2Btn.setOnClickListener {
            userService.changePassword(
                this,
                ChangePasswordRequest(
                    email,
                    binding.changePasswordStep2EmailEt.text.toString()
                )
            )
        }
    }

    override fun onChangePasswordSuccess(response: CommonResponse) {
        showToast(this@ChangePasswordStep2Activity, "비밀번호가 변경되었습니다.")

        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onChangePasswordFailure(message: String) {
        Log.w(LOG_API, "Error on response of change password: $message")
        showToast(this@ChangePasswordStep2Activity, "비밀번호 변경에 실패하였습니다.")
    }
}