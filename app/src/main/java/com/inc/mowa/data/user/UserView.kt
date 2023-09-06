package com.inc.mowa.data.user

import com.inc.mowa.data.CommonResponse

interface LoginView {
    fun onLoginSuccess(response: LoginResponse)
    fun onLoginFailure(message: String)
}

interface SignUpView {
    fun onSignUpSuccess(response: SignUpResponse)
    fun onSignUpFailure(message: String)
}

interface SendEmailView {
    fun onSendEmailSuccess(response: CommonResponse)
    fun onSendEmailFailure(message: String)
}

interface VerifyEmailView {
    fun onVerifyEmailSuccess(response: CommonResponse)
    fun onVerifyEmailFailure(message: String)
}

interface SendEmailForChangingPasswordView {
    fun onSendEmailForChangingPasswordSuccess(response: CommonResponse)
    fun onSendEmailForChangingPasswordFailure(message: String)
}

interface VerifyEmailForChangingPasswordView {
    fun onVerifyEmailForChangingPasswordSuccess(response: CommonResponse)
    fun onVerifyEmailForChangingPasswordFailure(message: String)
}

interface ChangePasswordView {
    fun onChangePasswordSuccess(response: CommonResponse)
    fun onChangePasswordFailure(message: String)
}
