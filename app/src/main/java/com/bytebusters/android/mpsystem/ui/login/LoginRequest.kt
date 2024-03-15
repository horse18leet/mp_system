package com.bytebusters.android.mpsystem.ui.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String,
)