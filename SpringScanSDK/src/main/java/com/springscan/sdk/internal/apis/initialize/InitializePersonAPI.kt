package com.springscan.sdk.internal.apis.initialize

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface InitializePersonAPI {
    @POST("user/person/initialize")
    suspend fun initialize(@Body initializePersonRequest: InitializePersonRequest): Response<RootResponse>
}
