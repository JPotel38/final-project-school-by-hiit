package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ScheduleEventRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ScheduleEventDto;
import fr.schoolbyhiit.portailsuiviformation.mapper.ScheduleEventMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ScheduleEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleEventServiceImpl implements ScheduleEventService {

    private final ScheduleEventMapper scheduleEventMapper;
    private final ScheduleEventRepository scheduleEventRepository;

    public ScheduleEventServiceImpl(ScheduleEventMapper scheduleEventMapper, ScheduleEventRepository scheduleEventRepository) {
        this.scheduleEventMapper = scheduleEventMapper;
        this.scheduleEventRepository = scheduleEventRepository;
    }

    @Override
    public List<ScheduleEventDto> findAll() {
        return scheduleEventMapper.toDtoList(scheduleEventRepository.findAll());
    }

    public void create(ScheduleEventDto scheduleEventDto) {

    }


}
