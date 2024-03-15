package com.bytebusters.android.mpsystem.entity.user

import com.bytebusters.android.mpsystem.entity.item.Item
import com.bytebusters.android.mpsystem.entity.msg.Message
import com.bytebusters.android.mpsystem.entity.purchase.Purchase
import com.bytebusters.android.mpsystem.entity.role.Role
import com.bytebusters.android.mpsystem.entity.sub.UserSubscription
import com.fasterxml.jackson.annotation.JsonIgnore
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
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Long? = null

    @Column(name = "email", unique = true, nullable = false)
    private val email: String? = null

    @Column(name = "password", nullable = false)
    private val password: String? = null

    @Column(name = "first_name", nullable = false)
    private val firstName: String? = null

    @Column(name = "second_name")
    private val secondName: String? = null

    @Column(name = "phone_num", unique = true, length = 14)
    private val phoneNum: String? = null

    @Column(name = "is_active", nullable = false)
    private val isActive: Boolean? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @OneToMany(mappedBy = "user")
    private val userPreferences: Set<UserPreference> = LinkedHashSet()

    @OneToMany(mappedBy = "user")
    private val userSubscriptions: Set<UserSubscription> = LinkedHashSet<UserSubscription>()

    @OneToMany(mappedBy = "userFrom")
    private val userFromMessages: Set<Message> = LinkedHashSet<Message>()

    @OneToMany(mappedBy = "userTo")
    private val userToMessages: Set<Message> = LinkedHashSet<Message>()

    @OneToMany(mappedBy = "user")
    private val items: Set<Item> = LinkedHashSet<Item>()

    @OneToMany(mappedBy = "user")
    private val purchases: Set<Purchase> = LinkedHashSet<Purchase>()

    @OneToMany(mappedBy = "user")
    private val toDoTasks: Set<ToDoTask> = LinkedHashSet()

    @OneToMany(mappedBy = "userCompetitor")
    private val competitorUsers: Set<Competitor> = LinkedHashSet()

    @OneToMany(mappedBy = "userCreator")
    private val userAuthors: Set<Competitor> = LinkedHashSet()

    @OneToMany(mappedBy = "user")
    private val apiKeys: Set<ApiKey> = LinkedHashSet()

    @OneToMany(mappedBy = "user")
    private val tokens: Set<Token> = LinkedHashSet()

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private val role: Role? = null
}
