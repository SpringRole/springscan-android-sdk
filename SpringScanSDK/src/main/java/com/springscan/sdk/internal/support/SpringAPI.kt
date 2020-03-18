package com.springscan.sdk.internal.support

import android.content.Context
import android.graphics.Bitmap
import com.springrole.springscan.api.upload.UploadAPI
import com.springscan.sdk.DocType
import com.springscan.sdk.internal.apis.compare.CompareRequest
import com.springscan.sdk.internal.apis.compare.CompareResult
import com.springscan.sdk.internal.apis.compare.CompareSelfieAndDocAPI
import com.springscan.sdk.internal.apis.criminal.CourtCheckRequest
import com.springscan.sdk.internal.apis.criminal.CourtResponse
import com.springscan.sdk.internal.apis.criminal.CriminalCheckAPI
import com.springscan.sdk.internal.apis.getperson.GetPersonAPI
import com.springscan.sdk.internal.apis.governmentverification.*
import com.springscan.sdk.internal.apis.initialize.InitializePersonAPI
import com.springscan.sdk.internal.apis.initialize.InitializePersonRequest
import com.springscan.sdk.internal.apis.initialize.RootResponse
import com.springscan.sdk.internal.apis.login.LoginAPI
import com.springscan.sdk.internal.apis.login.LoginResponse
import com.springscan.sdk.internal.apis.updatedoc.UpdateDocAPI
import com.springscan.sdk.internal.apis.updateselfie.UpdateSelfieAPI
import com.springscan.sdk.internal.apis.updateselfie.UpdateSelfieRequest
import com.springscan.sdk.internal.apis.uploaddoc.UploadResponse
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.util.*

class SpringAPI(private val context: Context, apiToken: String) {

    private val networkManger = NetworkManger(context, apiToken)

    private fun <T> processAPICall(
        apiFunction: suspend () -> Response<T>,
        apiCallback: APICallback<T>,
        coroutineScope: CoroutineScope
    ): Job {
        return coroutineScope.launch(CoroutineExceptionHandler { _, throwable ->
            apiCallback.onError(throwable)
        }) {
            val response = withContext(Dispatchers.IO) { apiFunction() }
            launch(Dispatchers.Main) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null)
                    apiCallback.onSuccess(responseBody)
                else {
                    apiCallback.onError(
                        UnknownFormatConversionException(
                            response.errorBody()?.toString() ?: "Unknown Error"
                        )
                    )
                }
            }
        }
    }

    fun login(
        email: String, password: String,
        apiCallback: APICallback<LoginResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val loginFunction: suspend () -> Response<LoginResponse> = {
            networkManger.getAPI(LoginAPI::class.java).login(email, password).apply {
                val token = this.body()?.token
                if (isSuccessful && token != null) {
                    Preferences(context).saveJWTToken(token)
                }
            }
        }
        return processAPICall(loginFunction, apiCallback, coroutineScope)
    }

    fun upload(
        bitmap: Bitmap, docType: DocType, personID: String?,
        apiCallback: APICallback<UploadResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val uploadFunction: suspend () -> Response<UploadResponse> = {
            val fileToUpload = withContext(Dispatchers.IO) {
                val f = File(
                    context.cacheDir,
                    docType.apiString + "_" + Date().time + ".jpg"
                )
                f.createNewFile()
                val bos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)
                val bitMapData = bos.toByteArray()
                val fos = FileOutputStream(f)
                fos.write(bitMapData)
                fos.flush()
                fos.close()
                f
            }

            val reqFile = fileToUpload.asRequestBody("image/*".toMediaTypeOrNull())
            val body = MultipartBody.Part.createFormData(
                docType.apiString, fileToUpload.name, reqFile
            )

            networkManger.getAPI(UploadAPI::class.java).uploadDocument(body, personID)
        }

        return processAPICall(uploadFunction, apiCallback, coroutineScope)
    }

    fun initializePerson(
        frontImageURL: String?, backImageURL: String?, selfie: String?, docType: DocType,
        apiCallback: APICallback<RootResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val initializeFunction: suspend () -> Response<RootResponse> = {
            networkManger.getAPI(InitializePersonAPI::class.java).initialize(
                InitializePersonRequest(
                    frontImageURL,
                    backImageURL,
                    selfie,
                    docType.apiString
                )
            )
        }
        return processAPICall(initializeFunction, apiCallback, coroutineScope)
    }

    fun updateDoc(
        frontImageURL: String, backImageURL: String?, personID: String, docType: DocType,
        apiCallback: APICallback<RootResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val updateFunction: suspend () -> Response<RootResponse> = {
            networkManger.getAPI(UpdateDocAPI::class.java).updateDocDetails(
                InitializePersonRequest(
                    frontImageURL,
                    backImageURL,
                    null,
                    docType.apiString
                ),
                personID
            )
        }
        return processAPICall(updateFunction, apiCallback, coroutineScope)
    }

    fun updateSelfie(
        selfie: String, personID: String,
        apiCallback: APICallback<RootResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val updateFunction: suspend () -> Response<RootResponse> = {
            networkManger.getAPI(UpdateSelfieAPI::class.java)
                .updateDocDetails(UpdateSelfieRequest(selfie), personID)
        }
        return processAPICall(updateFunction, apiCallback, coroutineScope)
    }

    fun getPerson(
        personID: String, apiCallback: APICallback<RootResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val updateFunction: suspend () -> Response<RootResponse> = {
            networkManger.getAPI(GetPersonAPI::class.java).getPerson(personID)
        }
        return processAPICall(updateFunction, apiCallback, coroutineScope)
    }

    fun compareSelfieAndDoc(
        personID: String, docType: DocType,
        apiCallback: APICallback<CompareResult>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val compareFunction: suspend () -> Response<CompareResult> = {
            networkManger.getAPI(CompareSelfieAndDocAPI::class.java)
                .compare(personID, CompareRequest(docType.apiString))
        }
        return processAPICall(compareFunction, apiCallback, coroutineScope)
    }

    fun verifyAadhaar(
        docID: String,
        apiCallback: APICallback<AadhaarResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<AadhaarResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).startAadhaarVerification(docID)
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyPan(
        docID: String,
        apiCallback: APICallback<PanResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<PanResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).startPanVerification(docID)
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyDrivingLicense(
        docID: String,
        apiCallback: APICallback<DLResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<DLResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).startDLVerification(docID)
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyVoterID(
        docID: String,
        apiCallback: APICallback<VoterIDResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<VoterIDResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).startVoterIDVerification(docID)
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyAadhaarWithoutOCR(
        idNumber: String,
        personID: String?,
        apiCallback: APICallback<AadhaarResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<AadhaarResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).noOCRAadhaarVerification(AadhaarRequest(personID, DocType.AADHAAR.apiString, idNumber))
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyPanWithoutOCR(
        dob: String,
        nameOnCard: String,
        idNumber: String,
        personID: String?,
        apiCallback: APICallback<PanResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<PanResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).noOCRPanVerification(PanRequest(personID, DocType.PAN.apiString, dob, nameOnCard, idNumber))
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyDrivingLicenseWithoutOCR(
        dob: String,
        nameOnCard: String,
        idNumber: String,
        personID: String?,
        apiCallback: APICallback<DLResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<DLResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).noOCRDLVerification(DLRequest(personID, DocType.DRIVING_LICENSE.apiString, dob, nameOnCard, idNumber))
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun verifyVoterIDWithoutOCR(
        nameOnCard: String,
        idNumber: String,
        personID: String?,
        apiCallback: APICallback<VoterIDResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val verifyFunction: suspend () -> Response<VoterIDResponse> = {
            networkManger.getAPI(GovVerificationAPI::class.java).noOCRVoterIDVerification(
                VoterIDRequest(personID, DocType.VOTER.apiString, nameOnCard, idNumber)
            )
        }
        return processAPICall(verifyFunction, apiCallback, coroutineScope)
    }

    fun courtCheckWithPersonID(
        personID: String,
        apiCallback: APICallback<CourtResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val checkFunction: suspend () -> Response<CourtResponse> = {
            networkManger.getAPI(CriminalCheckAPI::class.java).courtCheck(personID)
        }
        return processAPICall(checkFunction, apiCallback, coroutineScope)
    }

    fun courtCheckDirect(
        name: String,
        fathersName: String,
        address: String,
        apiCallback: APICallback<CourtResponse>,
        coroutineScope: CoroutineScope = GlobalScope
    ): Job {
        val checkFunction: suspend () -> Response<CourtResponse> = {
            networkManger.getAPI(CriminalCheckAPI::class.java).searchDirect(CourtCheckRequest(name, fathersName, address))
        }
        return processAPICall(checkFunction, apiCallback, coroutineScope)
    }


}