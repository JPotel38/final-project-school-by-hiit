package fr.schoolbyhiit.portailsuiviformation.report.services;

import fr.schoolbyhiit.portailsuiviformation.report.controller.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.report.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReportDAO{

    List<Report> findAll();

    Report create(Report newReport) throws ReportNotFoundException;

    void delete(Long id);

    Report find(Long id) throws ReportNotFoundException;

    Report update(Long id, Report report) throws ReportNotFoundException;

}
