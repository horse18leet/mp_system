package com.bytebusters.android.mpsystem.entity.role

import com.bytebusters.android.mpsystem.entity.enums.RoleType
import com.bytebusters.android.mpsystem.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
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
@Table(name = "roles")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private val name: RoleType? = null

    @OneToMany(mappedBy = "role")
    private val users: List<User>? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permission",
        joinColumns = [JoinColumn(name = "role_id", nullable = false)],
        inverseJoinColumns = [JoinColumn(name = "permission_id", nullable = false)]
    )
    private val permissions: Set<Permission>? = null
}