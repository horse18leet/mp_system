package com.bytebusters.android.mpsystem.dto.response.api

import java.time.LocalDateTime

data class OrderDto (
    var price: Double = 0.0,
    var takedAt: LocalDateTime? = null,
    var createdAt: LocalDateTime? = null
)