package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;

import java.util.List;

public interface ScheduleEventService {

    List<ScheduleEventDto> findAll();

    ScheduleEventDto create(ScheduleEventDto scheduleEventDto);

    ScheduleEventDto update(Long id, ScheduleEventDto scheduleEventDto);

    void delete(Long id);
}
