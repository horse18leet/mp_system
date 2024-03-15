package org.vyatsu.localApiModule.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.contractor.Contractor;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.msg.Message;
import org.vyatsu.localApiModule.entity.purchase.Purchase;
import org.vyatsu.localApiModule.entity.role.Role;
import org.vyatsu.localApiModule.entity.sub.UserSubscription;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "phone_num", unique = true, length = 14)
    private String phoneNum;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private Set<UserPreference> userPreferences = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserSubscription> userSubscriptions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userFrom")
    private Set<Message> userFromMessages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userTo")
    private Set<Message> userToMessages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Item> items = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ToDoTask> toDoTasks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userCompetitor")
    private Set<Competitor> competitorUsers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userCreator")
    private Set<Competitor> userAuthors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ApiKey> apiKeys = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Token> tokens = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Contractor> contractors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<WalletTransaction> walletTransactions = new LinkedHashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
