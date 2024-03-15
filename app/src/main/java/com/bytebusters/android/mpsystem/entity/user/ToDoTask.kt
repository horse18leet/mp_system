package com.bytebusters.android.mpsystem.entity.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDate
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@Table(name = "todo_tasks")
class ToDoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private val id: Long? = null

    @Column(name = "title", nullable = false)
    private val title: String? = null

    @Column(name = "description", nullable = false, length = 500)
    private val description: String? = null

    @Column(name = "due_date")
    private val dueDate: LocalDate? = null

    @Column(name = "is_completed", nullable = false)
    private val isCompleted: Boolean? = null

    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL")
    private val createdAt: LocalDateTime? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private val user: User? = null
}
