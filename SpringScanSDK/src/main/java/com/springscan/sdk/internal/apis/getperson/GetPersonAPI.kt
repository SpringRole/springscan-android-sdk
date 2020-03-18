package com.springscan.sdk.internal.apis.getperson

import com.springscan.sdk.internal.apis.initialize.RootResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetPersonAPI {
    @GET("user/person/{personID}")
    suspend fun getPerson(@Path("personID") personID: String): Response<RootResponse>
}
