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
@Table(name = "price_history")
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "old_price", nullable = false)
    private double oldPrice;

    @Column(name = "new_price", nullable = false)
    private double newPrice;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
}
