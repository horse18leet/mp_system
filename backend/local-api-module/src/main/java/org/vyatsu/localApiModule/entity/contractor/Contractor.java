package org.vyatsu.localApiModule.entity.contractor;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ContractorType;
import org.vyatsu.localApiModule.entity.enums.NotifyType;
import org.vyatsu.localApiModule.entity.user.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "contractors")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractorType type;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "actual_address", unique = true, nullable = false)
    private String actualAddress;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

}
