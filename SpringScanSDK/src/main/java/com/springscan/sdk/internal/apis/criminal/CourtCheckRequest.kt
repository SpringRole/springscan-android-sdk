package com.springscan.sdk.internal.apis.criminal

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourtCheckRequest(
    @SerializedName("name")
    var name: String?,
    @SerializedName("fatherName")
    var fatherName: String?,
    @SerializedName("address")
    var address: String?
): Parcelable