package com.bytebusters.android.mpsystem.sharedprefs

import android.content.Context
import com.bytebusters.android.mpsystem.R
import com.bytebusters.android.mpsystem.dto.response.api.UserDto
import com.google.gson.Gson

class SessionManager (context: Context) {
    private val prefs = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    companion object {
        const val USER_TOKEN = "user_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val USER = "user_dto"
    }

    fun saveAuthToken(token: String) = editPrefs(USER_TOKEN, token)
    fun deleteAuthToken() = editPrefs(USER_TOKEN, null)
    fun fetchAuthToken(): String? = prefs.getString(USER_TOKEN, null)

    fun saveRefreshToken(token: String) = editPrefs(REFRESH_TOKEN, token)
    fun deleteRefreshToken() = editPrefs(REFRESH_TOKEN, null)
    fun fetchRefreshToken(): String? = prefs.getString(REFRESH_TOKEN, null)

    fun saveUser(user: UserDto) {
        val json = Gson().toJson(user)
        editPrefs(USER, json)
    }
    fun deleteUser() = editPrefs(USER, null)
    fun fetchUser(): UserDto? {
        val json = prefs.getString(USER, null)
        return Gson().fromJson(json, UserDto::class.java)
    }

    fun clearTokens() {
        editPrefs(USER_TOKEN, "")
        editPrefs(REFRESH_TOKEN, "")
    }

    private fun editPrefs(key: String, value: String?) {
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }
}