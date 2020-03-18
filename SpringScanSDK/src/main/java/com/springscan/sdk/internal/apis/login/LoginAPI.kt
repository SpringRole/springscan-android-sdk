package com.springscan.sdk.internal.apis.login

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@Field("email") email:String, @Field("password") password:String) : Response<LoginResponse>
}