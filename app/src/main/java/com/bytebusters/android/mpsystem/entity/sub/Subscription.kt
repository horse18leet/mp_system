package com.bytebusters.android.mpsystem.entity.sub

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
@Table(name = "subscriptions")
class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "name", unique = true, nullable = false)
    private val name: String? = null

    @Column(name = "description")
    private val description: String? = null

    @Column(name = "price", nullable = false)
    private val price = 0.0

    @Column(name = "is_active", nullable = false)
    private val isActive: Boolean? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @OneToMany(mappedBy = "subscription")
    private val userSubscriptions: Set<UserSubscription> = LinkedHashSet()
}
