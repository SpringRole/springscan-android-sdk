package com.springscan.sdk.internal.apis.initialize

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RootResponse(
    @SerializedName("person")
    val person: Person,
    @SerializedName("status")
    val status: String?,
    @SerializedName("statusText")
    val statusText: String?
): Parcelable

@Parcelize
data class Person(
    @SerializedName("name") 
    val name: Name?,
    @SerializedName("documents") 
    val documents: Documents?,
    @SerializedName("selfie") 
    val selfie: Selfie?,
    @SerializedName("_id") 
    val id: String?,
    @SerializedName("addedBy") 
    val addedBy: String?,
    @SerializedName("createdAt") 
    val createdAt: String?,
    @SerializedName("updatedAt") 
    val updatedAt: String?
): Parcelable

@Parcelize
data class Documents(
    @SerializedName("ind_aadhaar") 
    val indAadhaar: DocDetailsResponse?,
    @SerializedName("ind_driving_license") 
    val indDrivingLicense: DocDetailsResponse?,
    @SerializedName("ind_pan") 
    val indPan: DocDetailsResponse?,
    @SerializedName("ind_passport")
    val indPassport: DocDetailsResponse?,
    @SerializedName("ind_voter_id") 
    val indVoterId: DocDetailsResponse?
): Parcelable

@Parcelize
data class Name(
    @SerializedName("first") 
    val first: String?,
    @SerializedName("last")
    val last: String?
): Parcelable

@Parcelize
data class Validity(
    @SerializedName("NT")
    val nT: String?
): Parcelable

@Parcelize
data class Selfie(
    @SerializedName("url") 
    val url: String?
): Parcelable

@Parcelize
data class DocDetailsResponse(
    @SerializedName("result")
    val OCRResult: OCRResult?,
    @SerializedName("manualObj")
    val manualUpdate: OCRResult?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("faceMatched")
    val faceMatched: Boolean?,
    @SerializedName("matchResult")
    val matchResult: MatchResult?,
    @SerializedName("matchedInformation")
    val matchedInformation: MatchedInformation?,
    @SerializedName("request_id")
    val requestId: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("docType")
    val docType: String?,
    @SerializedName("document1")
    val document1: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("__v")
    val v: Int?,
    @SerializedName("belongsTo")
    val belongsTo: String?,
    @SerializedName("govResult")
    val govResult: GovResult?
): Parcelable

@Parcelize
data class OCRResult(
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
    @SerializedName("minor")
    val minor: Boolean?,
    @SerializedName("name_on_card")
    val nameOnCard: String?,
    @SerializedName("pan_type")
    val panType: String?,
    @SerializedName("street_address")
    val streetAddress: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("validity")
    val validity: Validity?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("year_of_birth")
    val yearOfBirth: String?,
    @SerializedName("is_scanned")
    val isScanned: Boolean?,
    @SerializedName("house_number")
    val houseNumber: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("district")
    val district: String?
) : Parcelable

@Parcelize
data class MatchResult(
    @SerializedName("is_a_match")
    val isAMatch: Boolean?,
    @SerializedName("match_score")
    val matchScore: Double?,
    @SerializedName("review_recommended")
    val reviewRecommended: Boolean?,
    @SerializedName("image_1")
    val image1: ImageStatus?,
    @SerializedName("image_2")
    val image2: ImageStatus?
): Parcelable

@Parcelize
data class ImageStatus(
    @SerializedName("face_detected")
    val faceDetected: Boolean?,
    @SerializedName("face_quality")
    val faceQuality: String?
): Parcelable

@Parcelize
data class MatchedInformation(
    @SerializedName("message")
    val message: String?,
    @SerializedName("gender_match")
    val genderMatch: Boolean?,
    @SerializedName("age_match")
    val ageMatch: Boolean?,
    @SerializedName("id_match")
    val idMatch: Boolean?,
    @SerializedName("ocr_id_match")
    val ocrIdMatch: Boolean?
) : Parcelable

@Parcelize
data class GovResult (
    @SerializedName("action")
    val action: String?,
    @SerializedName("completed_at")
    val completedAt: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("group_id")
    val groupId: String?,
    @SerializedName("request_id")
    val requestId: String?,
    @SerializedName("result")
    val result: ResultOutput?,
    @SerializedName("response_status")
    val responseStatus: GovResultResponseStatus?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("verification_status")
    val verificationStatus: String?,
    @SerializedName("task_id")
    val taskId: String?,
    @SerializedName("type")
    val type: String?
): Parcelable

@Parcelize
data class GovResultResponseStatus(
    @SerializedName("code")
    val code: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
) : Parcelable

@Parcelize
data class ResultOutput (
    @SerializedName("match_output")
    val matchOutput: MatchOutput?,
    @SerializedName("source_output")
    val sourceOutput: SourceOutput?
): Parcelable

@Parcelize
class MatchOutput (
    @SerializedName("name_on_card")
    val nameOnCard: Int?
): Parcelable

@Parcelize
data class SourceOutput (
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id_number")
    val idNumber: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("middle_name")
    val middleName: String?,
    @SerializedName("name_on_card")
    val nameOnCard: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("status")
    val status: String?
): Parcelable

