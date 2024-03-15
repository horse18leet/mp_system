package com.bytebusters.android.mpsystem.dto.response.api

import com.bytebusters.android.mpsystem.entity.sub.UserSubscription
import com.bytebusters.android.mpsystem.entity.user.UserPreference
import java.time.LocalDateTime

class UserDto (
    var id: Long? = null,
    var email: String? = null,
    var firstName: String? = null,
    var secondName: String? = null,
    var phoneNum: String? = null,
    var isActive: Boolean? = null,
//    var createdAt: LocalDateTime? = null,
    var userPreferences: Set<UserPreference>? = null,
    var userSubscriptions: Set<UserSubscription>? = null,
    var role: RoleDto? = null
)