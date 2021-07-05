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

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDTO create(@RequestBody ReportDTO reportDTO) throws BadFormatException {
        return reportService.create(reportDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReportDTO findById(@PathVariable("id") Long id)  {
        return reportService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
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
