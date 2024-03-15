package com.bytebusters.android.mpsystem.services

import io.ktor.http.*
import io.ktor.util.date.*
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient


interface RequestCallback {
    fun onSuccess(response: String)
    fun onFailure(error: String)
}

class UserService() {

    fun createAuthenticatedClient(token: String): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor { chain ->
            val originalRequest = chain.request()

            val builder = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
            val newRequest = builder.build()
            chain.proceed(newRequest)
        }.build()
    }



}

object UserApi {
    val userService: UserService by lazy {
        UserService()
    }
}