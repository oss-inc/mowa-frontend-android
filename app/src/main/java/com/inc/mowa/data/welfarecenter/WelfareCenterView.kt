package com.inc.mowa.data.welfarecenter

interface WelfareCenterView {
    fun onGetWelfareCenterSuccess(welfareCenters: List<WelfareCenter>)
    fun onGetWelfareCenterFailure(code: Int, message: String)
}
