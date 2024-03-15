package com.bytebusters.android.mpsystem.network.auth

import com.bytebusters.android.mpsystem.dto.response.AuthResponse
import com.bytebusters.android.mpsystem.dto.response.api.UserDto
import com.bytebusters.android.mpsystem.ui.login.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiAuthQueries {

    @POST("/auth/signin")
    fun login(@Body model: LoginRequest): Call<AuthResponse>

    @GET("/user")
    fun fetchUser(): Call<UserDto>
}