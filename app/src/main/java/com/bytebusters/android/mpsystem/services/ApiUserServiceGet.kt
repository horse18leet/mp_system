package com.bytebusters.android.mpsystem.services

import com.bytebusters.android.mpsystem.repository.UserRepository
import com.bytebusters.android.mpsystem.ui.login.LoginRequest
import okhttp3.OkHttpClient

class ApiUserServiceGet () {



    suspend fun createAuthenticatedClient(token: String): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor { chain ->
            val originalRequest = chain.request()

            val builder = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
            val newRequest = builder.build()
            chain.proceed(newRequest)
        }.build()
    }
}