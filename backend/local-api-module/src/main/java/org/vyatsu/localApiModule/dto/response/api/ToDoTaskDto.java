package org.vyatsu.localApiModule.dto.response.api;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.vyatsu.localApiModule.entity.user.ToDoTask}
 */
@Value
public class ToDoTaskDto implements Serializable {
    Long id;
    String title;
    String description;
    LocalDate dueDate;
    Boolean isCompleted;
    LocalDate createdAt;
}