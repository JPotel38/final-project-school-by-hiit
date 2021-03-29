package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.dao.ReportRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.mapper.ReportMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;

    @Override
    public List<ReportDTO> findAll() {
        return reportMapper.toReportDtoList(reportRepository.findAll());
    }

    @Override
    public ReportDTO create(ReportDTO reportDTO) throws ReportNotFoundException {
        Report report = reportMapper.toReport(reportDTO);
        return reportMapper.toReportDto(reportRepository.save(report));
    }

    @Override
    public void delete(Long id) {
      reportRepository.deleteById(id);
    }

    @Override
    public ReportDTO findById(Long id) throws ReportNotFoundException {
        ReportDTO reportDTO = reportMapper.toReportDto(reportRepository.findById(id)
            .orElseThrow(() -> ReportNotFoundException.INSTANCE));
            return reportDTO;
    }

    @Override
    public ReportDTO update(Long id, ReportDTO reportDTO) throws ReportNotFoundException {
        Report report = reportMapper.toReport(reportDTO);
        report.setUser(reportDTO.getUser());
        report.setValidated(reportDTO.getValidated());
        report.setAppointmentDate(reportDTO.getAppointmentDate());
        report.setReportText(reportDTO.getReportText());
        return reportMapper.toReportDto(reportRepository.save(report));
    }
}
