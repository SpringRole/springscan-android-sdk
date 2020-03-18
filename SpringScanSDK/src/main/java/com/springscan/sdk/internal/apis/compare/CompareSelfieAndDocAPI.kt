package com.springscan.sdk.internal.apis.compare

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CompareSelfieAndDocAPI {
    @POST("user/person/{personID}/compare-selfie-and-document")
    suspend fun compare(
        @Path("personID") personID: String,
        @Body compareRequest: CompareRequest
    ): Response<CompareResult>
}
