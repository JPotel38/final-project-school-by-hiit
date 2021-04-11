package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.exception.WrongFormatTypeException;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController extends ReportNotFoundException{

    private ReportService reportService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDTO create(@RequestBody ReportDTO reportDTO) throws ReportNotFoundException, WrongFormatTypeException {
        return reportService.create(reportDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.FOUND)
    public ReportDTO findById(@PathVariable("id") Long id) throws ReportNotFoundException {
        return reportService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReportDTO update(@RequestBody ReportDTO reportDTO, @PathVariable Long id)
        throws ReportNotFoundException, WrongFormatTypeException {
        return reportService.update(id, reportDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        reportService.delete(id);
    }

}
