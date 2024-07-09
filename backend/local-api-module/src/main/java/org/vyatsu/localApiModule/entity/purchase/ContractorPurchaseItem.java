package org.vyatsu.localApiModule.entity.purchase;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.contractor.Contractor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "contractor_purchase_item")
public class ContractorPurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_purchase_item", nullable = false)
    private PurchaseItem purchaseItem;

    @ManyToOne
    @JoinColumn(name = "id_contractor", nullable = false)
    private Contractor contractor;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "deadline", nullable = false)
    private LocalDateTime deadline;
}
