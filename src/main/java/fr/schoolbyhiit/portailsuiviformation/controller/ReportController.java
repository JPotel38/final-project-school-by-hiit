package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping("/post")
    public @ResponseBody
    ResponseEntity<String> post(@RequestBody ReportDTO reportDTO) throws BadFormatException {
        reportService.create(reportDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReportDTO findById(@PathVariable("id") Long id) {
        return reportService.findById(id);
    }

    @PutMapping(value = "/put/{id}")
    public @ResponseBody
    ResponseEntity<String> put(@PathVariable Long id, @RequestBody ReportDTO reportDTO) {
        reportService.update(id, reportDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        reportService.delete(id);
    }

}
