package com.bytebusters.android.mpsystem.network.item

import com.bytebusters.android.mpsystem.dto.response.api.item.ItemDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiItemQueries {

    @POST("/item/create")
    fun createItem(@Body model: ItemDto): Call<ItemDto>


}