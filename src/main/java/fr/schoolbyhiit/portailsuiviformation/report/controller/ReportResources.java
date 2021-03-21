package fr.schoolbyhiit.portailsuiviformation.report.controller;

import fr.schoolbyhiit.portailsuiviformation.report.entities.ReportDAO;
import fr.schoolbyhiit.portailsuiviformation.report.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportResources {

    @Autowired
    private IService service;

    @GetMapping
    List<ReportDAO> all() {
        return service.findAll();
    }

    @PostMapping
    ReportDAO newReport(@RequestBody ReportDAO newReportDAO) throws ReportNotFoundException {
        return service.create(newReportDAO);
    }

    @GetMapping(value = "/{id}")
    ReportDAO one(@PathVariable("id") Long id) throws ReportNotFoundException {
        return (ReportDAO) service.find(id);
    }

    @PutMapping(value = "/{id}")
    ReportDAO updateReport(@RequestBody ReportDAO newReportDAO, @PathVariable Long id) throws ReportNotFoundException {
      ReportDAO updatedReportDAO = service.find(id);
        updatedReportDAO.setAuthor(newReportDAO.getAuthor());
        updatedReportDAO.setAppointment(newReportDAO.getAppointment());
        updatedReportDAO.setReportText(newReportDAO.getReportText());
        updatedReportDAO.setValidated(newReportDAO.isValidated());
        return updatedReportDAO;
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }

}
