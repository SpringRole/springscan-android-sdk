package com.springscan.sdk.internal.apis.criminal

import android.os.Parcelable

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourtResponse (
    @SerializedName("reports")
    var reports: List<Report>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("_id")
    var id: String?,
    @SerializedName("belongsTo")
    var belongsTo: String?,
    @SerializedName("query")
    var query: Query?,
    @SerializedName("createdAt")
    var createdAt: String?,
    @SerializedName("updatedAt")
    var updatedAt: String?,
    @SerializedName("__v")
    var v: Int?
): Parcelable

@Parcelize
data class Report (
    @SerializedName("year")
    var year: String?,
    @SerializedName("subject")
    var subject: String?,
    @SerializedName("address_taluka")
    var addressTaluka: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("type")
    var type: Int?,
    @SerializedName("next_hearing_date")
    var nextHearingDate: String?,
    @SerializedName("address_pincode")
    var addressPincode: String?,
    @SerializedName("first_hearing_date")
    var firstHearingDate: String?,
    @SerializedName("state_name")
    var stateName: String?,
    @SerializedName("address_wc")
    var addressWc: Int?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("under_acts")
    var underActs: String?,
    @SerializedName("address_district")
    var addressDistrict: String?,
    @SerializedName("nature_of_disposal")
    var natureOfDisposal: String?,
    @SerializedName("uniq_case_id")
    var uniqCaseId: String?,
    @SerializedName("name_wc")
    var nameWc: Int?,
    @SerializedName("business_category")
    var businessCategory: String?,
    @SerializedName("filing_no")
    var filingNo: String?,
    @SerializedName("case_category")
    var caseCategory: String?,
    @SerializedName("address_street")
    var addressStreet: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("dist_code")
    var distCode: Int?,
    @SerializedName("state_code")
    var stateCode: Int?,
    @SerializedName("link")
    var link: String?,
    @SerializedName("address_state")
    var addressState: String?,
    @SerializedName("court_no_judge")
    var courtNoJudge: String?,
    @SerializedName("decision_date")
    var decisionDate: String?,
    @SerializedName("court_no_name")
    var courtNoName: String?,
    @SerializedName("under_sections")
    var underSections: String?,
    @SerializedName("court_name")
    var courtName: String?,
    @SerializedName("case_no_year")
    var caseNoYear: String?,
    @SerializedName("address")
    var address: String?,
    @SerializedName("case_code")
    var caseCode: String?,
    @SerializedName("dist_name")
    var distName: String?,
    @SerializedName("case_type")
    var caseType: String?,
    @SerializedName("police_station")
    var policeStation: String?,
    @SerializedName("case_year")
    var caseYear: String?,
    @SerializedName("registration_no")
    var registrationNo: String?,
    @SerializedName("case_decision_date")
    var caseDecisionDate: String?,
    @SerializedName("purpose_of_hearing")
    var purposeOfHearing: String?,
    @SerializedName("case_status")
    var caseStatus: String?,
    @SerializedName("fir_no")
    var firNo: String?,
    @SerializedName("md5")
    var md5: String?,
    @SerializedName("raw_address")
    var rawAddress: String?,
    @SerializedName("court_code")
    var courtCode: Int?,
    @SerializedName("cnr")
    var cnr: String?,
    @SerializedName("data_category")
    var dataCategory: String?,
    @SerializedName("global_category")
    var globalCategory: String?,
    @SerializedName("score")
    var score: Double?,
    @SerializedName("model_score")
    var modelScore: Double?
): Parcelable

@Parcelize
data class Query (
    @SerializedName("name")
    var name: String?,
    @SerializedName("address")
    var address: String?,
    @SerializedName("fatherName")
    var fatherName: String?
): Parcelable

