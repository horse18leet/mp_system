package com.bytebusters.android.mpsystem.repository

import com.bytebusters.android.mpsystem.entity.item.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order?, Long?> {
    fun findOrdersByItemId(id: Long?): List<Order?>?
}
