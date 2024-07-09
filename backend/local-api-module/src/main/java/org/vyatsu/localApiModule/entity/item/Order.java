package org.vyatsu.localApiModule.entity.item;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "srid", nullable = false)
    private String srid;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "is_cancel")
    private Boolean isCancel;

    @Column(name = "is_refund", nullable = false)
    private Boolean isRefund;

    @Column(name = "taked_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime takedAt;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
}
