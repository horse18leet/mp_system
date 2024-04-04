package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.ToDoTask}
 */
@Value
public class ToDoTaskDto implements Serializable {
    Long id;
    String title;
    String description;
    LocalDateTime dueDate;
    Boolean isCompleted;
    LocalDateTime createdAt;
}