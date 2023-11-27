package org.vyatsu.localApiModule.mapper;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import org.vyatsu.localApiModule.dto.response.api.ToDoTaskDto;
import org.vyatsu.localApiModule.entity.user.ToDoTask;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T23:38:46+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ToDoTaskMapperImpl implements ToDoTaskMapper {

    private final DatatypeFactory datatypeFactory;

    public ToDoTaskMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ToDoTask toEntity(ToDoTaskDto toDoTaskDto) {
        if ( toDoTaskDto == null ) {
            return null;
        }

        ToDoTask.ToDoTaskBuilder toDoTask = ToDoTask.builder();

        toDoTask.id( toDoTaskDto.getId() );
        toDoTask.title( toDoTaskDto.getTitle() );
        toDoTask.description( toDoTaskDto.getDescription() );
        toDoTask.dueDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( toDoTaskDto.getDueDate() ) ) );
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
        LocalDateTime dueDate = null;
        Boolean isCompleted = null;
        LocalDateTime createdAt = null;

        id = toDoTask.getId();
        title = toDoTask.getTitle();
        description = toDoTask.getDescription();
        dueDate = xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( toDoTask.getDueDate() ) );
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
            toDoTask.setDueDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( toDoTaskDto.getDueDate() ) ) );
        }
        if ( toDoTaskDto.getIsCompleted() != null ) {
            toDoTask.setIsCompleted( toDoTaskDto.getIsCompleted() );
        }
        if ( toDoTaskDto.getCreatedAt() != null ) {
            toDoTask.setCreatedAt( toDoTaskDto.getCreatedAt() );
        }

        return toDoTask;
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }
}
