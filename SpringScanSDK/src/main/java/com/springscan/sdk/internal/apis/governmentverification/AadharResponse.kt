package com.springscan.sdk.internal.apis.governmentverification

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AadhaarResponse (
    @SerializedName("result")
    val result: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("information")
    val information: String?,
    @SerializedName("ocr")
    val ocr: Ocr?,
    @SerializedName("matched_information")
    val matchedInformation: MatchedInformation?
): Parcelable

@Parcelize
data class MatchedInformation (
    @SerializedName("message")
    val message: String?,
    @SerializedName("gender_match")
    val genderMatch: Boolean?,
    @SerializedName("state_match")
    val stateMatch: Boolean?,
    @SerializedName("age_match")
    val ageMatch: Boolean?
): Parcelable

@Parcelize
data class Ocr (
    @SerializedName("address")
    val address: String?,
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