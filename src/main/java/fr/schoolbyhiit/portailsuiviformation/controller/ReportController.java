package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping
    public @ResponseBody List<Report> all() {
        return service.findAll();
    }

    @PostMapping("/new")
    public @ResponseBody Report newReport(@RequestBody Report newReport) throws ReportNotFoundException {
        return service.create(newReport);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Report one(@PathVariable("id") Long id) throws ReportNotFoundException {
        return service.find(id);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody Report updateReport(@RequestBody Report newReport, @PathVariable Long id) throws ReportNotFoundException {
        return service.update(id, newReport);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }

}
