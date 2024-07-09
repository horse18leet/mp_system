package org.vyatsu.localApiModule.entity.purchase;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.item.Item;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "purchase_items")
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "id_purchase", nullable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @OneToMany(mappedBy = "purchaseItem")
    private Set<ContractorPurchaseItem> contractorPurchaseItems = new LinkedHashSet<>();
}
