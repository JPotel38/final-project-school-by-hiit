package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;
import fr.schoolbyhiit.portailsuiviformation.service.ScheduleEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/events/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ScheduleEventController {

    private final ScheduleEventService scheduleEventService;

    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduleEventDto> getEvents() {
        return scheduleEventService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleEventDto create(@RequestBody @Valid ScheduleEventDto scheduleEventDto) {
        return scheduleEventService.create(scheduleEventDto);
    }

    @PutMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleEventDto update(@PathVariable("id") Long id, @RequestBody @Valid ScheduleEventDto scheduleEventDto){
        return scheduleEventService.update(id, scheduleEventDto);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        scheduleEventService.delete(id);
    }

}
