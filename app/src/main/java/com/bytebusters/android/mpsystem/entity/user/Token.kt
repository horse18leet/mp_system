package com.bytebusters.android.mpsystem.entity.user

import com.bytebusters.android.mpsystem.entity.enums.TokenType
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
import lombok.EqualsAndHashCode
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = ["id"])
@Builder
@Entity
@Table(name = "jwts")
class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(unique = true, nullable = false)
    private val token: String? = null

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private val type: TokenType = TokenType.BEARER

    @Column(name = "revoked", nullable = false)
    private val revoked = false

    @Column(name = "expired", nullable = false)
    private val expired = false

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private val user: User? = null
}