package com.bytebusters.android.mpsystem.network

import com.bytebusters.android.mpsystem.network.auth.ApiAuthQueries
import com.bytebusters.android.mpsystem.network.item.ApiItemQueries

object ApiClient {
    private const val BASE_URL = "https://api.ucheter.ru"

    val authService: ApiAuthQueries
        get() = RetrofitClient.getClient(BASE_URL).create(ApiAuthQueries::class.java)

    val itemService: ApiItemQueries
        get() = RetrofitClient.getClient(BASE_URL).create(ApiItemQueries::class.java)
}