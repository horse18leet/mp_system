package com.bytebusters.android.mpsystem.entity.purchase

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
@Table(name = "purchases")
class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @OneToMany(mappedBy = "purchase")
    private val costs: Set<Cost> = LinkedHashSet()

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private val user: User? = null

    @Column(name = "cost", nullable = false)
    private val cost = 0.0

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @OneToMany(mappedBy = "purchase")
    private val purchaseItems: Set<PurchaseItem> = LinkedHashSet()
}
