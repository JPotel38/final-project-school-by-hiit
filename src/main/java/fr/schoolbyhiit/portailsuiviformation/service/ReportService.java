package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAll();

    Report create(Report newReport) throws ReportNotFoundException;

    void delete(Long id);

    Report find(Long id) throws ReportNotFoundException;

    Report update(Long id, Report updatedReport) throws ReportNotFoundException;

}
