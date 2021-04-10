package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.controller.exception.WrongFormatTypeException;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class ReportController extends ReportNotFoundException{

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDTO create(@RequestBody ReportDTO reportDTO) throws ReportNotFoundException, WrongFormatTypeException {
        return reportService.create(reportDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
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
