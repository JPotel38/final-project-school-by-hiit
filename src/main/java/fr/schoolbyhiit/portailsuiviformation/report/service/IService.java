package fr.schoolbyhiit.portailsuiviformation.report.service;

import fr.schoolbyhiit.portailsuiviformation.report.controller.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.report.entities.ReportDAO;

import java.util.List;

public interface IService {

    List<ReportDAO> findAll();

    ReportDAO create(ReportDAO newReportDAO) throws ReportNotFoundException;

    void delete(Long id);

    ReportDAO find(Long id) throws ReportNotFoundException;

    ReportDAO update(Long id, ReportDAO updatedReportDAO) throws ReportNotFoundException;

}
