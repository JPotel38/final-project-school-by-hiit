package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;
import fr.schoolbyhiit.portailsuiviformation.service.ScheduleEventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/events")
public class ScheduleEventController {

    private final ScheduleEventService scheduleEventService;

    public ScheduleEventController(ScheduleEventService scheduleEventService) {
        this.scheduleEventService = scheduleEventService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduleEventDto> getEvents() {
        return scheduleEventService.findAll();
    }

}
