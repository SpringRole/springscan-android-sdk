package com.springscan.sdk.internal.apis.compare

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.springscan.sdk.internal.apis.initialize.MatchResult
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompareResult (
    @SerializedName("matchResult")
    val matchResult: MatchResult? = null
): Parcelable