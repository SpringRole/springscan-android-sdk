package com.springscan.sdk

enum class DocType(
    val apiString: String,
    val simpleString: String
) {
    AADHAAR("ind_aadhaar", "Aadhaar"),
    PAN("ind_pan", "Pan"),
    VOTER("ind_voter_id", "Voter"),
    DRIVING_LICENSE("ind_driving_license", "Driving license"),
    FACE_IMAGE("face_image", "Face Image"),
    PASSPORT_FRONT("ind_passport", "Passport");
}
