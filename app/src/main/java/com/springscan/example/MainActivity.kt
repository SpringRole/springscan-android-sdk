package com.springscan.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.springscan.sdk.SpringScan
import com.springscan.sdk.internal.apis.login.LoginResponse
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
    }
}