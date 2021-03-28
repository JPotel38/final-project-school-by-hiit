package fr.schoolbyhiit.portailsuiviformation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {

    Module getModuleByDesignation(String designation);
}
