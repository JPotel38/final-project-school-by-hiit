package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;

import java.util.List;

public interface ReportService {

    List<ReportDTO> findAll();

    ReportDTO create(ReportDTO reportDTO) throws ReportNotFoundException;

    void delete(Long id);

    ReportDTO findById(Long id) throws ReportNotFoundException;

    ReportDTO update(Long id, ReportDTO reportDTO) throws ReportNotFoundException;

}
