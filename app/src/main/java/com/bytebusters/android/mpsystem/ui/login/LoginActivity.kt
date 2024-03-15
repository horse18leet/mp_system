package com.bytebusters.android.mpsystem.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.MutableState
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bytebusters.android.mpsystem.R
import com.bytebusters.android.mpsystem.application.HomeApplication
import com.bytebusters.android.mpsystem.dto.response.AuthResponse
import com.bytebusters.android.mpsystem.dto.response.api.UserDto
import com.bytebusters.android.mpsystem.network.ApiClient
import com.bytebusters.android.mpsystem.network.auth.AuthValidator
import com.bytebusters.android.mpsystem.screens.auth.LoginViewModel
import com.bytebusters.android.mpsystem.sharedprefs.SessionManager
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private val errorMessage = "Invalid credentials"
    private val sessionManager = SessionManager(HomeApplication.getAppContext())

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var usernameField: TextInputLayout
    private lateinit var pwdField: TextInputLayout
    private lateinit var registerTextView: TextView

    private lateinit var userDto: UserDto



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.loginResult.observe(this, Observer { loginResult ->
            // Обновите пользовательский интерфейс на основе результатов входа
        })

        // Здесь вы можете добавить обработчики событий и другую логику для вашего экрана входа
    }

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

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Log.e("LoginActivity", t.message.toString())
                }
            }
        )
    }

    fun fetchUserData() {

        ApiClient.authService.fetchUser().enqueue(
            object : Callback<UserDto> {
                override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                    if (response.isSuccessful) {
                        userDto = response.body()!!
                        loginViewModel.setUser(userDto)
                    }
                    else {
                        onFailure(call, Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<UserDto>, t: Throwable) {
                    Log.e("LoginActivity", t.message.toString())
                }
            }
        )
    }

    fun checkIsLoggedIn(): Boolean {
        return sessionManager.fetchAuthToken() != null && sessionManager.fetchRefreshToken() != null
    }
}

