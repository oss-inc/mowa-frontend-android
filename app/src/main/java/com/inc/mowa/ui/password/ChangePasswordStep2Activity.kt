package com.inc.mowa.ui.password

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.databinding.ActivityChangePasswordStep2Binding
import com.inc.mowa.ui.login.LoginActivity

class ChangePasswordStep2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordStep2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordStep2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
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
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}