package com.springscan.sdk.internal.support

import android.content.Context
import androidx.core.content.edit
import com.springscan.sdk.SpringScan

class Preferences(context: Context) {
    private val preferences = context.getSharedPreferences("SpringScan", Context.MODE_PRIVATE)

    private val accessTokenKey = "com.springscan.sdk.internal.support.Preferences.accessTokenKey"

    fun getJWTToken(): String? {
        return preferences.getString(accessTokenKey, null)
    }

    fun saveJWTToken(token: String) {
        preferences.edit {
            putString(accessTokenKey, token)
            apply()
        }
    }
}