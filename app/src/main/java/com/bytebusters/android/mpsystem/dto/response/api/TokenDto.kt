package com.bytebusters.android.mpsystem.dto.response.api

import com.bytebusters.android.mpsystem.entity.enums.TokenType

data class TokenDto (
    var id: Long? = null,
    var token: String? = null,
    var type: TokenType? = null,
    var revoked: Boolean = false,
    var expired: Boolean = false
)