package com.bytebusters.android.mpsystem.data

import com.bytebusters.android.mpsystem.data.model.LoggedInUser
import com.bytebusters.android.mpsystem.ui.login.LoginRequest
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(email: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val loginRequest: LoginRequest? = fetchLoginUserData(email, password)
            var loggedInUser: LoggedInUser? = null
            if(loginRequest != null){
                loggedInUser = fetchUser(loginRequest.email)
            }
            return Result.Success(loggedInUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    private fun fetchUser(accessToken: String): LoggedInUser? {
            val url = URL("https://api.ucheter.ru/user")
            val connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Authorization", "Bearer $accessToken")

            if (connection.responseCode == HttpsURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val inputStreamReader = InputStreamReader(inputStream, "UTF-8")
                val responseData = Gson().fromJson(inputStreamReader, LoggedInUser::class.java)
                return responseData
            } else {
                return null
            }
    }


    fun logout() {
        // TODO: revoke authentication
    }

    private fun fetchLoginUserData(email: String, password: String): LoginRequest? {
        val url = URL("https://api.ucheter.ru")
        val connection = url.openConnection() as HttpsURLConnection

        val requestData = JsonObject()
        requestData.addProperty("email", email)
        requestData.addProperty("password", password)
        val outputStream = connection.outputStream
        outputStream.write(requestData.toString().toByteArray(Charsets.UTF_8))
        outputStream.close()

        if (connection.responseCode == 200) {
            val inputStream = connection.inputStream
            val inputStreamReader = InputStreamReader(inputStream, "UTF-8")
            val request = Gson().fromJson(inputStreamReader, LoginRequest::class.java)

            return request
        }

        return null
    }
}