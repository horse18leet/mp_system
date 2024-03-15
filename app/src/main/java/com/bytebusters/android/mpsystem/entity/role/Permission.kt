package com.bytebusters.android.mpsystem.entity.role

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
@Table(name = "permissions")
class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(name = "name", nullable = false)
    private val name: String? = null
}
