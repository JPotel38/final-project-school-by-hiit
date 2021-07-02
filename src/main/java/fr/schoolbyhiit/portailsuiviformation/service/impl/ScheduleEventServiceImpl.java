package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ScheduleEventRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;
import fr.schoolbyhiit.portailsuiviformation.entity.ScheduleEvent;
import fr.schoolbyhiit.portailsuiviformation.mapper.ScheduleEventMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ScheduleEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleEventServiceImpl implements ScheduleEventService {

    private final ScheduleEventMapper scheduleEventMapper;
    private final ScheduleEventRepository scheduleEventRepository;

    @Override
    public List<ScheduleEventDto> findAll() {
        List<ScheduleEvent> eventList = scheduleEventRepository.findAll()
            .stream()
            .peek((event) -> {
                if (event.getEnd()==null) {
                   event.setEnd(event.getStart().plusHours(1L));
                }
            })
            .collect(Collectors.toList());
        return scheduleEventMapper.toDtoList(eventList);
    }

    @Override
    public ScheduleEventDto create(ScheduleEventDto scheduleEventDto) {
        return scheduleEventMapper.toDto(
            scheduleEventRepository.save(scheduleEventMapper.toEntity(scheduleEventDto))
        );
    }

    @Override
    public ScheduleEventDto update(Long id, ScheduleEventDto scheduleEventDto){
        ScheduleEvent scheduleEvent = scheduleEventRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        scheduleEvent.setStart(scheduleEventDto.getStart());
        scheduleEvent.setEnd(scheduleEventDto.getEnd());
        scheduleEvent.setAllDay(scheduleEventDto.getAllDay());
        scheduleEvent.setCourseId(scheduleEventDto.getCourseId());
        scheduleEvent.setTitle(scheduleEventDto.getTitle());

        return scheduleEventMapper.toDto(scheduleEventRepository.save(scheduleEvent));
    }

    @Override
    public void delete(Long id){
        scheduleEventRepository.deleteById(id);
    }


}
