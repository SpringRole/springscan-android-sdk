package com.springscan.sdk.internal.apis.updateselfie

import com.springscan.sdk.internal.apis.initialize.RootResponse
import com.springscan.sdk.internal.apis.updateselfie.UpdateSelfieRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface UpdateSelfieAPI {
    @POST("user/person/{personID}/selfie")
    suspend fun updateDocDetails(@Body updateSelfieRequest: UpdateSelfieRequest,
                                 @Path("personID") personID: String): Response<RootResponse>
}
