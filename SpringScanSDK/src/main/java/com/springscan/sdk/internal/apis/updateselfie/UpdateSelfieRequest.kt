package com.springscan.sdk.internal.apis.updateselfie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdateSelfieRequest (
    @SerializedName("selfieurl")
    val selfie: String?
): Parcelable