package com.springscan.sdk.internal.apis

import com.google.gson.annotations.SerializedName

data class CommonErrorResponse(
    @SerializedName("message")
    var message: String? = null
)