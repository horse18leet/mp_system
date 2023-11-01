package org.vyatsu.localApiModule.entity.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "wallet_transactions")
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "type")
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "impl_date")
    private LocalDateTime implDate;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_wallet", nullable = false)
    private Wallet wallet;
}
