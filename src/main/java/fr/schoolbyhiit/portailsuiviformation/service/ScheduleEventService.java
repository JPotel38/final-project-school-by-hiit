package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;

import java.util.List;

public interface ScheduleEventService {

    List<ScheduleEventDto> findAll();
}
