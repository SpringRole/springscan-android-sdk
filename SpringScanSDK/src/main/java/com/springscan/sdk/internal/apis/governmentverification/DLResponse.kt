package com.springscan.sdk.internal.apis.governmentverification

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DLResponse (
    @SerializedName("result")
    val result: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("ocr")
    val ocr: DLOcr,
    @SerializedName("matched_information")
    val matchedInformation: DLMatchedInformation
): Parcelable

@Parcelize
data class IssueDates (
    @SerializedName("LMV")
    val lMV: String,
    @SerializedName("MCWG")
    val mCWG: String,
    @SerializedName("TRANS")
    val tRANS: String
): Parcelable

@Parcelize
data class DLMatchedInformation (
    @SerializedName("message")
    val message: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("dl_status")
    val dlStatus: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("name_match")
    val nameMatch: Double,
    @SerializedName("dob_match")
    val dobMatch: Boolean,
    @SerializedName("ocr_id_match")
    val ocrIdMatch: Boolean
): Parcelable

@Parcelize
data class DLOcr (
    @SerializedName("address")
    val address: String,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
    @SerializedName("date_of_validity")
    val dateOfValidity: String,
    @SerializedName("fathers_name")
    val fathersName: String,
    @SerializedName("id_number")
    val idNumber: String,
    @SerializedName("is_scanned")
    val isScanned: String,
    @SerializedName("issue_dates")
    val issueDates: IssueDates,
    @SerializedName("name_on_card")
    val nameOnCard: String,
    @SerializedName("pincode")
    val pincode: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street_address")
    val streetAddress: String,
    @SerializedName("type")
    val type: List<String>,
    @SerializedName("validity")
    val validity: Validity
): Parcelable

@Parcelize
data class Validity (
    @SerializedName("NT")
    val nT: String,
    @SerializedName("T")
    val t: String
): Parcelable