package com.springscan.sdk.internal.apis.governmentverification

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DLRequest (
    @SerializedName("personId")
    var personId: String?,
    @SerializedName("doc_type")
    var docType: String?,
    @SerializedName("date_of_birth")
    var dateOfBirth: String?,
    @SerializedName("name_on_card")
    var nameOnCard: String?,
    @SerializedName("id_number")
    var idNumber: String?
): Parcelable

@Parcelize
data class VoterIDRequest (
    @SerializedName("personId")
    var personId: String?,
    @SerializedName("doc_type")
    var docType: String?,
    @SerializedName("name_on_card")
    var nameOnCard: String?,
    @SerializedName("id_number")
    var idNumber: String?
): Parcelable

@Parcelize
data class PanRequest (
    @SerializedName("personId")
    var personId: String?,
    @SerializedName("doc_type")
    var docType: String?,
    @SerializedName("date_of_birth")
    var dateOfBirth: String?,
    @SerializedName("name_on_card")
    var nameOnCard: String?,
    @SerializedName("id_number")
    var idNumber: String?
): Parcelable

@Parcelize
data class AadhaarRequest (
    @SerializedName("personId")
    var personId: String?,
    @SerializedName("doc_type")
    var docType: String?,
    @SerializedName("id_number")
    var idNumber: String?
): Parcelable
