package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name="schedule_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "start")
    @NotBlank
    private LocalDateTime start;

    @Column(name = "end")
    @NotBlank
    private LocalDateTime end;

    @Column(name = "all_day")
    @NotBlank
    private Boolean allDay;

    @Column(name = "course_id")
    @NotBlank
    private Long courseId;

}
