package com.bytebusters.android.mpsystem.entity.purchase

import com.bytebusters.android.mpsystem.entity.item.Item
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "purchase_items")
class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "count", nullable = false)
    private val count = 0

    @ManyToOne
    @JoinColumn(name = "id_purchase", nullable = false)
    private val purchase: Purchase? = null

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private val item: Item? = null
}
