package org.vyatsu.localApiModule.mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ToDoTaskDto;
import org.vyatsu.localApiModule.entity.user.ToDoTask;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T20:22:00+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ToDoTaskMapperImpl implements ToDoTaskMapper {

    @Override
    public ToDoTask toEntity(ToDoTaskDto toDoTaskDto) {
        if ( toDoTaskDto == null ) {
            return null;
        }

        ToDoTask.ToDoTaskBuilder toDoTask = ToDoTask.builder();

        toDoTask.id( toDoTaskDto.getId() );
        toDoTask.title( toDoTaskDto.getTitle() );
        toDoTask.description( toDoTaskDto.getDescription() );
        toDoTask.dueDate( toDoTaskDto.getDueDate() );
        toDoTask.isCompleted( toDoTaskDto.getIsCompleted() );
        toDoTask.createdAt( toDoTaskDto.getCreatedAt() );

        return toDoTask.build();
    }

    @Override
    public ToDoTaskDto toDto(ToDoTask toDoTask) {
        if ( toDoTask == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        LocalDate dueDate = null;
        Boolean isCompleted = null;
        LocalDate createdAt = null;

        id = toDoTask.getId();
        title = toDoTask.getTitle();
        description = toDoTask.getDescription();
        dueDate = toDoTask.getDueDate();
        isCompleted = toDoTask.getIsCompleted();
        createdAt = toDoTask.getCreatedAt();

        ToDoTaskDto toDoTaskDto = new ToDoTaskDto( id, title, description, dueDate, isCompleted, createdAt );

        return toDoTaskDto;
    }

    @Override
    public ToDoTask partialUpdate(ToDoTaskDto toDoTaskDto, ToDoTask toDoTask) {
        if ( toDoTaskDto == null ) {
            return toDoTask;
        }

        if ( toDoTaskDto.getId() != null ) {
            toDoTask.setId( toDoTaskDto.getId() );
        }
        if ( toDoTaskDto.getTitle() != null ) {
            toDoTask.setTitle( toDoTaskDto.getTitle() );
        }
        if ( toDoTaskDto.getDescription() != null ) {
            toDoTask.setDescription( toDoTaskDto.getDescription() );
        }
        if ( toDoTaskDto.getDueDate() != null ) {
            toDoTask.setDueDate( toDoTaskDto.getDueDate() );
        }
        if ( toDoTaskDto.getIsCompleted() != null ) {
            toDoTask.setIsCompleted( toDoTaskDto.getIsCompleted() );
        }
        if ( toDoTaskDto.getCreatedAt() != null ) {
            toDoTask.setCreatedAt( toDoTaskDto.getCreatedAt() );
        }

        return toDoTask;
    }
}
