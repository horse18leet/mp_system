package com.bytebusters.android.mpsystem.repository

import com.bytebusters.android.mpsystem.entity.user.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TokenRepository : JpaRepository<Token?, Long?> {
    @Query(
        value = """
        SELECT t FROM Token t INNER JOIN t.user u 
        WHERE u.id = :userId AND (t.expired = false OR t.revoked = false) 
    """
    )
    fun findAllValidTokenByUser(@Param("userId") id: Long?): List<Token?>?
    fun findByToken(token: String?): Optional<Token?>?
}