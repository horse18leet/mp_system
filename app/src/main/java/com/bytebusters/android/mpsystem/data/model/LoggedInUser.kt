package com.bytebusters.android.mpsystem.data.model

import java.time.LocalDateTime

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val id: Long,
    val email: String,
    val firstName: String,
    val secondName: String,
    val phoneNum: String,
    val isActive: Boolean,
    val createdAt: LocalDateTime
)