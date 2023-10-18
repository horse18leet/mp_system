package org.vyatsu.localApiModule.entity.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "balance", nullable = false)
    private double balance;

    @OneToMany(mappedBy = "wallet")
    private Set<WalletTransaction> walletTransactions = new LinkedHashSet<>();
}
