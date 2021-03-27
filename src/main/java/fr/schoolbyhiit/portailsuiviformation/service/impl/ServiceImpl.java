package fr.schoolbyhiit.portailsuiviformation.service.impl;

import fr.schoolbyhiit.portailsuiviformation.controller.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import fr.schoolbyhiit.portailsuiviformation.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public Report create(Report newReport) throws ReportNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Report find(Long id) throws ReportNotFoundException {
        return null;
    }

    @Override
    public Report update(Long id, Report updatedReport) throws ReportNotFoundException {
        return null;
    }
}
