package com.springrole.springscan.api.upload

import com.springscan.sdk.internal.apis.uploaddoc.UploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadAPI {
    @Multipart
    @POST("user/person/upload")
    suspend fun uploadDocument(
        @Part  body: MultipartBody.Part, @Part("person_id") personID: String?
    ): Response<UploadResponse>
}
