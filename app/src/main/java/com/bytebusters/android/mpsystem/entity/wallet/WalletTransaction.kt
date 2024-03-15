package com.bytebusters.android.mpsystem.entity.wallet

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
@Table(name = "wallet_transactions")
class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "amount", nullable = false)
    private val amount = 0.0

    @Column(name = "type")
    private val type: String? = null

    @Column(name = "description", nullable = false)
    private val description: String? = null

    @Column(name = "impl_date")
    private val implDate: LocalDateTime? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "id_wallet", nullable = false)
    private val wallet: Wallet? = null
}
