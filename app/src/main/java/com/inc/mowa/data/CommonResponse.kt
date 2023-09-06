package com.inc.mowa.data

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("message") var message: String
)
