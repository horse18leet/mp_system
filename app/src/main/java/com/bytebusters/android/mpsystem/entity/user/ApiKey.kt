package com.bytebusters.android.mpsystem.entity.user

import com.bytebusters.android.mpsystem.entity.enums.ApiKeyType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
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
@Table(name = "api_keys")
class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "key", unique = true, nullable = false, length = 1000)
    private val key: String? = null

    @Column(name = "client_id", unique = true)
    private val clientId: String? = null

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private val type: ApiKeyType = ApiKeyType.WB

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private val user: User? = null
}
