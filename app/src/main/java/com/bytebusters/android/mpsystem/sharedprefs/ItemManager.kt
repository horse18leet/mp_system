package com.bytebusters.android.mpsystem.sharedprefs

import android.content.Context
import com.bytebusters.android.mpsystem.R
import com.bytebusters.android.mpsystem.dto.response.api.item.ItemDto
import com.google.gson.Gson

class ItemManager (context: Context) {
    private val prefs = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    companion object {
        const val USER_ITEMS = "user_items"
    }

    fun saveItems(token: String) = editPrefs(USER_ITEMS, token)
    fun deleteAuthToken() = editPrefs(USER_ITEMS, null)
    fun fetchAuthToken(): String? = prefs.getString(USER_ITEMS, null)

    fun saveItems(items: List<ItemDto>) {
        for((index, item) in items) {
            val json = Gson().toJson(item)
            editPrefs(index.toString(), json)
        }
    }

    fun deleteUserItems() = editPrefs(USER_ITEMS, null)

    fun fetchUserItems(): ArrayList<ItemDto> {
        var isEndRange = false
        val pos = 0
        val userItems = ArrayList<ItemDto>()
        do {
            val json =  prefs.getString(pos.toString(), null)
            if(json != null) {
                val itemDto = Gson().fromJson(json, ItemDto::class.java)
                userItems.add(itemDto)
            }
            else{
                isEndRange = true
            }
        } while (!isEndRange)

        return userItems
    }

    private fun editPrefs(key: String, value: String?) {
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }
}