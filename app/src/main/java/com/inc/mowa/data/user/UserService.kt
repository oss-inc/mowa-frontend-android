package com.inc.mowa.data.user

import android.util.Log
import com.inc.mowa.data.CommonResponse
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserService {

    private val userRetrofitInterface: UserRetrofitInterface =
        retrofit.create(UserRetrofitInterface::class.java)

    fun login(loginView: LoginView, loginRequest: LoginRequest) {

        userRetrofitInterface.login(loginRequest).enqueue(object : Callback<LoginResponse> {

            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of login")
                    return
                }
                loginView.onLoginSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of login: $t")
                loginView.onLoginFailure(t.message!!)
            }

        })
    }

    fun signUp(signUpView: SignUpView, signUpRequest: SignUpRequest) {

        userRetrofitInterface.signUp(signUpRequest).enqueue(object : Callback<SignUpResponse> {

            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of signUp")
                    return
                }
                signUpView.onSignUpSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of signUp: $t")
                signUpView.onSignUpFailure(t.message!!)
            }

        })
    }

    fun sendEmail(sendEmailView: SendEmailView, sendEmailRequest: SendEmailRequest) {

        userRetrofitInterface.sendEmail(sendEmailRequest).enqueue(object : Callback<CommonResponse> {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of sendEmail")
                    return
                }
                sendEmailView.onSendEmailSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of sendEmail: $t")
                sendEmailView.onSendEmailFailure(t.message!!)
            }

        })
    }

    fun verifyEmail(verifyEmailView: VerifyEmailView, verifyEmailRequest: VerifyEmailRequest) {

        userRetrofitInterface.verifyEmail(verifyEmailRequest).enqueue(object : Callback<CommonResponse> {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of verifyEmail")
                    return
                }
                verifyEmailView.onVerifyEmailSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of verifyEmail: $t")
                verifyEmailView.onVerifyEmailFailure(t.message!!)
            }

        })
    }

    fun sendEmailForChangingPassword(sendEmailForChangingPasswordView: SendEmailForChangingPasswordView, sendEmailRequest: SendEmailRequest) {

        userRetrofitInterface.sendEmailForChangingPassword(sendEmailRequest).enqueue(object : Callback<CommonResponse> {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of sendEmailForChangingPassword")
                    return
                }
                sendEmailForChangingPasswordView.onSendEmailForChangingPasswordSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of sendEmailForChangingPassword: $t")
                sendEmailForChangingPasswordView.onSendEmailForChangingPasswordFailure(t.message!!)
            }

        })
    }

    fun verifyEmailForChangingPassword(verifyEmailForChangingPasswordView: VerifyEmailForChangingPasswordView, verifyEmailRequest: VerifyEmailRequest) {

        userRetrofitInterface.verifyEmailForChangingPassword(verifyEmailRequest).enqueue(object : Callback<CommonResponse> {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of verifyEmailForChangingPassword")
                    return
                }
                verifyEmailForChangingPasswordView.onVerifyEmailForChangingPasswordSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of verifyEmailForChangingPassword: $t")
                verifyEmailForChangingPasswordView.onVerifyEmailForChangingPasswordFailure(t.message!!)
            }

        })
    }

    fun changePassword(changePasswordView: ChangePasswordView, changePasswordRequest: ChangePasswordRequest) {

        userRetrofitInterface.changePassword(changePasswordRequest).enqueue(object : Callback<CommonResponse> {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (!response.isSuccessful) {
                    Log.w(LOG_API, "Error on response of changePassword")
                    return
                }
                changePasswordView.onChangePasswordSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.w(LOG_API, "Error on response of changePassword: $t")
                changePasswordView.onChangePasswordFailure(t.message!!)
            }

        })
    }
}