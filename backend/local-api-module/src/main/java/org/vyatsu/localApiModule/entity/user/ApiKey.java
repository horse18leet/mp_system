package org.vyatsu.localApiModule.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.vyatsu.localApiModule.entity.enums.ApiKeyType;
import org.vyatsu.localApiModule.entity.enums.TokenType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "api_keys")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "key", unique = true, nullable = false)
    private String key;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApiKeyType type = ApiKeyType.WB;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
