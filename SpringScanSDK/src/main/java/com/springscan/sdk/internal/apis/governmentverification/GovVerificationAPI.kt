package com.springscan.sdk.internal.apis.governmentverification

import com.springscan.sdk.DocType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface GovVerificationAPI {
    @POST("/v2/user/person/governmentCheck/{docType}/{docID}")
    suspend fun startDLVerification(@Path("docID") docID: String, @Path("docType") docType: String = DocType.AADHAAR.apiString): Response<DLResponse>

    @POST("/v2/user/person/governmentCheck/{docType}/{docID}")
    suspend fun startPanVerification(@Path("docID") docID: String, @Path("docType") docType: String = DocType.PAN.apiString): Response<PanResponse>

    @POST("/v2/user/person/governmentCheck/{docType}/{docID}")
    suspend fun startVoterIDVerification(@Path("docID") docID: String, @Path("docType") docType: String = DocType.VOTER.apiString): Response<VoterIDResponse>

    @POST("/v2/user/person/governmentCheck/{docType}/{docID}")
    suspend fun startAadhaarVerification(@Path("docID") docID: String, @Path("docType") docType: String = DocType.VOTER.apiString): Response<AadhaarResponse>

    @POST("/v2/user/person/governmentCheckDirect")
    suspend fun noOCRDLVerification(@Body dlRequest: DLRequest): Response<DLResponse>

    @POST("/v2/user/person/governmentCheckDirect")
    suspend fun noOCRPanVerification(@Body panRequest: PanRequest): Response<PanResponse>

    @POST("/v2/user/person/governmentCheckDirect")
    suspend fun noOCRVoterIDVerification(@Body voterIDRequest: VoterIDRequest): Response<VoterIDResponse>

    @POST("/v2/user/person/governmentCheckDirect")
    suspend fun noOCRAadhaarVerification(@Body aadhaarRequest: AadhaarRequest): Response<AadhaarResponse>

}