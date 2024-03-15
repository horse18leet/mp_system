package org.vyatsu.localApiModule.entity.contractor;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "payment_num", nullable = false)
    private String paymentNum;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "wallet")
    private Set<Contractor> contractors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "wallet")
    private Set<WalletTransaction> walletTransactions = new LinkedHashSet<>();
}
