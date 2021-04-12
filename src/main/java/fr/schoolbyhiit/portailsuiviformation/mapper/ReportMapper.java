package fr.schoolbyhiit.portailsuiviformation.mapper;

import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportDTO toReportDto(Report report);

    Report toReport(ReportDTO reportDto);

    List<ReportDTO> toReportDtoList(List<Report> reports);
}
