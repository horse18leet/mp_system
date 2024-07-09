package org.vyatsu.localApiModule.entity.contractor;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ContractorType;
<<<<<<< Updated upstream
=======
import org.vyatsu.localApiModule.entity.purchase.ContractorPurchaseItem;
>>>>>>> Stashed changes
import org.vyatsu.localApiModule.entity.user.User;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "contractors")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "phone_num", unique = true, nullable = false)
    private String phoneNum;

<<<<<<< Updated upstream
    @Column(name = "actual_address", unique = true, nullable = false)
=======
    @Column(name = "actual_address", nullable = false)
>>>>>>> Stashed changes
    private String actualAddress;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_hidden", nullable = false)
    private Boolean isHidden = true;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

    @OneToMany(mappedBy = "contractor")
    private Set<ContractorPurchaseItem> contractorPurchaseItems = new LinkedHashSet<>();
}
