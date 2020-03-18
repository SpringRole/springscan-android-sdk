package com.springscan.sdk.internal.apis.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String?,
    @SerializedName("userId")
    val userID: String?,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("company_name")
    val companyName: String?
)