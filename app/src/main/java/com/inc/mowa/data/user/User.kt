package com.inc.mowa.data.user

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email") var email: String,
    @SerializedName("name") var name: String,
    @SerializedName("password") var password: String
)

data class SignUpResponse(
    @SerializedName("message") var message: String,
    @SerializedName("access_token") var accessToken: String
)

data class LoginRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)

data class LoginResponse(
    @SerializedName("access_token") var accessToken: String
)

data class SendEmailRequest(
    @SerializedName("email") var email: String
)

data class VerifyEmailRequest(
    @SerializedName("email") var email: String,
    @SerializedName("otp") var otp: Int
)

data class ChangePasswordRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)