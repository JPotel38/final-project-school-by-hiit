package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IService service;

    @GetMapping
    List<Report> all() {
        return service.findAll();
    }

    @PostMapping
    Report newReport(@RequestBody Report newReport) throws ReportNotFoundException {
        return service.create(newReport);
    }

    @GetMapping(value = "/{id}")
    Report one(@PathVariable("id") Long id) throws ReportNotFoundException {
        return (Report) service.find(id);
    }

    @PutMapping(value = "/{id}")
    Report updateReport(@RequestBody Report newReport, @PathVariable Long id) throws ReportNotFoundException {
      Report updatedReport = service.find(id);
        updatedReport.setAuthor(newReport.getAuthor());
        updatedReport.setAppointment(newReport.getAppointment());
        updatedReport.setReportText(newReport.getReportText());
        updatedReport.setValidated(newReport.isValidated());
        return updatedReport;
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }

}
