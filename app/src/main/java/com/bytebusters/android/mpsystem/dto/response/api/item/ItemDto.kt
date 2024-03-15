package com.bytebusters.android.mpsystem.dto.response.api.item

import java.time.LocalDateTime


data class ItemDto (
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val firstPrice: Double? = null,
    val user: SimpleUserDto? = null,
    val category: String? = null,
    val vendorCode: String? = null,
    val mpLink: String? = null,
    val isDraft: Boolean? = null,
    val isActive: Boolean? = null,
    val createdAt: LocalDateTime? = null
)