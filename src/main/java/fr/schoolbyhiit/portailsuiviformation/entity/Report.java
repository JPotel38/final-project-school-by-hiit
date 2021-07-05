package fr.schoolbyhiit.portailsuiviformation.entity;

import fr.schoolbyhiit.portailsuiviformation.model.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "REPORT_SEQUENCE")
    private Long id;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "tutor_id")
    private Long tutorId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "appointment_date")
    @DateTimeFormat
    private ZonedDateTime appointmentDate;

    @Column(name = "report_text")
    @NotEmpty
    private String reportText;

    @Enumerated(EnumType.STRING)
    @Column(name = "validated", unique = true)
    private ReportStatus validated;
}
