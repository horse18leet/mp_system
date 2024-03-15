package com.bytebusters.android.mpsystem.network.auth

import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor  {
    private val sessionManager = SessionManager(HomeApplication.getInstance())

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        sessionManager.fetchAuthToken()?.let { token ->
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}