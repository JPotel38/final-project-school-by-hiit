package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {

    File getFilesByCreationDate(LocalDate creationDate);
    File getFileByDesignation(String designation);
    File getFileByCreationDate(LocalDate creationDate);
}
