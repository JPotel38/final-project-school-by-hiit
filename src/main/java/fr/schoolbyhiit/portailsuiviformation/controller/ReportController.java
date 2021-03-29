package fr.schoolbyhiit.portailsuiviformation.controller;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportDTO> getReports() {
        return reportService.findAll();
    }

    @PostMapping("/new")
    public @ResponseBody ReportDTO create(@RequestBody ReportDTO reportDTO) throws ReportNotFoundException {
        return reportService.create(reportDTO);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody ReportDTO findById(@PathVariable("id") Long id) throws ReportNotFoundException {
        return reportService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ReportDTO update(@RequestBody ReportDTO reportDTO, @PathVariable Long id) throws ReportNotFoundException {
        return reportService.update(id, reportDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        reportService.delete(id);
    }

}
