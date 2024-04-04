package org.vyatsu.localApiModule.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "key", unique = true, nullable = false)
    private UUID key;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "file_size", nullable = false)
    private Integer fileSize;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
