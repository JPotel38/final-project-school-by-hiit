package fr.schoolbyhiit.portailsuiviformation.entity;

import fr.schoolbyhiit.portailsuiviformation.model.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report implements Serializable {

    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "REPORT_SEQUENCE")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "date")
    @DateTimeFormat
    private LocalDate appointmentDate;

    @Column(name = "text")
    @NotEmpty
    private String reportText;

    @Enumerated(EnumType.STRING)
    @Column(name = "validated", unique = true)
    private ReportStatus validated;
}
