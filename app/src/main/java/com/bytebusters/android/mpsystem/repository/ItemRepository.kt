package com.bytebusters.android.mpsystem.repository

import com.bytebusters.android.mpsystem.entity.item.Item
import com.bytebusters.android.mpsystem.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ItemRepository : JpaRepository<Item?, Long?> {
    fun findByUserId(id: Long?): List<Item?>?
    fun findItemByUserAndIsDraft(user: User?, isDraft: Boolean): List<Item?>?

    @Query("SELECT DISTINCT i.category FROM Item i WHERE i.user.id = ?1")
    fun findUniqueCategoryByUserId(id: Long?): List<String?>?
    fun findByVendorCode(vendorCode: String?): Item?
    fun findItemByIsDraft(isDraft: Boolean?): List<Item?>?
}
