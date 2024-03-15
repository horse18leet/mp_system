package com.bytebusters.android.mpsystem.dto.response.api

import java.time.LocalDateTime

data class PurchaseDto (
    var id: Long? = null,
    var cost: Double = 0.0,
    var createdAt: LocalDateTime? = null
)