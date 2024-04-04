package org.vyatsu.localApiModule.entity.item;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.contractor.Contractor;
import org.vyatsu.localApiModule.entity.contractor.WalletTransaction;
import org.vyatsu.localApiModule.entity.purchase.Ad;
import org.vyatsu.localApiModule.entity.purchase.PurchaseItem;
import org.vyatsu.localApiModule.entity.user.User;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "first_price")
    private Double firstPrice;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "category")
    private String category;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "is_draft", nullable = false)
    private Boolean isDraft;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "item")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "item")
    private Set<PriceHistory> priceHistory = new LinkedHashSet<>();

    @OneToMany(mappedBy = "item")
    private Set<Ad> ads = new LinkedHashSet<>();

    @OneToMany(mappedBy = "item")
    private Set<PurchaseItem> purchaseItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "item")
    private Set<WalletTransaction> walletTransactions = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "contractor_item",
            joinColumns = @JoinColumn(name = "item_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "contractor_id", nullable = false)
    )
    private Set<Contractor> contractors;
}
