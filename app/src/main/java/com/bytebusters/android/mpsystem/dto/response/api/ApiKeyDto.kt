package com.bytebusters.android.mpsystem.dto.response.api

import com.bytebusters.android.mpsystem.entity.enums.ApiKeyType
import java.io.Serializable

class ApiKeyDto : Serializable {
    var id: Long? = null
    var key: String? = null
    var type: ApiKeyType? = null
}