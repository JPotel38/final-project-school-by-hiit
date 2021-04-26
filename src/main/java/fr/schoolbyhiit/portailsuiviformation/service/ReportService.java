package fr.schoolbyhiit.portailsuiviformation.service;

import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;

import java.util.List;

public interface ReportService {

    List<ReportDTO> findAll();

    ReportDTO create(ReportDTO reportDTO);

    void delete(Long id);

    ReportDTO findById(Long id);

    ReportDTO update(Long id, ReportDTO reportDTO);

}
