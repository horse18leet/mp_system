package org.vyatsu.localApiModule.entity.sub;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "subscription")
    private Set<UserSubscription> userSubscriptions = new LinkedHashSet<>();
}
