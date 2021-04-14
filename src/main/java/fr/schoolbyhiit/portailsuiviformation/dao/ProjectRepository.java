package fr.schoolbyhiit.portailsuiviformation.dao;

import fr.schoolbyhiit.portailsuiviformation.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
