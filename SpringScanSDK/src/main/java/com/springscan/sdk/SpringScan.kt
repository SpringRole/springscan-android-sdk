package com.springscan.sdk

import android.content.Context
import com.springscan.sdk.internal.support.SpringAPI

object SpringScan {

    private lateinit var springAPI: SpringAPI

    /**
     *  Call this function before making any other calls
     */
    fun initialize(context: Context, apiToken: String){
        this.springAPI = SpringAPI(context, apiToken)
    }

    fun getAPIInstance(): SpringAPI {
        if(!::springAPI.isInitialized){
            throw  IllegalStateException("SpringScan API ot initialized yet!")
        }
        return springAPI
    }

}