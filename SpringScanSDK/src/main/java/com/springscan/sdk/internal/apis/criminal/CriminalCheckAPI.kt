package com.springscan.sdk.internal.apis.criminal

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CriminalCheckAPI {
    @POST("criminal/courtCheck/{personID}")
    suspend fun courtCheck(
        @Path("personID") personID: String
    ): Response<CourtResponse>

    @POST("criminal/searchDirect")
    suspend fun searchDirect(
        @Body courtCheckRequest: CourtCheckRequest
    ): Response<CourtResponse>

}