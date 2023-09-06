package com.inc.mowa.data.user

import com.inc.mowa.data.CommonResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserRetrofitInterface {

    @POST("/user/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>

    @POST("/user/signup")
    fun signUp(
        @Body signUpRequest: SignUpRequest
    ): Call<SignUpResponse>

    @POST("/user/emails")
    fun sendEmail(
        @Body sendEmailRequest: SendEmailRequest
    ): Call<CommonResponse>

    @POST("/user/emails/verifications")
    fun verifyEmail(
        @Body verifyEmailRequest: VerifyEmailRequest
    ): Call<CommonResponse>

    @POST("/user/passwords")
    fun sendEmailForChangingPassword(
        @Body sendEmailRequest: SendEmailRequest
    ): Call<CommonResponse>

    @POST("/user/passwords/verifications")
    fun verifyEmailForChangingPassword(
        @Body verifyEmailRequest: VerifyEmailRequest
    ): Call<CommonResponse>

    @PATCH("/user/passwords")
    fun changePassword(
        @Body changePasswordRequest: ChangePasswordRequest
    ): Call<CommonResponse>
}