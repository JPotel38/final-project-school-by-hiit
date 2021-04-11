package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.exception.WrongFormatTypeException;
import fr.schoolbyhiit.portailsuiviformation.dao.ReportRepository;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.model.ReportStatus;
import fr.schoolbyhiit.portailsuiviformation.mapper.ReportMapper;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public ReportDTO create(ReportDTO reportDTO) throws WrongFormatTypeException {
        if (reportDTO.getUser() == null || reportDTO.getReportText() == null || reportDTO.getAppointmentDate() == null
            || reportDTO.getAppointmentDate() == null) {
            throw new WrongFormatTypeException("All fields are mandatory");
        }
        if(!(reportDTO.getUser() instanceof User)){
            throw new WrongFormatTypeException("Updated user must be a User Type");
        }
        if(!(reportDTO.getValidated() instanceof ReportStatus)){
            throw new WrongFormatTypeException("Updated report status must be either 'Validated' or 'Not validated'");
        }
        if(!(reportDTO.getAppointmentDate() instanceof LocalDate)){
            throw new WrongFormatTypeException(" Updated appointment date must be a valid Date Format : YYYY-MM-DD");
        }
        if(!(reportDTO.getReportText() instanceof String)){
            throw new WrongFormatTypeException("Updated Report Text must be a String");
        }
        Report report = reportMapper.toReport(reportDTO);
        return reportMapper.toReportDto(reportRepository.save(report));
    }

    @Override
    public void delete(Long id) throws ReportNotFoundException {
      reportRepository.deleteById(id);
    }

    @Override
    public ReportDTO findById(Long id) {
        ReportDTO reportDTO = reportMapper.toReportDto(reportRepository.findById(id)
            .orElseThrow(() -> new ReportNotFoundException()));
            return reportDTO;
    }

    @Override
    public ReportDTO update(Long id, ReportDTO reportDTO) throws ReportNotFoundException, WrongFormatTypeException {
        if (id == null) {
            throw new ReportNotFoundException();
        }
        if (reportDTO.getUser() == null || reportDTO.getReportText() == null || reportDTO.getAppointmentDate() == null
            || reportDTO.getAppointmentDate() == null) {
            throw new WrongFormatTypeException("All fields are mandatory");
        }
        if(!(reportDTO.getUser() instanceof User)){
            throw new WrongFormatTypeException("Updated user must be a User Type");
        }
        if(!(reportDTO.getValidated() instanceof ReportStatus)){
            throw new WrongFormatTypeException("Updated report status must be either 'Validated' or 'Not validated'");
        }
        if(!(reportDTO.getAppointmentDate() instanceof LocalDate)){
            throw new WrongFormatTypeException(" Updated appointment date must be a valid Date Format : YYYY-MM-DD");
        }
        if(!(reportDTO.getReportText() instanceof String)){
            throw new WrongFormatTypeException("Updated Report Text must be a String");
        }
        Report report = reportMapper.toReport(reportDTO);
        report.setUser(reportDTO.getUser());
        report.setValidated(reportDTO.getValidated());
        report.setAppointmentDate(reportDTO.getAppointmentDate());
        report.setReportText(reportDTO.getReportText());
        return reportMapper.toReportDto(reportRepository.save(report));
    }
}
