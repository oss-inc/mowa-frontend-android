package com.inc.mowa.data.welfarecenter

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WelfareCenterRetrofitInterface {

    @GET(".")
    fun getWelfareCenters(
        @Query("KEY") key: String,
        @Query("Type") type: String,
        @Query("pIndex") pageIndex: Int,
        @Query("pSize") pageSize: Int,
        @Query("SIGUNGU_NM") region: String?,
        @Query("FACLT_NM") faculty: String?
    ): Call<JsonObject>
}