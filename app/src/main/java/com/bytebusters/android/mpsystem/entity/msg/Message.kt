package com.bytebusters.android.mpsystem.entity.msg

import com.bytebusters.android.mpsystem.entity.user.User
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
@Table(name = "messages")
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "text", nullable = false)
    private val text: String? = null

    @ManyToOne
    @JoinColumn(name = "id_user_from", nullable = false)
    private val userFrom: User? = null

    @ManyToOne
    @JoinColumn(name = "id_user_to", nullable = false)
    private val userTo: User? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null
}
