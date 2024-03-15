package com.bytebusters.android.mpsystem.screens.auth

import android.util.Log
import android.util.Patterns
import android.widget.TextView
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bytebusters.android.mpsystem.R
import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.dto.response.AuthResponse
import com.bytebusters.android.mpsystem.dto.response.api.UserDto
import com.bytebusters.android.mpsystem.network.ApiClient
import com.bytebusters.android.mpsystem.network.auth.AuthValidator
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager
import com.bytebusters.android.mpsystem.ui.login.LoginFormState
import com.bytebusters.android.mpsystem.ui.login.LoginRequest
import com.bytebusters.android.mpsystem.ui.login.LoginResult
import com.google.android.material.textfield.TextInputLayout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val sessionManager = SessionManager(HomeApplication.getAppContext())

    private lateinit var usernameField: TextInputLayout
    private lateinit var pwdField: TextInputLayout
    private lateinit var registerTextView: TextView

    private lateinit var userDto: UserDto

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    private val _userData = MutableLiveData<UserDto>()
    val userData: LiveData<UserDto> = _userData

    fun login(em: MutableState<String>, pwd: MutableState<String>) {

        val email = em.value.trim()
        val password = pwd.value.trim()
        val loginModel = LoginRequest(email, password)

        val errors = AuthValidator.validateLogin(email, password)
        if (!errors.isValid) {
            usernameField.error = errors.email
            pwdField.error = errors.password
            return
        }

        ApiClient.authService.login(loginModel).enqueue(
            object : Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.isSuccessful) {
                        val tokens = response.body()

                        sessionManager.saveAuthToken(tokens!!.access_token)
                        sessionManager.saveRefreshToken(tokens.refresh_token)

                        fetchUserData()

                    } else {
                        onFailure(call, Throwable(response.message()))
                    }
                }

                override fun onFailure(
                    call: Call<AuthResponse>,
                    t: Throwable
                ) {
                    Log.e("LoginViewModel", t.message.toString())
                }
            }
        )
    }

    fun logout() {
        sessionManager.deleteAuthToken()
        sessionManager.deleteRefreshToken()
        sessionManager.deleteUser()
        Log.e("LoginViewModel", "Пользовательская сессия удалена")

    }

    fun setUser(user: UserDto) {
        _userData.value = user
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }


    fun fetchUserData() {

        ApiClient.authService.fetchUser().enqueue(
            object : Callback<UserDto> {
                override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                    if (response.isSuccessful) {
                        userDto = response.body()!!
                        sessionManager.saveUser(userDto)
                    } else {
                        onFailure(call, Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<UserDto>, t: Throwable) {
                    Log.e("LoginViewModel", t.message.toString())
                }
            }
        )
    }

    fun checkIsLoggedIn(): Boolean {
        return sessionManager.fetchUser() != null
    }

}