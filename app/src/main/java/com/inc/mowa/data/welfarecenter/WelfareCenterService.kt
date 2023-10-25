package com.inc.mowa.data.welfarecenter

import android.util.Log
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.inc.mowa.BuildConfig
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WelfareCenterService {

    private val retrofit = Retrofit.Builder().baseUrl(BuildConfig.WELFARE_CENTER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val welfareCenterService: WelfareCenterRetrofitInterface =
        retrofit.create(WelfareCenterRetrofitInterface::class.java)

    fun getWelfareCenters(welfareCenterView: WelfareCenterView, region: String?) {
        val key: String = BuildConfig.WELFARE_CENTER_API_KEY
        val type = "json"
        val pageIndex = 1
        val pageSize = 20

        val welfareCenters = ArrayList<WelfareCenter>()

        welfareCenterService.getWelfareCenters(key, type, pageIndex, pageSize, region, null)
            .enqueue(object : Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                    Log.d(LOG_API, "(getWelfareCenters) region: $region")
                    Log.d(LOG_API, "(getWelfareCenters) response: $response")
                    Log.d(LOG_API, "(getWelfareCenters) response.body: ${response.body()}")

                    if (response.code() == 200 && response.body() != null) {
                        val mResponse = response.body()!!
                        val root = mResponse.get("HtygdWelfaclt").asJsonArray
                        val head = root.get(0).asJsonObject.get("head").asJsonArray
                        val body = root.get(1).asJsonObject.asJsonObject.get("row").asJsonArray

                        // Head parsing
                        val code: String =
                            head.get(1).asJsonObject.get("RESULT").asJsonObject.get("CODE").asString
                        val message: String =
                            head.get(1).asJsonObject.get("RESULT").asJsonObject.get("MESSAGE").asString

                        if (code == "INFO-000") {
                            // Body parsing
                            for (i in 0 until body.size()) {
                                val jsonObject = body.get(i)

                                val facultyName: String =
                                    jsonObject.asJsonObject.get("FACLT_NM").asString
                                val facultyType: String =
                                    jsonObject.asJsonObject.get("FACLT_KIND_NM").asString

                                val telephoneNumber: String? =
                                    if (jsonObject.asJsonObject.get("DETAIL_TELNO").isJsonNull) null else jsonObject.asJsonObject.get(
                                        "DETAIL_TELNO"
                                    ).asString

                                val latitude: Double? =
                                    if (jsonObject.asJsonObject.get("REFINE_WGS84_LAT").isJsonNull) null else jsonObject.asJsonObject.get(
                                        "REFINE_WGS84_LAT"
                                    ).asDouble

                                val longitude: Double? =
                                    if (jsonObject.asJsonObject.get("REFINE_WGS84_LOGT").isJsonNull) null else jsonObject.asJsonObject.get(
                                        "REFINE_WGS84_LOGT"
                                    ).asDouble

                                val roadAddress: String? =
                                    if (jsonObject.asJsonObject.get("REFINE_ROADNM_ADDR").isJsonNull) null else jsonObject.asJsonObject.get(
                                        "REFINE_ROADNM_ADDR"
                                    ).asString
                                val address: String? =
                                    if (jsonObject.asJsonObject.get("REFINE_LOTNO_ADDR").isJsonNull) null else jsonObject.asJsonObject.get(
                                        "REFINE_LOTNO_ADDR"
                                    ).asString

                                val welfareCenter = WelfareCenter(
                                    facultyName,
                                    facultyType,
                                    roadAddress,
                                    address,
                                    telephoneNumber,
                                    latitude,
                                    longitude
                                )

                                welfareCenters.add(welfareCenter)
                            }

                            welfareCenterView.onGetWelfareCenterSuccess(welfareCenters)

                        } else {
                            welfareCenterView.onGetWelfareCenterFailure(
                                response.code(), "$code $message"
                            )
                        }
                    } else {
                        welfareCenterView.onGetWelfareCenterFailure(
                            response.code(), response.message()
                        )
                    }
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    welfareCenterView.onGetWelfareCenterFailure(500, t.toString())
                }
            })
    }
}
