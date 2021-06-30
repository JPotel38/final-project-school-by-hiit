package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDTO create(@RequestBody ReportDTO reportDTO) throws BadFormatException {
        return reportService.create(reportDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ReportDTO findById(@PathVariable("id") Long id)  {
        return reportService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ReportDTO update(@RequestBody ReportDTO reportDTO, @PathVariable Long id)
        throws ReportNotFoundException, BadFormatException {
        return reportService.update(id, reportDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        reportService.delete(id);
    }

}
