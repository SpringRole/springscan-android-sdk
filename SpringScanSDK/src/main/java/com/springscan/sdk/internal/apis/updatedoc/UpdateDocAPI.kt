package com.springscan.sdk.internal.apis.updatedoc

import com.springscan.sdk.internal.apis.initialize.InitializePersonRequest
import com.springscan.sdk.internal.apis.initialize.RootResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface UpdateDocAPI {
    @POST("user/person/{personID}/document")
    suspend fun updateDocDetails(@Body initializePersonRequest: InitializePersonRequest,
                                 @Path("personID") personID: String): Response<RootResponse>
}
