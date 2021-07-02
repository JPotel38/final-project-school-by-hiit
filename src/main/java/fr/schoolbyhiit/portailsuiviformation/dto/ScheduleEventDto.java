package fr.schoolbyhiit.portailsuiviformation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEventDto {

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private LocalDateTime start;

    private LocalDateTime end;

    @NotNull
    private Boolean allDay;

    private Long courseId;

}
