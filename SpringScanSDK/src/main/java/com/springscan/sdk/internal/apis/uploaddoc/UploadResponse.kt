package com.springscan.sdk.internal.apis.uploaddoc

import com.google.gson.annotations.SerializedName

data class UploadResponse (
    @SerializedName("ind_aadhaar")
    val aadhaarUploadInfo: DocUploadInfo? = null,
    @SerializedName("ind_pan")
    val panUploadInfo: DocUploadInfo? = null,
    @SerializedName("ind_driving_license")
    val drivingLicenseUploadInfo: DocUploadInfo? = null,
    @SerializedName("ind_passport_front")
    val passportFrontUploadInfo: DocUploadInfo? = null,
    @SerializedName("ind_passport_back")
    val passportBackUploadInfo: DocUploadInfo? = null,
    @SerializedName("ind_voter_id")
    val voterId: DocUploadInfo? = null,
    @SerializedName("face_image")
    val faceUploadInfo: DocUploadInfo? = null
)

data class DocUploadInfo(
    @SerializedName("Location")
    val url: String? = null,
    @SerializedName("Bucket")
    val bucket: String? = null,
    @SerializedName("mimeType")
    val mimeType: String? = null
)