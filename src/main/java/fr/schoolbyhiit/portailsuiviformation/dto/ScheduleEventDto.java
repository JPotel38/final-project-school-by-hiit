package fr.schoolbyhiit.portailsuiviformation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEventDto {

    private Long id;

    private String title;

    private LocalDateTime start;

    private LocalDateTime end;

    private Boolean allDay;

    private Long courseId;

}
