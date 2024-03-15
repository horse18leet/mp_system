package com.bytebusters.android.mpsystem.repository

import com.bytebusters.android.mpsystem.entity.enums.RoleType
import com.bytebusters.android.mpsystem.entity.role.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface RoleRepository : JpaRepository<Role?, Long?> {
    fun findByName(name: RoleType?): Optional<Role?>?

    @Query(
        value = """
        SELECT r FROM Role r JOIN FETCH r.users u 
        WHERE u.id = :userId
    """
    )
    fun findByUserId(@Param("userId") userId: Long?): Optional<Role?>
}
