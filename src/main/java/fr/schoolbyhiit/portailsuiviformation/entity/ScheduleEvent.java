package fr.schoolbyhiit.portailsuiviformation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private LocalDateTime start;

    @Column(name = "end")
    private LocalDateTime end;

    @Column(name = "all_day")
    @NotNull
    private Boolean allDay;

    @Column(name = "course_id")
    private Long courseId;

}
