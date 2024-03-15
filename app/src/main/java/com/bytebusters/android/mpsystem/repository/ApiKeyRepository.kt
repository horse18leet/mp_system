package com.bytebusters.android.mpsystem.repository

import com.bytebusters.android.mpsystem.entity.user.ApiKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ApiKeyRepository : JpaRepository<ApiKey?, Long?> {
    fun findByKey(key: String?): ApiKey?

    @Query("SELECT a FROM ApiKey a WHERE a.user.id = ?1")
    fun findByUserId(id: Long?): List<ApiKey?>?
}
