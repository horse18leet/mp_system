package com.bytebusters.android.mpsystem.entity.sub

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
@Table(name = "user_subscription")
class UserSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private val user: User? = null

    @ManyToOne
    @JoinColumn(name = "id_subscription", nullable = false)
    private val subscription: Subscription? = null

    @Column(name = "start_date", nullable = false)
    private val startDate: LocalDateTime? = null

    @Column(name = "end_date", nullable = false)
    private val endDate: LocalDateTime? = null
}
