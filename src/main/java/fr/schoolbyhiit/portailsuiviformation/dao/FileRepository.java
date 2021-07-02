package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import fr.schoolbyhiit.portailsuiviformation.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {

    List<File> getFilesByCourse(Course course);
}
