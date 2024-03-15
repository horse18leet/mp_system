package com.bytebusters.android.mpsystem.dto.response.api

import com.bytebusters.android.mpsystem.entity.enums.RoleType
import java.io.Serializable

class RoleDto (
    var id: Long? = null,
    var name: RoleType? = null
)