package com.springscan.sdk.internal.support

import com.springscan.sdk.internal.apis.login.LoginResponse

interface APICallback<T> {
    fun onSuccess(t: T)
    fun onError(throwable: Throwable)
}