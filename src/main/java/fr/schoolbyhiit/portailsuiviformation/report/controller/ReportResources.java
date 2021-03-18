package fr.schoolbyhiit.portailsuiviformation.report.controller;

import fr.schoolbyhiit.portailsuiviformation.report.entities.Report;
import fr.schoolbyhiit.portailsuiviformation.report.services.ReportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportResources {

    @Autowired
    private ReportDAO reportDAO;

    @GetMapping
    List<Report> all() {
        return reportDAO.findAll();
    }

    @PostMapping
    Report newReport(@RequestBody Report newReport) throws ReportNotFoundException {
        return reportDAO.create(newReport);
    }

    @GetMapping(value = "/{id}")
    Report one(@PathVariable("id") Long id) throws ReportNotFoundException {
        return (Report) reportDAO.find(id);
    }

    @PutMapping(value = "/{id}")
    Report updateReport(@RequestBody Report newReport, @PathVariable Long id) throws ReportNotFoundException {
      Report updatedReport = reportDAO.find(id);
        updatedReport.setAuthor(newReport.getAuthor());
        updatedReport.setAppointment(newReport.getAppointment());
        updatedReport.setReportText(newReport.getReportText());
        updatedReport.setValidated(newReport.isValidated());
        return updatedReport;
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        reportDAO.delete(id);
    }

}
