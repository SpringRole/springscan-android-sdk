package com.springscan.sdk.internal.apis.governmentverification

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PanMatchedInformation (
    @SerializedName("message")
    val message: String?,
    @SerializedName("id_match")
    val idMatch: Boolean?,
    @SerializedName("name_match")
    val nameMatch: Boolean?,
    @SerializedName("dob_match")
    val dobMatch: Boolean?
): Parcelable

@Parcelize
data class PanOcr (
    @SerializedName("age")
    val age: Int?,
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @SerializedName("date_of_issue")
    val dateOfIssue: String?,
    @SerializedName("fathers_name")
    val fathersName: String?,
    @SerializedName("id_number")
    val idNumber: String?,
    @SerializedName("is_scanned")
    val isScanned: Boolean?,
    @SerializedName("minor")
    val minor: Boolean?,
    @SerializedName("name_on_card")
    val nameOnCard: String?,
    @SerializedName("pan_type")
    val panType: String?
): Parcelable

@Parcelize
data class PanResponse (
    @SerializedName("result")
    val result: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("ocr")
    val ocr: PanOcr?,
    @SerializedName("matched_information")
    val matchedInformation: PanMatchedInformation?
): Parcelable