package com.springscan.sdk.internal.support

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.springscan.sdk.internal.apis.CommonErrorResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManger(private val context: Context, private val apiToken: String) {

    private fun getClient(): OkHttpClient{
        return  OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Token", apiToken)
                Preferences(context).getJWTToken()?.let {
                    requestBuilder.header("Authorization", it)
                }
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    private fun getGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.springscan.springverify.com/")
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .client(getClient())
            .build()
    }

    private val retrofit: Retrofit

    init{
        retrofit = getRetrofit()
    }

    fun <T> getAPI(service: Class<T>): T {
        return retrofit.create(service)
    }

    fun  parseError(response: Response<*>): CommonErrorResponse {
        return try {
            val converter = retrofit.responseBodyConverter<CommonErrorResponse>(
                CommonErrorResponse::class.java, arrayOfNulls(0))
            val errorBody = response.errorBody()
            if (errorBody == null)
                CommonErrorResponse(message = "Server send a non standard error")
            else
                converter.convert(errorBody) ?: CommonErrorResponse(
                    message = "Server send a non standard error"
                )
        } catch (illegalArgEx: IllegalArgumentException) {
            CommonErrorResponse(message = "Server send a non standard error")
        } catch (illegalState: IllegalStateException) {
            CommonErrorResponse(message = "Server send a non standard error")
        }
    }

}