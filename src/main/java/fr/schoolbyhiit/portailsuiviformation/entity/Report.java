package fr.schoolbyhiit.portailsuiviformation.entity;

import fr.schoolbyhiit.portailsuiviformation.entity.model.ReportStatus;
import fr.schoolbyhiit.portailsuiviformation.entity.model.RoleName;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report implements Serializable {

    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "REPORT_SEQUENCE")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false,unique=true)
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
