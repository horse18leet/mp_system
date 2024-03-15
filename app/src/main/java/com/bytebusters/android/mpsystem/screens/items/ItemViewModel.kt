package com.bytebusters.android.mpsystem.screens.items

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.dto.response.api.item.ItemDto
import com.bytebusters.android.mpsystem.dto.response.api.item.SimpleUserDto
import com.bytebusters.android.mpsystem.network.ApiClient
import com.bytebusters.android.mpsystem.sharedprefs.ItemManager
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class ItemViewModel : ViewModel() {
    private val sessionManager = SessionManager(HomeApplication.getAppContext())
    private val itemManager = ItemManager(HomeApplication.getAppContext())

    fun createItem(
        title: MutableState<String>,
        description: MutableState<String>,
        firstPrice: MutableState<Double>,
        category: MutableState<String>,
        vendorCode: MutableState<String>,
        mpLink: MutableState<String>
    ) {
        var itemDto = ItemDto(
            title = title.value,
            description = description.value,
            firstPrice = firstPrice.value,
            category = category.value,
            vendorCode = vendorCode.value,
            mpLink = mpLink.value,
            isDraft = true,
            isActive = true,
            createdAt = LocalDateTime.now(),
            user = SimpleUserDto(sessionManager.fetchUser()!!.id)
        )

        var itemsDto: ItemDto

        //отправка запроса добавления товара на сервер
        ApiClient.itemService.createItem(itemDto).enqueue(
            object : Callback<ItemDto> {
                override fun onResponse(call: Call<ItemDto>, response: Response<ItemDto>) {
                    if (response.isSuccessful) {
                        itemsDto = response.body()!!

                        //некоторая логика для добавления товара в коллекцию закэшированных товаров
                        var cacheItemsDto = itemManager.fetchUserItems()
                        cacheItemsDto.add(response.body()!!)
                        itemManager.saveItems(cacheItemsDto)

                    } else {
                        onFailure(call, Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<ItemDto>, t: Throwable) {
                    Log.e("ItemViewModel", t.message.toString())
                }
            }
        )
    }

}