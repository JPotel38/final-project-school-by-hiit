package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
