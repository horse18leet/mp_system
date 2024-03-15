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
@Table(name = "ads")
class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "estimation")
    private val estimation = 0

    @Column(name = "link", nullable = false)
    private val link: String? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "id_cost", nullable = false)
    private val cost: Cost? = null

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private val item: Item? = null
}
