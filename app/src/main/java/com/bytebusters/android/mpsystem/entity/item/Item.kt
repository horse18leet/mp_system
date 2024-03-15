package com.bytebusters.android.mpsystem.entity.item

import com.bytebusters.android.mpsystem.entity.purchase.Ad
import com.bytebusters.android.mpsystem.entity.purchase.PurchaseItem
import com.bytebusters.android.mpsystem.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "title", nullable = false)
    private val title: String? = null

    @Column(name = "description", length = 500)
    private val description: String? = null

    @Column(name = "first_price")
    private val firstPrice: Double? = null

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private val user: User? = null

    @Column(name = "category")
    private val category: String? = null

    @Column(name = "vendor_code")
    private val vendorCode: String? = null

    @Column(name = "is_active", nullable = false)
    private val isActive: Boolean? = null

    @Column(name = "is_draft", nullable = false)
    private val isDraft: Boolean? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @OneToMany(mappedBy = "item")
    private val orders: Set<Order> = LinkedHashSet()

    @OneToMany(mappedBy = "item")
    private val priceHistory: Set<PriceHistory> = LinkedHashSet()

    @OneToMany(mappedBy = "item")
    private val ads: Set<Ad> = LinkedHashSet<Ad>()

    @OneToMany(mappedBy = "item")
    private val purchaseItems: Set<PurchaseItem> = LinkedHashSet<PurchaseItem>()
}
