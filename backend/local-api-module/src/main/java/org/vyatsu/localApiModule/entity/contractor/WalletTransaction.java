package org.vyatsu.localApiModule.entity.contractor;

import jakarta.persistence.*;
import lombok.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "impl_date")
    private LocalDateTime implDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
}
