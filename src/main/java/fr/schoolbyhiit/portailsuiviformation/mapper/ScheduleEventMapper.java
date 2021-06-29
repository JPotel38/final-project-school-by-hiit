package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;
import fr.schoolbyhiit.portailsuiviformation.entity.ScheduleEvent;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleEventMapper {

    ScheduleEvent toEntity(ScheduleEventDto scheduleEventDto);

    ScheduleEventDto toDto(ScheduleEvent scheduleEvent);

    List<ScheduleEventDto> toDtoList(List<ScheduleEvent> scheduleEventList);

}
