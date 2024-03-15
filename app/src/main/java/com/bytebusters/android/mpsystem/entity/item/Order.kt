package com.bytebusters.android.mpsystem.entity.item

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private val item: Item? = null

    @Column(name = "price", nullable = false)
    private val price = 0.0

    @Column(name = "taked_at", columnDefinition = "TIMESTAMP NOT NULL", nullable = false)
    private val takedAt: LocalDateTime? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null
}
