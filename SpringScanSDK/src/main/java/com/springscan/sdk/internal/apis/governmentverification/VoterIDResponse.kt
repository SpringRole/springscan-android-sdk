package com.springscan.sdk.internal.apis.governmentverification

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VoterMatchedInformation (
    @SerializedName("message")
    val message: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("name_match")
    val nameMatch: Int?,
    @SerializedName("father_name_match")
    val fatherNameMatch: Int?,
    @SerializedName("street_address_match")
    val streetAddressMatch: Double?,
    @SerializedName("ocr_id_match")
    val ocrIdMatch: Boolean?
): Parcelable

@Parcelize
data class VoterOcr (
    @SerializedName("address")
    val address: String?,
    @SerializedName("age")
    val age: String?,
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @SerializedName("district")
    val district: String?,
    @SerializedName("fathers_name")
    val fathersName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("house_number")
    val houseNumber: String?,
    @SerializedName("id_number")
    val idNumber: String?,
    @SerializedName("is_scanned")
    val isScanned: String?,
    @SerializedName("name_on_card")
    val nameOnCard: String?,
    @SerializedName("pincode")
    val pincode: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("street_address")
    val streetAddress: String?,
    @SerializedName("year_of_birth")
    val yearOfBirth: String?
): Parcelable

@Parcelize
data class VoterIDResponse (
    @SerializedName("result")
    val result: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("ocr")
    val ocr: VoterOcr?,
    @SerializedName("matched_information")
    val matchedInformation: VoterMatchedInformation?
): Parcelable