package org.vyatsu.localApiModule.entity.contractor;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ContractorType;
import org.vyatsu.localApiModule.entity.enums.WalletTransactionType;
import org.vyatsu.localApiModule.entity.item.Item;
import org.vyatsu.localApiModule.entity.user.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "wallet_transactions")
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "impl_date")
    private LocalDateTime implDate;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private WalletTransactionType type;

    @ManyToOne
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
}
