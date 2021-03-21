package fr.schoolbyhiit.portailsuiviformation.report.service;

import fr.schoolbyhiit.portailsuiviformation.report.controller.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.report.entities.ReportDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService{
    @Override
    public List<ReportDAO> findAll() {
        return null;
    }

    @Override
    public ReportDAO create(ReportDAO newReportDAO) throws ReportNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ReportDAO find(Long id) throws ReportNotFoundException {
        return null;
    }

    @Override
    public ReportDAO update(Long id, ReportDAO updatedReportDAO) throws ReportNotFoundException {
        return null;
    }
}
