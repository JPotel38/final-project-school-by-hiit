package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course getCourseByDesignation(String designation);

    Course getCourseByDesignationAndDate(String designation, LocalDate date);

}
