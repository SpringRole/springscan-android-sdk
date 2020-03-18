package com.springscan.sdk.internal.apis.initialize

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InitializePersonRequest(
    @SerializedName("document1")
    val doc1: String?,
    @SerializedName("document2")
    val doc2: String?,
    @SerializedName("selfie")
    val selfie: String?,
    @SerializedName("docType")
    val docType: String?
): Parcelable