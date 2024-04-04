package org.vyatsu.localApiModule.entity.item;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
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

    @Column(name = "taked_at", columnDefinition = "TIMESTAMP NOT NULL", nullable = false)
    private LocalDateTime takedAt;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
}
