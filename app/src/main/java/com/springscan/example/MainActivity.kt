package com.springscan.example

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.springscan.sdk.DocType
import com.springscan.sdk.SpringScan
import com.springscan.sdk.internal.apis.initialize.RootResponse
import com.springscan.sdk.internal.apis.login.LoginResponse
import com.springscan.sdk.internal.apis.uploaddoc.UploadResponse
import com.springscan.sdk.internal.support.APICallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SpringScan.initialize(this, "USE_YOR_TOKEN")
        click_me.setOnClickListener {
            SpringScan.getAPIInstance().login("email@email.address", "password", object : APICallback<LoginResponse>{
                override fun onSuccess(t: LoginResponse) {
                    //Use Login Response as needed
                }

                override fun onError(throwable: Throwable) {
                    response_text.text = throwable.message
                }

            })
        }
        val myCapturedImageBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ALPHA_8)
        SpringScan.getAPIInstance().upload(myCapturedImageBitmap, DocType.AADHAAR, "person_id", object: APICallback<UploadResponse>{
            override fun onSuccess(t: UploadResponse) {
                //Use Upload Response as needed
            }

            override fun onError(throwable: Throwable) {

            }
        })

        SpringScan.getAPIInstance().updateDoc("Front Doc URL", "Back Image URL", "Face Image URL", DocType.DRIVING_LICENSE, object: APICallback<RootResponse>{
            override fun onSuccess(t: RootResponse) {

            }

            override fun onError(throwable: Throwable) {

            }

        })
    }
}