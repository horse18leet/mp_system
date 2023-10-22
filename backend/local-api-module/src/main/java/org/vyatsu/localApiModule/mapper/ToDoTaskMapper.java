package org.vyatsu.localApiModule.mapper;

import org.mapstruct.*;
import org.vyatsu.localApiModule.dto.response.api.ToDoTaskDto;
import org.vyatsu.localApiModule.entity.user.ToDoTask;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ToDoTaskMapper {
    ToDoTask toEntity(ToDoTaskDto toDoTaskDto);

    ToDoTaskDto toDto(ToDoTask toDoTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ToDoTask partialUpdate(ToDoTaskDto toDoTaskDto, @MappingTarget ToDoTask toDoTask);
}