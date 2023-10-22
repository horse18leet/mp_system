package org.vyatsu.localApiModule.entity.purchase;

import org.vyatsu.localApiModule.entity.item.Item;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "estimation")
    private int estimation;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "id_cost", nullable = false)
    private Cost cost;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;
}
