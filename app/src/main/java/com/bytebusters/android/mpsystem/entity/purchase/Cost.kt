package com.bytebusters.android.mpsystem.entity.purchase

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
@Table(name = "costs")
class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "title", nullable = false)
    private val title: String? = null

    @Column(name = "description", nullable = false)
    private val description: String? = null

    @Column(name = "type", nullable = false)
    private val type: String? = null

    @Column(name = "amount", nullable = false)
    private val amount = 0.0

    @ManyToOne
    @JoinColumn(name = "id_purchase", nullable = false)
    private val purchase: Purchase? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @OneToMany(mappedBy = "cost")
    private val ads: Set<Ad> = LinkedHashSet()
}
