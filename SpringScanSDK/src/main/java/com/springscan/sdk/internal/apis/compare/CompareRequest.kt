package com.springscan.sdk.internal.apis.compare

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompareRequest(
    @SerializedName("docType")
    var docType: String
) : Parcelable