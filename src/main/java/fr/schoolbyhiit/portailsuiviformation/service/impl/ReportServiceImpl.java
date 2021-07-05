package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.dao.ReportRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.exception.BadFormatException;
import fr.schoolbyhiit.portailsuiviformation.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.mapper.ReportMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportMapper reportMapper, ReportRepository reportRepository) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
    }

    @Override
    public List<ReportDTO> findAll() {
        return reportMapper.toReportDtoList(reportRepository.findAll());
    }

    @Override
    public ReportDTO create(ReportDTO reportDTO) {
        if (reportDTO.getUser() == null || reportDTO.getReportText() == null || reportDTO.getAppointmentDate() == null) {
            throw new BadFormatException("All fields are mandatory");
        }
        Report report = reportMapper.toReport(reportDTO);
        return reportMapper.toReportDto(reportRepository.save(report));
    }

    @Override
    public void delete(Long id) {
        // on contrôle si le rapport existe en base
        ReportDTO reportDTO = reportMapper.toReportDto(reportRepository.findById(id)
            .orElseThrow(ReportNotFoundException::new));
        reportRepository.deleteById(id);
    }

    @Override
    public ReportDTO findById(Long id) {
        return reportMapper.toReportDto(reportRepository.findById(id)
            .orElseThrow(ReportNotFoundException::new));
    }

    @Override
    public ReportDTO update(Long id, ReportDTO reportDTO) throws BadFormatException {
        if (id == null || reportDTO.getUser() == null || reportDTO.getReportText() == null || reportDTO.getAppointmentDate() == null) {
            throw new BadFormatException("All fields are mandatory");
        }

        final Report report = reportRepository.findById(id).orElseThrow(ReportNotFoundException::new);
        report.setUser(reportDTO.getUser());
        report.setValidated(reportDTO.getValidated());
        report.setAppointmentDate(reportDTO.getAppointmentDate());
        report.setReportText(reportDTO.getReportText());
        return reportMapper.toReportDto(reportRepository.save(report));
    }
}
