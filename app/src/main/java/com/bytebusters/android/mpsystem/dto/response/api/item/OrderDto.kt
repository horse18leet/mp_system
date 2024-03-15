package com.bytebusters.android.mpsystem.dto.response.api.item

import java.time.LocalDateTime

class OrderDto {
    var id: Long? = null
    var price = 0.0
    var takedAt: LocalDateTime? = null
    var createdAt: LocalDateTime? = null
}