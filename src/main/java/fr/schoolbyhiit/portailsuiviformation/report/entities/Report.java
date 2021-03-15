package fr.schoolbyhiit.portailsuiviformation.report.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "T_Report")
public class Report implements Serializable {

    @Id
    @Column(name = "report_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY, generator = "REPORT_SEQUENCE")
    private Long id;

    // Link it to user table
    @Column(name = "report_author")
    private String author;

    @Column(name = "report_date")
    private LocalDate appointment;

    @Column(name = "report_text")
    private String reportText;

    @Column(name = "report_validated")
    private boolean validated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getAppointment() {
        return appointment;
    }

    public void setAppointment(LocalDate appointment) {
        this.appointment = appointment;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", appointment=" + appointment +
                ", reportText='" + reportText + '\'' +
                ", validated=" + validated +
                '}';
    }
}
